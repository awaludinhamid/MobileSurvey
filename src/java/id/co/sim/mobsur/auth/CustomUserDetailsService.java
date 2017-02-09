/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.auth;

import id.co.sim.mobsur.bean.MasterRole;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import id.co.sim.mobsur.bean.MasterUser;
import id.co.sim.mobsur.service.MasterRoleService;
import id.co.sim.mobsur.service.MasterUserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Jun 22, 2015
 * @author awal
 */

/**
 * A custom service for retrieving users from a custom datasource, such as a database.
 * <p>
* This custom service must implement Spring's {@link UserDetailsService}
 */
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {
  
  @Autowired
  private HttpServletRequest request;
  @Autowired
  private MasterRoleService mrServ;
  @Autowired
  private MasterUserService muServ;

  protected static Logger logger = Logger.getLogger("service");

  /**
  * Retrieves a user record containing the user's credentials and access.
  * @param username
  * @return 
  */
  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException, DataAccessException {

    // Declare a null Spring User
    UserDetails userDetails = null;

    try {
      // Search database for a user that matches the specified username
      // You can provide a custom DAO to access your persistence layer
      // Or use JDBC to access your database
      // DbUser is our custom domain user. This is not the same as Spring's User
      MasterUser user = searchDatabase(username);

      // Populate the Spring User object with details from the dbUser
      // Here we just pass the username, password, and access level
      // getAuthorities() will translate the access level to the correct role type

      userDetails =  new User(
        user.getUserCode(),
        user.getUserPassword(),
        true,
        true,
        true,
        true,
        getAuthorities(user.getUserId()));
    } catch (Exception e) {
      logger.error("Error in retrieving user");
      logger.error(e);
      throw new UsernameNotFoundException("Error in retrieving user");
    }

    // Return user to Spring for processing.
    // Take note we're not the one evaluating whether this user is authenticated or valid
    // We just merely retrieve a user that matches the specified username
    return userDetails;
  }

  /**
  * Retrieves the correct ROLE type depending on the access level, where access level is an Integer.
  * Basically, this interprets the access value whether it's for a regular user or admin.
  *
  * @param access an integer value representing the access of the user
  * @return collection of granted authorities
  */
  private Collection<GrantedAuthority> getAuthorities(int userId) {
    // Create a list of grants for this user
    List<GrantedAuthority> authList = new ArrayList<>();
    
    // Set user roles 
    for(MasterRole role : mrServ.getRolesByUser(userId)) {
      authList.add(new SimpleGrantedAuthority(role.getRoleCode()));
    }
    
    // Return list of granted authorities
    return authList;
  }

  /*
  * Retrieval of user from a database.
  * @param username
  * @return MasterUser
  */
  private MasterUser searchDatabase(String username) {

    // Retrieve user from the database
    //List<Users> users = internalDatabase();
    MasterUser user = muServ.getByCodeAndCoy(username,request.getParameter("coyCode"));
    if(user == null) {
      logger.error("User does not exist!");
      throw new RuntimeException("User does not exist!");
    } else {
      return user;
    }
  }
}