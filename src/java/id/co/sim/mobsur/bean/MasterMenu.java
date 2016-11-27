/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import id.co.sim.mobsur.bean.support.RecordControllerBean;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @created Oct 14, 2016
 * @author awal
 */
@Entity
@Table(name="MASTER_MENU")
public class MasterMenu extends RecordControllerBean implements Serializable {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="MENU_ID")
  private int menuId;
  @Column(name="MENU_NAME")
  private String menuName;
  @Column(name="MENU_DESC")
  private String menuDesc;
  @Column(name="MENU_PAGE")
  private String menuPage;
  @Column(name="SORT")
  private int sort;
  @Column(name="ICON_PATH")
  private String iconPath;
  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name="PARENT_MENU_ID")
  private MasterParentMenu parentMenu;
  @JsonBackReference
  @OneToMany(mappedBy="menu")
  private List<MasterRoleMenu> roleMenus;

  /**
   * @return the menuId
   */
  public int getMenuId() {
    return menuId;
  }

  /**
   * @param menuId the menuId to set
   */
  public void setMenuId(int menuId) {
    this.menuId = menuId;
  }

  /**
   * @return the menuName
   */
  public String getMenuName() {
    return menuName;
  }

  /**
   * @param menuName the menuName to set
   */
  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }

  /**
   * @return the menuDesc
   */
  public String getMenuDesc() {
    return menuDesc;
  }

  /**
   * @param menuDesc the menuDesc to set
   */
  public void setMenuDesc(String menuDesc) {
    this.menuDesc = menuDesc;
  }

  /**
   * @return the menuPage
   */
  public String getMenuPage() {
    return menuPage;
  }

  /**
   * @param menuPage the menuPage to set
   */
  public void setMenuPage(String menuPage) {
    this.menuPage = menuPage;
  }

  /**
   * @return the sort
   */
  public int getSort() {
    return sort;
  }

  /**
   * @param sort the sort to set
   */
  public void setSort(int sort) {
    this.sort = sort;
  }

  /**
   * @return the parentMenu
   */
  public MasterParentMenu getParentMenu() {
    return parentMenu;
  }

  /**
   * @param parentMenu the parentMenu to set
   */
  public void setParentMenu(MasterParentMenu parentMenu) {
    this.parentMenu = parentMenu;
  }

  /**
   * @return the iconPath
   */
  public String getIconPath() {
    return iconPath;
  }

  /**
   * @param iconPath the iconPath to set
   */
  public void setIconPath(String iconPath) {
    this.iconPath = iconPath;
  }

  /**
   * @return the roleMenus
   */
  public List<MasterRoleMenu> getRoleMenus() {
    return roleMenus;
  }

  /**
   * @param roleMenus the roleMenus to set
   */
  public void setRoleMenus(List<MasterRoleMenu> roleMenus) {
    this.roleMenus = roleMenus;
  }
}
