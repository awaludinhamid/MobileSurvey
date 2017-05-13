/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to zipcode page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "zipcodeId";
disableObjArr = [{fieldName: "Zipcode Code", fieldValue: "zipcodeCode"},
                  {fieldName: "Description", fieldValue: "zipcodeDesc"}];

$("div#zipcode").ready(function() {
  
  var currDiv = "div#zipcode";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  
  /**
   * event: click new button
   * action: currently no action
   */
  $(currDiv + " div.find-record").on("click","div.img-container>img#img-new-record",function() { 
    //not yet implemented
  });
  
  /**
   * event: click edit button
   * action: currently no action
   */
  $(currDiv + " table ").on("click","td>img#img-edit-record",function() {
    //not yet implemented
  });
  
  /**
   * event: change/choose provinsi list value
   * action: currently no action
   */
  $(currDiv + " form#form-save select#provId").change(function() {
    //not yet implemented
  });
  
  /**
   * Reload city list by provinsi (not yet implemented)
   * @param {Number} provId , provinsi id
   * @param {Function} callback
   * @returns {void}
   */
  function changeListCityZip(provId,callback) {
    scope.initDropdownCommon(relativePath+"apps/data","citybyprov",{provId: provId}, function(response) {
      callback(response);
    });
  }
  
});