/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 * Deserializer json data with time type and remove timezone if any
 * @author awal
 * @created Mar 18, 2017
 */
public class CustomJsonTimeDeserializerWithoutTimeZone extends JsonDeserializer<Time> {
 
  private final Logger logger = Logger.getLogger("others");

  /**
   * Execute time deserializing by new process
   * Override default behavior
   * @param jp, parser
   * @param ctxt, context
   * @return deserialized time
   * @throws IOException
   * @throws JsonProcessingException 
   */
  @Override
  public Time deserialize(JsonParser jp, DeserializationContext ctxt)
          throws IOException, JsonProcessingException {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Time time = null;
    try{
      Date dt = format.parse("10:30:00.000-05.00".substring(0,12)); // remove incorrect timezone format
      time = new Time(dt.getTime());
    } catch (ParseException e){
      logger.error(e);
    }
    return time;
  }

}
