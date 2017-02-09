/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterTemplate;
import java.util.List;

/**
 * @created Jan 15, 2017
 * @author awal
 */
public interface MasterTemplateService {

  MasterTemplate save(MasterTemplate template);
  MasterTemplate delete(MasterTemplate template);
  MasterTemplate getById(int tempId);
  List<MasterTemplate> getByPageCoy(int coyId, int pageNo);
  List<MasterTemplate> getByPageCoyAndLabel(int coyId, String tempLabelPattern, int pageNo);
  int countByCoy(int coyId);
  int countByCoyAndLabel(int coyId, String tempLabelPattern);
  List<MasterTemplate> getByCoy(int coytId);
}
