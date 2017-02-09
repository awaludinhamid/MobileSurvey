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
 * @created Apr 4, 2016
 * @author awal
 */
@Repository("masterUserDAO")
public class MasterUserDAO extends BaseDAO<MasterUser>{  

  /**
   * Retrieve record from database by String name
   * @param userName
   * @return class bean
   */
  public MasterUser getByCode(String userName) {
    return (MasterUser) sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() +
              " where userCode = :userCode")
            .setString("userCode", userName)
            .uniqueResult();
  } 

  public String getPassByUser(String userCode) {
      return (String) sessionFactory.getCurrentSession().createQuery(
              "select userPassword from " + domainClass.getName() +
                " where userCode = :userCode")
              .setString("userCode", userCode)
              .uniqueResult();
  }
  
  public List<MasterUser> getByRangeCompany(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " usr " +
              "where usr.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
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
  
  public int count(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " usr " +
              "where usr.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }
  
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
  
  public List<MasterUser> getByCompany(int coyId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " usr " +
              "where usr.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .list();
  }
  
  public List<MasterUser> getByOffice(int officeId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " usr " +
              "where usr.office.officeId = :officeId")
            .setInteger("officeId", officeId)
            .list();
  }
  
  public MasterUser getByCodeAndCoy(String userName, String coyCode) {
    return (MasterUser) sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " usr " +
              "where usr.userCode = :userCode " +
                "and usr.office.company.coyCode = :coyCode")
            .setString("userCode", userName)
            .setString("coyCode", coyCode)
            .uniqueResult();
  } 
  
  public List<MasterUser> getByRoleCoy(int roleId, int coyId) {
    return sessionFactory.getCurrentSession().createQuery(
            "select usr from " + domainClass.getName() + " usr " +
              "join usr.userRoles ur " +
              "where ur.role.roleId = :roleId " +
                "and usr.office.company.coyId = :coyId")
            .setInteger("roleId", roleId)
            .setInteger("coyId", coyId)
            .list();
  }
  
  public List<MasterUser> getByCoyAsVerificator(int coyId) {
    return sessionFactory.getCurrentSession().createQuery(
            "select usr from " + domainClass.getName() + " usr " +
              "join usr.userRoles ur " +
              "where usr.office.company.coyId = :coyId " +
                "and ur.role.roleType.roleTypeCode = 'V'")
            .setInteger("coyId", coyId)
            .list();
  }
  
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
  
  public int countByCoyAndUserChildRole(int coyId, int parentRoleId) {
    return ((Long) sessionFactory.getCurrentSession().createSQLQuery(
            "select count(*) from master_user where user_id in ( " +
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
            .setInteger("coyId", coyId)
            .setInteger("parentRoleId", parentRoleId)
            .iterate().next()).intValue();            
  }
  
  public List<MasterUser> getByParentUser(int parentUserId) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select a.* from master_user a, get_user_child(:parentUserId) b " +
              "where a.user_id = b.user_id")
            .addEntity(domainClass)
            .setInteger("parentUserId", parentUserId)
            .list();
  }
  
  public List<MasterUser> getByRoleAndParentUser(int roleTypeId, int parentUserId) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select a.* from master_user a, get_user_child(:parentUserId) b, " +
              "master_user_role c, master_role d, master_role_type e " +
              "where a.user_id = b.user_id " +
                "and a.user_id = c.user_id " +
                "and c.role_id = d.role_id " +
                "and d.role_type_id = e.role_type_id " +
                "and e.role_type_id = " +
                    "(case when :roleTypeId = 0 then e.role_type_id else :roleTypeId end)")
            .addEntity(domainClass)
            .setInteger("roleTypeId", roleTypeId)
            .setInteger("parentUserId", parentUserId)
            .list();
  }
  
  public List<MasterUser> getByOfficeAndRoleTypeCode(int officeId, String roleTypeCode) {
    return sessionFactory.getCurrentSession().createQuery(
            "select usr from " + domainClass.getName() + " usr " +
              "join usr.userRoles usrrol " +
              "where usr.office.officeId = :officeId " +
                "and usrrol.role.roleType.roleTypeCode = :roleTypeCode")
            .setInteger("officeId", officeId)
            .setString("roleTypeCode", roleTypeCode)
            .list();
  } 
}
