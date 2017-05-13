/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterZipcodeVerificator;
import id.co.sim.mobsur.util.BaseDAO;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_ZIPCODE_VERIFICATOR
 * extends BaseDAO class
 * @see BaseDAO
 * @created Jan 23, 2017
 * @author awal
 */
@Repository("masterZipcodeVerificatorDAO")
public class MasterZipcodeVerificatorDAO extends BaseDAO<MasterZipcodeVerificator> {

  /**
   * Get zipcode-verificator data by range and company
   * @param coyId, company
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of zipcode-verificator based on given range and company
   */
  public List<MasterZipcodeVerificator> getByRangeCoy(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " zipver " +
              "where zipver.verificator.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get zipcode-verificator data by range, company, verificator and zipcode description pattern/partial
   * @param coyId, company
   * @param verificatorId
   * @param zipcodeCodePattern
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of zipcode-verificator based on given range, company, verificator and zipcode description pattern
   */
  public List<MasterZipcodeVerificator> getByRangeCoyVerifAndZipcode(int coyId, int verificatorId, String zipcodeCodePattern, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " zipver " +
              "where zipver.verificator.office.company.coyId = :coyId " +
                "and zipver.verificator.userId = " +
                          "(case when :verificatorId = 0 then zipver.verificator.userId else :verificatorId end) " +
                "and UPPER(zipver.zipcode.zipcodeCode) like UPPER(:zipcodeCodePattern)")
            .setInteger("coyId", coyId)
            .setInteger("verificatorId", verificatorId)
            .setString("zipcodeCodePattern", "%"+zipcodeCodePattern+"%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get number of zipcode-verificator data by company
   * @param coyId, company
   * @return count of zipcode-verificator based on given company
   */
  public int countByCoy(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " zipver " +
              "where zipver.verificator.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }

  /**
   * Get number of zipcode-verificator data by company, verificator and zipcode description pattern
   * @param coyId, company
   * @param verificatorId
   * @param zipcodeCodePattern
   * @return count of zipcode-verificator based on given company, verificator and zipcode description pattern
   */
  public int countByCoyVerifAndZipcode(int coyId, int verificatorId, String zipcodeCodePattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " zipver " +
              "where zipver.verificator.office.company.coyId = :coyId " +
                "and zipver.verificator.userId = " +
                          "(case when :verificatorId = 0 then zipver.verificator.userId else :verificatorId end) " +
                "and UPPER(zipver.zipcode.zipcodeCode) like UPPER(:zipcodeCodePattern)")
            .setInteger("coyId", coyId)
            .setInteger("verificatorId", verificatorId)
            .setString("zipcodeCodePattern", "%"+zipcodeCodePattern+"%")
            .iterate().next()).intValue();
  }
  
  /**
   * Get zipcode-verificator by company, verificator, zipcode and sub zipcode
   * @param coyId, company
   * @param userCode, verificator code
   * @param zipcodeCode
   * @param subZipcode
   * @return zipcode-verificator based on given company, verificator, zipcode and sub zipcode
   */
  public MasterZipcodeVerificator getByCoyVerifZipcodeAndSub(int coyId, String userCode, String zipcodeCode, String subZipcode) {
    return (MasterZipcodeVerificator) sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " zipver " +
              "where zipver.verificator.office.company.coyId = :coyId " +
                "and zipver.verificator.userCode = :userCode " +
                "and zipver.zipcode.zipcodeCode = :zipcodeCode " +
                "and zipver.subZipcode = :subZipcode")
            .setInteger("coyId", coyId)
            .setString("userCode", userCode)
            .setString("zipcodeCode", zipcodeCode)
            .setString("subZipcode", subZipcode)
            .uniqueResult();
  }
  
