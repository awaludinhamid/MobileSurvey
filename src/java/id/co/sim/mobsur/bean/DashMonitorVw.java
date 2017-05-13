/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * POJO view DASH_MONITOR_VW
 * @author awal
 * @created Feb 22, 2017
 */
@Entity
@Table(name="DASH_MONITOR_VW")
@SuppressWarnings("PersistenceUnitPresent")
public class DashMonitorVw implements Serializable {

  @Id
  @Column(name="USER_ID")
  private int userId;
  @Column(name="USER_NAME")
  private String userName;
  @Column(name="OFFICE_ID")
  private int officeId;
  @Column(name="LAST_TASK_ID")
  private int lastTaskId;
  @Column(name="OS_TASK")
  private int osTask;
  @Column(name="SUBMIT_TASK")
  private int submitTask;
  @Column(name="LAST_ASSIGN_DATE")
  private String lastAssignDate;
  @Column(name="GPS_LATITUDE")
  private Double gpsLatitude;
  @Column(name="GPS_LONGITUDE")
  private Double gpsLongitude;

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
   * @return the lastTaskId
   */
  public int getLastTaskId() {
    return lastTaskId;
  }

  /**
   * @param lastTaskId the lastTaskId to set
   */
  public void setLastTaskId(int lastTaskId) {
    this.lastTaskId = lastTaskId;
  }

  /**
   * @return the osTask
   */
  public int getOsTask() {
    return osTask;
  }

  /**
   * @param osTask the osTask to set
   */
  public void setOsTask(int osTask) {
    this.osTask = osTask;
  }

  /**
   * @return the submitTask
   */
  public int getSubmitTask() {
    return submitTask;
  }

  /**
   * @param submitTask the submitTask to set
   */
  public void setSubmitTask(int submitTask) {
    this.submitTask = submitTask;
  }

  /**
   * @return the gpsLatitude
   */
  public Double getGpsLatitude() {
    return gpsLatitude;
  }

  /**
   * @param gpsLatitude the gpsLatitude to set
   */
  public void setGpsLatitude(Double gpsLatitude) {
    this.gpsLatitude = gpsLatitude;
  }

  /**
   * @return the gpsLongitude
   */
  public Double getGpsLongitude() {
    return gpsLongitude;
  }

  /**
   * @param gpsLongitude the gpsLongitude to set
   */
  public void setGpsLongitude(Double gpsLongitude) {
    this.gpsLongitude = gpsLongitude;
  }

  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
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
   * @return the lastAssignDate
   */
  public String getLastAssignDate() {
    return lastAssignDate;
  }

  /**
   * @param lastAssignDate the lastAssignDate to set
   */
  public void setLastAssignDate(String lastAssignDate) {
    this.lastAssignDate = lastAssignDate;
  }
}
