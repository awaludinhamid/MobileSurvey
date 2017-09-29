/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.controller;

import id.co.sim.mobsur.bean.DetailCompanyLogo;
import id.co.sim.mobsur.bean.DetailQuestionGroup;
import id.co.sim.mobsur.bean.DetailTemplate;
import id.co.sim.mobsur.bean.MasterAbsence;
import id.co.sim.mobsur.bean.MasterCity;
import id.co.sim.mobsur.bean.MasterCompany;
import id.co.sim.mobsur.bean.MasterDistribution;
import id.co.sim.mobsur.bean.MasterHierarchy;
import id.co.sim.mobsur.bean.MasterJobAssignment;
import id.co.sim.mobsur.bean.MasterKecamatan;
import id.co.sim.mobsur.bean.MasterKelurahan;
import id.co.sim.mobsur.bean.MasterMenu;
import id.co.sim.mobsur.bean.MasterOffice;
import id.co.sim.mobsur.bean.MasterParameter;
import id.co.sim.mobsur.bean.MasterProduct;
import id.co.sim.mobsur.bean.MasterProvinsi;
import id.co.sim.mobsur.bean.MasterQuestion;
import id.co.sim.mobsur.bean.MasterQuestionGroup;
import id.co.sim.mobsur.bean.MasterRole;
import id.co.sim.mobsur.bean.MasterRoleMenu;
import id.co.sim.mobsur.bean.MasterTaskStatus;
import id.co.sim.mobsur.bean.MasterTemplate;
import id.co.sim.mobsur.bean.MasterUser;
import id.co.sim.mobsur.bean.MasterUserRole;
import id.co.sim.mobsur.bean.MasterZipcode;
import id.co.sim.mobsur.bean.MasterZipcodeVerificator;
import id.co.sim.mobsur.bean.MobileTaskAssignment;
import id.co.sim.mobsur.bean.MobileTaskResultDetailList;
import id.co.sim.mobsur.bean.dto.DetailQuestionGroupDTO;
import id.co.sim.mobsur.bean.dto.DetailTemplateDTO;
import id.co.sim.mobsur.bean.dto.MasterAbsenceDTO;
import id.co.sim.mobsur.bean.dto.MasterCityDTO;
import id.co.sim.mobsur.bean.dto.MasterCompanyDTO;
import id.co.sim.mobsur.bean.dto.MasterDistributionDTO;
import id.co.sim.mobsur.bean.dto.MasterHierarchyDTO;
import id.co.sim.mobsur.bean.dto.MasterJobAssignmentDTO;
import id.co.sim.mobsur.bean.dto.MasterKecamatanDTO;
import id.co.sim.mobsur.bean.dto.MasterKelurahanDTO;
import id.co.sim.mobsur.bean.dto.MasterMenuDTO;
import id.co.sim.mobsur.bean.dto.MasterOfficeDTO;
import id.co.sim.mobsur.bean.dto.MasterParameterDTO;
import id.co.sim.mobsur.bean.dto.MasterProductDTO;
import id.co.sim.mobsur.bean.dto.MasterQuestionDTO;
import id.co.sim.mobsur.bean.dto.MasterQuestionGroupDTO;
import id.co.sim.mobsur.bean.dto.MasterRoleMenuDTO;
import id.co.sim.mobsur.bean.dto.MasterRoleDTO;
import id.co.sim.mobsur.bean.dto.MasterTemplateDTO;
import id.co.sim.mobsur.bean.dto.MasterUserRoleDTO;
import id.co.sim.mobsur.bean.dto.MasterUserDTO;
import id.co.sim.mobsur.bean.dto.MasterZipcodeDTO;
import id.co.sim.mobsur.bean.dto.MasterZipcodeVerificatorDTO;
import id.co.sim.mobsur.bean.dto.MobileTaskAssignmentDTO;
import id.co.sim.mobsur.bean.dto.MobileTaskResultDetailListDTO;
import id.co.sim.mobsur.bean.dto.support.MasterJobAssignmentDTOList;
import id.co.sim.mobsur.bean.dto.support.MobileTaskAssignmentDTOList;
import id.co.sim.mobsur.bean.dto.support.MobileTaskResultDetailListDTOList;
import id.co.sim.mobsur.service.DetailCompanyLogoService;
import id.co.sim.mobsur.service.DetailQuestionGroupService;
import id.co.sim.mobsur.service.DetailTemplateService;
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
import id.co.sim.mobsur.service.MasterRoleService;
import id.co.sim.mobsur.service.MasterRoleTypeService;
import id.co.sim.mobsur.service.MasterTaskStatusService;
import id.co.sim.mobsur.service.MasterTemplateService;
import id.co.sim.mobsur.service.MasterUserRoleService;
import id.co.sim.mobsur.service.MasterUserService;
import id.co.sim.mobsur.service.MasterZipcodeService;
import id.co.sim.mobsur.service.MasterZipcodeVerificatorService;
import id.co.sim.mobsur.service.MobileTaskAssignmentService;
import id.co.sim.mobsur.service.MobileTaskResultDetailListService;
import id.co.sim.mobsur.service.MobileTaskResultDetailService;
import id.co.sim.mobsur.service.MobileTaskResultImageService;
import id.co.sim.mobsur.util.SupportUtil;
import id.co.sim.mobsur.util.file.ReadExcel;
import id.co.sim.mobsur.util.file.ReadText;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Save (insert/update/delete) process controller
 * @created Oct 23, 2016
 * @author awal
 */
@Controller
@RequestMapping("/save")
public class SaveController {
 
 // Service injection list
  @Autowired
  private DetailCompanyLogoService dclServ;
  @Autowired
  private DetailQuestionGroupService dqgServ;
  @Autowired
  private DetailTemplateService dtServ;
  @Autowired
  private MasterAbsenceService maServ;
  @Autowired
  private MasterAnswerTypeService matServ;
  @Autowired
  private MasterCityService mciServ;
  @Autowired
  private MasterCompanyService mcServ;
  @Autowired
  private MasterDistributionService mdServ;
  @Autowired
  private MasterHierarchyService mhServ;
  @Autowired
  private MasterKecamatanService mkServ;
  @Autowired
  private MasterKelurahanService mklServ;
  @Autowired
  private MasterMenuService mmServ;
  @Autowired
  private MasterOfficeService moServ;
  @Autowired
  private MasterOptionAnswerService moaServ;
  @Autowired
  private MasterParameterService mpServ;
  @Autowired
  private MasterParentParameterService mppServ;
  @Autowired
  private MasterParentMenuService mpmServ;
  @Autowired
  private MasterProvinsiService mprServ;
  @Autowired
  private MasterReasonTypeService mrtServ;
  @Autowired
  private MasterQuestionService mqServ;
  @Autowired
  private MasterRoleService mrServ;
  @Autowired
  private MasterRoleMenuService mrmServ;
  @Autowired
  private MasterRoleTypeService mrlServ;
  @Autowired
  private MasterTaskStatusService mtsServ;
  @Autowired
  private MasterUserService muServ;
  @Autowired
  private MasterUserRoleService murServ;
  @Autowired
  private MasterZipcodeService mzServ;
  @Autowired
  private MasterQuestionGroupService mqgServ;
  @Autowired
  private MasterTemplateService mtServ;
  @Autowired
  private MasterProductService mpdServ;
  @Autowired
  private MasterJobAssignmentService mjaServ;
  @Autowired
  private MasterZipcodeVerificatorService mzvServ;
  @Autowired
  private MobileTaskAssignmentService mtaServ;
  @Autowired
  private MobileTaskResultDetailService mtrdServ;
  @Autowired
  private MobileTaskResultDetailListService mtrdlServ;
  @Autowired
  private MobileTaskResultImageService mtriServ;

