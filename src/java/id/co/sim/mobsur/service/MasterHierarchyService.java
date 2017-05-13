/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterHierarchy;
import java.util.List;

/**
 * SPI of hierarchy module
 * @created Nov 29, 2016
 * @author awal
 */
public interface MasterHierarchyService {

  /**
   * Save given hierarchy
   * @param mh, hierarchy
   * @return saved hierarchy
   */
  MasterHierarchy save(MasterHierarchy mh);
  
  /**
   * Delete given hierarchy
   * @param mh, hierarchy
   */
  void delete(MasterHierarchy mh);
  
  /**
   * Get hierarchy by id
   * @param hieId, hierarchy
   * @return hierarchy based on given id
   */
  MasterHierarchy getById(int hieId);
  
  /**
   * Get hierarchy data by page
   * @param pageNo, page number to proceed
   * @return list of hierarchies based on page
   */
  List<MasterHierarchy> getByPage(int pageNo);
  
  /**
   * Get hierarchy data by page, company, role and superior role
   * @param coyId, company
   * @param roleId
   * @param roleIdUp, superior role
   * @param pageNo, page number to proceed
   * @return list of hierarchies based on page, company, role and superior role
   */
  List<MasterHierarchy> getByPageCoyRoleAndRoleUp(int coyId, int roleId, int roleIdUp, int pageNo);
  
  /**
   * Get number of all hierarchy data
   * @return count of all hierarchies
   */
  int count();
  
  /**
   * Get number of hierarchy data by company, role and superior role
   * @param coyId, company
   * @param roleId
   * @param roleIdUp, superior role
   * @return count of hierarchies based on company, role and superior role
   */
  int countByCoyRoleAndRoleUp(int coyId, int roleId, int roleIdUp);
}
