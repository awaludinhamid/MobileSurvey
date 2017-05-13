/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterKecamatan;
import id.co.sim.mobsur.dao.MasterKecamatanDAO;
import id.co.sim.mobsur.service.MasterKecamatanService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Kecamatan service implementation (see the service for usage info)
 * @created Dec 19, 2016
 * @author awal
 */
@Service("masterKecamatanService")
@Transactional(readOnly=true)
public class MasterKecamatanServiceImpl implements MasterKecamatanService {

  @Autowired
  private MasterKecamatanDAO masterKecamatanDAO;// DAO injection
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();//number of records per page (paging)

  @Override
  @Transactional(readOnly=false)
  public MasterKecamatan save(MasterKecamatan mk) {
    return masterKecamatanDAO.save(mk);
  }

  @Override
  @Transactional(readOnly=false)
  public void delete(MasterKecamatan mk) {
    masterKecamatanDAO.delete(mk);
  }

  @Override
  public MasterKecamatan getById(int kecId) {
    return masterKecamatanDAO.getById(kecId);
  }

  @Override
  public List<MasterKecamatan> getByPage(int pageNo) {
    return masterKecamatanDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterKecamatan> getByPageCodeAndName(String kecCodePattern, String kecNamePattern, int pageNo) {
    return masterKecamatanDAO.getByRangeCodeAndName(kecCodePattern, kecNamePattern, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterKecamatanDAO.count();
  }

  @Override
  public int countByCodeAndName(String kecCodePattern, String kecNamePattern) {
    return masterKecamatanDAO.countByCodeAndName(kecCodePattern, kecNamePattern);
  }

  @Override
  public List<MasterKecamatan> getByCity(int cityId) {
    return masterKecamatanDAO.getByCity(cityId);
  }
}
