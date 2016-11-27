/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.security;

import com.sun.jersey.api.core.HttpContext;
import com.sun.jersey.oauth.server.OAuthServerRequest;
import com.sun.jersey.oauth.signature.OAuthParameters;
import com.sun.jersey.oauth.signature.OAuthSecrets;
import com.sun.jersey.oauth.signature.OAuthSignature;
import com.sun.jersey.oauth.signature.OAuthSignatureException;
import id.co.sim.mobsur.bean.support.KeyBean;
import id.co.sim.mobsur.service.MasterUserService;
import id.co.sim.mobsur.util.SessionUtil;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @created Apr 13, 2013
 * @author awal
 */
@Configurable
@Path("/serverAuthentication")
public class ServerAuthentication {

    private final Logger logger = Logger.getLogger("deskcall");
    @Context
    private HttpContext context;
    @Context
    private HttpServletRequest httpRequest;
    private final Map<String,KeyBean> sessionMap = SessionHolder.getSessionMap();

    public String getVerified(HttpContext contextTmp) {
        // wrap incoming request for OAuth signature verification
        OAuthServerRequest request = new OAuthServerRequest(contextTmp.getRequest());
        // get incoming OAuth parameters
        OAuthParameters params = new OAuthParameters();
        params.readRequest(request);
        // get session info
        KeyBean keyBean = sessionMap.get(params.get("sessionId"));
        params.setConsumerKey(keyBean.getConsumerKey());
        params.setToken(keyBean.getTokenKey());
        //... set secrets based on consumer key and/or token in parameters ...
        OAuthSecrets secrets = new OAuthSecrets();
        secrets.setConsumerSecret(keyBean.getConsumerSecret());
        secrets.setTokenSecret(keyBean.getTokenSecret());
        // verify
        try {
            if(OAuthSignature.verify(request, params, secrets)) {
                return "true";
            }
            return "false";
        }
        catch (OAuthSignatureException ose) {
            logger.error(ose);
            return "error";
        }
    }

    @Path("/requestToken")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public synchronized KeyBean getToken() {
        // remove expired session
        Calendar currentCalendar = Calendar.getInstance();
        for(String key : sessionMap.keySet()) {
            // get properties
            Properties prop = new Properties();
            try {
                prop.load(SecretKeyGenerator.class.getClassLoader()
                        .getResourceAsStream("authentication.properties"));
            } catch(IOException ioe) {
                logger.error("Failed to load properties file");
                logger.error(ioe);
            }
            Integer expiredMilisecond = Integer.parseInt(prop.getProperty("auth.expiredMilisecond"));
            KeyBean keyBeanTemp = sessionMap.get(key);
            if(keyBeanTemp.getTimeIn().compareTo(currentCalendar) <= expiredMilisecond)
                sessionMap.remove(key);
        }
        KeyBean keyBean = new KeyBean();
        OAuthServerRequest request = new OAuthServerRequest(context.getRequest());
        OAuthParameters params = new OAuthParameters();
        params.readRequest(request);
        if(!params.isEmpty()) {
            String userName = params.get("userName");//"awal";
            String userPassword = params.get("userPassword");//"4w4lud1n";
            String dbPassword =
                    (new SessionUtil<MasterUserService>().getAppContext("masterUserService"))
                .getPassByUser(userName);
            if(userPassword.equals(dbPassword)) {
                // key
                RandomKeyGenerator randomKey = RandomKeyGenerator.getInstance();
                String consumerKey = randomKey.getRandomKey();
                String tokenKey = randomKey.getRandomKey();
                String sessionId = httpRequest.getSession().getId();
                // secret
                SecretKeyGenerator secretKeyGen = SecretKeyGenerator.getInstance();
                String consumerSecret =
                        secretKeyGen.encrypt(UUID.randomUUID().toString() + userName);
                String tokenSecret =
                        secretKeyGen.encrypt(UUID.randomUUID().toString() + userPassword);
                // put into session holder
                keyBean.setConsumerKey(consumerKey);
                keyBean.setConsumerSecret(consumerSecret);
                keyBean.setTokenKey(tokenKey);
                keyBean.setTokenSecret(tokenSecret);
                keyBean.setSessionId(sessionId);
                keyBean.setStatus("true");
                keyBean.setTimeIn(currentCalendar);
                sessionMap.put(sessionId, keyBean);
            }
        }
        return keyBean;
    }
}
