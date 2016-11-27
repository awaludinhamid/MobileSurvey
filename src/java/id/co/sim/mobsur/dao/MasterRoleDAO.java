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
              "where ur.user.userId = :userId")
            .setInteger("userId", userId)
            .list();
  }
  
  public List<MasterRole> getForClientRole() {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
              "where rol.roleName != 'System Owner'")
            .list();    
  }
}
