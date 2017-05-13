/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterProduct;
import id.co.sim.mobsur.dao.MasterProductDAO;
import id.co.sim.mobsur.service.MasterProductService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**	
 * Product service implementation (see the service for usage info)
 * @created Jan 5, 2017
 * @author awal
 */
@Service("masterProductService")
@Transactional(readOnly=true)
public class MasterProductServiceImpl implements MasterProductService {

  @Autowired
  private MasterProductDAO masterProductDAO;// DAO injection
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();//number of records per page (paging)

  @Override
  @Transactional(readOnly=false)
  public MasterProduct save(MasterProduct mp) {
    return masterProductDAO.save(mp);
  }

  @Override
  @Transactional(readOnly=false)
  public void delete(MasterProduct mp) {
    masterProductDAO.delete(mp);
  }

  @Override
  public MasterProduct getById(int productId) {
    return masterProductDAO.getById(productId);
  }

  @Override
  public List<MasterProduct> getByPage(int pageNo) {
    return masterProductDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterProduct> getByPageCoyAndName(int coyId, String productNamePattern, int pageNo) {
    return masterProductDAO.getByRangeCoyAndName(coyId, productNamePattern, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterProductDAO.count();
  }

  @Override
  public int countByCoyAndName(int coyId, String productNamePattern) {
    return masterProductDAO.countByCoyAndName(coyId, productNamePattern);
  }

  @Override
  public List<MasterProduct> getByPageCoy(int coyId, int pageNo) {
    return masterProductDAO.getByRangeCoy(coyId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByCoy(int coyId) {
    return masterProductDAO.countByCoy(coyId);
  }

  @Override
  public int countByTemplate(int tempId) {
    return masterProductDAO.countByTemplate(tempId);
  }
}
