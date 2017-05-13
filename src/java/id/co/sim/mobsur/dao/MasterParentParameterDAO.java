/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterParentParameter;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_PARENT_PARAMETER
 * extends BaseDAO class
 * @see BaseDAO
 * @author awal
 * @created Mar 14, 2017
 */
@Repository("masterParentParameter")
public class MasterParentParameterDAO extends BaseDAO<MasterParentParameter> {

  /**
   * Get all parent parameter data
   * Override default behavior
   * @return list of all parent parameters
   */
  @Override
  public List<MasterParentParameter> getAll() {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mpp " +
              "order by mpp.parentParDesc")
            .list();
  }
}
