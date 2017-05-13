/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import id.co.sim.mobsur.bean.support.RecordAuditBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * POJO table MASTER_TASK_STATUS
 * @created Feb 7, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_TASK_STATUS")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterTaskStatus extends RecordAuditBean {

  @Id
  @Column(name="TASK_STATUS_ID")
  private int taskStatusId;
  @Column(name="TASK_STATUS_CODE")
  private String taskStatusCode;
  @Column(name="TASK_STATUS_NAME")
  private String taskStatusName;

  /**
   * @return the taskStatusId
   */
  public int getTaskStatusId() {
    return taskStatusId;
  }

  /**
   * @param taskStatusId the taskStatusId to set
   */
  public void setTaskStatusId(int taskStatusId) {
    this.taskStatusId = taskStatusId;
  }

  /**
   * @return the taskStatusCode
   */
  public String getTaskStatusCode() {
    return taskStatusCode;
  }

  /**
   * @param taskStatusCode the taskStatusCode to set
   */
  public void setTaskStatusCode(String taskStatusCode) {
    this.taskStatusCode = taskStatusCode;
  }

  /**
   * @return the taskStatusName
   */
  public String getTaskStatusName() {
    return taskStatusName;
  }

  /**
   * @param taskStatusName the taskStatusName to set
   */
  public void setTaskStatusName(String taskStatusName) {
    this.taskStatusName = taskStatusName;
  }

}
