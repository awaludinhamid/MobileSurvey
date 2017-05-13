/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * DTO table MASTER_USER
 * @created Nov 18, 2016
 * @author awal
 */
public class MasterUserDTO extends RecordControllerBeanDTO {

  private int userId;
  private String userCode;
  private String userName;
  private String userPassword;  
  private String isVerif;  
  private String userEmail;
  private String userImei;
  private int officeId;

  /**
   * @return the userId
   */
  public int getUserId() {
    return userId;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(int userId) {
    this.userId = userId;
  }

  /**
   * @return the userCode
   */
  public String getUserCode() {
    return userCode;
  }

  /**
   * @param userCode the userCode to set
   */
  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * @return the userPassword
   */
  public String getUserPassword() {
    return userPassword;
  }

  /**
   * @param userPassword the userPassword to set
   */
  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  /**
   * @return the isVerif
   */
  public String getIsVerif() {
    return isVerif;
  }

  /**
   * @param isVerif the isVerif to set
   */
  public void setIsVerif(String isVerif) {
    this.isVerif = isVerif;
  }

  /**
   * @return the userEmail
   */
  public String getUserEmail() {
    return userEmail;
  }

  /**
   * @param userEmail the userEmail to set
   */
  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  /**
   * @return the officeId
   */
  public int getOfficeId() {
    return officeId;
  }

  /**
   * @param officeId the officeId to set
   */
  public void setOfficeId(int officeId) {
    this.officeId = officeId;
  }

  /**
   * @return the userImei
   */
  public String getUserImei() {
    return userImei;
  }

  /**
   * @param userImei the userImei to set
   */
  public void setUserImei(String userImei) {
    this.userImei = userImei;
  }
  
}
