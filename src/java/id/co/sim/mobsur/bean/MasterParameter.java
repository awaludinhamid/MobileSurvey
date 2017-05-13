/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import id.co.sim.mobsur.bean.support.RecordControllerBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * POJO table MASTER_PARAMETER
 * @created Nov 18, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_PARAMETER")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterParameter extends RecordControllerBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="PAR_ID")
  private int parId;
  @Column(name="PAR_VALUE")
  private String parValue;
  @ManyToOne
  @JoinColumn(name="COY_ID")
  private MasterCompany company;
  @ManyToOne
  @JoinColumn(name="PARENT_PAR_ID")
  private MasterParentParameter parentParameter;

  /**
   * @return the parId
   */
  public int getParId() {
    return parId;
  }

  /**
   * @param parId the parId to set
   */
  public void setParId(int parId) {
    this.parId = parId;
  }

  /**
   * @return the parValue
   */
  public String getParValue() {
    return parValue;
  }

  /**
   * @param parValue the parValue to set
   */
  public void setParValue(String parValue) {
    this.parValue = parValue;
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
   * @return the parentParameter
   */
  public MasterParentParameter getParentParameter() {
    return parentParameter;
  }

  /**
   * @param parentParameter the parentParameter to set
   */
  public void setParentParameter(MasterParentParameter parentParameter) {
    this.parentParameter = parentParameter;
  }
}
