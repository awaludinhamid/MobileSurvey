/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterDistribution;
import id.co.sim.mobsur.dao.MasterDistributionDAO;
import id.co.sim.mobsur.service.MasterDistributionService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Distribution service implementation (see the service for usage info)
 * @created Dec 4, 2016
 * @author awal
 */
@Service("masterDistributionService")
@Transactional(readOnly=true)
public class MasterDistributionServiceImpl implements MasterDistributionService {

  @Autowired
  private MasterDistributionDAO masterDistributionDAO;// DAO injection
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();//number of records per page (paging)

  @Override
  @Transactional(readOnly=false)
  public MasterDistribution save(MasterDistribution md) {
    return masterDistributionDAO.save(md);
  }

  @Override
  @Transactional(readOnly=false)
  public void delete(MasterDistribution md) {
    masterDistributionDAO.delete(md);
  }

  @Override
  public MasterDistribution getById(int distId) {
    return masterDistributionDAO.getById(distId);
  }

  @Override
  public List<MasterDistribution> getByPageCompany(int coyId, int pageNo) {
    return masterDistributionDAO.getByRangeCompany(coyId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterDistribution> getByPageCompanyOffice(int coyId, int officeId, int pageNo) {
    return masterDistributionDAO.getByRangeCompanyOffice(coyId, officeId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByCompany(int coyId) {
    return masterDistributionDAO.countByCompany(coyId);
  }

  @Override
  public int countByCompanyOffice(int coyId, int officeId) {
    return masterDistributionDAO.countByCompanyOffice(coyId, officeId);
  }
}
