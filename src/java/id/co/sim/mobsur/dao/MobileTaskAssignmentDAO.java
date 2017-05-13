/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MobileTaskAssignment;
import id.co.sim.mobsur.util.BaseDAO;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MOBILE_TASK_ASSIGNMENT
 * extends BaseDAO class
 * @see BaseDAO
 * @created Feb 2, 2017
 * @author awal
 */
@Repository("mobileTaskAssignmentDAO")
public class MobileTaskAssignmentDAO extends BaseDAO<MobileTaskAssignment> {
  
  /**
   * Get task data by range, user and task status code
   * @param userId
   * @param taskStatusCode, task status code collection
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of tasks based on given range, user and task status code
   */
  public List<MobileTaskAssignment> getByRangeUser(int userId, String taskStatusCode, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mta " +
              "where mta.user.userId = :userId " +
                "and mta.taskStatus.taskStatusCode = :taskStatusCode")
            .setInteger("userId", userId)
            .setString("taskStatusCode", taskStatusCode)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  } 
  
  /**
   * Get task data by range, user and more
   * @param userId
   * @param taskStatusId
   * @param tempId, template
   * @param priority, is priority (Y or N)
   * @param startDate
   * @param endDate
   * @param taskId
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of tasks based on given range, user and more (see parameters)
   */
  public List<MobileTaskAssignment> getByRangeUserAndOther(
          int userId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mta " +
              "where mta.user.userId = :userId " +
                "and (mta.taskStatus.taskStatusId = :taskStatusId or :taskStatusId = 0) " +
                "and (mta.product.template.tempId = :tempId or :tempId = 0) " +
                "and (mta.priority = :priority or :priority = '') " +
                "and date_trunc('day',mta.assignmentDate) >= to_date(:startDate,'yyyy-mm-dd') " +
                "and date_trunc('day',mta.assignmentDate) <= to_date(:endDate,'yyyy-mm-dd') " +
                "and (mta.taskId = :taskId or :taskId = 0) " +
              "order by mta.orderDate desc")
            .setInteger("userId", userId)
            .setInteger("taskStatusId", taskStatusId)
            .setInteger("tempId", tempId)
            .setString("priority", priority)
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .setInteger("taskId", taskId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  } 
  
  /**
   * Get task data by range, superior and more
   * @param parentUserId
   * @param taskStatusId
   * @param tempId, template
   * @param priority, is priority (Y or N)
   * @param startDate
   * @param endDate
   * @param taskId
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of tasks based on given range, superior and more (see parameters)
   */
  public List<MobileTaskAssignment> getByRangeParentUserAndOther(
          int parentUserId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId, int start, int num) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select mta.* from mobile_task_assignment mta, " +
              "master_product mp, " +
              "get_user_child(:parentUserId) child " +
              "where mta.user_id = child.user_id " +
                "and mta.product_id = mp.product_id " +
                "and (mta.task_status_id = :taskStatusId or :taskStatusId = 0) " +
                "and (mp.temp_id = :tempId or :tempId = 0) " +
                "and (mta.priority = :priority or :priority = '') " +
                "and date_trunc('day',mta.assignment_date) >= to_date(:startDate,'yyyy-mm-dd') " +
                "and date_trunc('day',mta.assignment_date) <= to_date(:endDate,'yyyy-mm-dd') " +
                "and (mta.task_id = :taskId or :taskId = 0) " +
            "union all " +
            "select mta.* from mobile_task_assignment mta, " +
              "master_product mp " +
              "where mta.product_id = mp.product_id " +
                "and mta.user_id = :parentUserId " +
                "and (mta.task_status_id = :taskStatusId or :taskStatusId = 0) " +
                "and (mp.temp_id = :tempId or :tempId = 0) " +
                "and (mta.priority = :priority or :priority = '') " +
                "and date_trunc('day',mta.assignment_date) >= to_date(:startDate,'yyyy-mm-dd') " +
                "and date_trunc('day',mta.assignment_date) <= to_date(:endDate,'yyyy-mm-dd') " +
                "and (mta.task_id = :taskId or :taskId = 0) " +
              "order by order_date desc")
            .addEntity(domainClass)
            .setInteger("parentUserId",parentUserId)
            .setInteger("taskStatusId", taskStatusId)
            .setInteger("tempId", tempId)
            .setString("priority", priority)
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .setInteger("taskId", taskId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get task data by range, superior and task status collection
   * @param parentUserId
   * @param taskStatusArr, task status code collection
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of tasks based on given range, superior and task status collection
   */
  public List<MobileTaskAssignment> getByRangeParentUserAndTaskStatusList(int parentUserId, String[] taskStatusArr, int start, int num) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select mta.* from mobile_task_assignment mta, " +
              "master_task_status mts, " +
              "get_user_child(:parentUserId) child " +
              "where mta.user_id = child.user_id " +
                "and mta.task_status_id = mts.task_status_id " +
                "and mts.task_status_code in (:taskStatusArr) " +
            "union all " +
            "select mta.* from mobile_task_assignment mta, " +
              "master_task_status mts " +
              "where mta.task_status_id = mts.task_status_id " +
                "and mta.user_id = :parentUserId " +
                "and mts.task_status_code in (:taskStatusArr) " +
              "order by task_id desc")
            .addEntity(domainClass)
            .setInteger("parentUserId", parentUserId)
            .setParameterList("taskStatusArr", taskStatusArr)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get task data by range, superior, task status collection and task
   * @param parentUserId
   * @param startDate
   * @param endDate
   * @param taskStatusArr, task status code collection
   * @param taskId
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of tasks based on given range, superior, task status collection and task
   */
  public List<MobileTaskAssignment> getByRangeParentUserOrderDateTaskStatusListAndTask(
          int parentUserId, String startDate, String endDate, String[] taskStatusArr, int taskId, int start, int num) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select mta.* from mobile_task_assignment mta, " +
              "master_task_status mts, " +
              "get_user_child(:parentUserId) child " +
              "where mta.user_id = child.user_id " +
                "and mta.task_id = (case when :taskId = 0 then mta.task_id else :taskId end) " +
                "and mta.task_status_id = mts.task_status_id " +
                "and mts.task_status_code in (:taskStatusArr) " +
                "and mta.order_date >= to_date(:startDate,'yyyy-mm-dd') " +
                "and mta.order_date <= to_date(:endDate,'yyyy-mm-dd') " +
            "union all " +
            "select mta.* from mobile_task_assignment mta, " +
              "master_task_status mts " +
              "where mta.task_status_id = mts.task_status_id " +
                "and mta.user_id = :parentUserId " +
                "and mta.task_id = (case when :taskId = 0 then mta.task_id else :taskId end) " +
                "and mts.task_status_code in (:taskStatusArr) " +
                "and mta.order_date >= to_date(:startDate,'yyyy-mm-dd') " +
                "and mta.order_date <= to_date(:endDate,'yyyy-mm-dd') " +
              "order by task_id desc")
            .addEntity(domainClass)
            .setInteger("parentUserId", parentUserId)
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .setInteger("taskId", taskId)
            .setParameterList("taskStatusArr", taskStatusArr)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get task data by range, user and task status collection
   * @param userId
   * @param taskStatusArr, task status code collection
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of tasks based on given range, user and task status collection
   */
  public List<MobileTaskAssignment> getByRangeUserAndTaskStatusList(int userId, String[] taskStatusArr, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mta " +
              "where mta.user.userId = :userId " +
                "and mta.taskStatus.taskStatusCode in :taskStatusArr")
            .setInteger("userId", userId)
            .setParameterList("taskStatusArr", taskStatusArr)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  } 
  
  /**
   * Get task data by range, office and more
   * @param officeId
   * @param taskStatusId
   * @param tempId, template
   * @param priority, is priority (Y or N)
   * @param taskId
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of tasks based on given range, office and more (see parameters)
   */
  public List<MobileTaskAssignment> getByRangeOfficeAndOther(
          int officeId, int taskStatusId, int tempId, String priority, int taskId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mta " +
              "where mta.office.officeId = :officeId " +
                "and (mta.taskStatus.taskStatusId = :taskStatusId or :taskStatusId = 0) " +
                "and (mta.product.template.tempId = :tempId or :tempId = 0) " +
                "and (mta.priority = :priority or :priority = '') " +
                "and (mta.taskId = :taskId or :taskId = 0) " +
              "order by mta.orderDate desc")
            .setInteger("officeId", officeId)
            .setInteger("taskStatusId", taskStatusId)
            .setInteger("tempId", tempId)
            .setString("priority", priority)
            .setInteger("taskId", taskId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  } 
  
  /**
   * Get task data by range, office and more
   * @param officeId
   * @param taskStatusId
   * @param tempId, template
   * @param priority, is priority (Y or N)
   * @param startDate
   * @param endDate
   * @param taskId
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of tasks based on given range, office and more (see parameters)
   */
  public List<MobileTaskAssignment> getByRangeOfficeAndOther(
          int officeId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mta " +
              "where mta.office.officeId = :officeId " +
                "and (mta.taskStatus.taskStatusId = :taskStatusId or :taskStatusId = 0) " +
                "and (mta.product.template.tempId = :tempId or :tempId = 0) " +
                "and (mta.priority = :priority or :priority = '') " +
                "and date_trunc('day',mta.assignmentDate) >= to_date(:startDate,'yyyy-mm-dd') " +
                "and date_trunc('day',mta.assignmentDate) <= to_date(:endDate,'yyyy-mm-dd') " +
                "and (mta.taskId = :taskId or :taskId = 0) " +
              "order by mta.orderDate desc")
            .setInteger("officeId", officeId)
            .setInteger("taskStatusId", taskStatusId)
            .setInteger("tempId", tempId)
            .setString("priority", priority)
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .setInteger("taskId", taskId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get task data by range, company and task status collection
   * @param coyId, company
   * @param taskStatusArr, task status code collection
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of tasks based on given range, company and task status collection
   */
  public List<MobileTaskAssignment> getByRangeCoyAndTaskStatusList(int coyId, String[] taskStatusArr, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mta " +
              "where mta.office.company.coyId = :coyId " +
                "and mta.taskStatus.taskStatusCode in :taskStatusArr " +
              "order by mta.orderDate desc")
            .setInteger("coyId", coyId)
            .setParameterList("taskStatusArr", taskStatusArr)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  } 
  
  /**
   * Get task data by range, company, order date (start and end date) and task status collection
   * @param coyId, company
   * @param startDate
   * @param endDate
   * @param taskStatusArr, task status code collection
   * @param taskId
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of tasks based on given range, company, order date and task status collection
   */
  public List<MobileTaskAssignment> getByRangeCoyOrderDateTaskStatusListAndTask(
          int coyId, String startDate, String endDate, String[] taskStatusArr, int taskId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mta " +
              "where mta.office.company.coyId = :coyId " +
                "and date_trunc('day',mta.orderDate) >= to_date(:startDate,'yyyy-mm-dd') " +
                "and date_trunc('day',mta.orderDate) <= to_date(:endDate,'yyyy-mm-dd') " +
                "and mta.taskStatus.taskStatusCode in :taskStatusArr " +
                "and (mta.taskId = :taskId or :taskId = 0) " +
              "order by mta.orderDate desc")
            .setInteger("coyId", coyId)
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .setInteger("taskId", taskId)
            .setParameterList("taskStatusArr", taskStatusArr)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  } 
  
  /**
   * Get number of task data by user and task status code
   * @param userId
   * @param taskStatusCode
   * @return count of tasks based on given user and task status code
   */
  public int countByUser(int userId, String taskStatusCode) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mta " +
              "where mta.user.userId = :userId " +
                "and mta.taskStatus.taskStatusCode = :taskStatusCode")
            .setInteger("userId", userId)
            .setString("taskStatusCode", taskStatusCode)
            .iterate().next()).intValue();
  } 
  
  /**
   * Get number of task data by user and more
   * @param userId
   * @param taskStatusId
   * @param tempId, template
   * @param priority, is priority (Y or N)
   * @param startDate
   * @param endDate
   * @param taskId
   * @return count of tasks based on given user and more (see the parameters)
   */
  public int countByUserAndOther(int userId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mta " +
              "where mta.user.userId = :userId " +
                "and (mta.taskStatus.taskStatusId = :taskStatusId or :taskStatusId = 0) " +
                "and (mta.product.template.tempId = :tempId or :tempId = 0) " +
                "and (mta.priority = :priority or :priority = '') " +
                "and date_trunc('day',mta.assignmentDate) >= to_date(:startDate,'yyyy-mm-dd') " +
                "and date_trunc('day',mta.assignmentDate) <= to_date(:endDate,'yyyy-mm-dd') " +
                "and (mta.taskId = :taskId or :taskId = 0)")
            .setInteger("userId", userId)
            .setInteger("taskStatusId", taskStatusId)
            .setInteger("tempId", tempId)
            .setString("priority", priority)
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .setInteger("taskId", taskId)
            .iterate().next()).intValue();
  } 
  
  /**
   * Get number of task data by superior and more
   * @param parentUserId
   * @param taskStatusId
   * @param tempId, template
   * @param priority, is priority (Y or N)
   * @param startDate
   * @param endDate
   * @param taskId
   * @return count of tasks based on given superior and more (see the parameters)
   */
  public int countByParentUserAndOther(int parentUserId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId) {
    return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery(
            "select count(*) from ( " +
              "select 1 from mobile_task_assignment mta, " +
                "master_product mp, " +
                "get_user_child(:parentUserId) child " +
                "where mta.user_id = child.user_id " +
                  "and mta.product_id = mp.product_id " +
                  "and (mta.task_status_id = :taskStatusId or :taskStatusId = 0) " +
                  "and (mp.temp_id = :tempId or :tempId = 0) " +
                  "and (mta.priority = :priority or :priority = '') " +
                  "and date_trunc('day',mta.assignment_date) >= to_date(:startDate,'yyyy-mm-dd') " +
                  "and date_trunc('day',mta.assignment_date) <= to_date(:endDate,'yyyy-mm-dd') " +
                  "and (mta.task_id = :taskId or :taskId = 0) " +
              "union all " +
              "select 1 from mobile_task_assignment mta, " +
                "master_product mp " +
                "where mta.product_id = mp.product_id " +
                  "and mta.user_id = :parentUserId " +
                  "and (mta.task_status_id = :taskStatusId or :taskStatusId = 0) " +
                  "and (mp.temp_id = :tempId or :tempId = 0) " +
                  "and (mta.priority = :priority or :priority = '') " +
                  "and date_trunc('day',mta.assignment_date) >= to_date(:startDate,'yyyy-mm-dd') " +
                  "and date_trunc('day',mta.assignment_date) <= to_date(:endDate,'yyyy-mm-dd') " +
                  "and (mta.task_id = :taskId or :taskId = 0)) mta")
            .setInteger("parentUserId",parentUserId)
            .setInteger("taskStatusId", taskStatusId)
            .setInteger("tempId", tempId)
            .setString("priority", priority)
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .setInteger("taskId", taskId)
            .list().get(0)).intValue();
  }
  
  /**
   * Get number of task data by superior and task status collection
   * @param parentUserId
   * @param taskStatusArr, task status code collection
   * @return count of tasks based on given superior and task status collection
   */
  public int countByParentUserAndTaskStatusList(int parentUserId, String[] taskStatusArr) {
    return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery(
            "select count(*) from ( " +
              "select 1 from mobile_task_assignment mta, " +
                "master_task_status mts, " +
                "get_user_child(:parentUserId) child " +
                "where mta.user_id = child.user_id " +
                  "and mta.task_status_id = mts.task_status_id " +
                  "and mts.task_status_code in (:taskStatusArr) " +
              "union all " +
              "select 1 from mobile_task_assignment mta, " +
                "master_task_status mts " +
                "where mta.task_status_id = mts.task_status_id " +
                  "and mta.user_id = :parentUserId " +
                  "and mts.task_status_code in (:taskStatusArr)) mta")
            .setInteger("parentUserId", parentUserId)
            .setParameterList("taskStatusArr", taskStatusArr)
            .list().get(0)).intValue();
  }
  
  /**
   * Get number of task data by superior, order date, task status collection and task
   * @param parentUserId
   * @param startDate
   * @param endDate
   * @param taskStatusArr, task status code collection
   * @param taskId
   * @return count of tasks based on given superior, order date, task status collection and task
   */
  public int countByParentUserOrderDateTaskStatusListAndTask(int parentUserId, String startDate, String endDate, String[] taskStatusArr, int taskId) {
    return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery(
            "select count(*) from ( " +
              "select 1 from mobile_task_assignment mta, " +
                "master_task_status mts, " +
                "get_user_child(:parentUserId) child " +
                "where mta.user_id = child.user_id " +
                  "and mta.task_id = (case when :taskId = 0 then mta.task_id else :taskId end) " +
                  "and mta.task_status_id = mts.task_status_id " +
                  "and mts.task_status_code in (:taskStatusArr) " +
                  "and mta.order_date >= to_date(:startDate,'yyyy-mm-dd') " +
                  "and mta.order_date <= to_date(:endDate,'yyyy-mm-dd') " +
              "union all " +
              "select 1 from mobile_task_assignment mta, " +
                "master_task_status mts " +
                "where mta.task_status_id = mts.task_status_id " +
                  "and mta.user_id = :parentUserId " +
                  "and mta.task_id = (case when :taskId = 0 then mta.task_id else :taskId end) " +
                  "and mts.task_status_code in (:taskStatusArr) " +
                  "and mta.order_date >= to_date(:startDate,'yyyy-mm-dd') " +
                  "and mta.order_date <= to_date(:endDate,'yyyy-mm-dd')) mta")
            .setInteger("parentUserId", parentUserId)
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .setInteger("taskId", taskId)
            .setParameterList("taskStatusArr", taskStatusArr)
            .list().get(0)).intValue();
  }
  
  /**
   * Get number of task data by user and task status collection
   * @param userId
   * @param taskStatusArr, task status code collection
   * @return count of tasks based on given user and task status collection
   */
  public int countByUserAndTaskStatusList(int userId, String[] taskStatusArr) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mta " +
              "where mta.user.userId = :userId " +
                "and mta.taskStatus.taskStatusCode in :taskStatusArr")
            .setInteger("userId", userId)
            .setParameterList("taskStatusArr", taskStatusArr)
            .iterate().next()).intValue();
  } 
  
  /**
   * Get number of task data by office and more
   * @param officeId
   * @param taskStatusId
   * @param tempId, template
   * @param priority, is priority (Y or N)
   * @param taskId
   * @return count of tasks based on given office and more (see the parameters)
   */
  public int countByOfficeAndOther(int officeId, int taskStatusId, int tempId, String priority, int taskId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mta " +
              "where mta.office.officeId = :officeId " +
                "and (mta.taskStatus.taskStatusId = :taskStatusId or :taskStatusId = 0) " +
                "and (mta.product.template.tempId = :tempId or :tempId = 0) " +
                "and (mta.priority = :priority or :priority = '') " +
                "and (mta.taskId = :taskId or :taskId = 0)")
            .setInteger("officeId", officeId)
            .setInteger("taskStatusId", taskStatusId)
            .setInteger("tempId", tempId)
            .setString("priority", priority)
            .setInteger("taskId", taskId)
            .iterate().next()).intValue();
  } 
  
  /**
   * Get number of task data by office and more
   * @param officeId
   * @param taskStatusId
   * @param tempId, template
   * @param priority, is priority (Y or N)
   * @param startDate
   * @param endDate
   * @param taskId
   * @return count of tasks based on given office and more (see the parameters)
   */
  public int countByOfficeAndOther(int officeId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mta " +
              "where mta.office.officeId = :officeId " +
                "and (mta.taskStatus.taskStatusId = :taskStatusId or :taskStatusId = 0) " +
                "and (mta.product.template.tempId = :tempId or :tempId = 0) " +
                "and (mta.priority = :priority or :priority = '') " +
                "and date_trunc('day',mta.assignmentDate) >= to_date(:startDate,'yyyy-mm-dd') " +
                "and date_trunc('day',mta.assignmentDate) <= to_date(:endDate,'yyyy-mm-dd') " +
                "and (mta.taskId = :taskId or :taskId = 0)")
            .setInteger("officeId", officeId)
            .setInteger("taskStatusId", taskStatusId)
            .setInteger("tempId", tempId)
            .setString("priority", priority)
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .setInteger("taskId", taskId)
            .iterate().next()).intValue();
  }
  
  /**
   * Get number of task data by company and task status collection
   * @param coyId, company
   * @param taskStatusArr, task status code collection
   * @return count of tasks based on given company and task status collection
   */
  public int countByCoyAndTaskStatusList(int coyId, String[] taskStatusArr) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mta " +
              "where mta.office.company.coyId = :coyId " +
                "and mta.taskStatus.taskStatusCode in :taskStatusArr")
            .setInteger("coyId", coyId)
            .setParameterList("taskStatusArr", taskStatusArr)
            .iterate().next()).intValue();
  }
  
  /**
   * Get number of task data by company, order date (start date and end date), task status collection and task
   * @param coyId, company
   * @param startDate
   * @param endDate
   * @param taskStatusArr, task status code collection
   * @param taskId
   * @return count of tasks based on given company, order date, task status collection and task
   */
  public int countByCoyOrderDateTaskStatusListAndTask(int coyId, String startDate, String endDate, String[] taskStatusArr, int taskId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mta " +
              "where mta.office.company.coyId = :coyId " +
                "and date_trunc('day',mta.orderDate) >= to_date(:startDate,'yyyy-mm-dd') " +
                "and date_trunc('day',mta.orderDate) <= to_date(:endDate,'yyyy-mm-dd') " +
                "and mta.taskStatus.taskStatusCode in :taskStatusArr " +
                "and (mta.taskId = :taskId or :taskId = 0)")
            .setInteger("coyId", coyId)
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .setInteger("taskId", taskId)
            .setParameterList("taskStatusArr", taskStatusArr)
            .iterate().next()).intValue();
  }
  
  /**
   * Get task data by office and role type code
   * @param officeId
   * @param roleTypeCode
   * @return list of tasks based on given office and role type code
   */
  public List<MobileTaskAssignment> getByOfficeAndRole(int officeId, String roleTypeCode) {
    return sessionFactory.getCurrentSession().createQuery(
            "select mta from " + domainClass.getName() + " mta " +
              "join mta.user.userRoles usrrol " +
              "where mta.user.office.officeId = :officeId " +
                "and usrrol.role.roleType.roleTypeCode = :roleTypeCode " +
                "and mta.taskStatus.taskStatusCode in ('ASSG','RETR','SURV','SUBM') " +
              "order by mta.user.userCode")
            .setInteger("officeId", officeId)
            .setString("roleTypeCode", roleTypeCode)
            .list();
  }
  
  /**
   * Get active task data by superior
   * @param parentUserId
   * @return list of active tasks based on given superior
   */
  public List<MobileTaskAssignment> getByParentUserAndActive(int parentUserId) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select mta.* from mobile_task_assignment mta, " +
              "master_task_status mts, " +
              "master_user mu, " +
              "get_user_child(:parentUserId) child " +
              "where mta.user_id = child.user_id " +
                "and mta.task_status_id = mts.task_status_id " +
                "and mta.user_id = mu.user_id " +
                "and mts.task_status_code in ('ASSG','RETR','SURV','SUBM') " +
              "order by mu.user_code")
            .addEntity(domainClass)
            .setInteger("parentUserId", parentUserId)
            .list();
  }
}
