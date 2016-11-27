/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import id.co.sim.mobsur.bean.support.RecordControllerBean;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @created Nov 26, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_ZIPCODE")
public class MasterZipcode extends RecordControllerBean implements Serializable {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ZIPCODE_ID")
  private int zipcodeId;
  @Column(name="ZIPCODE_CODE")
  private String zipcodeCode;
  @Column(name="ZIPCODE_DESC")
  private String zipcodeDesc;
  @Column(name="KELURAHAN")
  private String kelurahan;
  @Column(name="KECAMATAN")
  private String kecamatan;
  @Column(name="CITY")
  private String city;
  @Column(name="PROVINSI")
  private String provinsi;

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
   * @return the kelurahan
   */
  public String getKelurahan() {
    return kelurahan;
  }

  /**
   * @param kelurahan the kelurahan to set
   */
  public void setKelurahan(String kelurahan) {
    this.kelurahan = kelurahan;
  }

  /**
   * @return the kecamatan
   */
  public String getKecamatan() {
    return kecamatan;
  }

  /**
   * @param kecamatan the kecamatan to set
   */
  public void setKecamatan(String kecamatan) {
    this.kecamatan = kecamatan;
  }

  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return the provinsi
   */
  public String getProvinsi() {
    return provinsi;
  }

  /**
   * @param provinsi the provinsi to set
   */
  public void setProvinsi(String provinsi) {
    this.provinsi = provinsi;
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
}
