/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterTemplate;
import java.util.List;

/**
 * SPI of template module
 * @created Jan 15, 2017
 * @author awal
 */
public interface MasterTemplateService {

  /**
   * Save given template
   * @param template
   * @return saved template
   */
  MasterTemplate save(MasterTemplate template);
  
  /**
   * Delete given template
   * @param template 
   */
  void delete(MasterTemplate template);
  
  /**
   * Get template by id
   * @param tempId
   * @return template based on given id
   */
  MasterTemplate getById(int tempId);
  
  /**
   * Get template data by page and company
   * @param coyId, company
   * @param pageNo, page number to proceed
   * @return list of templates based on given page and company
   */
  List<MasterTemplate> getByPageCoy(int coyId, int pageNo);
  
  /**
   * Get template data by page, company and label pattern/partial
   * @param coyId, company
   * @param tempLabelPattern
   * @param pageNo, page number to proceed
   * @return list of templates based on given page, company and label pattern
   */
  List<MasterTemplate> getByPageCoyAndLabel(int coyId, String tempLabelPattern, int pageNo);
  
  /**
   * Get number of template data by company
   * @param coyId, company
   * @return count of templates based on given company
   */
  int countByCoy(int coyId);
  
  /**
   * Get number of template data by company and label pattern
   * @param coyId, company
   * @param tempLabelPattern
   * @return count of templates based on given company and label pattern
   */
  int countByCoyAndLabel(int coyId, String tempLabelPattern);
  
  /**
   * Get template data by company
   * @param coytId, company
   * @return list of templates based on given company
   */
  List<MasterTemplate> getByCoy(int coytId);
}
