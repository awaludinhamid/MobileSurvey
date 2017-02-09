/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterAbsence;
import id.co.sim.mobsur.dao.MasterAbsenceDAO;
import id.co.sim.mobsur.service.MasterAbsenceService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Jan 26, 2017
 * @author awal
 */
@Service("masterAbsenceService")
@Transactional(readOnly=true)
public class MasterAbsenceServiceImpl implements MasterAbsenceService {

  @Autowired
  private MasterAbsenceDAO masterAbsenceDAO; 
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterAbsence save(MasterAbsence absence) {
    return masterAbsenceDAO.save(absence);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterAbsence delete(MasterAbsence absence) {
    return masterAbsenceDAO.delete(absence);
  }

  @Override
  public List<MasterAbsence> getByPageCoy(int coyId, int pageNo) {
    return masterAbsenceDAO.getByRangeCoy(coyId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterAbsence> getByPageUserReasonStartAndEndDate(int userId, int reasonTypeId, String startDate, String endDate, int pageNo) {
    return masterAbsenceDAO.getByRangeUserReasonStartAndEndDate(userId, reasonTypeId, startDate, endDate, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByCoy(int coyId) {
    return masterAbsenceDAO.countByCoy(coyId);
  }

  @Override
  public int countByUserReasonStartAndEndDate(int userId, int reasonTypeId, String startDate, String endDate) {
    return masterAbsenceDAO.countByUserReasonStartAndEndDate(userId, reasonTypeId, startDate, endDate);
  }

  @Override
  public List<MasterAbsence> getByPageParentUser(int parentUserId, int pageNo) {
    return masterAbsenceDAO.getByRangeParentUser(parentUserId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByParentUser(int parentUserId) {
    return masterAbsenceDAO.countByParentUser(parentUserId);
  }

  @Override
  public List<MasterAbsence> getByPageParentUserReasonStartAndEndDate(int parentUserId, int userId, int reasonTypeId, String startDate, String endDate, int pageNo) {
    return masterAbsenceDAO.getByRangeParentUserReasonStartAndEndDate(
            parentUserId, userId, reasonTypeId, startDate, endDate, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByParentUserReasonStartAndEndDate(int parentUserId, int userId, int reasonTypeId, String startDate, String endDate) {
    return masterAbsenceDAO.countByParentUserReasonStartAndEndDate(parentUserId, userId, reasonTypeId, startDate, endDate);
  }
}
