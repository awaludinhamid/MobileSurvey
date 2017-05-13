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
 * POJO table MASTER_GROUP_PARAM
 * @created Jan 5, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_GROUP_PARAM")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterGroupParam extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="GROUP_PARAM_ID")
  private int groupParamId;
  @Column(name="GROUP_PARAM_CODE")
  private String groupParamCode;
  @Column(name="GROUP_PARAM_NAME")
  private String groupParamName;

  /**
   * @return the groupParamId
   */
  public int getGroupParamId() {
    return groupParamId;
  }

  /**
   * @param groupParamId the groupParamId to set
   */
  public void setGroupParamId(int groupParamId) {
    this.groupParamId = groupParamId;
  }

  /**
   * @return the groupParamCode
   */
  public String getGroupParamCode() {
    return groupParamCode;
  }

  /**
   * @param groupParamCode the groupParamCode to set
   */
  public void setGroupParamCode(String groupParamCode) {
    this.groupParamCode = groupParamCode;
  }

  /**
   * @return the groupParamName
   */
  public String getGroupParamName() {
    return groupParamName;
  }

  /**
   * @param groupParamName the groupParamName to set
   */
  public void setGroupParamName(String groupParamName) {
    this.groupParamName = groupParamName;
  }
}
