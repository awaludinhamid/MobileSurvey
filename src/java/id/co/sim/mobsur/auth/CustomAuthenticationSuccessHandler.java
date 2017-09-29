/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.auth;

import id.co.sim.mobsur.bean.MasterCompany;
import id.co.sim.mobsur.bean.MasterOffice;
import id.co.sim.mobsur.bean.MasterUser;
import id.co.sim.mobsur.bean.MasterUserRole;
import id.co.sim.mobsur.service.MasterCompanyService;
import id.co.sim.mobsur.service.MasterOfficeService;
import id.co.sim.mobsur.service.MasterUserRoleService;
import id.co.sim.mobsur.service.MasterUserService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * To do action when user have logged successfully
 * Currently used to create user session info and record user login
 * @created Apr 16, 2016
 * @author awal
 */
@Component("customAuthenticationSuccessHandler")
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler { // SavedRequestAwareAuthenticationSuccessHandler
 
  private final Logger authLogger = Logger.getLogger("auth");
  
  @Autowired
  private MasterCompanyService mcServ;
  @Autowired
  private MasterOfficeService moServ;
  @Autowired
  private MasterUserService muServ;  
  @Autowired
  private MasterUserRoleService murServ;  

  /**
   * Override super behaviour, prepare web parameter used
   * @param request, http request
   * @param response, http response
   * @param auth, authentication object
   * @throws IOException
   * @throws ServletException 
   */
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
          throws IOException, ServletException {    
    authLogger.info("set login info");
    //login info 
    HttpSession session = request.getSession();
    String userName = (String) session.getAttribute("userName");
    if(userName == null || userName.equals("")) {        
      MasterUser mstUser = muServ.getById((int) session.getAttribute("userId"));
      MasterOffice mstOffice = moServ.getById(mstUser.getOffice().getOfficeId());
      MasterCompany mstCoy = mcServ.getById(mstOffice.getCompany().getCoyId());      
      session.setAttribute("realName", mstUser.getUserName());
      session.setAttribute("userId", mstUser.getUserId());
      session.setAttribute("userName", mstUser.getUserCode());
      session.setAttribute("sessionId", session.getId());
      session.setAttribute("hasRole", murServ.countByUserValid(mstUser.getUserId()) == 0 ? "no" : "yes");      
      session.setAttribute("isValid", mcServ.getValidCoyByUserId(mstUser.getUserId()) == null ? "no" : "yes");
      session.setAttribute("systemName", mstCoy.getSystemName());
      session.setAttribute("coyId", mstCoy.getCoyId());
      session.setAttribute("companyLogoId", mstCoy.getDetailCompanyLogo().getCompanyLogoId());
      session.setAttribute("pagingRecords", GlobalIntVariable.PAGING_RECORDS.getVar());
      session.setAttribute("officeName", mstOffice.getOfficeName());
      MasterUserRole mur = murServ.getByUser(mstUser.getUserId());
      session.setAttribute("roleTypeCode", mur == null ? "" : mur.getRole().getRoleType().getRoleTypeCode());
      session.setAttribute("userFromOwner", murServ.getByCoyAndRoleType(mstCoy.getCoyId(),"O").isEmpty() ? "N" : "Y");
    }
    //redirect
    setDefaultTargetUrl("/apps/main/validation");
    super.onAuthenticationSuccess(request, response, auth);
  }
}
