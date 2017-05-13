/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

/**
 * DTO table MASTER_JOB_ASSIGNMENT
 * @created Jan 17, 2017
 * @author awal
 */
public class MasterJobAssignmentDTO {

  private int jobAssignId;
  private int userCommissionedId;
  private int userAssignedId;  
  private String createdBy;
  private String updatedBy;

  /**
   * @return the jobAssignId
   */
  public int getJobAssignId() {
    return jobAssignId;
  }

  /**
   * @param jobAssignId the jobAssignId to set
   */
  public void setJobAssignId(int jobAssignId) {
    this.jobAssignId = jobAssignId;
  }

  /**
   * @return the userCommissionedId
   */
  public int getUserCommissionedId() {
    return userCommissionedId;
  }

  /**
   * @param userCommissionedId the userCommissionedId to set
   */
  public void setUserCommissionedId(int userCommissionedId) {
    this.userCommissionedId = userCommissionedId;
  }

  /**
   * @return the userAssignedId
   */
  public int getUserAssignedId() {
    return userAssignedId;
  }

  /**
   * @param userAssignedId the userAssignedId to set
   */
  public void setUserAssignedId(int userAssignedId) {
    this.userAssignedId = userAssignedId;
  }

  /**
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * @param createdBy the createdBy to set
   */
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * @param updatedBy the updatedBy to set
   */
  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }
}
