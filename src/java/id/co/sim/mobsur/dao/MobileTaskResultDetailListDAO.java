/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MobileTaskResultDetailList;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MOBILE_TASK_RESULT_DETAIL_LIST
 * extends BaseDAO class
 * @see BaseDAO
 * @author awal
 * @created Feb 19, 2017
 */
@Repository("mobileTaskResultDetailListDAO")
public class MobileTaskResultDetailListDAO extends BaseDAO<MobileTaskResultDetailList> {

  /**
   * Get result detail list data by task
   * @param taskId
   * @return list of result detail lists based on given task
   */
  public List<MobileTaskResultDetailList> getByTask(int taskId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " +domainClass.getName() + " mtrdl " +
              "where mtrdl.taskResultDetail.taskResult.task.taskId = :taskId")
            .setInteger("taskId", taskId)
            .list();
  }

  /**
   * Get result detail list data which has image by result
   * @param taskResultId
   * @return list of result detail lists based on given result
   */
  public List<MobileTaskResultDetailList> getByTaskResultHasImage(int taskResultId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " +domainClass.getName() + " mtrdl " +
              "where mtrdl.taskResultDetail.taskResult.taskResultId = :taskResultId " +
                "and mtrdl.taskResultImage is not null")
            .setInteger("taskResultId", taskResultId)
            .list();
  }
}
