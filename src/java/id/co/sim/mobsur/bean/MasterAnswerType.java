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
 * POJO table MASTER_ANSWER_TYPE
 * @created Jan 5, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_ANSWER_TYPE")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterAnswerType extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ANSWER_TYPE_ID")
  private int answerTypeId;
  @Column(name="ANSWER_TYPE_NAME")
  private String answerTypeName;
  @Column(name="SHOW_MAX_LENGTH")
  private String showMaxLength;
  @Column(name="HAS_TEXT")
  private String hasText;

  /**
   * @return the answerTypeId
   */
  public int getAnswerTypeId() {
    return answerTypeId;
  }

  /**
   * @param answerTypeId the answerTypeId to set
   */
  public void setAnswerTypeId(int answerTypeId) {
    this.answerTypeId = answerTypeId;
  }

  /**
   * @return the answerTypeName
   */
  public String getAnswerTypeName() {
    return answerTypeName;
  }

  /**
   * @param answerTypeName the answerTypeName to set
   */
  public void setAnswerTypeName(String answerTypeName) {
    this.answerTypeName = answerTypeName;
  }

  /**
   * @return the showMaxLength
   */
  public String getShowMaxLength() {
    return showMaxLength;
  }

  /**
   * @param showMaxLength the showMaxLength to set
   */
  public void setShowMaxLength(String showMaxLength) {
    this.showMaxLength = showMaxLength;
  }

  /**
   * @return the hasText
   */
  public String getHasText() {
    return hasText;
  }

  /**
   * @param hasText the hasText to set
   */
  public void setHasText(String hasText) {
    this.hasText = hasText;
  }
}
