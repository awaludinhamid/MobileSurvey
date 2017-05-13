/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterProvinsi;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_PROVINSI
 * extends BaseDAO class
 * @see BaseDAO
 * @created Dec 16, 2016
 * @author awal
 */
@Repository("masterProvinsiDAO")
public class MasterProvinsiDAO extends BaseDAO<MasterProvinsi> {

  /**
   * Get provinsi data by range, provinsi code and name pattern/partial
   * @param provCodePattern
   * @param provNamePattern
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of provinsi based on given range, provinsi code and name pattern
   */
  public List<MasterProvinsi> getByRangeCodeAndName(String provCodePattern, String provNamePattern, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " prov " +
              "where UPPER(prov.provCode) like UPPER(:provCodePattern) " +
                "and UPPER(prov.provName) like UPPER(:provNamePattern)")
            .setString("provCodePattern", '%'+provCodePattern+'%')
            .setString("provNamePattern", '%'+provNamePattern+'%')
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of provinsi data by provinsi code and name pattern
   * @param provCodePattern
   * @param provNamePattern
   * @return count of provinsi based on given provinsi code and name pattern
   */
  public int countByCodeAndName(String provCodePattern, String provNamePattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " prov " +
              "where UPPER(prov.provCode) like UPPER(:provCodePattern) " +
                "and UPPER(prov.provName) like UPPER(:provNamePattern)")
            .setString("provCodePattern", '%'+provCodePattern+'%')
            .setString("provNamePattern", '%'+provNamePattern+'%')
            .iterate().next()).intValue();
  }
  
  /**
   * Get all provinsi data
   * Override default behavior
   * @return list of all provinsi
   */
  @Override
  public List<MasterProvinsi> getAll() {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " prov " +
              "where prov.startDate <= current_date " +
                "and prov.endDate >= current_date " +
              "order by prov.provName")
            .list();
  }
  
  /**
   * Get provinsi data by range
   * Override default behavior
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of provinsi based on given range
   */
  @Override
  public List<MasterProvinsi> getByRange(int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " prov " +
                "where prov.startDate <= current_date " +
                "and prov.endDate >= current_date")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of all provinsi data
   * Override default behavior
   * @return count of all provinsi
   */
  @Override
  public int count() {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " prov " +
                "where prov.startDate <= current_date " +
                "and prov.endDate >= current_date")
            .iterate().next()).intValue();
  }
}
