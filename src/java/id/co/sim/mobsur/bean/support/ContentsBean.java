/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.support;

import java.util.List;

/**
 * POJO dynamic table
 * @created Jan 9, 2017
 * @author awal
 */
public class ContentsBean {

  private List<String> tableHeaders;
  private List<StringBean> tableContents;

  /**
   * @return the tableHeaders
   */
  public List<String> getTableHeaders() {
    return tableHeaders;
  }

  /**
   * @param tableHeaders the tableHeaders to set
   */
  public void setTableHeaders(List<String> tableHeaders) {
    this.tableHeaders = tableHeaders;
  }

  /**
   * @return the tableContents
   */
  public List<StringBean> getTableContents() {
    return tableContents;
  }

  /**
   * @param tableContents the tableContents to set
   */
  public void setTableContents(List<StringBean> tableContents) {
    this.tableContents = tableContents;
  }
}
