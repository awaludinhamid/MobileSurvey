/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * DTO table MASTER_PROVINSI
 * @created Dec 19, 2016
 * @author awal
 */
public class MasterProvinsiDTO extends RecordControllerBeanDTO {

  private int provId;
  private String provCode;
  private String provName;

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

  /**
   * @return the provCode
   */
  public String getProvCode() {
    return provCode;
  }

  /**
   * @param provCode the provCode to set
   */
  public void setProvCode(String provCode) {
    this.provCode = provCode;
  }

  /**
   * @return the provName
   */
  public String getProvName() {
    return provName;
  }

  /**
   * @param provName the provName to set
   */
  public void setProvName(String provName) {
    this.provName = provName;
  }
}
