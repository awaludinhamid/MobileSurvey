/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.controller;

import id.co.sim.mobsur.bean.DetailQuestionGroup;
import id.co.sim.mobsur.bean.MasterAnswerType;
import id.co.sim.mobsur.bean.MasterCity;
import id.co.sim.mobsur.bean.MasterJobAssignment;
import id.co.sim.mobsur.bean.MasterKecamatan;
import id.co.sim.mobsur.bean.MasterKelurahan;
import id.co.sim.mobsur.bean.MasterMenu;
import id.co.sim.mobsur.bean.MasterOffice;
import id.co.sim.mobsur.bean.MasterOptionAnswer;
import id.co.sim.mobsur.bean.MasterParentMenu;
import id.co.sim.mobsur.bean.MasterProvinsi;
import id.co.sim.mobsur.bean.MasterQuestion;
import id.co.sim.mobsur.bean.MasterQuestionGroup;
import id.co.sim.mobsur.bean.MasterReasonType;
import id.co.sim.mobsur.bean.MasterRole;
import id.co.sim.mobsur.bean.MasterRoleMenu;
import id.co.sim.mobsur.bean.MasterRoleType;
import id.co.sim.mobsur.bean.MasterTaskStatus;
import id.co.sim.mobsur.bean.MasterTemplate;
import id.co.sim.mobsur.bean.MasterUser;
import id.co.sim.mobsur.bean.MasterZipcode;
import id.co.sim.mobsur.bean.MasterZipcodeVerificator;
import id.co.sim.mobsur.bean.support.ContentsBean;
import id.co.sim.mobsur.bean.support.StringBean;
import id.co.sim.mobsur.bean.support.UserMenuBean;
import id.co.sim.mobsur.service.DetailCompanyLogoService;
import id.co.sim.mobsur.service.DetailQuestionGroupService;
import id.co.sim.mobsur.service.GenericService;
import id.co.sim.mobsur.service.MasterAbsenceService;
import id.co.sim.mobsur.service.MasterAnswerTypeService;
import id.co.sim.mobsur.service.MasterCityService;
import id.co.sim.mobsur.service.MasterCompanyService;
import id.co.sim.mobsur.service.MasterDistributionService;
import id.co.sim.mobsur.service.MasterHierarchyService;
import id.co.sim.mobsur.service.MasterJobAssignmentService;
import id.co.sim.mobsur.service.MasterKecamatanService;
import id.co.sim.mobsur.service.MasterKelurahanService;
import id.co.sim.mobsur.service.MasterMenuService;
import id.co.sim.mobsur.service.MasterOfficeService;
import id.co.sim.mobsur.service.MasterOptionAnswerService;
import id.co.sim.mobsur.service.MasterParameterService;
import id.co.sim.mobsur.service.MasterParentMenuService;
import id.co.sim.mobsur.service.MasterProductService;
import id.co.sim.mobsur.service.MasterProvinsiService;
import id.co.sim.mobsur.service.MasterQuestionGroupService;
import id.co.sim.mobsur.service.MasterQuestionService;
import id.co.sim.mobsur.service.MasterReasonTypeService;
import id.co.sim.mobsur.service.MasterRoleMenuService;
import id.co.sim.mobsur.service.MasterUserRoleService;
import id.co.sim.mobsur.service.MasterRoleService;
import id.co.sim.mobsur.service.MasterRoleTypeService;
import id.co.sim.mobsur.service.MasterTaskStatusService;
import id.co.sim.mobsur.service.MasterTemplateService;
import id.co.sim.mobsur.service.MasterUserService;
import id.co.sim.mobsur.service.MasterZipcodeService;
import id.co.sim.mobsur.service.MasterZipcodeVerificatorService;
import id.co.sim.mobsur.service.MobileTaskAssignmentService;
import id.co.sim.mobsur.util.file.WriteExcel;
import id.co.sim.mobsur.util.file.WritePDF;
import id.co.sim.mobsur.util.file.WriteText;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
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
 private final String basicEndDate = "2999-12-31";
 private final String folderName = "download/";
 //        
 private File downloadFile;
 private String fileName;
 
 @Autowired
 private MasterParentMenuService mpmServ;
 @Autowired
 private MasterCompanyService mcServ;
 @Autowired
 private MasterMenuService mmServ;
 @Autowired
 private MasterRoleService mrServ;
 @Autowired
 private MasterRoleTypeService mrlServ;
 @Autowired
 private MasterOfficeService moServ;
 @Autowired
 private MasterUserService muServ;
 @Autowired
 private DetailCompanyLogoService dclServ;
 @Autowired
 private MasterUserRoleService murServ;
 @Autowired
 private MasterRoleMenuService mrmServ;
 @Autowired
 private MasterZipcodeService mzServ;
 @Autowired
 private MasterParameterService mpServ;
 @Autowired
 private MasterHierarchyService mhServ;
 @Autowired
 private MasterDistributionService mdServ;
 @Autowired
 private MasterProvinsiService mprServ;
 @Autowired
 private MasterCityService mciServ;
 @Autowired
 private MasterKecamatanService mkServ;
 @Autowired
 private MasterKelurahanService mklServ;
 @Autowired
 private MasterQuestionService mqServ;
 @Autowired
 private MasterAnswerTypeService matServ;
 @Autowired
 private MasterOptionAnswerService moaServ;
 @Autowired
 private GenericService genServ;
 @Autowired
 private MasterQuestionGroupService mqgServ;
 @Autowired
 private DetailQuestionGroupService dqgServ;
 @Autowired
 private MasterTemplateService mtServ;
 @Autowired
 private MasterProductService mpdServ;
 @Autowired
 private MasterJobAssignmentService mjaServ;
 @Autowired
 private MasterZipcodeVerificatorService mzvServ;
 @Autowired
 private MasterAbsenceService maServ;
 @Autowired
 private MasterReasonTypeService mrtServ;
 @Autowired
 private MobileTaskAssignmentService mtaServ;
 @Autowired
 private MasterTaskStatusService mtsServ;

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
      String asOfDate = emptyToValue(httpRequest.getParameter("asOfDate"),basicDate);
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
  * Generate all role types data
  *
  * @return json data
  */
    @RequestMapping(value = "/roletype", method = RequestMethod.GET)
    public @ResponseBody List<MasterRoleType> getAllRoleTypes() {
      logger.debug("Received request to get all role types data");
      // 
      return mrlServ.getAll();
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
  * Generate all roles data for client
  *
  * @param session
  * @return json data
  */
    @RequestMapping(value = "/rolebyrole", method = RequestMethod.GET)
    public @ResponseBody List<MasterRole> getRoleForClient(HttpSession session) {
      logger.debug("Received request to get all roles for client");
      //
      if(isOwner((Integer) session.getAttribute("userId")))
        //return mrServ.getForOwnerRole();//next on implementation
        return mrServ.getAll();//purpose for testing only
      return mrServ.getForClientRole();
 }

 /**
  * Generate all roles data for client with null value
  *
  * @param session
  * @return json data
  */
    @RequestMapping(value = "/rolebyrolewithnull", method = RequestMethod.GET)
    public @ResponseBody List<MasterRole> getRoleForClientWithNull(HttpSession session) {
      logger.debug("Received request to get all roles for client with null value");
      //
      if(isOwner((Integer) session.getAttribute("userId")))
        return mrServ.getForOwnerRoleWithNull();
      return mrServ.getForClientRoleWithNull();
 }

 /**
  * Generate all roles by parent role
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/rolebyparent", method = RequestMethod.GET)
    public @ResponseBody List<MasterRole> getRoleByParentRole(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all roles by parent role");
      //
      /*return mrServ.getByCoyAndParentRole(
              (Integer) httpRequest.getSession().getAttribute("coyId"),
              Integer.parseInt(httpRequest.getParameter("parentRoleId")));*/
      return mrServ.getByParentRoleLevel(mrServ.getById(Integer.parseInt(httpRequest.getParameter("parentRoleId"))).getRoleLevel());
 }

 /**
  * Generate all roles which assigned in distribution modul
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/roleassigndist", method = RequestMethod.GET)
    public @ResponseBody List<MasterRole> getRoleForAssignedDist(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all roles which assigned in distribution modul");
      //
      return mrServ.getForAssignDist();
 }

 /**
  * Generate all roles which could assigned job
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/rolejobassign", method = RequestMethod.GET)
    public @ResponseBody List<MasterRole> getRoleForJobAssign(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all roles which could assigned job");
      //
      return mrServ.getForClientRole();
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
      String asOfDate = emptyToValue(httpRequest.getParameter("asOfDate"),basicDate);
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
      String userIdStr = httpRequest.getParameter("userId");
      if(userIdStr == null || userIdStr.equals(""))
        return new ArrayList();
      return mrServ.getRolesByUser(Integer.parseInt(userIdStr));
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
      String asOfDate = emptyToValue(httpRequest.getParameter("asOfDate"),basicDate);
      int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
      //
      Map<String,Object> mapOffice = new HashMap();
      if(officeCodePattern.equals("") && officeNamePattern.equals("") && asOfDate.equals(basicDate)) {
        mapOffice.put("content", moServ.getByPageCompany(coyId,pageNo));
        mapOffice.put("count", moServ.count(coyId));
      } else {
        mapOffice.put("content", moServ.getByPageCompanyOfficeCodeNameAndDate(coyId, officeCodePattern, officeNamePattern, asOfDate, pageNo));
        mapOffice.put("count", moServ.countByCompanyOfficeCodeNameAndDate(coyId, officeCodePattern, officeNamePattern, asOfDate));        
      }
      return mapOffice;
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
      Object coyIdObj = httpRequest.getSession().getAttribute("coyId");
      if(coyIdObj == null)
        return new ArrayList();
      return muServ.getByCompany((Integer) coyIdObj);
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
      String asOfDate = emptyToValue(httpRequest.getParameter("asOfDate"),basicDate);
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
      String officeIdStr = httpRequest.getParameter("officeId");
      if(officeIdStr == null || officeIdStr.equals(""))
        return new ArrayList();
      return muServ.getByOffice(Integer.parseInt(officeIdStr));
 }

 /**
  * Generate all users data as verificator
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/userasverif", method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getUsersAsVerificator(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all users data by office");
      //
      return muServ.getByCoyAsVerificator((Integer) httpRequest.getSession().getAttribute("coyId"));
 }

 /**
  * Generate all users data by role
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = {"/userbyrole","/userbyrole2"}, method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getUsersByRole(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all users data by role");
      //
      return muServ.getByRoleCoy(
              Integer.parseInt(httpRequest.getParameter("roleId")),
              (Integer) httpRequest.getSession().getAttribute("coyId"));
 }

 /**
  * Generate all users data by parent
  *
   * @param session
  * @return json data
  */
    @RequestMapping(value = {"/userbyparent"}, method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getUsersByParent(HttpSession session) {
      logger.debug("Received request to get all users data by parent");
      //      
      return muServ.getByParentUser((Integer) (session.getAttribute("userId")));
 }

 /**
  * Generate all verificator users data by parent
  *
   * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = {"/userverifbyparent"}, method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getVerifUsersByParent(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all verificator users data by parent");
      //      
      String parentUserIdStr = httpRequest.getParameter("parentUserId");
      int parentUserId = (parentUserIdStr == null || parentUserIdStr.equals("")) ? 0 : Integer.parseInt(parentUserIdStr);
      parentUserId = parentUserId == 0 ? (Integer) (httpRequest.getSession().getAttribute("userId")) : parentUserId;
      return muServ.getByRoleAndParentUser(
              mrlServ.getByCode("V").getRoleTypeId(),
              parentUserId);
 }

 /**
  * Generate all coordinator users data by parent
  *
   * @param session
  * @return json data
  */
    @RequestMapping(value = {"/usercoordbyparent"}, method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getCoordUsersByParent(HttpSession session) {
      logger.debug("Received request to get all coordinator users data by parent");
      //      
      return muServ.getByRoleAndParentUser(
              mrlServ.getByCode("C").getRoleTypeId(),
              (Integer) (session.getAttribute("userId")));
 }

 /**
  * Generate all users data by role and parent
  *
   * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = {"/userbyroleparent"}, method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getUsersByRoleParent(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all users data by role and parent");
      //        
      int parentUserId = (Integer) (httpRequest.getSession().getAttribute("userId"));  
      int roleId = Integer.parseInt(httpRequest.getParameter("roleId"));
      if(roleId == 0)
        return new ArrayList();
      return muServ.getByRoleAndParentUser(
              mrServ.getById(roleId).getRoleType().getRoleTypeId(),
              parentUserId);
 }

 /**
  * Generate all users data by child role
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/userbychildrole", method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getUsersByChildRole(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all users data by child role");
      //
      int userId = (Integer) httpRequest.getSession().getAttribute("userId");
      int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
      //find the highest role
      int highestCount = 0;
      MasterRole highestRole = new MasterRole();
      for(MasterRole role : mrServ.getRolesByUser(userId)) {
        int count = muServ.countByCoyAndUserChildRole(coyId, role.getRoleId());
        if(count > highestCount) {
          highestCount = count;
          highestRole = role;
        }
      }
      return muServ.getByCoyAndUserChildRole(coyId,highestRole.getRoleId());
 }

 /**
  * Generate all users data by office and role type
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/coordbyofficerole", method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getUsersByOfficeRole(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all users data by office and role type");
      //
      int officeId = Integer.parseInt(httpRequest.getParameter("officeId"));
      if(officeId == 0)
        return new ArrayList();
      return muServ.getByOfficeAndRoleTypeCode(officeId, "C");
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
      String asOfDate = emptyToValue(httpRequest.getParameter("asOfDate"),basicDate);
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
      String asOfDate = emptyToValue(httpRequest.getParameter("asOfDate"),basicDate);
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
     String roleIdStr = httpRequest.getParameter("roleId");
     if(roleIdStr == null || roleIdStr.equals(""))
       return new ArrayList();
     return mrmServ.getByRoleId(Integer.parseInt(roleIdStr));
 }

 /**
  * Generate all zipcode data
  *
  * @return json data
  */
    @RequestMapping(value = "/zipcode", method = RequestMethod.GET)
    public @ResponseBody List<MasterZipcode> getAllZipcode() {
      logger.debug("Received request to get all zipcode data");
      // 
      return mzServ.getAll();
 }

 /**
  * Generate all zipcode data by kecamatan
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/zipcodebykec", method = RequestMethod.GET)
    public @ResponseBody List<MasterZipcode> getZipcodeByKecamatan(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all zipcode data by kecamatan");
     //retrieve zipcode
     String kecIdStr = httpRequest.getParameter("kecId");
     if(kecIdStr == null || kecIdStr.equals(""))
       return new ArrayList();
     return mzServ.getByKecamatan(Integer.parseInt(kecIdStr));
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
  * Generate all parameter data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/parameter/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getParameter(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all parameter data");
      //
      String parCodePattern = httpRequest.getParameter("parCodePattern") == null ? "" : httpRequest.getParameter("parCodePattern");
      String parDescPattern = httpRequest.getParameter("parDescPattern") == null ? "" : httpRequest.getParameter("parDescPattern");
      String parAppsType = httpRequest.getParameter("parAppsType") == null ? "" : httpRequest.getParameter("parAppsType");
      int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
      //
      Map<String,Object> mapParam = new HashMap();
      if(parCodePattern.equals("") && parDescPattern.equals("") && parAppsType.equals("")) {
        mapParam.put("content", mpServ.getByPageCompany(coyId, pageNo));
        mapParam.put("count", mpServ.countByCompany(coyId));
      } else {
        mapParam.put("content", mpServ.getByPageCompanyCodeDescAndApps(coyId, parCodePattern, parDescPattern, parAppsType, pageNo));
        mapParam.put("count", mpServ.countByCompanyCodeDescAndApps(coyId, parCodePattern, parDescPattern, parAppsType));        
      }
      return mapParam;
 }

 /**
  * Generate all hierarchy data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/hierarchy/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getHierarchy(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all hierarchy data");
      //
      int roleId = Integer.parseInt(httpRequest.getParameter("roleId"));
      int roleIdUp = Integer.parseInt(httpRequest.getParameter("roleIdUp"));
      int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
      //
      Map<String,Object> mapHie = new HashMap();
      if(roleId == 0 && roleIdUp == 0) {
        mapHie.put("content", mhServ.getByPage(pageNo));
        mapHie.put("count", mhServ.count());
      } else {
        mapHie.put("content", mhServ.getByPageCoyRoleAndRoleUp(coyId, roleId, roleIdUp, pageNo));
        mapHie.put("count", mhServ.countByCoyRoleAndRoleUp(coyId, roleId, roleIdUp));        
      }
      return mapHie;
 }

 /**
  * Generate all distribution data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/distribution/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getDistribution(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all distribution data");
      //
      int officeId = Integer.parseInt(httpRequest.getParameter("officeId"));
      int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
      //
      Map<String,Object> mapDist = new HashMap();
      if(officeId == 0) {
        mapDist.put("content", mdServ.getByPageCompany(coyId, pageNo));
        mapDist.put("count", mdServ.countByCompany(coyId));
      } else {
        mapDist.put("content", mdServ.getByPageCompanyOffice(coyId, officeId, pageNo));
        mapDist.put("count", mdServ.countByCompanyOffice(coyId, officeId));        
      }
      return mapDist;
 }

 /**
  * Generate all provinsi data
  *
  * @return json data
  */
    @RequestMapping(value = "/provinsi", method = RequestMethod.GET)
    public @ResponseBody List<MasterProvinsi> getAllProvinsi() {
      logger.debug("Received request to get all provinsi data");
      //
      return mprServ.getAll();
 }

 /**
  * Generate all provinsi data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/provinsi/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getProvinsi(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all provinsi data by page");
      //
      String provCodePattern = httpRequest.getParameter("provCodePattern") == null ? "" : httpRequest.getParameter("provCodePattern");
      String provNamePattern = httpRequest.getParameter("provNamePattern") == null ? "" : httpRequest.getParameter("provNamePattern");
      //
     Map<String,Object> mapProv = new HashMap();
      if(provCodePattern.equals("") && provNamePattern.equals("")) {
        mapProv.put("content", mprServ.getByPage(pageNo));
        mapProv.put("count", mprServ.count());
      } else {
        mapProv.put("content", mprServ.getByPageCodeAndName(provCodePattern, provNamePattern, pageNo));
        mapProv.put("count", mprServ.countByCodeAndName(provCodePattern, provNamePattern));        
      }
      return mapProv;
 }

 /**
  * Generate all city data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/city/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getCity(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all city data by page");
      //
      String cityCodePattern = httpRequest.getParameter("cityCodePattern") == null ? "" : httpRequest.getParameter("cityCodePattern");
      String cityNamePattern = httpRequest.getParameter("cityNamePattern") == null ? "" : httpRequest.getParameter("cityNamePattern");
      //
     Map<String,Object> mapCity = new HashMap();
      if(cityCodePattern.equals("") && cityNamePattern.equals("")) {
        mapCity.put("content", mciServ.getByPage(pageNo));
        mapCity.put("count", mciServ.count());
      } else {
        mapCity.put("content", mciServ.getByPageCodeAndName(cityCodePattern, cityNamePattern, pageNo));
        mapCity.put("count", mciServ.countByCodeAndName(cityCodePattern, cityNamePattern));        
      }
      return mapCity;
 }

 /**
  * Generate city data by provinsi
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/citybyprov", method = RequestMethod.GET)
    public @ResponseBody List<MasterCity> getCityByProv(HttpServletRequest httpRequest) {
     logger.debug("Received request to get city data by provinsi");
     //retrieve city
     String provIdStr = httpRequest.getParameter("provId");
     if(provIdStr == null || provIdStr.equals(""))
       return new ArrayList();
     return mciServ.getByProvinsi(Integer.parseInt(provIdStr));
 }

 /**
  * Generate all kecamatan data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/kecamatan/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getKecamatan(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all kecamatan data by page");
      //
      String kecCodePattern = httpRequest.getParameter("kecCodePattern") == null ? "" : httpRequest.getParameter("kecCodePattern");
      String kecNamePattern = httpRequest.getParameter("kecNamePattern") == null ? "" : httpRequest.getParameter("kecNamePattern");
      //
     Map<String,Object> mapKec = new HashMap();
      if(kecCodePattern.equals("") && kecNamePattern.equals("")) {
        mapKec.put("content", mkServ.getByPage(pageNo));
        mapKec.put("count", mkServ.count());
      } else {
        mapKec.put("content", mkServ.getByPageCodeAndName(kecCodePattern, kecNamePattern, pageNo));
        mapKec.put("count", mkServ.countByCodeAndName(kecCodePattern, kecNamePattern));        
      }
      return mapKec;
 }

 /**
  * Generate all kecamatan data by city
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/kecbycity", method = RequestMethod.GET)
    public @ResponseBody List<MasterKecamatan> getKecamatanByCity(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all kecamatan data by city");
     //retrieve kecamatan
     String cityIdStr = httpRequest.getParameter("cityId");
     if(cityIdStr == null || cityIdStr.equals(""))
       return new ArrayList();
     return mkServ.getByCity(Integer.parseInt(cityIdStr));
 }

 /**
  * Generate all kelurahan data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/kelurahan/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getKelurahan(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all kelurahan data by page");
      //
      String kelCodePattern = httpRequest.getParameter("kelCodePattern") == null ? "" : httpRequest.getParameter("kelCodePattern");
      String kelNamePattern = httpRequest.getParameter("kelNamePattern") == null ? "" : httpRequest.getParameter("kelNamePattern");
      //
     Map<String,Object> mapKel = new HashMap();
      if(kelCodePattern.equals("") && kelNamePattern.equals("")) {
        mapKel.put("content", mklServ.getByPage(pageNo));
        mapKel.put("count", mklServ.count());
      } else {
        mapKel.put("content", mklServ.getByPageCodeAndName(kelCodePattern, kelNamePattern, pageNo));
        mapKel.put("count", mklServ.countByCodeAndName(kelCodePattern, kelNamePattern));        
      }
      return mapKel;
 }

 /**
  * Generate all kelurahan data by city
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/kelbykec", method = RequestMethod.GET)
    public @ResponseBody List<MasterKelurahan> getKelurahanByKecamatan(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all kelurahan data by kecamatan");
     //retrieve kelurahan
     String kecIdStr = httpRequest.getParameter("kecId");
     if(kecIdStr == null || kecIdStr.equals(""))
       return new ArrayList();
     return mklServ.getByKecamatan(Integer.parseInt(kecIdStr));
 }

 /**
  * Generate question data by coy
  *
  * @param session
  * @return json data
  */
    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public @ResponseBody List<MasterQuestion> getQuestionByCoy(HttpSession session) {
      logger.debug("Received request to get question data by coy");
      //
      return mqServ.getByCoy((Integer) session.getAttribute("coyId"));
 }

 /**
  * Generate question data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/question/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getQuestion(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get question data by page");
      //
      String questLabelPattern = httpRequest.getParameter("questLabelPattern") == null ? "" : httpRequest.getParameter("questLabelPattern");
      int answerTypeId = Integer.parseInt(httpRequest.getParameter("answerTypeId"));
      int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
      //
     Map<String,Object> mapQuest = new HashMap();
      if(questLabelPattern.equals("") && answerTypeId == 0) {
        mapQuest.put("content", mqServ.getByPageCoy(coyId, pageNo));
        mapQuest.put("count", mqServ.countByCoy(coyId));
      } else {
        mapQuest.put("content", mqServ.getByPageCoyLabelAndAnswer(coyId, questLabelPattern, answerTypeId, pageNo));
        mapQuest.put("count", mqServ.countByCoyLabelAndAnswer(coyId, questLabelPattern, answerTypeId));        
      }
      return mapQuest;
 }

 /**
  * Generate all answer type data
  *
  * @return json data
  */
    @RequestMapping(value = "/answertype", method = RequestMethod.GET)
    public @ResponseBody List<MasterAnswerType> getAllAnswerType() {
     logger.debug("Received request to get all answer type data");
     //retrieve all answer type
     return matServ.getAll();
 }

 /**
  * Generate all option answer data
  *
  * @return json data
  */
    @RequestMapping(value = "/optionanswer", method = RequestMethod.GET)
    public @ResponseBody List<MasterOptionAnswer> getAllOptionAnswer() {
     logger.debug("Received request to get all option answer data");
     //retrieve all option answer
     return moaServ.getAll();
 }

 /**
  * Generate list option parameter data
  *
   * @param request
  * @return json data
  */
    @RequestMapping(value = "/listoptions", method = RequestMethod.GET)
    public @ResponseBody ContentsBean getDetailGroupParams(HttpServletRequest request) {
     logger.debug("Received request to get list option parameter data");
     //retrieve list option parameter
     return genServ.getTableContents(
             request.getParameter("tableName"),
             Integer.parseInt(request.getParameter("groupParamId")),
             request.getParameter("delimiter"));
 }

 /**
  * Generate question group data by coy
  *
  * @param session
  * @return json data
  */
    @RequestMapping(value = "/questiongroup", method = RequestMethod.GET)
    public @ResponseBody List<MasterQuestionGroup> getQuestionGroupByCoy(HttpSession session) {
      logger.debug("Received request to get question group data by coy");
      //
      return mqgServ.getByCoy((Integer) session.getAttribute("coyId"));
 }

 /**
  * Generate group question data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/questiongroup/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getQuestionGroup(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get group question data by page");
      //
      String questGroupLabelPattern = httpRequest.getParameter("questGroupLabelPattern") == null ?
              "" : httpRequest.getParameter("questGroupLabelPattern");
      int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
      //
     Map<String,Object> mapQueGrp = new HashMap();
      if(questGroupLabelPattern.equals("")) {
        mapQueGrp.put("content", mqgServ.getByPageCoy(coyId, pageNo));
        mapQueGrp.put("count", mqgServ.countByCoy(coyId));
      } else {
        mapQueGrp.put("content", mqgServ.getByPageCoyAndLabel(coyId, questGroupLabelPattern, pageNo));
        mapQueGrp.put("count", mqgServ.countByCoyAndLabel(coyId, questGroupLabelPattern));        
      }
      return mapQueGrp;
 }

 /**
  * Generate detail question group by group
  *
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/detailquestionbygroup", method = RequestMethod.GET)
    public @ResponseBody List<DetailQuestionGroup> getDetailQuestionByGroup(HttpServletRequest httpRequest) {
      logger.debug("Received request to get detail question group by group");
      //
      return dqgServ.getByQuestGroup(Integer.parseInt(httpRequest.getParameter("questGroupId")));
 }

 /**
  * Generate question template by coy
  *
  * @param session
  * @return json data
  */
    @RequestMapping(value = "/template", method = RequestMethod.GET)
    public @ResponseBody List<MasterTemplate> getTemplateByCoy(HttpSession session) {
      logger.debug("Received request to get template data by coy");
      //
      return mtServ.getByCoy((Integer) session.getAttribute("coyId"));
 }

 /**
  * Generate template data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/template/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getTemplate(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get template data by page");
      //
      String tempLabelPattern = httpRequest.getParameter("tempLabelPattern") == null ? "" : httpRequest.getParameter("tempLabelPattern");
      int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
      //
     Map<String,Object> mapTemp = new HashMap();
      if(tempLabelPattern.equals("")) {
        mapTemp.put("content", mtServ.getByPageCoy(coyId, pageNo));
        mapTemp.put("count", mtServ.countByCoy(coyId));
      } else {
        mapTemp.put("content", mtServ.getByPageCoyAndLabel(coyId, tempLabelPattern, pageNo));
        mapTemp.put("count", mtServ.countByCoyAndLabel(coyId, tempLabelPattern));        
      }
      return mapTemp;
 }

 /**
  * Generate product data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/product/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getProduct(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get product data by page");
      //
      String productNamePattern = httpRequest.getParameter("productNamePattern") == null ? "" : httpRequest.getParameter("productNamePattern");
      int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
      //
     Map<String,Object> mapProd = new HashMap();
      if(productNamePattern.equals("")) {
        mapProd.put("content", mpdServ.getByPageCoy(coyId, pageNo));
        mapProd.put("count", mpdServ.countByCoy(coyId));
      } else {
        mapProd.put("content", mpdServ.getByPageCoyAndName(coyId,productNamePattern, pageNo));
        mapProd.put("count", mpdServ.countByCoyAndName(coyId,productNamePattern));        
      }
      return mapProd;
 }

 /**
  * Generate job assignment data by user commissioned
  *
   * @param userCommissionedId
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/jobassignment/{userCommissionedId}", method = RequestMethod.GET)
    public @ResponseBody List<MasterJobAssignment> getJobAssignByUserCommission(
            @PathVariable("userCommissionedId") int userCommissionedId,
            HttpServletRequest httpRequest) {
      logger.debug("Received request to get job assignment data by user commissioned");
      //
      if(userCommissionedId == 0)
       return new ArrayList();
      return mjaServ.getByUserCommissioned(userCommissionedId);
 }

 /**
  * Generate question template by coy
  *
   * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/maxsubzipcode", method = RequestMethod.GET)
    public @ResponseBody StringBean getMaxSubZipcode(HttpServletRequest httpRequest) {
      logger.debug("Received request to get template data by coy");
      //
      return new StringBean(mzvServ.getMaxSubZipcodeByCoyAndZipcode(
              (Integer) httpRequest.getSession().getAttribute("coyId"),
              Integer.parseInt(httpRequest.getParameter("zipcodeId"))));
 }

 /**
  * Generate zipcode verificator data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/zipcodeverif/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getZipcodeVerif(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get zipcode verificator data by page");
      //
      int verificatorId = Integer.parseInt(httpRequest.getParameter("verificatorId"));
      String zipcodeCodePattern = httpRequest.getParameter("zipcodeCodePattern") == null ? "" : httpRequest.getParameter("zipcodeCodePattern");
      int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
      int parentUserId = (Integer) httpRequest.getSession().getAttribute("userId");
      //
     Map<String,Object> mapZipcodeVerif = new HashMap();
      if(verificatorId == 0 && zipcodeCodePattern.equals("")) {
        mapZipcodeVerif.put("content", mzvServ.getByPageParentUser(parentUserId, pageNo));
        mapZipcodeVerif.put("count", mzvServ.countByParentUser(parentUserId));
      } else {
        mapZipcodeVerif.put("content", mzvServ.getByPageParentUserVerifAndZipcode(parentUserId, verificatorId, zipcodeCodePattern, pageNo));
        mapZipcodeVerif.put("count", mzvServ.countByParentUserVerifAndZipcode(parentUserId, verificatorId, zipcodeCodePattern));        
      }
      return mapZipcodeVerif;
 }

  /**
   * Handles zipcode verificator download request
   * @param httpRequest 
   * @return  
   */
  @RequestMapping(value = "/zipcodeverif/download/request", method = RequestMethod.POST)
  public @ResponseBody StringBean processDownloadZipcodeVerificator(HttpServletRequest httpRequest) {
    logger.debug("Received request to process zipcode verificator file");   
    //return object
    StringBean sb = new StringBean();
    sb.setId(0);
    sb.setVal("SUCCESS");
    //request parameter
    int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
    String fileType = httpRequest.getParameter("fileType");
    int verificatorId = Integer.parseInt(httpRequest.getParameter("verificatorId"));
    MasterUser user = muServ.getById(verificatorId);
    String textDelimiter = httpRequest.getParameter("textDelimiter");
    
    //read data and rewrite it into downloadable file
    //titles
    List<String> titles = new ArrayList();
    titles.add("Verificator: " + user.getUserName());
    Date processDate = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String processDateStr = simpleDateFormat.format(processDate);
    titles.add("Process Date: " + processDateStr);
    //headers
    String[] hdrArr = {"Verificator Code","Zipcode Code","Sub Zipcode","Description"};
    List<String> headers = Arrays.asList(hdrArr);
    //contents
    List<List<String>> contents = new ArrayList();
    for(MasterZipcodeVerificator zipcodeVerif : mzvServ.getByCoyVerif(coyId, verificatorId)) {
      List<String> content = new ArrayList();
      content.add(zipcodeVerif.getVerificator().getUserCode());
      content.add(zipcodeVerif.getZipcode().getZipcodeCode());
      content.add(zipcodeVerif.getSubZipcode());
      content.add(zipcodeVerif.getDescription());
      contents.add(content);
    }
    //file name
    String fileExt = "";
    switch (fileType) {
      case "excelfile":
        fileExt = ".xls";
        break;
      case "pdffile":
        fileExt = ".pdf";
        break;
      case "textfile":
        fileExt = ".txt";
        break;
   }
    fileName = "list_zipcode_verificator_" + user.getUserCode() + "_" + processDateStr.replaceAll("-", "_") + fileExt;
    try {
      downloadFile = new File(folderName + fileName);
      switch (fileType) {
        case "excelfile":
          new WriteExcel(downloadFile, titles, headers, contents, user.getUserCode()).createFile();
          break;
        case "pdffile":
          new WritePDF(downloadFile, titles, headers, contents, user.getUserCode()).createFile();
          break;
        case "textfile":
          new WriteText(downloadFile, titles, headers, contents, user.getUserCode(),textDelimiter).createFile();
          break;
      }
    } catch (IOException | COSVisitorException ex) {
      logger.error(ex);
      sb.setId(1);
      sb.setVal("FAILED");
    }
    return sb;
  }

  /**
   * Handles zipcode verificator download page
   * @param httpResponse 
   */
  @RequestMapping(value = "/zipcodeverif/download", method = RequestMethod.GET)
  public void downloadZipcodeVerificator(HttpServletResponse httpResponse) {
    logger.debug("Received request to download zipcode verificator file");   
    //no cache applicable
    setNoCache(httpResponse);
    try {
      httpResponse.setHeader("Content-disposition","attachment; filename=" + fileName);
      setNoCache(httpResponse);
      //be aware this is a new java 7 feature, avoid the object have not closed after execute
      try (InputStream in = new FileInputStream(downloadFile)) {
        FileCopyUtils.copy(in, httpResponse.getOutputStream());
        httpResponse.flushBuffer();
      }
    } catch (IOException ex) {
      logger.error(ex);
    }
  }

 /**
  * Generate absence data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/absence/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getAbsence(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get absence data by page");
      //
      //int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
      int parentUserId = (Integer) httpRequest.getSession().getAttribute("userId");
      int userId = Integer.parseInt(httpRequest.getParameter("userId"));
      int reasonTypeId = Integer.parseInt(httpRequest.getParameter("reasonTypeId"));
      String startDate = emptyToValue(httpRequest.getParameter("startDate"),basicDate);
      String endDate = emptyToValue(httpRequest.getParameter("endDate"),basicEndDate);
      //
      Map<String,Object> mapAbsence = new HashMap();
      if(userId == 0 && reasonTypeId == 0 && startDate.equals(basicDate) && endDate.equals(basicEndDate)) {
        mapAbsence.put("content", maServ.getByPageParentUser(parentUserId, pageNo));
        mapAbsence.put("count", maServ.countByParentUser(parentUserId));
      } else {
        mapAbsence.put("content", maServ.getByPageParentUserReasonStartAndEndDate(parentUserId, userId, reasonTypeId, startDate, endDate, pageNo));
        mapAbsence.put("count", maServ.countByParentUserReasonStartAndEndDate(parentUserId, userId, reasonTypeId, startDate, endDate));        
      }
      return mapAbsence;
  }

 /**
  * Generate mobile task assignment data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/taskassign/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getMobileTaskAssign(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get mobile task assignment data by page");
      //
      int userId = Integer.parseInt(httpRequest.getParameter("coordinatorId"));
      //
      Map<String,Object> mapTaskAssign = new HashMap();
      if(userId == 0) {
        userId = (Integer) httpRequest.getSession().getAttribute("userId");
      }
      mapTaskAssign.put("content", mtaServ.getByPageUser(userId,pageNo));
      mapTaskAssign.put("count", mtaServ.countByUser(userId));
      return mapTaskAssign;
  }

 /**
  * Generate mobile rolling task data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/rollingtask/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getMobileRollingTask(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get mobile rolling task data by page");
      //
      int userId = Integer.parseInt(httpRequest.getParameter("commissionedId"));
      //
      Map<String,Object> mapRollTask = new HashMap();
      if(userId == 0) {
        mapRollTask.put("content", new ArrayList());
        mapRollTask.put("count", 0);
      } else {
        mapRollTask.put("content", mtaServ.getByPageUser(userId,pageNo));
        mapRollTask.put("count", mtaServ.countByUser(userId));
      }
      return mapRollTask;
  }

 /**
  * Generate mobile inquiry task data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/inquirytask/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getMobileInquiryTask(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get mobile inquiry task data by page");
      //
      int userId = Integer.parseInt(httpRequest.getParameter("coordinatorId"));
      //
      Map<String,Object> mapInqTask = new HashMap();
      if(userId == 0) {
        mapInqTask.put("content", new ArrayList());
        mapInqTask.put("count", 0);
      } else {
        mapInqTask.put("content", mtaServ.getByPageUser(userId,pageNo));
        mapInqTask.put("count", mtaServ.countByUser(userId));
      }
      return mapInqTask;
  }

 /**
  * Generate all reason type data
  *
  * @return json data
  */
    @RequestMapping(value = "/reasontype", method = RequestMethod.GET)
    public @ResponseBody List<MasterReasonType> getReasonType() {
     logger.debug("Received request to get all reason type data");
     //retrieve all reason type
     return mrtServ.getAll();
 }

 /**
  * Generate all task status data
  *
  * @return json data
  */
    @RequestMapping(value = "/taskstatus", method = RequestMethod.GET)
    public @ResponseBody List<MasterTaskStatus> getAllTaskStatus() {
     logger.debug("Received request to get all task status data");
     //retrieve all task status
     return mtsServ.getAll();
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
     return Base64.encodeBase64(dclServ.getById(companyLogoId).getLogoPicture());
 }
  
  @RequestMapping(value = "/iscoordinator", method = RequestMethod.GET)
  public @ResponseBody StringBean isCoordinator(HttpServletRequest httpRequest) {
    logger.debug("Received request to get status whether user is coordinator or not");
    //
    StringBean sb = new StringBean("false");
    List<MasterRole> roles = mrServ.getRolesByUser((Integer) httpRequest.getSession().getAttribute("userId"));
    for(MasterRole role : roles) {
      if(role.getRoleType() != null && role.getRoleType().getRoleTypeCode().equals("C")) {
        sb.setVal("true");
        return sb;
      }
    }
    return sb;
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
  
  private boolean isOwner(int userId) {        
    List<MasterRole> roles = mrServ.getRolesByUser(userId);
    for(MasterRole role : roles) {
      if(role.getRoleType() != null && role.getRoleType().getRoleTypeCode().equals("O"))
        return true;
    }
    return false;
  }
  
  private String emptyToValue(String valueToBeChecked, String valueIfNull) {
    if(valueToBeChecked == null || valueToBeChecked.equals(""))
      return valueIfNull;
    return valueToBeChecked;
  }

}
