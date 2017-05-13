/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MobileTaskResultDetail;
import id.co.sim.mobsur.dao.MobileTaskResultDetailDAO;
import id.co.sim.mobsur.service.MobileTaskResultDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**	
 * Result detail service implementation (see the service for usage info)
 * @author awal
 * @created Feb 20, 2017
 */
@Service("mobileTaskResultDetailService")
@Transactional(readOnly=true)
public class MobileTaskResultDetailServiceImpl implements MobileTaskResultDetailService {

  @Autowired
  private MobileTaskResultDetailDAO mobileTaskResultDetailDAO;// DAO injection

  @Override
  public MobileTaskResultDetail getById(int taskResultdetId) {
    return mobileTaskResultDetailDAO.getById(taskResultdetId);
  }
}
