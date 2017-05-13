/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to report monitoring page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "taskId";
dropdownArr = ["office"];
showFindImgOnly = true;    
masterFindOnlyArr = [{fieldToCheck: ["select#officeId"], message: "Must be picked up office to proceed ..!"}];
hasExtraClass = true;

$("div#repmon").ready(function() {
  
  var currDiv = "div#repmon";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  var scrollLeft = 0;//initialize left scrolling position
  
  if($(currDiv).length) {
    
    //compile download modal
    scope.compileObject("div#download-mdl");
    
    //additional process on loading the page
    cbFuncGenData = function() {
      
      //if logged user is coordinator then switch the view of several elements
      if($("span#roletype-code").text() === "C") {
        $("div.find-record select#officeId").hide();
        $("div.find-record div.img-container>img#img-find-record").hide();
        $("div.find-record input#officeLbl").show();
      
      //otherwise, do the same but opposite
      } else {
        $("div.find-record select#officeId").show();
        $("div.find-record div.img-container>img#img-find-record").show();
        $("div.find-record input#officeLbl").hide();      
      }
      
      var $tbodyDetTask = $("table#det-task>tbody");//body of table container
      var currUserCode = "";//current clicked user code
      
      //flush the table body
      $tbodyDetTask.empty();
      
      var htmlContent = "";//<TR> HTML content
      
      //iterate over data to create element inside table body
      $.each(scope.datatable,function(idx,val) {
        
        /**
         * Get background color of <TD> element based on current task status code
         * @returns {String}
         */
        var taskStatusBackStyle = function() {
          switch(val.taskStatus.taskStatusCode) {
            case "ASSG": return "#ff7f7f";
            case "RETR": return "yellow";
            case "SURV": return "#4fbfef";
            case "SUBM": return "#7fff7f";
            default: return "";
          }
        };
        
        //creation of table body contents
        if(currUserCode !== val.user.userCode) {
          if(currUserCode !== "") {
            htmlContent = "<tr>"+htmlContent+"</tr>";
            $tbodyDetTask.append(htmlContent);
            htmlContent = "";
          }
          htmlContent =
                  "<td>"+
                    "<ul class='list-unstyled'>"+
                      "<li>"+val.user.userCode+"</li>"+
                      "<li>"+val.user.userName+"</li>"+
                    "</ul>"+
                  "</td>"+
                  "<td>"+
                    "<ul class='list-unstyled' style='background-color: "+taskStatusBackStyle()+"'>"+
                      "<li>"+val.orderId+"</li>"+
                      "<li>A: "+(val.assignmentDate||"")+"</li>"+
                      "<li>R: "+(val.retrieveDate||"")+"</li>"+
                      "<li>S: "+(val.submitDate||"")+"</li>"+
                    "</ul>"+
                  "</td>";
          currUserCode = val.user.userCode;
        } else {
          htmlContent = htmlContent +
                  "<td>"+
                    "<ul class='list-unstyled' style='background-color: "+taskStatusBackStyle()+"'>"+
                      "<li>"+val.orderId+"</li>"+
                      "<li>A: "+(val.assignmentDate||"")+"</li>"+
                      "<li>R: "+(val.retrieveDate||"")+"</li>"+
                      "<li>S: "+(val.submitDate||"")+"</li>"+
                    "</ul>"+
                  "</td>";
        }
      });
      htmlContent = "<tr>"+htmlContent+"</tr>";
      
      //finally, append the content to container
      $tbodyDetTask.append(htmlContent);
    };
  }
  
  /**
   * event: change/choose office list value
   * action: assign office to the current data
   */
  $(currDiv + " div.find-record select#officeId").change(function() {
    scope.officeId = $(this).val();
    scope.$apply();
  });
  
  /**
   * event: scrolling over table container parent
   * action: move first <TD> element inside the container along with the scrolling bar
   */
  $(currDiv + " div#div-task").scroll(function() {
    
    //applied only to horizontal scrolling
    if($(this).scrollLeft() !== scrollLeft) {
      $(this).find("td:first-child")
              .css("transform","translateX(" + $(this).scrollLeft() + "px)");
      scrollLeft = $(this).scrollLeft();
    }
  });
  
  /**
   * event: click download button
   * action: show the download modul
   */
  $(currDiv + " button#download-btn").click(function() {  
    if(scope.officeId + "" === "0" && $("span#roletype-code").text() !== "C")
      showErrorMessage("Pick up Office First ..!");
    else
      $("div#download-mdl").modal("show");
  });
  
  /**
   * event: click 'ok' button inside download modal
   * action: download the file based on given parameters
   */
  $(currDiv + " button#download-btn-exec").click(function() {
    
    //verified delimiter if selected text file
    if(scope.filetypedl === "textfile" && (scope.textdelimiterdl === "" || scope.textdelimiterdl === undefined)) {
      showErrorMessage("Delimiter on text file may not be empty ..!");
      return false;
    }
    
    //parameters to be posted: file type, office id and delimiter if required
    var params = {
      fileType: scope.filetypedl,
      officeId: scope.officeId,
      textDelimiter: scope.textdelimiterdl
    }; 
    
    //post the request, close the modal once it was finished
    scope.postDataByParam(
            relativePath + "apps/data/repmon/download/request?" +
            $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text()
    ,params,function(reponse) {
      window.location.replace(relativePath + "apps/data/repmon/download");
      $("div#download-mdl").modal("hide");
    });
  });
});