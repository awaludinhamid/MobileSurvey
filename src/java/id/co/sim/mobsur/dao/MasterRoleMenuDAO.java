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
 * @created Oct 16, 2016
 * @author awal
 */
@Service("masterRoleMenuDAO")
public class MasterRoleMenuDAO extends BaseDAO<MasterRoleMenu> {

  public List<MasterRoleMenu> getByRoleId(int roleId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rm " +
              "where rm.role.roleId = :roleId")
            .setInteger("roleId",roleId)
            .list();
  }
  
  public List<MasterRoleMenu> getByRangeRoleMenuAndDate(int roleId, int menuId, String asOfDate, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rm " +
              "where rm.role.roleId = " +
                    "(case when :roleId = 0 then rm.role.roleId else :roleId end) " +
                "and rm.menu.menuId = " +
                    "(case when :menuId = 0 then rm.menu.menuId else :menuId end) " +
                "and rm.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("roleId", roleId)
            .setInteger("menuId", menuId)
            .setString("asOfDate", asOfDate)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByRoleMenuAndDate(int roleId, int menuId, String asOfDate) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " rm " +
              "where rm.role.roleId = " +
                    "(case when :roleId = 0 then rm.role.roleId else :roleId end) " +
                "and rm.menu.menuId = " +
                    "(case when :menuId = 0 then rm.menu.menuId else :menuId end) " +
                "and rm.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("roleId", roleId)
            .setInteger("menuId", menuId)
            .setString("asOfDate", asOfDate)
            .iterate().next()).intValue();
  }
}
