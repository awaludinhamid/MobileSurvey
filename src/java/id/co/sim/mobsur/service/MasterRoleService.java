/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterRole;
import java.util.List;

/**
 * @created Apr 4, 2016
 * @author awal
 */
public interface MasterRoleService {

  void save(MasterRole mr);
  void delete(MasterRole mr);
  MasterRole getById(int id);
  List<MasterRole> getAll();
  List<MasterRole> getByPage(int pageNo);
  List<MasterRole> getByPageRoleAndDate(int roleId, String asOfDate, int pageNo);
  int count();
  int countByRoleAndDate(int roleId, String asOfDate);
  List<MasterRole> getRolesByUser(int userId);
  List<MasterRole> getForClientRole();
  List<MasterRole> getForClientRoleWithNull();
  List<MasterRole> getForOwnerRole();
  List<MasterRole> getForOwnerRoleWithNull();
  List<MasterRole> getByCoyAndParentRole(int coyId, int parentRoleId);
  List<MasterRole> getForAssignDist();
  List<MasterRole> getByParentRoleLevel(int parentRoleLevel);
}
