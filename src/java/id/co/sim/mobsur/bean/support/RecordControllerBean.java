/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.support;

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
public class RecordControllerBean extends RecordAuditBean {
  
  @Temporal(TemporalType.DATE)
  @Column(name="START_DATE")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date startDate;
  @Temporal(TemporalType.DATE)
  @Column(name="END_DATE")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date endDate;

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
}
