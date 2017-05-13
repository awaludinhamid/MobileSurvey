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
 * DAO table MASTER_HIERARCHY
 * extends BaseDAO class
 * @see BaseDAO
 * @created Nov 29, 2016
 * @author awal
 */
@Repository("masterHierarchyDAO")
public class MasterHierarchyDAO extends BaseDAO<MasterHierarchy> {

  /**
   * Get hierarchy data by range, company, role and superior role
   * @param coyId, company
   * @param roleId
   * @param roleIdUp, superior role
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of hierarchies based on range, company, role and superior role
   */
  public List<MasterHierarchy> getByRangeCoyRoleAndRoleUp(int coyId, int roleId, int roleIdUp, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " hie " +
              "where hie.company.coyId = :coyId " +
                "and hie.role.roleId = " +
                    "(case when :roleId = 0 then hie.role.roleId else :roleId end) " +
                "and coalesce(hie.roleUp.roleId,-1) = " +
                    "(case when :roleIdUp = 0 then coalesce(hie.roleUp.roleId,-1) else :roleIdUp end)")
            .setInteger("coyId", coyId)
            .setInteger("roleId", roleId)
            .setInteger("roleIdUp", roleIdUp)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get number of hierarchy data by company, role and superior role
   * @param coyId, company
   * @param roleId
   * @param roleIdUp, superior role
   * @return count of hierarchies based on company, role and superior role
   */
  public int countByCoyRoleAndRoleUp(int coyId, int roleId, int roleIdUp) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " hie " +
              "where hie.company.coyId = :coyId " +
                "and hie.role.roleId = " +
                    "(case when :roleId = 0 then hie.role.roleId else :roleId end) " +
                "and coalesce(hie.roleUp.roleId,-1) = " +
                    "(case when :roleIdUp = 0 then coalesce(hie.roleUp.roleId,-1) else :roleIdUp end)")
            .setInteger("coyId", coyId)
            .setInteger("roleId", roleId)
            .setInteger("roleIdUp", roleIdUp)
            .iterate().next()).intValue();
  }
  
  /**
   * Get hierarchy data by range
   * Override default behavior
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of hierarchies based on range
   */
  @Override
  public List<MasterHierarchy> getByRange(int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " hie " +
                "where hie.startDate <= current_date " +
                "and hie.endDate >= current_date")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of all hierarchy data
   * Override default behavior
   * @return count of all hierarchies
   */
  @Override
  public int count() {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " hie " +
                "where hie.startDate <= current_date " +
                "and hie.endDate >= current_date")
            .iterate().next()).intValue();
  }
}
