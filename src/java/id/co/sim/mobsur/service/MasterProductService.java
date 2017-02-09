/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterProduct;
import java.util.List;

/**
 * @created Jan 5, 2017
 * @author awal
 */
public interface MasterProductService {

  MasterProduct save(MasterProduct mp);
  MasterProduct delete(MasterProduct mp);
  List<MasterProduct> getByPage(int pageNo);
  List<MasterProduct> getByPageCoy(int coyId, int pageNo);
  List<MasterProduct> getByPageCoyAndName(int coyId, String productNamePattern, int pageNo);
  int count();
  int countByCoy(int coyId);
  int countByCoyAndName(int coyId, String productNamePattern);
}
