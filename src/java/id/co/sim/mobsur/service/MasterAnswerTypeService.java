/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterAnswerType;
import java.util.List;

/**
 * SPI of answer type module
 * @created Jan 5, 2017
 * @author awal
 */
public interface MasterAnswerTypeService {

  /**
   * Get answer type by id
   * @param answerTypeId
   * @return answer type based on given id
   */
  MasterAnswerType getById(int answerTypeId);
  
  /**
   * Get all answer type data
   * @return list of all answer types
   */
  List<MasterAnswerType> getAll();
}
