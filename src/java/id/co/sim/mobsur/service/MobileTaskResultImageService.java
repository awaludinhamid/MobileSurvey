/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MobileTaskResultImage;

/**
 * SPI of result image module
 *
 * @author awal
 */
public interface MobileTaskResultImageService {

  /**
   * Get result image by id
   * @param imageId
   * @return result image based on given id
   */
  MobileTaskResultImage getById(int imageId);
}
