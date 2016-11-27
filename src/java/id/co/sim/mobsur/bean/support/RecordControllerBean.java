/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.support;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @created Oct 14, 2016
 * @author awal
 */
@MappedSuperclass
public class RecordControllerBean implements Serializable {
  
  @Temporal(TemporalType.DATE)
  @Column(name="START_DATE")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date startDate;
  @Temporal(TemporalType.DATE)
  @Column(name="END_DATE")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date endDate;
  @Column(name="CREATED_BY")
  private String createdBy;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="CREATED_DATE", insertable=false, updatable=false)
  private Date createdDate;
  @Column(name="UPDATED_BY")
  private String updatedBy;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="UPDATED_DATE", insertable=false, updatable=false)
  private Date updatedDate;

  /**
   * @return the startDate
   */
  public Date getStartDate() {
    return startDate;
  }

  /**
   * @param startDate the startDate to set
   */
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  /**
   * @return the endDate
   */
  public Date getEndDate() {
    return endDate;
  }

  /**
   * @param endDate the endDate to set
   */
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  /**
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * @param createdBy the createdBy to set
   */
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * @return the createdDate
   */
  public Date getCreatedDate() {
    return createdDate;
  }

  /**
   * @param createdDate the createdDate to set
   */
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  /**
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * @param updatedBy the updatedBy to set
   */
  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  /**
   * @return the updatedDate
   */
  public Date getUpdatedDate() {
    return updatedDate;
  }

  /**
   * @param updatedDate the updatedDate to set
   */
  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }
}
