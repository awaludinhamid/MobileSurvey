/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterRoleMenu;
import java.util.List;

/**
 * SPI of role menu module
 * @created Oct 16, 2016
 * @author awal
 */
public interface MasterRoleMenuService {

  /**
   * Save given role menu
   * @param mrm, role menu
   * @return saved role menu
   */
  MasterRoleMenu save(MasterRoleMenu mrm);
  
  /**
   * Delete given role menu
   * @param mrm, role menu
   */
  void delete(MasterRoleMenu mrm);
  
  /**
   * Get role menu by id
   * @param roleMenuId
   * @return role menu based on given id
   */
  MasterRoleMenu getById(int roleMenuId);
  
  /**
   * Get all role menu data
   * @return list of all role menus
   */
  List<MasterRoleMenu> getAll();
  
  /**
   * Get role menu data by role
   * @param roleId
   * @return list of role menus based on given role
   */
  List<MasterRoleMenu> getByRoleId(int roleId);
  
  /**
   * Get role menu data by page
   * @param pageNo
   * @return list of role menu based on given page
   */
  List<MasterRoleMenu> getByPage(int pageNo);
  
  /**
   * Get role menu data by page, role, menu and as of date
   * @param roleId
   * @param menuId
   * @param asOfDate, end date more than or equal to this date
   * @param pageNo, page number to proceed
   * @return list of role menus based on given page, role, menu and as of date
   */
  List<MasterRoleMenu> getByPageRoleMenuAndDate(int roleId, int menuId, String asOfDate, int pageNo);
  
  /**
   * Get number of all role menu data
   * @return count of all role menus
   */
  int count();
  
  /**
   * Get number of role menu data by role, menu and as of date
   * @param roleId
   * @param menuId
   * @param asOfDate, end date more than or equal to this date
   * @return count of role menus based on role, menu and as of date
   */
  int countByRoleMenuAndDate(int roleId, int menuId, String asOfDate);
  
  /**
   * Get number of role menu data by role
   * @param roleId
   * @return count of role menus based on role
   */
  int countByRole(int roleId);
  
  /**
   * Get number of role menu data by menu
   * @param menuId
   * @return count of role menus based on menu
   */
  int countByMenu(int menuId);
}
