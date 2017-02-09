/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  
//
dataIdField = "distId";
objRelMap = [{name: "roleAssignTo", field: [{column: "roleId", id: "roleId"}]}];
dropdownArr = ["roleassigndist","office"];

$(document).ready(function() {
  //
  var scope = $(elementScope).scope();
  
  //
  $("form#form-save input#loadBalance").val("L");
  $("form#form-save input#roundRobin").val("R");
  
  //
  $("div.find-record").on("click","div.img-container>img#img-new-record",function() { 
    scope.$apply(function() { // i thought this is very weird for angular model always reflected the change
      scope.office = scope.datadrop.office[0];
    });
    $("form#form-save input#officeName").val(scope.office.officeName);
  });
  
  //
  $("form#form-save select#officeId").change(function() {
    $("form#form-save input#officeName").val(scope.office.officeName);
  });
  
  //
  $("table ").on("click","td>img#img-edit-record",function() {
    scope.$apply(function() { // hey, we did it again here :(
      scope.office = scope.dataarr.office;
      scope.isAutoDist = scope.dataarr.isAutoDist === "true";
    });
    $("form#form-save input#officeName").val(scope.office.officeName);
  });
  
});