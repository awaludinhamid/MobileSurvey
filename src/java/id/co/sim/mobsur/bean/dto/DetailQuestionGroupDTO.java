/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * DTO table DETAIL_QUESTION_GROUP
 * @created Jan 13, 2017
 * @author awal
 */
public class DetailQuestionGroupDTO extends RecordControllerBeanDTO {

  private int detailQuestGroupId;
  private Integer sort;
  private int questGroupId;
  private int questId;

  /**
   * @return the detailQuestGroupId
   */
  public int getDetailQuestGroupId() {
    return detailQuestGroupId;
  }

  /**
   * @param detailQuestGroupId the detailQuestGroupId to set
   */
  public void setDetailQuestGroupId(int detailQuestGroupId) {
    this.detailQuestGroupId = detailQuestGroupId;
  }

  /**
   * @return the sort
   */
  public Integer getSort() {
    return sort;
  }

  /**
   * @param sort the sort to set
   */
  public void setSort(Integer sort) {
    this.sort = sort;
  }

  /**
   * @return the questGroupId
   */
  public int getQuestGroupId() {
    return questGroupId;
  }

  /**
   * @param questGroupId the questGroupId to set
   */
  public void setQuestGroupId(int questGroupId) {
    this.questGroupId = questGroupId;
  }

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
}
