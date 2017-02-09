/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  
//
dataIdField = "zipcodeId";
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
        changeListKelurahan(function() {
          scope.kelurahan = scope.datadrop.kelbykec[0].kelId;
        });
      });
    });
  });
  
  //
  $("table ").on("click","td>img#img-edit-record",function() {
    scope.prov = scope.dataarr.kelurahan.kecamatan.city.provinsi.provId;
    changeListCity(function() {
      scope.city = scope.dataarr.kelurahan.kecamatan.city.cityId;
      changeListKecamatan(function() {
        scope.kecamatan = scope.dataarr.kelurahan.kecamatan.kecId;
        changeListKelurahan(function() {
          scope.kelurahan = scope.dataarr.kelurahan.kelId;
        });
      });
    });
  });
  
  //
  $("form#form-save select#prov").change(function() {
    changeListCity(function() {
      scope.city = scope.datadrop.citybyprov[0].cityId;
      changeListKecamatan(function() {
        scope.kecamatan = scope.datadrop.kecbycity[0].kecId;
        changeListKelurahan(function() {
          scope.kelurahan = scope.datadrop.kelbykec[0].kelId;
        });
      });
    });
  });
  
  //
  $("form#form-save select#city").change(function() {
    changeListKecamatan(function() {
      scope.kecamatan = scope.datadrop.kecbycity[0].kecId;
      changeListKelurahan(function() {
        scope.kelurahan = scope.datadrop.kelbykec[0].kelId;
      });
    });
  });
  
  //
  $("form#form-save select#kecamatan").change(function() {
    changeListKelurahan(function() {
      scope.kelurahan = scope.datadrop.kelbykec[0].kelId;
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
  function changeListKelurahan(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","kelbykec",{kecId: scope.kecamatan}, function(response) {
      callback(response);
    });
  }
});