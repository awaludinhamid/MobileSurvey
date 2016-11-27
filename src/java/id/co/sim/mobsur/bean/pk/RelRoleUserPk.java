/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.pk;

import java.io.Serializable;
import javax.persistence.Column;

/**
 * @created Aug 3, 2016
 * @author awal
 */
public class RelRoleUserPk implements Serializable {

  @Column(name="ROLE_ID")
  private int roleId;
  @Column(name="USER_ID")
  private int userId;

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

  @Override
  public int hashCode() {
      return roleId + userId;
  }

  @Override
  public boolean equals(Object obj) {
      if(obj == null) return false;
      if(obj == this) return true;
      if(!(obj instanceof RelRoleUserPk)) return false;
      RelRoleUserPk rrup = (RelRoleUserPk) obj;
      return rrup.roleId == roleId &&
              rrup.userId == userId;
  }
  
}
