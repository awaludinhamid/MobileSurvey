/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterAbsence;
import java.util.List;

/**
 * SPI of absence module
 * @created Jan 26, 2017
 * @author awal
 */
public interface MasterAbsenceService {

  /**
   * Save given absence
   * @param absence
   * @return saved absence
   */
  MasterAbsence save(MasterAbsence absence);
  
  /**
   * Delete given absence
   * @param absence 
   */
  void delete(MasterAbsence absence);
  
  /**
   * Get absence by id
   * @param absenceId
   * @return absence based on given id
   */
  MasterAbsence getById(int absenceId);
  
  /**
   * Get absence data by page and company
   * @param coyId, company
   * @param pageNo, page number to proceed
   * @return list of absences based on given page and company
   */
  List<MasterAbsence> getByPageCoy(int coyId, int pageNo);
  
  /**
   * Get absence data by range, user, reason, start date and end date
   * @param userId
   * @param reasonTypeId
   * @param startDate
   * @param endDate
   * @param pageNo, page number to proceed
   * @return list of absences based on given range, user, reason, start date and end date
   */
  List<MasterAbsence> getByPageUserReasonStartAndEndDate(int userId, int reasonTypeId, String startDate, String endDate, int pageNo);
  
  /**
   * Get number of absence data by company
   * @param coyId, company
   * @return count of absence based on given company
   */
  int countByCoy(int coyId);
  
  /**
   * Get number of absence by user, reason, star date and end date
   * @param userId
   * @param reasonTypeId
   * @param startDate
   * @param endDate
   * @return count of absences based on given range, user, reason, star date and end date
   */
  int countByUserReasonStartAndEndDate(int userId, int reasonTypeId, String startDate, String endDate);
  
  /**
   * Get absence data by range and superior
   * @param parentUserId, superior
   * @param pageNo, page number to proceed
   * @return list of absences based on given range and superior
   */
  List<MasterAbsence> getByPageParentUser(int parentUserId, int pageNo);
  
  /**
   * Get absence by range, superior, user, reason, start date and end date
   * @param parentUserId
   * @param userId
   * @param reasonTypeId
   * @param startDate
   * @param endDate
   * @param pageNo, page number to proceed
   * @return list of absences based on given superior, user, reason, start date and end date
   */
  List<MasterAbsence> getByPageParentUserReasonStartAndEndDate(
          int parentUserId, int userId, int reasonTypeId, String startDate, String endDate, int pageNo);
  
  /**
   * Get number of absence data by superior
   * @param parentUserId, superior
   * @return count of absences based on given superior
   */
  int countByParentUser(int parentUserId);
  
  /**
   * Get number of absence data by superior, user, reason, start date and end date
   * @param parentUserId, superior
   * @param userId
   * @param reasonTypeId
   * @param startDate
   * @param endDate
   * @return count of absences based on given superior, user, reason, start date and end date
   */
  int countByParentUserReasonStartAndEndDate(
          int parentUserId, int userId, int reasonTypeId, String startDate, String endDate);
}