  private final Logger logger = Logger.getLogger("controller");
  private final int numOfBulkRecord = 100; //set the bulk here to minimize extra process for it is change occasionally

  /**
   * Save given company
   * @param companyDTO
   * @param session, http session object
   * @return saved company
   */
  @RequestMapping(value = "/company", method = RequestMethod.POST)
  public @ResponseBody MasterCompanyDTO saveCompany(
          @RequestBody MasterCompanyDTO companyDTO,
          HttpSession session
          )
  {
    //current logged user
    String username = (String) session.getAttribute("userName");
    //
    DetailCompanyLogo dcl;
    //check if the process is update or insert
    //transfer data from DTO to POJO
    if(companyDTO.getCoyId() == 0) {
      companyDTO.setCreatedBy(username);
      dcl = dclServ.save(new DetailCompanyLogo());
    } else {
      dcl = dclServ.getById(companyDTO.getCompanyLogoId());
    }
    companyDTO.setUpdatedBy(username);
    companyDTO.setCompanyLogoId(dcl.getCompanyLogoId());
    MasterCompany company = new MasterCompany();
    BeanUtils.copyProperties(companyDTO, company);
    company.setDetailCompanyLogo(dcl);
    mcServ.save(company);
    return companyDTO;
  }

  /**
   * Disable given company
   * @param companyDTO
   * @param session, http session object
   * @return disabled company
   */
  @RequestMapping(value = "/company/disable", method = RequestMethod.POST)
  public @ResponseBody MasterCompanyDTO disCompany(
          @RequestBody MasterCompanyDTO companyDTO,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    //
    MasterCompany company = mcServ.getById(companyDTO.getCoyId());
    //disable record
    company.setEndDate(getYesterday());
    company.setUpdatedBy(username);
    mcServ.save(company);
    return companyDTO;
  }

  /**
   * Save company logo process
   * @param imageFile
   * @param companyLogoId
   * @return saved status
   */
  @RequestMapping(value = "/company/file", method = RequestMethod.POST)
  public @ResponseBody String saveCompanyLogo(
          @RequestParam("companylogo") MultipartFile imageFile,
          @RequestParam("companyLogoId") int companyLogoId
          )
  {
    //
    if(!imageFile.isEmpty()) {
      try{
        DetailCompanyLogo dcl = dclServ.getById(companyLogoId);
        byte[] logoPicture = imageFile.getBytes();
        dcl.setLogoPicture(logoPicture);
        dclServ.save(dcl);
      } catch(IOException iox) {
        logger.error(iox);
        return "error";
      }
    }
    return "ok";
  }

  /**
   * Save given menu
   * @param menuDTO
   * @param session, http session object
   * @return saved menu
   */
  @RequestMapping(value = "/menu", method = RequestMethod.POST)
  public @ResponseBody MasterMenuDTO saveMenu(
          @RequestBody MasterMenuDTO menuDTO,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(menuDTO.getMenuId() == 0) {
      menuDTO.setCreatedBy(username);
    }
    menuDTO.setUpdatedBy(username);
    MasterMenu menu = new MasterMenu();
    BeanUtils.copyProperties(menuDTO, menu);
    menu.setParentMenu(mpmServ.getById(menuDTO.getParentMenuId()));
    mmServ.save(menu);
    return menuDTO;
  }

  /**
   * Disable given menu
   * @param menuDTO
   * @param session, http session object
   * @return disabled menu
   */
  @RequestMapping(value = "/menu/disable", method = RequestMethod.POST)
  public @ResponseBody MasterMenuDTO disMenu(
          @RequestBody MasterMenuDTO menuDTO,
          HttpSession session
          )
  {
    if(mrmServ.countByMenu(menuDTO.getMenuId()) > 0)
      return null;
    String username = (String) session.getAttribute("userName");
    MasterMenu menu = mmServ.getById(menuDTO.getMenuId());
    menu.setEndDate(getYesterday());
    menu.setUpdatedBy(username);
    mmServ.save(menu);
    return menuDTO;
  }

  /**
   * Save given role
   * @param roleDTO
   * @param session, http session object
   * @return saved role
   */
  @RequestMapping(value = "/role", method = RequestMethod.POST)
  public @ResponseBody MasterRoleDTO saveRole(
          @RequestBody MasterRoleDTO roleDTO,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(roleDTO.getRoleId() == 0) {
      roleDTO.setCreatedBy(username);
    } 
    roleDTO.setUpdatedBy(username);
    MasterRole role = new MasterRole();
    BeanUtils.copyProperties(roleDTO, role);
    role.setRoleType(mrlServ.getById(roleDTO.getRoleTypeId()));
    mrServ.save(role);
    return roleDTO;
  }

  /**
   * Disable given role
   * @param roleDTO
   * @param session, http session object
   * @return disabled role
   */
  @RequestMapping(value = "/role/disable", method = RequestMethod.POST)
  public @ResponseBody MasterRoleDTO disRole(
          @RequestBody MasterRoleDTO roleDTO,
          HttpSession session
          )
  {
    if(mrmServ.countByRole(roleDTO.getRoleId()) > 0 || murServ.countByRole(roleDTO.getRoleId()) > 0)
      return null;
    String username = (String) session.getAttribute("userName");
    MasterRole role = mrServ.getById(roleDTO.getRoleId());
    role.setUpdatedBy(username);
    role.setEndDate(getYesterday());
    mrServ.save(role);
    return roleDTO;
  }

