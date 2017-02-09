/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterHierarchy;
import id.co.sim.mobsur.dao.MasterHierarchyDAO;
import id.co.sim.mobsur.service.MasterHierarchyService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Nov 29, 2016
 * @author awal
 */
@Service("masterHierarchyService")
@Transactional(readOnly=true)
public class MasterHierarchyServiceImpl implements MasterHierarchyService {

  @Autowired
  private MasterHierarchyDAO masterHierarchyDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterHierarchy save(MasterHierarchy mh) {
    return masterHierarchyDAO.save(mh);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterHierarchy delete(MasterHierarchy mh) {
    return masterHierarchyDAO.delete(mh);
  }

  @Override
  public List<MasterHierarchy> getByPage(int pageNo) {
    return masterHierarchyDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterHierarchy> getByPageCoyRoleAndRoleUp(int coyId, int roleId, int roleIdUp, int pageNo) {
    return masterHierarchyDAO.getByRangeCoyRoleAndRoleUp(coyId, roleId, roleIdUp, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterHierarchyDAO.count();
  }

  @Override
  public int countByCoyRoleAndRoleUp(int coyId, int roleId, int roleIdUp) {
    return masterHierarchyDAO.countByCoyRoleAndRoleUp(coyId, roleId, roleIdUp);
  }
}
