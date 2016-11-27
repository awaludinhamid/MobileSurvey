/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.sim.mobsur.util;

/**
 *
 * @author awal
 */
public enum GlobalIntVariable {
  
  PAGING_RECORDS(10);
  
  private final int var;
  
  private GlobalIntVariable(final int var) {
    this.var = var;
  }
  
  public int getVar() {
    return var;
  }
}