  /**
   * Save given office
   * @param officeDTO
   * @param session, http session object
   * @return saved office
   */
  @RequestMapping(value = "/office", method = RequestMethod.POST)
  public @ResponseBody MasterOfficeDTO saveOffice(
          @RequestBody MasterOfficeDTO officeDTO,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(officeDTO.getOfficeId() == 0) {
      officeDTO.setCreatedBy(username);
      officeDTO.setCoyId((Integer) session.getAttribute("coyId"));
    }
    officeDTO.setUpdatedBy(username);
    MasterOffice office = new MasterOffice();
    BeanUtils.copyProperties(officeDTO, office);
    office.setCompany(mcServ.getById(officeDTO.getCoyId()));
    moServ.save(office);
    return officeDTO;
  }

  /**
   * Disable given office
   * @param officeDTO
   * @param session, http session object
   * @return disabled office
   */
  @RequestMapping(value = "/office/disable", method = RequestMethod.POST)
  public @ResponseBody MasterOfficeDTO disOffice(
          @RequestBody MasterOfficeDTO officeDTO,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    MasterOffice office = moServ.getById(officeDTO.getOfficeId());
    office.setEndDate(getYesterday());
    office.setUpdatedBy(username);
    office = moServ.save(office);
    //disable user
    for(MasterUser user : muServ.getByOffice(office.getOfficeId())) {
      user.setEndDate(getYesterday());
      user.setUpdatedBy(username);
      muServ.save(user);
    }
    return officeDTO;
  }

  /**
   * Save given user
   * @param userDTO
   * @param session, http session object
   * @return saved user
   */
  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public @ResponseBody MasterUserDTO saveUser(
          @RequestBody MasterUserDTO userDTO,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(userDTO.getUserId() == 0) {
      userDTO.setCreatedBy(username);      
      userDTO.setUserPassword(SupportUtil.getMd5Hash(userDTO.getUserPassword()));
    }
    userDTO.setUpdatedBy(username);
    MasterUser user = new MasterUser();
    user.setOffice(moServ.getById(userDTO.getOfficeId()));
    BeanUtils.copyProperties(userDTO, user);
    muServ.save(user);
    return userDTO;
  }

  /**
   * Disable given user
   * @param userDTO
   * @param session, http session object
   * @return disabled user
   */
  @RequestMapping(value = "/user/disable", method = RequestMethod.POST)
  public @ResponseBody MasterUserDTO disUser(
          @RequestBody MasterUserDTO userDTO,
          HttpSession session
          )
  {
    if(murServ.countByUser(userDTO.getUserId()) > 0)
      return null;
    String username = (String) session.getAttribute("userName");
    MasterUser user = muServ.getById(userDTO.getUserId());
    user.setEndDate(getYesterday());
    user.setUpdatedBy(username);
    muServ.save(user);
    return userDTO;
  }

  /**
   * Save given userrole
   * @param userRoleDTO
   * @param session, http session object
   * @return saved userrole
   */
  @RequestMapping(value = "/userrole", method = RequestMethod.POST)
  public @ResponseBody MasterUserRoleDTO saveUserRole(
          @RequestBody MasterUserRoleDTO userRoleDTO,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    MasterUserRole userRole = new MasterUserRole();
    if(userRoleDTO.getUserRoleId() == 0) {
      userRoleDTO.setCreatedBy(username);      
    } else {
      userRole = murServ.getById(userRoleDTO.getUserRoleId());
    }
    userRoleDTO.setUpdatedBy(username);
    BeanUtils.copyProperties(userRoleDTO, userRole);
    userRole.setUser(muServ.getById(userRoleDTO.getUserId()));
    userRole.setRole(mrServ.getById(userRoleDTO.getRoleId()));
    murServ.save(userRole);
    return userRoleDTO;
  }

  /**
   * Disable given userrole
   * @param userRoleDTO
   * @param session, http session object
   * @return disabled userrole
   */
  @RequestMapping(value = "/userrole/disable", method = RequestMethod.POST)
  public @ResponseBody MasterUserRoleDTO disUserRole(
          @RequestBody MasterUserRoleDTO userRoleDTO,
          HttpSession session
          )
  {
    MasterUserRole userRole = murServ.getById(userRoleDTO.getUserRoleId());
    murServ.delete(userRole);
    return userRoleDTO;
  }

  /**
   * Save given rolemenu
   * @param roleMenuDTO
   * @param session, http session object
   * @return saved rolemenu
   */
  @RequestMapping(value = "/rolemenu", method = RequestMethod.POST)
  public @ResponseBody MasterRoleMenuDTO saveRoleMenu(
          @RequestBody MasterRoleMenuDTO roleMenuDTO,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    MasterRoleMenu roleMenu = new MasterRoleMenu();
    if(roleMenuDTO.getRoleMenuId() == 0) {
      roleMenuDTO.setCreatedBy(username);      
    } else {
      roleMenu = mrmServ.getById(roleMenuDTO.getRoleMenuId());
    }
    roleMenuDTO.setUpdatedBy(username);
    BeanUtils.copyProperties(roleMenuDTO, roleMenu);
    roleMenu.setRole(mrServ.getById(roleMenuDTO.getRoleId()));
    roleMenu.setMenu(mmServ.getById(roleMenuDTO.getMenuId()));
    mrmServ.save(roleMenu);
    return roleMenuDTO;
  }

  /**
   * Disable given rolemenu
   * @param roleMenuDTO
   * @param session, http session object
   * @return disabled rolemenu
   */
  @RequestMapping(value = "/rolemenu/disable", method = RequestMethod.POST)
  public @ResponseBody MasterRoleMenuDTO disRoleMenu(
          @RequestBody MasterRoleMenuDTO roleMenuDTO,
          HttpSession session
          )
  {
    MasterRoleMenu roleMenu = mrmServ.getById(roleMenuDTO.getRoleMenuId());
    if(roleMenu != null)
      mrmServ.delete(roleMenu);
    return roleMenuDTO;
  }

  /**
   * Save given zipcode
   * @param zipcodeDTO
   * @param session, http session object
   * @return saved zipcode
   */
  @RequestMapping(value = "/zipcode", method = RequestMethod.POST)
  public @ResponseBody MasterZipcodeDTO saveZipcode(
          @RequestBody MasterZipcodeDTO zipcodeDTO,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(zipcodeDTO.getZipcodeId() == 0) {
      zipcodeDTO.setCreatedBy(username);      
    }
    zipcodeDTO.setUpdatedBy(username);
    MasterZipcode zipcode = new MasterZipcode();
    BeanUtils.copyProperties(zipcodeDTO, zipcode);
    zipcode.setCity(mciServ.getById(zipcodeDTO.getCityId()));
    mzServ.save(zipcode);
    return zipcodeDTO;
  }

