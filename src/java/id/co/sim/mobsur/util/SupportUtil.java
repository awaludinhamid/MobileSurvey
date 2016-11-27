/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 * @created Nov 18, 2016
 * @author awal
 */
public class SupportUtil {
  
  private static final Logger logger = Logger.getLogger("others");

  public static String getMd5Hash(String text) {
    try {
    MessageDigest digest = MessageDigest.getInstance("MD5");
    digest.update(text.getBytes("UTF-8"),0,text.length());
    return new BigInteger(1,digest.digest()).toString(16);
    } catch(UnsupportedEncodingException | NoSuchAlgorithmException ex) {
      logger.error(ex);
    }
    return text;
  }
  
  public static String getTodayInString(String format) {
    Date date = new Date(System.currentTimeMillis());
    return new SimpleDateFormat(format).format(date);
  }
}
