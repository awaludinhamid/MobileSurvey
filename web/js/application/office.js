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
dataIdField = "officeId";
disableObjArr = [{fieldName: "Office Code", fieldValue: "officeCode"},
                  {fieldName: "Office Name", fieldValue: "officeName"}];
objRelMap = [{name: "company", field: [{column: "coyId", id: "coyId"}]}];


$("div#office").ready(function() {
  //currently nothing to do in this page

});