/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.save;

import id.co.sim.mobsur.bean.save.support.RecordControllerBeanSave;

/**
 * @created Nov 17, 2016
 * @author awal
 */
public class MasterRoleSave extends RecordControllerBeanSave {

  private int roleId;
  private String roleCode;
  private String roleName;
  private String roleDesc;
  private String isOwner;

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

  /**
   * @return the roleCode
   */
  public String getRoleCode() {
    return roleCode;
  }

  /**
   * @param roleCode the roleCode to set
   */
  public void setRoleCode(String roleCode) {
    this.roleCode = roleCode;
  }

  /**
   * @return the roleName
   */
  public String getRoleName() {
    return roleName;
  }

  /**
   * @param roleName the roleName to set
   */
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  /**
   * @return the roleDesc
   */
  public String getRoleDesc() {
    return roleDesc;
  }

  /**
   * @param roleDesc the roleDesc to set
   */
  public void setRoleDesc(String roleDesc) {
    this.roleDesc = roleDesc;
  }

  /**
   * @return the isOwner
   */
  public String getIsOwner() {
    return isOwner;
  }

  /**
   * @param isOwner the isOwner to set
   */
  public void setIsOwner(String isOwner) {
    this.isOwner = isOwner;
  }
}
