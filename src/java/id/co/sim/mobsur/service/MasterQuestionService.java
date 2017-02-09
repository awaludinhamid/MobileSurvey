/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterQuestion;
import java.util.List;

/**
 * @created Jan 5, 2017
 * @author awal
 */
public interface MasterQuestionService {

  MasterQuestion save(MasterQuestion mq);
  MasterQuestion delete(MasterQuestion mq);
  MasterQuestion getById(int questId);
  List<MasterQuestion> getByPageCoy(int coyId, int pageNo);
  List<MasterQuestion> getByPageCoyLabelAndAnswer(int coyId, String questLabelPattern, int answerTypeId, int pageNo);
  int countByCoy(int coyId);
  int countByCoyLabelAndAnswer(int coyId, String questLabelPattern, int answerTypeId);
  List<MasterQuestion> getByCoy(int coyId);
}
