/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto.support;

import id.co.sim.mobsur.bean.dto.MobileTaskResultDetailListDTO;
import java.util.List;

/**
 * DTO list table MOBILE_TASK_RESULT_DETAIL_LIST
 *
 * @author awal
 * @created Feb 20, 2017
 */
public class MobileTaskResultDetailListDTOList {

  private List<MobileTaskResultDetailListDTO> resultDetailListDTOList;

  /**
   * @return the resultDetailListDTOList
   */
  public List<MobileTaskResultDetailListDTO> getResultDetailListDTOList() {
    return resultDetailListDTOList;
  }

  /**
   * @param resultDetailListDTOList the resultDetailListDTOList to set
   */
  public void setResultDetailListDTOList(List<MobileTaskResultDetailListDTO> resultDetailListDTOList) {
    this.resultDetailListDTOList = resultDetailListDTOList;
  }
}
