/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * @created Jan 5, 2017
 * @author awal
 */
public class MasterQuestionDTO extends RecordControllerBeanDTO {

  private int questId;
  private String questLabel;
  private Integer maxLength;
  private String isMandatory;
  private int answerTypeId;
  private int optionAnswerId;
  private int coyId;

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
   * @return the coyId
   */
  public int getCoyId() {
    return coyId;
  }

  /**
   * @param coyId the coyId to set
   */
  public void setCoyId(int coyId) {
    this.coyId = coyId;
  }
}
