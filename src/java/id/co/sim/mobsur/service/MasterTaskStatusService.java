/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterTaskStatus;
import java.util.List;

/**
 * @created Feb 8, 2017
 * @author awal
 */
public interface MasterTaskStatusService {

  List<MasterTaskStatus> getAll();

}
