/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.DetailCompanyLogo;

/**
 * @created Oct 19, 2016
 * @author awal
 */
public interface DetailCompanyLogoService {

  DetailCompanyLogo save(DetailCompanyLogo dcl);
  DetailCompanyLogo delete(DetailCompanyLogo dcl);
  DetailCompanyLogo getById(int id);
  DetailCompanyLogo getByCoyId(int coyId);
}
