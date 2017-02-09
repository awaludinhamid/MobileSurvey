/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterZipcodeVerificator;
import java.util.List;

/**
 * @created Jan 23, 2017
 * @author awal
 */
public interface MasterZipcodeVerificatorService {

  MasterZipcodeVerificator save(MasterZipcodeVerificator zipcodeVerif);
  MasterZipcodeVerificator delete(MasterZipcodeVerificator zipcodeVerif);
  MasterZipcodeVerificator getById(int zipcodeVerifId);
  List<MasterZipcodeVerificator> getByPageCoy(int coyId, int pageNo);
  List<MasterZipcodeVerificator> getByPageCoyVerifAndZipcode(int coyId, int verificatorId, String zipcodeCodePattern, int pageNo);
  int countByCoy(int coyId);
  int countByCoyVerifAndZipcode(int coyId, int verificatorId, String zipcodeCodePattern);
  MasterZipcodeVerificator getByCoyVerifZipcodeAndSub(int coyId, String userCode, String zipcodeCode, String subZipcode);
  List<MasterZipcodeVerificator> getByCoyVerif(int coyId, int userId);
  String getMaxSubZipcodeByCoyAndZipcode(int coyId, int zipcodeId);
  List<MasterZipcodeVerificator> getByPageParentUser(int parentUserId, int pageNo);
  List<MasterZipcodeVerificator> getByPageParentUserVerifAndZipcode(
          int parentUserId, int verificatorId, String zipcodeCodePattern, int pageNo);
  int countByParentUser(int parentUserId);
  int countByParentUserVerifAndZipcode(int parentUserId, int verificatorId, String zipcodeCodePattern);
}
