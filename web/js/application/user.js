/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to user page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "userId";
disableObjArr = [{fieldName: "User Code", fieldValue: "userCode"},
                  {fieldName: "User Name", fieldValue: "userName"}];
objRelMap = [{name: "office", field: [{column: "officeId", id: "officeId"}]}];
dropdownArr = ["user","office"];
hideFieldOnUpdateArr = ["user-password","con-user-password"];
fieldToCheckBeforeSaveArr = [{field1: "user-password", field2: "con-user-password", alert: "Password mismatch"}];
errorCaptureArr = [{errTxt: "Number of users", errMsg: "Number of users has reach the limit ..!"},
                    {errTxt: "check_user_company_unique_trig_func", errMsg: "Username already exist in the current company ..!"}];

$("div#user").ready(function() {
  //currently nothing to do in this page
});