/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto.support;

import java.util.List;

/**
 * DTO list table MOBILE_TASK_ASSIGNMENT
 * @created Feb 3, 2017
 * @author awal
 */
public class MobileTaskAssignmentDTOList {

  private Integer userId;
  private List<Integer> taskIdList;

  /**
   * @return the userId
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  /**
   * @return the taskIdList
   */
  public List<Integer> getTaskIdList() {
    return taskIdList;
  }

  /**
   * @param taskIdList the taskIdList to set
   */
  public void setTaskIdList(List<Integer> taskIdList) {
    this.taskIdList = taskIdList;
  }
}
