/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterQuestion;
import id.co.sim.mobsur.dao.MasterQuestionDAO;
import id.co.sim.mobsur.service.MasterQuestionService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Jan 5, 2017
 * @author awal
 */
@Service("masterQuestionService")
@Transactional(readOnly=true)
public class MasterQuestionServiceImpl implements MasterQuestionService {

  @Autowired
  private MasterQuestionDAO masterQuestionDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false) 
  public MasterQuestion save(MasterQuestion mq) {
    return masterQuestionDAO.save(mq);
  }

  @Override
  public MasterQuestion delete(MasterQuestion mq) {
    return masterQuestionDAO.delete(mq);
  }

  @Override
  public MasterQuestion getById(int questId) {
    return masterQuestionDAO.getById(questId);
  }

  @Override
  public List<MasterQuestion> getByPageCoy(int coyId, int pageNo) {
    return masterQuestionDAO.getByRangeCoy(coyId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterQuestion> getByPageCoyLabelAndAnswer(int coyId, String questLabelPattern, int answerTypeId, int pageNo) {
    return masterQuestionDAO.getByRangeCoyLabelAndAnswer(coyId, questLabelPattern, answerTypeId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByCoy(int coyId) {
    return masterQuestionDAO.countByCoy(coyId);
  }

  @Override
  public int countByCoyLabelAndAnswer(int coyId, String questLabelPattern, int answerTypeId) {
    return masterQuestionDAO.countByCoyLabelAndAnswer(coyId, questLabelPattern, answerTypeId);
  }

  @Override
  public List<MasterQuestion> getByCoy(int coyId) {
    return masterQuestionDAO.getByCoy(coyId);
  }
}
