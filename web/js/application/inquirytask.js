/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "taskId";
dropdownArr = ["office","taskstatus","template"];
showFindImgOnly = true;      
masterFindOnlyArr = [{fieldToCheck: ["select#coordinatorId"], message: "Must be picked up coordinator at least to proceed ..!"}];

$(document).ready(function() {
  //
  var scope = $(elementScope).scope();
  
  //
  datePicker("input#startDateFind");
  datePicker("input#endDateFind");
  
  //
  scope.getDataCommon(relativePath + "apps/data/iscoordinator",{},function(response) {
    if(response.data.val === "true") {
      $("div.find-record select#officeId").hide();
      $("div.find-record input#officeLbl").show();
      $("div.find-record select#coordinatorId").hide();
      $("div.find-record input#coordinatorLbl").show();
    } 
  });
  
  //
  $("div.find-record select#officeId").change(function() {
    changeListCoord(function() {
      scope.coordinatorId = "0";
      scope.datadrop.userverifbyparent = [];
    });
  });
  
  //
  $("div.find-record select#coordinatorId").change(function() {
    if(scope.coordinatorId === "0") {
      scope.datadrop.userverifbyparent = [];
      scope.verificatorId = "0";
      scope.$apply();
    } else {
      changeListVerif(function() {
        scope.verificatorId = "0";
      });
    }
  });
  
  //
  function changeListVerif(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","userverifbyparent",{parentUserId: scope.coordinatorId}, function(response) {
      callback(response);
    });
  }
  
  //
  function changeListCoord(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","coordbyofficerole",{officeId: scope.officeId}, function(response) {
      callback(response);
    });
  }
  
});