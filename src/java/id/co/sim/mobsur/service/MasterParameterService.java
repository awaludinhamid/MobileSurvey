/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterParameter;
import java.util.List;

/**
 * SPI of parameter module
 * @created Nov 18, 2016
 * @author awal
 */
public interface MasterParameterService {

  /**
   * Save given parameter
   * @param mp, parameter
   * @return saved parameter
   */
  MasterParameter save(MasterParameter mp);
  
  /**
   * Delete given parameter
   * @param mp, parameter
   */
  void delete(MasterParameter mp);
  
  /**
   * Get parameter by id
   * @param parId
   * @return parameter based on given id
   */
  MasterParameter getById(int parId);
  
  /**
   * Get parameter data by page and company
   * @param coyId, company
   * @param pageNo, page number to proceed
   * @return list of parameters based on given page and company
   */
  List<MasterParameter> getByPageCompany(int coyId, int pageNo);
  
  /**
   * Get parameter data by page, company, application type, parameter code and description pattern/partial
   * @param coyId, company
   * @param parCodePattern
   * @param parDescPattern
   * @param parAppsType, application type: web or mobile
   * @param pageNo, page number to proceed
   * @return list of parameters based on given page, company, application type, parameter code and description pattern
   */
  List<MasterParameter> getByPageCompanyCodeDescAndApps(int coyId, String parCodePattern, String parDescPattern, String parAppsType, int pageNo);
  
  /**
   * Get number of parameter data by company
   * @param coyId, company
   * @return count of parameters based on given company
   */
  int countByCompany(int coyId);
  
  /**
   * Get number of parameter data by company, application type, parameter code and description pattern
   * @param coyId, company
   * @param parCodePattern
   * @param parDescPattern
   * @param parAppsType, application type: web or mobile
   * @return count of parameters based on given company, application type, parameter code and description pattern
   */
  int countByCompanyCodeDescAndApps(int coyId, String parCodePattern, String parDescPattern, String parAppsType);
}
