/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterDistribution;
import java.util.List;

/**
 * @created Dec 4, 2016
 * @author awal
 */
public interface MasterDistributionService {

  MasterDistribution save(MasterDistribution md);
  MasterDistribution delete(MasterDistribution md);
  List<MasterDistribution> getByPageCompany(int coyId, int pageNo);
  List<MasterDistribution> getByPageCompanyOffice(int coyId, int officeId, int pageNo);
  int countByCompany(int coyId);
  int countByCompanyOffice(int coyId, int officeId);
}
