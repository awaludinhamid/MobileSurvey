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
@Table(name="DETAIL_TEMPLATE")
public class DetailTemplate extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="DETAIL_TEMP_ID")
  private int detailTempId;
  @Column(name="SORT")
  private Integer sort;
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name="TEMP_ID")
  private MasterTemplate template;
  @ManyToOne
  @JoinColumn(name="QUEST_GROUP_ID")
  private MasterQuestionGroup questionGroup;

  /**
   * @return the detailTempId
   */
  public int getDetailTempId() {
    return detailTempId;
  }

  /**
   * @param detailTempId the detailTempId to set
   */
  public void setDetailTempId(int detailTempId) {
    this.detailTempId = detailTempId;
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
   * @return the template
   */
  public MasterTemplate getTemplate() {
    return template;
  }

  /**
   * @param template the template to set
   */
  public void setTemplate(MasterTemplate template) {
    this.template = template;
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
}
