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
 * @created Dec 16, 2016
 * @author awal
 */
@Repository("masterProvinsiDAO")
public class MasterProvinsiDAO extends BaseDAO<MasterProvinsi> {

  public List<MasterProvinsi> getByRangeCodeAndName(String provCodePattern, String provNamePattern, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " " +
              "where UPPER(provCode) like UPPER(:provCodePattern) " +
                "and UPPER(provName) like UPPER(:provNamePattern)")
            .setString("provCodePattern", '%'+provCodePattern+'%')
            .setString("provNamePattern", '%'+provNamePattern+'%')
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByCodeAndName(String provCodePattern, String provNamePattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " " +
              "where UPPER(provCode) like UPPER(:provCodePattern) " +
                "and UPPER(provName) like UPPER(:provNamePattern)")
            .setString("provCodePattern", '%'+provCodePattern+'%')
            .setString("provNamePattern", '%'+provNamePattern+'%')
            .iterate().next()).intValue();
  }
}
