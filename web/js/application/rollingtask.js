/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to role page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "taskId";
dropdownArr = ["roleassigndist"];
replaceWithSaveImage = true;
masterListUpdateOnly = {updAssignObj: "select#assignedId", updCommissionObj: "select#commissionedId",
                        updVarName: "userId", updListIdName: "taskIdList",
                        warnMessage: ["Pick up rolling to first ..!","Pick up rolling from first ..!","Rolling from and rolling to must be different ..!"]};
hasExtraClass = true;

$("div#rollingtask").ready(function() {
  
  var currDiv = "div#rollingtask";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  
  /**
   * event: [un]checked the checkbox all
   * action: switched detail checkbox align with the checkbox all value
   */
  $(currDiv + " table#tbl-data input#inputVerifAll").change(function() {
    if($(this).prop("checked"))
      $("table#tbl-data>tbody input:checkbox").prop("checked",true);
    else
      $("table#tbl-data>tbody input:checkbox").prop("checked",false);
  }); 
  
  /**
   * event: change/choose role list value
   * action: assign commissioned id and assigned id value to default
   *         execute find button on click trigger
   */
  $(currDiv + " div.find-record select#roleId").change(function() {
    changeListRole($(this).val(),function() {
      scope.commissionedId = "0";
      scope.assignedId = "0";
      scope.$apply();
      $("div.find-record div.img-container>img#img-find-record").trigger("click");
    });
  });
  
  /**
   * event: change/choose commissioned id list value
   * action: assign commissioned id to the current data, assigned id value to default
   *         execute find button on click trigger
   */
  $(currDiv + " div.find-record select#commissionedId").change(function() {
    scope.commissionedId = $(this).val();
    scope.assignedId = "0";
    scope.$apply();
    $("div.find-record div.img-container>img#img-find-record").trigger("click");
  });
  
  /**
   * Reload role list by id
   * @param {Number} roleId
   * @param {Function} callback
   * @returns {void}
   */
  function changeListRole(roleId,callback) {
    scope.initDropdownCommon(relativePath+"apps/data","userbyroleparent",{roleId: roleId}, function(response) {
      callback(response);
    });
  }
  
});