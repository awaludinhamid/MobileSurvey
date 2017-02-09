/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterQuestionGroup;
import id.co.sim.mobsur.dao.MasterQuestionGroupDAO;
import id.co.sim.mobsur.service.MasterQuestionGroupService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Jan 10, 2017
 * @author awal
 */
@Service("masterQuestionGroupService")
@Transactional(readOnly=true)
public class MasterQuestionGroupServiceImpl implements MasterQuestionGroupService {

  @Autowired
  private MasterQuestionGroupDAO masterQuestionGroupDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterQuestionGroup save(MasterQuestionGroup mqg) {
    return masterQuestionGroupDAO.save(mqg);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterQuestionGroup delete(MasterQuestionGroup mqg) {
    return masterQuestionGroupDAO.delete(mqg);
  }

  @Override
  public MasterQuestionGroup getById(int questGroupId) {
    return masterQuestionGroupDAO.getById(questGroupId);
  }

  @Override
  public List<MasterQuestionGroup> getByPageCoy(int coyId, int pageNo) {
    return masterQuestionGroupDAO.getByRangeCoy(coyId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterQuestionGroup> getByPageCoyAndLabel(int coyId, String questGroupLabelPattern, int pageNo) {
    return masterQuestionGroupDAO.getByRangeCoyAndLabel(coyId, questGroupLabelPattern, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByCoy(int coyId) {
    return masterQuestionGroupDAO.countByCoy(coyId);
  }

  @Override
  public int countByCoyAndLabel(int coyId, String questGroupLabelPattern) {
    return masterQuestionGroupDAO.countByCoyAndLabel(coyId, questGroupLabelPattern);
  }

  @Override
  public List<MasterQuestionGroup> getByCoy(int coyId) {
    return masterQuestionGroupDAO.getByCoy(coyId);
  }
}
