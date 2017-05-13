/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterMenu;
import java.util.List;

/**
 * SPI of menu module
 * @created Oct 14, 2016
 * @author awal
 */
public interface MasterMenuService {

  /**
   * Save given menu
   * @param mm, menu
   */
  void save(MasterMenu mm);
  
  /**
   * Delete given menu
   * @param mm, menu
   */
  void delete(MasterMenu mm);
  
  /**
   * Get menu by id
   * @param id
   * @return menu based on given id
   */
  MasterMenu getById(int id);
  
  /**
   * Get all menu data
   * @return list of all menus
   */
  List<MasterMenu> getAll();
  
  /**
   * Get menu data by page
   * @param pageNo, page number to proceed
   * @return list of menus based on given page
   */
  List<MasterMenu> getByPage(int pageNo);
  
  /**
   * Get menu data by page, parent menu, menu, and as of date
   * @param parentMenuId
   * @param menuId
   * @param asOfDate, end date more than or equal to this date
   * @param pageNo, page number to proceed
   * @return list of menus based on given page, parent menu, menu, and as of date
   */
  List<MasterMenu> getByPageParentMenuAndDate(int parentMenuId, int menuId, String asOfDate, int pageNo);
  
  /**
   * Get number of all menu data
   * @return count of all menus
   */
  int count();
  
  /**
   * Get number of menu data by parent menu, menu and as of date
   * @param parentMenuId
   * @param menuId
   * @param asOfDate, end date more than or equal to this date
   * @return count of menus based on given parent menu, menu and as of date
   */
  int countByParentMenuAndDate(int parentMenuId, int menuId, String asOfDate);
  
  /**
   * Get menu data by user
   * @param userId
   * @return list of menus based on given user
   */
  List<MasterMenu> getListMenuByUserId(int userId);
  
  /**
   * Get menu data by role
   * @param roleId
   * @return list of menus based on given role
   */
  List<MasterMenu> getByRole(int roleId);
}
