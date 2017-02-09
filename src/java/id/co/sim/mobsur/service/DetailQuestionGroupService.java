/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.DetailQuestionGroup;
import java.util.List;

/**
 * @created Jan 11, 2017
 * @author awal
 */
public interface DetailQuestionGroupService {

  DetailQuestionGroup delete(DetailQuestionGroup dqg);
  List<DetailQuestionGroup> getByQuestGroup(int questGroupId);
}
