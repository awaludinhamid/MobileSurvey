/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterKelurahan;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_KELURAHAN
 * extends BaseDAO class
 * @see BaseDAO
 * @created Dec 16, 2016
 * @author awal
 */
@Repository("masterKelurahanDAO")
public class MasterKelurahanDAO extends BaseDAO<MasterKelurahan> {

  /**
   * Get kelurahan data by range, code and name pattern/partial
   * @param kelCodePattern
   * @param kelNamePattern
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of kelurahan based on given range, code and name pattern
   */
  public List<MasterKelurahan> getByRangeCodeAndName(String kelCodePattern, String kelNamePattern, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " kel " +
              "where UPPER(kel.kelCode) like UPPER(:kelCodePattern) " +
                "and UPPER(kel.kelName) like UPPER(:kelNamePattern)")
            .setString("kelCodePattern", "%"+kelCodePattern+"%")
            .setString("kelNamePattern", "%"+kelNamePattern+"%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get number of kelurahan data by code and name pattern
   * @param kelCodePattern
   * @param kelNamePattern
   * @return count of kelurahan based on given code and name pattern
   */
  public int countByCodeAndName(String kelCodePattern, String kelNamePattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " kel " +
              "where UPPER(kel.kelCode) like UPPER(:kelCodePattern) " +
                "and UPPER(kel.kelName) like UPPER(:kelNamePattern)")
            .setString("kelCodePattern", "%"+kelCodePattern+"%")
            .setString("kelNamePattern", "%"+kelNamePattern+"%")
            .iterate().next()).intValue();
  }
  
  /**
   * Get kelurahan data by kecamatan
   * @param kecId, kecamatan
   * @return list of kelurahan based on given kecamatan
   */
  public List<MasterKelurahan> getByKecamatan(int kecId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " kel " +
              "where kel.kecamatan.kecId = :kecId " +
                "and kel.startDate <= current_date " +
                "and kel.endDate >= current_date")
            .setInteger("kecId", kecId)
            .list();
  }
  
  /**
   * Get kelurahan data by range
   * Override default behavior
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of kelurahan based on given range
   */
  @Override
  public List<MasterKelurahan> getByRange(int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " kel " +
                "where kel.startDate <= current_date " +
                "and kel.endDate >= current_date")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of kelurahan data
   * Override default behavior
   * @return count of kelurahan
   */
  @Override
  public int count() {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " kel " +
                "where kel.startDate <= current_date " +
                "and kel.endDate >= current_date")
            .iterate().next()).intValue();
  }
}
