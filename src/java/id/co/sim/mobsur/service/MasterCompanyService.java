/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterCompany;
import java.util.List;

/**
 * @created Oct 12, 2016
 * @author awal
 */
public interface MasterCompanyService {

  MasterCompany save(MasterCompany mc);
  MasterCompany delete(MasterCompany mc);
  MasterCompany getById(int id);
  List<MasterCompany> getAll();
  List<MasterCompany> getByPage(int pageNo);
  List<MasterCompany> getByPageCodeAndNamePattern(String coyCodePattern, String coyNamePattern, int pageNo);
  int count();
  int countByCodeAndNamePattern(String coyCodePattern, String coyNamePattern);
  MasterCompany getValidCoyByUserId(int userId);
}
