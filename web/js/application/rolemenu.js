/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "roleMenuId";
objRelMap = [{name: "role", field: [{column: "roleId", id: "roleId"}]},
              {name: "menu", field: [{column: "menuId", id: "menuId"}]}];
dropdownArr = ["role","menu"];

$(document).ready(function() {  
  //
  datePicker("input#asOfDate");

});