/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

/**
 * SPI of detail template module
 * @author awal
 */
public interface DetailTemplateService {

  /**
   * Get number of detail template by question group
   * @param questGroupId, question group
   * @return count of detail template based on given question group
   */
  int countByQuestGroup(int questGroupId);
}
