/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterDistribution;
import java.util.List;

/**
 * SPI of distribution module
 * @created Dec 4, 2016
 * @author awal
 */
public interface MasterDistributionService {

  /**
   * Save given distribution
   * @param md, distribution
   * @return saved distribution
   */
  MasterDistribution save(MasterDistribution md);
  
  /**
   * Delete given distribution
   * @param md,distribution
   */
  void delete(MasterDistribution md);
  
  /**
   * Get distribution by id
   * @param distId, distribution
   * @return distribution based on given id
   */
  MasterDistribution getById(int distId);
  
  /**
   * Get distribution data by page and company
   * @param coyId, company
   * @param pageNo, page number to proceed
   * @return list of distributions based on given page and company
   */
  List<MasterDistribution> getByPageCompany(int coyId, int pageNo);
  
  /**
   * Get distribution data by page, company and office
   * @param coyId, company
   * @param officeId
   * @param pageNo, page number to proceed
   * @return list of distributions based on given page, company and office
   */
  List<MasterDistribution> getByPageCompanyOffice(int coyId, int officeId, int pageNo);
  
  /**
   * Get number of distribution data by company
   * @param coyId, company
   * @return count of distribution based on given company
   */
  int countByCompany(int coyId);
  
  /**
   * Get number of distribution data by company and office 
   * @param coyId
   * @param officeId
   * @return count of distribution based on given company and office
   */
  int countByCompanyOffice(int coyId, int officeId);
}
