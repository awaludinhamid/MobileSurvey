/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MobileTaskAssignment;
import id.co.sim.mobsur.dao.MobileTaskAssignmentDAO;
import id.co.sim.mobsur.service.MobileTaskAssignmentService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**	
 * Task service implementation (see the service for usage info)
 * @created Feb 2, 2017
 * @author awal
 */
@Service("mobileTaskAssignmentService")
@Transactional(readOnly=true)
public class MobileTaskAssignmentServiceImpl implements MobileTaskAssignmentService {

  @Autowired
  private MobileTaskAssignmentDAO mobileTaskAssignmentDAO;// DAO injection
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();//number of records per page (paging)

  @Override
  @Transactional(readOnly=false)
  public MobileTaskAssignment save(MobileTaskAssignment task) {
    return mobileTaskAssignmentDAO.save(task);
  }

  @Override
  public List<MobileTaskAssignment> getAll() {
    return mobileTaskAssignmentDAO.getAll();
  }

  @Override
  public List<MobileTaskAssignment> getByPage(int pageNo) {
    return mobileTaskAssignmentDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return mobileTaskAssignmentDAO.count();
  }

  @Override
  public List<MobileTaskAssignment> getByPageUser(int userId, String taskStatusCode, int pageNo) {
    return mobileTaskAssignmentDAO.getByRangeUser(userId, taskStatusCode, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MobileTaskAssignment> getByPageUserAndOther(int userId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId, int pageNo) {
    return mobileTaskAssignmentDAO.getByRangeUserAndOther(userId, taskStatusId, tempId, priority, startDate, endDate, taskId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByUser(int userId, String taskStatusCode) {
    return mobileTaskAssignmentDAO.countByUser(userId, taskStatusCode);
  }

  @Override
  public int countByUserAndOther(int userId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId) {
    return mobileTaskAssignmentDAO.countByUserAndOther(userId, taskStatusId, tempId, priority, startDate, endDate, taskId);
  }

  @Override
  public List<MobileTaskAssignment> getByPageParentUserAndOther(
          int parentUserId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId, int pageNo) {
    return mobileTaskAssignmentDAO.getByRangeParentUserAndOther(parentUserId, taskStatusId, tempId, priority, startDate, endDate, taskId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByParentUserAndOther(int parentUserId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId) {
    return mobileTaskAssignmentDAO.countByParentUserAndOther(parentUserId, taskStatusId, tempId, priority, startDate, endDate, taskId);
  }

  @Override
  public MobileTaskAssignment getById(int taskId) {
    return mobileTaskAssignmentDAO.getById(taskId);
  }

  @Override
  public List<MobileTaskAssignment> getByOfficeAndRole(int officeId, String roleTypeCode) {
    return mobileTaskAssignmentDAO.getByOfficeAndRole(officeId, roleTypeCode);
  }

  @Override
  public List<MobileTaskAssignment> getByPageUserAndTaskStatusList(int userId, String[] taskStatusArr, int pageNo) {
    return mobileTaskAssignmentDAO.getByRangeUserAndTaskStatusList(userId, taskStatusArr, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByUserAndTaskStatusList(int userId, String[] taskStatusArr) {
    return mobileTaskAssignmentDAO.countByUserAndTaskStatusList(userId, taskStatusArr);
  }

  @Override
  public List<MobileTaskAssignment> getByPageParentUserOrderDateTaskStatusListAndTask(
          int parentUserId, String startDate, String endDate, String[] taskStatusArr, int taskId, int pageNo) {
    return mobileTaskAssignmentDAO.getByRangeParentUserOrderDateTaskStatusListAndTask(
            parentUserId, startDate, endDate, taskStatusArr, taskId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByParentUserOrderDateTaskStatusListAndTask(
          int parentUserId, String startDate, String endDate, String[] taskStatusArr, int taskId) {
    return mobileTaskAssignmentDAO.countByParentUserOrderDateTaskStatusListAndTask(parentUserId, startDate, endDate, taskStatusArr, taskId);
  }

  @Override
  public List<MobileTaskAssignment> getByPageParentUserAndTaskStatusList(int parentUserId, String[] taskStatusArr, int pageNo) {
    return mobileTaskAssignmentDAO.getByRangeParentUserAndTaskStatusList(parentUserId, taskStatusArr, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByParentUserAndTaskStatusList(int parentUserId, String[] taskStatusArr) {
    return mobileTaskAssignmentDAO.countByParentUserAndTaskStatusList(parentUserId, taskStatusArr);
  }

  @Override
  public List<MobileTaskAssignment> getByParentUserAndActive(int parentUserId) {
    return mobileTaskAssignmentDAO.getByParentUserAndActive(parentUserId);
  }

  @Override
  public List<MobileTaskAssignment> getByPageOfficeAndOther(int officeId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId, int pageNo) {
    return mobileTaskAssignmentDAO.getByRangeOfficeAndOther(officeId, taskStatusId, tempId, priority, startDate, endDate, taskId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByOfficeAndOther(int officeId, int taskStatusId, int tempId, String priority, String startDate, String endDate, int taskId) {
    return mobileTaskAssignmentDAO.countByOfficeAndOther(officeId, taskStatusId, tempId, priority, startDate, endDate, taskId);
  }

  @Override
  public List<MobileTaskAssignment> getByPageCoyAndTaskStatusList(int coyId, String[] taskStatusArr, int pageNo) {
    return mobileTaskAssignmentDAO.getByRangeCoyAndTaskStatusList(coyId, taskStatusArr, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MobileTaskAssignment> getByPageCoyOrderDateTaskStatusListAndTask(int coyId, String startDate, String endDate, String[] taskStatusArr, int taskId, int pageNo) {
    return mobileTaskAssignmentDAO.getByRangeCoyOrderDateTaskStatusListAndTask(coyId, startDate, endDate, taskStatusArr, taskId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByCoyAndTaskStatusList(int coyId, String[] taskStatusArr) {
    return mobileTaskAssignmentDAO.countByCoyAndTaskStatusList(coyId, taskStatusArr);
  }

  @Override
  public int countByCoyOrderDateTaskStatusListAndTask(int coyId, String startDate, String endDate, String[] taskStatusArr, int taskId) {
    return mobileTaskAssignmentDAO.countByCoyOrderDateTaskStatusListAndTask(coyId, startDate, endDate, taskStatusArr, taskId);
  }

  @Override
  public List<MobileTaskAssignment> getByPageOfficeAndOther(int officeId, int taskStatusId, int tempId, String priority, int taskId, int pageNo) {
    return mobileTaskAssignmentDAO.getByRangeOfficeAndOther(officeId, taskStatusId, tempId, priority, taskId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByOfficeAndOther(int officeId, int taskStatusId, int tempId, String priority, int taskId) {
    return mobileTaskAssignmentDAO.countByOfficeAndOther(officeId, taskStatusId, tempId, priority, taskId);
  }
}
