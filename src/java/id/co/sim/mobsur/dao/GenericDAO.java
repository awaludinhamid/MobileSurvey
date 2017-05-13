/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.dto.TaskVerifyDTO;
import id.co.sim.mobsur.bean.dto.support.OptionBean;
import id.co.sim.mobsur.bean.support.StringBean;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * DAO various object
 * @created Jan 9, 2017
 * @author awal
 */
@Repository("genericDAO")
public class GenericDAO {

  @Autowired
  private SessionFactory sessionFactory;
  
  //
  /**
   * Common lookup table
   * Get contents by table
   * @param tableName
   * @param columnQuery, list of columns in the form of query
   * @param pkColumnName, name of the primary key
   * @return list of table contents based on given table
   */
  public List<StringBean> getTableContents(String tableName, String columnQuery, String pkColumnName) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select " + pkColumnName + " id, " + columnQuery + " val " +
              "from " + tableName)
            .setResultTransformer(Transformers.aliasToBean(StringBean.class))
            .list();
  }
  
  /**
   * Get column by table
   * @param tableName
   * @return list of column names based on given table
   */
  public List<String> getColumnNames(String tableName) { // strict to PostgreSQL
    String tableSchema = "public";
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select column_name " +
              "from information_schema.columns " +
              "where table_schema = :tableSchema " +
                "and table_name = :tableName " +
                "and column_name not in ('created_by','created_date','updated_by','updated_date') " +
                "and column_name not like '%_id'")
            .setString("tableSchema", tableSchema)
            .setString("tableName", tableName.toLowerCase())
            .list();
  }
  
  /**
   * Get primary key by table
   * @param tableName
   * @return column name of the primary key based on given table
   */
  public String getPKColumnName(String tableName) {  // strict to PostgreSQL
    return (String) sessionFactory.getCurrentSession().createSQLQuery(
            "select a.column_name " +
              "from information_schema.key_column_usage a, " +
                "information_schema.table_constraints b " +
              "where a.table_name = :tableName " +
                "and b.constraint_type = 'PRIMARY KEY' " +
                "and a.table_name = b.table_name " +
                "and a.constraint_name = b.constraint_name")
            .setString("tableName", tableName.toLowerCase())
            .list().get(0);
  }
  
  /**
   * Get verified task by the task
   * @param taskId
   * @return list of verified tasks based on given task
   */  
  public List<TaskVerifyDTO> getByTask(int taskId) {
      return sessionFactory.getCurrentSession().createSQLQuery(
              "select a.product_id as productId, " +
                "b.temp_id as tempId, " +
                "c.detail_temp_id as detailTempid, " +
                "d.quest_group_id as questGroupId, d.quest_group_label as questGroupLabel, " +
                "e.detail_quest_group_id as detailQuestGroupId, " +
                "f.quest_id as questId, f.quest_label as questLabel, " +
                "g.task_id as taskId, " +
                "h.task_result_id as taskResultId, " +
                "i.task_result_det_id as taskResultDetId, " +
                "j.task_result_det_list_id as taskResultDetListId, j.created_by as createdBy, " +
                      "j.answer_id as answerId, j.answer_text as answerText, " +
                      "j.old_answer_id as oldAnswerId, j.old_answer_text as oldAnswerText, " +
                      "j.edit_answer_id as editAnswerId, j.edit_answer_text as editAnswerText, " +
                      "j.fin_answer_id as finAnswerId, j.fin_answer_text as finAnswerText, " +
                "get_answer_desc_func(f.option_answer_id, j.answer_id) as answerDesc, " +
                "get_answer_desc_func(f.option_answer_id, j.edit_answer_id) as editAnswerDesc, " +
                "get_answer_desc_func(f.option_answer_id, j.fin_answer_id) as finAnswerDesc " +
                "from master_product a " +
                "inner join master_template b " +
                "on (a.temp_id = b.temp_id) " +
                "inner join detail_template c " +
                "on (b.temp_id = c.temp_id) " +
                "inner join master_question_group d " +
                "on (c.quest_group_id = d.quest_group_id) " +
                "inner join detail_question_group e " +
                "on (d.quest_group_id = e.quest_group_id) " +
                "inner join master_question f " +
                "on (e.quest_id = f.quest_id) " +
                "inner join mobile_task_assignment g " +
                "on (g.product_id = a.product_id) " +
                "inner join mobile_task_result h " +
                "on (g.task_id = :taskId and g.task_id = h.task_id) " +
                "left join mobile_task_result_detail i " +
                "on (h.task_result_id = i.task_result_id and f.quest_id = i.quest_id) " +
                "left join mobile_task_result_detail_list j " +
                "on (j.image_id is null and i.task_result_det_id = j.task_result_det_id) " +
                "order by 1,2,3,4,5,6,7,8,9,10,11")
              .addScalar("productId")
              .addScalar("tempId")
              .addScalar("detailTempId")
              .addScalar("questGroupId")
              .addScalar("questGroupLabel")
              .addScalar("detailQuestGroupId")
              .addScalar("questId")
              .addScalar("questLabel")
              .addScalar("taskId")
              .addScalar("taskResultId")
              .addScalar("taskResultDetId")
              .addScalar("taskResultDetListId")
              .addScalar("answerId")
              .addScalar("answerText")
              .addScalar("oldAnswerId")
              .addScalar("oldAnswerText")
              .addScalar("editAnswerId")
              .addScalar("editAnswerText")
              .addScalar("finAnswerId")
              .addScalar("finAnswerText")
              .addScalar("createdBy")
              .addScalar("answerDesc")
              .addScalar("editAnswerDesc")
              .addScalar("finAnswerDesc")
              .setInteger("taskId", taskId)
              .setResultTransformer(Transformers.aliasToBean(TaskVerifyDTO.class))
              .list();
  }
  
  /**
   * Get verified task by result
   * @param taskResultId, result
   * @return list of verified tasks based on given result
   */
  public List<TaskVerifyDTO> getByTaskResult(int taskResultId) {
      return sessionFactory.getCurrentSession().createSQLQuery(
              "select a.product_id as productId, " +
                "b.temp_id as tempId, " +
                "c.detail_temp_id as detailTempid, " +
                "d.quest_group_id as questGroupId, d.quest_group_label as questGroupLabel, " +
                "e.detail_quest_group_id as detailQuestGroupId, " +
                "f.quest_id as questId, f.quest_label as questLabel, " +
                "g.task_id as taskId, " +
                "h.task_result_id as taskResultId, " +
                "i.task_result_det_id as taskResultDetId, " +
                "j.task_result_det_list_id as taskResultDetListId, j.created_by as createdBy, " +
                      "j.answer_id as answerId, j.answer_text as answerText, " +
                      "j.old_answer_id as oldAnswerId, j.old_answer_text as oldAnswerText, " +
                      "j.edit_answer_id as editAnswerId, j.edit_answer_text as editAnswerText, " +
                      "j.fin_answer_id as finAnswerId, j.fin_answer_text as finAnswerText, " +
                      "get_answer_desc_func(f.option_answer_id,j.answer_id) as answerDesc, " +
                      "get_answer_desc_func(f.option_answer_id,j.edit_answer_id) as editAnswerDesc, " +
                      "get_answer_desc_func(f.option_answer_id,j.fin_answer_id) as finAnswerDesc, " +
                      "k.group_param_id as groupParamId, k.table_name as tableName, k.option_answer_name as optionAnswerName, " +
                      "l.has_text as hasText " +
                      //"get_option_list_dyn_func(k.group_param_id, k.table_name) as optionList " +
                "from master_product a " +
                "inner join master_template b " +
                "on (a.temp_id = b.temp_id) " +
                "inner join detail_template c " +
                "on (b.temp_id = c.temp_id) " +
                "inner join master_question_group d " +
                "on (c.quest_group_id = d.quest_group_id) " +
                "inner join detail_question_group e " +
                "on (d.quest_group_id = e.quest_group_id) " +
                "inner join master_question f " +
                "on (e.quest_id = f.quest_id) " +
                "inner join master_option_answer k " +
                "on (f.option_answer_id = k.option_answer_id) " +
                "inner join master_answer_type l " +
                "on (f.answer_type_id = l.answer_type_id) " +
                "inner join mobile_task_assignment g " +
                "on (g.product_id = a.product_id) " +
                "inner join mobile_task_result h " +
                "on (h.task_result_id = :taskResultId and g.task_id = h.task_id) " +
                "inner join mobile_task_result_detail i " +
                "on (h.task_result_id = i.task_result_id and f.quest_id = i.quest_id) " +
                "left join mobile_task_result_detail_list j " +
                "on (i.task_result_det_id = j.task_result_det_id) " +
                "order by c.sort, e.sort")
                //"order by 1,2,3,4,5,6,7,8,9,10,11")
              .addScalar("productId")
              .addScalar("tempId")
              .addScalar("detailTempId")
              .addScalar("questGroupId")
              .addScalar("questGroupLabel")
              .addScalar("detailQuestGroupId")
              .addScalar("questId")
              .addScalar("questLabel")
              .addScalar("taskId")
              .addScalar("taskResultId")
              .addScalar("taskResultDetId")
              .addScalar("taskResultDetListId")
              .addScalar("answerId")
              .addScalar("answerText")
              .addScalar("oldAnswerId")
              .addScalar("oldAnswerText")
              .addScalar("editAnswerId")
              .addScalar("editAnswerText")
              .addScalar("finAnswerId")
              .addScalar("finAnswerText")
              .addScalar("answerDesc")
              .addScalar("editAnswerDesc")
              .addScalar("finAnswerDesc")
              .addScalar("groupParamId")
              .addScalar("tableName")
              .addScalar("optionAnswerName")
              .addScalar("hasText")
              //.addScalar("optionList")
              .addScalar("createdBy")
              .setInteger("taskResultId", taskResultId)
              .setResultTransformer(Transformers.aliasToBean(TaskVerifyDTO.class))
              .list();
  }
  
  /**
   * Get option data by parameter or table
   * @param groupParamId
   * @param tableName
   * @return list of options based on given parameter and table
   */
  public List<OptionBean> getOptionList(Integer groupParamId, String tableName) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select id, descr " +
              "from get_option_list_dyn_func(:groupParamId, :tableName)")
            .addScalar("id")
            .addScalar("descr")
            .setString("tableName", tableName)
            .setParameter("groupParamId", groupParamId, IntegerType.INSTANCE)
            .setResultTransformer(Transformers.aliasToBean(OptionBean.class))
            .list();
  }
}
