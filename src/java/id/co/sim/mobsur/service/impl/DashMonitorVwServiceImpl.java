/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.DashMonitorVw;
import id.co.sim.mobsur.dao.DashMonitorVwDAO;
import id.co.sim.mobsur.service.DashMonitorVwService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Dashboard monitor service implementation (see the service for usage info)
 * @author awal
 * @created Feb 22, 2017
 */
@Service("dashMonitorVwService")
@Transactional(readOnly=true)
public class DashMonitorVwServiceImpl implements DashMonitorVwService {

  @Autowired
  private DashMonitorVwDAO dashMonitorVwDAO;// DAO injection

  @Override
  public List<DashMonitorVw> getByOffice(int officeId) {
    return dashMonitorVwDAO.getByOffice(officeId);
  }

  @Override
  public List<DashMonitorVw> getByParentUser(int parentUserId) {
    return dashMonitorVwDAO.getByParentUser(parentUserId);
  }
}
