/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.DetailQuestionGroup;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table DETAIL_QUESTION_GROUP
 * extends BaseDAO class
 * @see BaseDAO
 * @created Jan 11, 2017
 * @author awal
 */
@Repository("detailQuestionGroupDAO")
public class DetailQuestionGroupDAO extends BaseDAO<DetailQuestionGroup> {

  /**
   * Get detail question by the group
   * @param questGroupId, group
   * @return list of detail question based on given group
   */
  public List<DetailQuestionGroup> getByQuestGroup(int questGroupId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " dqgr " +
              "where dqgr.questionGroup.questGroupId = :questGroupId " +
                "and dqgr.endDate >= current_date")
            .setInteger("questGroupId", questGroupId)
            .list();
  }
  
  /**
   * Get detail question by question
   * @param questId, question
   * @return list of detail question based on given question
   */
  public List<DetailQuestionGroup> getByQuest(int questId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " dqgr " +
              "where dqgr.question.questId = :questId")
            .setInteger("questId", questId)
            .list();
  }
  
  /**
   * Get number of detail question, count by question
   * @param questId, question
   * @return count of detail question based on given question
   */
  public int countByQuest(int questId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " dqgr " +
              "where dqgr.question.questId = :questId")
            .setInteger("questId", questId)
            .iterate().next()).intValue();
  }
}
