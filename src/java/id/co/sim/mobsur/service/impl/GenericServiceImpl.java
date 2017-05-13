/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service.impl;

import id.co.sim.mobsur.bean.DetailGroupParam;
import id.co.sim.mobsur.bean.dto.TaskVerifyDTO;
import id.co.sim.mobsur.bean.dto.support.OptionBean;
import id.co.sim.mobsur.bean.support.ContentsBean;
import id.co.sim.mobsur.bean.support.StringBean;
import id.co.sim.mobsur.dao.DetailGroupParamDAO;
import id.co.sim.mobsur.dao.GenericDAO;
import id.co.sim.mobsur.service.GenericService;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Various service implementation (see the service for usage info)
 * @created Jan 9, 2017
 * @author awal
 */
@Service("genericService")
@Transactional(readOnly=true)
public class GenericServiceImpl implements GenericService {

  // DAO injection
  @Autowired
  private GenericDAO genericDAO;
  @Autowired
  private DetailGroupParamDAO detailGroupParamDAO;

  @Override
  public ContentsBean getTableContents(String tableName, int groupParamId, String delimiter) {
    ContentsBean cb = new ContentsBean();
    String tableNameTmp = tableName.replace(" ", ""); // avoid other sql injected than the table name
    String pkColumnName = genericDAO.getPKColumnName(tableNameTmp);
    List<String> colNames = genericDAO.getColumnNames(tableNameTmp);
    //Get table headers/column
    List<String> headers = new ArrayList();
    for(String colName : colNames)
      headers.add(WordUtils.capitalizeFully(colName.replace("_", " ")));
    cb.setTableHeaders(headers);
    //Generate table data (contents)
    if(groupParamId == 0) {//access via table itself
      StringBuilder columns = new StringBuilder();
      String colDelimiter = "||'" + delimiter + "'||";
      for(String colName : colNames)
        columns.append(colName).append(colDelimiter);
      cb.setTableContents(genericDAO.getTableContents(tableNameTmp, columns.substring(0, columns.lastIndexOf(colDelimiter)), pkColumnName));
     } else { //access via table group parameter
     List<StringBean> sbList = new ArrayList();
     List<DetailGroupParam> dgpList = detailGroupParamDAO.getByGroupParamId(groupParamId);
     for(DetailGroupParam dgp : dgpList) {
       StringBean sb = new StringBean();
       sb.setId(dgp.getDetailGroupParamId());
       sb.setVal(dgp.getDetailGroupParamCode() + delimiter + dgp.getDetailGroupParamName()); 
       sbList.add(sb);
     }
     cb.setTableContents(sbList);
    }
    return cb;
  }

    @Override
    public List<TaskVerifyDTO> getByTask(int taskId) {
        return genericDAO.getByTask(taskId);
    }

  @Override
  public List<TaskVerifyDTO> getByTaskResult(int taskResultId) {
    return genericDAO.getByTaskResult(taskResultId);
  }

  @Override
  public List<OptionBean> getOptionList(Integer groupParamId, String tableName) {
    return genericDAO.getOptionList(groupParamId, tableName);
  }
}
