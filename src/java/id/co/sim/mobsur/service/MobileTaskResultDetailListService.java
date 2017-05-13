/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MobileTaskResultDetailList;
import java.util.List;

/**
 * SPI of result detail list module
 *
 * @author awal
 */
public interface MobileTaskResultDetailListService {
  
  /**
   * Get result detail list by id
   * @param taskResultDetListId
   * @return result detail list based on given id
   */
  MobileTaskResultDetailList getById(int taskResultDetListId);
  
  /**
   * Get result detail list data by task
   * @param taskId
   * @return list of result detail list based on given task
   */
  List<MobileTaskResultDetailList> getByTask(int taskId);
  
  /**
   * Save given result detail list
   * @param resultDetailList
   * @return saved result detail list
   */
  MobileTaskResultDetailList save(MobileTaskResultDetailList resultDetailList);
  
  /**
   * Get result detail list data which has image by result
   * @param taskResultId
   * @return list of result detail lists based on given result 
   */
  List<MobileTaskResultDetailList> getByTaskResultHasImage(int taskResultId);
  
  /**
   * Bulk save given result detail list data
   * @param resultDetailListList
   * @param numOfBulkRecord 
   */
  void save(List<MobileTaskResultDetailList> resultDetailListList, int numOfBulkRecord);
}
