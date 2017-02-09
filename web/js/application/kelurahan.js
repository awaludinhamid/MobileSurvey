/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "kelId";
dropdownArr = ["provinsi"];

$(document).ready(function() {
  //
  var scope = $(elementScope).scope();
  
  //
  $("div.find-record").on("click","div.img-container>img#img-new-record",function() { 
    scope.prov = scope.datadrop.provinsi[0].provId;
    changeListCity(function() {
      scope.city = scope.datadrop.citybyprov[0].cityId;
      changeListKecamatan(function() {
        scope.kecamatan = scope.datadrop.kecbycity[0].kecId;
        changeListZipcode(function() {
          scope.zipcode = "";
        });
      });
    });
  });
  
  //
  $("table ").on("click","td>img#img-edit-record",function() {
    scope.prov = scope.dataarr.kecamatan.city.provinsi.provId;
    //we have to init the value to prevent it automatically filled null value with non-null value
    scope.zipcode = "";
    scope.kecamatan = "";
    changeListCity(function() {
      scope.city = scope.dataarr.kecamatan.city.cityId;
      changeListKecamatan(function() {
        scope.kecamatan = scope.dataarr.kecamatan.kecId;
        changeListZipcode(function() {           
          scope.zipcode = scope.dataarr.zipcode.zipcodeId;
          scope.$apply(); //apply scope change in separated object scope (in this case modal object)
        });
      });
    });
  });
  
  //
  $("form#form-save select#prov").change(function() {
    scope.datadrop.citybyprov = [];
    scope.datadrop.kecbycity = [];
    scope.datadrop.zipcodebykec = [];
    changeListCity(function() {
      scope.city = scope.datadrop.citybyprov[0].cityId;
      changeListKecamatan(function() {
        scope.kecamatan = scope.datadrop.kecbycity[0].kecId;
        changeListZipcode(function() {
          scope.zipcode = "";
        });
      });
    });
  });
  
  //
  $("form#form-save select#city").change(function() {
    scope.datadrop.kecbycity = [];
    scope.datadrop.zipcodebykec = [];
    changeListKecamatan(function() {
      scope.kecamatan = scope.datadrop.kecbycity[0].kecId;
        changeListZipcode(function() {
          scope.zipcode = "";
        });
    });
  });
  
  //
  $("form#form-save select#kecamatan").change(function() {
    scope.datadrop.zipcodebykec = [];
    changeListZipcode(function() {
      scope.zipcode = "";
    });
  });
  
  //
  function changeListCity(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","citybyprov",{provId: scope.prov}, function(response) {
      callback(response);
    });
  }
  
  //
  function changeListKecamatan(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","kecbycity",{cityId: scope.city}, function(response) {
      callback(response);
    });
  }
  
  //
  function changeListZipcode(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","zipcodebykec",{kecId: scope.kecamatan}, function(response) {
      callback(response);
    });
  }
});