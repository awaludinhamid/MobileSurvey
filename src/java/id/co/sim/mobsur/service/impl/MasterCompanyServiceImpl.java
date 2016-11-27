/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterCompany;
import id.co.sim.mobsur.dao.MasterCompanyDAO;
import id.co.sim.mobsur.service.MasterCompanyService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Oct 12, 2016
 * @author awal
 */
@Service("masterCompanyService")
@Transactional(readOnly=true)
public class MasterCompanyServiceImpl implements MasterCompanyService {

  @Autowired
  private MasterCompanyDAO masterCompanyDAO;  
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterCompany save(MasterCompany mc) {
    return masterCompanyDAO.save(mc);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterCompany delete(MasterCompany mc) {
    return masterCompanyDAO.delete(mc);
  }

  @Override
  public MasterCompany getById(int id) {
    return masterCompanyDAO.getById(id);
  }

  @Override
  public List<MasterCompany> getAll() {
    return masterCompanyDAO.getAll();
  }

  @Override
  public List<MasterCompany> getByPage(int pageNo) {
    return masterCompanyDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterCompany> getByPageCodeAndNamePattern(String coyCodePattern, String coyNamePattern, int pageNo) {
    return masterCompanyDAO.getByRangeCodeAndNamePattern(coyCodePattern, coyNamePattern, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterCompanyDAO.count();
  }

  @Override
  public int countByCodeAndNamePattern(String coyCodePattern, String coyNamePattern) {
    return masterCompanyDAO.countByCodeAndNamePattern(coyCodePattern, coyNamePattern);
  }

  @Override
  public MasterCompany getValidCoyByUserId(int userId) {
    return masterCompanyDAO.getValidCoyByUserId(userId);
  }
}
