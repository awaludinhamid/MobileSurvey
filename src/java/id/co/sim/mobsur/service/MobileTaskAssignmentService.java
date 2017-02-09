/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MobileTaskAssignment;
import java.util.List;

/**
 * @created Feb 2, 2017
 * @author awal
 */
public interface MobileTaskAssignmentService {

  MobileTaskAssignment save(MobileTaskAssignment task);
  MobileTaskAssignment getById(int taskId);
  List<MobileTaskAssignment> getAll();
  List<MobileTaskAssignment> getByPage(int pageNo);
  List<MobileTaskAssignment> getByPageUser(int userId, int pageNo);
  List<MobileTaskAssignment> getByPageParentUser(int parentUserId, int pageNo);
  int count();
  int countByUser(int userId);
  int countByParentUser(int parentUserId);
}
