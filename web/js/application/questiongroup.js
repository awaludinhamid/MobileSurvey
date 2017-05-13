/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to question group page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "questGroupId";
disableObjArr = [{fieldName: "Question Group", fieldValue: "questGroupLabel"}];
objRelMap = [{name: "company", field: [{column: "coyId", id: "coyId"}]}];
dropdownArr = ["question"];
masterDetailObj = {isFormOnly: false, data: [{new:"detailQuestionGroupDTO",edit:"detailQuestionGroups",field:{objName:"question",idName:"questId"}}]};
hasExtraClass = true;
extraCheckFieldDetail = {checkboxField: "inputVerif", fields: [{fieldName: "sort", alert:"All of field Sort may not be empty ..!"}]};

$("div#questiongroup").ready(function() {
  
  var currDiv = "div#questiongroup";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  
  if($(currDiv).length) {
    
    //compile question list and option list modal
    scope.compileObject($("div#mdl-question-list"));
    scope.compileObject($("div#mdl-option-list"));
  }
  
  /**
   * event: click image question
   * action: show question list modal
   */
  $(currDiv + " table ").on("click","td>img#img-question-record",function() {
    $("div#mdl-question-list").modal("show");
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