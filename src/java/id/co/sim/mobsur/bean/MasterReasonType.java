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
import javax.persistence.Table;

/**
 * POJO table MASTER_REASON_TYPE
 * @created Jan 26, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_REASON_TYPE")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterReasonType extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="REASON_TYPE_ID")
  private int reasonTypeId;
  @Column(name="REASON_TYPE_NAME")
  private String reasonTypeName;

  /**
   * @return the reasonTypeId
   */
  public int getReasonTypeId() {
    return reasonTypeId;
  }

  /**
   * @param reasonTypeId the reasonTypeId to set
   */
  public void setReasonTypeId(int reasonTypeId) {
    this.reasonTypeId = reasonTypeId;
  }

  /**
   * @return the reasonTypeName
   */
  public String getReasonTypeName() {
    return reasonTypeName;
  }

  /**
   * @param reasonTypeName the reasonTypeName to set
   */
  public void setReasonTypeName(String reasonTypeName) {
    this.reasonTypeName = reasonTypeName;
  }
}
