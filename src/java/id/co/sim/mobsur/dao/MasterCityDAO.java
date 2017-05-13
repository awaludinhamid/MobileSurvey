/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterCity;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_CITY
 * extends BaseDAO class
 * @see BaseDAO
 * @created Dec 16, 2016
 * @author awal
 */
@Repository("masterCityDAO")
public class MasterCityDAO extends BaseDAO<MasterCity> {

  /**
   * Get city data by range, code and name pattern/partial
   * @param cityCodePattern
   * @param cityNamePattern
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of cities based on given range, code and name pattern
   */
  public List<MasterCity> getByRangeCodeAndName(String cityCodePattern, String cityNamePattern, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " city " +
              "where UPPER(city.cityCode) like UPPER(:cityCodePattern) " +
                "and UPPER(city.cityName) like UPPER(:cityNamePattern)")
            .setString("cityCodePattern", "%"+cityCodePattern+"%")
            .setString("cityNamePattern", "%"+cityNamePattern+"%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of city data by code and name pattern
   * @param cityCodePattern
   * @param cityNamePattern
   * @return count of cities based on given code and name pattern
   */
  public int countByCodeAndName(String cityCodePattern, String cityNamePattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " city " +
              "where UPPER(city.cityCode) like UPPER(:cityCodePattern) " +
                "and UPPER(city.cityName) like UPPER(:cityNamePattern)")
            .setString("cityCodePattern", "%"+cityCodePattern+"%")
            .setString("cityNamePattern", "%"+cityNamePattern+"%")
            .iterate().next()).intValue();
  }
  
  /**
   * Get city data by provinsi
   * @param provId, provinsi
   * @return list of cities based on given provinsi
   */
  public List<MasterCity> getByProvinsi(int provId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " city " +
              "where city.provinsi.provId = :provId " +
                "and city.startDate <= current_date " +
                "and city.endDate >= current_date " +
              "order by city.cityName")
            .setInteger("provId", provId)
            .list();
  }
  
  /**
   * Get city data by range
   * Override default behavior
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of cities based on given range
   */
  @Override
  public List<MasterCity> getByRange(int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " city " +
                "where city.startDate <= current_date " +
                "and city.endDate >= current_date")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of all city data
   * Override default behavior
   * @return count of all cities
   */
  @Override
  public int count() {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " city " +
                "where city.startDate <= current_date " +
                "and city.endDate >= current_date")
            .iterate().next()).intValue();
  }
}
