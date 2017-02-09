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
 * @created Jan 11, 2017
 * @author awal
 */
@Repository("detailQuestionGroupDAO")
public class DetailQuestionGroupDAO extends BaseDAO<DetailQuestionGroup> {

  public List<DetailQuestionGroup> getByQuestGroup(int questGroupId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " dqgr " +
              "where dqgr.questionGroup.questGroupId = :questGroupId")
            .setInteger("questGroupId", questGroupId)
            .list();
  }
}
