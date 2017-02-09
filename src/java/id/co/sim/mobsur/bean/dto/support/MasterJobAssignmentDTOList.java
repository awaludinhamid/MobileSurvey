/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto.support;

import id.co.sim.mobsur.bean.dto.MasterJobAssignmentDTO;
import java.util.List;

/**
 * @created Jan 21, 2017
 * @author awal
 */
public class MasterJobAssignmentDTOList {

  private List<MasterJobAssignmentDTO> jobAssignmentDTOList;

  /**
   * @return the jobAssignmentDTOList
   */
  public List<MasterJobAssignmentDTO> getJobAssignmentDTOList() {
    return jobAssignmentDTOList;
  }

  /**
   * @param jobAssignmentDTOList the jobAssignmentDTOList to set
   */
  public void setJobAssignmentDTOList(List<MasterJobAssignmentDTO> jobAssignmentDTOList) {
    this.jobAssignmentDTOList = jobAssignmentDTOList;
  }
}
