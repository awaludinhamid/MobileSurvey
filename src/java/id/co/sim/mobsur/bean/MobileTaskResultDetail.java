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
 * POJO table MOBILE_TASK_RESULT_DETAIL
 * @created Feb 13, 2017
 * @author awal
 */
@Entity
@Table(name="MOBILE_TASK_RESULT_DETAIL")
@SuppressWarnings("PersistenceUnitPresent")
public class MobileTaskResultDetail extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="TASK_RESULT_DET_ID")
  private int taskResultDetId;
  @ManyToOne
  @JoinColumn(name="TASK_RESULT_ID")
  private MobileTaskResult taskResult;
  @ManyToOne
  @JoinColumn(name="QUEST_ID")
  private MasterQuestion question;

  /**
   * @return the taskResultDetId
   */
  public int getTaskResultDetId() {
    return taskResultDetId;
  }

  /**
   * @param taskResultDetId the taskResultDetId to set
   */
  public void setTaskResultDetId(int taskResultDetId) {
    this.taskResultDetId = taskResultDetId;
  }

  /**
   * @return the taskResult
   */
  public MobileTaskResult getTaskResult() {
    return taskResult;
  }

  /**
   * @param taskResult the taskResult to set
   */
  public void setTaskResult(MobileTaskResult taskResult) {
    this.taskResult = taskResult;
  }

  /**
   * @return the question
   */
  public MasterQuestion getQuestion() {
    return question;
  }

  /**
   * @param question the question to set
   */
  public void setQuestion(MasterQuestion question) {
    this.question = question;
  }
}
