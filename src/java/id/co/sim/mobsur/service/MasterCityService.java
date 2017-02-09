/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterCity;
import java.util.List;

/**
 * @created Dec 19, 2016
 * @author awal
 */
public interface MasterCityService {

  MasterCity save(MasterCity mc);
  MasterCity delete(MasterCity mc);
  MasterCity getById(int cityId);
  List<MasterCity> getByPage(int pageNo);
  List<MasterCity> getByPageCodeAndName(String cityCodePattern, String cityNamePattern, int pageNo);
  int count();
  int countByCodeAndName(String cityCodePattern, String cityNamePattern);
  List<MasterCity> getByProvinsi(int provId);
}
