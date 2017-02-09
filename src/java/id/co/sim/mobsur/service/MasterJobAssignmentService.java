/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterJobAssignment;
import java.util.List;

/**
 * @created Jan 17, 2017
 * @author awal
 */
public interface MasterJobAssignmentService {

  MasterJobAssignment save(MasterJobAssignment jobAssign);
  MasterJobAssignment delete(MasterJobAssignment jobAssign);
  int deleteById(int jobAssignId);
  MasterJobAssignment getById(int jobAssignId);
  List<MasterJobAssignment> getByUserCommissioned(int userCommissionedId);
}
