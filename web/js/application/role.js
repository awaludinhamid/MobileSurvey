/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to role page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "roleId";
disableObjArr = [{fieldName: "Role Code", fieldValue: "roleCode"},
                  {fieldName: "Role Name", fieldValue: "roleName"}];
dropdownArr = ["role","roletype"];
objRelMap = [{name: "roleType", field: [{column: "roleTypeId", id: "roleTypeId"}]}];

$("div#role").ready(function() {
  //currently nothing to do in this page
});