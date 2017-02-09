/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterParameter;
import java.util.List;

/**
 * @created Nov 18, 2016
 * @author awal
 */
public interface MasterParameterService {

  MasterParameter save(MasterParameter mp);
  MasterParameter delete(MasterParameter mp);
  List<MasterParameter> getByPageCompany(int coyId, int pageNo);
  List<MasterParameter> getByPageCompanyCodeDescAndApps(int coyId, String parCodePattern, String parDescPattern, String parAppsType, int pageNo);
  int countByCompany(int coyId);
  int countByCompanyCodeDescAndApps(int coyId, String parCodePattern, String parDescPattern, String parAppsType);
}
