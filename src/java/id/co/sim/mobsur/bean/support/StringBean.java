/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.support;

/**
 * @created Jan 9, 2017
 * @author awal
 * We need to store data of generic query (undefined query) in this bean
 */
public class StringBean {

  private int id;
  private String val;
  
  public StringBean() {}
  public StringBean(String val) {
    this.val = val;
  }

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
   * @return the val
   */
  public String getVal() {
    return val;
  }

  /**
   * @param val the val to set
   */
  public void setVal(String val) {
    this.val = val;
  }
}
