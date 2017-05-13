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
 * DAO table MASTER_PARAMETER
 * extends BaseDAO class
 * @see BaseDAO
 * @created Nov 18, 2016
 * @author awal
 */
@Repository("masterParameterDAO")
public class MasterParameterDAO extends BaseDAO<MasterParameter> {
  
  /**
   * Get parameter data by range and company
   * @param coyId, company
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of parameters based on given range and company
   */
  public List<MasterParameter> getByRangeCompany(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " par " +
              "where par.company.coyId = :coyId " +
                "and par.startDate <= current_date " +
                "and par.endDate >= current_date")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get parameter data by range, company, application type, parameter code and description pattern/partial
   * @param coyId, company
   * @param parCodePattern
   * @param parDescPattern
   * @param parAppsType, application type: web or mobile
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of parameters based on given range, company, application type, parameter code and description pattern
   */
  public List<MasterParameter> getByRangeCompanyCodeDescAndApps(
          int coyId, String parCodePattern, String parDescPattern, String parAppsType, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " par " +
              "where par.company.coyId = :coyId " +
                "and UPPER(par.parentParameter.parentParCode) like UPPER(:parCodePattern) " +
                "and UPPER(par.parentParameter.parentParDesc) like UPPER(:parDescPattern) " +
                "and par.parentParameter.parentParAppstype = " +    
                    "(case when :parAppsType = '' then par.parentParameter.parentParAppstype else :parAppsType end)")
            .setInteger("coyId", coyId)
            .setString("parCodePattern", "%"+parCodePattern+"%")
            .setString("parDescPattern", "%"+parDescPattern+"%")
            .setString("parAppsType", parAppsType)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get number of parameter data by company
   * @param coyId, company
   * @return count of parameters based on given company
   */
  public int countByCompany(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " par " +
              "where par.company.coyId = :coyId " +
                "and par.startDate <= current_date " +
                "and par.endDate >= current_date")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }

  /**
   * Get number of parameter data by company, application type, parameter code and description pattern
   * @param coyId, company
   * @param parCodePattern
   * @param parDescPattern
   * @param parAppsType, application type: web or mobile
   * @return count of parameters based on given company, application type, parameter code and description pattern
   */
  public int countByCompanyCodeDescAndApps(int coyId, String parCodePattern, String parDescPattern, String parAppsType) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " par " +
              "where par.company.coyId = :coyId " +
                "and UPPER(par.parentParameter.parentParCode) like UPPER(:parCodePattern) " +
                "and UPPER(par.parentParameter.parentParDesc) like UPPER(:parDescPattern) " +
                "and par.parentParameter.parentParAppstype = " +    
                    "(case when :parAppsType = '' then par.parentParameter.parentParAppstype else :parAppsType end)")
            .setInteger("coyId", coyId)
            .setString("parCodePattern", "%"+parCodePattern+"%")
            .setString("parDescPattern", "%"+parDescPattern+"%")
            .setString("parAppsType", parAppsType)
            .iterate().next()).intValue();
  }
}
