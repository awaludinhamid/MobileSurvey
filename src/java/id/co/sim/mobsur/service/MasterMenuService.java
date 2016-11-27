/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterMenu;
import java.util.List;

/**
 * @created Oct 14, 2016
 * @author awal
 */
public interface MasterMenuService {

  void save(MasterMenu mm);
  void delete(MasterMenu mm);
  MasterMenu getById(int id);
  List<MasterMenu> getAll();
  List<MasterMenu> getByPage(int pageNo);
  List<MasterMenu> getByPageParentMenuAndDate(int parentMenuId, int menuId, String asOfDate, int pageNo);
  int count();
  int countByParentMenuAndDate(int parentMenuId, int menuId, String asOfDate);
  List<MasterMenu> getListMenuByUserId(int userId);
  List<MasterMenu> getByRole(int roleId);
}
