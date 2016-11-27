/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterRoleMenu;
import java.util.List;

/**
 * @created Oct 16, 2016
 * @author awal
 */
public interface MasterRoleMenuService {

  MasterRoleMenu save(MasterRoleMenu mrm);
  MasterRoleMenu delete(MasterRoleMenu mrm);
  List<MasterRoleMenu> getAll();
  List<MasterRoleMenu> getByRoleId(int roleId);
  List<MasterRoleMenu> getByPage(int pageNo);
  List<MasterRoleMenu> getByPageRoleMenuAndDate(int roleId, int menuId, String asOfDate, int pageNo);
  int count();
  int countByRoleMenuAndDate(int roleId, int menuId, String asOfDate);
}
