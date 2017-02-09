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
 * @created Dec 16, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_KECAMATAN")
public class MasterKecamatan extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="KEC_ID")
  private int kecId;
  @Column(name="KEC_CODE")
  private String kecCode;
  @Column(name="KEC_NAME")
  private String kecName;
  @ManyToOne
  @JoinColumn(name="CITY_ID")
  private MasterCity city;

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