  /**
   * Disable given zipcode
   * @param zipcodeDTO
   * @param session, http session object
   * @return disabled zipcode
   */
  @RequestMapping(value = "/zipcode/disable", method = RequestMethod.POST)
  public @ResponseBody MasterZipcodeDTO disZipcode(
          @RequestBody MasterZipcodeDTO zipcodeDTO,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    MasterZipcode zipcode = mzServ.getById(zipcodeDTO.getZipcodeId());
    zipcode.setEndDate(getYesterday());
    zipcode.setUpdatedBy(username);
    mzServ.save(zipcode);
    return zipcodeDTO;
  }

  /**
   * Save given parameter
   * @param paramDTO
   * @param session, http session object
   * @return saved parameter
   */
  @RequestMapping(value = "/parameter", method = RequestMethod.POST)
  public @ResponseBody MasterParameterDTO saveParameter(
          @RequestBody MasterParameterDTO paramDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    if(paramDTO.getParId() == 0) {
      paramDTO.setCreatedBy(username);
      paramDTO.setCoyId((Integer) session.getAttribute("coyId"));
    }
    paramDTO.setUpdatedBy(username);
    MasterParameter param = new MasterParameter();
    BeanUtils.copyProperties(paramDTO, param);
    param.setCompany(mcServ.getById(paramDTO.getCoyId()));
    param.setParentParameter(mppServ.getById(paramDTO.getParentParId()));
    mpServ.save(param);
    return paramDTO;
  }

  /**
   * Disable given parameter
   * @param paramDTO
   * @param session, http session object
   * @return disabled parameter
   */
  @RequestMapping(value = "/parameter/disable", method = RequestMethod.POST)
  public @ResponseBody MasterParameterDTO disParameter(
          @RequestBody MasterParameterDTO paramDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    MasterParameter param = mpServ.getById(paramDTO.getParId());
    param.setEndDate(getYesterday());
    param.setUpdatedBy(username);
    mpServ.save(param);
    return paramDTO;
  }

  /**
   * Save given hierarchy
   * @param hieDTO
   * @param session, http session object
   * @return saved hierarchy
   */
  @RequestMapping(value = "/hierarchy", method = RequestMethod.POST)
  public @ResponseBody MasterHierarchyDTO saveHierarchy(
          @RequestBody MasterHierarchyDTO hieDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    if(hieDTO.getHieId() == 0) {
      hieDTO.setCreatedBy(username);
      hieDTO.setCoyId((Integer) session.getAttribute("coyId"));
    }
    hieDTO.setUpdatedBy(username);
    MasterHierarchy hie = new MasterHierarchy();
    BeanUtils.copyProperties(hieDTO, hie);
    hie.setCompany(mcServ.getById(hieDTO.getCoyId()));
    hie.setRole(mrServ.getById(hieDTO.getRoleId()));
    hie.setRoleUp(mrServ.getById(hieDTO.getRoleIdUp()));
    mhServ.save(hie);
    return hieDTO;
  }

  /**
   * Disable given hierarchy
   * @param hieDTO
   * @param session, http session object
   * @return disabled hierarchy
   */
  @RequestMapping(value = "/hierarchy/disable", method = RequestMethod.POST)
  public @ResponseBody MasterHierarchyDTO disHierarchy(
          @RequestBody MasterHierarchyDTO hieDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    MasterHierarchy hie = mhServ.getById(hieDTO.getHieId());
    hie.setEndDate(getYesterday());
    hie.setUpdatedBy(username);
    mhServ.save(hie);
    return hieDTO;
  }

  /**
   * Save given distribution
   * @param distDTO
   * @param session, http session object
   * @return saved distribution
   */
  @RequestMapping(value = "/distribution", method = RequestMethod.POST)
  public @ResponseBody MasterDistributionDTO saveDistribution(
          @RequestBody MasterDistributionDTO distDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    if(distDTO.getDistId() == 0) {
      distDTO.setCreatedBy(username);
    }
    distDTO.setUpdatedBy(username);
    MasterDistribution dist = new MasterDistribution();
    BeanUtils.copyProperties(distDTO, dist);
    dist.setOffice(moServ.getById(distDTO.getOfficeId()));
    dist.setRoleAssignTo(mrServ.getById(distDTO.getRoleId()));
    mdServ.save(dist);
    return distDTO;
  }

  /**
   * Disable given distribution
   * @param distDTO
   * @param session, http session object
   * @return disabled distribution
   */
  @RequestMapping(value = "/distribution/disable", method = RequestMethod.POST)
  public @ResponseBody MasterDistributionDTO disDistribution(
          @RequestBody MasterDistributionDTO distDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    MasterDistribution dist = mdServ.getById(distDTO.getDistId());
    dist.setEndDate(getYesterday());
    dist.setUpdatedBy(username);
    mdServ.save(dist);
    return distDTO;
  }

  /**
   * Save given provinsi
   * @param prov
   * @param session, http session object
   * @return saved provinsi
   */
  @RequestMapping(value = "/provinsi", method = RequestMethod.POST)
  public @ResponseBody MasterProvinsi saveProvinsi(
          @RequestBody MasterProvinsi prov,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    if(prov.getProvId() == 0) {
      prov.setCreatedBy(username);
    }
    prov.setUpdatedBy(username);
    mprServ.save(prov);
    return prov;
  }

  /**
   * Disable given provinsi
   * @param prov
   * @param session, http session object
   * @return disabled provinsi
   */
  @RequestMapping(value = "/provinsi/disable", method = RequestMethod.POST)
  public @ResponseBody MasterProvinsi disProvinsi(
          @RequestBody MasterProvinsi prov,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    prov = mprServ.getById(prov.getProvId());
    prov.setEndDate(getYesterday());
    prov.setUpdatedBy(username);
    mprServ.save(prov);
    return prov;
  }

  /**
   * Save given city
   * @param cityDTO
   * @param session, http session object
   * @return saved city
   */
  @RequestMapping(value = "/city", method = RequestMethod.POST)
  public @ResponseBody MasterCityDTO saveCity(
          @RequestBody MasterCityDTO cityDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    if(cityDTO.getCityId() == 0) {
      cityDTO.setCreatedBy(username);
    }
    cityDTO.setUpdatedBy(username);
    MasterCity city = new MasterCity();
    BeanUtils.copyProperties(cityDTO, city);
    city.setProvinsi(mprServ.getById(cityDTO.getProvId()));
    mciServ.save(city);
    return cityDTO;
  }

  /**
   * Disable given city
   * @param cityDTO
   * @param session, http session object
   * @return disabled city
   */
  @RequestMapping(value = "/city/disable", method = RequestMethod.POST)
  public @ResponseBody MasterCityDTO disCity(
          @RequestBody MasterCityDTO cityDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    MasterCity city = mciServ.getById(cityDTO.getCityId());
    city.setEndDate(getYesterday());
    city.setUpdatedBy(username);
    mciServ.save(city);
    return cityDTO;
  }

