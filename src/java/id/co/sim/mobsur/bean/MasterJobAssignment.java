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
 * @created Jan 17, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_JOB_ASSIGNMENT")
public class MasterJobAssignment extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="JOB_ASSIGN_ID")
  private int jobAssignId;
  @ManyToOne
  @JoinColumn(name="USER_COMMISSIONED_ID")
  private MasterUser commissionedUser;
  @ManyToOne
  @JoinColumn(name="USER_ASSIGNED_ID")
  private MasterUser assignedUser;

  /**
   * @return the jobAssignId
   */
  public int getJobAssignId() {
    return jobAssignId;
  }

  /**
   * @param jobAssignId the jobAssignId to set
   */
  public void setJobAssignId(int jobAssignId) {
    this.jobAssignId = jobAssignId;
  }

  /**
   * @return the commissionedUser
   */
  public MasterUser getCommissionedUser() {
    return commissionedUser;
  }

  /**
   * @param commissionedUser the commissionedUser to set
   */
  public void setCommissionedUser(MasterUser commissionedUser) {
    this.commissionedUser = commissionedUser;
  }

  /**
   * @return the assignedUser
   */
  public MasterUser getAssignedUser() {
    return assignedUser;
  }

  /**
   * @param assignedUser the assignedUser to set
   */
  public void setAssignedUser(MasterUser assignedUser) {
    this.assignedUser = assignedUser;
  }
}
