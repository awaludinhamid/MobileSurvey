/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "userId";
objRelMap = [{name: "office", field: ["officeId"]}];
dropdownArr = ["user","office"];
hideFieldOnUpdateArr = ["user-password","con-user-password"];
fieldToCheckBeforeSaveArr = [{field1: "user-password", field2: "con-user-password", alert: "Password mismatch"}];
fieldToAssignBeforeSaveArr = [{source: "user-password", target: "userPassword"}];

$(document).ready(function() {
  datePicker("input#asOfDate");

});