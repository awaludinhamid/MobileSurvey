/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterQuestion;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_QUESTION
 * extends BaseDAO class
 * @see BaseDAO
 * @created Jan 5, 2017
 * @author awal
 */
@Repository("masterQuestionDAO")
public class MasterQuestionDAO extends BaseDAO<MasterQuestion> {

  /**
   * Get question data by range and company
   * @param coyId, company
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of questions based on given range and company
   */
  public List<MasterQuestion> getByRangeCoy(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " que " +
              "where que.company.coyId = :coyId " +
                "and que.startDate <= current_date " +
                "and que.endDate >= current_date")
            .setInteger("coyId",coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get question data by range, company, label and answer type
   * @param coyId, company
   * @param questLabelPattern
   * @param answerTypeId
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of questions based on given range, company, label and answer type
   */
  public List<MasterQuestion> getByRangeCoyLabelAndAnswer(int coyId, String questLabelPattern, int answerTypeId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " que " +
              "where que.company.coyId = :coyId " +
                "and UPPER(que.questLabel) like UPPER(:questLabelPattern) " +
                "and que.answerType.answerTypeId = " +
                    "(case when :answerTypeId = 0 then que.answerType.answerTypeId else :answerTypeId end)")
            .setInteger("coyId",coyId)
            .setString("questLabelPattern", "%"+questLabelPattern+"%")
            .setInteger("answerTypeId", answerTypeId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get number of question data by company
   * @param coyId, company
   * @return count of questions based on given company
   */
  public int countByCoy(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " que " +
              "where que.company.coyId = :coyId " +
                "and que.startDate <= current_date " +
                "and que.endDate >= current_date")
            .setInteger("coyId",coyId)
            .iterate().next()).intValue();
  }

  /**
   * Get number of question data by company, label and answer type
   * @param coyId, company
   * @param questLabelPattern
   * @param answerTypeId
   * @return count of questions based on given company, label and answer type
   */
  public int countByCoyLabelAndAnswer(int coyId, String questLabelPattern, int answerTypeId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " que " +
              "where que.company.coyId = :coyId " +
                "and UPPER(que.questLabel) like UPPER(:questLabelPattern) " +
                "and que.answerType.answerTypeId = " +
                    "(case when :answerTypeId = 0 then que.answerType.answerTypeId else :answerTypeId end)")
            .setInteger("coyId",coyId)
            .setString("questLabelPattern", "%"+questLabelPattern+"%")
            .setInteger("answerTypeId", answerTypeId)
            .iterate().next()).intValue();
  }

  /**
   * Get question data by company
   * @param coyId, company
   * @return list of questions based on given company
   */
  public List<MasterQuestion> getByCoy(int coyId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " que " +
              "where que.company.coyId = :coyId " +
                "and que.startDate <= current_date " +
                "and que.endDate >= current_date " +
              "order by que.questLabel")
            .setInteger("coyId",coyId)
            .list();
  }
}
