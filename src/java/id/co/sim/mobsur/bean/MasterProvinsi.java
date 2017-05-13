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
import javax.persistence.Table;

/**
 * POJO table MASTER_PROVINSI
 * @created Dec 16, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_PROVINSI")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterProvinsi extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="PROV_ID")
  private int provId;
  @Column(name="PROV_CODE")
  private String provCode;
  @Column(name="PROV_NAME")
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
