/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to absence page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "absenceId";
disableObjArr = [{fieldName: "User", fieldValue: "user.userName"},
                  {fieldName: "Reason Type", fieldValue: "reasonType.reasonTypeName"},
                  {fieldName: "Valid Date", fieldValue: "startDate"}];
objRelMap = [{name: "user", field: [{column: "userId", id: "userId"}]},
              {name: "reasonType", field: [{column: "reasonTypeId", id: "reasonTypeId"}]}];
dropdownArr = ["userbyparent","reasontype"];
isDateCheckToToday = true;

$("div#absence").ready(function() {
  //currently nothing to do in this page
});