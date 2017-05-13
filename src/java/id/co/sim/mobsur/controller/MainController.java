/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Page controller
 * Handles and retrieves various page depending on the URI template.
 * A user must be log-in first he can access these pages.
 * Specific page can be accessed by specific user, however.
 * @created Jun 19, 2016
 * @author awal
 */
@Controller
@RequestMapping("/main")
public class MainController {

  private final Logger logger = Logger.getLogger("controller");


  /**
    * Handles and retrieves the validation JSP page
    *
    * @return the name of the validation JSP page
    */
  @RequestMapping(value = "/validation", method = RequestMethod.GET)
  public String getValidPage() {
    logger.debug("Received request to show app page");
    // This will resolve to /jsp/validationpage.jsp
    return "validationpage";
  }

  /**
    * Handles and retrieves the home JSP page
    *
    * @return the name of the home JSP page
    */
  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public String getHomePage() {
    logger.debug("Received request to show home page");
    // This will resolve to /jsp/homepage.jsp
    return "homepage";
  }

  /**
    * Handles and retrieves the help JSP page
    *
    * @return the name of the help JSP page
    */
  @RequestMapping(value = "/help", method = RequestMethod.GET)
  public String getHelpPage() {
    logger.debug("Received request to show help page");
    // This will resolve to /jsp/helppage.jsp
    return "helppage";
  }

  /**
    * Handles and retrieves the about JSP page
    *
    * @return the name of the about JSP page
    */
  @RequestMapping(value = "/about", method = RequestMethod.GET)
  public String getAboutPage() {
    logger.debug("Received request to show about page");
    // This will resolve to /jsp/aboutpage.jsp
    return "aboutpage";
  }

  /**
    * Handles and retrieves the contact us JSP page
    *
    * @return the name of the contact us JSP page
    */
  @RequestMapping(value = "/contactus", method = RequestMethod.GET)
  public String getContactUsPage() {
    logger.debug("Received request to show contact us page");
    // This will resolve to /jsp/contactuspage.jsp
    return "contactuspage";
  }

  /**
    * Handles and retrieves the profile JSP page
    *
    * @return the name of the profile JSP page
    */
  @RequestMapping(value = "/profile", method = RequestMethod.GET)
  public String getProfilePage() {
    logger.debug("Received request to show profile page");
    // This will resolve to /jsp/profilepage.jsp
    return "profilepage";
  }

  /**
    * Handles error JSP page that launched when error produced
    *
    * @return the name of the error JSP page
    */
  @RequestMapping(value = "/error", method = RequestMethod.GET)
  public String getErrorPage() {
    logger.debug("Received request to show error page");
    // This will resolve to /jsp/errorpage.jsp
    return "errorpage";
  }

  /**
    * Handles and retrieves the default application JSP page
    *
    * @return the name of the application JSP page
    */
  @RequestMapping(value = "/application", method = RequestMethod.GET)
  public String getApplicationPage() {
    logger.debug("Received request to show company page");
    // This will resolve to /jsp/support/application.jsp
    return "support/application";
  }
    
}
