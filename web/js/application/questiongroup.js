/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "questGroupId";
objRelMap = [{name: "company", field: [{column: "coyId", id: "coyId"}]}];
dropdownArr = ["question"];
masterDetailObj = {isFormOnly: false, data: [{new:"detailQuestionGroupDTO",edit:"detailQuestionGroups",field:{objName:"question",idName:"questId"}}]};

$(document).ready(function() {
  //
  var scope = $(elementScope).scope();
  
  //
  $("table ").on("click","td>img#img-question-record",function() {
    $("div#mdl-question-list").modal("show");
  });
  
  //
  $("table ").on("click","td>img#img-option-record",function() {
    scope.initDataTableGeneric(relativePath+"apps/data","listoptions",
      {tableName: scope.dataarr.optionAnswer.tableName,
        groupParamId: scope.dataarr.optionAnswer.groupParam === null || scope.dataarr.optionAnswer.groupParam === undefined ?
                      0 : scope.dataarr.optionAnswer.groupParam.groupParamId,
        delimiter: delimiter}, function(response) {
      $("div#mdl-option-list").modal("show");
    });
  });
});