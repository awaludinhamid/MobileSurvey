/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterOffice;
import id.co.sim.mobsur.dao.MasterOfficeDAO;
import id.co.sim.mobsur.service.MasterOfficeService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Nov 3, 2016
 * @author awal
 */
@Service("masterOfficeService")
@Transactional(readOnly=true)
public class MasterOfficeServiceImpl implements MasterOfficeService {

  @Autowired
  private MasterOfficeDAO masterOfficeDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterOffice save(MasterOffice mo) {
    return masterOfficeDAO.save(mo);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterOffice delete(MasterOffice mo) {
    return masterOfficeDAO.delete(mo);
  }

  @Override
  public List<MasterOffice> getAll() {
    return masterOfficeDAO.getAll();
  }

  @Override
  public MasterOffice getById(int id) {
    return masterOfficeDAO.getById(id);
  }

  @Override
  public List<MasterOffice> getByPageCompany(int coyId, int pageNo) {
    return masterOfficeDAO.getByRangeCompany(coyId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterOffice> getByPageCompanyOfficeCodeNameAndDate(
          int coyId, String officeCodePattern, String officeNamePattern, String asOfDate, int pageNo) {
    return masterOfficeDAO.getByRangeCompanyOfficeCodeNameAndDate(
            coyId, officeCodePattern, officeNamePattern, asOfDate, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count(int coyId) {
    return masterOfficeDAO.count(coyId);
  }

  @Override
  public int countByCompanyOfficeCodeNameAndDate(int coyId, String officeCodePattern, String officeNamePattern, String asOfDate) {
    return masterOfficeDAO.countByCompanyOfficeCodeNameAndDate(coyId, officeCodePattern, officeNamePattern, asOfDate);
  }

  @Override
  public List<MasterOffice> getByCompany(int coyId) {
    return masterOfficeDAO.getByCompany(coyId);
  }
}
