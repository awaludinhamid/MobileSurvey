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
 * POJO table MASTER_PARENT_PARAMETER
 *
 * @author awal
 * @created Mar 14, 2017
 */
@Entity
@Table(name="MASTER_PARENT_PARAMETER")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterParentParameter extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="PARENT_PAR_ID")
  private int parentParId;
  @Column(name="PARENT_PAR_CODE")
  private String parentParCode;
  @Column(name="PARENT_PAR_DESC")
  private String parentParDesc;
  @Column(name="PARENT_PAR_DATATYPE")
  private String parentParDatatype;
  @Column(name="PARENT_PAR_APPSTYPE")
  private String parentParAppstype;
  @Column(name="PARENT_PAR_VALUE")
  private String parentParValue;

  /**
   * @return the parentParId
   */
  public int getParentParId() {
    return parentParId;
  }

  /**
   * @param parentParId the parentParId to set
   */
  public void setParentParId(int parentParId) {
    this.parentParId = parentParId;
  }

  /**
   * @return the parentParCode
   */
  public String getParentParCode() {
    return parentParCode;
  }

  /**
   * @param parentParCode the parentParCode to set
   */
  public void setParentParCode(String parentParCode) {
    this.parentParCode = parentParCode;
  }

  /**
   * @return the parentParDesc
   */
  public String getParentParDesc() {
    return parentParDesc;
  }

  /**
   * @param parentParDesc the parentParDesc to set
   */
  public void setParentParDesc(String parentParDesc) {
    this.parentParDesc = parentParDesc;
  }

  /**
   * @return the parentParDatatype
   */
  public String getParentParDatatype() {
    return parentParDatatype;
  }

  /**
   * @param parentParDatatype the parentParDatatype to set
   */
  public void setParentParDatatype(String parentParDatatype) {
    this.parentParDatatype = parentParDatatype;
  }

  /**
   * @return the parentParAppstype
   */
  public String getParentParAppstype() {
    return parentParAppstype;
  }

  /**
   * @param parentParAppstype the parentParAppstype to set
   */
  public void setParentParAppstype(String parentParAppstype) {
    this.parentParAppstype = parentParAppstype;
  }

  /**
   * @return the parentParValue
   */
  public String getParentParValue() {
    return parentParValue;
  }

  /**
   * @param parentParValue the parentParValue to set
   */
  public void setParentParValue(String parentParValue) {
    this.parentParValue = parentParValue;
  }
}
