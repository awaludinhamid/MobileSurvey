/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterUserRole;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @created Apr 14, 2016
 * @author awal
 */
@Repository("masterUserRoleDAO")
public class MasterUserRoleDAO extends BaseDAO<MasterUserRole> {
  
  public List<MasterUserRole> getRangeByCoy(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mur " +
              "where mur.user.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public List<MasterUserRole> getRangeByCoyOfficeRoleUserNameDate(
          int coyId, int officeId, int roleId, String userNamePattern, String asOfDate, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mur " +
              "where mur.user.office.company.coyId = :coyId " +
                "and mur.user.office.officeId = " +
                    "(case when :officeId = 0 then mur.user.office.officeId else :officeId end) " +
                "and mur.role.roleId = " +
                    "(case when :roleId = 0 then mur.role.roleId else :roleId end) " +
                "and UPPER(mur.user.userName) like UPPER(:userNamePattern) " +
                "and mur.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("coyId", coyId)
            .setInteger("officeId", officeId)
            .setInteger("roleId", roleId)
            .setString("userNamePattern", "%"+userNamePattern+"%")
            .setString("asOfDate",asOfDate)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByCoy(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mur " +
              "where mur.user.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }
  
  public int countByCoyOfficeRoleUserNameDate(int coyId, int officeId, int roleId, String userNamePattern, String asOfDate) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mur " +
              "where mur.user.office.company.coyId = :coyId " +
                "and mur.user.office.officeId = " +
                    "(case when :officeId = 0 then mur.user.office.officeId else :officeId end) " +
                "and mur.role.roleId = " +
                    "(case when :roleId = 0 then mur.role.roleId else :roleId end) " +
                "and UPPER(mur.user.userName) like UPPER(:userNamePattern) " +
                "and mur.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("coyId", coyId)
            .setInteger("officeId", officeId)
            .setInteger("roleId", roleId)
            .setString("userNamePattern", "%"+userNamePattern+"%")
            .setString("asOfDate",asOfDate)
            .iterate().next()).intValue();
  }
}
