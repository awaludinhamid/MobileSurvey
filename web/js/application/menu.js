/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "menuId";
objRelMap = [{name: "parentMenu", field: ["parentMenuId"]}];
dropdownArr = ["parentmenu","menu"];

$(document).ready(function() {
  datePicker("input#asOfDate");
});