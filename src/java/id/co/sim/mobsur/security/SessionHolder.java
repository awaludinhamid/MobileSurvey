/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.security;

import id.co.sim.mobsur.bean.support.KeyBean;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author awal
 */
public class SessionHolder {

    private static final Map<String,KeyBean> sessionMap =
            Collections.synchronizedMap(new LinkedHashMap<String,KeyBean>());

    /**
     * @return the sessionMap
     */
    public static Map<String, KeyBean> getSessionMap() {
        return sessionMap;
    }

    /**
     * Disable, must set map through its member
     * @param aSessionMap the sessionMap to set
     */
    //public static void setSessionMap(Map<String, KeyBean> aSessionMap) {
    //    sessionMap = aSessionMap;
    //}

    private SessionHolder() {
    }

 }
