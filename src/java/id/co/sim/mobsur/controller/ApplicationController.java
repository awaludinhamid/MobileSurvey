/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Application controller
 * Handles and retrieves various page depending on the URI template.
 * A user must be log-in first he can access these pages.
 * Specific page can be accessed by specific user, however.
 * @created Jun 19, 2015
 * @author awal
 */
@Controller
@RequestMapping("/application")
public class ApplicationController {

  private final Logger logger = Logger.getLogger("controller");


  /**
    * Handles and retrieves the company JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/company", method = RequestMethod.GET)
  public String getCompanyPage() {
    logger.debug("Received request to show company page");
    // This will resolve to /jsp/application/companypage.jsp
    return "application/companypage";
  }

  /**
    * Handles and retrieves the menu JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/menu", method = RequestMethod.GET)
  public String getMenuPage() {
    logger.debug("Received request to show menu page");
    // This will resolve to /jsp/application/menupage.jsp
    return "application/menupage";
  }

  /**
    * Handles and retrieves the role JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/role", method = RequestMethod.GET)
  public String getRolePage() {
    logger.debug("Received request to show role page");
    // This will resolve to /jsp/application/rolepage.jsp
    return "application/rolepage";
  }

  /**
    * Handles and retrieves the office JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/office", method = RequestMethod.GET)
  public String getOfficePage() {
    logger.debug("Received request to show office page");
    // This will resolve to /jsp/application/officepage.jsp
    return "application/officepage";
  }

  /**
    * Handles and retrieves the user JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public String getUserPage() {
    logger.debug("Received request to show user page");
    // This will resolve to /jsp/application/userpage.jsp
    return "application/userpage";
  }

  /**
    * Handles and retrieves the user role JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/userrole", method = RequestMethod.GET)
  public String getUserRolePage() {
    logger.debug("Received request to show user role page");
    // This will resolve to /jsp/application/userrolepage.jsp
    return "application/userrolepage";
  }

  /**
    * Handles and retrieves the role menu JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/rolemenu", method = RequestMethod.GET)
  public String getRoleMenuPage() {
    logger.debug("Received request to show role menu page");
    // This will resolve to /jsp/application/rolemenupage.jsp
    return "application/rolemenupage";
  }

  /**
    * Handles and retrieves the zipcode JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/zipcode", method = RequestMethod.GET)
  public String getZipcodePage() {
    logger.debug("Received request to show zipcode page");
    // This will resolve to /jsp/application/zipcodepage.jsp
    return "application/zipcodepage";
  }

  /**
    * Handles and retrieves the summary JSP page
    *
    * @param httpRequest
    * @param principal
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/summary", method = RequestMethod.GET)
  public String getSummaryPage(HttpServletRequest httpRequest, Principal principal) {
    logger.debug("Received request to show summary page");
    // This will resolve to /jsp/application/summarypage.jsp
    return "application/summarypage";
  }
    
}
