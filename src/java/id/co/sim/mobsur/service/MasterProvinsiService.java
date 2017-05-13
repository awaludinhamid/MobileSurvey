/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterProvinsi;
import java.util.List;

/**
 * SPI of provinsi module
 * @created Dec 19, 2016
 * @author awal
 */
public interface MasterProvinsiService {

  /**
   * Save given provinsi
   * @param mp, provinsi
   * @return saved provinsi
   */
  MasterProvinsi save(MasterProvinsi mp);
  
  /**
   * Delete given provinsi
   * @param mp, provinsi
   */
  void delete(MasterProvinsi mp);
  
  /**
   * Get provinsi by id
   * @param provId
   * @return provinsi baased on given id
   */
  MasterProvinsi getById(int provId);
  
  /**
   * Get all provinsi data
   * @return list of all provinsi
   */
  List<MasterProvinsi> getAll();
  
  /**
   * Get provinsi data by page
   * @param pageNo, page number to proceed
   * @return list of provinsi based on given page
   */
  List<MasterProvinsi> getByPage(int pageNo);
  
  /**
   * Get provinsi data by page, provinsi code and name pattern/partial
   * @param provCodePattern
   * @param provNamePattern
   * @param pageNo, page number to proceed
   * @return list of provinsi based on given page, provinsi code and name pattern
   */
  List<MasterProvinsi> getByPageCodeAndName(String provCodePattern, String provNamePattern, int pageNo);
  
  /**
   * Get number of all provinsi data
   * @return count of all provinsi
   */
  int count();
  
  /**
   * Get number of provinsi data by provinsi code and name pattern
   * @param provCodePattern
   * @param provNamePattern
   * @return count of provinsi based on given provinsi code and name pattern
   */
  int countByCodeAndName(String provCodePattern, String provNamePattern);
}