  /**
   * Save given kecamatan
   * @param kecDTO
   * @param session, http session object
   * @return saved kecamatan
   */
  @RequestMapping(value = "/kecamatan", method = RequestMethod.POST)
  public @ResponseBody MasterKecamatanDTO saveKecamatan(
          @RequestBody MasterKecamatanDTO kecDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    if(kecDTO.getKecId() == 0) {
      kecDTO.setCreatedBy(username);
    }
    kecDTO.setUpdatedBy(username);
    MasterKecamatan kec = new MasterKecamatan();
    BeanUtils.copyProperties(kecDTO, kec);
    kec.setCity(mciServ.getById(kecDTO.getCityId()));
    mkServ.save(kec);
    return kecDTO;
  }

  /**
   * Disable given kecamatan
   * @param kecDTO
   * @param session, http session object
   * @return disabled kecamatan
   */
  @RequestMapping(value = "/kecamatan/disable", method = RequestMethod.POST)
  public @ResponseBody MasterKecamatanDTO disKecamatan(
          @RequestBody MasterKecamatanDTO kecDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    MasterKecamatan kec = mkServ.getById(kecDTO.getKecId());
    kec.setEndDate(getYesterday());
    kec.setUpdatedBy(username);
    mkServ.save(kec);
    return kecDTO;
  }

  /**
   * Save given kelurahan
   * @param kelDTO
   * @param session, http session object
   * @return saved kelurahan
   */
  @RequestMapping(value = "/kelurahan", method = RequestMethod.POST)
  public @ResponseBody MasterKelurahanDTO saveKelurahan(
          @RequestBody MasterKelurahanDTO kelDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    if(kelDTO.getKelId() == 0) {
      kelDTO.setCreatedBy(username);
    }
    kelDTO.setUpdatedBy(username);
    MasterKelurahan kel = new MasterKelurahan();
    BeanUtils.copyProperties(kelDTO, kel);
    kel.setKecamatan(mkServ.getById(kelDTO.getKecId()));
    if(kelDTO.getZipcodeId() != null)
      kel.setZipcode(mzServ.getById(kelDTO.getZipcodeId()));
    mklServ.save(kel);
    return kelDTO;
  }

  /**
   * Disable given kelurahan
   * @param kelDTO
   * @param session, http session object
   * @return disabled kelurahan
   */
  @RequestMapping(value = "/kelurahan/disable", method = RequestMethod.POST)
  public @ResponseBody MasterKelurahanDTO disKelurahan(
          @RequestBody MasterKelurahanDTO kelDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    MasterKelurahan kel = mklServ.getById(kelDTO.getKelId());
    kel.setEndDate(getYesterday());
    kel.setUpdatedBy(username);
    mklServ.save(kel);
    return kelDTO;
  }

  /**
   * Save given question
   * @param questDTO
   * @param session, http session object
   * @return saved question
   */
  @RequestMapping(value = "/question", method = RequestMethod.POST)
  public @ResponseBody MasterQuestionDTO saveQuestion(
          @RequestBody MasterQuestionDTO questDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    if(questDTO.getQuestId() == 0) {
      questDTO.setCreatedBy(username);
      questDTO.setCoyId((Integer) session.getAttribute("coyId"));
    }
    questDTO.setUpdatedBy(username);
    MasterQuestion quest = new MasterQuestion();
    BeanUtils.copyProperties(questDTO, quest);
    quest.setCompany(mcServ.getById(questDTO.getCoyId()));
    quest.setAnswerType(matServ.getById(questDTO.getAnswerTypeId()));
    quest.setOptionAnswer(moaServ.getById(questDTO.getOptionAnswerId()));
    mqServ.save(quest);
    return questDTO;
  }

  /**
   * Disable given question
   * @param questDTO
   * @param session, http session object
   * @return disabled question
   */
  @RequestMapping(value = "/question/disable", method = RequestMethod.POST)
  public @ResponseBody MasterQuestionDTO disQuestion(
          @RequestBody MasterQuestionDTO questDTO,
          HttpSession session
          )
  {
    if(dqgServ.countByQuest(questDTO.getQuestId()) > 0)
      return null;
    String username = (String) session.getAttribute("userName");
    MasterQuestion quest = mqServ.getById(questDTO.getQuestId());
    quest.setEndDate(getYesterday());
    quest.setUpdatedBy(username);
    quest = mqServ.save(quest);
    //delete relation on disable
    //remarked for change decision
    /*for(DetailQuestionGroup dqgr : dqgServ.getByQuest(quest.getQuestId())) {
      MasterQuestionGroup mqgr = dqgr.getQuestionGroup();
      Set<DetailQuestionGroup> dqgrSet = mqgr.getDetailQuestionGroups();
      for(DetailQuestionGroup dqgrTmp : dqgrSet) {
        if(dqgr.getDetailQuestGroupId() == dqgrTmp.getDetailQuestGroupId()) {
          dqgrSet.remove(dqgrTmp);
          break;
        }
      }
      mqgServ.save(mqgr);
    }*/
    return questDTO;
  }

  /**
   * Save given questiongroup
   * @param questGroupDTO
   * @param session, http session object
   * @return saved questiongroup
   */
  @RequestMapping(value = "/questiongroup", method = RequestMethod.POST)
  public @ResponseBody MasterQuestionGroupDTO saveQuestionGroup(
          @RequestBody MasterQuestionGroupDTO questGroupDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    MasterQuestionGroup questGroup = new MasterQuestionGroup();
    if(questGroupDTO.getQuestGroupId() == 0) {
      questGroupDTO.setCreatedBy(username);
      questGroupDTO.setCoyId((Integer) session.getAttribute("coyId"));
      questGroup.setCompany(mcServ.getById(questGroupDTO.getCoyId()));
    } else {
      questGroup = mqgServ.getById(questGroupDTO.getQuestGroupId());
    }
    questGroupDTO.setUpdatedBy(username);
    //include saving detail
    Set<DetailQuestionGroup> dqgSet = new HashSet();
    for(DetailQuestionGroupDTO detQuestGroupDTO : questGroupDTO.getDetailQuestionGroupDTO()) {
      DetailQuestionGroup detQuestGroup = new DetailQuestionGroup();
      if(detQuestGroupDTO.getDetailQuestGroupId() == 0) {
        detQuestGroupDTO.setCreatedBy(username);
      }
      detQuestGroupDTO.setStartDate(questGroupDTO.getStartDate());
      detQuestGroupDTO.setEndDate(questGroupDTO.getEndDate());
      detQuestGroupDTO.setUpdatedBy(username);
      BeanUtils.copyProperties(detQuestGroupDTO, detQuestGroup);
      detQuestGroup.setQuestion(mqServ.getById(detQuestGroupDTO.getQuestId()));
      detQuestGroup.setQuestionGroup(questGroup);
      dqgSet.add(detQuestGroup);
    }
    //refresh detail list before save
    BeanUtils.copyProperties(questGroupDTO, questGroup);
    Set<DetailQuestionGroup> dqgSetPersist = questGroup.getDetailQuestionGroups();
    if(dqgSetPersist != null) {
      dqgSetPersist.clear();
      for(DetailQuestionGroup dqg : dqgSet)
        dqgSetPersist.add(dqg);
    } else {
      questGroup.setDetailQuestionGroups(dqgSet);
    }
    mqgServ.save(questGroup);
    return questGroupDTO;
  }

