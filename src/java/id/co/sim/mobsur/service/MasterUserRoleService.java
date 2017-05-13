/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterUserRole;
import java.util.List;

/**
 * SPI of user role module
 * @created Apr 14, 2016
 * @author awal
 */
public interface MasterUserRoleService {
  
  /**
   * Save given user role
   * @param mur, user role
   * @return saved user role
   */
  MasterUserRole save(MasterUserRole mur);
  
  /**
   * Delete given user role
   * @param mur, user role
   */
  void delete(MasterUserRole mur);
  
  /**
   * Get user role by id
   * @param userRoleId
   * @return user role based on given id
   */
  MasterUserRole getById(int userRoleId);
  
  /**
   * Get user role data by page and company
   * @param coyId, company
   * @param pageNo, page number to proceed
   * @return list of user roles based on given page and company
   */
  List<MasterUserRole> getPageByCoy(int coyId, int pageNo);  
  
  /**
   * Get user role data by page, company, office, role, username pattern/partial and as of date
   * @param coyId, company
   * @param officeId
   * @param roleId
   * @param userNamePattern
   * @param asOfDate, end date more than or equal to this date
   * @param pageNo, page number to proceed
   * @return list of user roles based on given page, company, office, role, username pattern and as of date
   */
  List<MasterUserRole> getPageByCoyOfficeRoleUserNameDate(
          int coyId, int officeId, int roleId, String userNamePattern, String asOfDate, int pageNo);  
  
  /**
   * Get number of user role data by company
   * @param coyId, company
   * @return count of user roles based on given company
   */
  int countByCoy(int coyId);  
  
  /**
   * Get number of user role data by company, office, role, username pattern/partial and as of date
   * @param coyId, company
   * @param officeId
   * @param roleId
   * @param userNamePattern
   * @param asOfDate, end date more than or equal to this date
   * @return count of user roles based on given company, office, role, username pattern/partial and as of date
   */
  int countByCoyOfficeRoleUserNameDate(int coyId, int officeId, int roleId, String userNamePattern, String asOfDate);
  
  /**
   * Get user role data by office
   * @param officeId
   * @return list of user roles based on given office
   */
  List<MasterUserRole> getByOffice(int officeId);
  
  /**
   * Get number of valid user role data by user
   * @param userId
   * @return count of valid user roles based on given user
   */
  int countByUserValid(int userId);
  
  /**
   * Get number of user role data by role
   * @param roleId
   * @return count of user roles based on given role
   */
  int countByRole(int roleId);
  
  /**
   * Get number of user role data by user
   * @param userId
   * @return count of user roles based on given user
   */
  int countByUser(int userId);
  
  /**
   * Get user role by user
   * @param userId
   * @return user role based on given user
   */
  MasterUserRole getByUser(int userId);
}
