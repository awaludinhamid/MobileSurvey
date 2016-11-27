/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterUserRole;
import java.util.List;

/**
 * @created Apr 14, 2016
 * @author awal
 */
public interface MasterUserRoleService {
  
  MasterUserRole save(MasterUserRole mur);
  MasterUserRole delete(MasterUserRole mur);
  List<MasterUserRole> getPageByCoy(int coyId, int pageNo);  
  List<MasterUserRole> getPageByCoyOfficeRoleUserNameDate(
          int coyId, int officeId, int roleId, String userNamePattern, String asOfDate, int pageNo);  
  int countByCoy(int coyId);  
  int countByCoyOfficeRoleUserNameDate(int coyId, int officeId, int roleId, String userNamePattern, String asOfDate);
}
