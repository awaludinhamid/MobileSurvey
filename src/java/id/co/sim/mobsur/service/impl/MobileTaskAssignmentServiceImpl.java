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
 * @created Feb 2, 2017
 * @author awal
 */
@Service("mobileTaskAssignmentService")
@Transactional(readOnly=true)
public class MobileTaskAssignmentServiceImpl implements MobileTaskAssignmentService {

  @Autowired
  private MobileTaskAssignmentDAO mobileTaskAssignmentDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

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
  public List<MobileTaskAssignment> getByPageUser(int userId, int pageNo) {
    return mobileTaskAssignmentDAO.getByRangeUser(userId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByUser(int userId) {
    return mobileTaskAssignmentDAO.countByUser(userId);
  }

  @Override
  public List<MobileTaskAssignment> getByPageParentUser(int parentUserId, int pageNo) {
    return mobileTaskAssignmentDAO.getByRangeParentUser(parentUserId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByParentUser(int parentUserId) {
    return mobileTaskAssignmentDAO.countByParentUser(parentUserId);
  }

  @Override
  public MobileTaskAssignment getById(int taskId) {
    return mobileTaskAssignmentDAO.getById(taskId);
  }
}
