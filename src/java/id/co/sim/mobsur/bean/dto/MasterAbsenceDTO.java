/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * @created Jan 26, 2017
 * @author awal
 */
public class MasterAbsenceDTO extends RecordControllerBeanDTO {

  private int absenceId;
  private String description;
  private int userId;
  private int reasonTypeId;

  /**
   * @return the absenceId
   */
  public int getAbsenceId() {
    return absenceId;
  }

  /**
   * @param absenceId the absenceId to set
   */
  public void setAbsenceId(int absenceId) {
    this.absenceId = absenceId;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
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

  /**
   * @return the reasonTypeId
   */
  public int getReasonTypeId() {
    return reasonTypeId;
  }

  /**
   * @param reasonTypeId the reasonTypeId to set
   */
  public void setReasonTypeId(int reasonTypeId) {
    this.reasonTypeId = reasonTypeId;
  }
}