  /**
   * Disable given questiongroup
   * @param questGroupDTO
   * @param session, http session object
   * @return disabled questiongroup
   */
  @RequestMapping(value = "/questiongroup/disable", method = RequestMethod.POST)
  public @ResponseBody MasterQuestionGroupDTO disQuestionGroup(
          @RequestBody MasterQuestionGroupDTO questGroupDTO,
          HttpSession session
          )
  {    
    if(dtServ.countByQuestGroup(questGroupDTO.getQuestGroupId()) > 0) //disable if record has no relation only
      return null;
    String username = (String) session.getAttribute("userName");
    MasterQuestionGroup questGroup = mqgServ.getById(questGroupDTO.getQuestGroupId());
    questGroup.setEndDate(getYesterday());
    questGroup.setUpdatedBy(username);
    //
    for(DetailQuestionGroup detQuestGroup : questGroup.getDetailQuestionGroups()) {
      detQuestGroup.setEndDate(getYesterday());
      detQuestGroup.setUpdatedBy(username);
    }
    mqgServ.save(questGroup);
    return questGroupDTO;
  }

  /**
   * Save given template
   * @param tempDTO
   * @param session, http session object
   * @return saved template
   */
  @RequestMapping(value = "/template", method = RequestMethod.POST)
  public @ResponseBody MasterTemplateDTO saveTemplate(
          @RequestBody MasterTemplateDTO tempDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    MasterTemplate temp = new MasterTemplate();
    if(tempDTO.getTempId() == 0) {
      tempDTO.setCreatedBy(username);
      tempDTO.setCoyId((Integer) session.getAttribute("coyId"));
      temp.setCompany(mcServ.getById(tempDTO.getCoyId()));
    } else {
      temp = mtServ.getById(tempDTO.getTempId());
    }
    tempDTO.setUpdatedBy(username);
    //include saving detail
    Set<DetailTemplate> dtSet = new HashSet();
    for(DetailTemplateDTO detTempDTO : tempDTO.getDetailTemplateDTO()) {
      DetailTemplate detTemp = new DetailTemplate();
      if(detTempDTO.getDetailTempId() == 0) {
        detTempDTO.setCreatedBy(username);
      }
      detTempDTO.setStartDate(tempDTO.getStartDate());
      detTempDTO.setEndDate(tempDTO.getEndDate());
      detTempDTO.setUpdatedBy(username);
      BeanUtils.copyProperties(detTempDTO, detTemp);
      detTemp.setQuestionGroup(mqgServ.getById(detTempDTO.getQuestGroupId()));
      detTemp.setTemplate(temp);
      dtSet.add(detTemp);
    }
    //refresh detail list before save
    BeanUtils.copyProperties(tempDTO, temp);
    Set<DetailTemplate> dtSetPersist = temp.getDetailTemplates();
    if(dtSetPersist != null) {
      dtSetPersist.clear();
      for(DetailTemplate dt : dtSet)
        dtSetPersist.add(dt);
    } else {
      temp.setDetailTemplates(dtSet);
    }
    mtServ.save(temp);
    return tempDTO;
  }

  /**
   * Disable given template
   * @param tempDTO
   * @param session, http session object
   * @return disabled template
   */
  @RequestMapping(value = "/template/disable", method = RequestMethod.POST)
  public @ResponseBody MasterTemplateDTO disTemplate(
          @RequestBody MasterTemplateDTO tempDTO,
          HttpSession session
          )
  { 
    if(mpdServ.countByTemplate(tempDTO.getTempId()) > 0)//disable if record has no relation only
      return null;
    String username = (String) session.getAttribute("userName");
    MasterTemplate temp = mtServ.getById(tempDTO.getTempId());
    temp.setEndDate(getYesterday());
    temp.setUpdatedBy(username);
    //
    for(DetailTemplate detTemp : temp.getDetailTemplates()) {
      detTemp.setEndDate(getYesterday());
      detTemp.setUpdatedBy(username);
    }
    mtServ.save(temp);
    return tempDTO;
  }

  /**
   * Save given product
   * @param prodDTO
   * @param session, http session object
   * @return saved product
   */
  @RequestMapping(value = "/product", method = RequestMethod.POST)
  public @ResponseBody MasterProductDTO saveProduct(
          @RequestBody MasterProductDTO prodDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    if(prodDTO.getProductId() == 0) {
      prodDTO.setCreatedBy(username);
    }
    prodDTO.setUpdatedBy(username);
    MasterProduct prod = new MasterProduct();
    BeanUtils.copyProperties(prodDTO, prod);
    prod.setTemplate(mtServ.getById(prodDTO.getTempId()));
    mpdServ.save(prod);
    return prodDTO;
  }

  /**
   * Disable given product
   * @param prodDTO
   * @param session, http session object
   * @return disabled product
   */
  @RequestMapping(value = "/product/disable", method = RequestMethod.POST)
  public @ResponseBody MasterProductDTO disProduct(
          @RequestBody MasterProductDTO prodDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    MasterProduct prod = mpdServ.getById(prodDTO.getProductId());
    prod.setEndDate(getYesterday());
    prod.setUpdatedBy(username);
    mpdServ.save(prod);
    return prodDTO;
  }

