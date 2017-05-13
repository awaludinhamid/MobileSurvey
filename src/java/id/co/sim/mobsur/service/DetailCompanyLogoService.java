/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.DetailCompanyLogo;

/**
 * SPI of detail company logo module
 * @created Oct 19, 2016
 * @author awal
 */
public interface DetailCompanyLogoService {

  /**
   * Save given detail company logo
   * @param dcl, detail company logo
   * @return saved detail company logo
   */
  DetailCompanyLogo save(DetailCompanyLogo dcl);
  
  /**
   * Delete given detail company logo
   * @param dcl, detail company logo 
   */
  void delete(DetailCompanyLogo dcl);
  
  /**
   * Get detail company logo by id
   * @param id
   * @return detail company logo based on given id
   */
  DetailCompanyLogo getById(int id);
  
  /**
   * Get detail company logo by company
   * @param coyId, company
   * @return detail company logo based on given company
   */
  DetailCompanyLogo getByCoyId(int coyId);
}
