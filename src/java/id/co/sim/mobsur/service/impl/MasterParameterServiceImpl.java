/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterParameter;
import id.co.sim.mobsur.dao.MasterParameterDAO;
import id.co.sim.mobsur.service.MasterParameterService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Nov 18, 2016
 * @author awal
 */
@Service("masterParameterService")
@Transactional(readOnly=true)
public class MasterParameterServiceImpl implements MasterParameterService {

  @Autowired
  private MasterParameterDAO masterParameterDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterParameter save(MasterParameter mp) {
    return masterParameterDAO.save(mp);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterParameter delete(MasterParameter mp) {
    return masterParameterDAO.delete(mp);
  }

  @Override
  public List<MasterParameter> getByPageCompanyCodeDescAndApps(
          int coyId, String parCodePattern, String parDescPattern, String parAppsType, int pageNo) {
    return masterParameterDAO.getByRangeCompanyCodeDescAndApps(coyId, parCodePattern, parDescPattern, parAppsType, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByCompanyCodeDescAndApps(int coyId, String parCodePattern, String parDescPattern, String parAppsType) {
    return masterParameterDAO.countByCompanyCodeDescAndApps(coyId, parCodePattern, parDescPattern, parAppsType);
  }

  @Override
  public List<MasterParameter> getByPageCompany(int coyId, int pageNo) {
    return masterParameterDAO.getByRangeCompany(coyId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByCompany(int coyId) {
    return masterParameterDAO.countByCompany(coyId);
  }
}
