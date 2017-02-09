/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "userRoleId";
objRelMap = [{name: "user", field: [{column: "userId", id: "userId"}]},{name: "role", field: [{column: "roleId", id: "roleId"}]}];
dropdownArr = ["office","rolebyrole"];

$(document).ready(function() {
  //
  var scope = $(elementScope).scope();
  var isNew = true; //what kind of process currently running ('new' or 'edit', next maybe 'delete' also)
  
  //
  datePicker("input#asOfDate");
  
  //
  $("table ").on("click","td>img#img-edit-record",function() { 
    isNew = false;
    scope.$apply(function() { // i was wonder why this statement must be called
      scope.user = scope.dataarr.user;
      scope.office = scope.user.office;
    });
    $("form#form-save div:has(select#userIdTemp)").prop("hidden",true);
    $("form#form-save div:has(label#userCode)").prop("hidden",false);
  });
  
  //
  $("div.find-record").on("click","div.img-container>img#img-new-record",function() { 
    isNew = true;
    scope.$apply(function() { 
      scope.office = scope.datadrop.office[0];
    });
    $("form#form-save select#officeId").prop("disabled",false);
    $("form#form-save div:has(select#userIdTemp)").prop("hidden",false);
    $("form#form-save div:has(label#userCode)").prop("hidden",true);
    changeListUserOffice();
  });
  
  //
  $("form#form-save select#officeId").change(function() {
    if(isNew)
      changeListUserOffice();
  });
  
  //
  $("table ").on("click","td>img#img-menu-record",function() {
    scope.initDropdownCommon(relativePath+"apps/data","rolemenubyrole",{roleId: scope.dataarr.role.roleId}, function(response) {
      $("div#mdl-menu-list").modal("show");
    });
  });
  
  //
  function changeListUserOffice(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","userbyoffice",{officeId: scope.office.officeId}, function(response) {
      scope.user = scope.datadrop.userbyoffice[0];
      callback();
    });
  }

});