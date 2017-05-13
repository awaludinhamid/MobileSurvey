/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to kecamatan page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "kecId";
disableObjArr = [{fieldName: "Kecamatan Code", fieldValue: "kecCode"},
                  {fieldName: "Kecamatan Name", fieldValue: "kecName"}];
dropdownArr = ["provinsi"];

$("div#kecamatan").ready(function() {
  
  var currDiv = "div#kecamatan";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  
  /**
   * event: click new button
   * action: reload city list
   */
  $(currDiv + " div.find-record").on("click","div.img-container>img#img-new-record",function() { 
    scope.prov = scope.datadrop.provinsi[0];
    changeListCity(scope.prov.provId,function() {
      scope.city = scope.datadrop.citybyprov[0].cityId;
    });
  });
  
  /**
   * event: click edit button
   * action: assign scope of provinsi value and reload city list
   */
  $(currDiv + " table ").on("click","td>img#img-edit-record",function() {
    scope.prov = scope.dataarr.city.provinsi;
    scope.city = ""; //we have to init the value to prevent it automatically filled null value with non-null value
    changeListCity(scope.prov.provId,function() {  
      scope.city = scope.dataarr.city.cityId;
      scope.$apply();
    });
  });
  
  /**
   * event: change/choose provinsi list value
   * action: reload city list and assign city value
   */
  $(currDiv + " form#form-save select#provId").change(function() {
    changeListCity($(this).val(),function() {
      scope.city = scope.datadrop.citybyprov[0].cityId;
    });
  });
  
  /**
   * Reload city list by provinsi
   * @param {Number} provId , provinsi
   * @param {Function} callback
   * @returns void
   */
  function changeListCity(provId,callback) {
    scope.initDropdownCommon(relativePath+"apps/data","citybyprov",{provId: provId}, function(response) {
      callback(response);
    });
  }
});