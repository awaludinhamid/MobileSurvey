/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.dao;

import id.co.sim.mobsur.bean.support.StringBean;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @created Jan 9, 2017
 * @author awal
 */
@Repository("genericDAO")
public class GenericDAO {

  @Autowired
  private SessionFactory sessionFactory;
  
  //common lookup table
  public List<StringBean> getTableContents(String tableName, String columnQuery, String pkColumnName) {
    return sessionFactory.getCurrentSession().createSQLQuery(
            "select " + pkColumnName + " id, " + columnQuery + " val " +
              "from " + tableName)
            .setResultTransformer(Transformers.aliasToBean(StringBean.class))
            .list();
  }
  
  //
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
  
  //
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
}
