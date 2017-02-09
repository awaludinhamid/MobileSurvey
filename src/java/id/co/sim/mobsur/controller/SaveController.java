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
import id.co.sim.mobsur.bean.MasterTemplate;
import id.co.sim.mobsur.bean.MasterUser;
import id.co.sim.mobsur.bean.MasterUserRole;
import id.co.sim.mobsur.bean.MasterZipcode;
import id.co.sim.mobsur.bean.MasterZipcodeVerificator;
import id.co.sim.mobsur.bean.MobileTaskAssignment;
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
import id.co.sim.mobsur.bean.dto.support.MasterJobAssignmentDTOList;
import id.co.sim.mobsur.bean.dto.support.MobileTaskAssignmentDTOList;
import id.co.sim.mobsur.service.DetailCompanyLogoService;
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
import id.co.sim.mobsur.service.MasterRoleService;
import id.co.sim.mobsur.service.MasterRoleTypeService;
import id.co.sim.mobsur.service.MasterTemplateService;
import id.co.sim.mobsur.service.MasterUserRoleService;
import id.co.sim.mobsur.service.MasterUserService;
import id.co.sim.mobsur.service.MasterZipcodeService;
import id.co.sim.mobsur.service.MasterZipcodeVerificatorService;
import id.co.sim.mobsur.service.MobileTaskAssignmentService;
import id.co.sim.mobsur.util.SupportUtil;
import id.co.sim.mobsur.util.file.ReadExcel;
import id.co.sim.mobsur.util.file.ReadText;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
 * @created Oct 23, 2016
 * @author awal
 */
@Controller
@RequestMapping("/save")
public class SaveController {
  
  @Autowired
  private DetailCompanyLogoService dclServ;
  @Autowired
  private MasterCompanyService mcServ;
  @Autowired
  private MasterParentMenuService mpmServ;
  @Autowired
  private MasterMenuService mmServ;
  @Autowired
  private MasterRoleService mrServ;
  @Autowired
  private MasterOfficeService moServ;
  @Autowired
  private MasterUserService muServ;
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
  private MasterReasonTypeService mrtServ;
  @Autowired
  private MasterAbsenceService maServ;
  @Autowired
  private MasterRoleTypeService mrlServ;
  @Autowired
  private MobileTaskAssignmentService mtaServ;

  private final Logger logger = Logger.getLogger("controller");

