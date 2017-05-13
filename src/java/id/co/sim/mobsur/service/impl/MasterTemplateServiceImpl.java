/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterTemplate;
import id.co.sim.mobsur.dao.MasterTemplateDAO;
import id.co.sim.mobsur.service.MasterTemplateService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**	
 * Template service implementation (see the service for usage info)
 * @created Jan 15, 2017
 * @author awal
 */
@Service("masterTemplateService")
@Transactional(readOnly=true)
public class MasterTemplateServiceImpl implements MasterTemplateService {

  @Autowired
  private MasterTemplateDAO masterTemplateDAO;// DAO injection
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();//number of records per page (paging)

  @Override
  @Transactional(readOnly=false)
  public MasterTemplate save(MasterTemplate template) {
    return masterTemplateDAO.save(template);
  }

  @Override
  @Transactional(readOnly=false)
  public void delete(MasterTemplate template) {
    masterTemplateDAO.delete(template);
  }

  @Override
  public MasterTemplate getById(int tempId) {
    return masterTemplateDAO.getById(tempId);
  }

  @Override
  public List<MasterTemplate> getByPageCoy(int coyId, int pageNo) {
    return masterTemplateDAO.getByRangeCoy(coyId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterTemplate> getByPageCoyAndLabel(int coyId, String tempLabelPattern, int pageNo) {
    return masterTemplateDAO.getByRangeCoyAndLabel(coyId, tempLabelPattern, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByCoy(int coyId) {
    return masterTemplateDAO.countByCoy(coyId);
  }

  @Override
  public int countByCoyAndLabel(int coyId, String tempLabelPattern) {
    return masterTemplateDAO.countByCoyAndLabel(coyId, tempLabelPattern);
  }

  @Override
  public List<MasterTemplate> getByCoy(int coytId) {
    return masterTemplateDAO.getByCoy(coytId);
  }
}
