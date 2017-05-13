/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to question page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "questId";
disableObjArr = [{fieldName: "Question", fieldValue: "questLabel"},
                  {fieldName: "Answer Type", fieldValue: "answerType.answerTypeName"}];
objRelMap = [{name: "company", field: [{column: "coyId", id: "coyId"}]},
              {name: "answerType", field: [{column: "answerTypeId", id: "answerTypeId"}]},
              {name: "optionAnswer", field: [{column: "optionAnswerId", id: "optionAnswerId"}]}];
dropdownArr = ["answertype","optionanswer"];

$("div#question").ready(function() {
  
  var currDiv = "div#question";//element name of the page  
  var scope = $(elementScope).scope();//angular scope initial
  
  if($(currDiv).length)
    //compile option list modal
    scope.compileObject($("div#mdl-option-list"));
  
  /**
   * event: click new button
   * action: assign answer type value to default
   */
  $(currDiv + " div.find-record").on("click","div.img-container>img#img-new-record",function() { 
    scope.answertype = scope.datadrop.answertype[0];
    scope.$apply();
  });
  
  /**
   * event: click edit button
   * action: assign answer type value to current data
   */
  $(currDiv + " table ").on("click","td>img#img-edit-record",function() {
    scope.answertype = scope.dataarr.answerType;
    scope.$apply();// i was wonder why this statement must be called
  });
  
  /**
   * event: click image option
   * action: gather option list of clicked data
   *         show option list modal
   */
  $(currDiv + " table ").on("click","td>img#img-option-record",function() {
    scope.initDataTableGeneric(relativePath+"apps/data","listoptions",
      {tableName: scope.dataarr.optionAnswer.tableName,
        groupParamId: scope.dataarr.optionAnswer.groupParam === null || scope.dataarr.optionAnswer.groupParam === undefined ?
                      0 : scope.dataarr.optionAnswer.groupParam.groupParamId,
        delimiter: delimiter}, function(response) {
      $("div#mdl-option-list").modal("show");
    });
  });
  
});