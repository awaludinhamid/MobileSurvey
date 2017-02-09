/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "taskId";
dropdownArr = ["roleassigndist"];
replaceWithSaveImage = true;
masterListUpdateOnly = {updAssignObj: "select#assignedId", updCommissionObj: "select#commissionedId",
                        updVarName: "userId", updListIdName: "taskIdList",
                        warnMessage: ["Pick up rolling to first ..!","Pick up rolling from first ..!","Rolling from and rolling to must be different ..!"]};

$(document).ready(function() {
  //
  var scope = $(elementScope).scope();
  
  //
  $("table#tbl-data input#inputVerifAll").change(function() {
    if($(this).prop("checked"))
      $("table#tbl-data>tbody input:checkbox").prop("checked",true);
    else
      $("table#tbl-data>tbody input:checkbox").prop("checked",false);
  }); 
  
  //
  $("div.find-record select#roleId").change(function() {
    changeListRole(function() {
      scope.commissionedId = "0";
      scope.assignedId = "0";
      $("div.find-record div.img-container>img#img-find-record").trigger("click");
    });
  });
  
  //
  $("div.find-record select#commissionedId").change(function() {
    $("div.find-record div.img-container>img#img-find-record").trigger("click");
  });
  
  //
  function changeListRole(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","userbyroleparent",{roleId: scope.roleId}, function(response) {
      callback(response);
    });
  }
  
});