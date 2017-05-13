/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * DTO table MASTER_KELURAHAN
 * @created Dec 23, 2016
 * @author awal
 */
public class MasterKelurahanDTO extends RecordControllerBeanDTO {

  private int kelId;
  private String kelCode;
  private String kelName;
  private int kecId;
  private Integer zipcodeId;

  /**
   * @return the kelId
   */
  public int getKelId() {
    return kelId;
  }

  /**
   * @param kelId the kelId to set
   */
  public void setKelId(int kelId) {
    this.kelId = kelId;
  }

  /**
   * @return the kelCode
   */
  public String getKelCode() {
    return kelCode;
  }

  /**
   * @param kelCode the kelCode to set
   */
  public void setKelCode(String kelCode) {
    this.kelCode = kelCode;
  }

  /**
   * @return the kelName
   */
  public String getKelName() {
    return kelName;
  }

  /**
   * @param kelName the kelName to set
   */
  public void setKelName(String kelName) {
    this.kelName = kelName;
  }

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
   * @return the zipcodeId
   */
  public Integer getZipcodeId() {
    return zipcodeId;
  }

  /**
   * @param zipcodeId the zipcodeId to set
   */
  public void setZipcodeId(Integer zipcodeId) {
    this.zipcodeId = zipcodeId;
  }
}
