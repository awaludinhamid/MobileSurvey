/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import id.co.sim.mobsur.bean.support.RecordAuditBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * POJO table MOBILE_TASK_RESULT_DETAIL_LIST
 * @created Feb 13, 2017
 * @author awal
 */
@Entity
@Table(name="MOBILE_TASK_RESULT_DETAIL_LIST")
@SuppressWarnings("PersistenceUnitPresent")
public class MobileTaskResultDetailList extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="TASK_RESULT_DET_LIST_ID")
  private int taskResultDetListId;
  @Column(name="ANSWER_ID")
  private Integer answerId;
  @Column(name="ANSWER_TEXT")
  private String answerText;
  @Column(name="OLD_ANSWER_ID")
  private Integer oldAnswerId;
  @Column(name="OLD_ANSWER_TEXT")
  private String oldAnswerText;
  @Column(name="EDIT_ANSWER_ID")
  private Integer editAnswerId;
  @Column(name="EDIT_ANSWER_TEXT")
  private String editAnswerText;
  @Column(name="FIN_ANSWER_ID")
  private Integer finAnswerId;
  @Column(name="FIN_ANSWER_TEXT")
  private String finAnswerText;
  @Column(name="FLAG_FIN_ANSWER_USE")
  private String flagFinAnswerUse;
  @ManyToOne
  @JoinColumn(name="TASK_RESULT_DET_ID")
  private MobileTaskResultDetail taskResultDetail;
  @ManyToOne
  @JoinColumn(name="IMAGE_ID")
  private MobileTaskResultImage taskResultImage;

  /**
   * @return the taskResultDetListId
   */
  public int getTaskResultDetListId() {
    return taskResultDetListId;
  }

  /**
   * @param taskResultDetListId the taskResultDetListId to set
   */
  public void setTaskResultDetListId(int taskResultDetListId) {
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
   * @return the flagFinAnswerUse
   */
  public String getFlagFinAnswerUse() {
    return flagFinAnswerUse;
  }

  /**
   * @param flagFinAnswerUse the flagFinAnswerUse to set
   */
  public void setFlagFinAnswerUse(String flagFinAnswerUse) {
    this.flagFinAnswerUse = flagFinAnswerUse;
  }

  /**
   * @return the taskResultDetail
   */
  public MobileTaskResultDetail getTaskResultDetail() {
    return taskResultDetail;
  }

  /**
   * @param taskResultDetail the taskResultDetail to set
   */
  public void setTaskResultDetail(MobileTaskResultDetail taskResultDetail) {
    this.taskResultDetail = taskResultDetail;
  }

  /**
   * @return the taskResultImage
   */
  public MobileTaskResultImage getTaskResultImage() {
    return taskResultImage;
  }

  /**
   * @param taskResultImage the taskResultImage to set
   */
  public void setTaskResultImage(MobileTaskResultImage taskResultImage) {
    this.taskResultImage = taskResultImage;
  }
}
