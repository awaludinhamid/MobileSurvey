/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterOffice;
import java.util.List;

/**
 * SPI of office module
 * @created Nov 3, 2016
 * @author awal
 */
public interface MasterOfficeService {

  /**
   * Save given office
   * @param mo, office
   * @return saved office
   */
  MasterOffice save(MasterOffice mo);
  
  /**
   * Delete given office
   * @param mo, office
   */
  void delete(MasterOffice mo);
  
  /**
   * Get all office data
   * @return list of all offices
   */
  List<MasterOffice> getAll();
  
  /**
   * Get office by id
   * @param id
   * @return office based on given id
   */
  MasterOffice getById(int id);
  
  /**
   * Get office data by page and company
   * @param coyId, company
   * @param pageNo, page number to proceed
   * @return list of offices based on given page and company
   */
  List<MasterOffice> getByPageCompany(int coyId, int pageNo);
  
  /**
   * Get office data by page, company, as of date, office code and name pattern/partial
   * @param coyId, company
   * @param officeCodePattern
   * @param officeNamePattern
   * @param asOfDate, end date more than or equal to this date
   * @param pageNo, page number to proceed
   * @return list of offices based on given page, company, as of date, office code and name pattern
   */
  List<MasterOffice> getByPageCompanyOfficeCodeNameAndDate(
          int coyId, String officeCodePattern, String officeNamePattern, String asOfDate, int pageNo);
  
  /**
   * Get number of office data by company
   * @param coyId, company
   * @return count of offices based on given company
   */
  int count(int coyId);
  
  /**
   * Get number of office data by company, as of date, office code and name pattern
   * @param coyId, company
   * @param officeCodePattern
   * @param officeNamePattern
   * @param asOfDate, end date more than or equal to this date
   * @return count of offices based on given company, as of date, office code and name pattern
   */
  int countByCompanyOfficeCodeNameAndDate(int coyId, String officeCodePattern, String officeNamePattern, String asOfDate);
  
  /**
   * Get office data by company
   * @param coyId, company
   * @return list of offices based on given company
   */
  List<MasterOffice> getByCompany(int coyId);
}
