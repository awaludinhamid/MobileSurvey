/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.support;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO location coordinate
 * @author awal
 * @created Feb 23, 2017
 */
public class CoordinateBean {

  private double latitude;
  private double longitude;
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
  private Date submitDate;

  /**
   * @return the latitude
   */
  public double getLatitude() {
    return latitude;
  }

  /**
   * @param latitude the latitude to set
   */
  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  /**
   * @return the longitude
   */
  public double getLongitude() {
    return longitude;
  }

  /**
   * @param longitude the longitude to set
   */
  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  /**
   * @return the submitDate
   */
  public Date getSubmitDate() {
    return submitDate;
  }

  /**
   * @param submitDate the submitDate to set
   */
  public void setSubmitDate(Date submitDate) {
    this.submitDate = submitDate;
  }
}
