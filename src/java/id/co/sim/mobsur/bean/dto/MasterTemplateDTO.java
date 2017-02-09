/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;
import java.util.List;

/**
 * @created Jan 15, 2017
 * @author awal
 */
public class MasterTemplateDTO extends RecordControllerBeanDTO {

  private int tempId;
  private String tempCode;
  private String tempLabel;
  private int coyId;
  private List<DetailTemplateDTO> detailTemplateDTO;

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
   * @return the tempLabel
   */
  public String getTempLabel() {
    return tempLabel;
  }

  /**
   * @param tempLabel the tempLabel to set
   */
  public void setTempLabel(String tempLabel) {
    this.tempLabel = tempLabel;
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
   * @return the detailTemplateDTO
   */
  public List<DetailTemplateDTO> getDetailTemplateDTO() {
    return detailTemplateDTO;
  }

  /**
   * @param detailTemplateDTO the detailTemplateDTO to set
   */
  public void setDetailTemplateDTO(List<DetailTemplateDTO> detailTemplateDTO) {
    this.detailTemplateDTO = detailTemplateDTO;
  }

  /**
   * @return the tempCode
   */
  public String getTempCode() {
    return tempCode;
  }

  /**
   * @param tempCode the tempCode to set
   */
  public void setTempCode(String tempCode) {
    this.tempCode = tempCode;
  }
}
