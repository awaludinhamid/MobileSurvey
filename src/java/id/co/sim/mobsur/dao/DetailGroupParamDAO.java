/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.DetailGroupParam;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table DETAIL_GROUP_PARAM
 * extends BaseDAO class
 * @see BaseDAO
 * @created Jan 9, 2017
 * @author awal
 */
@Repository("detailGroupParamDAO")
public class DetailGroupParamDAO extends BaseDAO<DetailGroupParam> {

  /**
   * Get detail group parameter by the group
   * @param groupParamId, group
   * @return list of detail group based on given group parameter
   */
  public List<DetailGroupParam> getByGroupParamId(int groupParamId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " det " +
              "where det.groupParam.groupParamId = :groupParamId")
            .setInteger("groupParamId", groupParamId)
            .list();
  }
}