  /**
   * Get zipcode-verificator data by company and verificator
   * @param coyId, company
   * @param userId, verificator
   * @return list of zipcode-verificator based on given company and verificator
   */
  public List<MasterZipcodeVerificator> getByCoyVerif(int coyId, int userId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " zipver " +
              "where zipver.verificator.office.company.coyId = :coyId " +
                "and zipver.verificator.userId = :userId")
            .setInteger("coyId", coyId)
            .setInteger("userId", userId)
            .list();
  }
  
  /**
   * Get maximum sub zipcode on specific company and zipcode
   * @param coyId, company
   * @param zipcodeId
   * @return maximum sub zipcode based on given company and zipcode
   */
  public String getMaxSubZipcodeByCoyAndZipcode(int coyId, int zipcodeId) {
    return (String) sessionFactory.getCurrentSession().createQuery(
            "select max(subZipcode) from " + domainClass.getName() + " zipver " +
              "where zipver.verificator.office.company.coyId = :coyId " +
                "and zipver.zipcode.zipcodeId = :zipcodeId")
            .setInteger("coyId", coyId)
            .setInteger("zipcodeId", zipcodeId)
            .uniqueResult();
  }
  
  /**
   * Get zipcode-verificator data by range and superior
   * @param parentUserId
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of zipcode-verificator based on given range and superior
   */
  public List<MasterZipcodeVerificator> getByRangeParentUser(int parentUserId, int start, int num) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select a.* from master_zipcode_verificator a, " +
              "get_user_child(:parentUserId) b " +
              "where a.verificator_id = b.user_id")
            .addEntity(domainClass)
            .setInteger("parentUserId", parentUserId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get zipcode-verificator data by range, superior, verificator and zipcode
   * @param parentUserId
   * @param verificatorId
   * @param zipcodeCodePattern
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of zipcode-verificator based on given range, superior, verificator and zipcode
   */
  public List<MasterZipcodeVerificator> getByRangeParentUserVerifAndZipcode(
          int parentUserId, int verificatorId, String zipcodeCodePattern, int start, int num) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select a.* from master_zipcode_verificator a, " +
              "get_user_child(:parentUserId) b, " +
              "master_zipcode c " +
              "where a.verificator_id = " +
                          "(case when :verificatorId = 0 then a.verificator_id else :verificatorId end) " +
                "and UPPER(c.zipcode_code) like UPPER(:zipcodeCodePattern) " +
                "and a.verificator_id = b.user_id " +
                "and a.zipcode_id = c.zipcode_id")
            .addEntity(domainClass)
            .setInteger("parentUserId", parentUserId)
            .setInteger("verificatorId", verificatorId)
            .setString("zipcodeCodePattern", "%"+zipcodeCodePattern+"%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of zipcode-verificator data by superior
   * @param parentUserId
   * @return count of zipcode-verificator based on given superior
   */
  public int countByParentUser(int parentUserId) {
    return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery(
            "select count(*) from master_zipcode_verificator a, " +
              "get_user_child(:parentUserId) b " +
                "where a.verificator_id = b.user_id")
            .setInteger("parentUserId",parentUserId)
            .list().get(0)).intValue();
  }

  /**
   * Get number of zipcode-verificator data by superior, verificator and zipcode
   * @param parentUserId
   * @param verificatorId
   * @param zipcodeCodePattern
   * @return count of zipcode-verificator based on given superior, verificator and zipcode
   */
  public int countByParentUserVerifAndZipcode(int parentUserId, int verificatorId, String zipcodeCodePattern) {
    return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery(
            "select count(*) from master_zipcode_verificator a, " +
              "get_user_child(:parentUserId) b, " +
              "master_zipcode c " +
              "where a.verificator_id = " +
                          "(case when :verificatorId = 0 then a.verificator_id else :verificatorId end) " +
                "and UPPER(c.zipcode_code) like UPPER(:zipcodeCodePattern) " +
                "and a.verificator_id = b.user_id " +
                "and a.zipcode_id = c.zipcode_id")
            .setInteger("parentUserId", parentUserId)
            .setInteger("verificatorId", verificatorId)
            .setString("zipcodeCodePattern", "%"+zipcodeCodePattern+"%")
            .list().get(0)).intValue();
  }
  
  /**
   * Get zipcode-verificator data by company
   * @param coyId, company
   * @return list of zipcode-verificator based on given company
   */
  public List<MasterZipcodeVerificator> getByCoy(int coyId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " zipver " +
              "where zipver.verificator.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .list();
  }
}
