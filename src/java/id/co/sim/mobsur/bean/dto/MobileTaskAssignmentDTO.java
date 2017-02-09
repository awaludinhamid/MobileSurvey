/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto;

import java.sql.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @created Feb 2, 2017
 * @author awal
 */
public class MobileTaskAssignmentDTO {

  private int taskId;
  private String orderId;
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date orderDate;
  private String customerId;
  private String customerName;
  private String customerAddress;
  private String customerPhone;
  private String customerZipcode;
  private String customerSubZipcode;
  private String customerRt;
  private String customerRw;
  private String priority;
  private String notes;
  private String verifyBy;
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date verifyDate;
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date assignmentDate;
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date retrieveDate;
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date submitDate;
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date finalizationDate;
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date receiveDate;
  private String assignmentStatus;
  private Integer userId;
  private Integer productId;
  private Integer officeId;
  private Integer taskStatusId;
  private String createdBy;
  private String updatedBy;

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
   * @return the userId
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  /**
   * @return the productId
   */
  public Integer getProductId() {
    return productId;
  }

  /**
   * @param productId the productId to set
   */
  public void setProductId(Integer productId) {
    this.productId = productId;
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
   * @return the officeId
   */
  public Integer getOfficeId() {
    return officeId;
  }

  /**
   * @param officeId the officeId to set
   */
  public void setOfficeId(Integer officeId) {
    this.officeId = officeId;
  }

  /**
   * @return the taskStatusId
   */
  public Integer getTaskStatusId() {
    return taskStatusId;
  }

  /**
   * @param taskStatusId the taskStatusId to set
   */
  public void setTaskStatusId(Integer taskStatusId) {
    this.taskStatusId = taskStatusId;
  }
}
