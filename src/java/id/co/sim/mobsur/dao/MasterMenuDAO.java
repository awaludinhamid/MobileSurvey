/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterMenu;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_MENU
 * extends BaseDAO class
 * @see BaseDAO
 * @created Oct 14, 2016
 * @author awal
 */
@Repository("masterMenuDAO")
public class MasterMenuDAO extends BaseDAO<MasterMenu> {

  /**
   * Get menu data by range, parent menu, menu, and as of date
   * @param parentMenuId
   * @param menuId
   * @param asOfDate, end date more than or equal to this date
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of menus based on given range, parent menu, menu, and as of date
   */
  public List<MasterMenu> getByRangeParentMenuAndDate(int parentMenuId, int menuId, String asOfDate, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mnu " +
              "where mnu.parentMenu.parentMenuId = " +
                    "(case when :parentMenuId = 0 then mnu.parentMenu.parentMenuId else :parentMenuId end)" +
                "and mnu.menuId = " +
                    "(case when :menuId = 0 then mnu.menuId else :menuId end)" +
                "and mnu.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("parentMenuId", parentMenuId)
            .setInteger("menuId", menuId)
            .setString("asOfDate", asOfDate)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get number of menu data by parent menu, menu and as of date
   * @param parentMenuId
   * @param menuId
   * @param asOfDate, end date more than or equal to this date
   * @return count of menus based on given parent menu, menu and as of date
   */
  public int countByParentMenuAndDate(int parentMenuId, int menuId, String asOfDate) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mnu " +
              "where mnu.parentMenu.parentMenuId = " +
                    "(case when :parentMenuId = 0 then mnu.parentMenu.parentMenuId else :parentMenuId end)" +
                "and mnu.menuId = " +
                    "(case when :menuId = 0 then mnu.menuId else :menuId end)" +
                "and mnu.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("parentMenuId", parentMenuId)
            .setInteger("menuId", menuId)
            .setString("asOfDate", asOfDate)
            .iterate().next()).intValue();
  }
  
  /**
   * Get menu data by user
   * @param userId
   * @return list of menus based on given user
   */
  public List<MasterMenu> getListMenuByUserId(int userId) {
    return sessionFactory.getCurrentSession().createQuery(
            "select mnu from " + domainClass.getName() + " mnu " +
              "join mnu.roleMenus rm " +
              "join rm.role.userRoles ur " +
              "where ur.user.userId = :userId  " +
                "and mnu.startDate <= current_date " +
                "and mnu.endDate >= current_date " +
                "and rm.role.startDate <= current_date " +
                "and rm.role.endDate >= current_date " +
                "and ur.user.startDate <= current_date " +
                "and ur.user.endDate >= current_date " +
              "order by mnu.parentMenu.parentMenuId, mnu.sort")
            .setInteger("userId", userId)
            .list();
  }
  
  /**
   * Get menu data by role
   * @param roleId
   * @return list of menus based on given role
   */
  public List<MasterMenu> getByRole(int roleId) {
    return sessionFactory.getCurrentSession().createQuery(
            "select mnu from " + domainClass.getName() + " mnu " +
              "join mnu.roleMenus rm " +
              "where rm.role.roleId = :roleId " +
                "and rm.role.startDate <= current_date " +
                "and rm.role.endDate >= current_date " +
                "and mnu.startDate <= current_date " +
                "and mnu.endDate >= current_date")
            .setInteger("roleId", roleId)
            .list();
  }
  
  /**
   * Get all menu data
   * Override default behavior
   * @return list of all menus
   */
  @Override
  public List<MasterMenu> getAll() {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mnu " +
              "where mnu.startDate <= current_date " +
                "and mnu.endDate >= current_date " +
              "order by mnu.menuName")
            .list();
  }
  
  /**
   * Get menu data by range
   * Override default behavior
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of menus based on given range
   */
  @Override
  public List<MasterMenu> getByRange(int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mnu " +
                "where mnu.startDate <= current_date " +
                "and mnu.endDate >= current_date")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of all menu data
   * Override default behavior
   * @return count of all menus
   */
  @Override
  public int count() {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mnu " +
                "where mnu.startDate <= current_date " +
                "and mnu.endDate >= current_date")
            .iterate().next()).intValue();
  }
}
