/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * @created Nov 29, 2016
 * @author awal
 */
public class MasterHierarchyDTO extends RecordControllerBeanDTO {

  private int hieId;
  private int roleId;
  private Integer roleIdUp;
  private int coyId;

  /**
   * @return the hieId
   */
  public int getHieId() {
    return hieId;
  }

  /**
   * @param hieId the hieId to set
   */
  public void setHieId(int hieId) {
    this.hieId = hieId;
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
   * @return the roleIdUp
   */
  public Integer getRoleIdUp() {
    return roleIdUp;
  }

  /**
   * @param roleIdUp the roleIdUp to set
   */
  public void setRoleIdUp(Integer roleIdUp) {
    this.roleIdUp = roleIdUp;
  }

  /**
   * @return the coyId
   */
  public int getCoyId() {
    return coyId;
  }

  /**
   * @param coyId the coyId to set
   */
  public void setCoyId(int coyId) {
    this.coyId = coyId;
  }
}
