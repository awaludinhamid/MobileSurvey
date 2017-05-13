/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterOptionAnswer;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DAO table MASTER_OPTION_ANSWER
 * extends BaseDAO class
 * @see BaseDAO
 * @created Jan 5, 2017
 * @author awal
 */
@Repository("masterOptionAnswerDAO")
public class MasterOptionAnswerDAO extends BaseDAO<MasterOptionAnswer> {

  /**
   * Get all option answer data
   * Override default behavior
   * @return list of all option answers
   */
  @Override
  public List<MasterOptionAnswer> getAll() {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " moa " +
             "order by (case when moa.optionAnswerName = 'NONE' then 0 else 1 end), moa.optionAnswerName")
            .list();
  }

}
