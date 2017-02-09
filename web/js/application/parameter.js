/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  
//
dataIdField = "parId";
objRelMap = [{name: "company", field: [{column: "coyId", id: "coyId"}]}];


$(document).ready(function() {
  //
  var scope = $(elementScope).scope();
  
  //
  scope.datadrop["parappstype"] = [{value:"Mobile",name:"Mobile"},{value:"Web",name:"Web"}];
  scope.datadrop["pardatatype"] = [
    {value:"NUMBER",name:"NUMBER"},
    {value:"VARCHAR",name:"VARCHAR"},
    {value:"BOOLEAN",name:"BOOLEAN"},
    {value:"DATE",name:"DATE"}];
});