/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterRole;
import id.co.sim.mobsur.dao.MasterRoleDAO;
import id.co.sim.mobsur.service.MasterRoleService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Apr 4, 2016
 * @author awal
 */
@Service("masterRoleService")
@Transactional(readOnly=true)
public class MasterRoleServiceImpl implements MasterRoleService {

  @Autowired
  private MasterRoleDAO masterRoleDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public void save(MasterRole mr) {
    masterRoleDAO.save(mr);
  }

  @Override
  @Transactional(readOnly=false)
  public void delete(MasterRole mr) {
    masterRoleDAO.delete(mr);
  }

  @Override
  public MasterRole getById(int id) {
    return masterRoleDAO.getById(id);
  }

  @Override
  public List<MasterRole> getAll() {
    return masterRoleDAO.getAll();
  }

  @Override
  public List<MasterRole> getByPage(int pageNo) {
    return masterRoleDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterRole> getByPageRoleAndDate(int roleId, String asOfDate, int pageNo) {
    return masterRoleDAO.getByRangeRoleAndDate(roleId, asOfDate, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterRoleDAO.count();
  }

  @Override
  public int countByRoleAndDate(int roleId, String asOfDate) {
    return masterRoleDAO.countByRoleAndDate(roleId, asOfDate);
  }
  
  @Override
  public List<MasterRole> getRolesByUser(int userId) {
    return masterRoleDAO.getRolesByUser(userId);
  }

  @Override
  public List<MasterRole> getForClientRole() {
    return masterRoleDAO.getForClientRole();
  }
}
