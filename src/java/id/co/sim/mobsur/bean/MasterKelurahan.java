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
@Table(name="MASTER_KELURAHAN")
public class MasterKelurahan extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="KEL_ID")
  private int kelId;
  @Column(name="KEL_CODE")
  private String kelCode;
  @Column(name="KEL_NAME")
  private String kelName;
  @ManyToOne
  @JoinColumn(name="KEC_ID")
  private MasterKecamatan kecamatan;
  @ManyToOne
  @JoinColumn(name="ZIPCODE_ID")
  private MasterZipcode zipcode;

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
   * @return the kecamatan
   */
  public MasterKecamatan getKecamatan() {
    return kecamatan;
  }

  /**
   * @param kecamatan the kecamatan to set
   */
  public void setKecamatan(MasterKecamatan kecamatan) {
    this.kecamatan = kecamatan;
  }

  /**
   * @return the zipcode
   */
  public MasterZipcode getZipcode() {
    return zipcode;
  }

  /**
   * @param zipcode the zipcode to set
   */
  public void setZipcode(MasterZipcode zipcode) {
    this.zipcode = zipcode;
  }
}
