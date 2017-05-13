/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MobileTaskResultImage;
import id.co.sim.mobsur.dao.MobileTaskResultImageDAO;
import id.co.sim.mobsur.service.MobileTaskResultImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**	
 * Result image service implementation (see the service for usage info)
 * @author awal
 * @created Feb 20, 2017
 */
@Service("mobileTaskResultImageService")
@Transactional(readOnly=true)
public class MobileTaskResultImageServiceImpl implements MobileTaskResultImageService {

  @Autowired
  private MobileTaskResultImageDAO mobileTaskResultImageDAO;// DAO injection

  @Override
  public MobileTaskResultImage getById(int imageId) {
    return mobileTaskResultImageDAO.getById(imageId);
  }
}
