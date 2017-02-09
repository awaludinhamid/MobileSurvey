/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterAbsence;
import java.util.List;

/**
 * @created Jan 26, 2017
 * @author awal
 */
public interface MasterAbsenceService {

  MasterAbsence save(MasterAbsence absence);
  MasterAbsence delete(MasterAbsence absence);
  List<MasterAbsence> getByPageCoy(int coyId, int pageNo);
  List<MasterAbsence> getByPageUserReasonStartAndEndDate(int userId, int reasonTypeId, String startDate, String endDate, int pageNo);
  int countByCoy(int coyId);
  int countByUserReasonStartAndEndDate(int userId, int reasonTypeId, String startDate, String endDate);
  List<MasterAbsence> getByPageParentUser(int parentUserId, int pageNo);
  List<MasterAbsence> getByPageParentUserReasonStartAndEndDate(
          int parentUserId, int userId, int reasonTypeId, String startDate, String endDate, int pageNo);
  int countByParentUser(int parentUserId);
  int countByParentUserReasonStartAndEndDate(
          int parentUserId, int userId, int reasonTypeId, String startDate, String endDate);
}
