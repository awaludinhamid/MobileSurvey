/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import id.co.sim.mobsur.bean.support.RecordControllerBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @created Jan 5, 2017
 * @author awal
 */
@Entity
@Table(name="DETAIL_QUESTION_GROUP")
public class DetailQuestionGroup extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="DETAIL_QUEST_GROUP_ID")
  private int detailQuestGroupId;
  @Column(name="SORT")
  private Integer sort;
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name="QUEST_GROUP_ID")
  private MasterQuestionGroup questionGroup;
  @ManyToOne
  @JoinColumn(name="QUEST_ID")
  private MasterQuestion question;

  /**
   * @return the detailQuestGroupId
   */
  public int getDetailQuestGroupId() {
    return detailQuestGroupId;
  }

  /**
   * @param detailQuestGroupId the detailQuestGroupId to set
   */
  public void setDetailQuestGroupId(int detailQuestGroupId) {
    this.detailQuestGroupId = detailQuestGroupId;
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
   * @return the questionGroup
   */
  public MasterQuestionGroup getQuestionGroup() {
    return questionGroup;
  }

  /**
   * @param questionGroup the questionGroup to set
   */
  public void setQuestionGroup(MasterQuestionGroup questionGroup) {
    this.questionGroup = questionGroup;
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
