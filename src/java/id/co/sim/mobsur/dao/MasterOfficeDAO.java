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
 * @created Nov 3, 2016
 * @author awal
 */
@Repository("masterOfficeDAO")
public class MasterOfficeDAO extends BaseDAO<MasterOffice> {

  public List<MasterOffice> getByRangeCompany(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " ofc " +
            "where ofc.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

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

  public int count(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " ofc " +
            "where ofc.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }

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

  public List<MasterOffice> getByCompany(int coyId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " ofc " +
            "where ofc.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .list();
  }
}
