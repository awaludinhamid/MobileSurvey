/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterKecamatan;
import java.util.List;

/**
 * @created Dec 19, 2016
 * @author awal
 */
public interface MasterKecamatanService {

  MasterKecamatan save(MasterKecamatan mk);
  MasterKecamatan delete(MasterKecamatan mk);
  MasterKecamatan getById(int kecId);
  List<MasterKecamatan> getByPage(int pageNo);
  List<MasterKecamatan> getByPageCodeAndName(String kecCodePattern, String kecNamePattern, int pageNo);
  int count();
  int countByCodeAndName(String kecCodePattern, String kecNamePattern);
  List<MasterKecamatan> getByCity(int cityId);
}
