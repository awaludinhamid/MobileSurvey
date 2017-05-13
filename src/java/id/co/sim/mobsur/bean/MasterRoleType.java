/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import id.co.sim.mobsur.bean.support.RecordAuditBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * POJO table MASTER_ROLE_TYPE
 * @created Feb 3, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_ROLE_TYPE")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterRoleType extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ROLE_TYPE_ID")
  private int roleTypeId;
  @Column(name="ROLE_TYPE_CODE")
  private String roleTypeCode;
  @Column(name="ROLE_TYPE_DESC")
  private String roleTypeDesc;

  /**
   * @return the roleTypeId
   */
  public int getRoleTypeId() {
    return roleTypeId;
  }

  /**
   * @param roleTypeId the roleTypeId to set
   */
  public void setRoleTypeId(int roleTypeId) {
    this.roleTypeId = roleTypeId;
  }

  /**
   * @return the roleTypeCode
   */
  public String getRoleTypeCode() {
    return roleTypeCode;
  }

  /**
   * @param roleTypeCode the roleTypeCode to set
   */
  public void setRoleTypeCode(String roleTypeCode) {
    this.roleTypeCode = roleTypeCode;
  }

  /**
   * @return the roleTypeDesc
   */
  public String getRoleTypeDesc() {
    return roleTypeDesc;
  }

  /**
   * @param roleTypeDesc the roleTypeDesc to set
   */
  public void setRoleTypeDesc(String roleTypeDesc) {
    this.roleTypeDesc = roleTypeDesc;
  }
}
