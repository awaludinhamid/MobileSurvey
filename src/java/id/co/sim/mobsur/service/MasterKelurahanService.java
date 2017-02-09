/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterKelurahan;
import java.util.List;

/**
 * @created Dec 23, 2016
 * @author awal
 */
public interface MasterKelurahanService {

  MasterKelurahan save(MasterKelurahan mk);
  MasterKelurahan delete(MasterKelurahan mk);
  MasterKelurahan getById(int kelId);
  List<MasterKelurahan> getByPage(int pageNo);
  List<MasterKelurahan> getByPageCodeAndName(String kelCodePattern, String kelNamePattern, int pageNo);
  int count();
  int countByCodeAndName(String kelCodePattern, String kelNamePattern);
  List<MasterKelurahan> getByKecamatan(int kecId);
}
