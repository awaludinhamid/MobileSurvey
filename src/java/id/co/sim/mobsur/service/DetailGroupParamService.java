/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.DetailGroupParam;
import java.util.List;

/**
 * SPI of detail group parameter module
 * @created Jan 9, 2017
 * @author awal
 */
public interface DetailGroupParamService {

  /**
   * Get detail group parameter by the group
   * @param groupParamId, group parameter
   * @return list of detail group based on given group parameter
   */
  public List<DetailGroupParam> getByGroupParamId(int groupParamId);
}
