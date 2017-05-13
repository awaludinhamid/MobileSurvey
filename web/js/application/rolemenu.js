/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to role menu page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "roleMenuId";
disableObjArr = [{fieldName: "Role Name", fieldValue: "role.roleName"},
                  {fieldName: "Menu Name", fieldValue: "menu.menuName"}];
objRelMap = [{name: "role", field: [{column: "roleId", id: "roleId"}]},
              {name: "menu", field: [{column: "menuId", id: "menuId"}]}];
dropdownArr = ["role","menu"];
errorCaptureArr = [{errTxt: "master_role_menu_unq001", errMsg: "Menu role combination already exist ..!"}];

$("div#rolemenu").ready(function() { 
  //currently nothing to do in this page
});