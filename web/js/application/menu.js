/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to menu page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "menuId";
disableObjArr = [{fieldName: "Menu Name", fieldValue: "menuName"},
                  {fieldName: "Description", fieldValue: "menuDesc"}];
objRelMap = [{name: "parentMenu", field: [{column: "parentMenuId", id: "parentMenuId"}]}];
dropdownArr = ["parentmenu","menu"];

$("div#menu").ready(function() {
  //currently nothing to do in this page
});