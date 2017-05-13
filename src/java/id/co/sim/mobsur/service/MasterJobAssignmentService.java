/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterJobAssignment;
import java.util.List;

/**
 * SPI of job assignment module
 * @created Jan 17, 2017
 * @author awal
 */
public interface MasterJobAssignmentService {

  /**
   * Save given job assignment
   * @param jobAssign, job assignment
   * @return 
   */
  MasterJobAssignment save(MasterJobAssignment jobAssign);
  
  /**
   * Delete given job assignment
   * @param jobAssign 
   */
  void delete(MasterJobAssignment jobAssign);
  
  /**
   * Delete job assignment by id
   * @param jobAssignId
   * @return exit status (0=normal, otherwise force exit)
   */
  int deleteById(int jobAssignId);
  
  /**
   * Get job assignment by id
   * @param jobAssignId
   * @return job assignment based on given id
   */
  MasterJobAssignment getById(int jobAssignId);
  
  /**
   * Get job assign data by commission
   * @param userCommissionedId
   * @return list of job assigns based on given commission
   */
  List<MasterJobAssignment> getByUserCommissioned(int userCommissionedId);
}
