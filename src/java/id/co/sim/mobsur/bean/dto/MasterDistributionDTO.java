/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * @created Dec 4, 2016
 * @author awal
 */
public class MasterDistributionDTO extends RecordControllerBeanDTO {

  private int distId;
  private String isAutoDist;
  private String methodType;
  private int officeId;
  private int roleId;

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
   * @return the officeId
   */
  public int getOfficeId() {
    return officeId;
  }

  /**
   * @param officeId the officeId to set
   */
  public void setOfficeId(int officeId) {
    this.officeId = officeId;
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
}
