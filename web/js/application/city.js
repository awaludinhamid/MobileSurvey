/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to city page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "cityId";
disableObjArr = [{fieldName: "City Code", fieldValue: "cityCode"},
                  {fieldName: "City Name", fieldValue: "cityName"}];
objRelMap = [{name: "provinsi", field: [{column: "provId", id: "provId"}]}];
dropdownArr = ["provinsi"];

$("div#city").ready(function() {
  //currently nothing to do in this page
});