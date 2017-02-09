/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "productId";
dropdownArr = ["template"];

$(document).ready(function() {
  //
  var scope = $(elementScope).scope();
  
  $("div.find-record").on("click","div.img-container>img#img-new-record",function() {
    initTempValue(scope.datadrop.template[0]);
  });
  
  //
  $("table ").on("click","td>img#img-edit-record",function() {
    initTempValue(scope.dataarr.template);
  });
  
  function initTempValue(tempVal) {
    scope.$apply(function() { // i was wonder why this statement must be called
      scope.template = tempVal;
    });
  }
  
});