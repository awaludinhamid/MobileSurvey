/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterReasonType;
import id.co.sim.mobsur.dao.MasterReasonTypeDAO;
import id.co.sim.mobsur.service.MasterReasonTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Jan 26, 2017
 * @author awal
 */
@Service("masterReasonTypeService")
@Transactional(readOnly=true)
public class MasterReasonTypeServiceImpl implements MasterReasonTypeService {

  @Autowired
  private MasterReasonTypeDAO masterReasonTypeDAO;

  @Override
  public List<MasterReasonType> getAll() {
    return masterReasonTypeDAO.getAll();
  }

  @Override
  public MasterReasonType getById(int reasonTypeId) {
    return masterReasonTypeDAO.getById(reasonTypeId);
  }
}
