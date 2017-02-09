/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterHierarchy;
import java.util.List;

/**
 * @created Nov 29, 2016
 * @author awal
 */
public interface MasterHierarchyService {

  MasterHierarchy save(MasterHierarchy mh);
  MasterHierarchy delete(MasterHierarchy mh);
  List<MasterHierarchy> getByPage(int pageNo);
  List<MasterHierarchy> getByPageCoyRoleAndRoleUp(int coyId, int roleId, int roleIdUp, int pageNo);
  int count();
  int countByCoyRoleAndRoleUp(int coyId, int roleId, int roleIdUp);
}
