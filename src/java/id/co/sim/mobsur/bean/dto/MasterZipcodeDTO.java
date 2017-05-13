/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * DTO table MASTER_ZIPCODE
 * @created Dec 23, 2016
 * @author awal
 */
public class MasterZipcodeDTO extends RecordControllerBeanDTO {

  private int zipcodeId;
  private String zipcodeCode;
  private String zipcodeDesc;
  //private int kecId;
  private int cityId;

  /**
   * @return the zipcodeId
   */
  public int getZipcodeId() {
    return zipcodeId;
  }

  /**
   * @param zipcodeId the zipcodeId to set
   */
  public void setZipcodeId(int zipcodeId) {
    this.zipcodeId = zipcodeId;
  }

  /**
   * @return the zipcodeCode
   */
  public String getZipcodeCode() {
    return zipcodeCode;
  }

  /**
   * @param zipcodeCode the zipcodeCode to set
   */
  public void setZipcodeCode(String zipcodeCode) {
    this.zipcodeCode = zipcodeCode;
  }

  /**
   * @return the zipcodeDesc
   */
  public String getZipcodeDesc() {
    return zipcodeDesc;
  }

  /**
   * @param zipcodeDesc the zipcodeDesc to set
   */
  public void setZipcodeDesc(String zipcodeDesc) {
    this.zipcodeDesc = zipcodeDesc;
  }

  /**
   * @return the cityId
   */
  public int getCityId() {
    return cityId;
  }

  /**
   * @param cityId the cityId to set
   */
  public void setCityId(int cityId) {
    this.cityId = cityId;
  }
}
