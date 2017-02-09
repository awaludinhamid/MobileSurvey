/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * @created Nov 29, 2016
 * @author awal
 */
public class MasterParameterDTO extends RecordControllerBeanDTO {

  private int parId;
  private String parCode;
  private String parDesc;
  private String parAppsType;
  private String parDataType;
  private String parValue;
  private int coyId;

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
   * @return the coyId
   */
  public int getCoyId() {
    return coyId;
  }

  /**
   * @param coyId the coyId to set
   */
  public void setCoyId(int coyId) {
    this.coyId = coyId;
  }
}
