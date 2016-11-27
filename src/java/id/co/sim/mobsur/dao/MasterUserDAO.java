/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.MasterUser;
import id.co.sim.mobsur.util.BaseDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @created Apr 4, 2016
 * @author awal
 */
@Repository("masterUserDAO")
public class MasterUserDAO extends BaseDAO<MasterUser>{  

  /**
   * Retrieve record from database by String name
   * @param userName
   * @return class bean
   */
  public MasterUser getByCode(String userName) {
    return (MasterUser) sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() +
              " where userCode = :userCode")
            .setString("userCode", userName)
            .uniqueResult();
  } 

  public String getPassByUser(String userCode) {
      return (String) sessionFactory.getCurrentSession().createQuery(
              "select userPassword from " + domainClass.getName() +
                " where userCode = :userCode")
              .setString("userCode", userCode)
              .uniqueResult();
  }
  
  public List<MasterUser> getByRangeCompany(int coyId, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " usr " +
              "where usr.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public List<MasterUser> getByRangeCompanyUserNameAndDate(int coyId, String userCode, String userName, String asOfDate, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " usr " +
              "where usr.office.company.coyId = :coyId " +
                "and usr.userCode = " +
                    "(case when :userCode = '' then usr.userCode else :userCode end)" +
                "and userName = " +
                    "(case when :userName = '' then usr.userName else :userName end)" +
                "and usr.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("coyId", coyId)
            .setString("userCode", userCode)
            .setString("userName", userName)
            .setString("asOfDate", asOfDate)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int count(int coyId) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " usr " +
              "where usr.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .iterate().next()).intValue();
  }
  
  public int countByCompanyUserNameAndDate(int coyId, String userCode, String userName, String asOfDate) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " usr " +
              "where usr.office.company.coyId = :coyId " +
                "and usr.userCode = " +
                    "(case when :userCode = '' then usr.userCode else :userCode end)" +
                "and userName = " +
                    "(case when :userName = '' then usr.userName else :userName end)" +
                "and usr.endDate >= to_date(:asOfDate,'yyyy-mm-dd')")
            .setInteger("coyId", coyId)
            .setString("userCode", userCode)
            .setString("userName", userName)
            .setString("asOfDate", asOfDate)
            .iterate().next()).intValue();
  }
  
  public List<MasterUser> getByCompany(int coyId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " usr " +
              "where usr.office.company.coyId = :coyId")
            .setInteger("coyId", coyId)
            .list();
  }
  
  public List<MasterUser> getByOffice(int officeId) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " usr " +
              "where usr.office.officeId = :officeId")
            .setInteger("officeId", officeId)
            .list();
  }
  
}
