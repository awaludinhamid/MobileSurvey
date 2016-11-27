/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.save;

import id.co.sim.mobsur.bean.save.support.RecordControllerBeanSave;

/**
 * @created Nov 17, 2016
 * @author awal
 */
public class MasterOfficeSave extends RecordControllerBeanSave {

  private int officeId;
  private String officeCode;
  private String officeName;
  private String address;
  private int coyId;

  /**
   * @return the officeId
   */
  public int getOfficeId() {
    return officeId;
  }

  /**
   * @param officeId the officeId to set
   */
  public void setOfficeId(int officeId) {
    this.officeId = officeId;
  }

  /**
   * @return the officeCode
   */
  public String getOfficeCode() {
    return officeCode;
  }

  /**
   * @param officeCode the officeCode to set
   */
  public void setOfficeCode(String officeCode) {
    this.officeCode = officeCode;
  }

  /**
   * @return the officeName
   */
  public String getOfficeName() {
    return officeName;
  }

  /**
   * @param officeName the officeName to set
   */
  public void setOfficeName(String officeName) {
    this.officeName = officeName;
  }

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return the coyId
   */
  public int getCoyId() {
    return coyId;
  }

  /**
   * @param coyId the coyId to set
   */
  public void setCoyId(int coyId) {
    this.coyId = coyId;
  }
}
