/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to task assign page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "taskId";
dropdownArr = ["usercoordbyparent"/*,"userverifbyparent"*/];
replaceWithSaveImage = true;
masterListUpdateOnly = {updAssignObj: "select#verificatorId", updVarName: "userId", updListIdName: "taskIdList",
                        warnMessage: ["Pick up verificator first ..!"]};
hasExtraClass = true;

$("div#taskassign").ready(function() {
  
  var currDiv = "div#taskassign";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  
  if($(currDiv).length > 0) {
    
    //additional process on loading page
    cbFuncGenData = function() {
      
      //if logged user is coordinator then assign id to user id
      //disable the element from change
      //reload verified task list
      //assign verificator id to default
      if($("span#roletype-code").text() === "C") {
        scope.coordinatorId = scope.datadrop.usercoordbyparent[0].userId;
        $("div.find-record select#coordinatorId").prop("disabled",true);
        changeListVerifTask(scope.coordinatorId, function() {
          scope.verificatorId = "0";
        });
      } else {
        $("div.find-record select#coordinatorId").prop("disabled",false);
      }
      cbFuncGenData = function() {};
    };
  }
  
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
   * event: change/choose coordinator list value
   * action: reload verified task list
   *         assign verificator id value to default
   *         execute find button on click trigger
   */
  $(currDiv + " div.find-record select#coordinatorId").change(function() {
    changeListVerifTask($(this).val(), function() {
      scope.verificatorId = "0";
      $("div.find-record div.img-container>img#img-find-record").trigger("click");
    });
  });
  
  /**
   * Reload verified task list
   * @param {Number} parentUserId
   * @param {Function} callback
   * @returns {void}
   */
  function changeListVerifTask(parentUserId,callback) {
    scope.initDropdownCommon(relativePath+"apps/data","userverifbyparent",{parentUserId: parentUserId}, function(response) {
      callback(response);
    });
  }
  
});