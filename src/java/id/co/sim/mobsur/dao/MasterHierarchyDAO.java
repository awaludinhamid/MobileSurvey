/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterHierarchy;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @created Nov 29, 2016
 * @author awal
 */
@Repository("masterHierarchyDAO")
public class MasterHierarchyDAO extends BaseDAO<MasterHierarchy> {

  public List<MasterHierarchy> getByRangeCoyRoleAndRoleUp(int coyId, int roleId, int roleIdUp, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " hie " +
              "where hie.company.coyId = :coyId " +
                "and role.roleId = " +
                    "(case when :roleId = -1 then role.roleId else :roleId end) " +
                "and coalesce(roleUp.roleId,0) = " +
                    "(case when :roleIdUp = -1 then coalesce(roleUp.roleId,0) else :roleIdUp end)")
            .setInteger("coyId", coyId)
            .setInteger("roleId", roleId)
            .setInteger("roleIdUp", roleIdUp)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  public int countByCoyRoleAndRoleUp(int coyId, int roleId, int roleIdUp) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " hie " +
              "where hie.company.coyId = :coyId " +
                "and role.roleId = " +
                    "(case when :roleId = -1 then role.roleId else :roleId end) " +
                "and coalesce(roleUp.roleId,0) = " +
                    "(case when :roleIdUp = -1 then coalesce(roleUp.roleId,0) else :roleIdUp end)")
            .setInteger("coyId", coyId)
            .setInteger("roleId", roleId)
            .setInteger("roleIdUp", roleIdUp)
            .iterate().next()).intValue();
  }
}
