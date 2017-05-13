/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.DetailTemplate;
import id.co.sim.mobsur.util.BaseDAO;
import org.springframework.stereotype.Repository;

/**
 * DAO table DETAIL_TEMPLATE
 * extends BaseDAO class
 * @see BaseDAO
 * @author awal
 * @created Mar 22, 2017
 */
@Repository("detailTemplateDAO")
public class DetailTemplateDAO extends BaseDAO<DetailTemplate> {

  /**
   * Get number of detail template by question group
   * @param questGroupId, group
   * @return count of detail template based on given question group
   */
  public int countByQuestGroup(int questGroupId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " dtmp " +
              "where dtmp.questionGroup.questGroupId = :questGroupId")
            .setInteger("questGroupId", questGroupId)
            .iterate().next()).intValue();
  }
}
