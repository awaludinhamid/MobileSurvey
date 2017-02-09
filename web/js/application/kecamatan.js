/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "kecId";
dropdownArr = ["provinsi"];

$(document).ready(function() {
  //
  var scope = $(elementScope).scope();
  
  //
  $("div.find-record").on("click","div.img-container>img#img-new-record",function() { 
    scope.prov = scope.datadrop.provinsi[0].provId;
    changeListCity(function() {
      scope.city = scope.datadrop.citybyprov[0].cityId;
    });
  });
  
  //
  $("table ").on("click","td>img#img-edit-record",function() {
    scope.prov = scope.dataarr.city.provinsi.provId;
    scope.city = ""; //we have to init the value to prevent it automatically filled null value with non-null value
    changeListCity(function() {  
      scope.city = scope.dataarr.city.cityId;
      scope.$apply();
    });
  });
  
  //
  $("form#form-save select#prov").change(function() {
    scope.datadrop.citybyprov = [];
    changeListCity(function() {
      scope.city = scope.datadrop.citybyprov[0].cityId;
    });
  });
  
  //
  function changeListCity(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","citybyprov",{provId: scope.prov}, function(response) {
      callback(response);
    });
  }
});