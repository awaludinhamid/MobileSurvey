/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

/**
 * DTO table MASTER_ZIPCODE_VERIFICATOR
 * @created Jan 23, 2017
 * @author awal
 */
public class MasterZipcodeVerificatorDTO {

  private int zipcodeVerifId;
  private String subZipcode;
  private String description;
  private int zipcodeId;
  private int verificatorId;
  private String createdBy;
  private String updatedBy;

  /**
   * @return the zipcodeVerifId
   */
  public int getZipcodeVerifId() {
    return zipcodeVerifId;
  }

  /**
   * @param zipcodeVerifId the zipcodeVerifId to set
   */
  public void setZipcodeVerifId(int zipcodeVerifId) {
    this.zipcodeVerifId = zipcodeVerifId;
  }

  /**
   * @return the subZipcode
   */
  public String getSubZipcode() {
    return subZipcode;
  }

  /**
   * @param subZipcode the subZipcode to set
   */
  public void setSubZipcode(String subZipcode) {
    this.subZipcode = subZipcode;
  }

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
   * @return the verificatorId
   */
  public int getVerificatorId() {
    return verificatorId;
  }

  /**
   * @param verificatorId the verificatorId to set
   */
  public void setVerificatorId(int verificatorId) {
    this.verificatorId = verificatorId;
  }

  /**
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * @param createdBy the createdBy to set
   */
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * @param updatedBy the updatedBy to set
   */
  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }
}
