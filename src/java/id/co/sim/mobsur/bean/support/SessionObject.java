/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.support;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * @created Oct 31, 2016
 * @author awal
 */
public class SessionObject {

  private int userId;
  private String userName;
  private String realName;
  private String sessionId;
  private String hasRole;
  private String isValid;

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
   * @return the realName
   */
  public String getRealName() {
    return realName;
  }

  /**
   * @param realName the realName to set
   */
  public void setRealName(String realName) {
    this.realName = realName;
  }

  /**
   * @return the sessionId
   */
  public String getSessionId() {
    return sessionId;
  }

  /**
   * @param sessionId the sessionId to set
   */
  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  /**
   * @return the hasRole
   */
  public String getHasRole() {
    return hasRole;
  }

  /**
   * @param hasRole the hasRole to set
   */
  public void setHasRole(String hasRole) {
    this.hasRole = hasRole;
  }

  /**
   * @return the isValid
   */
  public String getIsValid() {
    return isValid;
  }

  /**
   * @param isValid the isValid to set
   */
  public void setIsValid(String isValid) {
    this.isValid = isValid;
  }
}
