/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.util;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Session template when accessing database via java bean
 * @param <T>
 * @created Mar 31, 2013
 * @author awal
 */
public class SessionUtil<T> {

  private final Logger logger = Logger.getLogger("others");
  
  //spring context
  private static final ApplicationContext appContext =
    new ClassPathXmlApplicationContext("applicationContext.xml");

  /**
   * Get connection for current java bean
   * @param beanName
   * @return service class
   */
  public T getAppContext(String beanName) {
    logger.info(beanName + " get application context");
    T t = (T) appContext.getBean(beanName);
    return t;
  }

}
