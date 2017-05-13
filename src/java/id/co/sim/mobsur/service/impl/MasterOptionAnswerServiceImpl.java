/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterOptionAnswer;
import id.co.sim.mobsur.dao.MasterOptionAnswerDAO;
import id.co.sim.mobsur.service.MasterOptionAnswerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**	
 * Option answer service implementation (see the service for usage info)
 * @created Jan 5, 2017
 * @author awal
 */
@Service("masterOptionAnswerService")
@Transactional(readOnly=true)
public class MasterOptionAnswerServiceImpl implements MasterOptionAnswerService {

  @Autowired
  private MasterOptionAnswerDAO masterOptionAnswerDAO;// DAO injection

  @Override
  public MasterOptionAnswer getById(int optionAnswerId) {
    return masterOptionAnswerDAO.getById(optionAnswerId);
  }

  @Override
  public List<MasterOptionAnswer> getAll() {
    return masterOptionAnswerDAO.getAll();
  }
}
