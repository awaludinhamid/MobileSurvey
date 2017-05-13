/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.DetailGroupParam;
import id.co.sim.mobsur.dao.DetailGroupParamDAO;
import id.co.sim.mobsur.service.DetailGroupParamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Detail group parameter service implementation (see the service for usage info)
 * @created Jan 9, 2017
 * @author awal
 */
@Service("detailGroupParamService")
@Transactional(readOnly=true)
public class DetailGroupParamServiceImpl implements DetailGroupParamService {

  @Autowired
  private DetailGroupParamDAO detailGroupParamDAO;// DAO injection

  @Override
  public List<DetailGroupParam> getByGroupParamId(int groupParamId) {
    return detailGroupParamDAO.getByGroupParamId(groupParamId);
  }
}
