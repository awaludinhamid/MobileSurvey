/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to kelurahan page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "kelId";
disableObjArr = [{fieldName: "Kelurahan Code", fieldValue: "kelCode"},
                  {fieldName: "Kelurahan Name", fieldValue: "kelName"}];
dropdownArr = ["provinsi"];

$("div#kelurahan").ready(function() {
  
  var currDiv = "div#kelurahan";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  
  /**
   * event: click new button
   * action: assign zipcode list to default
   *         assign provinsi, city and kecamatan value to default
   *         reload city list and kecamatan list
   */
  $(currDiv + " div.find-record").on("click","div.img-container>img#img-new-record",function() { 
    scope.datadrop.zipcodebypattern = [];
    scope.prov = scope.datadrop.provinsi[0];
    changeListCityKel(scope.prov.provId,function() {
      scope.city = scope.datadrop.citybyprov[0];
      changeListKecamatan(scope.city.cityId,function() {
        scope.kecamatan = scope.datadrop.kecbycity[0];
      });
    });
  });
  
  /**
   * event: click edit button
   * action: assign zipcode list to default
   *         assign provinsi, city, kecamatan and zipcode value to current value
   *         reload city, kecamatan and zipcode list
   */
  $(currDiv + " table ").on("click","td>img#img-edit-record",function() {
    scope.datadrop.zipcodebypattern = [];
    scope.prov = scope.dataarr.kecamatan.city.provinsi;
    scope.kecamatan = "";
    changeListCityKel(scope.prov.provId,function() {
      scope.city = scope.dataarr.kecamatan.city;
      changeListKecamatan(scope.city.cityId,function() {
        scope.kecamatan = scope.dataarr.kecamatan;
        if(scope.dataarr.zipcode) {
          changeListZipcode(scope.dataarr.zipcode.zipcodeCode);
        }        
        scope.zipcode = scope.dataarr.zipcode.zipcodeId;
      });
    });
  });
  
  /**
   * event: change/choose provinsi list value
   * action: assign city, kecamatan and zipcode list to default
   *         assign city and kecamatan value to default
   *         reload city and kecamatan list
   */
  $(currDiv + " form#form-save select#provId").change(function() {
    scope.datadrop.citybyprov = [];
    scope.datadrop.kecbycity = [];
    scope.datadrop.zipcodebykec = [];
    changeListCityKel($(this).val(),function() {
      scope.city = scope.datadrop.citybyprov[0];
      changeListKecamatan(scope.city.cityId,function() {
        scope.kecamatan = scope.datadrop.kecbycity[0];
      });
    });
  });
  
  /**
   * event: change/choose city list value
   * action: assign kecamatan and zipcode list to default
   *         reload kecamatan list
   *         assign kecamatan value to default
   */
  $(currDiv + " form#form-save select#cityId").change(function() {
    scope.datadrop.kecbycity = [];
    scope.datadrop.zipcodebykec = [];
    changeListKecamatan($(this).val(),function() {
      scope.kecamatan = scope.datadrop.kecbycity[0];
    });
  });
  
  /**
   * event: change/choose kecamatan list value
   * action: undefined
   */
  $(currDiv + " form#form-save select#kecamatan").change(function() {
    //not yet implemented
  });
  
  /**
   * event: click load zipcode button
   * action: reload zipcode list based on given pattern
   */
  $(currDiv + " form#form-save button#btn-load-zipcode").click(function() {
    var patternCode = $("form#form-save input#patternCode").val();    
    if(patternCode.length < 2)
      alert("Search result too large, enter more character ..!");
    else
      changeListZipcode(patternCode);
  });
  
  /**
   * Reload city list by provinsi
   * @param {Number} provId , provinsi
   * @param {Function} callback
   * @returns void
   */
  function changeListCityKel(provId,callback) {
    scope.initDropdownCommon(relativePath+"apps/data","citybyprov",{provId: provId}, function(response) {
      callback(response);
    });
  }
  
  /**
   * Reload kecamatan list by city
   * @param {Number} cityId , city
   * @param {Function} callback
   * @returns void
   */
  function changeListKecamatan(cityId,callback) {
    scope.initDropdownCommon(relativePath+"apps/data","kecbycity",{cityId: cityId}, function(response) {
      callback(response);
    });
  }
  
  /**
   * Reload zipcode list by pattern
   * @param {String} patternCode
   * @param {Function} callback
   * @returns void
   */
  function changeListZipcode(patternCode,callback) {
    scope.initDropdownCommon(relativePath+"apps/data","zipcodebypattern",{patternCode: patternCode}, function(response) {
      callback(response);
    });
  }
});