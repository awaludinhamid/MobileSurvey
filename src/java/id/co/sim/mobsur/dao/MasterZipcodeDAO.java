/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterZipcode;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

/**
 * @created Nov 26, 2016
 * @author awal
 */
@Repository("masterZipcodeDAO")
public class MasterZipcodeDAO extends BaseDAO<MasterZipcode> {
 
  public List<MasterZipcode> getByRangeZipcodeDesc(String zipcodeCodePattern, String zipcodeDescPattern, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " zip " +
              "where UPPER(zipcodeCode) like UPPER(:zipcodeCodePattern) " +
                "and UPPER(zipcodeDesc) like UPPER(:zipcodeDescPattern)")
            .setString("zipcodeCodePattern", "%"+zipcodeCodePattern+"%")
            .setString("zipcodeDescPattern", "%"+zipcodeDescPattern+"%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
 
  public int countByZipcodeDesc(String zipcodeCodePattern, String zipcodeDescPattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " zip " +
              "where UPPER(zipcodeCode) like UPPER(:zipcodeCodePattern) " +
                "and UPPER(zipcodeDesc) like UPPER(:zipcodeDescPattern)")
            .setString("zipcodeCodePattern", "%"+zipcodeCodePattern+"%")
            .setString("zipcodeDescPattern", "%"+zipcodeDescPattern+"%")
            .iterate().next()).intValue();
  }
  
  public List<String> getListInput(String fieldName) {
    Criteria crit = sessionFactory.getCurrentSession().createCriteria(domainClass)
            .setProjection(Projections.distinct(Projections.property(fieldName)));
    return crit.list();
  }
  
  public MasterZipcode getByZipcodeCode(String zipcodeCode) {
    return (MasterZipcode) sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " " +
              "where zipcodeCode = :zipcodeCode")
            .setString("zipcodeCode", zipcodeCode)
            .uniqueResult();
  }
  
  public List<MasterZipcode> getByKecamatan(int kecId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " zip " +
              "where zip.kecamatan.kecId = :kecId")
            .setInteger("kecId", kecId)
            .list();
  }
}
