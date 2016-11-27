/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import id.co.sim.mobsur.bean.support.RecordControllerBean;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @created Oct 14, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_PARENT_MENU")
public class MasterParentMenu extends RecordControllerBean implements Serializable {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="PARENT_MENU_ID")
  private int parentMenuId;
  @Column(name="PARENT_MENU_NAME")
  private String parentMenuName;
  @Column(name="PARENT_MENU_DESC")
  private String parentMenuDesc;
  @JsonBackReference
  @OneToMany(mappedBy="parentMenu")
  private List<MasterMenu> menus;

  /**
   * @return the parentMenuId
   */
  public int getParentMenuId() {
    return parentMenuId;
  }

  /**
   * @param parentMenuId the parentMenuId to set
   */
  public void setParentMenuId(int parentMenuId) {
    this.parentMenuId = parentMenuId;
  }

  /**
   * @return the parentMenuName
   */
  public String getParentMenuName() {
    return parentMenuName;
  }

  /**
   * @param parentMenuName the parentMenuName to set
   */
  public void setParentMenuName(String parentMenuName) {
    this.parentMenuName = parentMenuName;
  }

  /**
   * @return the parentMenuDesc
   */
  public String getParentMenuDesc() {
    return parentMenuDesc;
  }

  /**
   * @param parentMenuDesc the parentMenuDesc to set
   */
  public void setParentMenuDesc(String parentMenuDesc) {
    this.parentMenuDesc = parentMenuDesc;
  }

  /**
   * @return the menus
   */
  public List<MasterMenu> getMenus() {
    return menus;
  }

  /**
   * @param menus the menus to set
   */
  public void setMenus(List<MasterMenu> menus) {
    this.menus = menus;
  }
}
