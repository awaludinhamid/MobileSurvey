/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.auth;

import id.co.sim.mobsur.bean.MasterCompany;
import id.co.sim.mobsur.bean.MasterOffice;
import id.co.sim.mobsur.bean.MasterUser;
import id.co.sim.mobsur.service.MasterCompanyService;
import id.co.sim.mobsur.service.MasterOfficeService;
import id.co.sim.mobsur.service.MasterUserService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import id.co.sim.mobsur.util.SessionUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * To do action when user have logged successfully
 * Currently used to create user session info and record user login
 * @created Apr 16, 2016
 * @author awal
 */
@Component("customAuthenticationSuccessHandler")
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler { //SimpleUrlAuthenticationSuccessHandler
 
  private final Logger authLogger = Logger.getLogger("auth");

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
          throws IOException, ServletException {    
    authLogger.info("set login info");
    //login info 
    HttpSession session = request.getSession();
    String userName = (String) session.getAttribute("userName");
    if(userName == null || userName.equals("")) {        
      String name = auth.getName();
      MasterUserService mstUsersServ =
              new SessionUtil<MasterUserService>().getAppContext("masterUserService");
      MasterCompanyService mstCoyServ =
              new SessionUtil<MasterCompanyService>().getAppContext("masterCompanyService");
      MasterUser mstUser = mstUsersServ.getByCode(name);
      MasterOffice mstOffice = new SessionUtil<MasterOfficeService>().getAppContext("masterOfficeService").getById(mstUser.getOffice().getOfficeId());
      MasterCompany mstCoy = mstCoyServ.getById(mstOffice.getCompany().getCoyId());
      session.setAttribute("realName", mstUser.getUserName());
      session.setAttribute("userId", mstUser.getUserId());
      session.setAttribute("userName", name);
      session.setAttribute("sessionId", session.getId());
      session.setAttribute("hasRole", mstUser.getUserRoles() == null ? "no" : "yes");      
      session.setAttribute("isValid", mstCoyServ.getValidCoyByUserId(mstUser.getUserId()) == null ? "no" : "yes");
      session.setAttribute("systemName", mstCoy.getSystemName());
      session.setAttribute("coyId", mstCoy.getCoyId());
      session.setAttribute("companyLogoId", mstCoy.getDetailCompanyLogo().getCompanyLogoId());
      session.setAttribute("pagingRecords", GlobalIntVariable.PAGING_RECORDS.getVar());
    }
    //redirect
    setDefaultTargetUrl("/apps/main/validation");
    super.onAuthenticationSuccess(request, response, auth);
  }
}
