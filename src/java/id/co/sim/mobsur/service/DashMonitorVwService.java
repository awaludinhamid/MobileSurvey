/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.DashMonitorVw;
import java.util.List;

/**
 * SPI of dashboard monitor module
 * @author awal
 */
public interface DashMonitorVwService {

  /**
   * Get dashboard monitor data by office
   * @param officeId
   * @return list of dashboard monitor data based on given office
   */
  List<DashMonitorVw> getByOffice(int officeId);
  
  /**
   * Get dashboard monitor data by superior
   * @param parentUserId
   * @return list of dashboard monitor data based on given superior
   */
  List<DashMonitorVw> getByParentUser(int parentUserId);
}
