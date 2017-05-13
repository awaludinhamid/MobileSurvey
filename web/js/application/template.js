/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to template page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "tempId";
disableObjArr = [{fieldName: "Template Code", fieldValue: "tempCode"},
                  {fieldName: "Template Label", fieldValue: "tempLabel"}];
objRelMap = [{name: "company", field: [{column: "coyId", id: "coyId"}]}];
dropdownArr = ["questiongroup"];
masterDetailObj = {isFormOnly: false, data: [{new:"detailTemplateDTO", edit:"detailTemplates", field:{objName:"questionGroup", idName:"questGroupId"}}]};
hasExtraClass = true;
extraCheckFieldDetail = {checkboxField: "inputVerif", fields: [{fieldName: "sort", alert:"All of field Sort may not be empty ..!"}]};

$("div#template").ready(function() {
  //
  var currDiv = "div#template";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  
  if($(currDiv).length) {
    
    //compile question group list modal and question list modal
    scope.compileObject($("div#mdl-question-group-list"));
    scope.compileObject($("div#mdl-question-list"));
  }
  
  /**
   * event: click question group image
   * action: show question group list modal
   */
  $(currDiv + " table ").on("click","td>img#img-question-group-record",function() {
    $("div#mdl-question-group-list").modal("show");
  });
  
  /**
   * event: click question image
   * action: show question list image modal
   */
  $(currDiv + " table ").on("click","td>img#img-question-record",function() {
      $("div#mdl-question-list").modal("show");
  });
});