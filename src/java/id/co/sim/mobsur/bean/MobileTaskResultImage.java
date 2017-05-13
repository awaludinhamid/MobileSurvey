/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * POJO table MOBILE_TASK_RESULT_IMAGE
 * @created Feb 13, 2017
 * @author awal
 */
@Entity
@Table(name="MOBILE_TASK_RESULT_IMAGE")
@SuppressWarnings("PersistenceUnitPresent")
public class MobileTaskResultImage implements Serializable {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="IMAGE_ID")
  private int imageId;
  @Column(name="IMAGE")
  private byte[] image;

  /**
   * @return the imageId
   */
  public int getImageId() {
    return imageId;
  }

  /**
   * @param imageId the imageId to set
   */
  public void setImageId(int imageId) {
    this.imageId = imageId;
  }

  /**
   * @return the image
   */
  public byte[] getImage() {
    return image;
  }

  /**
   * @param image the image to set
   */
  public void setImage(byte[] image) {
    this.image = image;
  }
}
