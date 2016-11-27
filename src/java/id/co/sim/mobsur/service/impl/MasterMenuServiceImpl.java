/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterMenu;
import id.co.sim.mobsur.dao.MasterMenuDAO;
import id.co.sim.mobsur.service.MasterMenuService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Oct 14, 2016
 * @author awal
 */
@Service("masterMenuService")
@Transactional(readOnly=true)
public class MasterMenuServiceImpl implements MasterMenuService {

  @Autowired
  private MasterMenuDAO masterMenuDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public void save(MasterMenu mm) {
    masterMenuDAO.save(mm);
  }

  @Override
  @Transactional(readOnly=false)
  public void delete(MasterMenu mm) {
    masterMenuDAO.delete(mm);
  }

  @Override
  public MasterMenu getById(int id) {
    return masterMenuDAO.getById(id);
  }

  @Override
  public List<MasterMenu> getAll() {
    return masterMenuDAO.getAll();
  }

  @Override
  public List<MasterMenu> getByPage(int pageNo) {
    return masterMenuDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterMenu> getByPageParentMenuAndDate(int parentMenuId, int menuId, String asOfDate, int pageNo) {
    return masterMenuDAO.getByRangeParentMenuAndDate(parentMenuId, menuId, asOfDate, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterMenuDAO.count();
  }

  @Override
  public int countByParentMenuAndDate(int parentMenuId, int menuId, String asOfDate) {
    return masterMenuDAO.countByParentMenuAndDate(parentMenuId, menuId, asOfDate);
  }

  @Override
  public List<MasterMenu> getListMenuByUserId(int userId) {
    return masterMenuDAO.getListMenuByUserId(userId);
  }

  @Override
  public List<MasterMenu> getByRole(int roleId) {
    return masterMenuDAO.getByRole(roleId);
  }
}
