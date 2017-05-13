/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to distribution page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "distId";
disableObjArr = [{fieldName: "Office Name", fieldValue: "office.officeName"},
                  {fieldName: "Role Name", fieldValue: "roleAssignTo.roleName"}];
objRelMap = [{name: "roleAssignTo", field: [{column: "roleId", id: "roleId"}]}];
dropdownArr = ["roleassigndist","office"];

$("div#distribution").ready(function() {
  
  var currDiv = "div#distribution";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  
  if($(currDiv).length) {
    
    //initial assigned value to load balance and round robin element
    $(currDiv + " form#form-save input#loadBalance").val("L");
    $(currDiv + " form#form-save input#roundRobin").val("R");
  }
  
  /**
   * event: click new button
   * action: re-assign office and auto distribution value into default
   */
  $(currDiv + " div.find-record").on("click","div.img-container>img#img-new-record",function() { 
    scope.office = scope.datadrop.office[0];
    scope.isAutoDist = false;
    scope.$apply();
  });
  
  /**
   * event: change/choose the office list value
   * action: not yet
   */
  $(currDiv + " form#form-save select#officeId").change(function() {
    //prepare for future purpose
  });
  
  /**
   * event: click edit button
   * action: assign office and auto distribution value into clicked record value
   */
  $(currDiv + " table ").on("click","td>img#img-edit-record",function() {
    scope.office = scope.dataarr.office;
    scope.isAutoDist = scope.dataarr.isAutoDist === "true";
    scope.$apply();
  });
  
  /**
   * Get office name by given id
   * (not yet implementation)
   * @param {String} id
   * @returns String
   */
  function getOfficeName(id) {
    var officeName = "";
    $.each(scope.datadrop.office,function(idx,val) {
      if(val.officeId + "" === id) {
        officeName = val.officeName;
        return false;
      }
    });
    return officeName;
  }
});