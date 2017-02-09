/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "taskId";
objRelMap = [{name: "user", field: [{column: "userId", id: "userId"}]},
              {name: "product", field: [{column: "productId", id: "productId"}]}];
dropdownArr = ["usercoordbyparent","userverifbyparent"];
replaceWithSaveImage = true;
masterListUpdateOnly = {updAssignObj: "select#verificatorId", updVarName: "userId", updListIdName: "taskIdList",
                        warnMessage: ["Pick up verificator first ..!"]};

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
  $("div.find-record select#coordinatorId").change(function() {
    changeListVerif(function() {
      scope.verificatorId = "0";
      $("div.find-record div.img-container>img#img-find-record").trigger("click");
    });
  });
  
  //
  function changeListVerif(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","userverifbyparent",{parentUserId: scope.coordinatorId}, function(response) {
      callback(response);
    });
  }
  
});