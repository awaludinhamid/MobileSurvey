/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterRole;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_ROLE
 * extends BaseDAO class
 * @see BaseDAO
 * @created Apr 4, 2016
 * @author awal
 */
@Repository("masterRoleDAO")
public class MasterRoleDAO extends BaseDAO<MasterRole> {
  
  /**
   * Get role data by range, role and as of date
   * @param roleId
   * @param asOfDate, end date more than or equal to this date
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of roles based on given range, role and as of date
   */
  public List<MasterRole> getByRangeRoleAndDate(int roleId, String asOfDate, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
            "where rol.roleId = " +
                    "(case when :roleId = 0 then rol.roleId else :roleId end)" +
              "and rol.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("roleId", roleId)
            .setString("asOfDate", asOfDate)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of role data by role and as of date
   * @param roleId
   * @param asOfDate, end date more than or equal to this date
   * @return count of roles based on given role and as of date
   */
  public int countByRoleAndDate(int roleId, String asOfDate) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " rol " +
            "where rol.roleId = " +
                    "(case when :roleId = 0 then rol.roleId else :roleId end)" +
              "and rol.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("roleId", roleId)
            .setString("asOfDate", asOfDate)
            .iterate().next()).intValue();
  }
  
  /**
   * Get role data by user
   * @param userId
   * @return list of roles based on given user
   */
  public List<MasterRole> getRolesByUser(int userId) {
    return sessionFactory.getCurrentSession().createQuery(
            "select rol from " + domainClass.getName() + " rol " +
              "join rol.userRoles ur " +
              "where ur.user.userId = :userId " +
                "and rol.startDate <= current_date " +
                "and rol.endDate >= current_date " +
                "and ur.user.startDate <= current_date " +
                "and ur.user.endDate >= current_date " +
              "order by rol.roleLevel")
            .setInteger("userId", userId)
            .list();
  }
  
  /**
   * Get role data specific for client
   * @return list of roles for client
   */
  public List<MasterRole> getForClientRole() {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
              "where rol.roleType.roleTypeCode != 'O' " +
                "and rol.startDate <= current_date " +
                "and rol.endDate >= current_date " +
              "order by rol.roleLevel")
            .list();    
  }
  
  /**
   * Get role data specific for owner
   * @return list of roles for owner
   */
  public List<MasterRole> getForOwnerRole() {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
              "where rol.roleType.roleTypeCode = 'O' " +
                "and rol.startDate <= current_date " +
                "and rol.endDate >= current_date " +
              "order by rol.roleLevel")
            .list();    
  }
  
  /**
   * Get role data specific for assign distribution module
   * @return list of roles for assign distribution module
   */
  public List<MasterRole> getForAssignDist() {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
              "where rol.roleType.roleTypeCode in ('C','V') " +
                "and rol.startDate <= current_date " +
                "and rol.endDate >= current_date " +
              "order by rol.roleLevel")
            .list();
  }
  
  /**
   * Get role data by parent role level
   * @param parentRoleLevel
   * @return list of roles based on given parent role level
   */
  public List<MasterRole> getByParentRoleLevel(int parentRoleLevel) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
              "where rol.roleLevel > :parentRoleLevel " +
                "and rol.startDate <= current_date " +
                "and rol.endDate >= current_date " +
              "order by rol.roleLevel")
            .setInteger("parentRoleLevel", parentRoleLevel)
            .list();
  }
  
  /**
   * Get role data by company and parent role
   * @param coyId, company
   * @param parentRoleId
   * @return list of roles based on given company and parent role
   */
  public List<MasterRole> getByCoyAndParentRole(int coyId, int parentRoleId) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select role.* from master_role role,( " +
              "with recursive nodes (role_id) as ( " +
                "select hie1.role_id " +
                  "from master_hierarchy hie1 " +
                  "where hie1.role_id_up = :parentRoleId " +
                    "and hie1.coy_id = :coyId " +
                "union " +
                "select hie2.role_id " +
                  "from master_hierarchy hie2, " +
                  "nodes hie3 " +
                  "where hie2.role_id_up = hie3.role_id " +
                    "and hie2.coy_id = :coyId) " +
              "select role_id from nodes) nodes " +
              "where role.role_id = nodes.role_id " +
                "and role.startDate <= current_date " +
                "and role.endDate >= current_date")
            .addEntity(domainClass)
            .setInteger("parentRoleId", parentRoleId)
            .setInteger("coyId", coyId)
            .list();
  }
  
  /**
   * Get all role data
   * Override default behavior
   * @return list of all roles
   */
  @Override
  public List<MasterRole> getAll() {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
              "where rol.startDate <= current_date " +
                "and rol.endDate >= current_date " +
              "order by rol.roleLevel")
            .list();
  }
  
  /**
   * Get role data by range
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of roles based on given range
   */
  @Override
  public List<MasterRole> getByRange(int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
                "where rol.startDate <= current_date " +
                "and rol.endDate >= current_date")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of all role data
   * Override default behavior
   * @return count of all roles
   */
  @Override
  public int count() {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " rol " +
                "where rol.startDate <= current_date " +
                "and rol.endDate >= current_date")
            .iterate().next()).intValue();
  }
  
  /**
   * Get role data specific for job assign
   * @return list of roles for job assign
   */
  public List<MasterRole> getForJobAssign() {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
              "where rol.roleType.roleTypeCode in ('M','C') " +
                "and rol.startDate <= current_date " +
                "and rol.endDate >= current_date " +
              "order by rol.roleLevel")
            .list();    
  }
  
  /**
   * Get role data by role level
   * @param roleLevel
   * @return list of roles based on given role level
   */
  public List<MasterRole> getByRoleLevel(int roleLevel) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
              "where rol.roleLevel = :roleLevel " +
              "order by rol.roleName")
            .setInteger("roleLevel", roleLevel)
            .list();    
  }
  
  /**
   * Get role data by role type
   * @param roleTypeCode, role type code collection
   * @return list of roles based on given role type
   */
  public List<MasterRole> getByRoleType(String[] roleTypeCode) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
              "where rol.roleType.roleTypeCode in :roleTypeCode " +
                "and rol.startDate <= current_date " +
                "and rol.endDate >= current_date " +
              "order by rol.roleLevel")
            .setParameterList("roleTypeCode", roleTypeCode)
            .list();    
  }
}
