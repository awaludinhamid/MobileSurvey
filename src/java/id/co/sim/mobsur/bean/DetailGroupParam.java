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
 * POJO table DETAIL_GROUP_PARAM
 * @created Jan 5, 2017
 * @author awal
 */
@Entity
@Table(name="DETAIL_GROUP_PARAM")
@SuppressWarnings("PersistenceUnitPresent")
public class DetailGroupParam extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="DETAIL_GROUP_PARAM_ID")
  private int detailGroupParamId;
  @Column(name="DETAIL_GROUP_PARAM_CODE")
  private String detailGroupParamCode;
  @Column(name="DETAIL_GROUP_PARAM_NAME")
  private String detailGroupParamName;
  @ManyToOne
  @JoinColumn(name="GROUP_PARAM_ID")
  private MasterGroupParam groupParam;

  /**
   * @return the detailGroupParamId
   */
  public int getDetailGroupParamId() {
    return detailGroupParamId;
  }

  /**
   * @param detailGroupParamId the detailGroupParamId to set
   */
  public void setDetailGroupParamId(int detailGroupParamId) {
    this.detailGroupParamId = detailGroupParamId;
  }

  /**
   * @return the detailGroupParamCode
   */
  public String getDetailGroupParamCode() {
    return detailGroupParamCode;
  }

  /**
   * @param detailGroupParamCode the detailGroupParamCode to set
   */
  public void setDetailGroupParamCode(String detailGroupParamCode) {
    this.detailGroupParamCode = detailGroupParamCode;
  }

  /**
   * @return the detailGroupParamName
   */
  public String getDetailGroupParamName() {
    return detailGroupParamName;
  }

  /**
   * @param detailGroupParamName the detailGroupParamName to set
   */
  public void setDetailGroupParamName(String detailGroupParamName) {
    this.detailGroupParamName = detailGroupParamName;
  }

  /**
   * @return the groupParam
   */
  public MasterGroupParam getGroupParam() {
    return groupParam;
  }

  /**
   * @param groupParam the groupParam to set
   */
  public void setGroupParam(MasterGroupParam groupParam) {
    this.groupParam = groupParam;
  }
}
