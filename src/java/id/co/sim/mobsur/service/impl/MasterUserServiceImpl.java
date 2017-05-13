/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterUser;
import id.co.sim.mobsur.dao.MasterUserDAO;
import id.co.sim.mobsur.service.MasterUserService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**	
 * User service implementation (see the service for usage info)
 * @created Apr 4, 2016
 * @author awal
 */
@Service("masterUserService")
@Transactional(readOnly=true)
public class MasterUserServiceImpl implements MasterUserService {

  @Autowired
  private MasterUserDAO masterUserDAO;// DAO injection
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();//number of records per page (paging)

  @Override
  @Transactional(readOnly=false)
  public MasterUser save(MasterUser mu) {
    return masterUserDAO.save(mu);
  }

  @Override
  @Transactional(readOnly=false)
  public void delete(MasterUser mu) {
    masterUserDAO.delete(mu);
  }

  @Override
  public MasterUser getById(int id) {
    return masterUserDAO.getById(id);
  }

  @Override
  public MasterUser getByCode(String userCode) {
    return masterUserDAO.getByCode(userCode);
  }

  @Override
  public String getPassByUser(String userCode) {
    return masterUserDAO.getPassByUser(userCode);
  }

  @Override
  public List<MasterUser> getAll() {
    return masterUserDAO.getAll(); 
  }

  @Override
  public List<MasterUser> getByPageCompany(int coyId, int pageNo) {
    return masterUserDAO.getByRangeCompany(coyId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterUser> getByPageCompanyUserNameAndDate(int coyId, String userCode, String userName, String asOfDate, int pageNo) {
    return masterUserDAO.getByRangeCompanyUserNameAndDate(coyId, userCode, userName, asOfDate, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count(int coyId) {
    return masterUserDAO.count(coyId);
  }

  @Override
  public int countByCompanyUserNameAndDate(int coyId, String userCode, String userName, String asOfDate) {
    return masterUserDAO.countByCompanyUserNameAndDate(coyId, userCode, userName, asOfDate);
  }

  @Override
  public List<MasterUser> getByCompany(int coyId) {
    return masterUserDAO.getByCompany(coyId);
  }

  @Override
  public List<MasterUser> getByOffice(int officeId) {
    return masterUserDAO.getByOffice(officeId);
  }

  @Override
  public MasterUser getByCodeAndCoy(String userName, String coyCode) {
    return masterUserDAO.getByCodeAndCoy(userName, coyCode);
  }

  @Override
  public List<MasterUser> getByRoleCoy(int roleId, int coyId) {
    return masterUserDAO.getByRoleCoy(roleId, coyId);
  }

  @Override
  public List<MasterUser> getByCoyAsVerificator(int coyId) {
    return masterUserDAO.getByCoyAsVerificator(coyId);
  }

  @Override
  public List<MasterUser> getByCoyAndUserChildRole(int coyId, int parentRoleId) {
    return masterUserDAO.getByCoyAndUserChildRole(coyId, parentRoleId);
  }

  @Override
  public int countByCoyAndUserChildRole(int coyId, int parentRoleId) {
    return masterUserDAO.countByCoyAndUserChildRole(coyId, parentRoleId);
  }

  @Override
  public List<MasterUser> getByParentUser(int parentUserId) {
    return masterUserDAO.getByParentUser(parentUserId);
  }

  @Override
  public List<MasterUser> getByRoleAndParentUser(int roleTypeId, int parentUserId) {
    return masterUserDAO.getByRoleAndParentUser(roleTypeId, parentUserId);
  }

  @Override
  public List<MasterUser> getByOfficeAndRoleTypeCode(int officeId, String roleTypeCode) {
    return masterUserDAO.getByOfficeAndRoleTypeCode(officeId, roleTypeCode);
  }

  @Override
  public List<MasterUser> getByRoleOffice(int roleId, int officeId) {
    return masterUserDAO.getByRoleOffice(roleId, officeId);
  }
}
