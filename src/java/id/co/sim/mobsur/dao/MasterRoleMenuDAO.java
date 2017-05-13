/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterRoleMenu;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * DAO table MASTER_ROLE_MENU
 * extends BaseDAO class
 * @see BaseDAO
 * @created Oct 16, 2016
 * @author awal
 */
@Service("masterRoleMenuDAO")
public class MasterRoleMenuDAO extends BaseDAO<MasterRoleMenu> {

  /**
   * Get role menu data by role
   * @param roleId
   * @return list of role menus based on given role
   */
  public List<MasterRoleMenu> getByRoleId(int roleId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rm " +
              "where rm.role.roleId = :roleId ")/* +
                "and rm.startDate <= current_date " +
                "and rm.endDate >= current_date")*/
            .setInteger("roleId",roleId)
            .list();
  }
  
  /**
   * Get role menu data by range, role, menu and as of date
   * @param roleId
   * @param menuId
   * @param asOfDate, end date more than or equal to this date
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of role menus based on given range, role, menu and as of date
   */
  public List<MasterRoleMenu> getByRangeRoleMenuAndDate(int roleId, int menuId, String asOfDate, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rm " +
              "where rm.role.roleId = " +
                    "(case when :roleId = 0 then rm.role.roleId else :roleId end) " +
                "and rm.menu.menuId = " +
                    "(case when :menuId = 0 then rm.menu.menuId else :menuId end) " +
                "and rm.menu.endDate >= to_date(:asOfDate,'yyyy-mm-dd') " +
                "and rm.role.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("roleId", roleId)
            .setInteger("menuId", menuId)
            .setString("asOfDate", asOfDate)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of role menu data by role, menu and as of date
   * @param roleId
   * @param menuId
   * @param asOfDate, end date more than or equal to this date
   * @return count of role menus based on role, menu and as of date
   */
  public int countByRoleMenuAndDate(int roleId, int menuId, String asOfDate) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " rm " +
              "where rm.role.roleId = " +
                    "(case when :roleId = 0 then rm.role.roleId else :roleId end) " +
                "and rm.menu.menuId = " +
                    "(case when :menuId = 0 then rm.menu.menuId else :menuId end) " +
                "and rm.menu.endDate >= to_date(:asOfDate,'yyyy-mm-dd') " +
                "and rm.role.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("roleId", roleId)
            .setInteger("menuId", menuId)
            .setString("asOfDate", asOfDate)
            .iterate().next()).intValue();
  }
  
  /**
   * Get number of role menu data by role
   * @param roleId
   * @return count of role menus based on role
   */
  public int countByRole(int roleId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " rm " +
                "where rm.role.roleId = :roleId")
            .setInteger("roleId", roleId)
            .iterate().next()).intValue();
  }
  
  /**
   * Get number of role menu data by menu
   * @param menuId
   * @return count of role menus based on menu
   */
  public int countByMenu(int menuId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " rm " +
                "where rm.menu.menuId = :menuId")
            .setInteger("menuId", menuId)
            .iterate().next()).intValue();
  }
}
