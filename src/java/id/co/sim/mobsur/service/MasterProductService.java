/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.service;

import id.co.sim.mobsur.bean.MasterProduct;
import java.util.List;

/**
 * SPI of product module
 * @created Jan 5, 2017
 * @author awal
 */
public interface MasterProductService {

  /**
   * Save given product
   * @param mp, product
   * @return saved product
   */
  MasterProduct save(MasterProduct mp);
  
  /**
   * Delete given product
   * @param mp, product
   */
  void delete(MasterProduct mp);
  
  /**
   * Get product by id
   * @param productId
   * @return product based on given id
   */
  MasterProduct getById(int productId);
  
  /**
   * Get product data by page
   * @param pageNo, page number to proceed
   * @return list of products based on given page
   */
  List<MasterProduct> getByPage(int pageNo);
  
  /**
   * Get product data by page and company
   * @param coyId, company
   * @param pageNo, page number to proceed
   * @return list of products based on given page and company
   */
  List<MasterProduct> getByPageCoy(int coyId, int pageNo);
  
  /**
   * Get product data by page, company and product name pattern/partial
   * @param coyId, company
   * @param productNamePattern
   * @param pageNo, page number to proceed
   * @return list of products based on given page, company and product name pattern
   */
  List<MasterProduct> getByPageCoyAndName(int coyId, String productNamePattern, int pageNo);
  
  /**
   * Get number of all product data
   * @return count of all products
   */
  int count();
  
  /**
   * Get number of product data by company
   * @param coyId, company
   * @return count of products based on given company
   */
  int countByCoy(int coyId);
  
  /**
   * Get number of product data by company and product name pattern
   * @param coyId, company
   * @param productNamePattern
   * @return count of products based on given company and product name pattern
   */
  int countByCoyAndName(int coyId, String productNamePattern);
  
  /**
   * Get number of product data by template
   * @param tempId, template
   * @return count of products based on given template
   */
  int countByTemplate(int tempId);
}
