/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterRoleType;
import java.util.List;

/**
 * @created Feb 3, 2017
 * @author awal
 */
public interface MasterRoleTypeService {

  MasterRoleType getById(int roleTypeId);
  List<MasterRoleType> getAll();
  MasterRoleType getByCode(String roleTypeCode);
}
