/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterZipcode;
import java.util.List;

/**
 * SPI of zipcode module
 * @created Nov 26, 2016
 * @author awal
 */
public interface MasterZipcodeService {

  /**
   * Save given zipcode
   * @param mz, zipcode
   * @return saved zipcode
   */
  MasterZipcode save(MasterZipcode mz);
  
  /**
   * Delete given zipcode
   * @param mz, zipcode
   */
  void delete(MasterZipcode mz);
  
  /**
   * Get zipcode by id
   * @param id
   * @return zipcode based on given id
   */
  MasterZipcode getById(int id);
  
  /**
   * Get all zipcode data
   * @return list of all zipcode
   */
  List<MasterZipcode> getAll();
  
  /**
   * Get zipcode data by page
   * Override default behavior
   * @param pageNo, page number to proceed
   * @return list of zipcodes based on given page
   */
  List<MasterZipcode> getByPage(int pageNo);
  
  /**
   * Get zipcode data by range, zipcode code and description pattern/partial
   * @param zipcodeCodePattern
   * @param zipcodeDescPattern
   * @param pageNo, page number to proceed
   * @return list of sipcodes based on given range, zipcode code and description pattern
   */
  List<MasterZipcode> getByRangeZipcodeDesc(String zipcodeCodePattern, String zipcodeDescPattern, int pageNo);
  
  /**
   * Get number of all sipcode data
   * @return list of all sipcodes
   */
  int count();
  
  /**
   * Get number of zipcode data by range, zipcode code and description pattern
   * @param zipcodeCodePattern
   * @param zipcodeDescPattern
   * @return count of zipcodes based on given range, zipcode code and description pattern
   */
  int countByZipcodeDesc(String zipcodeCodePattern, String zipcodeDescPattern);
  
  /**
   * Get column content data by column
   * @param fieldName, the name of specific column to return
   * @return list of column contents based on given column
   */
  List<String> getListInput(String fieldName);
  
  /**
   * Get zipcode by code
   * @param zipcodeCode
   * @return zipcode based on given the code
   */
  MasterZipcode getByZipcodeCode(String zipcodeCode);
  
  /**
   * Get zipcode data by kecamatan
   * @param kecId, kecamatan
   * @return list of zipcodes based on given kecamatan
   */
  List<MasterZipcode> getByKecamatan(int kecId);
  
  /**
   * Get zipcode data by city
   * @param cityId
   * @return list of zipcodes based on given city
   */
  List<MasterZipcode> getByCity(int cityId);
  
  /**
   * Get zipcode data by code pattern/partial
   * @param patternCode
   * @return list of zipcodes based on given code pattern
   */
  List<MasterZipcode> getByPatternCode(String patternCode);
}
