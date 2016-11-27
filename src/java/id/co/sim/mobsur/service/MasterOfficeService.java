/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterOffice;
import java.util.List;

/**
 * @created Nov 3, 2016
 * @author awal
 */
public interface MasterOfficeService {

  MasterOffice save(MasterOffice mo);
  MasterOffice delete(MasterOffice mo);
  List<MasterOffice> getAll();
  MasterOffice getById(int id);
  List<MasterOffice> getByPageCompany(int coyId, int pageNo);
  List<MasterOffice> getByPageCompanyOfficeCodeNameAndDate(
          int coyId, String officeCodePattern, String officeNamePattern, String asOfDate, int pageNo);
  int count(int coyId);
  int countByCompanyOfficeCodeNameAndDate(int coyId, String officeCodePattern, String officeNamePattern, String asOfDate);
  List<MasterOffice> getByCompany(int coyId);
}
