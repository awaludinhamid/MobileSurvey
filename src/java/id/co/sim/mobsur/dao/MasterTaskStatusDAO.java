/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import org.springframework.stereotype.Repository;

import id.co.sim.mobsur.bean.MasterTaskStatus;
import id.co.sim.mobsur.util.BaseDAO;

/**
 * DAO table MASTER_TASK_STATUS
 * extends BaseDAO class
 * @see BaseDAO
 * @created Feb 8, 2017
 * @author awal
 */

@Repository("masterTaskStatusDAO")
public class MasterTaskStatusDAO extends BaseDAO<MasterTaskStatus> {

  /**
   * Get task status by code
   * @param taskStatusCode
   * @return task status based on the code
   */
  public MasterTaskStatus getByCode(String taskStatusCode) {
    return (MasterTaskStatus) sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mts " +
              "where mts.taskStatusCode = :taskStatusCode")
            .setString("taskStatusCode", taskStatusCode)
            .uniqueResult();
  }
}
