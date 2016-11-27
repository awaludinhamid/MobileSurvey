/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import id.co.sim.mobsur.bean.support.RecordControllerBean;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @created Apr 4, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_USER")
public class MasterUser extends RecordControllerBean implements Serializable {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="USER_ID")
  private int userId;
  @Column(name="USER_CODE")
  private String userCode;
  @Column(name="USER_NAME")
  private String userName;
  @Column(name="USER_PASSWORD")
  private String userPassword;  
  @Column(name="IS_VERIF")
  private String isVerif;  
  @Column(name="USER_EMAIL")
  private String userEmail;
  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name="OFFICE_ID")
  private MasterOffice office;
  @JsonBackReference
  @OneToMany(mappedBy="user")
  private List<MasterUserRole> userRoles;

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
   * @return the office
   */
  public MasterOffice getOffice() {
    return office;
  }

  /**
   * @param office the office to set
   */
  public void setOffice(MasterOffice office) {
    this.office = office;
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
   * @return the userRoles
   */
  public List<MasterUserRole> getUserRoles() {
    return userRoles;
  }

  /**
   * @param userRoles the userRoles to set
   */
  public void setUserRoles(List<MasterUserRole> userRoles) {
    this.userRoles = userRoles;
  }
}
