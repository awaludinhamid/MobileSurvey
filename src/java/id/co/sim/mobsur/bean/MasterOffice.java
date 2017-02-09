/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import id.co.sim.mobsur.bean.support.RecordControllerBean;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @created Nov 3, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_OFFICE")
public class MasterOffice extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="OFFICE_ID")
  private int officeId;
  @Column(name="OFFICE_CODE")
  private String officeCode;
  @Column(name="OFFICE_NAME")
  private String officeName;
  @Column(name="ADDRESS")
  private String address;
  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name="COY_ID")
  private MasterCompany company;
  @JsonBackReference
  @OneToMany(mappedBy="office")
  private List<MasterUser> users;

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
   * @return the users
   */
  public List<MasterUser> getUsers() {
    return users;
  }

  /**
   * @param users the users to set
   */
  public void setUsers(List<MasterUser> users) {
    this.users = users;
  }
  
}
