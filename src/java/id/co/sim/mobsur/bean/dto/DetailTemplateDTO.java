/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * DTO table DETAIL_TEMPLATE
 * @created Jan 15, 2017
 * @author awal
 */
public class DetailTemplateDTO extends RecordControllerBeanDTO {

  private int detailTempId;
  private Integer sort;
  private int tempId;
  private int questGroupId;

  /**
   * @return the detailTempId
   */
  public int getDetailTempId() {
    return detailTempId;
  }

  /**
   * @param detailTempId the detailTempId to set
   */
  public void setDetailTempId(int detailTempId) {
    this.detailTempId = detailTempId;
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
   * @return the tempId
   */
  public int getTempId() {
    return tempId;
  }

  /**
   * @param tempId the tempId to set
   */
  public void setTempId(int tempId) {
    this.tempId = tempId;
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
}
