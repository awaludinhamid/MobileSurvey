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
 * POJO table MASTER_QUESTION
 * @created Jan 5, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_QUESTION")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterQuestion extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="QUEST_ID")
  private int questId;
  @Column(name="QUEST_LABEL")
  private String questLabel;
  @Column(name="MAX_LENGTH")
  private Integer maxLength;
  @Column(name="IS_MANDATORY")
  private String isMandatory;
  @ManyToOne
  @JoinColumn(name="ANSWER_TYPE_ID")
  private MasterAnswerType answerType;
  @ManyToOne
  @JoinColumn(name="OPTION_ANSWER_ID")
  private MasterOptionAnswer optionAnswer;
  @ManyToOne
  @JoinColumn(name="COY_ID")
  private MasterCompany company;

  /**
   * @return the questId
   */
  public int getQuestId() {
    return questId;
  }

  /**
   * @param questId the questId to set
   */
  public void setQuestId(int questId) {
    this.questId = questId;
  }

  /**
   * @return the questLabel
   */
  public String getQuestLabel() {
    return questLabel;
  }

  /**
   * @param questLabel the questLabel to set
   */
  public void setQuestLabel(String questLabel) {
    this.questLabel = questLabel;
  }

  /**
   * @return the maxLength
   */
  public Integer getMaxLength() {
    return maxLength;
  }

  /**
   * @param maxLength the maxLength to set
   */
  public void setMaxLength(Integer maxLength) {
    this.maxLength = maxLength;
  }

  /**
   * @return the isMandatory
   */
  public String getIsMandatory() {
    return isMandatory;
  }

  /**
   * @param isMandatory the isMandatory to set
   */
  public void setIsMandatory(String isMandatory) {
    this.isMandatory = isMandatory;
  }

  /**
   * @return the company
   */
  public MasterCompany getCompany() {
    return company;
  }

  /**
   * @param company the company to set
   */
  public void setCompany(MasterCompany company) {
    this.company = company;
  }

  /**
   * @return the answerType
   */
  public MasterAnswerType getAnswerType() {
    return answerType;
  }

  /**
   * @param answerType the answerType to set
   */
  public void setAnswerType(MasterAnswerType answerType) {
    this.answerType = answerType;
  }

  /**
   * @return the optionAnswer
   */
  public MasterOptionAnswer getOptionAnswer() {
    return optionAnswer;
  }

  /**
   * @param optionAnswer the optionAnswer to set
   */
  public void setOptionAnswer(MasterOptionAnswer optionAnswer) {
    this.optionAnswer = optionAnswer;
  }
}
