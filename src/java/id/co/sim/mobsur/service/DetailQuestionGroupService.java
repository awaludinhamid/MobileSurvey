/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.DetailQuestionGroup;
import java.util.List;

/**
 * SPI of detail question group module
 * @created Jan 11, 2017
 * @author awal
 */
public interface DetailQuestionGroupService {

  /**
   * Delete given detail question
   * @param dqg, detail question
   */
  void delete(DetailQuestionGroup dqg);
  
  /**
   * Get detail question group by id
   * @param detQuestGroupId, detail question
   * @return detail question group object based on given id
   */
  DetailQuestionGroup getById(int detQuestGroupId);
  
  /**
   * Get detail question by the group
   * @param questGroupId, question group
   * @return list of detail question based on given group
   */
  List<DetailQuestionGroup> getByQuestGroup(int questGroupId);
  
  /**
   * Get detail question by question
   * @param questId, question
   * @return list of detail question based on given question
   */
  List<DetailQuestionGroup> getByQuest(int questId);
  
  /**
   * Get number of detail question, count by question
   * @param questId, question
   * @return count of detail question based on given question
   */
  int countByQuest(int questId);
}
