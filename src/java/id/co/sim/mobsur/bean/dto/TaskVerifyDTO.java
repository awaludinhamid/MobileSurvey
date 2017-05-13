/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.OptionBean;
import java.util.List;

/**
 * DTO task verification process
 *
 * @author awal
 * @created Feb 18, 2017
 */
public class TaskVerifyDTO {

    private Integer productId;
    private Integer tempId;
    private Integer detailTempId;
    private Integer questGroupId;
    private String questGroupLabel;
    private Integer detailQuestGroupId;
    private Integer questId;
    private String questLabel;
    private Integer taskId;
    private Integer taskResultId;
    private Integer taskResultDetId;
    private Integer taskResultDetListId;
    private Integer answerId;
    private String answerText;
    private Integer oldAnswerId;
    private String oldAnswerText;
    private Integer editAnswerId;
    private String editAnswerText;
    private Integer finAnswerId;
    private String finAnswerText;
    private String createdBy;
    private String answerDesc;
    private String editAnswerDesc;
    private String finAnswerDesc;
    private Integer groupParamId;
    private String tableName;
    private String optionAnswerName;
    private String hasText;
    private List<OptionBean> optionList;

    /**
     * @return the productId
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * @return the tempId
     */
    public Integer getTempId() {
        return tempId;
    }

    /**
     * @param tempId the tempId to set
     */
    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    /**
     * @return the detailTempId
     */
    public Integer getDetailTempId() {
        return detailTempId;
    }

    /**
     * @param detailTempId the detailTempId to set
     */
    public void setDetailTempId(Integer detailTempId) {
        this.detailTempId = detailTempId;
    }

    /**
     * @return the questGroupId
     */
    public Integer getQuestGroupId() {
        return questGroupId;
    }

    /**
     * @param questGroupId the questGroupId to set
     */
    public void setQuestGroupId(Integer questGroupId) {
        this.questGroupId = questGroupId;
    }

    /**
     * @return the questGroupLabel
     */
    public String getQuestGroupLabel() {
        return questGroupLabel;
    }

    /**
     * @param questGroupLabel the questGroupLabel to set
     */
    public void setQuestGroupLabel(String questGroupLabel) {
        this.questGroupLabel = questGroupLabel;
    }

    /**
     * @return the detailQuestGroupId
     */
    public Integer getDetailQuestGroupId() {
        return detailQuestGroupId;
    }

    /**
     * @param detailQuestGroupId the detailQuestGroupId to set
     */
    public void setDetailQuestGroupId(Integer detailQuestGroupId) {
        this.detailQuestGroupId = detailQuestGroupId;
    }

    /**
     * @return the questId
     */
    public Integer getQuestId() {
        return questId;
    }

    /**
     * @param questId the questId to set
     */
    public void setQuestId(Integer questId) {
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
     * @return the taskId
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * @param taskId the taskId to set
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * @return the taskResultId
     */
    public Integer getTaskResultId() {
        return taskResultId;
    }

    /**
     * @param taskResultId the taskResultId to set
     */
    public void setTaskResultId(Integer taskResultId) {
        this.taskResultId = taskResultId;
    }

    /**
     * @return the taskResultDetId
     */
    public Integer getTaskResultDetId() {
        return taskResultDetId;
    }

    /**
     * @param taskResultDetId the taskResultDetId to set
     */
    public void setTaskResultDetId(Integer taskResultDetId) {
        this.taskResultDetId = taskResultDetId;
    }

    /**
     * @return the taskResultDetListId
     */
    public Integer getTaskResultDetListId() {
        return taskResultDetListId;
    }

    /**
     * @param taskResultDetListId the taskResultDetListId to set
     */
    public void setTaskResultDetListId(Integer taskResultDetListId) {
        this.taskResultDetListId = taskResultDetListId;
    }

    /**
     * @return the answerId
     */
    public Integer getAnswerId() {
        return answerId;
    }

    /**
     * @param answerId the answerId to set
     */
    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    /**
     * @return the answerText
     */
    public String getAnswerText() {
        return answerText;
    }

    /**
     * @param answerText the answerText to set
     */
    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

  /**
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * @param createdBy the createdBy to set
   */
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * @return the oldAnswerId
   */
  public Integer getOldAnswerId() {
    return oldAnswerId;
  }

  /**
   * @param oldAnswerId the oldAnswerId to set
   */
  public void setOldAnswerId(Integer oldAnswerId) {
    this.oldAnswerId = oldAnswerId;
  }

  /**
   * @return the oldAnswerText
   */
  public String getOldAnswerText() {
    return oldAnswerText;
  }

  /**
   * @param oldAnswerText the oldAnswerText to set
   */
  public void setOldAnswerText(String oldAnswerText) {
    this.oldAnswerText = oldAnswerText;
  }

  /**
   * @return the editAnswerId
   */
  public Integer getEditAnswerId() {
    return editAnswerId;
  }

  /**
   * @param editAnswerId the editAnswerId to set
   */
  public void setEditAnswerId(Integer editAnswerId) {
    this.editAnswerId = editAnswerId;
  }

  /**
   * @return the editAnswerText
   */
  public String getEditAnswerText() {
    return editAnswerText;
  }

  /**
   * @param editAnswerText the editAnswerText to set
   */
  public void setEditAnswerText(String editAnswerText) {
    this.editAnswerText = editAnswerText;
  }

  /**
   * @return the finAnswerId
   */
  public Integer getFinAnswerId() {
    return finAnswerId;
  }

  /**
   * @param finAnswerId the finAnswerId to set
   */
  public void setFinAnswerId(Integer finAnswerId) {
    this.finAnswerId = finAnswerId;
  }

  /**
   * @return the finAnswerText
   */
  public String getFinAnswerText() {
    return finAnswerText;
  }

  /**
   * @param finAnswerText the finAnswerText to set
   */
  public void setFinAnswerText(String finAnswerText) {
    this.finAnswerText = finAnswerText;
  }

  /**
   * @return the editAnswerDesc
   */
  public String getEditAnswerDesc() {
    return editAnswerDesc;
  }

  /**
   * @param editAnswerDesc the editAnswerDesc to set
   */
  public void setEditAnswerDesc(String editAnswerDesc) {
    this.editAnswerDesc = editAnswerDesc;
  }

  /**
   * @return the finAnswerDesc
   */
  public String getFinAnswerDesc() {
    return finAnswerDesc;
  }

  /**
   * @param finAnswerDesc the finAnswerDesc to set
   */
  public void setFinAnswerDesc(String finAnswerDesc) {
    this.finAnswerDesc = finAnswerDesc;
  }

  /**
   * @return the answerDesc
   */
  public String getAnswerDesc() {
    return answerDesc;
  }

  /**
   * @param answerDesc the answerDesc to set
   */
  public void setAnswerDesc(String answerDesc) {
    this.answerDesc = answerDesc;
  }

  /**
   * @return the optionList
   */
  public List<OptionBean> getOptionList() {
    return optionList;
  }

  /**
   * @param optionList the optionList to set
   */
  public void setOptionList(List<OptionBean> optionList) {
    this.optionList = optionList;
  }

  /**
   * @return the groupParamId
   */
  public Integer getGroupParamId() {
    return groupParamId;
  }

  /**
   * @param groupParamId the groupParamId to set
   */
  public void setGroupParamId(Integer groupParamId) {
    this.groupParamId = groupParamId;
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
    
}
