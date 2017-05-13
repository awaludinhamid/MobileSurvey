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
 * DAO table MASTER_ZIPCODE
 * extends BaseDAO class
 * @see BaseDAO
 * @created Nov 26, 2016
 * @author awal
 */
@Repository("masterZipcodeDAO")
public class MasterZipcodeDAO extends BaseDAO<MasterZipcode> {
 
  /**
   * Get zipcode data by range, zipcode code and description pattern/partial
   * @param zipcodeCodePattern
   * @param zipcodeDescPattern
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of sipcodes based on given range, zipcode code and description pattern
   */
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
 
  /**
   * Get number of zipcode data by range, zipcode code and description pattern
   * @param zipcodeCodePattern
   * @param zipcodeDescPattern
   * @return count of zipcodes based on given range, zipcode code and description pattern
   */
  public int countByZipcodeDesc(String zipcodeCodePattern, String zipcodeDescPattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " zip " +
              "where UPPER(zipcodeCode) like UPPER(:zipcodeCodePattern) " +
                "and UPPER(zipcodeDesc) like UPPER(:zipcodeDescPattern)")
            .setString("zipcodeCodePattern", "%"+zipcodeCodePattern+"%")
            .setString("zipcodeDescPattern", "%"+zipcodeDescPattern+"%")
            .iterate().next()).intValue();
  }
  
  /**
   * Get column content data by column
   * @param fieldName, the name of specific column to return
   * @return list of column contents based on given column
   */
  public List<String> getListInput(String fieldName) {
    Criteria crit = sessionFactory.getCurrentSession().createCriteria(domainClass)
            .setProjection(Projections.distinct(Projections.property(fieldName)));
    return crit.list();
  }
  
  /**
   * Get zipcode by code
   * @param zipcodeCode
   * @return zipcode based on given the code
   */
  public MasterZipcode getByZipcodeCode(String zipcodeCode) {
    return (MasterZipcode) sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " zip " +
              "where zip.zipcodeCode = :zipcodeCode " +
                "and zip.startDate <= current_date " +
                "and zip.endDate >= current_date")
            .setString("zipcodeCode", zipcodeCode)
            .uniqueResult();
  }
  
  /**
   * Get zipcode data by kecamatan
   * @param kecId, kecamatan
   * @return list of zipcodes based on given kecamatan
   */
  public List<MasterZipcode> getByKecamatan(int kecId) {
    return sessionFactory.getCurrentSession().createQuery(
            "select distinct kel.zipcode from MasterKelurahan kel " +
              "where kel.kecamatan.kecId = :kecId " +
                "and kel.zipcode.startDate <= current_date " +
                "and kel.zipcode.endDate >= current_date")
            .setInteger("kecId", kecId)
            .list();
  }
  
  /**
   * Get zipcode data by city
   * @param cityId
   * @return list of zipcodes based on given city
   */
  public List<MasterZipcode> getByCity(int cityId) {
    return sessionFactory.getCurrentSession().createQuery(
            "select distinct kel.zipcode from MasterKelurahan kel " +
              "where kel.kecamatan.city.cityId = :cityId " +
                "and kel.zipcode.startDate <= current_date " +
                "and kel.zipcode.endDate >= current_date " +
              "order by kel.zipcode.zipcodeCode")
            .setInteger("cityId", cityId)
            .list();
  }
  
  /**
   * Get all zipcode data
   * Override default behavior
   * @return list of all zipcodes
   */
  @Override
  public List<MasterZipcode> getAll() {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " zip " +
              "where zip.startDate <= current_date " +
                "and zip.endDate >= current_date")
            .list();
  }
  
  /**
   * Get zipcode data by range
   * Override default behavior
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of zipcodes based on given range
   */
  @Override
  public List<MasterZipcode> getByRange(int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " zip " +
                "where zip.startDate <= current_date " +
                "and zip.endDate >= current_date")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of all zipcode data
   * Override default behavior
   * @return count of all zipcodes
   */
  @Override
  public int count() {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " zip " +
                "where zip.startDate <= current_date " +
                "and zip.endDate >= current_date")
            .iterate().next()).intValue();
  }
  
  /**
   * Get zipcode data by code pattern/partial
   * @param patternCode
   * @return list of zipcodes based on given code pattern
   */
  public List<MasterZipcode> getByPatternCode(String patternCode) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " zip " +
              "where zip.zipcodeCode like :patternCode " +
              "order by zip.zipcodeCode")
            .setString("patternCode", patternCode + "%")
            .list();
  }
}
