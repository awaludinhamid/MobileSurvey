/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterZipcode;
import id.co.sim.mobsur.dao.MasterZipcodeDAO;
import id.co.sim.mobsur.service.MasterZipcodeService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Nov 26, 2016
 * @author awal
 */
@Service("masterZipcodeService")
@Transactional(readOnly=true)
public class MasterZipcodeServiceImpl implements MasterZipcodeService {

  @Autowired
  private MasterZipcodeDAO masterZipcodeDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterZipcode save(MasterZipcode mz) {
    return masterZipcodeDAO.save(mz);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterZipcode delete(MasterZipcode mz) {
    return masterZipcodeDAO.delete(mz);
  }

  @Override
  public MasterZipcode getById(int id) {
    return masterZipcodeDAO.getById(id);
  }

  @Override
  public List<MasterZipcode> getAll() {
    return masterZipcodeDAO.getAll();
  }

  @Override
  public List<MasterZipcode> getByPage(int pageNo) {
    return masterZipcodeDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterZipcode> getByRangeZipcodeDesc(String zipcodeCodePattern, String zipcodeDescPattern, int pageNo) {
    return masterZipcodeDAO.getByRangeZipcodeDesc(zipcodeCodePattern, zipcodeDescPattern, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterZipcodeDAO.count();
  }

  @Override
  public int countByZipcodeDesc(String zipcodeCodePattern, String zipcodeDescPattern) {
    return masterZipcodeDAO.countByZipcodeDesc(zipcodeCodePattern, zipcodeDescPattern);
  }
  
  @Override
  public List<String> getListInput(String fieldName) {
    return masterZipcodeDAO.getListInput(fieldName);
  }
}
