/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterZipcode;
import java.util.List;

/**
 * @created Nov 26, 2016
 * @author awal
 */
public interface MasterZipcodeService {

  MasterZipcode save(MasterZipcode mz);
  MasterZipcode delete(MasterZipcode mz);
  MasterZipcode getById(int id);
  List<MasterZipcode> getAll();
  List<MasterZipcode> getByPage(int pageNo);
  List<MasterZipcode> getByRangeZipcodeDesc(String zipcodeCodePattern, String zipcodeDescPattern, int pageNo);
  int count();
  int countByZipcodeDesc(String zipcodeCodePattern, String zipcodeDescPattern);
  List<String> getListInput(String fieldName);
}
