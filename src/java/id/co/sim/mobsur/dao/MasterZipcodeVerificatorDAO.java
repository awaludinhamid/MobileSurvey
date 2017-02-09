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
 * @created Jan 23, 2017
 * @author awal
 */
@Repository("masterZipcodeVerificatorDAO")
public class MasterZipcodeVerificatorDAO extends BaseDAO<MasterZipcodeVerificator> {

  public List<MasterZipcodeVerificator> getByRangeCoy(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " zipver " +
              "where zipver.verificator.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

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

  public int countByCoy(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " zipver " +
              "where zipver.verificator.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }

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
  
  public List<MasterZipcodeVerificator> getByCoyVerif(int coyId, int userId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " zipver " +
              "where zipver.verificator.office.company.coyId = :coyId " +
                "and zipver.verificator.userId = :userId")
            .setInteger("coyId", coyId)
            .setInteger("userId", userId)
            .list();
  }
  
  public String getMaxSubZipcodeByCoyAndZipcode(int coyId, int zipcodeId) {
    return (String) sessionFactory.getCurrentSession().createQuery(
            "select max(subZipcode) from " + domainClass.getName() + " zipver " +
              "where zipver.verificator.office.company.coyId = :coyId " +
                "and zipver.zipcode.zipcodeId = :zipcodeId")
            .setInteger("coyId", coyId)
            .setInteger("zipcodeId", zipcodeId)
            .uniqueResult();
  }
  
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
            .setInteger("parentUserId", parentUserId)
            .setInteger("verificatorId", verificatorId)
            .setString("zipcodeCodePattern", "%"+zipcodeCodePattern+"%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByParentUser(int parentUserId) {
    return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery(
            "select count(*) from master_zipcode_verificator a, " +
              "get_user_child(:parentUserId) b " +
                "where a.verificator_id = b.user_id")
            .setInteger("parentUserId",parentUserId)
            .list().get(0)).intValue();
  }

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
}
