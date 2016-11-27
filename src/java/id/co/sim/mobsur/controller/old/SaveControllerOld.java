/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.controller.old;

import id.co.sim.mobsur.bean.DetailCompanyLogo;
import id.co.sim.mobsur.bean.MasterCompany;
import id.co.sim.mobsur.bean.MasterMenu;
import id.co.sim.mobsur.bean.MasterOffice;
import id.co.sim.mobsur.bean.MasterRole;
import id.co.sim.mobsur.bean.MasterUser;
import id.co.sim.mobsur.bean.MasterUserRole;
import id.co.sim.mobsur.bean.save.old.MasterUserRoleSaveOld;
import id.co.sim.mobsur.service.DetailCompanyLogoService;
import id.co.sim.mobsur.service.MasterCompanyService;
import id.co.sim.mobsur.service.MasterMenuService;
import id.co.sim.mobsur.service.MasterOfficeService;
import id.co.sim.mobsur.service.MasterRoleService;
import id.co.sim.mobsur.service.MasterUserRoleService;
import id.co.sim.mobsur.service.MasterUserService;
import id.co.sim.mobsur.util.SessionUtil;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
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
/*@Controller
@RequestMapping("/save")*/
public class SaveControllerOld {

  private final Logger logger = Logger.getLogger("controller");
  @Autowired
  private MasterRoleService mrServ;
  @Autowired
  private MasterUserService muServ;
  @Autowired
  private MasterUserRoleService murServ;

  @RequestMapping(value = "/company", method = RequestMethod.POST)
  public String saveCustomer(
          @ModelAttribute("company") MasterCompany company,
          @RequestParam("companylogo") MultipartFile imageFile,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    //
    DetailCompanyLogoService dcls = new SessionUtil<DetailCompanyLogoService>().getAppContext("detailCompanyLogoService");
    DetailCompanyLogo dcl;
    if(company.getCoyId() == 0) {
      company.setCreatedBy(username);
      dcl = new DetailCompanyLogo();
    } else {
      dcl = dcls.getById(company.getDetailCompanyLogo().getCompanyLogoId());
    }
    if(!imageFile.isEmpty()) {
      try{
        byte[] logoPicture = imageFile.getBytes();
        dcl.setLogoPicture(logoPicture);
      } catch(IOException iox) {
        logger.error(iox);
      }
    }
    dcl = dcls.save(dcl);
    company.setDetailCompanyLogo(dcl);
    company.setUpdatedBy(username);
    new SessionUtil<MasterCompanyService>().getAppContext("masterCompanyService").save(company);
    return "redirect:../../apps/application/company";
  }

  @RequestMapping(value = "/menu", method = RequestMethod.POST)
  public String saveMenu(
          @ModelAttribute("menu") MasterMenu menu,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(menu.getMenuId() == 0) {
      menu.setCreatedBy(username);
    }
    menu.setUpdatedBy(username);
    new SessionUtil<MasterMenuService>().getAppContext("masterMenuService").save(menu);
    return "redirect:../../apps/application/menu";
  }

  @RequestMapping(value = "/role", method = RequestMethod.POST)
  public String saveRole(
          @ModelAttribute("role") MasterRole role,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(role.getRoleId() == 0) {
      role.setCreatedBy(username);
    }
    role.setUpdatedBy(username);
    new SessionUtil<MasterRoleService>().getAppContext("masterRoleService").save(role);
    return "redirect:../../apps/application/role";
  }

  @RequestMapping(value = "/office", method = RequestMethod.POST)
  public String saveOffice(
          @ModelAttribute("office") MasterOffice office,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(office.getOfficeId() == 0) {
      office.setCreatedBy(username);
    }
    office.setUpdatedBy(username);
    new SessionUtil<MasterOfficeService>().getAppContext("masterOfficeService").save(office);
    return "redirect:../../apps/application/office";
  }

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public String saveUser(
          @ModelAttribute("user") MasterUser user,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(user.getUserId() == 0) {
      user.setCreatedBy(username);
    }
    user.setUpdatedBy(username);
    new SessionUtil<MasterUserService>().getAppContext("masterUserService").save(user);
    return "redirect:../../apps/application/user";
  }

  @RequestMapping(value = "/userrole", method = RequestMethod.POST)
  public @ResponseBody MasterUserRoleSaveOld saveUserRole(
          @RequestBody MasterUserRoleSaveOld userRoleSave,
          HttpSession session
          )
  {
    String username = (String) session.getAttribute("userName");
    if(userRoleSave.getUserRoleId() == 0) {
      userRoleSave.setCreatedBy(username);      
    }
    userRoleSave.setUpdatedBy(username);
    MasterUser user = muServ.getById(userRoleSave.getUserId());
    for(Integer roleId : userRoleSave.getRoles()) {
      MasterUserRole userRole = new MasterUserRole();
      BeanUtils.copyProperties(userRoleSave, userRole);
      userRole.setUser(user);
      userRole.setRole(mrServ.getById(roleId));
      murServ.save(userRole);
    }
    return userRoleSave;
  }
}
