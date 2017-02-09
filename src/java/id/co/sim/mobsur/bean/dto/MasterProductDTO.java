/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * @created Jan 5, 2017
 * @author awal
 */
public class MasterProductDTO extends RecordControllerBeanDTO {

  private int productId;
  private String productCode;
  private String productName;
  private String isAutoSurvey;
  private Integer tempId;

  /**
   * @return the productId
   */
  public int getProductId() {
    return productId;
  }

  /**
   * @param productId the productId to set
   */
  public void setProductId(int productId) {
    this.productId = productId;
  }

  /**
   * @return the productCode
   */
  public String getProductCode() {
    return productCode;
  }

  /**
   * @param productCode the productCode to set
   */
  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  /**
   * @return the productName
   */
  public String getProductName() {
    return productName;
  }

  /**
   * @param productName the productName to set
   */
  public void setProductName(String productName) {
    this.productName = productName;
  }

  /**
   * @return the tempId
   */
  public Integer getTempId() {
    return tempId;
  }

  /**
   * @param tempId the tempId to set
   */
  public void setTempId(Integer tempId) {
    this.tempId = tempId;
  }

  /**
   * @return the isAutoSurvey
   */
  public String getIsAutoSurvey() {
    return isAutoSurvey;
  }

  /**
   * @param isAutoSurvey the isAutoSurvey to set
   */
  public void setIsAutoSurvey(String isAutoSurvey) {
    this.isAutoSurvey = isAutoSurvey;
  }
}
