/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterCity;
import id.co.sim.mobsur.dao.MasterCityDAO;
import id.co.sim.mobsur.service.MasterCityService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Dec 19, 2016
 * @author awal
 */
@Service("masterCityService")
@Transactional(readOnly=true)
public class MasterCityServiceImpl implements MasterCityService {

  @Autowired
  private MasterCityDAO masterCityDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterCity save(MasterCity mc) {
    return masterCityDAO.save(mc);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterCity delete(MasterCity mc) {
    return masterCityDAO.delete(mc);
  }

  @Override
  public MasterCity getById(int cityId) {
    return masterCityDAO.getById(cityId);
  }

  @Override
  public List<MasterCity> getByPage(int pageNo) {
    return masterCityDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterCity> getByPageCodeAndName(String cityCodePattern, String cityNamePattern, int pageNo) {
    return masterCityDAO.getByRangeCodeAndName(cityCodePattern, cityNamePattern, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterCityDAO.count();
  }

  @Override
  public int countByCodeAndName(String cityCodePattern, String cityNamePattern) {
    return masterCityDAO.countByCodeAndName(cityCodePattern, cityNamePattern);
  }

  @Override
  public List<MasterCity> getByProvinsi(int provId) {
    return masterCityDAO.getByProvinsi(provId);
  }
}
