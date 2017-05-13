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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * POJO table MOBILE_USER_LOCATION
 *
 * @author awal
 * @created Mar 21, 2017
 */
@Entity
@Table(name="MOBILE_USER_LOCATION")
@SuppressWarnings("PersistenceUnitPresent")
public class MobileUserLocation extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="USER_LOCATION_ID")
  private int userLocationId;
  @Column(name="GPS_LATITUDE")
  private double gpsLatitude;
  @Column(name="GPS_LONGITUDE")
  private double gpsLongitude;
  @OneToOne
  @JoinColumn(name="USER_ID")
  private MasterUser user;

  /**
   * @return the userLocationId
   */
  public int getUserLocationId() {
    return userLocationId;
  }

  /**
   * @param userLocationId the userLocationId to set
   */
  public void setUserLocationId(int userLocationId) {
    this.userLocationId = userLocationId;
  }

  /**
   * @return the gpsLatitude
   */
  public double getGpsLatitude() {
    return gpsLatitude;
  }

  /**
   * @param gpsLatitude the gpsLatitude to set
   */
  public void setGpsLatitude(double gpsLatitude) {
    this.gpsLatitude = gpsLatitude;
  }

  /**
   * @return the gpsLongitude
   */
  public double getGpsLongitude() {
    return gpsLongitude;
  }

  /**
   * @param gpsLongitude the gpsLongitude to set
   */
  public void setGpsLongitude(double gpsLongitude) {
    this.gpsLongitude = gpsLongitude;
  }

  /**
   * @return the user
   */
  public MasterUser getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public void setUser(MasterUser user) {
    this.user = user;
  }
}    
