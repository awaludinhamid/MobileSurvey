/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MobileTaskResultDetailList;
import id.co.sim.mobsur.dao.MobileTaskResultDetailListDAO;
import id.co.sim.mobsur.service.MobileTaskResultDetailListService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**	
 * Result detail list service implementation (see the service for usage info)
 * @author awal
 * @created Feb 19, 2017
 */
@Service("mobileTaskResultDetailList")
@Transactional(readOnly=true)
public class MobileTaskResultDetailListServiceImpl implements MobileTaskResultDetailListService {

  @Autowired
  private MobileTaskResultDetailListDAO mobileTaskResultDetailListDAO;// DAO injection

  @Override
  @Transactional(readOnly=false)
  public MobileTaskResultDetailList save(MobileTaskResultDetailList resultDetailList) {
    return mobileTaskResultDetailListDAO.save(resultDetailList);
  }

  @Override
  public MobileTaskResultDetailList getById(int taskResultDetListId) {
    return mobileTaskResultDetailListDAO.getById(taskResultDetListId);
  }

  @Override
  public List<MobileTaskResultDetailList> getByTask(int taskId) {
    return mobileTaskResultDetailListDAO.getByTask(taskId);
  }

  @Override
  public List<MobileTaskResultDetailList> getByTaskResultHasImage(int taskResultId) {
    return mobileTaskResultDetailListDAO.getByTaskResultHasImage(taskResultId);
  }

  @Override
  public void save(List<MobileTaskResultDetailList> resultDetailListList, int numOfBulkRecord) {
    mobileTaskResultDetailListDAO.save(resultDetailListList, numOfBulkRecord);
  }
}
