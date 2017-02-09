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
 * @created Jan 17, 2017
 * @author awal
 */
@Repository("masterJobAssignmentDAO")
public class MasterJobAssignmentDAO extends BaseDAO<MasterJobAssignment> {

  public List<MasterJobAssignment> getByUserCommissioned(int userCommissionedId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " jobass " +
              "where jobass.commissionedUser.userId = :userCommissionedId")
            .setInteger("userCommissionedId", userCommissionedId)
            .list();
  }
  
  public int deleteById(int jobAssignId) {
    return sessionFactory.getCurrentSession().createQuery(
            "delete from " + domainClass.getName() + " " +
              "where jobAssignId = :jobAssignId")
            .setInteger("jobAssignId", jobAssignId)
            .executeUpdate();
  }
}
