/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.support;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @created Feb 1, 2017
 * @author awal
 */
@Entity
@Table(name="USER_HIERARCHY_VW")
public class UserHierarchyVw implements Serializable{

  @Id
  @Column(name="USER_ID")
  private int userId;
  @Column(name="PARENT_USER_ID")
  private int parentUserId;  

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
   * @return the parentUserId
   */
  public int getParentUserId() {
    return parentUserId;
  }

  /**
   * @param parentUserId the parentUserId to set
   */
  public void setParentUserId(int parentUserId) {
    this.parentUserId = parentUserId;
  }
}
