/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterKecamatan;
import java.util.List;

/**
 * SPI of kecamatan module
 * @created Dec 19, 2016
 * @author awal
 */
public interface MasterKecamatanService {

  /**
   * Save given kecamatan
   * @param mk, kecamatan
   * @return saved kecamatan
   */
  MasterKecamatan save(MasterKecamatan mk);
  
  /**
   * Delete given kecamatan
   * @param mk, kecamatan
   */
  void delete(MasterKecamatan mk);
  
  /**
   * Get kecamatan by id
   * @param kecId
   * @return kecamatan based on given id
   */
  MasterKecamatan getById(int kecId);
  
  /**
   * Get kecamatan data by page
   * @param pageNo, page number to proceed
   * @return list of kecamatan based on given page
   */
  List<MasterKecamatan> getByPage(int pageNo);
  
  /**
   * Get kecamatan data by page, code and name pattern/partial
   * @param kecCodePattern
   * @param kecNamePattern
   * @param pageNo, page number to proceed
   * @return list of kecamatan based on given page, code and name pattern
   */
  List<MasterKecamatan> getByPageCodeAndName(String kecCodePattern, String kecNamePattern, int pageNo);
  
  /**
   * Get number of all kecamatan data 
   * @return count of all kecamatan
   */
  int count();
  
  /**
   * Get number of kecamatan data by code and name pattern
   * @param kecCodePattern
   * @param kecNamePattern
   * @return count of kecamatan based on given code and name pattern
   */
  int countByCodeAndName(String kecCodePattern, String kecNamePattern);
  
  /**
   * Get kecamatan data by city 
   * @param cityId
   * @return list of kecamatan based on given city
   */
  List<MasterKecamatan> getByCity(int cityId);
}
