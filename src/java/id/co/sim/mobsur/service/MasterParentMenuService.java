/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterParentMenu;
import java.util.List;

/**
 * @created Oct 14, 2016
 * @author awal
 */
public interface MasterParentMenuService {

  void save(MasterParentMenu mpm);
  void delete(MasterParentMenu mpm);
  MasterParentMenu getById(int id);
  List<MasterParentMenu> getAll();
  List<MasterParentMenu> getByPage(int pageNo);

}
