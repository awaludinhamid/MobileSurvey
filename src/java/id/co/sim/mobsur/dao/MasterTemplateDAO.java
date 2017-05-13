/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterTemplate;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_TEMPLATE
 * extends BaseDAO class
 * @see BaseDAO
 * @created Jan 15, 2017
 * @author awal
 */
@Repository("masterTemplateDAO")
public class MasterTemplateDAO extends BaseDAO<MasterTemplate> {

  /**
   * Get template data by range and company
   * @param coyId, company
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of templates based on given range and company
   */
  public List<MasterTemplate> getByRangeCoy(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " tmp " +
              "where tmp.company.coyId = :coyId " +
                "and tmp.startDate <= current_date " +
                "and tmp.endDate >= current_date")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get template data by range, company and label pattern/partial
   * @param coyId, company
   * @param tempLabelPattern
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of templates based on given range, company and label pattern
   */
  public List<MasterTemplate> getByRangeCoyAndLabel(int coyId, String tempLabelPattern, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " tmp " +
              "where UPPER(tmp.tempLabel) like UPPER(:tempLabelPattern) " +
                "and tmp.company.coyId = :coyId")
            .setString("tempLabelPattern", "%"+tempLabelPattern+"%")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get number of template data by company
   * @param coyId, company
   * @return count of templates based on given company
   */
  public int countByCoy(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " tmp " +
              "where tmp.company.coyId = :coyId " +
                "and tmp.startDate <= current_date " +
                "and tmp.endDate >= current_date")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }

  /**
   * Get number of template data by company and label pattern
   * @param coyId, company
   * @param tempLabelPattern
   * @return count of templates based on given company and label pattern
   */
  public int countByCoyAndLabel(int coyId, String tempLabelPattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " tmp " +
              "where UPPER(tmp.tempLabel) like UPPER(:tempLabelPattern) " +
                "and tmp.company.coyId = :coyId")
            .setString("tempLabelPattern", "%"+tempLabelPattern+"%")
            .setInteger("coyId", coyId)            
            .iterate().next()).intValue();
  }
  
  /**
   * Get template data by company
   * @param coytId, company
   * @return list of templates based on given company
   */
  public List<MasterTemplate> getByCoy(int coytId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " tmp " +
              "where tmp.company.coyId = :coyId " +
                "and tmp.startDate <= current_date " +
                "and tmp.endDate >= current_date " +
              "order by tmp.tempCode")
            .setInteger("coyId", coytId)
            .list();
  }
}
