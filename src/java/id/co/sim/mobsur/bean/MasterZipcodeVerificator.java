/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import id.co.sim.mobsur.bean.support.RecordAuditBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * POJO table MASTER_ZIPCODE_VERIFICATOR
 * @created Jan 23, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_ZIPCODE_VERIFICATOR")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterZipcodeVerificator extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ZIPCODE_VERIF_ID")
  private int zipcodeVerifId;
  @Column(name="SUB_ZIPCODE")
  private String subZipcode;
  @Column(name="DESCRIPTION")
  private String description;
  @ManyToOne
  @JoinColumn(name="ZIPCODE_ID")
  private MasterZipcode zipcode;
  @ManyToOne
  @JoinColumn(name="VERIFICATOR_ID")
  private MasterUser verificator;

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

  /**
   * @return the verificator
   */
  public MasterUser getVerificator() {
    return verificator;
  }

  /**
   * @param verificator the verificator to set
   */
  public void setVerificator(MasterUser verificator) {
    this.verificator = verificator;
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
