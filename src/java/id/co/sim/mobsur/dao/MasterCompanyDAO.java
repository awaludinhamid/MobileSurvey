/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterCompany;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @created Oct 12, 2016
 * @author awal
 */
@Repository("masterCompany")
public class MasterCompanyDAO extends BaseDAO<MasterCompany> {
  
  public List<MasterCompany> getByRangeCodeAndNamePattern(String coyCodePattern, String coyNamePattern, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " " +
              "where coyCode like :coyCodePattern " +
                "and coyName like :coyNamePattern")
            .setString("coyCodePattern", "%"+coyCodePattern+"%")
            .setString("coyNamePattern", "%"+coyNamePattern+"%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByCodeAndNamePattern(String coyCodePattern, String coyNamePattern) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " " +
              "where coyCode like :coyCodePattern " +
                "and coyName like :coyNamePattern")
            .setString("coyCodePattern", "%"+coyCodePattern+"%")
            .setString("coyNamePattern", "%"+coyNamePattern+"%")
            .iterate().next()).intValue();
  }

  public MasterCompany getValidCoyByUserId(int userId) {
    return (MasterCompany) sessionFactory.getCurrentSession().createQuery(
            "select coy from " + domainClass.getName() + " as coy " +
              "inner join coy.offices as ofc " +
              "inner join ofc.users as usr " +
              "where usr.userId = :userId " +
                "and coy.startDate <= current_date and coy.endDate >= current_date")
            .setInteger("userId", userId)
            .uniqueResult();
  }
  
}
