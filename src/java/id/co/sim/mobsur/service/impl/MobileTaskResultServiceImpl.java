/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MobileTaskResult;
import id.co.sim.mobsur.bean.support.CoordinateBean;
import id.co.sim.mobsur.dao.MobileTaskResultDAO;
import id.co.sim.mobsur.service.MobileTaskResultService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**	
 * Result service implementation (see the service for usage info)
 * @created Feb 13, 2017
 * @author awal
 */
@Service("mobileTaskResultService")
@Transactional(readOnly=true)
public class MobileTaskResultServiceImpl implements MobileTaskResultService {

  @Autowired
  private MobileTaskResultDAO mobileTaskResultDAO;// DAO injection
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();//number of records per page (paging)

  @Override
  public MobileTaskResult save(MobileTaskResult mtr) {
    return mobileTaskResultDAO.save(mtr);
  }

  @Override
  public void delete(MobileTaskResult mtr) {
    mobileTaskResultDAO.delete(mtr);
  }

  @Override
  public List<MobileTaskResult> getByPageCoordAndTaskStatus(int coordId, String taskStatusCode, int pageNo) {
    return mobileTaskResultDAO.getByRangeCoordAndTaskStatus(coordId, taskStatusCode, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MobileTaskResult> getByPageVerifAndTaskStatus(int verifId, String taskStatusCode, int pageNo) {
    return mobileTaskResultDAO.getByRangeVerifAndTaskStatus(verifId, taskStatusCode, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByCoordAndTaskStatus(int coordId, String taskStatusCode) {
    return mobileTaskResultDAO.countByCoordAndTaskStatus(coordId, taskStatusCode);
  }

  @Override
  public int countByVerifAndTaskStatus(int verifId, String taskStatusCode) {
    return mobileTaskResultDAO.countByVerifAndTaskStatus(verifId, taskStatusCode);
  }

  @Override
  public List<CoordinateBean> getCoordinateByVerifAssignDateAndGps(int verifId, String startDate, String endDate, String isGps) {
    return mobileTaskResultDAO.getCoordinateByVerifAssignDateAndGps(verifId, startDate, endDate, isGps);
  }

  @Override
  public MobileTaskResult getByTaskIsLast(int taskId) {
    return mobileTaskResultDAO.getByTaskIsLast(taskId);
  }
}
