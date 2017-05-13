/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.support;

import id.co.sim.mobsur.bean.dto.TaskVerifyDTO;
import java.util.List;

/**
 * POJO for task verification collection
 * @author awal
 * @created Feb 19, 2017
 */
public class VerifyTaskBean {

  private List<TaskVerifyDTO> taskVerifyList;
  private List<ImageBean> imageList;

  /**
   * @return the taskVerifyList
   */
  public List<TaskVerifyDTO> getTaskVerifyList() {
    return taskVerifyList;
  }

  /**
   * @param taskVerifyList the taskVerifyList to set
   */
  public void setTaskVerifyList(List<TaskVerifyDTO> taskVerifyList) {
    this.taskVerifyList = taskVerifyList;
  }

  /**
   * @return the imageList
   */
  public List<ImageBean> getImageList() {
    return imageList;
  }

  /**
   * @param imageList the imageList to set
   */
  public void setImageList(List<ImageBean> imageList) {
    this.imageList = imageList;
  }
}
