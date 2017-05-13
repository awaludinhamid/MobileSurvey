/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterCompany;
import java.util.List;

/**
 * SPI of company module
 * @created Oct 12, 2016
 * @author awal
 */
public interface MasterCompanyService {

  /**
   * Save given company
   * @param mc, company
   * @return saved company
   */
  MasterCompany save(MasterCompany mc);
  
  /**
   * Delete given company
   * @param mc, company 
   */
  void delete(MasterCompany mc);
  
  /**
   * Get company by id
   * @param id
   * @return company based on given id
   */
  MasterCompany getById(int id);
  
  /**
   * Get all company data
   * @return list of all companies
   */
  List<MasterCompany> getAll();
  
  /**
   * Get company data by page
   * @param pageNo, page number to proceed
   * @return list of companies based on given page
   */
  List<MasterCompany> getByPage(int pageNo);
  
  /**
   * Get company data by page, code and name pattern/partial
   * @param coyCodePattern
   * @param coyNamePattern
   * @param pageNo, page number to proceed
   * @return list of companies based on given page, code and name pattern
   */
  List<MasterCompany> getByPageCodeAndNamePattern(String coyCodePattern, String coyNamePattern, int pageNo);
  
  /**
   * Get number of all company data
   * @return count of all companies
   */
  int count();
  
  /**
   * Get number of company data by code and name pattern
   * @param coyCodePattern
   * @param coyNamePattern
   * @return count of companies based on given code and name pattern
   */
  int countByCodeAndNamePattern(String coyCodePattern, String coyNamePattern);
  
  /**
   * Get company data by user
   * @param userId
   * @return company based on given user
   */
  MasterCompany getValidCoyByUserId(int userId);
}
