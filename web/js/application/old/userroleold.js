/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "userRoleId";
objRelMap = [{name: "user", field: ["office.officeId","userId"]}];
dropdownArr = ["office","role"];
hideFieldOnUpdateArr = ["user-password","con-user-password"];
fieldIncludeCheckboxListArr = ["roles"];

$(document).ready(function() {
  //
  var scope = $("div#div-table").scope();
  var currUserArr = [];
  
  //
  datePicker("input#asOfDate");
  
  //
  $("table ").on("click","td>img#img-edit-record",function() { 
    $("form#form-save div:has(select#officeId)").prop("hidden",true);
    $("form#form-save div:has(select#userId)").prop("hidden",true);
    $("form#form-save div:has(input#officeName)").prop("hidden",false);
    $("form#form-save div:has(input#userCode)").prop("hidden",false);
    $("form#form-save select#officeId").val(scope.data.user.office.officeId);
    $("form#form-save select#userId").val(scope.data.user.userId);
    $("form#form-save input#officeName").val(scope.data.user.office.officeName);
    $("form#form-save input#userCode").val(scope.data.user.userCode);
    $("form#form-save input#userName").val(scope.data.user.userName);
    getRolesByUser(function(data) {
      $("form#form-save div#roles>div").each(function() {
        var thisObj = $(this);
        $.each(data,function(idx,val) {
          if(thisObj.data("id") === val.roleId) {
            thisObj.find("input:checkbox").prop("checked",true);
            return false;
          }
        });
      });      
    });
  });
  
  //
  $("div.find-record").on("click","div.img-container>img#img-new-record",function() { 
    $("form#form-save input:checkbox").prop("checked",false); 
    $("form#form-save div:has(select#officeId)").prop("hidden",false);
    $("form#form-save div:has(select#userId)").prop("hidden",false);
    $("form#form-save div:has(input#officeName)").prop("hidden",true);
    $("form#form-save div:has(input#userCode)").prop("hidden",true);
    changeListUserOffice();
  });
  
  //
  $("form#form-save select#officeId").change(function() {
    changeListUserOffice();
  });
  
  //
  $("form#form-save select#userId").change(function() {
    $("form#form-save input#userName").val(findCurrUserName($(this).val()));
  });
  
  //
  function changeListUserOffice() {
    scope.initDropdownCommon(relativePath+"apps/data","userbyoffice",{officeId: $("form#form-save select#officeId").val()}, function(response) {
      currUserArr = response.data;
      $("form#form-save input#userName").val(currUserArr[0].userName);
    });
  }
  
  //
  function getRolesByUser(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","rolebyuser",{userId: scope.data.user.userId}, function(response) {
      callback(response.data);
    });
  }
  
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