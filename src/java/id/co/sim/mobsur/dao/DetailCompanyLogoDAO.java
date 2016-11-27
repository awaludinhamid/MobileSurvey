/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.DetailCompanyLogo;
import id.co.sim.mobsur.util.BaseDAO;
import org.springframework.stereotype.Repository;

/**
 * @created Oct 19, 2016
 * @author awal
 */
@Repository("detailCompanyLogoDAO")
public class DetailCompanyLogoDAO extends BaseDAO<DetailCompanyLogo> {

  public DetailCompanyLogo getByCoyId(int coyId) {
    return (DetailCompanyLogo) sessionFactory.getCurrentSession().createQuery(
              "from " + domainClass.getName() + " as logo " +
              "join fetch logo.company as coy " +
              "where coy.coyId = :coyId")
            .setInteger("coyId", coyId)
            .uniqueResult();
  }
}
