/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterOffice;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_OFFICE
 * extends BaseDAO class
 * @see BaseDAO
 * @created Nov 3, 2016
 * @author awal
 */
@Repository("masterOfficeDAO")
public class MasterOfficeDAO extends BaseDAO<MasterOffice> {

  /**
   * Get office data by range and company
   * @param coyId, company
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of offices based on given range and company
   */
  public List<MasterOffice> getByRangeCompany(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " ofc " +
            "where ofc.company.coyId = :coyId " +
              "and ofc.startDate <= current_date " +
              "and ofc.endDate >= current_date")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get office data by range, company, as of date, office code and name pattern/partial
   * @param coyId, company
   * @param officeCodePattern
   * @param officeNamePattern
   * @param asOfDate, end date more than or equal to this date
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of offices based on given range, company, as of date, office code and name pattern
   */
  public List<MasterOffice> getByRangeCompanyOfficeCodeNameAndDate(
          int coyId, String officeCodePattern, String officeNamePattern, String asOfDate, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " ofc " +
            "where ofc.company.coyId = :coyId " +
              "and UPPER(ofc.officeCode) like UPPER(:officeCodePattern) " +
              "and UPPER(ofc.officeName) like UPPER(:officeNamePattern) " +
              "and ofc.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("coyId", coyId)
            .setString("officeCodePattern", "%"+officeCodePattern+"%")
            .setString("officeNamePattern", "%"+officeNamePattern+"%")
            .setString("asOfDate", asOfDate)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get number of office data by company
   * @param coyId, company
   * @return count of offices based on given company
   */
  public int count(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " ofc " +
            "where ofc.company.coyId = :coyId " +
              "and ofc.startDate <= current_date " +
              "and ofc.endDate >= current_date")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }

  /**
   * Get number of office data by company, as of date, office code and name pattern
   * @param coyId, company
   * @param officeCodePattern
   * @param officeNamePattern
   * @param asOfDate, end date more than or equal to this date
   * @return count of offices based on given company, as of date, office code and name pattern
   */
  public int countByCompanyOfficeCodeNameAndDate(int coyId, String officeCodePattern, String officeNamePattern, String asOfDate) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " ofc " +
            "where ofc.company.coyId = :coyId " +
              "and UPPER(ofc.officeCode) like UPPER(:officeCodePattern) " +
              "and UPPER(ofc.officeName) like UPPER(:officeNamePattern) " +
              "and ofc.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("coyId", coyId)
            .setString("officeCodePattern", "%"+officeCodePattern+"%")
            .setString("officeNamePattern", "%"+officeNamePattern+"%")
            .setString("asOfDate", asOfDate)
            .iterate().next()).intValue();
  }

  /**
   * Get office data by company
   * @param coyId, company
   * @return list of offices based on given company
   */
  public List<MasterOffice> getByCompany(int coyId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " ofc " +
            "where ofc.company.coyId = :coyId  " +
              "and ofc.startDate <= current_date " +
              "and ofc.endDate >= current_date " +
            "order by ofc.officeName")
            .setInteger("coyId", coyId)
            .list();
  }
}
