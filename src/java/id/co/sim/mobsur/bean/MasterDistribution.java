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
 * @created Dec 4, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_DISTRIBUTION")
public class MasterDistribution extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="DIST_ID")
  private int distId;
  @Column(name="IS_AUTO_DIST")
  private String isAutoDist;
  @Column(name="METHOD_TYPE")
  private String methodType;
  @ManyToOne
  @JoinColumn(name="OFFICE_ID")
  private MasterOffice office;
  @ManyToOne
  @JoinColumn(name="ROLE_ASSIGN_TO")
  private MasterRole roleAssignTo;

  /**
   * @return the distId
   */
  public int getDistId() {
    return distId;
  }

  /**
   * @param distId the distId to set
   */
  public void setDistId(int distId) {
    this.distId = distId;
  }

  /**
   * @return the isAutoDist
   */
  public String getIsAutoDist() {
    return isAutoDist;
  }

  /**
   * @param isAutoDist the isAutoDist to set
   */
  public void setIsAutoDist(String isAutoDist) {
    this.isAutoDist = isAutoDist;
  }

  /**
   * @return the methodType
   */
  public String getMethodType() {
    return methodType;
  }

  /**
   * @param methodType the methodType to set
   */
  public void setMethodType(String methodType) {
    this.methodType = methodType;
  }

  /**
   * @return the office
   */
  public MasterOffice getOffice() {
    return office;
  }

  /**
   * @param office the office to set
   */
  public void setOffice(MasterOffice office) {
    this.office = office;
  }

  /**
   * @return the roleAssignTo
   */
  public MasterRole getRoleAssignTo() {
    return roleAssignTo;
  }

  /**
   * @param roleAssignTo the roleAssignTo to set
   */
  public void setRoleAssignTo(MasterRole roleAssignTo) {
    this.roleAssignTo = roleAssignTo;
  }
}
