/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterRoleMenu;
import id.co.sim.mobsur.dao.MasterRoleMenuDAO;
import id.co.sim.mobsur.service.MasterRoleMenuService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Oct 16, 2016
 * @author awal
 */
@Service("masterRoleMenuService")
@Transactional(readOnly=true) 
public class MasterRoleMenuServiceImpl implements MasterRoleMenuService {

  @Autowired
  private MasterRoleMenuDAO masterRoleMenuDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterRoleMenu save(MasterRoleMenu mrm) {
    return masterRoleMenuDAO.save(mrm);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterRoleMenu delete(MasterRoleMenu mrm) {
    return masterRoleMenuDAO.delete(mrm);
  }

  @Override
  public List<MasterRoleMenu> getAll() {
    return masterRoleMenuDAO.getAll();
  }

  @Override
  public List<MasterRoleMenu> getByPage(int pageNo) {
    return masterRoleMenuDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterRoleMenu> getByRoleId(int roleId) {
    return masterRoleMenuDAO.getByRoleId(roleId);
  }

  @Override
  public List<MasterRoleMenu> getByPageRoleMenuAndDate(int roleId, int menuId, String asOfDate, int pageNo) {
    return masterRoleMenuDAO.getByRangeRoleMenuAndDate(roleId, menuId, asOfDate, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByRoleMenuAndDate(int roleId, int menuId, String asOfDate) {
    return masterRoleMenuDAO.countByRoleMenuAndDate(roleId, menuId, asOfDate);
  }
  
  @Override
  public int count() {
    return masterRoleMenuDAO.count();
  }
}
