/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to drop task page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "taskId";
showFindImgOnly = true;      
hasExtraClass = true;

$("div#droptask").ready(function() {
  //
  var currDiv = "div#droptask";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  
  if($(currDiv).length) {
    
    //compile drop modal
    scope.compileObject($("div#mdl-drop-record"));
  }
  
  /**
   * event: click confirm button in the drop modal
   * action: drop current record and hide the modal
   */
  $(currDiv + " button#drop-confirm-btn").click(function() {
    var formData = {};
    formData[dataIdField] = scope.dataarr[dataIdField];
    scope.saveDataNonAssign(relativePath + "apps/save/droptask?" + $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text(),
                    formData,function() {
      scope.getData(scope.url,scope.params);
      $("div#mdl-drop-record").modal("hide");
    });
  });
  
});