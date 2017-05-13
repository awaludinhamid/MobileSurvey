/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MobileTaskResult;
import id.co.sim.mobsur.bean.support.CoordinateBean;
import java.util.List;

/**
 * SPI of result module
 * @created Feb 13, 2017
 * @author awal
 */
public interface MobileTaskResultService {

  /**
   * Save given result
   * @param mtr, result
   * @return saved result
   */
  MobileTaskResult save(MobileTaskResult mtr);
  
  /**
   * Delete given result
   * @param mtr, result
   */
  void delete(MobileTaskResult mtr);
  
  /**
   * Get result data by page, coordinator and task status code
   * @param coordId, coordinator
   * @param taskStatusCode
   * @param pageNo, page number to proceed
   * @return list of results based on given page, coordinator and task status code
   */
  List<MobileTaskResult> getByPageCoordAndTaskStatus(int coordId, String taskStatusCode, int pageNo);
  
  /**
   * Get result data by page, verificator and task status code
   * @param verifId, verificator
   * @param taskStatusCode
   * @param pageNo, page number to proceed
   * @return list of results based on given page, verificator and task status code
   */
  List<MobileTaskResult> getByPageVerifAndTaskStatus(int verifId, String taskStatusCode, int pageNo);
  
  /**
   * Get number of result data by coordinator and task status code
   * @param coordId, coordinator
   * @param taskStatusCode
   * @return count of results based on given coordinator and task status code
   */
  int countByCoordAndTaskStatus(int coordId, String taskStatusCode);
  
  /**
   * Get number of result data by verificator and task status code
   * @param verifId, verificator
   * @param taskStatusCode
   * @return count of results based on given verificator and task status code
   */
  int countByVerifAndTaskStatus(int verifId, String taskStatusCode);
  
  /**
   * Get coordinate data by verificator, assign date (start and end date) and GPS status
   * @param verifId, verificator
   * @param startDate
   * @param endDate
   * @param isGps, mobile using GPS while connecting (Y or N)
   * @return list of coordinates based on given verificator, assign date and GPS status
   */
  List<CoordinateBean> getCoordinateByVerifAssignDateAndGps(int verifId, String startDate, String endDate, String isGps);
  
  /**
   * Get result by task
   * @param taskId
   * @return result based on given task, the first occurrence
   */
  MobileTaskResult getByTaskIsLast(int taskId);
}
