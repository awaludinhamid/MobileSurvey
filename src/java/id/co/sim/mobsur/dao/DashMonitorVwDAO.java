/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.DashMonitorVw;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO view DASH_MONITOR_VW
 * extends BaseDAO class
 * @see BaseDAO
 * @author awal
 * @created Feb 22, 2017
 */
@Repository("dashMonitorVwDAO")
public class DashMonitorVwDAO extends BaseDAO<DashMonitorVw> {

  /**
   * Get dashboard monitor data by office
   * @param officeId
   * @return list of dashboard monitor data based on given office
   */
  public List<DashMonitorVw> getByOffice(int officeId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " dmv " +
              "where dmv.officeId = :officeId")
            .setInteger("officeId", officeId)
            .list();
  }
  
  /**
   * Get dashboard monitor data by superior
   * @param parentUserId, superior
   * @return list of dashboard monitor data based on given superior
   */
  public List<DashMonitorVw> getByParentUser(int parentUserId) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select dmv.* from dash_monitor_vw dmv, " +
              "get_user_child(:parentUserId) child " +
              "where dmv.user_id = child.user_id")
            .addEntity(domainClass)
            .setInteger("parentUserId", parentUserId)
            .list();
  }
}
