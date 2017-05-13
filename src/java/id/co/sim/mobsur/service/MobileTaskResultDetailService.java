/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MobileTaskResultDetail;

/**
 * SPI of result detail module
 *
 * @author awal
 */
public interface MobileTaskResultDetailService {

  /**
   * Get result detail by id
   * @param taskResultdetId
   * @return result detail based on given id
   */
  MobileTaskResultDetail getById(int taskResultdetId);
}
