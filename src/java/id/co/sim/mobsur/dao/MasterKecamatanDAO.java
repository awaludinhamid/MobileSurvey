/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterKecamatan;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_KECAMATAN
 * extends BaseDAO class
 * @see BaseDAO
 * @created Dec 16, 2016
 * @author awal
 */
@Repository("masterKecamatanDAO")
public class MasterKecamatanDAO extends BaseDAO<MasterKecamatan> {

  /**
   * Get kecamatan data by range, code and name pattern/partial
   * @param kecCodePattern
   * @param kecNamePattern
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of kecamatan based on given range, code and name pattern
   */
  public List<MasterKecamatan> getByRangeCodeAndName(String kecCodePattern, String kecNamePattern, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " kec " +
              "where UPPER(kec.kecCode) like UPPER(:kecCodePattern) " +
                "and UPPER(kec.kecName) like UPPER(:kecNamePattern)")
            .setString("kecCodePattern", "%"+kecCodePattern+"%")
            .setString("kecNamePattern", "%"+kecNamePattern+"%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get number of kecamatan data by code and name pattern
   * @param kecCodePattern
   * @param kecNamePattern
   * @return count of kecamatan based on given code and name pattern
   */
  public int countByCodeAndName(String kecCodePattern, String kecNamePattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " kec " +
              "where UPPER(kec.kecCode) like UPPER(:kecCodePattern) " +
                "and UPPER(kec.kecName) like UPPER(:kecNamePattern)")
            .setString("kecCodePattern", "%"+kecCodePattern+"%")
            .setString("kecNamePattern", "%"+kecNamePattern+"%")
            .iterate().next()).intValue();
  }
  
  /**
   * Get kecamatan data by city 
   * @param cityId
   * @return list of kecamatan based on given city
   */
  public List<MasterKecamatan> getByCity(int cityId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " kec " +
              "where kec.city.cityId = :cityId " +
                "and kec.startDate <= current_date " +
                "and kec.endDate >= current_date " +
              "order by kec.kecName")
            .setInteger("cityId", cityId)
            .list();
  }
  
  /**
   * Get kecamatan data by range
   * Override default behavior
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of kecamatan based on given range
   */
  @Override
  public List<MasterKecamatan> getByRange(int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " kec " +
                "where kec.startDate <= current_date " +
                "and kec.endDate >= current_date")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of all kecamatan data 
   * Override default behavior
   * @return count of all kecamatan
   */
  @Override
  public int count() {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " kec " +
                "where kec.startDate <= current_date " +
                "and kec.endDate >= current_date")
            .iterate().next()).intValue();
  }
}
