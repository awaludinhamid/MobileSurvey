/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.dao.DetailTemplateDAO;
import id.co.sim.mobsur.service.DetailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Detail template service implementation (see the service for usage info)
 * @author awal
 * @created Mar 22, 2017
 */
@Service("detailTemplateService")
@Transactional(readOnly=true)
public class DetailTemplateServiceImpl implements DetailTemplateService {

  @Autowired
  private DetailTemplateDAO detailTemplateDAO;// DAO injection

  @Override
  public int countByQuestGroup(int questGroupId) {
    return detailTemplateDAO.countByQuestGroup(questGroupId);
  }
}
