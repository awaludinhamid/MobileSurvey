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
    * Handles and retrieves parameter JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/parameter", method = RequestMethod.GET)
  public String getParameterPage() {
    logger.debug("Received request to show parameter page");
    // This will resolve to /jsp/application/parameterpage.jsp
    return "application/parameterpage";
  }

  /**
    * Handles and retrieves hierarchy JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/hierarchy", method = RequestMethod.GET)
  public String getHierarchyPage() {
    logger.debug("Received request to show hierarchy page");
    // This will resolve to /jsp/application/hierarchypage.jsp
    return "application/hierarchypage";
  }

  /**
    * Handles and retrieves distribution JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/distribution", method = RequestMethod.GET)
  public String getDistributionPage() {
    logger.debug("Received request to show distribution page");
    // This will resolve to /jsp/application/distributionpage.jsp
    return "application/distributionpage";
  }

  /**
    * Handles and retrieves provinsi JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/provinsi", method = RequestMethod.GET)
  public String getProvinsiPage() {
    logger.debug("Received request to show provinsi page");
    // This will resolve to /jsp/application/provinsipage.jsp
    return "application/provinsipage";
  }

  /**
    * Handles and retrieves city JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/city", method = RequestMethod.GET)
  public String getCityPage() {
    logger.debug("Received request to show city page");
    // This will resolve to /jsp/application/citypage.jsp
    return "application/citypage";
  }

  /**
    * Handles and retrieves kecamatan JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/kecamatan", method = RequestMethod.GET)
  public String getKecamatanPage() {
    logger.debug("Received request to show kecamatan page");
    // This will resolve to /jsp/application/kecamatanpage.jsp
    return "application/kecamatanpage";
  }

  /**
    * Handles and retrieves kelurahan JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/kelurahan", method = RequestMethod.GET)
  public String getKelurahanPage() {
    logger.debug("Received request to show kelurahan page");
    // This will resolve to /jsp/application/kelurahanpage.jsp
    return "application/kelurahanpage";
  }

  /**
    * Handles and retrieves question JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/question", method = RequestMethod.GET)
  public String getQuestionPage() {
    logger.debug("Received request to show question page");
    // This will resolve to /jsp/application/questionpage.jsp
    return "application/questionpage";
  }

  /**
    * Handles and retrieves group question JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/questiongroup", method = RequestMethod.GET)
  public String getQuestionGroupPage() {
    logger.debug("Received request to show group question page");
    // This will resolve to /jsp/application/questiongrouppage.jsp
    return "application/questiongrouppage";
  }

  /**
    * Handles and retrieves template JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/template", method = RequestMethod.GET)
  public String getTemplatePage() {
    logger.debug("Received request to show template page");
    // This will resolve to /jsp/application/templatepage.jsp
    return "application/templatepage";
  }

  /**
    * Handles and retrieves product JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/product", method = RequestMethod.GET)
  public String getProductPage() {
    logger.debug("Received request to show product page");
    // This will resolve to /jsp/application/productpage.jsp
    return "application/productpage";
  }

  /**
    * Handles and retrieves job assignment JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/jobassignment", method = RequestMethod.GET)
  public String getJobAssignmentPage() {
    logger.debug("Received request to show job assignment page");
    // This will resolve to /jsp/application/jobassignmentpage.jsp
    return "application/jobassignmentpage";
  }

  /**
    * Handles and retrieves zipcode verificator JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/zipcodeverif", method = RequestMethod.GET)
  public String getZipcodeVerifPage() {
    logger.debug("Received request to show zipcode verificator page");
    // This will resolve to /jsp/application/zipcodeverifpage.jsp
    return "application/zipcodeverifpage";
  }

  /**
    * Handles and retrieves absence JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/absence", method = RequestMethod.GET)
  public String getAbsencePage() {
    logger.debug("Received request to show absence page");
    // This will resolve to /jsp/application/absencepage.jsp
    return "application/absencepage";
  }

  /**
    * Handles and retrieves mobile task assign JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/taskassign", method = RequestMethod.GET)
  public String getMobileTaskAssignPage() {
    logger.debug("Received request to show mobile task assign page");
    // This will resolve to /jsp/application/taskassignpage.jsp
    return "application/taskassignpage";
  }

  /**
    * Handles and retrieves mobile rolling task JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/rollingtask", method = RequestMethod.GET)
  public String getMobileRollingTaskPage() {
    logger.debug("Received request to show mobile rolling task page");
    // This will resolve to /jsp/application/rollingtaskpage.jsp
    return "application/rollingtaskpage";
  }

  /**
    * Handles and retrieves mobile inquiry task JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/inquirytask", method = RequestMethod.GET)
  public String getMobileInquiryTaskPage() {
    logger.debug("Received request to show mobile inquiry task page");
    // This will resolve to /jsp/application/inquirytaskpage.jsp
    return "application/inquirytaskpage";
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
