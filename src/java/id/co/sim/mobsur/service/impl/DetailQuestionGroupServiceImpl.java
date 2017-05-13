/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.DetailQuestionGroup;
import id.co.sim.mobsur.dao.DetailQuestionGroupDAO;
import id.co.sim.mobsur.service.DetailQuestionGroupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Detail question group service implementation (see the service for usage info)
 * @created Jan 11, 2017
 * @author awal
 */
@Service("detailQuestionGroupService")
@Transactional(readOnly=true)
public class DetailQuestionGroupServiceImpl implements DetailQuestionGroupService {

  @Autowired
  private DetailQuestionGroupDAO detailQuestionGroupDAO;// DAO injection

  @Override
  @Transactional(readOnly=false)
  public void delete(DetailQuestionGroup dqg) {
    detailQuestionGroupDAO.delete(dqg);
  }

  @Override
  public List<DetailQuestionGroup> getByQuestGroup(int questGroupId) {
    return detailQuestionGroupDAO.getByQuestGroup(questGroupId);
  }

  @Override
  public List<DetailQuestionGroup> getByQuest(int questId) {
    return detailQuestionGroupDAO.getByQuest(questId);
  }

  @Override
  public DetailQuestionGroup getById(int detQuestGroupId) {
    return detailQuestionGroupDAO.getById(detQuestGroupId);
  }

  @Override
  public int countByQuest(int questId) {
    return detailQuestionGroupDAO.countByQuest(questId);
  }
}
