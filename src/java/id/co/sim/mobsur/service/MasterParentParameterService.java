/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterParentParameter;
import java.util.List;

/**
 * SPI of parent parameter module
 *
 * @author awal
 */
public interface MasterParentParameterService {

  /**
   * Get parent parameter by id
   * @param parentParId
   * @return parent parameter based on given id
   */
  MasterParentParameter getById(int parentParId);
  
  /**
   * Get all parent parameter data
   * @return list of all parent parameters
   */
  List<MasterParentParameter> getAll();
}
