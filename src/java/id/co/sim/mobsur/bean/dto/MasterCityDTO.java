/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * @created Dec 19, 2016
 * @author awal
 */
public class MasterCityDTO extends RecordControllerBeanDTO {

  private int cityId;
  private String cityCode;
  private String cityName;
  private int provId;

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

  /**
   * @return the cityCode
   */
  public String getCityCode() {
    return cityCode;
  }

  /**
   * @param cityCode the cityCode to set
   */
  public void setCityCode(String cityCode) {
    this.cityCode = cityCode;
  }

  /**
   * @return the cityName
   */
  public String getCityName() {
    return cityName;
  }

  /**
   * @param cityName the cityName to set
   */
  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  /**
   * @return the provId
   */
  public int getProvId() {
    return provId;
  }

  /**
   * @param provId the provId to set
   */
  public void setProvId(int provId) {
    this.provId = provId;
  }
}
