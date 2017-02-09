/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import id.co.sim.mobsur.bean.support.RecordControllerBean;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @created Apr 4, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_ROLE")
public class MasterRole extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ROLE_ID")
  private int roleId;
  @Column(name="ROLE_CODE")
  private String roleCode;
  @Column(name="ROLE_NAME")
  private String roleName;
  @Column(name="ROLE_DESC")
  private String roleDesc;
  @Column(name="ROLE_LEVEL")
  private int roleLevel;
  @ManyToOne
  @JoinColumn(name="ROLE_TYPE_ID")
  private MasterRoleType roleType; 
  @JsonBackReference
  @OneToMany(mappedBy="role")
  private List<MasterRoleMenu> roleMenus;
  @JsonBackReference
  @OneToMany(mappedBy="role")
  private List<MasterUserRole> userRoles;

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
   * @return the roleMenus
   */
  public List<MasterRoleMenu> getRoleMenus() {
    return roleMenus;
  }

  /**
   * @param roleMenus the roleMenus to set
   */
  public void setRoleMenus(List<MasterRoleMenu> roleMenus) {
    this.roleMenus = roleMenus;
  }

  /**
   * @return the userRoles
   */
  public List<MasterUserRole> getUserRoles() {
    return userRoles;
  }

  /**
   * @param userRoles the userRoles to set
   */
  public void setUserRoles(List<MasterUserRole> userRoles) {
    this.userRoles = userRoles;
  }

  /**
   * @return the roleLevel
   */
  public int getRoleLevel() {
    return roleLevel;
  }

  /**
   * @param roleLevel the roleLevel to set
   */
  public void setRoleLevel(int roleLevel) {
    this.roleLevel = roleLevel;
  }

  /**
   * @return the roleType
   */
  public MasterRoleType getRoleType() {
    return roleType;
  }

  /**
   * @param roleType the roleType to set
   */
  public void setRoleType(MasterRoleType roleType) {
    this.roleType = roleType;
  }
}
