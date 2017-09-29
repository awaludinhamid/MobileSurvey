/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MobileTaskResult;
import id.co.sim.mobsur.bean.support.CoordinateBean;
import id.co.sim.mobsur.util.BaseDAO;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

/**
 * DAO table MOBILE_TASK_RESULT
 * extends BaseDAO class
 * @see BaseDAO
 * @created Feb 13, 2017
 * @author awal
 */
@Repository("mobileTaskResultDAO")
public class MobileTaskResultDAO extends BaseDAO<MobileTaskResult> {

  /**
   * Get result data by range, coordinator and task status code
   * @param coordId, coordinator
   * @param taskStatusCode
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of results based on given range, coordinator and task status code
   */
  public List<MobileTaskResult> getByRangeCoordAndTaskStatus(int coordId, String taskStatusCode, int start, int num) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select mtr.* from mobile_task_result mtr, " +
              "mobile_task_assignment mta, " +
              "master_task_status mts, " +
              "get_user_child(:coordId) par " +
              "where mtr.task_id = mta.task_id " +
                "and mta.user_id = par.user_id " +
                "and mta.task_status_id = mts.task_status_id " +
                "and mts.task_status_code = :taskStatusCode " +
                "and mtr.task_result_id in ( " +
                  "select max(mtrx.task_result_id) " +
                    "from mobile_task_result mtrx, " +
                    "mobile_task_assignment mtax, " +
                    "master_task_status mtsx, " +
                    "get_user_child(:coordId) parx " +
                    "where mtrx.task_id = mtax.task_id " +
                      "and mtax.user_id = parx.user_id " +
                      "and mtax.task_status_id = mtsx.task_status_id " +
                      "and mtsx.task_status_code = :taskStatusCode " +
                      "group by mtax.task_id)")
            .addEntity(domainClass)
            .setInteger("coordId", coordId)
            .setString("taskStatusCode", taskStatusCode)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get result data by range, verificator and task status code
   * @param verifId, verificator
   * @param taskStatusCode
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of results based on given range, verificator and task status code
   */
  public List<MobileTaskResult> getByRangeVerifAndTaskStatus(int verifId, String taskStatusCode, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mtr " +
              "where mtr.task.user.userId = :verifId " +
                "and mtr.task.taskStatus.taskStatusCode = :taskStatusCode " +
                "and mtr.taskResultId in ( " +
                  "select max(mtrx.taskResultId) " +
                    "from " + domainClass.getName() + " mtrx " +
                    "where mtrx.task.user.userId = :verifId " +
                      "and mtrx.task.taskStatus.taskStatusCode = :taskStatusCode " +
                    "group by mtrx.task.taskId)")
            .setInteger("verifId", verifId)
            .setString("taskStatusCode", taskStatusCode)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get number of result data by coordinator and task status code
   * @param coordId, coordinator
   * @param taskStatusCode
   * @return count of results based on given coordinator and task status code
   */
  public int countByCoordAndTaskStatus(int coordId, String taskStatusCode) {
    return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery(
            "select count(*) from mobile_task_result mtr, " +
              "mobile_task_assignment mta, " +
              "master_task_status mts, " +
              "get_user_child(:coordId) par " +
              "where mtr.task_id = mta.task_id " +
                "and mta.user_id = par.user_id " +
                "and mta.task_status_id = mts.task_status_id " +
                "and mts.task_status_code = :taskStatusCode " +
                "and mtr.task_result_id in ( " +
                  "select max(mtrx.task_result_id) " +
                    "from mobile_task_result mtrx, " +
                    "mobile_task_assignment mtax, " +
                    "master_task_status mtsx, " +
                    "get_user_child(:coordId) parx " +
                    "where mtrx.task_id = mtax.task_id " +
                      "and mtax.user_id = parx.user_id " +
                      "and mtax.task_status_id = mtsx.task_status_id " +
                      "and mtsx.task_status_code = :taskStatusCode " +
                      "group by mtax.task_id)")
            .setInteger("coordId", coordId)
            .setString("taskStatusCode", taskStatusCode)
            .list().get(0)).intValue();
  }
  
  /**
   * Get number of result data by verificator and task status code
   * @param verifId, verificator
   * @param taskStatusCode
   * @return count of results based on given verificator and task status code
   */
  public int countByVerifAndTaskStatus(int verifId, String taskStatusCode) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mtr " +
              "where mtr.task.user.userId = :verifId " +
                "and mtr.task.taskStatus.taskStatusCode = :taskStatusCode " +
                "and mtr.taskResultId in ( " +
                  "select max(mtrx.taskResultId) " +
                    "from " + domainClass.getName() + " mtrx " +
                    "where mtrx.task.user.userId = :verifId " +
                      "and mtrx.task.taskStatus.taskStatusCode = :taskStatusCode " +
                    "group by mtrx.task.taskId)")
            .setInteger("verifId", verifId)
            .setString("taskStatusCode", taskStatusCode)
            .iterate().next()).intValue();
  }
  
  /**
   * Get coordinate data by verificator, assign date (start and end date) and GPS status
   * @param verifId, verificator
   * @param startDate
   * @param endDate
   * @param isGps, mobile using GPS while connecting (Y or N)
   * @return list of coordinates based on given verificator, assign date and GPS status
   */
  public List<CoordinateBean> getCoordinateByVerifAssignDateAndGps(int verifId, String startDate, String endDate, String isGps) {
    return sessionFactory.getCurrentSession().createQuery(
            "select mtr.gpsLatitude as latitude, mtr.gpsLongitude as longitude, mtr.task.submitDate as submitDate from " + domainClass.getName() + " mtr " +
              "where mtr.task.user.userId = :verifId " +
                "and date_trunc('day',mtr.task.submitDate) >= to_date(:startDate,'yyyy-mm-dd') " +
                "and date_trunc('day',mtr.task.submitDate) <= to_date(:endDate,'yyyy-mm-dd') " +
                "and coalesce(mtr.isGps,'N') = :isGps " +
                "order by mtr.task.submitDate")
            .setInteger("verifId", verifId)
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .setString("isGps", isGps)
            .setResultTransformer(Transformers.aliasToBean(CoordinateBean.class))
            .list();
  }
  
  /**
   * Get result by task
   * @param taskId
   * @return result based on given task, the first occurrence
   */
  public MobileTaskResult getByTaskIsLast(int taskId) {
    return (MobileTaskResult) sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mtr " +
              "where mtr.task.taskId = :taskId " +
              "order by mtr.taskResultId desc")
            .setInteger("taskId", taskId)
            .setMaxResults(1)
            .uniqueResult();
  }
}
