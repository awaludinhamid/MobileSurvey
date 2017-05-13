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
 * POJO table MASTER_ZIPCODE
 * @created Nov 26, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_ZIPCODE")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterZipcode extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ZIPCODE_ID")
  private int zipcodeId;
  @Column(name="ZIPCODE_CODE")
  private String zipcodeCode;
  @Column(name="ZIPCODE_DESC")
  private String zipcodeDesc;
  /*@ManyToOne
  @JoinColumn(name="KEC_ID")
  private MasterKecamatan kecamatan;*/
  @ManyToOne
  @JoinColumn(name="CITY_ID")
  private MasterCity city;

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
   * @return the city
   */
  public MasterCity getCity() {
    return city;
  }

  /**
   * @param city the city to set
   */
  public void setCity(MasterCity city) {
    this.city = city;
  }
}
