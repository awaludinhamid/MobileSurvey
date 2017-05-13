/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to product page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "productId";
disableObjArr = [{fieldName: "Product Code", fieldValue: "productCode"},
                  {fieldName: "Product Name", fieldValue: "productName"}];
dropdownArr = ["template"];

$("div#product").ready(function() {
  //
  var currDiv = "div#product";//element name of the page  
  var scope = $(elementScope).scope();//angular scope initial
  
  /**
   * event: click new button
   * action: assign template value to default
   */
  $(currDiv + " div.find-record").on("click","div.img-container>img#img-new-record",function() {
    initTempValue(scope.datadrop.template[0]);
  });
  
  /**
   * event: click edit button
   * action: assign template value to current data
   */
  $(currDiv + " table ").on("click","td>img#img-edit-record",function() {
    initTempValue(scope.dataarr.template);
  });
  
  /**
   * 
   * @param {Object} tempVal , the template object
   * @returns {void}
   */
  function initTempValue(tempVal) {
    scope.$apply(function() { // i was wonder why this statement must be called
      scope.template = tempVal;
    });
  }
  
});