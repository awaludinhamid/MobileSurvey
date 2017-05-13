/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordAuditBeanDTO;

/**
 * DTO table MASTER_ROLE_MENU
 * @created Nov 26, 2016
 * @author awal
 */
//public class MasterRoleMenuDTO extends RecordControllerBeanDTO {
public class MasterRoleMenuDTO extends RecordAuditBeanDTO {

  private int roleMenuId;
  private String roleMenuDesc;
  private int roleId;
  private int menuId;  

  /**
   * @return the roleMenuId
   */
  public int getRoleMenuId() {
    return roleMenuId;
  }

  /**
   * @param roleMenuId the roleMenuId to set
   */
  public void setRoleMenuId(int roleMenuId) {
    this.roleMenuId = roleMenuId;
  }

  /**
   * @return the roleMenuDesc
   */
  public String getRoleMenuDesc() {
    return roleMenuDesc;
  }

  /**
   * @param roleMenuDesc the roleMenuDesc to set
   */
  public void setRoleMenuDesc(String roleMenuDesc) {
    this.roleMenuDesc = roleMenuDesc;
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

  /**
   * @return the menuId
   */
  public int getMenuId() {
    return menuId;
  }

  /**
   * @param menuId the menuId to set
   */
  public void setMenuId(int menuId) {
    this.menuId = menuId;
  }
}
