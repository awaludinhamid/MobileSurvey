/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * @created Nov 25, 2016
 * @author awal
 */
public class MasterUserRoleDTO extends RecordControllerBeanDTO {

  private int userRoleId;
  private int roleId;
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

  /**
   * @return the roleId
   */
  public int getRoleId() {
    return roleId;
  }

  /**
   * @param roleId the roleId to set
   */
  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }
}
