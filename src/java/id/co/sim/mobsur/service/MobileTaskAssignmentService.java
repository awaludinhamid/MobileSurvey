/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MobileTaskAssignment;
import java.util.List;

/**
 * SPI of task module
 * @created Feb 2, 2017
 * @author awal
 */
public interface MobileTaskAssignmentService {

  /**
   * Save given task
   * @param task
   * @return saved task
   */
  MobileTaskAssignment save(MobileTaskAssignment task);
  
  /**
   * Get task by id
   * @param taskId
   * @return task based on given id
   */
  MobileTaskAssignment getById(int taskId);
  
  /**
   * Get all task data
   * @return list of all tasks
   */
  List<MobileTaskAssignment> getAll();
  
  /**
   * Get task data by page
   * @param pageNo, page number to proceed
   * @return list of tasks based on given page
   */
  List<MobileTaskAssignment> getByPage(int pageNo);
  
  /**
   * Get task data by page, user and task status code
   * @param userId
   * @param taskStatusCode, task status code collection
   * @param pageNo, page number to proceed
   * @return list of tasks based on given page, user and task status code
   */
  List<MobileTaskAssignment> getByPageUser(int userId, String taskStatusCode, int pageNo);
  
  /**
   * Get task data by page, user and more
   * @param userId
   * @param taskStatusId
   * @param tempId, template
   * @param priority, is priority (Y or N)
   * @param startDate
   * @param endDate
   * @param taskId
   * @param pageNo, page number to proceed
   * @return list of tasks based on given page, user and more (see parameters)
   */
  List<MobileTaskAssignment> getByPageUserAndOther(int userId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId, int pageNo);
  
  /**
   * Get task data by page, superior and more
   * @param parentUserId
   * @param taskStatusId
   * @param tempId, template
   * @param priority, is priority (Y or N)
   * @param startDate
   * @param endDate
   * @param taskId
   * @param pageNo, page number to proceed
   * @return list of tasks based on given page, superior and more (see parameters)
   */
  List<MobileTaskAssignment> getByPageParentUserAndOther(int parentUserId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId, int pageNo);
  
  /**
   * Get task data by page, user and task status collection
   * @param userId
   * @param taskStatusArr, task status code collection
   * @param pageNo, page number to proceed
   * @return list of tasks based on given page, user and task status collection
   */
  List<MobileTaskAssignment> getByPageUserAndTaskStatusList(int userId, String[] taskStatusArr, int pageNo);
  
  /**
   * Get task data by page, superior and task status collection
   * @param parentUserId
   * @param taskStatusArr, task status code collection
   * @param pageNo, page number to proceed
   * @return list of tasks based on given page, superior and task status collection
   */
  List<MobileTaskAssignment> getByPageParentUserAndTaskStatusList(int parentUserId, String[] taskStatusArr, int pageNo);
  
  /**
   * Get task data by page, superior, task status collection and task
   * @param parentUserId
   * @param startDate
   * @param endDate
   * @param taskStatusArr, task status code collection
   * @param taskId
   * @param pageNo, page number to proceed
   * @return list of tasks based on given page, superior, task status collection and task
   */
  List<MobileTaskAssignment> getByPageParentUserOrderDateTaskStatusListAndTask(
          int parentUserId, String startDate, String endDate, String[] taskStatusArr, int taskId, int pageNo);
  
  /**
   * Get task data by page, office and more
   * @param officeId
   * @param taskStatusId
   * @param tempId, template
   * @param priority, is priority (Y or N)
   * @param taskId
   * @param pageNo, page number to proceed
   * @return list of tasks based on given page, office and more (see parameters)
   */
  List<MobileTaskAssignment> getByPageOfficeAndOther(int officeId, int taskStatusId, int tempId, String priority, int taskId, int pageNo);
  
  /**
   * Get task data by page, office and more
   * @param officeId
   * @param taskStatusId
   * @param tempId, template
   * @param priority, is priority (Y or N)
   * @param startDate
   * @param endDate
   * @param taskId
   * @param pageNo, page number to proceed
   * @return list of tasks based on given page, office and more (see parameters)
   */
  List<MobileTaskAssignment> getByPageOfficeAndOther(int officeId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId, int pageNo);
  
