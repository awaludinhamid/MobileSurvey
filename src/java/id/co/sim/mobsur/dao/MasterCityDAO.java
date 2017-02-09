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
 * @created Dec 16, 2016
 * @author awal
 */
@Repository("masterCityDAO")
public class MasterCityDAO extends BaseDAO<MasterCity> {

  public List<MasterCity> getByRangeCodeAndName(String cityCodePattern, String cityNamePattern, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " " +
              "where UPPER(cityCode) like UPPER(:cityCodePattern) " +
                "and UPPER(cityName) like UPPER(:cityNamePattern)")
            .setString("cityCodePattern", "%"+cityCodePattern+"%")
            .setString("cityNamePattern", "%"+cityNamePattern+"%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByCodeAndName(String cityCodePattern, String cityNamePattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " " +
              "where UPPER(cityCode) like UPPER(:cityCodePattern) " +
                "and UPPER(cityName) like UPPER(:cityNamePattern)")
            .setString("cityCodePattern", "%"+cityCodePattern+"%")
            .setString("cityNamePattern", "%"+cityNamePattern+"%")
            .iterate().next()).intValue();
  }
  
  public List<MasterCity> getByProvinsi(int provId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " city " +
              "where city.provinsi.provId = :provId")
            .setInteger("provId", provId)
            .list();
  }
}
