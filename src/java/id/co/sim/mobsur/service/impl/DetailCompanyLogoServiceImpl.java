/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.DetailCompanyLogo;
import id.co.sim.mobsur.dao.DetailCompanyLogoDAO;
import id.co.sim.mobsur.service.DetailCompanyLogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Oct 19, 2016
 * @author awal
 */
@Service("detailCompanyLogoService")
@Transactional(readOnly=true)
public class DetailCompanyLogoServiceImpl implements DetailCompanyLogoService {

  @Autowired
  private DetailCompanyLogoDAO detailCompanyLogoDAO;

  @Override
  @Transactional(readOnly=false)
  public DetailCompanyLogo save(DetailCompanyLogo dcl) {
    return detailCompanyLogoDAO.save(dcl);
  }

  @Override
  @Transactional(readOnly=false)
  public DetailCompanyLogo delete(DetailCompanyLogo dcl) {
    return detailCompanyLogoDAO.delete(dcl);
  }

  @Override
  public DetailCompanyLogo getById(int id) {
    return detailCompanyLogoDAO.getById(id);
  }

  @Override
  public DetailCompanyLogo getByCoyId(int coyId) {
    return detailCompanyLogoDAO.getByCoyId(coyId);
  }
}
