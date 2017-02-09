/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterRoleType;
import id.co.sim.mobsur.dao.MasterRoleTypeDAO;
import id.co.sim.mobsur.service.MasterRoleTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Feb 3, 2017
 * @author awal
 */
@Service("masterRoleTypeService")
@Transactional(readOnly=true)
public class MasterRoleTypeServiceImpl implements MasterRoleTypeService {

  @Autowired
  private MasterRoleTypeDAO masterRoleTypeDAO;

  @Override
  public List<MasterRoleType> getAll() {
    return masterRoleTypeDAO.getAll();
  }

  @Override
  public MasterRoleType getById(int roleTypeId) {
    return masterRoleTypeDAO.getById(roleTypeId);
  }

  @Override
  public MasterRoleType getByCode(String roleTypeCode) {
    return masterRoleTypeDAO.getByCode(roleTypeCode);
  }
}
