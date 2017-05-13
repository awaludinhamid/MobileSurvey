/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterAnswerType;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_ANSWER_TYPE
 * extends BaseDAO class
 * @see BaseDAO
 * @created Jan 5, 2017
 * @author awal
 */
@Repository("masterAnswerTypeDAO")
public class MasterAnswerTypeDAO extends BaseDAO<MasterAnswerType> {

  /**
   * Get all answer type data
   * Override default behavior
   * @return list of all answer types
   */
  @Override
  public List<MasterAnswerType> getAll() {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mat " +
             "order by mat.answerTypeName")
            .list();
  }
}
