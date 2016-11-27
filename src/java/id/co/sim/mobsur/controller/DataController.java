/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.controller;

import com.sun.jersey.core.util.Base64;
import id.co.sim.mobsur.bean.MasterMenu;
import id.co.sim.mobsur.bean.MasterOffice;
import id.co.sim.mobsur.bean.MasterParentMenu;
import id.co.sim.mobsur.bean.MasterRole;
import id.co.sim.mobsur.bean.MasterRoleMenu;
import id.co.sim.mobsur.bean.MasterUser;
import id.co.sim.mobsur.bean.support.UserMenuBean;
import id.co.sim.mobsur.service.DetailCompanyLogoService;
import id.co.sim.mobsur.service.MasterCompanyService;
import id.co.sim.mobsur.service.MasterMenuService;
import id.co.sim.mobsur.service.MasterOfficeService;
import id.co.sim.mobsur.service.MasterParentMenuService;
import id.co.sim.mobsur.service.MasterRoleMenuService;
import id.co.sim.mobsur.service.MasterUserRoleService;
import id.co.sim.mobsur.service.MasterRoleService;
import id.co.sim.mobsur.service.MasterUserService;
import id.co.sim.mobsur.service.MasterZipcodeService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Data controller, requested via AJAX
 * Handles and retrieves the data page depending on the URI template
 * A user must be log-in first he can access these pages
 * @created Jun 19, 2015
 * @author awal
 */
@Controller
@RequestMapping("/data")
public class DataController {

 private final Logger logger = Logger.getLogger("controller");
 private final String basicDate = "2016-01-01";
 
 @Autowired
 private MasterParentMenuService mpmServ;
 @Autowired
 private MasterCompanyService mcServ;
 @Autowired
 private MasterMenuService mmServ;
 @Autowired
 MasterRoleService mrServ;
 @Autowired
 MasterOfficeService moServ;
 @Autowired
 MasterUserService muServ;
 @Autowired
 DetailCompanyLogoService dclServ;
 @Autowired
 MasterUserRoleService murServ;
 @Autowired
 MasterRoleMenuService mrmServ;
 @Autowired
 MasterZipcodeService mzServ;

 /**
  * Generate all companies data
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/company/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getCompanies(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get companies data");
      //
      String coyCodePattern = httpRequest.getParameter("coyCodePattern") == null ? "" : httpRequest.getParameter("coyCodePattern");
      String coyNamePattern = httpRequest.getParameter("coyNamePattern") == null ? "" : httpRequest.getParameter("coyNamePattern");
      //
      Map<String,Object> mapCoy = new HashMap();
      if(coyCodePattern.equals("") && coyNamePattern.equals("")) {
        mapCoy.put("content", mcServ.getByPage(pageNo));
        mapCoy.put("count", mcServ.count());
      } else {
        mapCoy.put("content", mcServ.getByPageCodeAndNamePattern(coyCodePattern, coyNamePattern, pageNo));
        mapCoy.put("count", mcServ.countByCodeAndNamePattern(coyCodePattern, coyNamePattern));
      }
      return mapCoy;
 }

 /**
  * Generate all parent menus data
  *
  * @return json data
  */
    @RequestMapping(value = "/parentmenu", method = RequestMethod.GET)
    public @ResponseBody List<MasterParentMenu> getAllParentMenu() {
     logger.debug("Received request to get all parent menus data");
     //retrieve all parent menus
     return mpmServ.getAll();
 }

 /**
  * Generate all menus data
  *
  * @return json data
  */
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public @ResponseBody List<MasterMenu> getAllMenu() {
     logger.debug("Received request to get all menus data");
     //retrieve all menus
     return mmServ.getAll();
 }

