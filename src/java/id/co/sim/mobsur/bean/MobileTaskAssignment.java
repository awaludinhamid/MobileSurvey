/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import id.co.sim.mobsur.bean.support.RecordAuditBean;
import id.co.sim.mobsur.util.CustomJsonTimeSerializerWithoutTimeZone;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO table MOBILE_TASK_ASSIGNMENT
 * @created Feb 2, 2017
 * @author awal
 */
@Entity
@Table(name="MOBILE_TASK_ASSIGNMENT")
@SuppressWarnings("PersistenceUnitPresent")
public class MobileTaskAssignment extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="TASK_ID")
  private int taskId;
  @Column(name="ORDER_ID")
  private String orderId;
  @Column(name="ORDER_DATE")
  @Temporal(TemporalType.DATE)
  private Date orderDate;
  @Column(name="CUSTOMER_ID")
  private String customerId;
  @Column(name="CUSTOMER_NAME")
  private String customerName;
  @Column(name="CUSTOMER_ADDRESS")
  private String customerAddress;
  @Column(name="CUSTOMER_PHONE")
  private String customerPhone;
  @Column(name="CUSTOMER_ZIPCODE")
  private String customerZipcode;
  @Column(name="CUSTOMER_SUB_ZIPCODE")
  private String customerSubZipcode;
  @Column(name="CUSTOMER_RT")
  private String customerRt;
  @Column(name="CUSTOMER_RW")
  private String customerRw;
  @Column(name="PRIORITY")
  private String priority;
  @Column(name="NOTES")
  private String notes;
  @Column(name="VERIFY_BY")
  private String verifyBy;
  @Column(name="VERIFY_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date verifyDate;
  @Column(name="ASSIGNMENT_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  @JsonSerialize(using = CustomJsonTimeSerializerWithoutTimeZone.class)
  private Date assignmentDate;
  @Column(name="RETRIEVE_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  @JsonSerialize(using = CustomJsonTimeSerializerWithoutTimeZone.class)
  private Date retrieveDate;
  @Column(name="SUBMIT_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  @JsonSerialize(using = CustomJsonTimeSerializerWithoutTimeZone.class)
  private Date submitDate;
  @Column(name="FINALIZATION_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  @JsonSerialize(using = CustomJsonTimeSerializerWithoutTimeZone.class)
  private Date finalizationDate;
  @Column(name="RECEIVE_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  @JsonSerialize(using = CustomJsonTimeSerializerWithoutTimeZone.class)
  private Date receiveDate;
  @Column(name="ASSIGNMENT_STATUS")
  private String assignmentStatus;
  @ManyToOne
  @JoinColumn(name="USER_ID")
  private MasterUser user;
  @ManyToOne
  @JoinColumn(name="PRODUCT_ID")
  private MasterProduct product;
  @ManyToOne
  @JoinColumn(name="OFFICE_ID")
  private MasterOffice office;
  @ManyToOne
  @JoinColumn(name="TASK_STATUS_ID")
  private MasterTaskStatus taskStatus;

  /**
   * @return the taskId
   */
  public int getTaskId() {
    return taskId;
  }

  /**
   * @param taskId the taskId to set
   */
  public void setTaskId(int taskId) {
    this.taskId = taskId;
  }

  /**
   * @return the orderId
   */
  public String getOrderId() {
    return orderId;
  }

  /**
   * @param orderId the orderId to set
   */
  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  /**
   * @return the orderDate
   */
  public Date getOrderDate() {
    return orderDate;
  }

  /**
   * @param orderDate the orderDate to set
   */
  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  /**
   * @return the customerId
   */
  public String getCustomerId() {
    return customerId;
  }

  /**
   * @param customerId the customerId to set
   */
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  /**
   * @return the customerName
   */
  public String getCustomerName() {
    return customerName;
  }

  /**
   * @param customerName the customerName to set
   */
  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  /**
   * @return the customerAddress
   */
  public String getCustomerAddress() {
    return customerAddress;
  }

  /**
   * @param customerAddress the customerAddress to set
   */
  public void setCustomerAddress(String customerAddress) {
    this.customerAddress = customerAddress;
  }

  /**
   * @return the customerPhone
   */
  public String getCustomerPhone() {
    return customerPhone;
  }

  /**
   * @param customerPhone the customerPhone to set
   */
  public void setCustomerPhone(String customerPhone) {
    this.customerPhone = customerPhone;
  }

  /**
   * @return the customerZipcode
   */
  public String getCustomerZipcode() {
    return customerZipcode;
  }

  /**
   * @param customerZipcode the customerZipcode to set
   */
  public void setCustomerZipcode(String customerZipcode) {
    this.customerZipcode = customerZipcode;
  }

  /**
   * @return the customerSubZipcode
   */
  public String getCustomerSubZipcode() {
    return customerSubZipcode;
  }

  /**
   * @param customerSubZipcode the customerSubZipcode to set
   */
  public void setCustomerSubZipcode(String customerSubZipcode) {
    this.customerSubZipcode = customerSubZipcode;
  }

  /**
   * @return the customerRt
   */
  public String getCustomerRt() {
    return customerRt;
  }

  /**
   * @param customerRt the customerRt to set
   */
  public void setCustomerRt(String customerRt) {
    this.customerRt = customerRt;
  }

  /**
   * @return the customerRw
   */
  public String getCustomerRw() {
    return customerRw;
  }

  /**
   * @param customerRw the customerRw to set
   */
  public void setCustomerRw(String customerRw) {
    this.customerRw = customerRw;
  }

  /**
   * @return the priority
   */
  public String getPriority() {
    return priority;
  }

  /**
   * @param priority the priority to set
   */
  public void setPriority(String priority) {
    this.priority = priority;
  }

  /**
   * @return the notes
   */
  public String getNotes() {
    return notes;
  }

  /**
   * @param notes the notes to set
   */
  public void setNotes(String notes) {
    this.notes = notes;
  }

  /**
   * @return the verifyBy
   */
  public String getVerifyBy() {
    return verifyBy;
  }

  /**
   * @param verifyBy the verifyBy to set
   */
  public void setVerifyBy(String verifyBy) {
    this.verifyBy = verifyBy;
  }

  /**
   * @return the verifyDate
   */
  public Date getVerifyDate() {
    return verifyDate;
  }

  /**
   * @param verifyDate the verifyDate to set
   */
  public void setVerifyDate(Date verifyDate) {
    this.verifyDate = verifyDate;
  }

  /**
   * @return the assignmentDate
   */
  public Date getAssignmentDate() {
    return assignmentDate;
  }

  /**
   * @param assignmentDate the assignmentDate to set
   */
  public void setAssignmentDate(Date assignmentDate) {
    this.assignmentDate = assignmentDate;
  }

  /**
   * @return the retrieveDate
   */
  public Date getRetrieveDate() {
    return retrieveDate;
  }

  /**
   * @param retrieveDate the retrieveDate to set
   */
  public void setRetrieveDate(Date retrieveDate) {
    this.retrieveDate = retrieveDate;
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

  /**
   * @return the finalizationDate
   */
  public Date getFinalizationDate() {
    return finalizationDate;
  }

  /**
   * @param finalizationDate the finalizationDate to set
   */
  public void setFinalizationDate(Date finalizationDate) {
    this.finalizationDate = finalizationDate;
  }

  /**
   * @return the receiveDate
   */
  public Date getReceiveDate() {
    return receiveDate;
  }

  /**
   * @param receiveDate the receiveDate to set
   */
  public void setReceiveDate(Date receiveDate) {
    this.receiveDate = receiveDate;
  }

  /**
   * @return the assignmentStatus
   */
  public String getAssignmentStatus() {
    return assignmentStatus;
  }

  /**
   * @param assignmentStatus the assignmentStatus to set
   */
  public void setAssignmentStatus(String assignmentStatus) {
    this.assignmentStatus = assignmentStatus;
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

  /**
   * @return the product
   */
  public MasterProduct getProduct() {
    return product;
  }

  /**
   * @param product the product to set
   */
  public void setProduct(MasterProduct product) {
    this.product = product;
  }

  /**
   * @return the office
   */
  public MasterOffice getOffice() {
    return office;
  }

  /**
   * @param office the office to set
   */
  public void setOffice(MasterOffice office) {
    this.office = office;
  }

  /**
   * @return the taskStatus
   */
  public MasterTaskStatus getTaskStatus() {
    return taskStatus;
  }

  /**
   * @param taskStatus the taskStatus to set
   */
  public void setTaskStatus(MasterTaskStatus taskStatus) {
    this.taskStatus = taskStatus;
  }
}
