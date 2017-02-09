/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * @created Nov 16, 2016
 * @author awal
 */
public class MasterCompanyDTO extends RecordControllerBeanDTO {

  private int coyId;
  private String coyCode;
  private String coyName;
  private String address;
  private String phone;
  private String mouNo;
  private String picName;
  private String hpNo;
  private int noOfUsers;
  private String systemName;
  private int companyLogoId;

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

}
