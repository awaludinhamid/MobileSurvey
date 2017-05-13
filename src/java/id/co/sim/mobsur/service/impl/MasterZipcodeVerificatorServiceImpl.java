/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.MasterZipcodeVerificator;
import id.co.sim.mobsur.dao.MasterZipcodeVerificatorDAO;
import id.co.sim.mobsur.service.MasterZipcodeVerificatorService;
import id.co.sim.mobsur.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**	
 * Zipcode verificator service implementation (see the service for usage info)
 * @created Jan 23, 2017
 * @author awal
 */
@Service("masterZipcodeVerificatorService")
@Transactional(readOnly=true)
public class MasterZipcodeVerificatorServiceImpl implements MasterZipcodeVerificatorService {

  @Autowired
  private MasterZipcodeVerificatorDAO masterZipcodeVerificatorDAO;// DAO injection
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();//number of records per page (paging)

  @Override
  @Transactional(readOnly=false)
  public MasterZipcodeVerificator save(MasterZipcodeVerificator zipcodeVerif) {
    return masterZipcodeVerificatorDAO.save(zipcodeVerif);
  }

  @Override
  @Transactional(readOnly=false)
  public void save(List<MasterZipcodeVerificator> zipcodeVerifList, int numOfBulkRecord) {
    masterZipcodeVerificatorDAO.save(zipcodeVerifList, numOfBulkRecord);
  }

  @Override
  @Transactional(readOnly=false)
  public void delete(MasterZipcodeVerificator zipcodeVerif) {
    masterZipcodeVerificatorDAO.delete(zipcodeVerif);
  }

  @Override
  public MasterZipcodeVerificator getById(int zipcodeVerifId) {
    return masterZipcodeVerificatorDAO.getById(zipcodeVerifId);
  }

  @Override
  public List<MasterZipcodeVerificator> getByPageCoy(int coyId, int pageNo) {
    return masterZipcodeVerificatorDAO.getByRangeCoy(coyId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterZipcodeVerificator> getByPageCoyVerifAndZipcode(int coyId, int verificatorId, String zipcodeCodePattern, int pageNo) {
    return masterZipcodeVerificatorDAO.getByRangeCoyVerifAndZipcode(coyId, verificatorId, zipcodeCodePattern, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByCoy(int coyId) {
    return masterZipcodeVerificatorDAO.countByCoy(coyId);
  }

  @Override
  public int countByCoyVerifAndZipcode(int coyId, int verificatorId, String zipcodeCodePattern) {
    return masterZipcodeVerificatorDAO.countByCoyVerifAndZipcode(coyId, verificatorId, zipcodeCodePattern);
  }

  @Override
  public MasterZipcodeVerificator getByCoyVerifZipcodeAndSub(int coyId, String userCode, String zipcodeCode, String subZipcode) {
    return masterZipcodeVerificatorDAO.getByCoyVerifZipcodeAndSub(coyId, userCode, zipcodeCode, subZipcode);
  }

  @Override
  public List<MasterZipcodeVerificator> getByCoyVerif(int coyId, int userId) {
    return masterZipcodeVerificatorDAO.getByCoyVerif(coyId, userId);
  }

  @Override
  public String getMaxSubZipcodeByCoyAndZipcode(int coyId, int zipcodeId) {
    return masterZipcodeVerificatorDAO.getMaxSubZipcodeByCoyAndZipcode(coyId, zipcodeId);
  }

  @Override
  public List<MasterZipcodeVerificator> getByPageParentUser(int parentUserId, int pageNo) {
    return masterZipcodeVerificatorDAO.getByRangeParentUser(parentUserId, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByParentUser(int parentUserId) {
    return masterZipcodeVerificatorDAO.countByParentUser(parentUserId);
  }

  @Override
  public List<MasterZipcodeVerificator> getByPageParentUserVerifAndZipcode(int parentUserId, int verificatorId, String zipcodeCodePattern, int pageNo) {
    return masterZipcodeVerificatorDAO.getByRangeParentUserVerifAndZipcode(
            parentUserId, verificatorId, zipcodeCodePattern, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByParentUserVerifAndZipcode(int parentUserId, int verificatorId, String zipcodeCodePattern) {
    return masterZipcodeVerificatorDAO.countByParentUserVerifAndZipcode(parentUserId, verificatorId, zipcodeCodePattern);
  }

  @Override
  public List<MasterZipcodeVerificator> getByCoy(int coyId) {
    return masterZipcodeVerificatorDAO.getByCoy(coyId);
  }
}
