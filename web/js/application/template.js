/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "tempId";
objRelMap = [{name: "company", field: [{column: "coyId", id: "coyId"}]}];
dropdownArr = ["questiongroup"];
masterDetailObj = {isFormOnly: false, data: [{new:"detailTemplateDTO", edit:"detailTemplates", field:{objName:"questionGroup", idName:"questGroupId"}}]};

$(document).ready(function() {
  
  //
  $("table ").on("click","td>img#img-question-group-record",function() {
    $("div#mdl-question-group-list").modal("show");
  });
  
  //
  $("table ").on("click","td>img#img-question-record",function() {
      $("div#mdl-question-list").modal("show");
  });
});