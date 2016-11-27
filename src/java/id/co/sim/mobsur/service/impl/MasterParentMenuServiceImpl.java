/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterParentMenu;
import id.co.sim.mobsur.dao.MasterParentMenuDAO;
import id.co.sim.mobsur.service.MasterParentMenuService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Oct 14, 2016
 * @author awal
 */
@Service("masterParentMenuService")
@Transactional(readOnly=true)
public class MasterParentMenuServiceImpl implements MasterParentMenuService {

  @Autowired
  private MasterParentMenuDAO masterParentMenuDAO;

  @Override
  public void save(MasterParentMenu mpm) {
    masterParentMenuDAO.save(mpm);
  }

  @Override
  public void delete(MasterParentMenu mpm) {
    masterParentMenuDAO.delete(mpm);
  }

  @Override
  public MasterParentMenu getById(int id) {
    return masterParentMenuDAO.getById(id);
  }

  @Override
  public List<MasterParentMenu> getAll() {
    return masterParentMenuDAO.getAll();
  }

  @Override
  public List<MasterParentMenu> getByPage(int pageNo) {
    int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();
    return masterParentMenuDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }
}
