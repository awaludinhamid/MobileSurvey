/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * DAO template used as parent class
 * Containing basic DAO statement
 * Sub-class extend this class to gather its field/method
 * @created Aug 26, 2014
 * @author awal
 * @param <T>
 */
public class BaseDAO<T> {
  protected Class domainClass;
  @Autowired
  protected SessionFactory sessionFactory;
  
  private final Logger logger = Logger.getLogger("dao");

  /**
   * Using java reflection to get current bean class which used this class
   */
  public BaseDAO() {
    this.domainClass = (Class) ((ParameterizedType) getClass()
            .getGenericSuperclass())
            .getActualTypeArguments()[0];
  }

  /**
   * Save current record into database
   * @param domain
   * @return class bean
   */
  public T save(T domain) {
    sessionFactory.getCurrentSession().saveOrUpdate(domain);
    return domain;
  }
  
  /**
   * Save bulk record into database
   * @param domain
   * @param bulkRecord, number of record per batch
   */  
  public void save(List<T> domain, int bulkRecord) {
    try {
      Session session = sessionFactory.openSession();
      Transaction tx = session.beginTransaction();
      int idxTx = 0;
      for(T t : domain) {
        session.saveOrUpdate(t);
        if(++idxTx % bulkRecord == 0) {
          session.flush();
          session.clear();
        }
      }
      tx.commit();
      session.close();
    } catch(GenericJDBCException gje) {
      logger.error(gje);
    }
  }

  /**
   * Delete current record from database
   * @param domain
   //* @return class bean
   */
  public void delete(T domain) {
    sessionFactory.getCurrentSession().delete(domain);
    //return domain;
  }

  /**
   * Retrieve record from database by integer id
   * @param id
   * @return class bean
   */
  public T getById(int id) {
    return (T) sessionFactory.getCurrentSession().get(domainClass, id);
  }

  /**
   * Retrieve record from database by String id
   * @param id
   * @return class bean
   */
  public T getById(String id) {
    return (T) sessionFactory.getCurrentSession().get(domainClass, id);
  }

  /**
   * Retrieve all of records
   * @return List of class bean
   */
  public List<T> getAll() {
    return sessionFactory.getCurrentSession().createQuery("from " + domainClass.getName()).list();
  }

  /**
   * Retrieve all of records by paging
   * @param start
   * @param num
   * @return List of class bean
   */
  public List<T> getByRange(int start, int num) {
    return sessionFactory.getCurrentSession().createQuery("from " + domainClass.getName())
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }

  /**
   * Get number of records
   * @return records count
   */
  public int count() {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " x")
            .iterate().next()).intValue();
  }
}
