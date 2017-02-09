/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterJobAssignment;
import id.co.sim.mobsur.dao.MasterJobAssignmentDAO;
import id.co.sim.mobsur.service.MasterJobAssignmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Jan 17, 2017
 * @author awal
 */
@Service("masterJobAssignmentService")
@Transactional(readOnly=true)
public class MasterJobAssignmentServiceImpl implements MasterJobAssignmentService {

  @Autowired
  private MasterJobAssignmentDAO masterJobAssignmentDAO;

  @Override
  @Transactional(readOnly=false)
  public MasterJobAssignment save(MasterJobAssignment jobAssign) {
    return masterJobAssignmentDAO.save(jobAssign);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterJobAssignment delete(MasterJobAssignment jobAssign) {
    return masterJobAssignmentDAO.delete(jobAssign);
  }

  @Override
  @Transactional(readOnly=false)
  public int deleteById(int jobAssignId) {
    return masterJobAssignmentDAO.deleteById(jobAssignId);
  }

  @Override
  public MasterJobAssignment getById(int jobAssignId) {
    return masterJobAssignmentDAO.getById(jobAssignId);
  }

  @Override
  public List<MasterJobAssignment> getByUserCommissioned(int userCommissionedId) {
    return masterJobAssignmentDAO.getByUserCommissioned(userCommissionedId);
  }
}
