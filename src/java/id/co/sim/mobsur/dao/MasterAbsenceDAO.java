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
 * @created Jan 26, 2017
 * @author awal
 */
@Repository("masterAbsenceDAO")
public class MasterAbsenceDAO extends BaseDAO<MasterAbsence> {

  public List<MasterAbsence> getByRangeCoy(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " absc " +
              "where absc.user.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

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

  public int countByCoy(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " absc " +
              "where absc.user.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }
  
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
  
  public List<MasterAbsence> getByRangeParentUser(int parentUserId, int start, int num) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select absc.* from master_absence absc, " +
              "get_user_child(:parentUserId) child " +
                "where absc.user_id = child.user_id")
            .addEntity(domainClass)
            .setInteger("parentUserId",parentUserId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
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
  
  public int countByParentUser(int parentUserId) {
    return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery(
            "select count(*) from master_absence absc, " +
              "get_user_child(:parentUserId) child " +
                "where absc.user_id = child.user_id")
            .setInteger("parentUserId",parentUserId)
            .list().get(0)).intValue();
  }
  
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