  /**
   * Save given job assignment
   * @param jobAssignDTOList
   * @param httpRequest, http request object
   * @return saved job assignment
   */
  @RequestMapping(value = "/jobassignment", method = RequestMethod.POST)
  public @ResponseBody MasterJobAssignmentDTOList saveJobAssignment(
          @RequestBody MasterJobAssignmentDTOList jobAssignDTOList,
          HttpServletRequest httpRequest
          )
  {    
    String username = (String) httpRequest.getSession().getAttribute("userName");
    //who has this data list
    int userCommissionedId = Integer.parseInt(httpRequest.getParameter("userCommissionedId"));
    //job assign list POSTED
    List<MasterJobAssignmentDTO> jobAssignDTOs = jobAssignDTOList.getJobAssignmentDTOList();
    List<Integer> toDeleteList = new ArrayList();
    //job assign list CURRENT (prepare to DELETED)
    for(MasterJobAssignment jobAssign : mjaServ.getByUserCommissioned(userCommissionedId))
      toDeleteList.add(jobAssign.getJobAssignId());
    //check:
    //if record exists in POSTED and not in CURRENT then insert it
    //else remove from DELETED
    for(MasterJobAssignmentDTO jobAssignDTO : jobAssignDTOs) {
      if(jobAssignDTO.getJobAssignId() == 0)
        jobAssignDTO.setCreatedBy(username);
      else
        toDeleteList.remove(Integer.valueOf(jobAssignDTO.getJobAssignId()));
      jobAssignDTO.setUpdatedBy(username);
      MasterJobAssignment jobAssign = new MasterJobAssignment();
      BeanUtils.copyProperties(jobAssignDTO, jobAssign);
      jobAssign.setCommissionedUser(muServ.getById(jobAssignDTO.getUserCommissionedId()));
      jobAssign.setAssignedUser(muServ.getById(jobAssignDTO.getUserAssignedId()));
      mjaServ.save(jobAssign);
    }
    //delete the DELETED rest
    for(Integer jobAssignId : toDeleteList)
      mjaServ.deleteById(jobAssignId);
    return jobAssignDTOList;
  }

  /**
   * Save given zipcode verificator
   * @param zipcodeVerifDTO
   * @param session, http session object
   * @return saved zipcode verificator
   */
  @RequestMapping(value = "/zipcodeverif", method = RequestMethod.POST)
  public @ResponseBody MasterZipcodeVerificatorDTO saveZipcodeVerif(
          @RequestBody MasterZipcodeVerificatorDTO zipcodeVerifDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    if(zipcodeVerifDTO.getZipcodeVerifId() == 0) {
      zipcodeVerifDTO.setCreatedBy(username);
    }
    zipcodeVerifDTO.setUpdatedBy(username);
    MasterZipcodeVerificator zipcodeVerif = new MasterZipcodeVerificator();
    BeanUtils.copyProperties(zipcodeVerifDTO, zipcodeVerif);
    zipcodeVerif.setVerificator(muServ.getById(zipcodeVerifDTO.getVerificatorId()));
    zipcodeVerif.setZipcode(mzServ.getById(zipcodeVerifDTO.getZipcodeId()));
    mzvServ.save(zipcodeVerif);
    return zipcodeVerifDTO;
  }

  /**
   * Upload zipcode verificator list via excel file
   * @param file, excel file to upload
   * @param fields, fields to read
   * @param headerFlag, if true, the file has header, otherwise it has not
   * @param fileName, the name of the file
   * @param session, http session object
   * @return upload status
   * @throws Exception 
   */
  @RequestMapping(value = "/zipcodeverif/excelfile", method = RequestMethod.POST)
  public @ResponseBody String uploadZipcodeVerifExcelFile(
          @RequestParam("excelfile") MultipartFile file,
          @RequestParam("fields") List<String> fields,
          @RequestParam("headerFlag") String headerFlag,
          @RequestParam("fileName") String fileName,
          HttpSession session
          ) throws Exception
  {
    //proceed filled file only
    if(!file.isEmpty()) {
      String userCode = (String) session.getAttribute("userName");
      MasterCompany company = mcServ.getById((Integer) session.getAttribute("coyId"));
      //read the contents and save them (bulk)
      List<Map<String,String>> contents = new ReadExcel(file,fields,(headerFlag.equals("WH")),fileName).getFileContents();
      List<MasterZipcodeVerificator> zipcodeVerifList = new ArrayList();
      for(Map<String,String> content : contents) {
        String userCodeContent = content.get("userCode");
        if(isInvalidUser(userCode, company.getCoyCode()))
          throw new Exception("File contained invalid user");
        String zipcodeCode = content.get("zipcodeCode");
        if(isInvalidZipcode(zipcodeCode))
          throw new Exception("File contained invalid zipcode");
        String subZipcode = content.get("subZipcode");
        MasterZipcodeVerificator zipcodeVerif = mzvServ.getByCoyVerifZipcodeAndSub(
                company.getCoyId(),
                userCodeContent,
                zipcodeCode,
                subZipcode);
        //check:
        //if record not exists then insert, otherwise update
        if(zipcodeVerif == null) {
          zipcodeVerif = new MasterZipcodeVerificator();
          zipcodeVerif.setCreatedBy(userCode);
          zipcodeVerif.setVerificator(muServ.getByCodeAndCoy(userCodeContent,company.getCoyCode()));
          zipcodeVerif.setZipcode(mzServ.getByZipcodeCode(zipcodeCode));
          zipcodeVerif.setSubZipcode(subZipcode);
        }
        zipcodeVerif.setDescription(content.get("description"));
        zipcodeVerif.setUpdatedBy(userCode);
        zipcodeVerifList.add(zipcodeVerif);
      }
      mzvServ.save(zipcodeVerifList, numOfBulkRecord);
    }
    return "ok";
  }

  /**
   * Upload zipcode verificator list via textfile file
   * @param file, excel file to upload
   * @param fields, fields to read
   * @param headerFlag, if true, the file has header, otherwise it has not
   * @param fileName, the name of the file
   * @param textDelimiter, character separator between to fields
   * @param session, http session object
   * @return upload status
   * @throws Exception 
   */
  @RequestMapping(value = "/zipcodeverif/textfile", method = RequestMethod.POST)
  public @ResponseBody String uploadZipcodeVerifTextFile(
          @RequestParam("textfile") MultipartFile file,
          @RequestParam("fields") List<String> fields,
          @RequestParam("headerFlag") String headerFlag,
          @RequestParam("textDelimiter") String textDelimiter,
          @RequestParam("fileName") String fileName,
          HttpSession session
          ) throws Exception
  {
    //
    if(!file.isEmpty()) {
      String userCode = (String) session.getAttribute("userName");
      MasterCompany company = mcServ.getById((Integer) session.getAttribute("coyId"));
      List<Map<String,String>> contents = new ReadText(file,fields,(headerFlag.equals("WH")),textDelimiter,fileName).getFileContents();
      List<MasterZipcodeVerificator> zipcodeVerifList = new ArrayList();
      for(Map<String,String> content : contents) {
        String userCodeContent = content.get("userCode");
        if(isInvalidUser(userCode,company.getCoyCode()))
          throw new Exception("File contained invalid user");
        String zipcodeCode = content.get("zipcodeCode");
        if(isInvalidZipcode(zipcodeCode))
          throw new Exception("File contained invalid zipcode");
        String subZipcode = content.get("subZipcode");
        MasterZipcodeVerificator zipcodeVerif = mzvServ.getByCoyVerifZipcodeAndSub(
                company.getCoyId(),
                userCodeContent,
                zipcodeCode,
                subZipcode);
        if(zipcodeVerif == null) {
          zipcodeVerif = new MasterZipcodeVerificator();
          zipcodeVerif.setCreatedBy(userCode);
          zipcodeVerif.setVerificator(muServ.getByCodeAndCoy(userCodeContent,company.getCoyCode()));
          zipcodeVerif.setZipcode(mzServ.getByZipcodeCode(zipcodeCode));
          zipcodeVerif.setSubZipcode(subZipcode);
        }
        zipcodeVerif.setDescription(content.get("description"));
        zipcodeVerif.setUpdatedBy(userCode);
        zipcodeVerifList.add(zipcodeVerif);
      }
      mzvServ.save(zipcodeVerifList, numOfBulkRecord);
    }
    return "ok";
  }

