/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterJobAssignment;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_JOB_ASSIGNMENT
 * extends BaseDAO class
 * @see BaseDAO
 * @created Jan 17, 2017
 * @author awal
 */
@Repository("masterJobAssignmentDAO")
public class MasterJobAssignmentDAO extends BaseDAO<MasterJobAssignment> {

  /**
   * Get job assign data by commission
   * @param userCommissionedId
   * @return list of job assigns based on given commission
   */
  public List<MasterJobAssignment> getByUserCommissioned(int userCommissionedId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " jobass " +
              "where jobass.commissionedUser.userId = :userCommissionedId")
            .setInteger("userCommissionedId", userCommissionedId)
            .list();
  }
  
  /**
   * Delete job assign by id
   * @param jobAssignId
   * @return deleted status (0=exit normal, otherwise force exit)
   */
  public int deleteById(int jobAssignId) {
    return sessionFactory.getCurrentSession().createQuery(
            "delete from " + domainClass.getName() + " jobass " +
              "where jobass.jobAssignId = :jobAssignId")
            .setInteger("jobAssignId", jobAssignId)
            .executeUpdate();
  }
}
