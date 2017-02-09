/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterQuestionGroup;
import java.util.List;

/**
 * @created Jan 10, 2017
 * @author awal
 */
public interface MasterQuestionGroupService {

  MasterQuestionGroup save(MasterQuestionGroup mqg);
  MasterQuestionGroup delete(MasterQuestionGroup mqg);
  MasterQuestionGroup getById(int questGroupId);
  List<MasterQuestionGroup> getByPageCoy(int coyId, int pageNo);
  List<MasterQuestionGroup> getByPageCoyAndLabel(int coyId, String questGroupLabelPattern, int pageNo);
  int countByCoy(int coyId);
  int countByCoyAndLabel(int coyId, String questGroupLabelPattern);
  List<MasterQuestionGroup> getByCoy(int coyId);
}
