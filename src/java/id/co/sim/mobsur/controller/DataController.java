/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.controller;

import id.co.sim.mobsur.bean.DetailQuestionGroup;
import id.co.sim.mobsur.bean.MasterAnswerType;
import id.co.sim.mobsur.bean.MasterCity;
import id.co.sim.mobsur.bean.MasterCompany;
import id.co.sim.mobsur.bean.MasterJobAssignment;
import id.co.sim.mobsur.bean.MasterKecamatan;
import id.co.sim.mobsur.bean.MasterKelurahan;
import id.co.sim.mobsur.bean.MasterMenu;
import id.co.sim.mobsur.bean.MasterOffice;
import id.co.sim.mobsur.bean.MasterOptionAnswer;
import id.co.sim.mobsur.bean.MasterParentMenu;
import id.co.sim.mobsur.bean.MasterParentParameter;
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
import id.co.sim.mobsur.bean.MobileTaskAssignment;
import id.co.sim.mobsur.bean.MobileTaskResult;
import id.co.sim.mobsur.bean.MobileTaskResultDetailList;
import id.co.sim.mobsur.bean.dto.TaskVerifyDTO;
import id.co.sim.mobsur.bean.support.ContentsBean;
import id.co.sim.mobsur.bean.support.ImageBean;
import id.co.sim.mobsur.bean.support.StringBean;
import id.co.sim.mobsur.bean.support.UserMenuBean;
import id.co.sim.mobsur.bean.support.VerifyTaskBean;
import id.co.sim.mobsur.service.DashMonitorVwService;
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
import id.co.sim.mobsur.service.MasterParentParameterService;
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
import id.co.sim.mobsur.service.MobileTaskResultDetailListService;
import id.co.sim.mobsur.service.MobileTaskResultImageService;
import id.co.sim.mobsur.service.MobileTaskResultService;
import id.co.sim.mobsur.util.file.WriteExcel;
import id.co.sim.mobsur.util.file.WritePDF;
import id.co.sim.mobsur.util.file.WriteText;
import id.co.sim.mobsur.util.file.WriteText2;
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
 * @created Jun 19, 2016
 * @author awal
 */
@Controller
@RequestMapping("/data")
public class DataController {

 private final Logger logger = Logger.getLogger("controller");
 private final String basicDate = "2000-01-01"; //default start date
 private final String basicEndDate = "2999-12-31"; //default end date
 private final String folderName = "download/"; //keep the downloaded file in this folder (find out in apache bin location)
 //        
 private File downloadFile; //download file object
 private String fileName;
 
 // Service injection list
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
 private MasterParentParameterService mppServ;
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
 @Autowired
 private MobileTaskResultService mtrServ;
 @Autowired
 private MobileTaskResultDetailListService mtrdlServ;
 @Autowired
 private MobileTaskResultImageService mtriServ;
 @Autowired
 private DashMonitorVwService dmvServ;

