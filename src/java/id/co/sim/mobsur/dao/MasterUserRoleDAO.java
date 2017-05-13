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
 * DAO table MASTER_USER_ROLE
 * extends BaseDAO class
 * @see BaseDAO
 * @created Apr 14, 2016
 * @author awal
 */
@Repository("masterUserRoleDAO")
public class MasterUserRoleDAO extends BaseDAO<MasterUserRole> {
  
  /**
   * Get user role data by range and company
   * @param coyId, company
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of user roles based on given range and company
   */
  public List<MasterUserRole> getRangeByCoy(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mur " +
              "where mur.user.office.company.coyId = :coyId ")/* +
                "and mur.startDate <= current_date " +
                "and mur.endDate >= current_date")*/
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get user role data by range, company, office, role, username pattern/partial and as of date
   * @param coyId, company
   * @param officeId
   * @param roleId
   * @param userNamePattern
   * @param asOfDate, end date more than or equal to this date
   * @param start, first record row position
   * @param num, number of record to return
   * @return list of user roles based on given range, company, office, role, username pattern and as of date
   */
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
                "and mur.user.endDate >= to_date(:asOfDate,'yyyy-mm-dd') " +
                "and mur.role.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("coyId", coyId)
            .setInteger("officeId", officeId)
            .setInteger("roleId", roleId)
            .setString("userNamePattern", "%"+userNamePattern+"%")
            .setString("asOfDate",asOfDate)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  /**
   * Get number of user role data by company
   * @param coyId, company
   * @return count of user roles based on given company
   */
  public int countByCoy(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mur " +
              "where mur.user.office.company.coyId = :coyId ")/* +
                "and mur.startDate <= current_date " +
                "and mur.endDate >= current_date")*/
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }
  
  /**
   * Get number of user role data by company, office, role, username pattern/partial and as of date
   * @param coyId, company
   * @param officeId
   * @param roleId
   * @param userNamePattern
   * @param asOfDate, end date more than or equal to this date
   * @return count of user roles based on given company, office, role, username pattern/partial and as of date
   */
  public int countByCoyOfficeRoleUserNameDate(int coyId, int officeId, int roleId, String userNamePattern, String asOfDate) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mur " +
              "where mur.user.office.company.coyId = :coyId " +
                "and mur.user.office.officeId = " +
                    "(case when :officeId = 0 then mur.user.office.officeId else :officeId end) " +
                "and mur.role.roleId = " +
                    "(case when :roleId = 0 then mur.role.roleId else :roleId end) " +
                "and UPPER(mur.user.userName) like UPPER(:userNamePattern) " +
                "and mur.user.endDate >= to_date(:asOfDate,'yyyy-mm-dd') " +
                "and mur.role.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("coyId", coyId)
            .setInteger("officeId", officeId)
            .setInteger("roleId", roleId)
            .setString("userNamePattern", "%"+userNamePattern+"%")
            .setString("asOfDate",asOfDate)
            .iterate().next()).intValue();
  }
  
  /**
   * Get user role data by office
   * @param officeId
   * @return list of user roles based on given office
   */
  public List<MasterUserRole> getByOffice(int officeId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mur " +
              "where mur.user.office.officeId = :officeId")
            .setInteger("officeId", officeId)
            .list();
  }
  
  /**
   * Get number of valid user role data by user
   * @param userId
   * @return count of valid user roles based on given user
   */
  public int countByUserValid(int userId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mur " +
              "where mur.user.userId = :userId " +
                "and mur.user.startDate <= current_date " +
                "and mur.user.endDate >= current_date " +
                "and mur.role.startDate <= current_date " +
                "and mur.role.endDate >= current_date")
            .setInteger("userId", userId)
            .iterate().next()).intValue();
  }
  
  /**
   * Get number of user role data by role
   * @param roleId
   * @return count of user roles based on given role
   */
  public int countByRole(int roleId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mur " +
              "where mur.role.roleId = :roleId")
            .setInteger("roleId", roleId)
            .iterate().next()).intValue();
  }
  
  /**
   * Get number of user role data by user
   * @param userId
   * @return count of user roles based on given user
   */
  public int countByUser(int userId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mur " +
              "where mur.user.userId = :userId")
            .setInteger("userId", userId)
            .iterate().next()).intValue();
  }
  
  /**
   * Get user role by user
   * @param userId
   * @return user role based on given user
   */
  public MasterUserRole getByUser(int userId) {
    return (MasterUserRole) sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mur " +
              "where mur.user.userId = :userId")
            .setInteger("userId", userId)
            .uniqueResult();
  }
}
