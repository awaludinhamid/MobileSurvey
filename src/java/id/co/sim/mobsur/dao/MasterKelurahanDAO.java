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
 * @created Dec 16, 2016
 * @author awal
 */
@Repository("masterKelurahanDAO")
public class MasterKelurahanDAO extends BaseDAO<MasterKelurahan> {

  public List<MasterKelurahan> getByRangeCodeAndName(String kelCodePattern, String kelNamePattern, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " " +
              "where UPPER(kelCode) like UPPER(:kelCodePattern) " +
                "and UPPER(kelName) like UPPER(:kelNamePattern)")
            .setString("kelCodePattern", "%"+kelCodePattern+"%")
            .setString("kelNamePattern", "%"+kelNamePattern+"%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  public int countByCodeAndName(String kelCodePattern, String kelNamePattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " " +
              "where UPPER(kelCode) like UPPER(:kelCodePattern) " +
                "and UPPER(kelName) like UPPER(:kelNamePattern)")
            .setString("kelCodePattern", "%"+kelCodePattern+"%")
            .setString("kelNamePattern", "%"+kelNamePattern+"%")
            .iterate().next()).intValue();
  }
  
  public List<MasterKelurahan> getByKecamatan(int kecId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " kel " +
              "where kel.kecamatan.kecId = :kecId")
            .setInteger("kecId", kecId)
            .list();
  }
}