  /**
   * Get task data by page, company and task status collection
   * @param coyId, company
   * @param taskStatusArr, task status code collection
   * @param pageNo, page number to proceed
   * @return list of tasks based on given page, company and task status collection
   */
  List<MobileTaskAssignment> getByPageCoyAndTaskStatusList(int coyId, String[] taskStatusArr, int pageNo);
  
  /**
   * Get task data by page, company, order date (start and end date) and task status collection
   * @param coyId, company
   * @param startDate
   * @param endDate
   * @param taskStatusArr, task status code collection
   * @param taskId
   * @param pageNo, page number to proceed
   * @return list of tasks based on given page, company, order date and task status collection
   */
  List<MobileTaskAssignment> getByPageCoyOrderDateTaskStatusListAndTask(int coyId, String startDate, String endDate, String[] taskStatusArr, int taskId, int pageNo);
  
  /**
   * Get number of all task data
   * @return count of all tasks
   */
  int count();
  
  /**
   * Get number of task data by user and task status code
   * @param userId
   * @param taskStatusCode
   * @return count of tasks based on given user and task status code
   */
  int countByUser(int userId, String taskStatusCode);
  
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
  int countByUserAndOther(int userId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId);
  
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
  int countByParentUserAndOther(int parentUserId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId);
  
  /**
   * Get number of task data by user and task status collection
   * @param userId
   * @param taskStatusArr, task status code collection
   * @return count of tasks based on given user and task status collection
   */
  int countByUserAndTaskStatusList(int userId, String[] taskStatusArr);
  
  /**
   * Get number of task data by superior and task status collection
   * @param parentUserId
   * @param taskStatusArr, task status code collection
   * @return count of tasks based on given superior and task status collection
   */
  int countByParentUserAndTaskStatusList(int parentUserId, String[] taskStatusArr);
  
  /**
   * Get number of task data by superior, order date, task status collection and task
   * @param parentUserId
   * @param startDate
   * @param endDate
   * @param taskStatusArr, task status code collection
   * @param taskId
   * @return count of tasks based on given superior, order date, task status collection and task
   */
  int countByParentUserOrderDateTaskStatusListAndTask(int parentUserId, String startDate, String endDate, String[] taskStatusArr, int taskId);
  
  /**
   * Get number of task data by office and more
   * @param officeId
   * @param taskStatusId
   * @param tempId, template
   * @param priority, is priority (Y or N)
   * @param taskId
   * @return count of tasks based on given office and more (see the parameters)
   */
  int countByOfficeAndOther(int officeId, int taskStatusId, int tempId, String priority, int taskId);
  
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
  int countByOfficeAndOther(int officeId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId);
  
  /**
   * Get number of task data by company and task status collection
   * @param coyId, company
   * @param taskStatusArr, task status code collection
   * @return count of tasks based on given company and task status collection
   */
  int countByCoyAndTaskStatusList(int coyId, String[] taskStatusArr);
  
  /**
   * Get number of task data by company, order date (start date and end date), task status collection and task
   * @param coyId, company
   * @param startDate
   * @param endDate
   * @param taskStatusArr, task status code collection
   * @param taskId
   * @return count of tasks based on given company, order date, task status collection and task
   */
  int countByCoyOrderDateTaskStatusListAndTask(int coyId, String startDate, String endDate, String[] taskStatusArr, int taskId);
  
  /**
   * Get task data by office and role type code
   * @param officeId
   * @param roleTypeCode
   * @return list of tasks based on given office and role type code
   */
  List<MobileTaskAssignment> getByOfficeAndRole(int officeId, String roleTypeCode);
  
  /**
   * Get active task data by superior
   * @param parentUserId
   * @return list of active tasks based on given superior
   */
  List<MobileTaskAssignment> getByParentUserAndActive(int parentUserId);
}
