/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import id.co.sim.mobsur.bean.support.RecordControllerBean;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @created Apr 14, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_USER_ROLE")
public class MasterUserRole extends RecordControllerBean implements Serializable {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="USER_ROLE_ID")
  private int userRoleId;
  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name="ROLE_ID")
  private MasterRole role;
  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name="USER_ID")
  private MasterUser user;

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
   * @return the role
   */
  public MasterRole getRole() {
    return role;
  }

  /**
   * @param role the role to set
   */
  public void setRole(MasterRole role) {
    this.role = role;
  }

  /**
   * @return the user
   */
  public MasterUser getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public void setUser(MasterUser user) {
    this.user = user;
  }
}