  @RequestMapping(value = "/company", method = RequestMethod.POST)
  public @ResponseBody MasterCompanyDTO saveCompany(
          @RequestBody MasterCompanyDTO companyDTO,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    //
    DetailCompanyLogo dcl;
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

  @RequestMapping(value = "/userrole", method = RequestMethod.POST)
  public @ResponseBody MasterUserRoleDTO saveUserRole(
          @RequestBody MasterUserRoleDTO userRoleDTO,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(userRoleDTO.getUserRoleId() == 0) {
      userRoleDTO.setCreatedBy(username);      
    }
    userRoleDTO.setUpdatedBy(username);
    MasterUserRole userRole = new MasterUserRole();
    BeanUtils.copyProperties(userRoleDTO, userRole);
    userRole.setUser(muServ.getById(userRoleDTO.getUserId()));
    userRole.setRole(mrServ.getById(userRoleDTO.getRoleId()));
    murServ.save(userRole);
    return userRoleDTO;
  }

  @RequestMapping(value = "/rolemenu", method = RequestMethod.POST)
  public @ResponseBody MasterRoleMenuDTO saveRoleMenu(
          @RequestBody MasterRoleMenuDTO roleMenuDTO,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(roleMenuDTO.getRoleMenuId() == 0) {
      roleMenuDTO.setCreatedBy(username);      
    }
    roleMenuDTO.setUpdatedBy(username);
    MasterRoleMenu roleMenu = new MasterRoleMenu();
    BeanUtils.copyProperties(roleMenuDTO, roleMenu);
    roleMenu.setRole(mrServ.getById(roleMenuDTO.getRoleId()));
    roleMenu.setMenu(mmServ.getById(roleMenuDTO.getMenuId()));
    mrmServ.save(roleMenu);
    return roleMenuDTO;
  }

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
    zipcode.setKecamatan(mkServ.getById(zipcodeDTO.getKecId()));
    mzServ.save(zipcode);
    return zipcodeDTO;
  }

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
    mpServ.save(param);
    return paramDTO;
  }

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
    kel.setZipcode(mzServ.getById(kelDTO.getZipcodeId()));
    mklServ.save(kel);
    return kelDTO;
  }

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
    //
    Set<DetailQuestionGroup> dqgSet = new HashSet();
    for(DetailQuestionGroupDTO detQuestGroupDTO : questGroupDTO.getDetailQuestionGroupDTO()) {
      DetailQuestionGroup detQuestGroup = new DetailQuestionGroup();
      if(detQuestGroupDTO.getDetailQuestGroupId() == 0) {
        detQuestGroupDTO.setCreatedBy(username);
        detQuestGroupDTO.setStartDate(questGroupDTO.getStartDate());
        detQuestGroupDTO.setEndDate(questGroupDTO.getEndDate());
      }
      detQuestGroupDTO.setUpdatedBy(username);
      BeanUtils.copyProperties(detQuestGroupDTO, detQuestGroup);
      detQuestGroup.setQuestion(mqServ.getById(detQuestGroupDTO.getQuestId()));
      detQuestGroup.setQuestionGroup(questGroup);
      dqgSet.add(detQuestGroup);
    }
    //
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
    //
    Set<DetailTemplate> dtSet = new HashSet();
    for(DetailTemplateDTO detTempDTO : tempDTO.getDetailTemplateDTO()) {
      DetailTemplate detTemp = new DetailTemplate();
      if(detTempDTO.getDetailTempId() == 0) {
        detTempDTO.setCreatedBy(username);
        detTempDTO.setStartDate(tempDTO.getStartDate());
        detTempDTO.setEndDate(tempDTO.getEndDate());
      }
      detTempDTO.setUpdatedBy(username);
      BeanUtils.copyProperties(detTempDTO, detTemp);
      detTemp.setQuestionGroup(mqgServ.getById(detTempDTO.getQuestGroupId()));
      detTemp.setTemplate(temp);
      dtSet.add(detTemp);
    }
    //
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

  @RequestMapping(value = "/jobassignment", method = RequestMethod.POST)
  public @ResponseBody MasterJobAssignmentDTOList saveJobAssignment(
          @RequestBody MasterJobAssignmentDTOList jobAssignDTOList,
          HttpSession session
          )
  {    
    String username = (String) session.getAttribute("userName");
    List<MasterJobAssignmentDTO> jobAssignDTOs = jobAssignDTOList.getJobAssignmentDTOList();
    List<Integer> toDeleteList = new ArrayList();
    for(MasterJobAssignment jobAssign : mjaServ.getByUserCommissioned(jobAssignDTOs.get(0).getUserCommissionedId()))
      toDeleteList.add(jobAssign.getJobAssignId());
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
    //delete the rest
    for(Integer jobAssignId : toDeleteList)
      mjaServ.deleteById(jobAssignId);
    return jobAssignDTOList;
  }

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

  @RequestMapping(value = "/zipcodeverif/excelfile", method = RequestMethod.POST)
  public @ResponseBody String uploadZipcodeVerifExcelFile(
          @RequestParam("excelfile") MultipartFile file,
          @RequestParam("fields") List<String> fields,
          @RequestParam("headerFlag") String headerFlag,
          @RequestParam("fileName") String fileName,
          HttpSession session
          )
  {
    //
    if(!file.isEmpty()) {
      try {
        String userCode = (String) session.getAttribute("userName");
        List<Map<String,String>> contents = new ReadExcel(file,fields,(headerFlag.equals("WH")),fileName).getFileContents();
        for(Map<String,String> content : contents) {
          String userCodeContent = content.get("userCode");
          String zipcodeCode = content.get("zipcodeCode");
          String subZipcode = content.get("subZipcode");
          MasterZipcodeVerificator zipcodeVerif = mzvServ.getByCoyVerifZipcodeAndSub(
                  (Integer) session.getAttribute("coyId"),
                  userCodeContent,
                  zipcodeCode,
                  subZipcode);
          if(zipcodeVerif == null) {
            zipcodeVerif = new MasterZipcodeVerificator();
            zipcodeVerif.setCreatedBy(userCode);
            zipcodeVerif.setVerificator(muServ.getByCode(userCodeContent));
            zipcodeVerif.setZipcode(mzServ.getByZipcodeCode(zipcodeCode));
            zipcodeVerif.setSubZipcode(subZipcode);
          }
          zipcodeVerif.setDescription(content.get("description"));
          zipcodeVerif.setUpdatedBy(userCode);
          mzvServ.save(zipcodeVerif);
        }
      } catch(IOException ex) {
        logger.error(ex);
        return ex.getMessage();
      }
    }
    return "ok";
  }

  @RequestMapping(value = "/zipcodeverif/textfile", method = RequestMethod.POST)
  public @ResponseBody String uploadZipcodeVerifTextFile(
          @RequestParam("textfile") MultipartFile file,
          @RequestParam("fields") List<String> fields,
          @RequestParam("headerFlag") String headerFlag,
          @RequestParam("textDelimiter") String textDelimiter,
          @RequestParam("fileName") String fileName,
          HttpSession session
          )
  {
    //
    if(!file.isEmpty()) {
      try {
        String userCode = (String) session.getAttribute("userName");
        List<Map<String,String>> contents = new ReadText(file,fields,(headerFlag.equals("WH")),textDelimiter,fileName).getFileContents();
        for(Map<String,String> content : contents) {
          String userCodeContent = content.get("userCode");
          String zipcodeCode = content.get("zipcodeCode");
          String subZipcode = content.get("subZipcode");
          MasterZipcodeVerificator zipcodeVerif = mzvServ.getByCoyVerifZipcodeAndSub(
                  (Integer) session.getAttribute("coyId"),
                  userCodeContent,
                  zipcodeCode,
                  subZipcode);
          if(zipcodeVerif == null) {
            zipcodeVerif = new MasterZipcodeVerificator();
            zipcodeVerif.setCreatedBy(userCode);
            zipcodeVerif.setVerificator(muServ.getByCode(userCodeContent));
            zipcodeVerif.setZipcode(mzServ.getByZipcodeCode(zipcodeCode));
            zipcodeVerif.setSubZipcode(subZipcode);
          }
          zipcodeVerif.setDescription(content.get("description"));
          zipcodeVerif.setUpdatedBy(userCode);
          mzvServ.save(zipcodeVerif);
        }
      } catch(IOException ex) {
        logger.error(ex);
        return ex.getMessage();
      }
    }
    return "ok";
  }

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
      mtaServ.save(mta);
    }
    return taskDTOList;
  }
}
