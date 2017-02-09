/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterReasonType;
import java.util.List;

/**
 * @created Jan 26, 2017
 * @author awal
 */
public interface MasterReasonTypeService {

  MasterReasonType getById(int reasonTypeId);
  List<MasterReasonType> getAll();
}
