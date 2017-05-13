/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import id.co.sim.mobsur.bean.support.RecordControllerBean;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * POJO table MASTER_COMPANY
 * @created Oct 12, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_COMPANY")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterCompany extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="COY_ID")
  private int coyId;
  @Column(name="COY_CODE")
  private String coyCode;
  @Column(name="COY_NAME")
  private String coyName;
  @Column(name="ADDRESS")
  private String address;
  @Column(name="PHONE")
  private String phone;
  @Column(name="MOU_NO")
  private String mouNo;
  @Column(name="PIC_NAME")
  private String picName;
  @Column(name="HP_NO")
  private String hpNo;
  @Column(name="NO_OF_USERS")
  private int noOfUsers;
  @Column(name="SYSTEM_NAME")
  private String systemName;
  @JsonManagedReference
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="COMPANY_LOGO_ID")
  private DetailCompanyLogo detailCompanyLogo;
  @JsonBackReference
  @OneToMany(mappedBy="company")
  private List<MasterOffice> offices;

  /**
   * @return the coyId
   */
  public int getCoyId() {
    return coyId;
  }

  /**
   * @param coyId the coyId to set
   */
  public void setCoyId(int coyId) {
    this.coyId = coyId;
  }

  /**
   * @return the coyCode
   */
  public String getCoyCode() {
    return coyCode;
  }

  /**
   * @param coyCode the coyCode to set
   */
  public void setCoyCode(String coyCode) {
    this.coyCode = coyCode;
  }

  /**
   * @return the coyName
   */
  public String getCoyName() {
    return coyName;
  }

  /**
   * @param coyName the coyName to set
   */
  public void setCoyName(String coyName) {
    this.coyName = coyName;
  }

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * @param phone the phone to set
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * @return the mouNo
   */
  public String getMouNo() {
    return mouNo;
  }

  /**
   * @param mouNo the mouNo to set
   */
  public void setMouNo(String mouNo) {
    this.mouNo = mouNo;
  }

  /**
   * @return the picName
   */
  public String getPicName() {
    return picName;
  }

  /**
   * @param picName the picName to set
   */
  public void setPicName(String picName) {
    this.picName = picName;
  }

  /**
   * @return the hpNo
   */
  public String getHpNo() {
    return hpNo;
  }

  /**
   * @param hpNo the hpNo to set
   */
  public void setHpNo(String hpNo) {
    this.hpNo = hpNo;
  }

  /**
   * @return the noOfUsers
   */
  public int getNoOfUsers() {
    return noOfUsers;
  }

  /**
   * @param noOfUsers the noOfUsers to set
   */
  public void setNoOfUsers(int noOfUsers) {
    this.noOfUsers = noOfUsers;
  }

  /**
   * @return the systemName
   */
  public String getSystemName() {
    return systemName;
  }

  /**
   * @param systemName the systemName to set
   */
  public void setSystemName(String systemName) {
    this.systemName = systemName;
  }

  /**
   * @return the detailCompanyLogo
   */
  public DetailCompanyLogo getDetailCompanyLogo() {
    return detailCompanyLogo;
  }

  /**
   * @param detailCompanyLogo the detailCompanyLogo to set
   */
  public void setDetailCompanyLogo(DetailCompanyLogo detailCompanyLogo) {
    this.detailCompanyLogo = detailCompanyLogo;
  }

  /**
   * @return the offices
   */
  public List<MasterOffice> getOffices() {
    return offices;
  }

  /**
   * @param offices the offices to set
   */
  public void setOffices(List<MasterOffice> offices) {
    this.offices = offices;
  }
}
