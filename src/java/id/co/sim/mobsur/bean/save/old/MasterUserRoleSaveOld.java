/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.save.old;

import id.co.sim.mobsur.bean.save.support.RecordControllerBeanSave;
import java.util.List;

/**
 * @created Nov 25, 2016
 * @author awal
 */
public class MasterUserRoleSaveOld extends RecordControllerBeanSave {

  private int userRoleId;
  private List<Integer> roles;
  private int userId;

  /**
   * @return the userRoleId
   */
  public int getUserRoleId() {
    return userRoleId;
  }

  /**
   * @param userRoleId the userRoleId to set
   */
  public void setUserRoleId(int userRoleId) {
    this.userRoleId = userRoleId;
  }

  /**
   * @return the roles
   */
  public List<Integer> getRoles() {
    return roles;
  }

  /**
   * @param roles the roles to set
   */
  public void setRoles(List<Integer> roles) {
    this.roles = roles;
  }

  /**
   * @return the userId
   */
  public int getUserId() {
    return userId;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(int userId) {
    this.userId = userId;
  }
}
