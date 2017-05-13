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
 * POJO table MASTER_PRODUCT
 * @created Jan 5, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_PRODUCT")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterProduct extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="PRODUCT_ID")
  private int productId;
  @Column(name="PRODUCT_CODE")
  private String productCode;
  @Column(name="PRODUCT_NAME")
  private String productName;
  @Column(name="IS_AUTO_SURVEY")
  private String isAutoSurvey;
  @ManyToOne
  @JoinColumn(name="TEMP_ID")
  private MasterTemplate template;

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
   * @return the template
   */
  public MasterTemplate getTemplate() {
    return template;
  }

  /**
   * @param template the template to set
   */
  public void setTemplate(MasterTemplate template) {
    this.template = template;
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
