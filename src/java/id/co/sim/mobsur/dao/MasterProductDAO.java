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
 * @created Jan 5, 2017
 * @author awal
 */
@Repository("masterProductDAO")
public class MasterProductDAO extends BaseDAO<MasterProduct> {

  public List<MasterProduct> getByRangeCoy(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " prod " +
              "where prod.template.company.coyId = :coyId")
            .setInteger("coyId",coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

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

  public int countByCoy(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " prod " +
              "where prod.template.company.coyId = :coyId")
            .setInteger("coyId",coyId)
            .iterate().next()).intValue();
  }

  public int countByCoyAndName(int coyId, String productNamePattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " prod " +
              "where prod.template.company.coyId = :coyId " +
              "and UPPER(prod.productName) like UPPER(:productNamePattern)")
            .setInteger("coyId",coyId)
            .setString("productNamePattern", "%"+productNamePattern+"%")
            .iterate().next()).intValue();
  }
}
