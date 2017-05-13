/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import id.co.sim.mobsur.bean.dto.support.RecordControllerBeanDTO;
import java.util.List;

/**
 * DTO table MASTER_QUESTION_GROUP
 * @created Jan 10, 2017
 * @author awal
 */
public class MasterQuestionGroupDTO extends RecordControllerBeanDTO {

  private int questGroupId;
  private String questGroupLabel;
  private int coyId;
  private List<DetailQuestionGroupDTO> detailQuestionGroupDTO;

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
   * @return the detailQuestionGroupDTO
   */
  public List<DetailQuestionGroupDTO> getDetailQuestionGroupDTO() {
    return detailQuestionGroupDTO;
  }

  /**
   * @param detailQuestionGroupDTO the detailQuestionGroupDTO to set
   */
  public void setDetailQuestionGroupDTO(List<DetailQuestionGroupDTO> detailQuestionGroupDTO) {
    this.detailQuestionGroupDTO = detailQuestionGroupDTO;
  }
}
