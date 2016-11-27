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
 * @created Oct 16, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_ROLE_MENU")
public class MasterRoleMenu extends RecordControllerBean implements Serializable {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ROLE_MENU_ID")
  private int roleMenuId;
  @Column(name="ROLE_MENU_DESC")
  private String roleMenuDesc;
  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name="ROLE_ID")
  private MasterRole role;
  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name="MENU_ID")
  private MasterMenu menu;  

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
   * @return the menu
   */
  public MasterMenu getMenu() {
    return menu;
  }

  /**
   * @param menu the menu to set
   */
  public void setMenu(MasterMenu menu) {
    this.menu = menu;
  }
}
