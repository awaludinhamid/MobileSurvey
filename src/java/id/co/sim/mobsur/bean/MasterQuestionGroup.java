/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import id.co.sim.mobsur.bean.support.RecordControllerBean;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @created Jan 5, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_QUESTION_GROUP")
public class MasterQuestionGroup extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="QUEST_GROUP_ID")
  private int questGroupId;
  @Column(name="QUEST_GROUP_LABEL")
  private String questGroupLabel;
  @ManyToOne
  @JoinColumn(name="COY_ID")
  private MasterCompany company;
  @JsonManagedReference
  @OneToMany(mappedBy="questionGroup",fetch = FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
  private Set<DetailQuestionGroup> detailQuestionGroups;

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
   * @return the company
   */
  public MasterCompany getCompany() {
    return company;
  }

  /**
   * @param company the company to set
   */
  public void setCompany(MasterCompany company) {
    this.company = company;
  }

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
   * @return the detailQuestionGroups
   */
  public Set<DetailQuestionGroup> getDetailQuestionGroups() {
    return detailQuestionGroups;
  }

  /**
   * @param detailQuestionGroups the detailQuestionGroups to set
   */
  public void setDetailQuestionGroups(Set<DetailQuestionGroup> detailQuestionGroups) {
    this.detailQuestionGroups = detailQuestionGroups;
  }
}
