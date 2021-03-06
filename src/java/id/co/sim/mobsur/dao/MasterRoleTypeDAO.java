/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterRoleType;
import id.co.sim.mobsur.util.BaseDAO;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_ROLE_TYPE
 * extends BaseDAO class
 * @see BaseDAO
 * @created Feb 3, 2017
 * @author awal
 */
@Repository("masterRoleTypeDAO")
public class MasterRoleTypeDAO extends BaseDAO<MasterRoleType> {

  /**
   * Get role type data by code
   * @param roleTypeCode
   * @return role type based on the code
   */
  public MasterRoleType getByCode(String roleTypeCode) {
    return (MasterRoleType) sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " roltyp " +
              "where roltyp.roleTypeCode = :roleTypeCode")
            .setString("roleTypeCode", roleTypeCode)
            .uniqueResult();
  }
}
