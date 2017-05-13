/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterUser;
import java.util.List;

/**
 * SPI of user module
 * @created Apr 4, 2016
 * @author awal
 */
public interface MasterUserService {

  /**
   * Save given user
   * @param mu, user
   * @return saved user
   */
  MasterUser save(MasterUser mu);
  
  /**
   * Delete given user
   * @param mu, user 
   */
  void delete(MasterUser mu);
  
  /**
   * Get user by id
   * @param id
   * @return user based on given id
   */
  MasterUser getById(int id);
  
  /**
   * Get user by code
   * @param userCode
   * @return user based on given code
   */
  MasterUser getByCode(String userCode);
  
  /**
   * Get user password by user code
   * @param userCode
   * @return user password based on given user code
   */
  String getPassByUser(String userCode);
  
  /**
   * Get all user data
   * @return list of all users
   */
  List<MasterUser> getAll();
  
  /**
   * Get user data by page and company
   * @param coyId, company
   * @param pageNo, page number to proceed
   * @return list of users based on given page and company
   */
  List<MasterUser> getByPageCompany(int coyId, int pageNo);
  
  /**
   * Get user data by range, company, user code, user name and as of date
   * @param coyId, company
   * @param userCode
   * @param userName
   * @param asOfDate, end date more than or equal to this date
   * @param pageNo, page number to proceed
   * @return list of users based on given range, company, user code, user name and as of date
   */
  List<MasterUser> getByPageCompanyUserNameAndDate(int coyId, String userCode, String userName, String asOfDate, int pageNo);
  
  /**
   * Get number of user data by company
   * @param coyId, company
   * @return count of users based on given company
   */
  int count(int coyId);
  
  /**
   * Get number of user data by company, user code, user name and as of date
   * @param coyId, company
   * @param userCode
   * @param userName
   * @param asOfDate, end date more than or equal to this date
   * @return count of users based on given company, user code, user name and as of date
   */
  int countByCompanyUserNameAndDate(int coyId, String userCode, String userName, String asOfDate);
  
  /**
   * Get user data by company
   * @param coyId, company
   * @return list of users based on given company
   */
  List<MasterUser> getByCompany(int coyId);
  
  /**
   * Get user data by office
   * @param officeId
   * @return list of users based on given office
   */
  List<MasterUser> getByOffice(int officeId);
  
  /**
   * Get user by username and company
   * @param userName
   * @param coyCode, company code
   * @return user based on given username and company
   */
  MasterUser getByCodeAndCoy(String userName, String coyCode);
  
  /**
   * Get user data by role and company
   * @param roleId
   * @param coyId, company
   * @return list of users based on given role and company
   */
  List<MasterUser> getByRoleCoy(int roleId, int coyId);
  
  /**
   * Get user data who has verificator role by company
   * @param coyId, company
   * @return list of users who has verificator role based on given company
   */
  List<MasterUser> getByCoyAsVerificator(int coyId);
  
  /**
   * Get user data by company and superior role
   * @param coyId, company
   * @param parentRoleId
   * @return list of users based on given company and superior role
   */
  List<MasterUser> getByCoyAndUserChildRole(int coyId, int parentRoleId);
  
  /**
   * Get number of user data by company and superior role
   * @param coyId, company
   * @param parentRoleId
   * @return count of users based on given company and superior role
   */
  int countByCoyAndUserChildRole(int coyId, int parentRoleId);
  
  /**
   * Get user data by superior role
   * @param parentUserId
   * @return list of users based on given superior role
   */
  List<MasterUser> getByParentUser(int parentUserId);
  
  /**
   * Get user data by role type and superior
   * @param roleTypeId
   * @param parentUserId
   * @return list of users based on given role type and superior
   */
  List<MasterUser> getByRoleAndParentUser(int roleTypeId, int parentUserId);
  
  /**
   * Get user data by office and role type code
   * @param officeId
   * @param roleTypeCode
   * @return list of users based on given office and role type code
   */
  List<MasterUser> getByOfficeAndRoleTypeCode(int officeId, String roleTypeCode);
  
  /**
   * Get user data by role and office
   * @param roleId
   * @param officeId
   * @return list of users based on given role and office
   */
  List<MasterUser> getByRoleOffice(int roleId, int officeId);
}
