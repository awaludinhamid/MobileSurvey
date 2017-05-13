/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterCity;
import java.util.List;

/**
 * SPI of city module
 * @created Dec 19, 2016
 * @author awal
 */
public interface MasterCityService {

  /**
   * Save given city
   * @param mc, city
   * @return saved city
   */
  MasterCity save(MasterCity mc);
  
  /**
   * Delete given city
   * @param mc, city 
   */
  void delete(MasterCity mc);
  
  /**
   * Get city by id
   * @param cityId
   * @return city based on given id
   */
  MasterCity getById(int cityId);
  
  /**
   * Get city data by range
   * @param pageNo, page number to proceed
   * @return list of cities based on given range
   */
  List<MasterCity> getByPage(int pageNo);
  
  /**
   * Get city data by range, code and name pattern/partial
   * @param cityCodePattern
   * @param cityNamePattern
   * @param pageNo, page number to proceed
   * @return list of cities based on given range, code and name pattern
   */
  List<MasterCity> getByPageCodeAndName(String cityCodePattern, String cityNamePattern, int pageNo);
  
  /**
   * Get number of all city data
   * @return count of all cities
   */
  int count();
  
  /**
   * Get number of city data by code and name pattern
   * @param cityCodePattern
   * @param cityNamePattern
   * @return count of cities based on given code and name pattern
   */
  int countByCodeAndName(String cityCodePattern, String cityNamePattern);
  
  /**
   * Get city data by provinsi
   * @param provId, provinsi
   * @return list of cities based on given provinsi
   */
  List<MasterCity> getByProvinsi(int provId);
}