 /**
  * Generate companies data by page
  * store result in the java Map, so we can send the content and its count
   * @param pageNo, page number
  * @param httpRequest
  * @return list of companies contents of the given page, and count of them by the finding parameters
  */
    @RequestMapping(value = "/company/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getCompanies(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get companies data");
      //parameter of find
      String coyCodePattern = httpRequest.getParameter("coyCodePattern") == null ? "" : httpRequest.getParameter("coyCodePattern");
      String coyNamePattern = httpRequest.getParameter("coyNamePattern") == null ? "" : httpRequest.getParameter("coyNamePattern");
      //
      Map<String,Object> mapCoy = new HashMap();
      if(coyCodePattern.equals("") && coyNamePattern.equals("")) { //no filter, the default
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
  * @return list of all parent menus
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
  * @return list of all menus
  */
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public @ResponseBody List<MasterMenu> getAllMenu() {
     logger.debug("Received request to get all menus data");
     //retrieve all menus
     return mmServ.getAll();
 }

 /**
  * Generate menus data by page
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of menus contents of the given page, and count of them by the finding parameters
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
  * @return list of all role types
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
  * @return list of all roles
  */
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public @ResponseBody List<MasterRole> getAllRoles() {
      logger.debug("Received request to get all roles data");
      // 
      return mrServ.getAll();
 }

 /**
  * Generate all roles data based on logged user role group: owner or client
  *
  * @param session
  * @return list of all roles, based on logged user
  */
    @RequestMapping(value = "/rolebyrole", method = RequestMethod.GET)
    public @ResponseBody List<MasterRole> getRoleForClient(HttpSession session) {
      logger.debug("Received request to get all roles for client");
      //owner
      if(isOwner((Integer) session.getAttribute("userId")))
        //return mrServ.getForOwnerRole();//next on implementation
        return mrServ.getAll();//purpose for testing only
      //client
      return mrServ.getForClientRole();
 }

 /**
  * Generate all roles data plus null value by logged user role group: owner or client
  *
  * @param session
  * @return list of all roles, based on logged user plus null
  */
    @RequestMapping(value = "/rolebyrolewithnull", method = RequestMethod.GET)
    public @ResponseBody List<MasterRole> getRoleForClientWithNull(HttpSession session) {
      logger.debug("Received request to get all roles for client with null value");
      //owner
      if(isOwner((Integer) session.getAttribute("userId")))
        return mrServ.getForOwnerRoleWithNull();
      //client
      return mrServ.getForClientRoleWithNull();
 }

 /**
  * Generate all roles by parent role
  *
  * @param httpRequest
  * @return list of roles by given user as a superior
  */
    @RequestMapping(value = "/rolebyparent", method = RequestMethod.GET)
    public @ResponseBody List<MasterRole> getRoleByParentRole(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all roles by parent role");
      //
      return mrServ.getByParentRoleLevel(mrServ.getById(Integer.parseInt(httpRequest.getParameter("parentRoleId"))).getRoleLevel());
 }

 /**
  * Generate all roles which assigned in distribution modul
  *
  * @param httpRequest
  * @return list of roles specific to distribution model
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
  * @return list of roles based on user who has privilege signing job
  */
    @RequestMapping(value = "/rolejobassign", method = RequestMethod.GET)
    public @ResponseBody List<MasterRole> getRoleForJobAssign(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all roles which could assigned job");
      //
      String userRoleTypeCode = (String) httpRequest.getSession().getAttribute("roleTypeCode");
      String[] roleTypeCodeArr = {userRoleTypeCode,"C"};
      //
      return mrServ.getByRoleType(roleTypeCodeArr);
 }

 /**
  * Generate all down level roles of role
  *
  * @param httpRequest
  * @return list of children roles of the given role
  */
    @RequestMapping(value = "/rolechildlevel", method = RequestMethod.GET)
    public @ResponseBody List<MasterRole> getRoleChildLevel(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all down level roles of role");
      //      
      return mrServ.getByRoleLevel(Integer.parseInt(httpRequest.getParameter("roleLevel")) + 1);
 }

 /**
  * Generate all roles data by page
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of roles contents of the given page, and count of them by the finding parameters
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
  * @return list of roles by the given user
  */
    @RequestMapping(value = "/rolebyuser", method = RequestMethod.GET)
    public @ResponseBody List<MasterRole> getRolesByUser(HttpServletRequest httpRequest) {
      logger.debug("Received request to get roles data by user");
      //
      String userIdStr = httpRequest.getParameter("userId");
      //return undefined user
      if(userIdStr == null || userIdStr.equals(""))
        return new ArrayList();
      //others
      return mrServ.getRolesByUser(Integer.parseInt(userIdStr));
 }

 /**
  * Generate offices by company data
  *
  * @param session
  * @return list of offices by the current company
  */
    @RequestMapping(value = "/office", method = RequestMethod.GET)
    public @ResponseBody List<MasterOffice> getOfficesByCompany(HttpSession session) {
      logger.debug("Received request to get offices data");
      //coordinator office
      if(((String) session.getAttribute("roleTypeCode")).equals("C")) {
        List<MasterOffice> offices = new ArrayList();
        offices.add(muServ.getById((Integer) session.getAttribute("userId")).getOffice());
        return offices;
      }
      //all office
      return moServ.getByCompany((Integer) session.getAttribute("coyId"));
 }

 /**
  * Generate offices data by company and page
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of offices contents of the given page, and count of them by the finding parameters
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
  * Generate all users data
  *
  * @param httpRequest
  * @return list of users based on given company
  */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getUsersByCompany(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all users data");
      //
      Object coyIdObj = httpRequest.getSession().getAttribute("coyId");
      //no company
      if(coyIdObj == null)
        return new ArrayList();
      //normal
      return muServ.getByCompany((Integer) coyIdObj);
 }

 /**
  * Generate all users data by page
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of users contents of the given page, and count of them by the finding parameters
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
  * @return list of users based on given office
  */
    @RequestMapping(value = "/userbyoffice", method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getUsersByOffice(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all users data by office");
      //
      String officeIdStr = httpRequest.getParameter("officeId");
      //no office
      if(officeIdStr == null || officeIdStr.equals(""))
        return new ArrayList();
      //normal
      return muServ.getByOffice(Integer.parseInt(officeIdStr));
 }

 /**
  * Generate all users data as verificator
  *
  * @param httpRequest
  * @return list of users who has verificator role based on given company
  */
    @RequestMapping(value = "/userasverif", method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getUsersAsVerificator(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all users data by office");
      //
      return muServ.getByCoyAsVerificator((Integer) httpRequest.getSession().getAttribute("coyId"));
 }

 /**
  * Generate all company users data by role
  *
  * @param httpRequest
  * @return list of users based on given role and company
  */
    @RequestMapping(value = "/userbyrole", method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getUsersByRoleCompany(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all company users data by role");
      //
      return muServ.getByRoleCoy(
              Integer.parseInt(httpRequest.getParameter("roleId")),
              (Integer) httpRequest.getSession().getAttribute("coyId"));
 }

 /**
  * Generate all office users data by role
  *
  * @param httpRequest
  * @return list of users depend on the role, if manager return users based on company, otherwise return based on office
  */
    @RequestMapping(value = "/userbyrole2", method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getUsersByRoleOffice(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all office users data by role");
      //
      String roleTypeCode = httpRequest.getParameter("roleTypeCode");
      //user company
      if(roleTypeCode.equals("M"))
        return muServ.getByRoleCoy(
              Integer.parseInt(httpRequest.getParameter("roleId")),
              (Integer) httpRequest.getSession().getAttribute("coyId"));      
      //user office
      return muServ.getByRoleOffice(
              Integer.parseInt(httpRequest.getParameter("roleId")),
              muServ.getById(Integer.parseInt(httpRequest.getParameter("userId"))).getOffice().getOfficeId());
 }

 /**
  * Generate all users data by parent
  *
   * @param session
  * @return list of users based on given superior
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
  * @return list of users who has verificator role based on given superior
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
  * @return list of users who has coordinator role based on given company
  */
    @RequestMapping(value = {"/usercoordbyparent"}, method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getCoordUsersByParent(HttpSession session) {
      logger.debug("Received request to get all coordinator users data by parent");
      //coordinator himself      
      if(((String) session.getAttribute("roleTypeCode")).equals("C")) {
        List<MasterUser> users = new ArrayList();
        users.add(muServ.getById((Integer) session.getAttribute("userId")));
        return users;
      }
      //normal
      return muServ.getByRoleAndParentUser(
              mrlServ.getByCode("C").getRoleTypeId(),
              (Integer) (session.getAttribute("userId")));
 }

 /**
  * Generate all users data by role and parent
  *
   * @param httpRequest
  * @return list of users based on given role and superior
  */
    @RequestMapping(value = {"/userbyroleparent"}, method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getUsersByRoleParent(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all users data by role and parent");
      //        
      int parentUserId = (Integer) (httpRequest.getSession().getAttribute("userId"));  
      int roleId = Integer.parseInt(httpRequest.getParameter("roleId"));
      //no role
      if(roleId == 0)
        return new ArrayList();
      //normal
      return muServ.getByRoleAndParentUser(
              mrServ.getById(roleId).getRoleType().getRoleTypeId(),
              parentUserId);
 }

 /**
  * Generate all users data by child role
  *
  * @param httpRequest
  * @return list of users who is a child of given superior
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
  * Generate all coordinators data by office and role type
  *
  * @param httpRequest
  * @return list of users who has coordinator role based on given office
  */
    @RequestMapping(value = "/coordbyofficerole", method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getCoordByOfficeRole(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all coordinators data by office and role type");
      //
      int officeId = Integer.parseInt(httpRequest.getParameter("officeId"));
      //no office
      if(officeId == 0)
        return new ArrayList();
      //normal
      return muServ.getByOfficeAndRoleTypeCode(officeId, "C");
 }

 /**
  * Generate all verificators data by office and role type
  *
  * @param httpRequest
  * @return list of users who has verificator role based on given office
  */
    @RequestMapping(value = "/verifbyofficerole", method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getVerifByOfficeRole(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all verificators data by office and role type");
      //
      if(((String) httpRequest.getSession().getAttribute("roleTypeCode")).equals("C"))
        return muServ.getByParentUser((Integer) httpRequest.getSession().getAttribute("userId"));
      //
      int officeId = Integer.parseInt(httpRequest.getParameter("officeId"));
      //no office
      if(officeId == 0)
        return new ArrayList();
      //normal
      return muServ.getByOfficeAndRoleTypeCode(officeId, "V");
 }

 /**
  * Generate all user role data by page
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of user roles contents of the given page, and count of them by the finding parameters
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
  * @return list of user-menu combinations based on given user
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
  * Generate all role menus data by page
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of role menus contents of the given page, and count of them by the finding parameters
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
  * @return list of role-menu combinations based on given role
  */
    @RequestMapping(value = "/rolemenubyrole", method = RequestMethod.GET)
    public @ResponseBody List<MasterRoleMenu> getRoleMenuByRole(HttpServletRequest httpRequest) {
     logger.debug("Received request to get role menu data by role");
     //retrieve menu role
     String roleIdStr = httpRequest.getParameter("roleId");
     //no role
     if(roleIdStr == null || roleIdStr.equals(""))
       return new ArrayList();
     //normal
     return mrmServ.getByRoleId(Integer.parseInt(roleIdStr));
 }

 /**
  * Generate all zipcode data
  *
  * @return list of all zipcodes
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
  * @return list of zipcodes based on given kecamatan
  */
    @RequestMapping(value = "/zipcodebykec", method = RequestMethod.GET)
    public @ResponseBody List<MasterZipcode> getZipcodeByKecamatan(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all zipcode data by kecamatan");
     //retrieve zipcode
     String kecIdStr = httpRequest.getParameter("kecId");
     //no kecamatan
     if(kecIdStr == null || kecIdStr.equals(""))
       return new ArrayList();
     //normal
     return mzServ.getByKecamatan(Integer.parseInt(kecIdStr));
 }

 /**
  * Generate all zipcode data by city
  *
  * @param httpRequest
  * @return list of zipcodes based on given city
  */
    @RequestMapping(value = "/zipcodebycity", method = RequestMethod.GET)
    public @ResponseBody List<MasterZipcode> getZipcodeByCity(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all zipcode data by city");
     //retrieve zipcode
     String cityIdStr = httpRequest.getParameter("cityId");
     //no city
     if(cityIdStr == null || cityIdStr.equals(""))
       return new ArrayList();
     //normal
     return mzServ.getByCity(Integer.parseInt(cityIdStr));
 }

 /**
  * Generate all zipcode data by pattern code
  *
  * @param httpRequest
  * @return list of zipcodes based on given pattern
  */
    @RequestMapping(value = "/zipcodebypattern", method = RequestMethod.GET)
    public @ResponseBody List<MasterZipcode> getZipcodeByPattern(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all zipcode data by pattern code");
     //retrieve zipcode
     String patternCode = httpRequest.getParameter("patternCode");
     //no pattern
     if(patternCode == null || patternCode.equals(""))
       return new ArrayList();
     //normal
     return mzServ.getByPatternCode(patternCode);
 }

 /**
  * Generate all zipcodes data by page
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of zipcodes contents of the given page, and count of them by the finding parameters
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
  * Generate all parent parameters data
  *
  * @return list of all parent parameters
  */
    @RequestMapping(value = "/parentparam", method = RequestMethod.GET)
    public @ResponseBody List<MasterParentParameter> getAllParentParam() {
     logger.debug("Received request to get all parent parameters data");
     //retrieve all parent parameters
     return mppServ.getAll();
 }

 /**
  * Generate all parameter data by page
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of parameters contents based on given page and company, and count of them by the finding parameters
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
   * @param pageNo, page number
  * @param httpRequest
  * @return list of hierarchies contents of the given page and company, and count of them by the finding parameters
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
   * @param pageNo, page number
  * @param httpRequest
  * @return list of distributions contents of the given page and company, and count of them by the finding parameters
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
  * @return list of all provinsi
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
   * @param pageNo, page number
  * @param httpRequest
  * @return list of provinsi contents of the given page, and count of them by the finding parameters
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
   * @param pageNo, page number
  * @param httpRequest
  * @return list of cities contents of the given page, and count of them by the finding parameters
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
  * @return list of all cities based on given provinsi
  */
    @RequestMapping(value = "/citybyprov", method = RequestMethod.GET)
    public @ResponseBody List<MasterCity> getCityByProv(HttpServletRequest httpRequest) {
     logger.debug("Received request to get city data by provinsi");
     //retrieve city
     String provIdStr = httpRequest.getParameter("provId");
     //no provinsi
     if(provIdStr == null || provIdStr.equals(""))
       return new ArrayList();
     //normal
     return mciServ.getByProvinsi(Integer.parseInt(provIdStr));
 }

 /**
  * Generate all kecamatan data by page
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of kecamatan contents of the given page, and count of them by the finding parameters
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
  * @return list of all kecamatan based on given city
  */
    @RequestMapping(value = "/kecbycity", method = RequestMethod.GET)
    public @ResponseBody List<MasterKecamatan> getKecamatanByCity(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all kecamatan data by city");
     //retrieve kecamatan
     String cityIdStr = httpRequest.getParameter("cityId");
     //no city
     if(cityIdStr == null || cityIdStr.equals(""))
       return new ArrayList();
     //normal
     return mkServ.getByCity(Integer.parseInt(cityIdStr));
 }

 /**
  * Generate all kelurahan data by page
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of kelurahan contents of the given page, and count of them by the finding parameters
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
  * Generate all kelurahan data by kecamatan
  *
  * @param httpRequest
  * @return list of kelurahan based on given kecamatan
  */
    @RequestMapping(value = "/kelbykec", method = RequestMethod.GET)
    public @ResponseBody List<MasterKelurahan> getKelurahanByKecamatan(HttpServletRequest httpRequest) {
      logger.debug("Received request to get all kelurahan data by kecamatan");
     //retrieve kelurahan
     String kecIdStr = httpRequest.getParameter("kecId");
     //no kecamatan
     if(kecIdStr == null || kecIdStr.equals(""))
       return new ArrayList();
     //normal
     return mklServ.getByKecamatan(Integer.parseInt(kecIdStr));
 }

 /**
  * Generate question data by coy
  *
  * @param session
  * @return list of questions based on given company
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
   * @param pageNo, page number
  * @param httpRequest
  * @return list of questions contents of the given page and company, and count of them by the finding parameters
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
  * @return list of all answer types
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
  * @return list of all option answers
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
  * @return list of options based on given table or group parameter
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
  * @return list of question groups based on given company
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
   * @param pageNo, page number
  * @param httpRequest
  * @return list of question groups contents of the given page and company, and count of them by the finding parameters
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
  * @return list of detail question based on given question group
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
  * @return list of templates based on given company
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
   * @param pageNo, page number
  * @param httpRequest
  * @return list of templates contents of the given page and company, and count of them by the finding parameters
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
   * @param pageNo, page number
  * @param httpRequest
  * @return list of products contents of the given page and company, and count of them by the finding parameters
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
  * @return list of jobs contents of the given page, and count of them by the finding parameters
  */
    @RequestMapping(value = "/jobassignment/{userCommissionedId}", method = RequestMethod.GET)
    public @ResponseBody List<MasterJobAssignment> getJobAssignByUserCommission(
            @PathVariable("userCommissionedId") int userCommissionedId,
            HttpServletRequest httpRequest) {
      logger.debug("Received request to get job assignment data by user commissioned");
      //no commission
      if(userCommissionedId == 0)
       return new ArrayList();
      //normal
      return mjaServ.getByUserCommissioned(userCommissionedId);
 }

 /**
  * Generate maximum sub zipcode
  *
   * @param httpRequest
  * @return maximum sub zipcode based on given company and zipcode
  */
    @RequestMapping(value = "/maxsubzipcode", method = RequestMethod.GET)
    public @ResponseBody String getMaxSubZipcode(HttpServletRequest httpRequest) {
      logger.debug("Received request to get template data by coy");
      //
      return mzvServ.getMaxSubZipcodeByCoyAndZipcode(
              (Integer) httpRequest.getSession().getAttribute("coyId"),
              Integer.parseInt(httpRequest.getParameter("zipcodeId")));
 }

 /**
  * Generate zipcode verificator data by page
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of zipcode verificators contents of the given page and company, and count of them by the finding parameters
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
   * @return download request status 
   */
  @RequestMapping(value = "/zipcodeverif/download/request", method = RequestMethod.POST)
  public @ResponseBody StringBean processDownloadZipcodeVerificator(HttpServletRequest httpRequest) {
    logger.debug("Received request to process zipcode verificator file");   
    //return object
    StringBean sb = new StringBean();
    sb.setId(0);
    sb.setVal("SUCCESS");
    //request parameter
    MasterCompany coy = mcServ.getById((Integer) httpRequest.getSession().getAttribute("coyId"));
    String fileType = httpRequest.getParameter("fileType");
    int userId = (Integer) httpRequest.getSession().getAttribute("userId");
    MasterUser user = muServ.getById(userId);
    String textDelimiter = httpRequest.getParameter("textDelimiter");
    
    //read data and rewrite it into downloadable file
    //titles
    List<String> titles = new ArrayList();
    titles.add("Company: " + coy.getCoyName());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String processDateStr = simpleDateFormat.format(new Date());
    titles.add("Process Date: " + processDateStr);
    //headers
    String[] hdrArr = {"Verificator Code","Zipcode Code","Sub Zipcode","Description"};
    List<String> headers = Arrays.asList(hdrArr);
    //contents
    List<List<String>> contents = new ArrayList();
    for(MasterZipcodeVerificator zipcodeVerif : mzvServ.getByCoy(coy.getCoyId())) {
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
    fileName = "list_zipcode_verificator_" + coy.getCoyCode() + "_" + processDateStr.replaceAll("-", "_") + fileExt;
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
          new WriteText2(downloadFile, titles, headers, contents, user.getUserCode(),textDelimiter).createFile();
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
   * Handles zipcode verificator download template request
   * @param httpRequest 
   * @return download template request status
   */
  @RequestMapping(value = "/zipcodeverif/download/requesttemp", method = RequestMethod.POST)
  public @ResponseBody StringBean processDownloadZipcodeVerificatorTemp(HttpServletRequest httpRequest) {
    logger.debug("Received request to process zipcode verificator file");   
    //return object
    StringBean sb = new StringBean();
    sb.setId(0);
    sb.setVal("SUCCESS");
    //request parameter
    String fileType = httpRequest.getParameter("fileType");
    int userId = (Integer) httpRequest.getSession().getAttribute("userId");
    MasterUser user = muServ.getById(userId);
    String textDelimiter = httpRequest.getParameter("textDelimiter");
    
    //read data and rewrite it into downloadable file
    //titles
    List<String> titles = new ArrayList();
    //headers
    String[] hdrArr = {"Verificator Code","Zipcode Code","Sub Zipcode","Description"};
    List<String> headers = Arrays.asList(hdrArr);
    //contents
    List<List<String>> contents = new ArrayList();
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
    fileName = "list_zipcode_verificator" + fileExt;
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
          new WriteText2(downloadFile, titles, headers, contents, user.getUserCode(),textDelimiter).createFile();
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
   * Handles zipcode verificator download file
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
   * @param pageNo, page number
  * @param httpRequest
  * @return list of absences contents of the given page, and count of them by the finding parameters
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
   * @param pageNo, page number
  * @param httpRequest
  * @return list of task assigns contents of the given page, and count of them by the finding parameters
  */
    @RequestMapping(value = "/taskassign/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getMobileTaskAssign(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get mobile task assignment data by page");
      //
      String taskStatusCode = "ASSG"; //assigned status only allowed
      int userId = Integer.parseInt(httpRequest.getParameter("coordinatorId"));
      //
      Map<String,Object> mapTaskAssign = new HashMap();
      if(userId == 0) {
        userId = (Integer) httpRequest.getSession().getAttribute("userId");
      }
      mapTaskAssign.put("content", mtaServ.getByPageUser(userId, taskStatusCode, pageNo));
      mapTaskAssign.put("count", mtaServ.countByUser(userId, taskStatusCode));
      return mapTaskAssign;
  }

 /**
  * Generate mobile rolling task data by page
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of rolling tasks contents of the given page, and count of them by the finding parameters
  */
    @RequestMapping(value = "/rollingtask/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getMobileRollingTask(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get mobile rolling task data by page");
      //
      String[] taskStatusArr = {"ASSG","RETR"}; //assigned and retrieve status allowed
      int userId = Integer.parseInt(httpRequest.getParameter("commissionedId"));
      //
      Map<String,Object> mapRollTask = new HashMap();
      if(userId == 0) {
        mapRollTask.put("content", new ArrayList());
        mapRollTask.put("count", 0);
      } else {
        mapRollTask.put("content", mtaServ.getByPageUserAndTaskStatusList(userId, taskStatusArr, pageNo));
        mapRollTask.put("count", mtaServ.countByUserAndTaskStatusList(userId, taskStatusArr));
      }
      return mapRollTask;
  }

 /**
  * Generate mobile inquiry task data by page
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of tasks contents of the given page, and count of them by the finding parameters
  */
    @RequestMapping(value = "/inquirytask/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getMobileInquiryTask(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get mobile inquiry task data by page");
      //
      int officeId = Integer.parseInt(httpRequest.getParameter("officeId"));
      int coordinatorId = Integer.parseInt(httpRequest.getParameter("coordinatorId"));
      int verificatorId = Integer.parseInt(httpRequest.getParameter("verificatorId"));
      int taskStatusId = Integer.parseInt(httpRequest.getParameter("taskStatusId"));
      int tempId = Integer.parseInt(httpRequest.getParameter("tempId"));
      String priority = httpRequest.getParameter("priority");
      String startDate = emptyToValue(httpRequest.getParameter("startDate"),basicDate);
      String endDate = emptyToValue(httpRequest.getParameter("endDate"),basicEndDate);
      int taskId = Integer.parseInt(emptyToValue(httpRequest.getParameter("taskId"),"0"));
      //
      Map<String,Object> mapInqTask = new HashMap();
      if(officeId == 0) {
        mapInqTask.put("content", new ArrayList());
        mapInqTask.put("count", 0);
      } else if(coordinatorId == 0) {
        if(startDate.equals(basicDate) && endDate.equals(basicEndDate)) { //currently date assign is null
          mapInqTask.put("content", mtaServ.getByPageOfficeAndOther(officeId, taskStatusId, tempId, priority, taskId, pageNo));
          mapInqTask.put("count", mtaServ.countByOfficeAndOther(officeId, taskStatusId, tempId, priority, taskId));
        } else {
          mapInqTask.put("content", mtaServ.getByPageOfficeAndOther(officeId, taskStatusId, tempId, priority, startDate, endDate, taskId, pageNo));
          mapInqTask.put("count", mtaServ.countByOfficeAndOther(officeId, taskStatusId, tempId, priority, startDate, endDate, taskId));
        }
      } else if(verificatorId == 0) {
        mapInqTask.put("content", mtaServ.getByPageParentUserAndOther(coordinatorId, taskStatusId, tempId, priority, startDate, endDate, taskId, pageNo));
        mapInqTask.put("count", mtaServ.countByParentUserAndOther(coordinatorId, taskStatusId, tempId, priority, startDate, endDate, taskId));
      } else {
        mapInqTask.put("content", mtaServ.getByPageUserAndOther(verificatorId, taskStatusId, tempId, priority, startDate, endDate, taskId, pageNo));
        mapInqTask.put("count", mtaServ.countByUserAndOther(verificatorId, taskStatusId, tempId, priority, startDate, endDate, taskId));
      }
      return mapInqTask;
  }

 /**
  * Generate verify task data
  *
     * @param httpRequest
  * @return verify task, based on task
  */
    @RequestMapping(value = "/verifytask", method = RequestMethod.GET)
    public @ResponseBody VerifyTaskBean getVerifyTask(HttpServletRequest httpRequest) {
      logger.debug("Received request to get verify task data");
      //retrieve verify task data     
      VerifyTaskBean vtb = new VerifyTaskBean();
      int taskId = Integer.parseInt(httpRequest.getParameter("taskId"));
      MobileTaskResult taskResult = mtrServ.getByTaskIsLast(taskId);
      //no result
      if(taskResult == null)
        return vtb;
      //get image (if exists)
      List<ImageBean> imageList = new ArrayList();
      for(MobileTaskResultDetailList taskResultDetailList : mtrdlServ.getByTaskResultHasImage(taskResult.getTaskResultId())) {
        ImageBean image = new ImageBean();
        image.setId(taskResultDetailList.getTaskResultImage().getImageId());
        image.setName(taskResultDetailList.getTaskResultDetail().getQuestion().getQuestLabel());
        imageList.add(image);
      }
      //get data
      List<TaskVerifyDTO> taskVerifyList = genServ.getByTaskResult(taskResult.getTaskResultId());
      for(TaskVerifyDTO taskVerify : taskVerifyList) {
        if(taskVerify.getAnswerId() != null)
          taskVerify.setOptionList(genServ.getOptionList(taskVerify.getGroupParamId(), taskVerify.getTableName()));
      }
      vtb.setTaskVerifyList(taskVerifyList);
      vtb.setImageList(imageList);
      return vtb;
 }

 /**
  * Generate image of task by id
  *
   * @param imageId
   * @param httpResponse
  * @return image by given id
  */
    @RequestMapping(value = "/verifytask/image/{imageId}", method = RequestMethod.GET)
    public @ResponseBody byte[] getImageById(
            @PathVariable("imageId") int imageId,
            HttpServletResponse httpResponse) {
     logger.debug("Received request to get image of task by id");
     //no cache applicable
     setNoCache(httpResponse);
     // must be base64 object before sending to client
     return Base64.encodeBase64(mtriServ.getById(imageId).getImage());
 }

 /**
  * Generate mobile verify task data by page
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of verify tasks contents of the given page, and count of them by the finding parameters
  */
    @RequestMapping(value = "/verifytask/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getMobileVerifyTask(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get mobile verify task data by page");
      //
      String taskStatusCode = "SUBM";
      int coordId = Integer.parseInt(httpRequest.getParameter("coordinatorId"));
      int verifId = Integer.parseInt(httpRequest.getParameter("verificatorId"));
      //
      Map<String,Object> mapVerTask = new HashMap();
      if(coordId == 0 && verifId == 0) {
        mapVerTask.put("content", new ArrayList());
        mapVerTask.put("count", 0);
      } else if(verifId == 0) {
        mapVerTask.put("content", mtrServ.getByPageCoordAndTaskStatus(coordId, taskStatusCode, pageNo));
        mapVerTask.put("count", mtrServ.countByCoordAndTaskStatus(coordId, taskStatusCode));
      } else {
        mapVerTask.put("content", mtrServ.getByPageVerifAndTaskStatus(verifId, taskStatusCode,pageNo));
        mapVerTask.put("count", mtrServ.countByVerifAndTaskStatus(verifId, taskStatusCode));
      }
      return mapVerTask;
  }

 /**
  * Generate mobile drop task data by page
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of drop tasks contents of the given page, and count of them by the finding parameters
  */
    @RequestMapping(value = "/droptask/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getMobileDropTask(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get mobile drop task data by page");
      //
      String[] taskStatusArr = {"NEW","ASSG","RETR"};
      String startDate = emptyToValue(httpRequest.getParameter("startDate"),basicDate);
      String endDate = emptyToValue(httpRequest.getParameter("endDate"),basicEndDate);
      String userRoleTypeCode = (String) httpRequest.getSession().getAttribute("roleTypeCode");
      int taskId = Integer.parseInt(emptyToValue(httpRequest.getParameter("taskId"), "0"));
      //
      Map<String,Object> mapDropTask = new HashMap();
      if(userRoleTypeCode.equals("C")) {
        int parentUserId = (Integer) httpRequest.getSession().getAttribute("userId");
        if(startDate.equals(basicDate) && endDate.equals(basicEndDate) && taskId == 0) {
          mapDropTask.put("content", mtaServ.getByPageParentUserAndTaskStatusList(parentUserId, taskStatusArr, pageNo));
          mapDropTask.put("count", mtaServ.countByParentUserAndTaskStatusList(parentUserId, taskStatusArr));
        } else {
          mapDropTask.put("content", mtaServ.getByPageParentUserOrderDateTaskStatusListAndTask(
                  parentUserId, startDate, endDate, taskStatusArr, taskId, pageNo));
          mapDropTask.put("count", mtaServ.countByParentUserOrderDateTaskStatusListAndTask(parentUserId, startDate, endDate, taskStatusArr, taskId));
        }
      } else {
        int coyId = (Integer) httpRequest.getSession().getAttribute("coyId");
        if(startDate.equals(basicDate) && endDate.equals(basicEndDate) && taskId == 0) {
          mapDropTask.put("content", mtaServ.getByPageCoyAndTaskStatusList(coyId, taskStatusArr, pageNo));
          mapDropTask.put("count", mtaServ.countByCoyAndTaskStatusList(coyId, taskStatusArr));
        } else {
          mapDropTask.put("content", mtaServ.getByPageCoyOrderDateTaskStatusListAndTask(
                  coyId, startDate, endDate, taskStatusArr, taskId, pageNo));
          mapDropTask.put("count", mtaServ.countByCoyOrderDateTaskStatusListAndTask(coyId, startDate, endDate, taskStatusArr, taskId));
        }
      }
      return mapDropTask;
  }

 /**
  * Generate mobile dashboard monitor data
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of monitor data contents of the given page, and count of them by the finding parameters
  */
    @RequestMapping(value = "/dashmon/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getMobileDashboardMonitor(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get mobile dashboard monitor data");
      //
      int coordId = Integer.parseInt(httpRequest.getParameter("coordinatorId"));
      //
      Map<String,Object> mapDashMon = new HashMap();
      if(coordId == 0) {
        mapDashMon.put("content", new ArrayList());
        mapDashMon.put("count", 0);
      } else {
        mapDashMon.put("content", dmvServ.getByParentUser(coordId));
        mapDashMon.put("count", 1);
      }
      return mapDashMon;
  }

 /**
  * Generate mobile location tracking data
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of location tracking contents of the given page, and count of them by the finding parameters
  */
    @RequestMapping(value = "/loctrack/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getMobileLocationTracking(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get mobile location tracking data");
      //
      int verifId = Integer.parseInt(httpRequest.getParameter("verificatorId"));
      String startDate = emptyToValue(httpRequest.getParameter("startDate"),basicDate);
      String endDate = emptyToValue(httpRequest.getParameter("endDate"),basicEndDate);
      String isGps = httpRequest.getParameter("isGps");
      //
      Map<String,Object> mapLocTrack = new HashMap();
      if(verifId == 0) {
        mapLocTrack.put("content", new ArrayList());
        mapLocTrack.put("count", 0);
      } else {
        mapLocTrack.put("content", mtrServ.getCoordinateByVerifAssignDateAndGps(verifId, startDate, endDate, isGps));
        mapLocTrack.put("count", 1);
      }
      return mapLocTrack;
  }

  /**
   * Handles report monitoring download request
   * @param httpRequest 
   * @return download status
   */
  @RequestMapping(value = "/repmon/download/request", method = RequestMethod.POST)
  public @ResponseBody StringBean processDownloadReportMonitoring(HttpServletRequest httpRequest) {
    logger.debug("Received request to process report monitoring file");   
    //return object
    StringBean sb = new StringBean();
    sb.setId(0);
    sb.setVal("SUCCESS");
    //request parameter
    int officeId = Integer.parseInt(httpRequest.getParameter("officeId"));
    String fileType = httpRequest.getParameter("fileType");
    MasterUser user = muServ.getById((Integer) httpRequest.getSession().getAttribute("userId"));
    MasterOffice office = moServ.getById(officeId);
    if(office == null)
      office = user.getOffice();
    String textDelimiter = httpRequest.getParameter("textDelimiter");
    String roleTypeCode = (String) httpRequest.getSession().getAttribute("roleTypeCode");
    
    //read data and rewrite it into downloadable file
    //titles
    List<String> titles = new ArrayList();
    titles.add("Office: " + office.getOfficeName());
    titles.add("Coordinator: " + (roleTypeCode.equals("C") ? user.getUserName() : "ALL"));
    Date processDate = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String processDateStr = simpleDateFormat.format(processDate);
    titles.add("Process Date: " + processDateStr);
    //headers
    String[] hdrArr = {"User Code","User Name","Order No","Assignment Date","Retrieve Date","Submit Date","Task Status"};
    List<String> headers = Arrays.asList(hdrArr);
    //contents
    
    List<List<String>> contents = new ArrayList();
    List<MobileTaskAssignment> taskList = roleTypeCode.equals("C") ? mtaServ.getByParentUserAndActive(user.getUserId()) : mtaServ.getByOfficeAndRole(officeId, "V");
    for(MobileTaskAssignment task : taskList) {
      List<String> content = new ArrayList();
      content.add(task.getUser().getUserCode());
      content.add(task.getUser().getUserName());
      content.add(task.getOrderId());
      content.add(task.getAssignmentDate()+"");
      content.add(task.getRetrieveDate()+"");
      content.add(task.getSubmitDate()+"");
      content.add(task.getTaskStatus().getTaskStatusCode());
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
    fileName = "report_monitoring_" + office.getOfficeCode() + "_" + (roleTypeCode.equals("C") ? user.getUserCode() : "all") + "_" + processDateStr.replaceAll("-", "_") + fileExt;
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
   * Handles report monitoring download file
   * @param httpResponse 
   */
  @RequestMapping(value = "/repmon/download", method = RequestMethod.GET)
  public void downloadReportMonitoring(HttpServletResponse httpResponse) {
    logger.debug("Received request to download report monitoring file");   
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
  * Generate report monitoring data
  *
   * @param pageNo, page number
  * @param httpRequest
  * @return list of reports contents of the given page, and count of them by the finding parameters
  */
    @RequestMapping(value = "/repmon/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getReportMonitoring(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get report monitoring data");
      Map<String,Object> mapRepMon = new HashMap();
      //
      if(((String) httpRequest.getSession().getAttribute("roleTypeCode")).equals("C")) {        
        mapRepMon.put("content", mtaServ.getByParentUserAndActive((Integer) httpRequest.getSession().getAttribute("userId")));
        mapRepMon.put("count", 1);
        return mapRepMon;
      }
      //
      String roleTypeCode = "V";
      int officeId = Integer.parseInt(httpRequest.getParameter("officeId"));
      //
      if(officeId == 0) {
        mapRepMon.put("content", new ArrayList());
        mapRepMon.put("count", 0);
      } else {
        mapRepMon.put("content", mtaServ.getByOfficeAndRole(officeId, roleTypeCode));
        mapRepMon.put("count", 1);
      }
      return mapRepMon;
  }

 /**
  * Generate all reason type data
  *
  * @return list of all reason types
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
  * @return list of all task status
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
  * @return company logo by given id
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
 
  /**
   * Check current user is a coordinator
   * @param httpRequest
   * @return coordinator flag, true or false
   */
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
  
  /**
   * Generate current session
   * @param httpRequest
   * @return current session id
   */
  @RequestMapping(value = "/currentsession", method = RequestMethod.GET)
  public @ResponseBody String getCurrentSession(HttpServletRequest httpRequest) {
    logger.debug("Received request to get current session");
    return httpRequest.getSession().getId();
  }
  
  //set response no cache
  //applicable on rapid data change
  private void setNoCache(HttpServletResponse httpResponse) {
    httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    httpResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    httpResponse.setDateHeader("Expires", 0); // Proxies    
  }
  
  //check current connected user is an owner
  private boolean isOwner(int userId) {        
    List<MasterRole> roles = mrServ.getRolesByUser(userId);
    for(MasterRole role : roles) {
      if(role.getRoleType() != null && role.getRoleType().getRoleTypeCode().equals("O"))
        return true;
    }
    return false;
  }
  
  //convert empty value to default
  private String emptyToValue(String valueToBeChecked, String valueIfNull) {
    if(valueToBeChecked == null || valueToBeChecked.equals(""))
      return valueIfNull;
    return valueToBeChecked;
  }

}
