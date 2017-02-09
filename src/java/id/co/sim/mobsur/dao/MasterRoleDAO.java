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
 * @created Apr 4, 2016
 * @author awal
 */
@Repository("masterRoleDAO")
public class MasterRoleDAO extends BaseDAO<MasterRole> {
  
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
  
  public List<MasterRole> getRolesByUser(int userId) {
    return sessionFactory.getCurrentSession().createQuery(
            "select rol from " + domainClass.getName() + " rol " +
              "join rol.userRoles ur " +
              "where ur.user.userId = :userId " +
              "order by rol.roleLevel")
            .setInteger("userId", userId)
            .list();
  }
  
  public List<MasterRole> getForClientRole() {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
              "where rol.roleType.roleTypeCode != 'O' " +
              "order by rol.roleLevel")
            .list();    
  }
  
  public List<MasterRole> getForOwnerRole() {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
              "where rol.roleType.roleTypeCode = 'O' " +
              "order by rol.roleLevel")
            .list();    
  }
  
  public List<MasterRole> getForAssignDist() {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
              "where rol.roleType.roleTypeCode in ('C','V') " +
              "order by rol.roleLevel")
            .list();
  }
  
  public List<MasterRole> getByParentRoleLevel(int parentRoleLevel) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
              "where rol.roleLevel > :parentRoleLevel " +
              "order by rol.roleLevel")
            .setInteger("parentRoleLevel", parentRoleLevel)
            .list();
  }
  
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
              "where role.role_id = nodes.role_id")
            .addEntity(domainClass)
            .setInteger("parentRoleId", parentRoleId)
            .setInteger("coyId", coyId)
            .list();
  }
  
  @Override
  public List<MasterRole> getAll() {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
              "order by rol.roleLevel")
            .list();
  }
}