 /**
  * Generate all menus data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/menu/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getMenus(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get menus data");
      //
      int parentMenuId = Integer.parseInt(httpRequest.getParameter("parentMenuId"));
      int menuId = Integer.parseInt(httpRequest.getParameter("menuId"));
      String asOfDate = httpRequest.getParameter("asOfDate");
      asOfDate = (asOfDate == null || asOfDate.equals("")) ? basicDate : asOfDate;
      //
      Map<String,Object> mapMenu = new HashMap();
      if(parentMenuId == 0 && menuId == 0 && asOfDate.equals(basicDate)) {
        mapMenu.put("content", mmServ.getByPage(pageNo));
        mapMenu.put("count", mmServ.count());
        logger.info("access: access1");
      } else {
        mapMenu.put("content", mmServ.getByPageParentMenuAndDate(parentMenuId, menuId, asOfDate, pageNo));
        mapMenu.put("count", mmServ.countByParentMenuAndDate(parentMenuId, menuId, asOfDate));
        logger.info("access: access2");
      }
      return mapMenu;
 }

 /**
  * Generate all roles data
  *
  * @return json data
  */
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public @ResponseBody List<MasterRole> getAllRoles() {
      logger.debug("Received request to get all roles data");
      //      
      return mrServ.getAll();
 }

 /**
  * Generate all roles data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/role/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getRoles(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get roles data");
      //
      Integer roleId = Integer.parseInt(httpRequest.getParameter("roleId"));
      String asOfDate = httpRequest.getParameter("asOfDate");
      asOfDate = (asOfDate == null || asOfDate.equals("")) ? basicDate : asOfDate;
      //
      Map<String,Object> mapRole = new HashMap();
      if(roleId == 0 && asOfDate.equals(basicDate)) {
        mapRole.put("content", mrServ.getByPage(pageNo));
        mapRole.put("count", mrServ.count());
      } else {
        mapRole.put("content", mrServ.getByPageRoleAndDate(roleId, asOfDate, pageNo));
        mapRole.put("count", mrServ.countByRoleAndDate(roleId, asOfDate));        
      }
      return mapRole;
 }

 /**
  * Generate all roles data by user
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/rolebyuser", method = RequestMethod.GET)
    public @ResponseBody List<MasterRole> getRolesByUser(HttpServletRequest httpRequest) {
      logger.debug("Received request to get roles data by user");
      //
      return mrServ.getRolesByUser(Integer.parseInt(httpRequest.getParameter("userId")));
 }

 /**
  * Generate offices by company data
  *
  * @param session
  * @return json data
  */
    @RequestMapping(value = "/office", method = RequestMethod.GET)
    public @ResponseBody List<MasterOffice> getOfficesByCompany(HttpSession session) {
      logger.debug("Received request to get offices data");
      //
      return moServ.getByCompany((Integer) session.getAttribute("coyId"));
 }

