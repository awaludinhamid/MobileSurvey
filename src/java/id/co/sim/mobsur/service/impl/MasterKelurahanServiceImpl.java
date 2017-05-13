/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterKelurahan;
import id.co.sim.mobsur.dao.MasterKelurahanDAO;
import id.co.sim.mobsur.service.MasterKelurahanService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Kelurahan service implementation (see the service for usage info)
 * @created Dec 23, 2016
 * @author awal
 */
@Service("masterKelurahanService")
@Transactional(readOnly=true)
public class MasterKelurahanServiceImpl implements MasterKelurahanService {

  @Autowired
  private MasterKelurahanDAO masterKelurahanDAO;// DAO injection
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();//number of records per page (paging)

  @Override
  @Transactional(readOnly=false)
  public MasterKelurahan save(MasterKelurahan mk) {
    return masterKelurahanDAO.save(mk);
  }

  @Override
  @Transactional(readOnly=false)
  public void delete(MasterKelurahan mk) {
    masterKelurahanDAO.delete(mk);
  }

  @Override
  public MasterKelurahan getById(int kelId) {
    return masterKelurahanDAO.getById(kelId);
  }

  @Override
  public List<MasterKelurahan> getByPage(int pageNo) {
    return masterKelurahanDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterKelurahan> getByPageCodeAndName(String kelCodePattern, String kelNamePattern, int pageNo) {
    return masterKelurahanDAO.getByRangeCodeAndName(kelCodePattern, kelNamePattern, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterKelurahanDAO.count();
  }

  @Override
  public int countByCodeAndName(String kelCodePattern, String kelNamePattern) {
    return masterKelurahanDAO.countByCodeAndName(kelCodePattern, kelNamePattern);
  }

  @Override
  public List<MasterKelurahan> getByKecamatan(int kecId) {
    return masterKelurahanDAO.getByKecamatan(kecId);
  }
}
