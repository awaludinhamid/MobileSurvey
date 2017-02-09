/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterParameter;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @created Nov 18, 2016
 * @author awal
 */
@Repository("masterParameterDAO")
public class MasterParameterDAO extends BaseDAO<MasterParameter> {
  
  public List<MasterParameter> getByRangeCompany(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " par " +
              "where par.company.coyId = :coyId ")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public List<MasterParameter> getByRangeCompanyCodeDescAndApps(
          int coyId, String parCodePattern, String parDescPattern, String parAppsType, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " par " +
              "where par.company.coyId = :coyId " +
                "and UPPER(par.parCode) like UPPER(:parCodePattern) " +
                "and UPPER(par.parDesc) like UPPER(:parDescPattern) " +
                "and par.parAppsType = " +    
                    "case when :parAppsType = '' then par.parAppsType else :parAppsType end")
            .setInteger("coyId", coyId)
            .setString("parCodePattern", "%"+parCodePattern+"%")
            .setString("parDescPattern", "%"+parDescPattern+"%")
            .setString("parAppsType", parAppsType)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  public int countByCompany(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " par " +
              "where par.company.coyId = :coyId ")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }

  public int countByCompanyCodeDescAndApps(int coyId, String parCodePattern, String parDescPattern, String parAppsType) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " par " +
              "where par.company.coyId = :coyId " +
                "and UPPER(par.parCode) like UPPER(:parCodePattern) " +
                "and UPPER(par.parDesc) like UPPER(:parDescPattern) " +
                "and par.parAppsType = " +    
                    "case when :parAppsType = '' then par.parAppsType else :parAppsType end")
            .setInteger("coyId", coyId)
            .setString("parCodePattern", "%"+parCodePattern+"%")
            .setString("parDescPattern", "%"+parDescPattern+"%")
            .setString("parAppsType", parAppsType)
            .iterate().next()).intValue();
  }
}
