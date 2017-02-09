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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @created Jan 26, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_ABSENCE")
public class MasterAbsence extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ABSENCE_ID")
  private int absenceId;
  @Column(name="DESCRIPTION")
  private String description;
  @ManyToOne
  @JoinColumn(name="USER_ID")
  private MasterUser user;
  @ManyToOne
  @JoinColumn(name="REASON_TYPE_ID")
  private MasterReasonType reasonType;

  /**
   * @return the absenceId
   */
  public int getAbsenceId() {
    return absenceId;
  }

  /**
   * @param absenceId the absenceId to set
   */
  public void setAbsenceId(int absenceId) {
    this.absenceId = absenceId;
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

  /**
   * @return the user
   */
  public MasterUser getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public void setUser(MasterUser user) {
    this.user = user;
  }

  /**
   * @return the reasonType
   */
  public MasterReasonType getReasonType() {
    return reasonType;
  }

  /**
   * @param reasonType the reasonType to set
   */
  public void setReasonType(MasterReasonType reasonType) {
    this.reasonType = reasonType;
  }
}
