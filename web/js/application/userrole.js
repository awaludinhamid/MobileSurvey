/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "userRoleId";
objRelMap = [{name: "user", field: ["userId"]},{name: "role", field: ["roleId"]}];
dropdownArr = ["office","role"];

$(document).ready(function() {
  //
  var scope = $("div#div-table").scope();
  var currUserArr = [];
  
  //
  datePicker("input#asOfDate");
  
  //
  $("table ").on("click","td>img#img-edit-record",function() { 
    $("form#form-save div:has(select#officeId)").prop("hidden",true);
    $("form#form-save div:has(select#userIdTemp)").prop("hidden",true);
    $("form#form-save div:has(input#officeName)").prop("hidden",false);
    $("form#form-save div:has(input#userCode)").prop("hidden",false);
    $("form#form-save input#officeName").val(scope.data.user.office.officeName);
    $("form#form-save input#userCode").val(scope.data.user.userCode);
    $("form#form-save input#userName").val(scope.data.user.userName);
  });
  
  //
  $("div.find-record").on("click","div.img-container>img#img-new-record",function() { 
    $("form#form-save div:has(select#officeId)").prop("hidden",false);
    $("form#form-save div:has(select#userIdTemp)").prop("hidden",false);
    $("form#form-save div:has(input#officeName)").prop("hidden",true);
    $("form#form-save div:has(input#userCode)").prop("hidden",true);
    changeListUserOffice();
  });
  
  //
  $("form#form-save select#officeId").change(function() {
    changeListUserOffice();
  });
  
  //
  $("form#form-save select#userIdTemp").change(function() {
    $("form#form-save input#userId").val($(this).val());
    $("form#form-save input#userName").val(findCurrUserName($(this).val()));
  });
  
  //
  $("table ").on("click","td>img#img-menu-record",function() {
    scope.initDropdownCommon(relativePath+"apps/data","rolemenubyrole",{roleId: scope.data.role.roleId}, function(response) {
      $("div#mdl-menu-list").modal("show");
    });
  });
  
  //
  function changeListUserOffice(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","userbyoffice",{officeId: $("form#form-save select#officeId").val()}, function(response) {
      currUserArr = response.data;
      $("form#form-save input#userId").val(currUserArr[0].userId);
      $("form#form-save input#userName").val(currUserArr[0].userName);
      callback();
    });
  }
  
  //
  /*function getRolesByUser(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","rolebyuser",{userId: scope.data.user.userId}, function(response) {
      callback(response.data);
    });
  }*/
  
  //
  function findCurrUserName(userId) {
    var userName = "";
    $.each(currUserArr,function(idx,val) {
      if(val.userId+"" === userId) {
        userName = val.userName;
        return false;
      }
    });
    return userName;
  }

});