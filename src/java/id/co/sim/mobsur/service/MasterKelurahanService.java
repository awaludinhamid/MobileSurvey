/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterKelurahan;
import java.util.List;

/**
 * SPI of kelurahan module
 * @created Dec 23, 2016
 * @author awal
 */
public interface MasterKelurahanService {

  /**
   * Save given kelurahan
   * @param mk, kelurahan
   * @return saved kelurahan
   */
  MasterKelurahan save(MasterKelurahan mk);
  
  /**
   * Delete given kelurahan
   * @param mk, kelurahan
   */
  void delete(MasterKelurahan mk);
  
  /**
   * Get kelurahan by id
   * @param kelId
   * @return kelurahan based on given id
   */
  MasterKelurahan getById(int kelId);
  
  /**
   * Get kelurahan data by page
   * @param pageNo, page number to proceed
   * @return list of kelurahan based on given page
   */
  List<MasterKelurahan> getByPage(int pageNo);
  
  /**
   * Get kelurahan data by page, code and name pattern/partial
   * @param kelCodePattern
   * @param kelNamePattern
   * @param pageNo, page number to proceed
   * @return list of kelurahan based on given page, code and name pattern
   */
  List<MasterKelurahan> getByPageCodeAndName(String kelCodePattern, String kelNamePattern, int pageNo);
  
  /**
   * Get number of kelurahan data
   * @return count of kelurahan
   */
  int count();
  
  /**
   * Get number of kelurahan data by code and name pattern
   * @param kelCodePattern
   * @param kelNamePattern
   * @return count of kelurahan based on given code and name pattern
   */
  int countByCodeAndName(String kelCodePattern, String kelNamePattern);
  
  /**
   * Get kelurahan data by kecamatan
   * @param kecId, kecamatan
   * @return list of kelurahan based on given kecamatan
   */
  List<MasterKelurahan> getByKecamatan(int kecId);
}
