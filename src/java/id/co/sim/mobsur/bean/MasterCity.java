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
 * POJO table MASTER_CITY
 * @created Dec 16, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_CITY")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterCity extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="CITY_ID")
  private int cityId;
  @Column(name="CITY_CODE")
  private String cityCode;
  @Column(name="CITY_NAME")
  private String cityName;
  @ManyToOne
  @JoinColumn(name="PROV_ID")
  private MasterProvinsi provinsi;

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
   * @return the provinsi
   */
  public MasterProvinsi getProvinsi() {
    return provinsi;
  }

  /**
   * @param provinsi the provinsi to set
   */
  public void setProvinsi(MasterProvinsi provinsi) {
    this.provinsi = provinsi;
  }
  
}
