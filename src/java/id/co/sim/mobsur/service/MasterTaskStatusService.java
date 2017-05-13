/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterTaskStatus;
import java.util.List;

/**
 * SPI of task status module
 * @created Feb 8, 2017
 * @author awal
 */
public interface MasterTaskStatusService {

  /**
   * Get task status by id
   * @param taskStatusId
   * @return task status based on given id
   */
  MasterTaskStatus getById(int taskStatusId);
  
  /**
   * Get task status by code
   * @param taskStatusCode
   * @return task status based on given code
   */
  MasterTaskStatus getByCode(String taskStatusCode);
  
  /**
   * Get all task status data
   * @return list of all task status
   */
  List<MasterTaskStatus> getAll();

}
