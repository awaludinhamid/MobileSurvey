/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterRole;
import java.util.List;

/**
 * SPI of role module
 * @created Apr 4, 2016
 * @author awal
 */
public interface MasterRoleService {

  /**
   * Save given role
   * @param mr, role
   */
  void save(MasterRole mr);
  
  /**
   * Delete given role
   * @param mr, role
   */
  void delete(MasterRole mr);
  
  /**
   * Get role by id
   * @param id
   * @return role based on given id
   */
  MasterRole getById(int id);
  
  /**
   * Get all role data
   * @return list of all roles
   */
  List<MasterRole> getAll();
  
  /**
   * Get role data by page
   * @param pageNo
   * @return list of roles based on given page
   */
  List<MasterRole> getByPage(int pageNo);
  
  /**
   * Get role data by page, role and as of date
   * @param roleId
   * @param asOfDate, end date more than or equal to this date
   * @param pageNo, page number to proceed
   * @return list of roles based on given page, role and as of date
   */
  List<MasterRole> getByPageRoleAndDate(int roleId, String asOfDate, int pageNo);
  
  /**
   * Get number of all role
   * @return count of all roles
   */
  int count();
  
  /**
   * Get number of role data by role and as of date
   * @param roleId
   * @param asOfDate, end date more than or equal to this date
   * @return count of roles based on given role and as of date
   */
  int countByRoleAndDate(int roleId, String asOfDate);
  
  /**
   * Get role data by user
   * @param userId
   * @return list of roles based on given user
   */
  List<MasterRole> getRolesByUser(int userId);
  
  /**
   * Get role data specific for client
   * @return list of roles for client
   */
  List<MasterRole> getForClientRole();
  
  /**
   * Get role data specific for client
   * @return list of roles for client with additional null value
   */
  List<MasterRole> getForClientRoleWithNull();
  
  /**
   * Get role data specific for owner
   * @return list of roles for owner
   */
  List<MasterRole> getForOwnerRole();
  
  /**
   * Get role data specific for owner
   * @return list of roles for owner with additional null value
   */
  List<MasterRole> getForOwnerRoleWithNull();
  
  /**
   * Get role data by company and parent role
   * @param coyId, company
   * @param parentRoleId
   * @return list of roles based on given company and parent role
   */
  List<MasterRole> getByCoyAndParentRole(int coyId, int parentRoleId);
  
  /**
   * Get role data specific for assign distribution module
   * @return list of roles for assign distribution module
   */
  List<MasterRole> getForAssignDist();
  
  /**
   * Get role data by parent role level
   * @param parentRoleLevel
   * @return list of roles based on given parent role level
   */
  List<MasterRole> getByParentRoleLevel(int parentRoleLevel);
  
  /**
   * Get role data specific for job assign
   * @return list of roles for job assign
   */
  List<MasterRole> getForJobAssign();
  
  /**
   * Get role data by role level
   * @param roleLevel
   * @return list of roles based on given role level
   */
  List<MasterRole> getByRoleLevel(int roleLevel);
  
  /**
   * Get role data by role type
   * @param roleTypeCode, role type code collection
   * @return list of roles based on given role type
   */
  List<MasterRole> getByRoleType(String[] roleTypeCode);
}
