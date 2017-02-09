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
 * @created Dec 16, 2016
 * @author awal
 */
@Repository("masterKecamatanDAO")
public class MasterKecamatanDAO extends BaseDAO<MasterKecamatan> {

  public List<MasterKecamatan> getByRangeCodeAndName(String kecCodePattern, String kecNamePattern, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " " +
              "where UPPER(kecCode) like UPPER(:kecCodePattern) " +
                "and UPPER(kecName) like UPPER(:kecNamePattern)")
            .setString("kecCodePattern", "%"+kecCodePattern+"%")
            .setString("kecNamePattern", "%"+kecNamePattern+"%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  public int countByCodeAndName(String kecCodePattern, String kecNamePattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " " +
              "where UPPER(kecCode) like UPPER(:kecCodePattern) " +
                "and UPPER(kecName) like UPPER(:kecNamePattern)")
            .setString("kecCodePattern", "%"+kecCodePattern+"%")
            .setString("kecNamePattern", "%"+kecNamePattern+"%")
            .iterate().next()).intValue();
  }
  
  public List<MasterKecamatan> getByCity(int cityId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " kec " +
              "where kec.city.cityId = :cityId")
            .setInteger("cityId", cityId)
            .list();
  }
}
