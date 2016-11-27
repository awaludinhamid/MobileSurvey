/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean.support;

/**
 * @created Oct 19, 2016
 * @author awal
 */
public class UserMenuBean {

  private String parent;
  private String menu;
  private String menuUrl;
  private String iconPath;

  /**
   * @return the parent
   */
  public String getParent() {
    return parent;
  }

  /**
   * @param parent the parent to set
   */
  public void setParent(String parent) {
    this.parent = parent;
  }

  /**
   * @return the menu
   */
  public String getMenu() {
    return menu;
  }

  /**
   * @param menu the menu to set
   */
  public void setMenu(String menu) {
    this.menu = menu;
  }

  /**
   * @return the menuUrl
   */
  public String getMenuUrl() {
    return menuUrl;
  }

  /**
   * @param menuUrl the menuUrl to set
   */
  public void setMenuUrl(String menuUrl) {
    this.menuUrl = menuUrl;
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
}
