/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;

/**
 * DTO table MASTER_PARAMETER
 * @created Nov 29, 2016
 * @author awal
 */
public class MasterParameterDTO extends RecordControllerBeanDTO {

  private int parId;
  private String parValue;
  private int coyId;
  private int parentParId;

  /**
   * @return the parId
   */
  public int getParId() {
    return parId;
  }

  /**
   * @param parId the parId to set
   */
  public void setParId(int parId) {
    this.parId = parId;
  }

  /**
   * @return the parValue
   */
  public String getParValue() {
    return parValue;
  }

  /**
   * @param parValue the parValue to set
   */
  public void setParValue(String parValue) {
    this.parValue = parValue;
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

  /**
   * @return the parentParId
   */
  public int getParentParId() {
    return parentParId;
  }

  /**
   * @param parentParId the parentParId to set
   */
  public void setParentParId(int parentParId) {
    this.parentParId = parentParId;
  }
}
