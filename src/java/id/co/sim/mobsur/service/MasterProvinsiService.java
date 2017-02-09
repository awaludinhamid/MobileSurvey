/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterProvinsi;
import java.util.List;

/**
 * @created Dec 19, 2016
 * @author awal
 */
public interface MasterProvinsiService {

  MasterProvinsi save(MasterProvinsi mp);
  MasterProvinsi delete(MasterProvinsi mp);
  MasterProvinsi getById(int provId);
  List<MasterProvinsi> getAll();
  List<MasterProvinsi> getByPage(int pageNo);
  List<MasterProvinsi> getByPageCodeAndName(String provCodePattern, String provNamePattern, int pageNo);
  int count();
  int countByCodeAndName(String provCodePattern, String provNamePattern);
}
