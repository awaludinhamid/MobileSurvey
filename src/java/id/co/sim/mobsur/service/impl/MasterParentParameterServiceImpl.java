/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterParentParameter;
import id.co.sim.mobsur.dao.MasterParentParameterDAO;
import id.co.sim.mobsur.service.MasterParentParameterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**	
 * Parent parameter service implementation (see the service for usage info)
 * @author awal
 * @created Mar 14, 2017
 */
@Service("masterParentParameterService")
@Transactional(readOnly=true)
public class MasterParentParameterServiceImpl implements MasterParentParameterService {

  @Autowired
  private MasterParentParameterDAO masterParentParameterDAO;// DAO injection

  @Override
  public MasterParentParameter getById(int parentParId) {
    return masterParentParameterDAO.getById(parentParId);
  }

  @Override
  public List<MasterParentParameter> getAll() {
    return masterParentParameterDAO.getAll();
  }
}
