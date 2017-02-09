/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterProvinsi;
import id.co.sim.mobsur.dao.MasterProvinsiDAO;
import id.co.sim.mobsur.service.MasterProvinsiService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Dec 19, 2016
 * @author awal
 */
@Service("masterProvinsiService")
@Transactional(readOnly=true)
public class MasterProvinsiServiceImpl implements MasterProvinsiService {

  @Autowired
  private MasterProvinsiDAO masterProvinsiDAO;  
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterProvinsi save(MasterProvinsi mp) {
    return masterProvinsiDAO.save(mp);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterProvinsi delete(MasterProvinsi mp) {
    return masterProvinsiDAO.delete(mp);
  }

  @Override
  public MasterProvinsi getById(int provId) {
    return masterProvinsiDAO.getById(provId);
  }

  @Override
  public List<MasterProvinsi> getAll() {
    return masterProvinsiDAO.getAll();
  }

  @Override
  public List<MasterProvinsi> getByPage(int pageNo) {
    return masterProvinsiDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterProvinsi> getByPageCodeAndName(String provCodePattern, String provNamePattern, int pageNo) {
    return masterProvinsiDAO.getByRangeCodeAndName(provCodePattern, provNamePattern, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterProvinsiDAO.count();
  }

  @Override
  public int countByCodeAndName(String provCodePattern, String provNamePattern) {
    return masterProvinsiDAO.countByCodeAndName(provCodePattern, provNamePattern);
  }
  
}
