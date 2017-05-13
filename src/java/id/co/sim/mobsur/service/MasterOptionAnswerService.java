/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterOptionAnswer;
import java.util.List;

/**
 * SPI of option answer module
 * @created Jan 5, 2017
 * @author awal
 */
public interface MasterOptionAnswerService {

  /**
   * Get option answer by id
   * @param optionAnswerId
   * @return option answer based on given id
   */
  MasterOptionAnswer getById(int optionAnswerId);
  
  /**
   * Get all option answer data
   * @return list of all option answers
   */
  List<MasterOptionAnswer> getAll();
}
