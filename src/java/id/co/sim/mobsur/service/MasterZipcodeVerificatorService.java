/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterZipcodeVerificator;
import java.util.List;

/**
 * SPI of zipcode-verificator module
 * @created Jan 23, 2017
 * @author awal
 */
public interface MasterZipcodeVerificatorService {

  /**
   * Save given zipcode-verificator
   * @param zipcodeVerif
   * @return saved zipcode-verificator
   */
  MasterZipcodeVerificator save(MasterZipcodeVerificator zipcodeVerif);
  
  /**
   * Bulk save given zipcode-verificator data
   * @param zipcodeVerifList
   * @param numOfBulkRecord 
   */
  void save(List<MasterZipcodeVerificator> zipcodeVerifList, int numOfBulkRecord);
  
  /**
   * Delete given zipcode-verificator
   * @param zipcodeVerif 
   */
  void delete(MasterZipcodeVerificator zipcodeVerif);
  
  /**
   * Get zipcode-verificator by id
   * @param zipcodeVerifId
   * @return zipcode-verificator based on given id
   */
  MasterZipcodeVerificator getById(int zipcodeVerifId);
  
  /**
   * Get zipcode-verificator data by page and company
   * @param coyId, company
   * @param pageNo, page number to proceed
   * @return list of zipcode-verificator based on given page and company
   */
  List<MasterZipcodeVerificator> getByPageCoy(int coyId, int pageNo);
  
  /**
   * Get zipcode-verificator data by page, company, verificator and zipcode description pattern/partial
   * @param coyId, company
   * @param verificatorId
   * @param zipcodeCodePattern
   * @param pageNo, page number to proceed
   * @return list of zipcode-verificator based on given page, company, verificator and zipcode description pattern
   */
  List<MasterZipcodeVerificator> getByPageCoyVerifAndZipcode(int coyId, int verificatorId, String zipcodeCodePattern, int pageNo);
  
  /**
   * Get number of zipcode-verificator data by company
   * @param coyId, company
   * @return count of zipcode-verificator based on given company
   */
  int countByCoy(int coyId);
  
  /**
   * Get number of zipcode-verificator data by company, verificator and zipcode description pattern
   * @param coyId, company
   * @param verificatorId
   * @param zipcodeCodePattern
   * @return count of zipcode-verificator based on given company, verificator and zipcode description pattern
   */
  int countByCoyVerifAndZipcode(int coyId, int verificatorId, String zipcodeCodePattern);
  
  /**
   * Get zipcode-verificator by company, verificator, zipcode and sub zipcode
   * @param coyId, company
   * @param userCode, verificator code
   * @param zipcodeCode
   * @param subZipcode
   * @return zipcode-verificator based on given company, verificator, zipcode and sub zipcode
   */
  MasterZipcodeVerificator getByCoyVerifZipcodeAndSub(int coyId, String userCode, String zipcodeCode, String subZipcode);
  
  /**
   * Get zipcode-verificator data by company and verificator
   * @param coyId, company
   * @param userId, verificator
   * @return list of zipcode-verificator based on given company and verificator
   */
  List<MasterZipcodeVerificator> getByCoyVerif(int coyId, int userId);
  
  /**
   * Get maximum sub zipcode on specific company and zipcode
   * @param coyId, company
   * @param zipcodeId
   * @return maximum sub zipcode based on given company and zipcode
   */
  String getMaxSubZipcodeByCoyAndZipcode(int coyId, int zipcodeId);
  
  /**
   * Get zipcode-verificator data by page and superior
   * @param parentUserId
   * @param pageNo, page number to proceed
   * @return list of zipcode-verificator based on given page and superior
   */
  List<MasterZipcodeVerificator> getByPageParentUser(int parentUserId, int pageNo);
  
  /**
   * Get zipcode-verificator data by page, superior, verificator and zipcode
   * @param parentUserId
   * @param verificatorId
   * @param zipcodeCodePattern
   * @param pageNo, page number to proceed
   * @return list of zipcode-verificator based on given page, superior, verificator and zipcode
   */
  List<MasterZipcodeVerificator> getByPageParentUserVerifAndZipcode(
          int parentUserId, int verificatorId, String zipcodeCodePattern, int pageNo);
  
  /**
   * Get number of zipcode-verificator data by superior
   * @param parentUserId
   * @return count of zipcode-verificator based on given superior
   */
  int countByParentUser(int parentUserId);
  
  /**
   * Get number of zipcode-verificator data by superior, verificator and zipcode
   * @param parentUserId
   * @param verificatorId
   * @param zipcodeCodePattern
   * @return count of zipcode-verificator based on given superior, verificator and zipcode
   */
  int countByParentUserVerifAndZipcode(int parentUserId, int verificatorId, String zipcodeCodePattern);
  
  /**
   * Get zipcode-verificator data by company
   * @param coyId, company
   * @return list of zipcode-verificator based on given company
   */
  List<MasterZipcodeVerificator> getByCoy(int coyId);
}
