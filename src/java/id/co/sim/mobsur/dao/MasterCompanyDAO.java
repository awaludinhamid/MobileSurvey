/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterCompany;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_COMPANY
 * extends BaseDAO class
 * @see BaseDAO
 * @created Oct 12, 2016
 * @author awal
 */
@Repository("masterCompany")
public class MasterCompanyDAO extends BaseDAO<MasterCompany> {
  
  /**
   * Get company data by range, code and name pattern/partial
   * @param coyCodePattern
   * @param coyNamePattern
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of companies based on given range, code and name pattern
   */
  public List<MasterCompany> getByRangeCodeAndNamePattern(String coyCodePattern, String coyNamePattern, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " coy " +
              "where UPPER(coy.coyCode) like UPPER(:coyCodePattern) " +
                "and UPPER(coy.coyName) like UPPER(:coyNamePattern)")
            .setString("coyCodePattern", "%"+coyCodePattern+"%")
            .setString("coyNamePattern", "%"+coyNamePattern+"%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of company data by code and name pattern
   * @param coyCodePattern
   * @param coyNamePattern
   * @return count of companies based on given code and name pattern
   */
  public int countByCodeAndNamePattern(String coyCodePattern, String coyNamePattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " coy " +
              "where UPPER(coy.coyCode) like UPPER(:coyCodePattern) " +
                "and UPPER(coy.coyName) like UPPER(:coyNamePattern)")
            .setString("coyCodePattern", "%"+coyCodePattern+"%")
            .setString("coyNamePattern", "%"+coyNamePattern+"%")
            .iterate().next()).intValue();
  }

  /**
   * Get company data by user
   * @param userId
   * @return company based on given user
   */
  public MasterCompany getValidCoyByUserId(int userId) {
    return (MasterCompany) sessionFactory.getCurrentSession().createQuery(
            "select coy from " + domainClass.getName() + " as coy " +
              "inner join coy.offices as ofc " +
              "inner join ofc.users as usr " +
              "where usr.userId = :userId " +
                "and coy.startDate <= current_date and coy.endDate >= current_date")
            .setInteger("userId", userId)
            .uniqueResult();
  }
  
  /**
   * Get company data by range
   * Override default behavior
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of companies based on given range
   */
  @Override
  public List<MasterCompany> getByRange(int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " coy " +
                "where coy.startDate <= current_date " +
                "and coy.endDate >= current_date")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of all company data
   * Override default behavior
   * @return count of all companies
   */
  @Override
  public int count() {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " coy " +
                "where coy.startDate <= current_date " +
                "and coy.endDate >= current_date")
            .iterate().next()).intValue();
  }
}
