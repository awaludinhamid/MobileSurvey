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
 * @created Oct 14, 2016
 * @author awal
 */
@Repository("masterMenuDAO")
public class MasterMenuDAO extends BaseDAO<MasterMenu> {

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
  
  public List<MasterMenu> getListMenuByUserId(int userId) {
    return sessionFactory.getCurrentSession().createQuery(
            "select mnu from " + domainClass.getName() + " mnu " +
              "join mnu.roleMenus rm " +
              "join rm.role.userRoles ur " +
              "where ur.user.userId = :userId " +
              "order by mnu.parentMenu.parentMenuId, mnu.sort")
            .setInteger("userId", userId)
            .list();
  }
  
  public List<MasterMenu> getByRole(int roleId) {
    return sessionFactory.getCurrentSession().createQuery(
            "select mnu from " + domainClass.getName() + " mnu " +
              "join mnu.roleMenus rm " +
              "where rm.role.roleId = :roleId")
            .setInteger("roleId", roleId)
            .list();
  }
}
