/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterQuestion;
import java.util.List;

/**
 * SPI of question module
 * @created Jan 5, 2017
 * @author awal
 */
public interface MasterQuestionService {

  /**
   * Save given question
   * @param mq, question
   * @return saved question
   */
  MasterQuestion save(MasterQuestion mq);
  
  /**
   * Delete given question
   * @param mq, question
   */
  void delete(MasterQuestion mq);
  
  /**
   * Get question by id
   * @param questId
   * @return question based on given id
   */
  MasterQuestion getById(int questId);
  
  /**
   * Get question data by page and company
   * @param coyId, company
   * @param pageNo, page number to proceed
   * @return list of questions based on given page and company
   */
  List<MasterQuestion> getByPageCoy(int coyId, int pageNo);
  
  /**
   * Get question data by page, company, label and answer type
   * @param coyId, company
   * @param questLabelPattern
   * @param answerTypeId
   * @param pageNo, page number to proceed
   * @return list of questions based on given page, company, label and answer type
   */
  List<MasterQuestion> getByPageCoyLabelAndAnswer(int coyId, String questLabelPattern, int answerTypeId, int pageNo);
  
  /**
   * Get number of question data by company
   * @param coyId, company
   * @return count of questions based on given company
   */
  int countByCoy(int coyId);
  
  /**
   * Get number of question data by company, label and answer type
   * @param coyId, company
   * @param questLabelPattern
   * @param answerTypeId
   * @return count of questions based on given company, label and answer type
   */
  int countByCoyLabelAndAnswer(int coyId, String questLabelPattern, int answerTypeId);
  
  /**
   * Get question data by company
   * @param coyId, company
   * @return list of questions based on given company
   */
  List<MasterQuestion> getByCoy(int coyId);
}