  /**
   * Save given absence
   * @param absenceDTO
   * @param session, http session object
   * @return saved absence
   */
  @RequestMapping(value = "/absence", method = RequestMethod.POST)
  public @ResponseBody MasterAbsenceDTO saveAbsence(
          @RequestBody MasterAbsenceDTO absenceDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    if(absenceDTO.getAbsenceId() == 0) {
      absenceDTO.setCreatedBy(username);
    }
    absenceDTO.setUpdatedBy(username);
    MasterAbsence absence = new MasterAbsence();
    BeanUtils.copyProperties(absenceDTO, absence);
    absence.setUser(muServ.getById(absenceDTO.getUserId()));
    absence.setReasonType(mrtServ.getById(absenceDTO.getReasonTypeId()));
    maServ.save(absence);
    return absenceDTO;
  }

  /**
   * Disable given absence
   * @param absenceDTO
   * @param session, http session object
   * @return disabled absence
   */
  @RequestMapping(value = "/absence/disable", method = RequestMethod.POST)
  public @ResponseBody MasterAbsenceDTO disAbsence(
          @RequestBody MasterAbsenceDTO absenceDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    MasterAbsence absence = maServ.getById(absenceDTO.getAbsenceId());
    absence.setEndDate(getYesterday());
    absence.setUpdatedBy(username);
    maServ.save(absence);
    return absenceDTO;
  }

  /**
   * Update user of task assignment list
   * @param taskDTOList
   * @param session, http session object
   * @return list of updated task
   */
  @RequestMapping(value = "/taskassign", method = RequestMethod.POST)
  public @ResponseBody MobileTaskAssignmentDTOList saveTaskAssignList(
          @RequestBody MobileTaskAssignmentDTOList taskDTOList,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    MasterUser user = muServ.getById(taskDTOList.getUserId());
    for(Integer taskId : taskDTOList.getTaskIdList()) {
      MobileTaskAssignment mta = mtaServ.getById(taskId);
      mta.setUser(user);
      mta.setUpdatedBy(username);
      mtaServ.save(mta);
    }
    return taskDTOList;
  }

  /**
   * Update user of rolling task list
   * @param taskDTOList
   * @param session, http session object
   * @return list of updated tasks
   */
  @RequestMapping(value = "/rollingtask", method = RequestMethod.POST)
  public @ResponseBody MobileTaskAssignmentDTOList saveRollingTaskList(
          @RequestBody MobileTaskAssignmentDTOList taskDTOList,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    MasterUser user = muServ.getById(taskDTOList.getUserId());
    for(Integer taskId : taskDTOList.getTaskIdList()) {
      MobileTaskAssignment mta = mtaServ.getById(taskId);
      mta.setUser(user);
      mta.setUpdatedBy(username);
      //if rolling task has retrieve status then switch it to assign status
      if(mta.getTaskStatus().getTaskStatusCode().equals("RETR")) {
        mta.setTaskStatus(mtsServ.getByCode("ASSG"));
        mta.setAssignmentDate(new Date(System.currentTimeMillis()));
      }
      mtaServ.save(mta);
    }
    return taskDTOList;
  }

  /**
   * Save given verified task
   * @param detailListDTOList
   * @param session, http session object
   * @return list of saved result tasks
   */
  @RequestMapping(value = "/verifytask", method = RequestMethod.POST)
  public @ResponseBody MobileTaskResultDetailListDTOList saveVerifyTaskList(
          @RequestBody MobileTaskResultDetailListDTOList detailListDTOList,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    List<MobileTaskResultDetailList> resultDetailListList = new ArrayList();
    for(MobileTaskResultDetailListDTO resultDetailListDTO : detailListDTOList.getResultDetailListDTOList()) {
      if(resultDetailListDTO.getTaskResultDetListId() == 0)
        resultDetailListDTO.setCreatedBy(username);
      resultDetailListDTO.setUpdatedBy(username);
      MobileTaskResultDetailList resultDetailList = mtrdlServ.getById(resultDetailListDTO.getTaskResultDetListId());
      BeanUtils.copyProperties(resultDetailListDTO, resultDetailList);
      resultDetailListList.add(resultDetailList);
    }
    //
    if(!resultDetailListList.isEmpty()) {
      mtrdlServ.save(resultDetailListList, numOfBulkRecord);
      MobileTaskAssignment task = resultDetailListList.get(0).getTaskResultDetail().getTaskResult().getTask();
      task.setTaskStatus(mtsServ.getByCode("VERIF"));
      task.setVerifyDate(new Date(System.currentTimeMillis()));
      task.setVerifyBy(username);
      task.setUpdatedBy(username);
      mtaServ.save(task);
    }
    //
    return detailListDTOList;
  }

  /**
   * Delete given task
   * @param taskDTO
   * @param session, http session object
   * @return deleted task
   */
  @RequestMapping(value = "/droptask", method = RequestMethod.POST)
  public @ResponseBody MobileTaskAssignmentDTO saveDropTaskList(
          @RequestBody MobileTaskAssignmentDTO taskDTO,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    MasterTaskStatus taskStatus = mtsServ.getByCode("DROP");
    MobileTaskAssignment mta = mtaServ.getById(taskDTO.getTaskId());
    mta.setTaskStatus(taskStatus);
    mta.setUpdatedBy(username);
    mtaServ.save(mta);
    return taskDTO;
  }
  
  //simple yesterday creator
  private Date getYesterday() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -1);
    return new Date(cal.getTimeInMillis());
  }
  
  //check if user is valid
  private boolean isInvalidUser(String userCode, String coyCode) {
    return muServ.getByCodeAndCoy(userCode, coyCode) == null;
  }
  
  //check if zipcode is valid
  private boolean isInvalidZipcode(String zipcodeCode) {
    return mzServ.getByZipcodeCode(zipcodeCode) == null;
  }
}
