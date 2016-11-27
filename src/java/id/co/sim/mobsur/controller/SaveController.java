/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.controller;

import id.co.sim.mobsur.bean.DetailCompanyLogo;
import id.co.sim.mobsur.bean.MasterCompany;
import id.co.sim.mobsur.bean.MasterMenu;
import id.co.sim.mobsur.bean.MasterOffice;
import id.co.sim.mobsur.bean.MasterRole;
import id.co.sim.mobsur.bean.MasterRoleMenu;
import id.co.sim.mobsur.bean.MasterUser;
import id.co.sim.mobsur.bean.MasterUserRole;
import id.co.sim.mobsur.bean.MasterZipcode;
import id.co.sim.mobsur.bean.save.MasterCompanySave;
import id.co.sim.mobsur.bean.save.MasterMenuSave;
import id.co.sim.mobsur.bean.save.MasterOfficeSave;
import id.co.sim.mobsur.bean.save.MasterRoleMenuSave;
import id.co.sim.mobsur.bean.save.MasterRoleSave;
import id.co.sim.mobsur.bean.save.MasterUserRoleSave;
import id.co.sim.mobsur.bean.save.MasterUserSave;
import id.co.sim.mobsur.service.DetailCompanyLogoService;
import id.co.sim.mobsur.service.MasterCompanyService;
import id.co.sim.mobsur.service.MasterMenuService;
import id.co.sim.mobsur.service.MasterOfficeService;
import id.co.sim.mobsur.service.MasterParentMenuService;
import id.co.sim.mobsur.service.MasterRoleMenuService;
import id.co.sim.mobsur.service.MasterRoleService;
import id.co.sim.mobsur.service.MasterUserRoleService;
import id.co.sim.mobsur.service.MasterUserService;
import id.co.sim.mobsur.service.MasterZipcodeService;
import id.co.sim.mobsur.util.SupportUtil;
import java.io.IOException;
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

  private final Logger logger = Logger.getLogger("controller");

  @RequestMapping(value = "/company", method = RequestMethod.POST)
  public @ResponseBody MasterCompanySave saveCompany(
          @RequestBody MasterCompanySave companySave,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    //
    DetailCompanyLogo dcl;
    if(companySave.getCoyId() == 0) {
      companySave.setCreatedBy(username);
      dcl = dclServ.save(new DetailCompanyLogo());
    } else {
      dcl = dclServ.getById(companySave.getCompanyLogoId());
    }
    companySave.setUpdatedBy(username);
    companySave.setCompanyLogoId(dcl.getCompanyLogoId());
    MasterCompany company = new MasterCompany();
    BeanUtils.copyProperties(companySave, company);
    company.setDetailCompanyLogo(dcl);
    mcServ.save(company);
    return companySave;
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
  public @ResponseBody MasterMenuSave saveMenu(
          @RequestBody MasterMenuSave menuSave,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(menuSave.getMenuId() == 0) {
      menuSave.setCreatedBy(username);
    }
    menuSave.setUpdatedBy(username);
    MasterMenu menu = new MasterMenu();
    BeanUtils.copyProperties(menuSave, menu);
    menu.setParentMenu(mpmServ.getById(menuSave.getParentMenuId()));
    mmServ.save(menu);
    return menuSave;
  }

  @RequestMapping(value = "/role", method = RequestMethod.POST)
  public @ResponseBody MasterRoleSave saveRole(
          @RequestBody MasterRoleSave roleSave,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(roleSave.getRoleId() == 0) {
      roleSave.setCreatedBy(username);
    } 
    roleSave.setUpdatedBy(username);
    MasterRole role = new MasterRole();
    BeanUtils.copyProperties(roleSave, role);
    mrServ.save(role);
    return roleSave;
  }

  @RequestMapping(value = "/office", method = RequestMethod.POST)
  public @ResponseBody MasterOfficeSave saveOffice(
          @RequestBody MasterOfficeSave officeSave,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(officeSave.getOfficeId() == 0) {
      officeSave.setCreatedBy(username);
      int coyId = (Integer) session.getAttribute("coyId");
      officeSave.setCoyId(coyId);
    }
    officeSave.setUpdatedBy(username);
    MasterOffice office = new MasterOffice();
    BeanUtils.copyProperties(officeSave, office);
    office.setCompany(mcServ.getById(officeSave.getCoyId()));
    moServ.save(office);
    return officeSave;
  }

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public @ResponseBody MasterUserSave saveUser(
          @RequestBody MasterUserSave userSave,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(userSave.getUserId() == 0) {
      userSave.setCreatedBy(username);      
      userSave.setUserPassword(SupportUtil.getMd5Hash(userSave.getUserPassword()));
    }
    userSave.setUpdatedBy(username);
    MasterUser user = new MasterUser();
    user.setOffice(moServ.getById(userSave.getOfficeId()));
    BeanUtils.copyProperties(userSave, user);
    muServ.save(user);
    return userSave;
  }

  @RequestMapping(value = "/userrole", method = RequestMethod.POST)
  public @ResponseBody MasterUserRoleSave saveUserRole(
          @RequestBody MasterUserRoleSave userRoleSave,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(userRoleSave.getUserRoleId() == 0) {
      userRoleSave.setCreatedBy(username);      
    }
    userRoleSave.setUpdatedBy(username);
    MasterUserRole userRole = new MasterUserRole();
    BeanUtils.copyProperties(userRoleSave, userRole);
    userRole.setUser(muServ.getById(userRoleSave.getUserId()));
    userRole.setRole(mrServ.getById(userRoleSave.getRoleId()));
    murServ.save(userRole);
    return userRoleSave;
  }

  @RequestMapping(value = "/rolemenu", method = RequestMethod.POST)
  public @ResponseBody MasterRoleMenuSave saveRoleMenu(
          @RequestBody MasterRoleMenuSave roleMenuSave,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(roleMenuSave.getRoleMenuId() == 0) {
      roleMenuSave.setCreatedBy(username);      
    }
    roleMenuSave.setUpdatedBy(username);
    MasterRoleMenu roleMenu = new MasterRoleMenu();
    BeanUtils.copyProperties(roleMenuSave, roleMenu);
    roleMenu.setRole(mrServ.getById(roleMenuSave.getRoleId()));
    roleMenu.setMenu(mmServ.getById(roleMenuSave.getMenuId()));
    mrmServ.save(roleMenu);
    return roleMenuSave;
  }

  @RequestMapping(value = "/zipcode", method = RequestMethod.POST)
  public @ResponseBody MasterZipcode saveZipcode(
          @RequestBody MasterZipcode zipcode,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(zipcode.getZipcodeId() == 0) {
      zipcode.setCreatedBy(username);      
    }
    zipcode.setUpdatedBy(username);
    mzServ.save(zipcode);
    return zipcode;
  }
}
