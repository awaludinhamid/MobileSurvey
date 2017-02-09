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
 * @created Jan 10, 2017
 * @author awal
 */
@Repository("masterQuestionGroupDAO")
public class MasterQuestionGroupDAO extends BaseDAO<MasterQuestionGroup> {

  public List<MasterQuestionGroup> getByRangeCoy(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " quegr " +
              "where quegr.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

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
  
  public int countByCoy(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " quegr " +
              "where quegr.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }
  
  public int countByCoyAndLabel(int coyId, String questGroupLabelPattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " quegr " +
              "where quegr.company.coyId = :coyId " +
                "and UPPER(quegr.questGroupLabel) like UPPER(:questGroupLabelPattern)")
            .setInteger("coyId", coyId)
            .setString("questGroupLabelPattern","%"+questGroupLabelPattern+"%")
            .iterate().next()).intValue();
  }
  
  public List<MasterQuestionGroup> getByCoy(int coyId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " quegr " +
              "where quegr.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .list();
  }
  
}
