/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterDistribution;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_DISTRIBUTION 
 * extends BaseDAO class
 * @see BaseDAO
 * @created Dec 4, 2016
 * @author awal
 */
@Repository("masterDistributionDAO")
public class MasterDistributionDAO extends BaseDAO<MasterDistribution> {

  /**
   * Get distribution data by range and company
   * @param coyId, company
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of distributions based on given range and company
   */
  public List<MasterDistribution> getByRangeCompany(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " dis " +
              "where dis.office.company.coyId = :coyId " +
                "and dis.startDate <= current_date " +
                "and dis.endDate >= current_date")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get distribution data by range, company and office
   * @param coyId, company
   * @param officeId
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of distributions based on given range, company and office
   */
  public List<MasterDistribution> getByRangeCompanyOffice(int coyId, int officeId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " dis " +
              "where dis.office.company.coyId = :coyId " +
                "and dis.office.officeId = " +
                    "(case when :officeId = 0 then dis.office.officeId else :officeId end)")
            .setInteger("coyId", coyId)
            .setInteger("officeId", officeId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get number of distribution data by company
   * @param coyId, company
   * @return count of distribution based on given company
   */
  public int countByCompany(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " dis " +
              "where dis.office.company.coyId = :coyId " +
                "and dis.startDate <= current_date " +
                "and dis.endDate >= current_date")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }

  /**
   * Get number of distribution data by company and office 
   * @param coyId
   * @param officeId
   * @return count of distribution based on given company and office
   */
  public int countByCompanyOffice(int coyId, int officeId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " dis " +
              "where dis.office.company.coyId = :coyId " +
                "and dis.office.officeId = " +
                    "(case when :officeId = 0 then dis.office.officeId else :officeId end)")
            .setInteger("coyId", coyId)
            .setInteger("officeId", officeId)
            .iterate().next()).intValue();
  }
}
