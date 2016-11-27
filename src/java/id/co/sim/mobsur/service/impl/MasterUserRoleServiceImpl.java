/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterUserRole;
import id.co.sim.mobsur.dao.MasterUserRoleDAO;
import id.co.sim.mobsur.service.MasterUserRoleService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Apr 14, 2016
 * @author awal
 */
@Service("masterUserRoleService")
@Transactional(readOnly=true)
public class MasterUserRoleServiceImpl implements MasterUserRoleService {

  @Autowired
  private MasterUserRoleDAO masterUserRoleDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterUserRole save(MasterUserRole mur) {
    return masterUserRoleDAO.save(mur);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterUserRole delete(MasterUserRole mur) {
    return masterUserRoleDAO.delete(mur);
  }

  @Override
  public List<MasterUserRole> getPageByCoy(int coyId, int pageNo) {
    return masterUserRoleDAO.getRangeByCoy(coyId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterUserRole> getPageByCoyOfficeRoleUserNameDate(
          int coyId, int officeId, int roleId, String userNamePattern, String asOfDate,int pageNo) {
    return masterUserRoleDAO.getRangeByCoyOfficeRoleUserNameDate(
            coyId, officeId, roleId, userNamePattern, asOfDate, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByCoy(int coyId) {
    return masterUserRoleDAO.countByCoy(coyId);
  }

  @Override
  public int countByCoyOfficeRoleUserNameDate(int coyId, int officeId, int roleId, String userNamePattern, String asOfDate) {
    return masterUserRoleDAO.countByCoyOfficeRoleUserNameDate(coyId, officeId, roleId, userNamePattern, asOfDate);
  }
}
