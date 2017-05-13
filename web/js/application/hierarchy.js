/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to hierarchy page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "hieId";
disableObjArr = [{fieldName: "Parent Role Name", fieldValue: "roleUp.roleName"},
                  {fieldName: "Role Name", fieldValue: "role.roleName"}];
objRelMap = [{name: "company", field: [{column: "coyId", id: "coyId"}]},
              {name: "role", field: [{column: "roleId", id: "roleId"}]},
              {name: "roleUp", field: [{column: "roleId", id: "roleIdUp"}]}];
dropdownArr = ["rolebyrole","rolebyrolewithnull"];

$("div#hierarchy").ready(function() {
  //currently nothing to do in this page
});