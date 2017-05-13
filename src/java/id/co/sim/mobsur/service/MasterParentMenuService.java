/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterParentMenu;
import java.util.List;

/**
 * SPI of parent menu module
 * @created Oct 14, 2016
 * @author awal
 */
public interface MasterParentMenuService {

  /**
   * Save given parent menu
   * @param mpm, parent menu
   */
  void save(MasterParentMenu mpm);
  
  /**
   * Delete given parent menu
   * @param mpm, parent menu
   */
  void delete(MasterParentMenu mpm);
  
  /**
   * Get parent menu by id
   * @param id
   * @return parent menu based on given id
   */
  MasterParentMenu getById(int id);
  
  /**
   * Get all parent menu data
   * @return list of all parent menus
   */
  List<MasterParentMenu> getAll();
  
  /**
   * Get parent menu data by page
   * @param pageNo
   * @return list of parent menus based on given page
   */
  List<MasterParentMenu> getByPage(int pageNo);

}
