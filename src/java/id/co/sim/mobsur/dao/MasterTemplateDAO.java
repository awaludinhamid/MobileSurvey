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
 * @created Jan 15, 2017
 * @author awal
 */
@Repository("masterTemplateDAO")
public class MasterTemplateDAO extends BaseDAO<MasterTemplate> {

  public List<MasterTemplate> getByRangeCoy(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " tmp " +
              "where tmp.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

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

  public int countByCoy(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " tmp " +
              "where tmp.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }

  public int countByCoyAndLabel(int coyId, String tempLabelPattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " tmp " +
              "where UPPER(tmp.tempLabel) like UPPER(:tempLabelPattern) " +
                "and tmp.company.coyId = :coyId")
            .setString("tempLabelPattern", "%"+tempLabelPattern+"%")
            .setInteger("coyId", coyId)            
            .iterate().next()).intValue();
  }
  
  public List<MasterTemplate> getByCoy(int coytId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " tmp " +
              "where tmp.company.coyId = :coyId")
            .setInteger("coyId", coytId)
            .list();
  }
}
