/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import id.co.sim.mobsur.bean.support.RecordControllerBean;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @created Oct 19, 2016
 * @author awal
 */
@Entity
@Table(name="DETAIL_COMPANY_LOGO")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="detailCompanyLogo")
public class DetailCompanyLogo implements Serializable {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="COMPANY_LOGO_ID")
  private int companyLogoId;
  @JsonIgnore
  @Column(name="LOGO_PICTURE")
  private byte[] logoPicture;
  @JsonBackReference
  @OneToOne(mappedBy="detailCompanyLogo")
  private MasterCompany company;

  /**
   * @return the companyLogoId
   */
  public int getCompanyLogoId() {
    return companyLogoId;
  }

  /**
   * @param companyLogoId the companyLogoId to set
   */
  public void setCompanyLogoId(int companyLogoId) {
    this.companyLogoId = companyLogoId;
  }

  /**
   * @return the logoPicture
   */
  public byte[] getLogoPicture() {
    return logoPicture;
  }

  /**
   * @param logoPicture the logoPicture to set
   */
  public void setLogoPicture(byte[] logoPicture) {
    this.logoPicture = logoPicture;
  }

  /**
   * @return the company
   */
  public MasterCompany getCompany() {
    return company;
  }

  /**
   * @param company the company to set
   */
  public void setCompany(MasterCompany company) {
    this.company = company;
  }
}
