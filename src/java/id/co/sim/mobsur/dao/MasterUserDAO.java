/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterUser;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_USER
 * extends BaseDAO class
 * @see BaseDAO
 * @created Apr 4, 2016
 * @author awal
 */
@Repository("masterUserDAO")
public class MasterUserDAO extends BaseDAO<MasterUser>{  

  /**
   * Get user by username
   * @param userName
   * @return user based on given username
   */
  public MasterUser getByCode(String userName) {
    return (MasterUser) sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " usr " +
              "where usr.userCode = :userCode " +
                "and usr.startDate <= current_date " +
                "and usr.endDate >= current_date")
            .setString("userCode", userName)
            .uniqueResult();
  } 

  /**
   * Get user password by user code
   * @param userCode
   * @return user password based on given user code
   */
  public String getPassByUser(String userCode) {
      return (String) sessionFactory.getCurrentSession().createQuery(
              "select usr.userPassword from " + domainClass.getName() + " usr " +
                "where usr.userCode = :userCode " +
                  "and usr.startDate <= current_date " +
                  "and usr.endDate >= current_date")
              .setString("userCode", userCode)
              .uniqueResult();
  }
  
  /**
   * Get user data by range and company
   * @param coyId, company
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of users based on given range and company
   */
  public List<MasterUser> getByRangeCompany(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " usr " +
              "where usr.office.company.coyId = :coyId " +
                "and usr.startDate <= current_date " +
                "and usr.endDate >= current_date")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get user data by range, company, user code, user name and as of date
   * @param coyId, company
   * @param userCode
   * @param userName
   * @param asOfDate, end date more than or equal to this date
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of users based on given range, company, user code, user name and as of date
   */
  public List<MasterUser> getByRangeCompanyUserNameAndDate(int coyId, String userCode, String userName, String asOfDate, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " usr " +
              "where usr.office.company.coyId = :coyId " +
                "and usr.userCode = " +
                    "(case when :userCode = '' then usr.userCode else :userCode end)" +
                "and userName = " +
                    "(case when :userName = '' then usr.userName else :userName end)" +
                "and usr.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("coyId", coyId)
            .setString("userCode", userCode)
            .setString("userName", userName)
            .setString("asOfDate", asOfDate)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of user data by company
   * @param coyId, company
   * @return count of users based on given company
   */
  public int count(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " usr " +
              "where usr.office.company.coyId = :coyId " +
                "and usr.startDate <= current_date " +
                "and usr.endDate >= current_date")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }
  
  /**
   * Get number of user data by company, user code, user name and as of date
   * @param coyId, company
   * @param userCode
   * @param userName
   * @param asOfDate, end date more than or equal to this date
   * @return count of users based on given company, user code, user name and as of date
   */
  public int countByCompanyUserNameAndDate(int coyId, String userCode, String userName, String asOfDate) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " usr " +
              "where usr.office.company.coyId = :coyId " +
                "and usr.userCode = " +
                    "(case when :userCode = '' then usr.userCode else :userCode end)" +
                "and userName = " +
                    "(case when :userName = '' then usr.userName else :userName end)" +
                "and usr.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("coyId", coyId)
            .setString("userCode", userCode)
            .setString("userName", userName)
            .setString("asOfDate", asOfDate)
            .iterate().next()).intValue();
  }
  
  /**
   * Get user data by company
   * @param coyId, company
   * @return list of users based on given company
   */
  public List<MasterUser> getByCompany(int coyId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " usr " +
              "where usr.office.company.coyId = :coyId " +
                "and usr.startDate <= current_date " +
                "and usr.endDate >= current_date " +
              "order by usr.userCode, usr.userName")
            .setInteger("coyId", coyId)
            .list();
  }
  
  /**
   * Get user data by office
   * @param officeId
   * @return list of users based on given office
   */
  public List<MasterUser> getByOffice(int officeId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " usr " +
              "where usr.office.officeId = :officeId " +
                "and usr.startDate <= current_date " +
                "and usr.endDate >= current_date")
            .setInteger("officeId", officeId)
            .list();
  }
  
  /**
   * Get user by username and company
   * @param userName
   * @param coyCode, company code
   * @return user based on given username and company
   */
  public MasterUser getByCodeAndCoy(String userName, String coyCode) {
    return (MasterUser) sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " usr " +
              "where usr.userCode = :userCode " +
                "and usr.office.company.coyCode = :coyCode " +
                "and usr.startDate <= current_date " +
                "and usr.endDate >= current_date")
            .setString("userCode", userName)
            .setString("coyCode", coyCode)
            .uniqueResult();
  } 
  
  /**
   * Get user data by role and company
   * @param roleId
   * @param coyId, company
   * @return list of users based on given role and company
   */
  public List<MasterUser> getByRoleCoy(int roleId, int coyId) {
    return sessionFactory.getCurrentSession().createQuery(
            "select usr from " + domainClass.getName() + " usr " +
              "join usr.userRoles ur " +
              "where ur.role.roleId = :roleId " +
                "and usr.office.company.coyId = :coyId " +
                "and usr.startDate <= current_date " +
                "and usr.endDate >= current_date " +
                "and ur.role.startDate <= current_date " +
                "and ur.role.endDate >= current_date")
            .setInteger("roleId", roleId)
            .setInteger("coyId", coyId)
            .list();
  }
  
  /**
   * Get user data who has verificator role by company
   * @param coyId, company
   * @return list of users who has verificator role based on given company
   */
  public List<MasterUser> getByCoyAsVerificator(int coyId) {
    return sessionFactory.getCurrentSession().createQuery(
            "select usr from " + domainClass.getName() + " usr " +
              "join usr.userRoles ur " +
              "where usr.office.company.coyId = :coyId " +
                "and ur.role.roleType.roleTypeCode = 'V' " +
                "and usr.startDate <= current_date " +
                "and usr.endDate >= current_date " +
                "and ur.role.startDate <= current_date " +
                "and ur.role.endDate >= current_date")
            .setInteger("coyId", coyId)
            .list();
  }
  
  /**
   * Get user data by company and superior role
   * @param coyId, company
   * @param parentRoleId
   * @return list of users based on given company and superior role
   */
  public List<MasterUser> getByCoyAndUserChildRole(int coyId, int parentRoleId) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select * from master_user where user_id in ( " +
              "select usrrol.user_id from master_user_role usrrol, ( " +
                "with recursive nodes (role_id) as ( " +
                  "select hie1.role_id from master_hierarchy hie1 " +
                    "where hie1.role_id_up = :parentRoleId " +
                      "and hie1.coy_id = :coyId " +
                  "union " +
                  "select hie2.role_id " +
                    "from master_hierarchy hie2, "+
                    "nodes hie3 " +
                    "where hie2.role_id_up = hie3.role_id " +
                      "and hie2.coy_id = :coyId) " +
                "select role_id from nodes) nodes " +
                "where usrrol.role_id = nodes.role_id)")
            .addEntity(domainClass)
            .setInteger("coyId", coyId)
            .setInteger("parentRoleId", parentRoleId)
            .list();            
  }
  
  /**
   * Get number of user data by company and superior role
   * @param coyId, company
   * @param parentRoleId
   * @return count of users based on given company and superior role
   */
  public int countByCoyAndUserChildRole(int coyId, int parentRoleId) {
    return ((Long) sessionFactory.getCurrentSession().createSQLQuery(
            "select count(*) from master_user usr where user_id in ( " +
              "select usrrol.user_id from master_user_role usrrol, ( " +
                "with recursive nodes (role_id) as ( " +
                  "select hie1.role_id from master_hierarchy hie1 " +
                    "where hie1.role_id_up = :parentRoleId " +
                      "and hie1.coy_id = :coyId " +
                  "union " +
                  "select hie2.role_id " +
                    "from master_hierarchy hie2, "+
                    "nodes hie3 " +
                    "where hie2.role_id_up = hie3.role_id " +
                      "and hie2.coy_id = :coyId) " +
                "select role_id from nodes) nodes " +
                "where usrrol.role_id = nodes.role_id) " +
                  "and usr.start_date <= current_date " +
                  "and usr.end_date >= current_date")
            .setInteger("coyId", coyId)
            .setInteger("parentRoleId", parentRoleId)
            .iterate().next()).intValue();            
  }
  
  /**
   * Get user data by superior role
   * @param parentUserId
   * @return list of users based on given superior role
   */
  public List<MasterUser> getByParentUser(int parentUserId) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select a.* from master_user a, get_user_child(:parentUserId) b " +
              "where a.user_id = b.user_id " +
                "and a.start_date <= current_date " +
                "and a.end_date >= current_date")
            .addEntity(domainClass)
            .setInteger("parentUserId", parentUserId)
            .list();
  }
  
  /**
   * Get user data by role type and superior
   * @param roleTypeId
   * @param parentUserId
   * @return list of users based on given role type and superior
   */
  public List<MasterUser> getByRoleAndParentUser(int roleTypeId, int parentUserId) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select a.* from master_user a, get_user_child(:parentUserId) b, " +
              "master_user_role c, master_role d, master_role_type e " +
              "where a.user_id = b.user_id " +
                "and a.user_id = c.user_id " +
                "and c.role_id = d.role_id " +
                "and d.role_type_id = e.role_type_id " +
                "and e.role_type_id = " +
                    "(case when :roleTypeId = 0 then e.role_type_id else :roleTypeId end) " +
                "and a.start_date <= current_date " +
                "and a.end_date >= current_date " +
                /*"and c.start_date <= current_date " +
                "and c.end_date >= current_date " +*/
                "and d.start_date <= current_date " +
                "and d.end_date >= current_date " +
              "order by a.user_code")
            .addEntity(domainClass)
            .setInteger("roleTypeId", roleTypeId)
            .setInteger("parentUserId", parentUserId)
            .list();
  }
  
  /**
   * Get user data by office and role type code
   * @param officeId
   * @param roleTypeCode
   * @return list of users based on given office and role type code
   */
  public List<MasterUser> getByOfficeAndRoleTypeCode(int officeId, String roleTypeCode) {
    return sessionFactory.getCurrentSession().createQuery(
            "select usr from " + domainClass.getName() + " usr " +
              "join usr.userRoles usrrol " +
              "where usr.office.officeId = :officeId " +
                "and usrrol.role.roleType.roleTypeCode = :roleTypeCode " +
                "and usr.startDate <= current_date " +
                "and usr.endDate >= current_date " +
                "and usrrol.role.startDate <= current_date " +
                "and usrrol.role.endDate >= current_date")
            .setInteger("officeId", officeId)
            .setString("roleTypeCode", roleTypeCode)
            .list();
  } 
  
  /**
   * Get user data by role and office
   * @param roleId
   * @param officeId
   * @return list of users based on given role and office
   */
  public List<MasterUser> getByRoleOffice(int roleId, int officeId) {
    return sessionFactory.getCurrentSession().createQuery(
            "select usr from " + domainClass.getName() + " usr " +
              "join usr.userRoles ur " +
              "where ur.role.roleId = :roleId " +
                "and usr.office.officeId = :officeId " +
                "and usr.startDate <= current_date " +
                "and usr.endDate >= current_date " +
                "and ur.role.startDate <= current_date " +
                "and ur.role.endDate >= current_date")
            .setInteger("roleId", roleId)
            .setInteger("officeId", officeId)
            .list();
  }
}
