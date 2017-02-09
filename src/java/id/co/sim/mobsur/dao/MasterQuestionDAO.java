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
 * @created Jan 5, 2017
 * @author awal
 */
@Repository("masterQuestionDAO")
public class MasterQuestionDAO extends BaseDAO<MasterQuestion> {

  public List<MasterQuestion> getByRangeCoy(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " que " +
              "where que.company.coyId = :coyId")
            .setInteger("coyId",coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  public List<MasterQuestion> getByRangeCoyLabelAndAnswer(int coyId, String questLabelPattern, int answerTypeId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " que " +
              "where que.company.coyId = :coyId " +
                "and UPPER(que.questLabel) like UPPER(:questLabelPattern) " +
                "and que.answerType.answerTypeId = " +
                    "case when :answerTypeId = 0 then que.answerType.answerTypeId else :answerTypeId end")
            .setInteger("coyId",coyId)
            .setString("questLabelPattern", "%"+questLabelPattern+"%")
            .setInteger("answerTypeId", answerTypeId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  public int countByCoy(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " que " +
              "where que.company.coyId = :coyId")
            .setInteger("coyId",coyId)
            .iterate().next()).intValue();
  }

  public int countByCoyLabelAndAnswer(int coyId, String questLabelPattern, int answerTypeId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " que " +
              "where que.company.coyId = :coyId " +
                "and UPPER(que.questLabel) like UPPER(:questLabelPattern) " +
                "and que.answerType.answerTypeId = " +
                    "case when :answerTypeId = 0 then que.answerType.answerTypeId else :answerTypeId end")
            .setInteger("coyId",coyId)
            .setString("questLabelPattern", "%"+questLabelPattern+"%")
            .setInteger("answerTypeId", answerTypeId)
            .iterate().next()).intValue();
  }

  public List<MasterQuestion> getByCoy(int coyId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " que " +
              "where que.company.coyId = :coyId")
            .setInteger("coyId",coyId)
            .list();
  }
}
