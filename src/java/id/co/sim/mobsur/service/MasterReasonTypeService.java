/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterReasonType;
import java.util.List;

/**
 * SPI of reason type module
 * @created Jan 26, 2017
 * @author awal
 */
public interface MasterReasonTypeService {

  /**
   * Get reason type by id
   * @param reasonTypeId
   * @return reason type based on given id
   */
  MasterReasonType getById(int reasonTypeId);
  
  /**
   * Get all reason type data
   * @return list of all reason types
   */
  List<MasterReasonType> getAll();
}
