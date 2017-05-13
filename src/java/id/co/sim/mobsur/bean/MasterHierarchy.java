/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import id.co.sim.mobsur.bean.support.RecordControllerBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * POJO table MASTER_HIERARCHY
 * @created Nov 29, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_HIERARCHY")
public class MasterHierarchy extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="HIE_ID")
  private int hieId;
  @ManyToOne
  @JoinColumn(name="ROLE_ID")
  private MasterRole role;
  @ManyToOne
  @JoinColumn(name="ROLE_ID_UP")
  private MasterRole roleUp;
  @ManyToOne
  @JoinColumn(name="COY_ID")
  private MasterCompany company;

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
   * @return the roleUp
   */
  public MasterRole getRoleUp() {
    return roleUp;
  }

  /**
   * @param roleUp the roleUp to set
   */
  public void setRoleUp(MasterRole roleUp) {
    this.roleUp = roleUp;
  }

  /**
   * @return the company
   */
  public MasterCompany getCompany() {
    return company;
  }

  /**
   * @param company the company to set
   */
  public void setCompany(MasterCompany company) {
    this.company = company;
  }
}
