/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterRoleType;
import java.util.List;

/**
 * SPI of role type module
 * @created Feb 3, 2017
 * @author awal
 */
public interface MasterRoleTypeService {

  /**
   * Get role type by id
   * @param roleTypeId
   * @return role type based on given id
   */
  MasterRoleType getById(int roleTypeId);
  
  /**
   * Get all role type data
   * @return list of all role types based on given id
   */
  List<MasterRoleType> getAll();
  
  /**
   * Get role type data by code
   * @param roleTypeCode
   * @return role type based on the code
   */
  MasterRoleType getByCode(String roleTypeCode);
}