 /**
  * Generate offices by company data
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/office/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getOfficesByCompany(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get offices data");
      //
      String officeCodePattern = httpRequest.getParameter("officeCodePattern") == null ? "" : httpRequest.getParameter("officeCodePattern");
      String officeNamePattern = httpRequest.getParameter("officeNamePattern") == null ? "" : httpRequest.getParameter("officeNamePattern");
      String asOfDate = httpRequest.getParameter("asOfDate");
      asOfDate = (asOfDate == null || asOfDate.equals("")) ? basicDate : asOfDate;
      int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
      //
      Map<String,Object> mapUser = new HashMap();
      if(officeCodePattern.equals("") && officeNamePattern.equals("") && asOfDate.equals(basicDate)) {
        mapUser.put("content", moServ.getByPageCompany(coyId,pageNo));
        mapUser.put("count", moServ.count(coyId));
      } else {
        mapUser.put("content", moServ.getByPageCompanyOfficeCodeNameAndDate(coyId, officeCodePattern, officeNamePattern, asOfDate, pageNo));
        mapUser.put("count", moServ.countByCompanyOfficeCodeNameAndDate(coyId, officeCodePattern, officeNamePattern, asOfDate));        
      }
      return mapUser;
 }

 /**
  * Generate all users data by page
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getUsersByCompany(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all users data");
      //
      int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
      return muServ.getByCompany(coyId);
 }

 /**
  * Generate all users data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/user/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getUsersByCompany(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all users data");
      //
      String userCode = httpRequest.getParameter("userCode") == null ? "" : httpRequest.getParameter("userCode");
      String userName = httpRequest.getParameter("userName") == null ? "" : httpRequest.getParameter("userName");
      String asOfDate = httpRequest.getParameter("asOfDate");
      asOfDate = (asOfDate == null || asOfDate.equals("")) ? basicDate : asOfDate;
      int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
      //
      Map<String,Object> mapUser = new HashMap();
      if(userCode.equals("") && userName.equals("") && asOfDate.equals(basicDate)) {
        mapUser.put("content", muServ.getByPageCompany(coyId,pageNo));
        mapUser.put("count", muServ.count(coyId));
      } else {
        mapUser.put("content", muServ.getByPageCompanyUserNameAndDate(coyId,userCode, userName, asOfDate, pageNo));
        mapUser.put("count", muServ.countByCompanyUserNameAndDate(coyId,userCode, userName, asOfDate));        
      }
      return mapUser;
 }

 /**
  * Generate all users data by office
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/userbyoffice", method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getUsersByOffice(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all users data by office");
      //
      int officeId = Integer.parseInt(httpRequest.getParameter("officeId"));
      return muServ.getByOffice(officeId);
 }

 /**
  * Generate all user role data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/userrole/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getUserRoles(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all user role data");
      //
      int officeId = Integer.parseInt(httpRequest.getParameter("officeId"));
      int roleId = Integer.parseInt(httpRequest.getParameter("roleId"));
      String userNamePattern = httpRequest.getParameter("userNamePattern") == null ? "" : httpRequest.getParameter("userNamePattern");
      String asOfDate = httpRequest.getParameter("asOfDate");
      asOfDate = (asOfDate == null || asOfDate.equals("")) ? basicDate : asOfDate;
      int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
      //
      Map<String,Object> mapUserRole = new HashMap();
      if(officeId == 0 && roleId == 0 && userNamePattern.equals("") && asOfDate.equals(basicDate)) {
        mapUserRole.put("content", murServ.getPageByCoy(coyId, pageNo));
        mapUserRole.put("count", murServ.countByCoy(coyId));
      } else {
        mapUserRole.put("content", murServ.getPageByCoyOfficeRoleUserNameDate(coyId, officeId, roleId, userNamePattern, asOfDate, pageNo));
        mapUserRole.put("count", murServ.countByCoyOfficeRoleUserNameDate(coyId, officeId, roleId, userNamePattern, asOfDate));        
      }
      return mapUserRole;
 }

 /**
  * Generate all roles data for client
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/roleforclient", method = RequestMethod.GET)
    public @ResponseBody List<MasterRole> getRoleForClient(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all roles for client");
      //
      return mrServ.getForClientRole();
 }

 /**
  * Generate user menu data
  *
   * @param userId
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/usermenu/{userId}", method = RequestMethod.GET)
    public @ResponseBody List<UserMenuBean> getUserMenus(@PathVariable("userId") int userId, HttpServletRequest httpRequest) {
     logger.debug("Received request to get user menu data");
     //retrieve user menu
     List<MasterMenu> menus = mmServ.getListMenuByUserId(userId);
     List<UserMenuBean> userMenus = new ArrayList();
     for(MasterMenu mm : menus) {
       UserMenuBean umb = new UserMenuBean();
       umb.setParent(mm.getParentMenu().getParentMenuName());
       umb.setMenu(mm.getMenuName());
       umb.setMenuUrl(mm.getMenuPage());
       umb.setIconPath(mm.getIconPath());
       userMenus.add(umb);
     }
     return userMenus;
 }

 /**
  * Generate all role menu data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/rolemenu/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getRoleMenus(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all user role data");
      //
      int roleId = Integer.parseInt(httpRequest.getParameter("roleId"));
      int menuId = Integer.parseInt(httpRequest.getParameter("menuId"));
      String asOfDate = httpRequest.getParameter("asOfDate");
      asOfDate = (asOfDate == null || asOfDate.equals("")) ? basicDate : asOfDate;
      //
      Map<String,Object> mapRoleMenu = new HashMap();
      if(roleId == 0 && menuId == 0 && asOfDate.equals(basicDate)) {
        mapRoleMenu.put("content", mrmServ.getByPage(pageNo));
        mapRoleMenu.put("count", mrmServ.count());
      } else {
        mapRoleMenu.put("content", mrmServ.getByPageRoleMenuAndDate(roleId, menuId, asOfDate, pageNo));
        mapRoleMenu.put("count", mrmServ.countByRoleMenuAndDate(roleId, menuId, asOfDate));        
      }
      return mapRoleMenu;
 }

 /**
  * Generate role menu data by role
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/rolemenubyrole", method = RequestMethod.GET)
    public @ResponseBody List<MasterRoleMenu> getRoleMenuByRole(HttpServletRequest httpRequest) {
     logger.debug("Received request to get role menu data by role");
     //retrieve menu role
     return mrmServ.getByRoleId(Integer.parseInt(httpRequest.getParameter("roleId")));
 }

 /**
  * Generate all zipcode data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/zipcode/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getZipcode(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all zipcode data");
      //
      String zipcodeCodePattern = httpRequest.getParameter("zipcodeCodePattern") == null ? "" : httpRequest.getParameter("zipcodeCodePattern");
      String zipcodeDescPattern = httpRequest.getParameter("zipcodeDescPattern") == null ? "" : httpRequest.getParameter("zipcodeDescPattern");
      //
      Map<String,Object> mapZipcode = new HashMap();
      if(zipcodeCodePattern.equals("") && zipcodeDescPattern.equals("")) {
        mapZipcode.put("content", mzServ.getByPage(pageNo));
        mapZipcode.put("count", mzServ.count());
      } else {
        mapZipcode.put("content", mzServ.getByRangeZipcodeDesc(zipcodeCodePattern, zipcodeDescPattern, pageNo));
        mapZipcode.put("count", mzServ.countByZipcodeDesc(zipcodeCodePattern, zipcodeDescPattern));        
      }
      return mapZipcode;
 }

 /**
  * Generate option list data
  *
   * @param listName
  * @return json data
  */
    @RequestMapping(value = "/optionlist/{listname}", method = RequestMethod.GET)
    public @ResponseBody List<String> getOptionList(@PathVariable("listname") String listName) {
     logger.debug("Received request to get option list data");
     //
     return mzServ.getListInput(listName);
 }

 /**
  * Generate company logo data
  *
   * @param companyLogoId
  * @param httpRequest
   * @param httpResponse
  * @return json data
  */
    @RequestMapping(value = "/detailcompanylogo/{companyLogoId}", method = RequestMethod.GET)
    public @ResponseBody byte[] getCoyLogo(
            @PathVariable("companyLogoId") int companyLogoId,
            HttpServletRequest httpRequest,
            HttpServletResponse httpResponse) {
     logger.debug("Received request to get company logo");
     //no cache applicable
     setNoCache(httpResponse);
     // must be base64 object before sending to client
     return Base64.encode(dclServ.getById(companyLogoId).getLogoPicture());
 }
  
  @RequestMapping(value = "/currentsession", method = RequestMethod.GET)
  public @ResponseBody String getCurrentSession(HttpServletRequest httpRequest) {
    logger.debug("Received request to get current session");
    return httpRequest.getSession().getId();
  }
  
  private void setNoCache(HttpServletResponse httpResponse) {
    httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    httpResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    httpResponse.setDateHeader("Expires", 0); // Proxies    
  }

}
