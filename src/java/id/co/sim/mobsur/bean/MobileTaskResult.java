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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * POJO table MOBILE_TASK_RESULT
 * @created Feb 12, 2017
 * @author awal
 */
@Entity
@Table(name="MOBILE_TASK_RESULT")
@SuppressWarnings("PersistenceUnitPresent")
public class MobileTaskResult extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="TASK_RESULT_ID")
  private int taskResultId;
  @Column(name="MCC")
  private String mcc;
  @Column(name="MNC")
  private String mnc;
  @Column(name="LAC")
  private String lac;
  @Column(name="CELL_ID")
  private String cellId;
  @Column(name="IS_GPS")
  private String isGps;
  @Column(name="ACCURACY")
  private Integer accuracy;
  @Column(name="GPS_LATITUDE")
  private Double gpsLatitude;
  @Column(name="GPS_LONGITUDE")
  private Double gpsLongitude;
  @ManyToOne
  @JoinColumn(name="TASK_ID")
  private MobileTaskAssignment task;

  /**
   * @return the taskResultId
   */
  public int getTaskResultId() {
    return taskResultId;
  }

  /**
   * @param taskResultId the taskResultId to set
   */
  public void setTaskResultId(int taskResultId) {
    this.taskResultId = taskResultId;
  }

  /**
   * @return the mcc
   */
  public String getMcc() {
    return mcc;
  }

  /**
   * @param mcc the mcc to set
   */
  public void setMcc(String mcc) {
    this.mcc = mcc;
  }

  /**
   * @return the mnc
   */
  public String getMnc() {
    return mnc;
  }

  /**
   * @param mnc the mnc to set
   */
  public void setMnc(String mnc) {
    this.mnc = mnc;
  }

  /**
   * @return the lac
   */
  public String getLac() {
    return lac;
  }

  /**
   * @param lac the lac to set
   */
  public void setLac(String lac) {
    this.lac = lac;
  }

  /**
   * @return the cellId
   */
  public String getCellId() {
    return cellId;
  }

  /**
   * @param cellId the cellId to set
   */
  public void setCellId(String cellId) {
    this.cellId = cellId;
  }

  /**
   * @return the isGps
   */
  public String getIsGps() {
    return isGps;
  }

  /**
   * @param isGps the isGps to set
   */
  public void setIsGps(String isGps) {
    this.isGps = isGps;
  }

  /**
   * @return the accuracy
   */
  public Integer getAccuracy() {
    return accuracy;
  }

  /**
   * @param accuracy the accuracy to set
   */
  public void setAccuracy(Integer accuracy) {
    this.accuracy = accuracy;
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
   * @return the task
   */
  public MobileTaskAssignment getTask() {
    return task;
  }

  /**
   * @param task the task to set
   */
  public void setTask(MobileTaskAssignment task) {
    this.task = task;
  }
}
