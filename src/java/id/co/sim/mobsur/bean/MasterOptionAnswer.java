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
 * POJO table MASTER_OPTION_ANSWER
 * @created Jan 5, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_OPTION_ANSWER")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterOptionAnswer extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="OPTION_ANSWER_ID")
  private int optionAnswerId;
  @Column(name="OPTION_ANSWER_NAME")
  private String optionAnswerName;
  @Column(name="TABLE_NAME")
  private String tableName;
  @ManyToOne
  @JoinColumn(name="GROUP_PARAM_ID")
  private MasterGroupParam groupParam;

  /**
   * @return the optionAnswerId
   */
  public int getOptionAnswerId() {
    return optionAnswerId;
  }

  /**
   * @param optionAnswerId the optionAnswerId to set
   */
  public void setOptionAnswerId(int optionAnswerId) {
    this.optionAnswerId = optionAnswerId;
  }

  /**
   * @return the optionAnswerName
   */
  public String getOptionAnswerName() {
    return optionAnswerName;
  }

  /**
   * @param optionAnswerName the optionAnswerName to set
   */
  public void setOptionAnswerName(String optionAnswerName) {
    this.optionAnswerName = optionAnswerName;
  }

  /**
   * @return the tableName
   */
  public String getTableName() {
    return tableName;
  }

  /**
   * @param tableName the tableName to set
   */
  public void setTableName(String tableName) {
    this.tableName = tableName;
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
