/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MobileTaskAssignment;
import id.co.sim.mobsur.util.BaseDAO;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @created Feb 2, 2017
 * @author awal
 */
@Repository("mobileTaskAssignmentDAO")
public class MobileTaskAssignmentDAO extends BaseDAO<MobileTaskAssignment> {
  
  public List<MobileTaskAssignment> getByRangeUser(int userId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mta " +
              "where mta.user.userId = :userId")
            .setInteger("userId", userId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  } 
  
  public List<MobileTaskAssignment> getByRangeParentUser(int parentUserId, int start, int num) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select mta.* from mobile_task_assignment mta, " +
              "master_user_role usrrol, " +
              "master_role rol, " +
              "master_role_type roltyp, " +
              "get_user_child(:parentUserId) child " +
              "where roltyp.role_type_code = 'C' " +
                "and mta.user_id = usrrol.user_id " +
                "and usrrol.role_id = rol.role_id " +
                "and rol.role_type_id = roltyp.role_type_id " +
                "and mta.user_id = child.user_id " +
            "union all " +
            "select mta.* from mobile_task_assignment mta " +
              "where mta.user_id = :parentUserId")
            .addEntity(domainClass)
            .setInteger("parentUserId",parentUserId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByUser(int userId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mta " +
              "where mta.user.userId = :userId")
            .setInteger("userId", userId)
            .iterate().next()).intValue();
  } 
  
  public int countByParentUser(int parentUserId) {
    return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery(
            "select count(*) from ( " +
              "select 1 from mobile_task_assignment mta, " +
                "master_user_role usrrol, " +
                "master_role rol, " +
                "master_role_type roltyp, " +
                "get_user_child(:parentUserId) child " +
                "where roltyp.role_type_code = 'C' " +
                  "and mta.user_id = usrrol.user_id " +
                  "and usrrol.role_id = rol.role_id " +
                  "and rol.role_type_id = roltyp.role_type_id " +
                  "and mta.user_id = child.user_id " +
              "union all " +
              "select 1 from mobile_task_assignment mta " +
                "where mta.user_id = :parentUserId) mta")
            .setInteger("parentUserId",parentUserId)
            .list().get(0)).intValue();
  }
}
