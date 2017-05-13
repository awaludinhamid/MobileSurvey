/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to office page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "parId";
disableObjArr = [{fieldName: "Parameter Code", fieldValue: "parCode"},
                  {fieldName: "Description", fieldValue: "parDesc"}];
objRelMap = [{name: "company", field: [{column: "coyId", id: "coyId"}]},
              {name: "parentParameter", field: [{column: "parentParId", id: "parentParId"}]}];
dropdownArr = ["parentparam"];

$("div#parameter").ready(function() {
  //
  var currDiv = "div#parameter";//element name of the page  
  var scope = $(elementScope).scope();//angular scope initial
  
  if($(currDiv).length) {
    
    //assign parameter application type to the angular scope
    scope.datadrop["parappstype"] = [{value:"Mobile",name:"Mobile"},{value:"Web",name:"Web"}];
  }
  
  /**
   * event: change/choose parent parameter list value
   * action: switch input type of chosen parameter
   */
  $(currDiv + " select#parentParIdTmp").change(function() {
    switchParamInputType(getParentParCode($(this).val()));
  });
  
  /**
   * event: click new button
   * action: assign parameter value to default
   *         switch input type of parameter based on current parent parameter
   */
  $(currDiv + " div.find-record").on("click","div.img-container>img#img-new-record",function() { 
    $("input#parValue").attr("type","text");
    scope.parentpar = scope.datadrop.parentparam[0];
    scope.$apply();
    switchParamInputType(scope.parentpar.parentParCode);
  });
  
  /**
   * event: click edit button
   * action: assign parent parameter
   *         switch input type of parameter based on current parent parameter
   */
  $(currDiv + " table ").on("click","td>img#img-edit-record",function() {
    scope.parentpar = scope.dataarr.parentParameter;
    scope.$apply();// i was wonder why this statement must be called
    switchParamInputType(scope.parentpar.parentParCode);
  });
  
  /**
   * Get parent parameter code by id
   * @param {Number} parentParId , parent parameter id
   * @returns {String}
   */
  function getParentParCode(parentParId) {
    var parentpar = scope.datadrop.parentparam;
    for(var idx in parentpar) {
      if(parentpar[idx].parentParId + "" === parentParId)
        return parentpar[idx].parentParCode;
    }
    return "";
  }
  
  /**
   * Switch input type of parameter based on given code
   * @param {String} paramCode , parameter code
   * @returns {void}
   */
  function switchParamInputType(paramCode) {
    if(paramCode === "IM001")
      $("input#parValue").attr("type","number").attr("max","1024");
    else
      $("input#parValue").attr("type","text");
  }
});