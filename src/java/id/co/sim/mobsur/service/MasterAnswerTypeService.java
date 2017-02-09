/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterAnswerType;
import java.util.List;

/**
 * @created Jan 5, 2017
 * @author awal
 */
public interface MasterAnswerTypeService {

  MasterAnswerType getById(int answerTypeId);
  List<MasterAnswerType> getAll();
}
