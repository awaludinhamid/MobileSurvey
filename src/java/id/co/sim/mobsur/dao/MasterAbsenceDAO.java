/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterAbsence;
import id.co.sim.mobsur.util.BaseDAO;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_ABSENCE
 * extends BaseDAO class
 * @see BaseDAO
 * @created Jan 26, 2017
 * @author awal
 */
@Repository("masterAbsenceDAO")
public class MasterAbsenceDAO extends BaseDAO<MasterAbsence> {

  /**
   * Get absence data by range and company
   * @param coyId, company
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of absences based on given range and company
   */
  public List<MasterAbsence> getByRangeCoy(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " absc " +
              "where absc.user.office.company.coyId = :coyId " +
                "and absc.startDate <= current_date " +
                "and absc.endDate >= current_date")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get absence data by range, user, reason, start date and end date
   * @param userId
   * @param reasonTypeId
   * @param startDate
   * @param endDate
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of absences based on given range, user, reason, start date and end date
   */
  public List<MasterAbsence> getByRangeUserReasonStartAndEndDate(int userId, int reasonTypeId, String startDate, String endDate, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " absc " +
              "where absc.user.userId = " +
                    "(case when :userId = 0 then absc.user.userId else :userId end) " +
                "and absc.reasonType.reasonTypeId = " +
                    "(case when :reasonTypeId = 0 then absc.reasonType.reasonTypeId else :reasonTypeId end) " +
                "and absc.startDate >= to_date(:startDate,'yyyy-mm-dd') " +
                "and absc.endDate <= to_date(:endDate,'yyyy-mm-dd')")
            .setInteger("userId", userId)
            .setInteger("reasonTypeId", reasonTypeId)
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get number of absence data by company
   * @param coyId, company
   * @return count of absence based on given company
   */
  public int countByCoy(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " absc " +
              "where absc.user.office.company.coyId = :coyId " +
                "and absc.startDate <= current_date " +
                "and absc.endDate >= current_date")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }
  
  /**
   * Get number of absence by user, reason, star date and end date
   * @param userId
   * @param reasonTypeId
   * @param startDate
   * @param endDate
   * @return count of absences based on given user, reason, star date and end date
   */
  public int countByUserReasonStartAndEndDate(int userId, int reasonTypeId, String startDate, String endDate) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " absc " +
              "where absc.user.userId = " +
                    "(case when :userId = 0 then absc.user.userId else :userId end) " +
                "and absc.reasonType.reasonTypeId = " +
                    "(case when :reasonTypeId = 0 then absc.reasonType.reasonTypeId else :reasonTypeId end) " +
                "and absc.startDate >= to_date(:startDate,'yyyy-mm-dd') " +
                "and absc.endDate <= to_date(:endDate,'yyyy-mm-dd')")
            .setInteger("userId", userId)
            .setInteger("reasonTypeId", reasonTypeId)
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .iterate().next()).intValue();
  }
  
  /**
   * Get absence data by range and superior
   * @param parentUserId, superior
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of absences based on given range and superior
   */
  public List<MasterAbsence> getByRangeParentUser(int parentUserId, int start, int num) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select absc.* from master_absence absc, " +
              "get_user_child(:parentUserId) child " +
                "where absc.user_id = child.user_id " +
                "and absc.start_date <= current_date " +
                "and absc.end_date >= current_date")
            .addEntity(domainClass)
            .setInteger("parentUserId",parentUserId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get absence by range, superior, user, reason, start date and end date
   * @param parentUserId
   * @param userId
   * @param reasonTypeId
   * @param startDate
   * @param endDate
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of absences based on given superior, user, reason, start date and end date
   */
  public List<MasterAbsence> getByRangeParentUserReasonStartAndEndDate(
          int parentUserId, int userId, int reasonTypeId, String startDate, String endDate, int start, int num) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select absc.* from master_absence absc, " +
              "get_user_child(:parentUserId) child " +
              "where absc.user_id = " +
                    "(case when :userId = 0 then absc.user_id else :userId end) " +
                "and absc.reason_type_id = " +
                    "(case when :reasonTypeId = 0 then absc.reason_type_id else :reasonTypeId end) " +
                "and absc.start_date >= to_date(:startDate,'yyyy-mm-dd') " +
                "and absc.end_date <= to_date(:endDate,'yyyy-mm-dd') " +
                "and absc.user_id = child.user_id")
            .addEntity(domainClass)
            .setInteger("parentUserId",parentUserId)
            .setInteger("userId", userId)
            .setInteger("reasonTypeId", reasonTypeId)
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of absence data by superior
   * @param parentUserId, superior
   * @return count of absences based on given superior
   */
  public int countByParentUser(int parentUserId) {
    return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery(
            "select count(*) from master_absence absc, " +
              "get_user_child(:parentUserId) child " +
                "where absc.user_id = child.user_id " +
                "and absc.start_date <= current_date " +
                "and absc.end_date >= current_date")
            .setInteger("parentUserId",parentUserId)
            .list().get(0)).intValue();
  }
  
  /**
   * Get number of absence data by superior, user, reason, start date and end date
   * @param parentUserId, superior
   * @param userId
   * @param reasonTypeId
   * @param startDate
   * @param endDate
   * @return count of absences based on given superior, user, reason, start date and end date
   */
  public int countByParentUserReasonStartAndEndDate(
          int parentUserId, int userId, int reasonTypeId, String startDate, String endDate) {
    return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery(
            "select count(*) from master_absence absc, " +
              "get_user_child(:parentUserId) child " +
              "where absc.user_id = " +
                    "(case when :userId = 0 then absc.user_id else :userId end) " +
                "and absc.reason_type_id = " +
                    "(case when :reasonTypeId = 0 then absc.reason_type_id else :reasonTypeId end) " +
                "and absc.start_date >= to_date(:startDate,'yyyy-mm-dd') " +
                "and absc.end_date <= to_date(:endDate,'yyyy-mm-dd') " +
                "and absc.user_id = child.user_id")
            .setInteger("parentUserId",parentUserId)
            .setInteger("userId", userId)
            .setInteger("reasonTypeId", reasonTypeId)
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .list().get(0)).intValue();
  }
}
