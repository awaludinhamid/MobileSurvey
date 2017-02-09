/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterTaskStatus;
import id.co.sim.mobsur.dao.MasterTaskStatusDAO;
import id.co.sim.mobsur.service.MasterTaskStatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Feb 8, 2017
 * @author awal
 */

@Service("masterTaskStatusService")
@Transactional(readOnly=true)
public class MasterTaskStatusServiceImpl implements MasterTaskStatusService {

    @Autowired
    private MasterTaskStatusDAO masterTaskStatusDAO;

  @Override
  public List<MasterTaskStatus> getAll() {
    return masterTaskStatusDAO.getAll();
  }

}
