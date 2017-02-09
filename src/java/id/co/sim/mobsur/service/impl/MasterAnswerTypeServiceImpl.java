/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterAnswerType;
import id.co.sim.mobsur.dao.MasterAnswerTypeDAO;
import id.co.sim.mobsur.service.MasterAnswerTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Jan 5, 2017
 * @author awal
 */
@Service("masterAnswerTypeService")
@Transactional(readOnly=true)
public class MasterAnswerTypeServiceImpl implements MasterAnswerTypeService {

  @Autowired
  private MasterAnswerTypeDAO masterAnswerTypeDAO;

  @Override
  public MasterAnswerType getById(int answerTypeId) {
    return masterAnswerTypeDAO.getById(answerTypeId);
  }

  @Override
  public List<MasterAnswerType> getAll() {
    return masterAnswerTypeDAO.getAll();
  }
}
