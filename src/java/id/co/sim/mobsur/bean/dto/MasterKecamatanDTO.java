/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * DTO table MASTER_KECAMATAN
 * @created Dec 19, 2016
 * @author awal
 */
public class MasterKecamatanDTO extends RecordControllerBeanDTO {

  private int kecId;
  private String kecCode;
  private String kecName;
  private int cityId;

  /**
   * @return the kecId
   */
  public int getKecId() {
    return kecId;
  }

  /**
   * @param kecId the kecId to set
   */
  public void setKecId(int kecId) {
    this.kecId = kecId;
  }

  /**
   * @return the kecCode
   */
  public String getKecCode() {
    return kecCode;
  }

  /**
   * @param kecCode the kecCode to set
   */
  public void setKecCode(String kecCode) {
    this.kecCode = kecCode;
  }

  /**
   * @return the kecName
   */
  public String getKecName() {
    return kecName;
  }

  /**
   * @param kecName the kecName to set
   */
  public void setKecName(String kecName) {
    this.kecName = kecName;
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
