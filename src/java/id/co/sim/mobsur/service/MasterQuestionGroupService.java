/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterQuestionGroup;
import java.util.List;

/**
 * SPI of question group module
 * @created Jan 10, 2017
 * @author awal
 */
public interface MasterQuestionGroupService {

  /**
   * Save given question group
   * @param mqg, question group
   * @return saved question group
   */
  MasterQuestionGroup save(MasterQuestionGroup mqg);
  
  /**
   * Delete given question group
   * @param mqg, question group
   */
  void delete(MasterQuestionGroup mqg);
  
  /**
   * Get question group by id
   * @param questGroupId
   * @return question group based on given id
   */
  MasterQuestionGroup getById(int questGroupId);
  
  /**
   * Get question group data by page and company
   * @param coyId, company
   * @param pageNo, page number to proceed
   * @return list of question groups based on given page and company
   */
  List<MasterQuestionGroup> getByPageCoy(int coyId, int pageNo);
  
  /**
   * Get question group data by range, company and label pattern/partial
   * @param coyId, company
   * @param questGroupLabelPattern
   * @param pageNo, page number to proceed
   * @return list of question groups based on given range, company and label pattern
   */
  List<MasterQuestionGroup> getByPageCoyAndLabel(int coyId, String questGroupLabelPattern, int pageNo);
  
  /**
   * Get number of question group data by company
   * @param coyId, company
   * @return count of question groups based on given company
   */
  int countByCoy(int coyId);
  
  /**
   * Get number of question group data by company and label pattern 
   * @param coyId, company
   * @param questGroupLabelPattern
   * @return count of question group based on given company and label pattern
   */
  int countByCoyAndLabel(int coyId, String questGroupLabelPattern);
  
  /**
   * Get question group data by company 
   * @param coyId, company
   * @return list of question groups based on given company
   */
  List<MasterQuestionGroup> getByCoy(int coyId);
}
