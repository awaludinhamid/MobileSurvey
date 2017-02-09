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
@Table(name="MASTER_TEMPLATE")
public class MasterTemplate extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="TEMP_ID")
  private int tempId;
  @Column(name="TEMP_CODE")
  private String tempCode;
  @Column(name="TEMP_LABEL")
  private String tempLabel;
  @ManyToOne
  @JoinColumn(name="COY_ID")
  private MasterCompany company;
  @JsonManagedReference
  @OneToMany(mappedBy="template",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
  private Set<DetailTemplate> detailTemplates;
  

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
   * @return the detailTemplates
   */
  public Set<DetailTemplate> getDetailTemplates() {
    return detailTemplates;
  }

  /**
   * @param detailTemplates the detailTemplates to set
   */
  public void setDetailTemplates(Set<DetailTemplate> detailTemplates) {
    this.detailTemplates = detailTemplates;
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
