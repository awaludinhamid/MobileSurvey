/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterProduct;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_PRODUCT
 * extends BaseDAO class
 * @see BaseDAO
 * @created Jan 5, 2017
 * @author awal
 */
@Repository("masterProductDAO")
public class MasterProductDAO extends BaseDAO<MasterProduct> {

  /**
   * Get product data by range and company
   * @param coyId, company
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of products based on given range and company
   */
  public List<MasterProduct> getByRangeCoy(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " prod " +
              "where prod.template.company.coyId = :coyId " +
                "and prod.startDate <= current_date " +
                "and prod.endDate >= current_date")
            .setInteger("coyId",coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get product data by range, company and product name pattern/partial
   * @param coyId, company
   * @param productNamePattern
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of products based on given range, company and product name pattern
   */
  public List<MasterProduct> getByRangeCoyAndName(int coyId, String productNamePattern, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " prod " +
              "where prod.template.company.coyId = :coyId " +
              "and UPPER(prod.productName) like UPPER(:productNamePattern)")
            .setInteger("coyId",coyId)
            .setString("productNamePattern", "%"+productNamePattern+"%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get number of product data by company
   * @param coyId, company
   * @return count of products based on given company
   */
  public int countByCoy(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " prod " +
              "where prod.template.company.coyId = :coyId " +
                "and prod.startDate <= current_date " +
                "and prod.endDate >= current_date")
            .setInteger("coyId",coyId)
            .iterate().next()).intValue();
  }

  /**
   * Get number of product data by company and product name pattern
   * @param coyId, company
   * @param productNamePattern
   * @return count of products based on given company and product name pattern
   */
  public int countByCoyAndName(int coyId, String productNamePattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " prod " +
              "where prod.template.company.coyId = :coyId " +
                "and UPPER(prod.productName) like UPPER(:productNamePattern)")
            .setInteger("coyId",coyId)
            .setString("productNamePattern", "%"+productNamePattern+"%")
            .iterate().next()).intValue();
  }
  
  /**
   * Get number of product data by template
   * @param tempId, template
   * @return count of products based on given template
   */
  public int countByTemplate(int tempId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " prod " +
              "where prod.template.tempId = :tempId")
            .setInteger("tempId", tempId)
            .iterate().next()).intValue();
  }
}
