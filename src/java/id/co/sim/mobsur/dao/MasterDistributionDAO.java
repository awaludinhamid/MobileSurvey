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
 * @created Dec 4, 2016
 * @author awal
 */
@Repository("masterDistributionDAO")
public class MasterDistributionDAO extends BaseDAO<MasterDistribution> {

  public List<MasterDistribution> getByRangeCompany(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " dis " +
              "where dis.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

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

  public int countByCompany(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " dis " +
              "where dis.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }

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
