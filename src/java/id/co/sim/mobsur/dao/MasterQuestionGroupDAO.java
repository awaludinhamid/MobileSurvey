/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterQuestionGroup;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_QUESTION_GROUP
 * extends BaseDAO class
 * @see BaseDAO
 * @created Jan 10, 2017
 * @author awal
 */
@Repository("masterQuestionGroupDAO")
public class MasterQuestionGroupDAO extends BaseDAO<MasterQuestionGroup> {

  /**
   * Get question group data by range and company
   * @param coyId, company
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of question groups based on given range and company
   */
  public List<MasterQuestionGroup> getByRangeCoy(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " quegr " +
              "where quegr.company.coyId = :coyId " +
                "and quegr.startDate <= current_date " +
                "and quegr.endDate >= current_date")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get question group data by range, company and label pattern/partial
   * @param coyId, company
   * @param questGroupLabelPattern
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of question groups based on given range, company and label pattern
   */
  public List<MasterQuestionGroup> getByRangeCoyAndLabel(int coyId, String questGroupLabelPattern, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " quegr " +
              "where quegr.company.coyId = :coyId " +
                "and UPPER(quegr.questGroupLabel) like UPPER(:questGroupLabelPattern)")
            .setInteger("coyId", coyId)
            .setString("questGroupLabelPattern","%"+questGroupLabelPattern+"%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of question group data by company
   * @param coyId, company
   * @return count of question group based on given company
   */
  public int countByCoy(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " quegr " +
              "where quegr.company.coyId = :coyId " +
                "and quegr.startDate <= current_date " +
                "and quegr.endDate >= current_date")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }
  
  /**
   * Get number of question group data by company and label pattern 
   * @param coyId, company
   * @param questGroupLabelPattern
   * @return count of question group based on given company and label pattern
   */
  public int countByCoyAndLabel(int coyId, String questGroupLabelPattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " quegr " +
              "where quegr.company.coyId = :coyId " +
                "and UPPER(quegr.questGroupLabel) like UPPER(:questGroupLabelPattern)")
            .setInteger("coyId", coyId)
            .setString("questGroupLabelPattern","%"+questGroupLabelPattern+"%")
            .iterate().next()).intValue();
  }
  
  /**
   * Get question group data by company 
   * @param coyId, company
   * @return list of question groups based on given company
   */
  public List<MasterQuestionGroup> getByCoy(int coyId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " quegr " +
              "where quegr.company.coyId = :coyId " +
                "and quegr.startDate <= current_date " +
                "and quegr.endDate >= current_date " +
              "order by quegr.questGroupLabel")
            .setInteger("coyId", coyId)
            .list();
  }
  
}
