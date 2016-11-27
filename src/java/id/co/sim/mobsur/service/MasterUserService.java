/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterUser;
import java.util.List;

/**
 * @created Apr 4, 2016
 * @author awal
 */
public interface MasterUserService {

  MasterUser save(MasterUser mu);
  MasterUser delete(MasterUser mu);
  MasterUser getById(int id);
  MasterUser getByCode(String userCode);
  String getPassByUser(String userCode);
  List<MasterUser> getAll();
  List<MasterUser> getByPageCompany(int coyId, int pageNo);
  List<MasterUser> getByPageCompanyUserNameAndDate(int coyId, String userCode, String userName, String asOfDate, int pageNo);
  int count(int coyId);
  int countByCompanyUserNameAndDate(int coyId, String userCode, String userName, String asOfDate);
  List<MasterUser> getByCompany(int coyId);
  List<MasterUser> getByOffice(int officeId);
}
