/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.dto.support;

/**
 * POJO data option
 * @author awal
 * @created Apr 16, 2017
 */
public class OptionBean {

  private int id;
  private String descr;

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the descr
   */
  public String getDescr() {
    return descr;
  }

  /**
   * @param descr the descr to set
   */
  public void setDescr(String descr) {
    this.descr = descr;
  }
}
