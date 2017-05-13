/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.dto.TaskVerifyDTO;
import id.co.sim.mobsur.bean.dto.support.OptionBean;
import id.co.sim.mobsur.bean.support.ContentsBean;
import java.util.List;

/**
 * SPI of various module
 * @created Jan 9, 2017
 * @author awal
 */
public interface GenericService {

  /**
   * Get contents by table
   * @param tableName
   * @param groupParamId, group parameter
   * @param delimiter, character separator of the column data
   * @return list of table contents (including headers/columns) based on given table
   */
  ContentsBean getTableContents(String tableName, int groupParamId, String delimiter);
  
  /**
   * Get verified task by the task
   * @param taskId
   * @return list of verified tasks based on given task
   */
  List<TaskVerifyDTO> getByTask(int taskId);
  
  /**
   * Get verified task by result
   * @param taskResultId, result
   * @return list of verified tasks based on given result
   */
  List<TaskVerifyDTO> getByTaskResult(int taskResultId);
  
  /**
   * Get option data by parameter or table
   * @param groupParamId
   * @param tableName
   * @return list of options based on given parameter and table
   */
  List<OptionBean> getOptionList(Integer groupParamId, String tableName);
}
