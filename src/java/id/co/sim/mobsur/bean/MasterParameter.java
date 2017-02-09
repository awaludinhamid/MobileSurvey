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
 * @created Nov 18, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_PARAMETER")
public class MasterParameter extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="PAR_ID")
  private int parId;
  @Column(name="PAR_CODE")
  private String parCode;
  @Column(name="PAR_DESC")
  private String parDesc;
  @Column(name="PAR_APPS_TYPE")
  private String parAppsType;
  @Column(name="PAR_DATA_TYPE")
  private String parDataType;
  @Column(name="PAR_VALUE")
  private String parValue;
  @ManyToOne
  @JoinColumn(name="COY_ID")
  private MasterCompany company;

  /**
   * @return the parId
   */
  public int getParId() {
    return parId;
  }

  /**
   * @param parId the parId to set
   */
  public void setParId(int parId) {
    this.parId = parId;
  }

  /**
   * @return the parCode
   */
  public String getParCode() {
    return parCode;
  }

  /**
   * @param parCode the parCode to set
   */
  public void setParCode(String parCode) {
    this.parCode = parCode;
  }

  /**
   * @return the parDesc
   */
  public String getParDesc() {
    return parDesc;
  }

  /**
   * @param parDesc the parDesc to set
   */
  public void setParDesc(String parDesc) {
    this.parDesc = parDesc;
  }

  /**
   * @return the parAppsType
   */
  public String getParAppsType() {
    return parAppsType;
  }

  /**
   * @param parAppsType the parAppsType to set
   */
  public void setParAppsType(String parAppsType) {
    this.parAppsType = parAppsType;
  }

  /**
   * @return the parDataType
   */
  public String getParDataType() {
    return parDataType;
  }

  /**
   * @param parDataType the parDataType to set
   */
  public void setParDataType(String parDataType) {
    this.parDataType = parDataType;
  }

  /**
   * @return the parValue
   */
  public String getParValue() {
    return parValue;
  }

  /**
   * @param parValue the parValue to set
   */
  public void setParValue(String parValue) {
    this.parValue = parValue;
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
