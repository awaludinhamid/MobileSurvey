/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to inquiry task page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "taskId";
dropdownArr = ["office","taskstatus","template"];
showFindImgOnly = true;      
masterFindOnlyArr = [{fieldToCheck: ["select#officeId"], message: "Must be picked up office to proceed ..!"}];
hasExtraClass = true;

$("div#inquirytask").ready(function() {
  
  var currDiv = "div#inquirytask";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  
  if($(currDiv).length) {

    //compile task result modal
    scope.compileObject($("div#mdl-task-result"));

    //re-viewing several element if logged user is a coordinator and execute additional process
    if($("span#roletype-code").text() === "C") {
      $("div.find-record select#officeId").hide();
      $("div.find-record input#officeLbl").show();
      $("div.find-record select#coordinatorId").hide();
      $("div.find-record input#coordinatorLbl").show();
      
      //additional process on loading
      //assign coordinator id value and reload the verificator list
      cbFuncGenData = function() {
        scope.coordinatorId = Number($("span#userid").text());
        changeListVerif(function() {
          scope.verificatorId = "0";
          scope.officeId = scope.datadrop.userverifbyparent[0].office.officeId;
        });
        cbFuncGenData = function() {};
      };
    }
  }
  
  /**
   * event: change/choose the office list value
   * action: assign coordinator, coordinator list and verificator list value to the default
   */
  $(currDiv + " div.find-record select#officeId").change(function() {
    scope.officeId = $(this).val();
    if(scope.officeId === "0") {
      scope.coordinatorId = "0";
      scope.datadrop.coordbyofficerole = [];
      scope.datadrop.userverifbyparent = [];
      scope.$apply();
    } else {
      changeListCoordInq(function() {
        scope.coordinatorId = "0";
        scope.datadrop.userverifbyparent = [];
      });
    }
  });
  
  /**
   * event: change/choose the coordinator list value
   * action: assign verificator and verificator list value to the default
   */
  $(currDiv + " div.find-record select#coordinatorId").change(function() {
    scope.coordinatorId = $(this).val();
    if(scope.coordinatorId === "0") {
      scope.datadrop.userverifbyparent = [];
      scope.verificatorId = "0";
      scope.$apply();
    } else {
      changeListVerif(function() {
        scope.verificatorId = "0";
      });
    }
  });
  
  /**
   * event: click detail data button
   * action: show detail data modal and assign the contents
   */
  $(currDiv + " table#tbl-data ").on("click","td>button",function() {  
    scope.getDataNonJson(relativePath+"apps/data/verifytask",{taskId: scope.dataarr.taskId}, function(response) {
      
      var $divDetQuest = $("div#det-quest");//container of the question data
      var $divPhotoQuest = $("div#photo-quest");//container of the image data
      
      //flush the container
      $divDetQuest.empty();
      $divPhotoQuest.empty();
      
      var data = response.data.taskVerifyList;//question data
      var dataImg = response.data.imageList;//image data
      
      //proceed if data or image exists
      if(data || dataImg) {
        if(data.length > 0 || dataImg.length > 0) {
          
          var currGroup = "";//current group on iteration
          var $currGroup;//current group object on iteration

          //flush question container
          $divDetQuest.empty();
          
          //creation of detail question element
          $.each(data,function(idx,val) {
            
            //current group different from previous group
            if(currGroup !== val.questGroupId) {
              $divDetQuest.append("<br/>");
              $currGroup = $("<div>",{}).html(
                       "<div class='group-header'>"+
                         "<span>"+val.questGroupLabel+"</span>"+
                       "</div>"
                      );
              $("<table>",{class:"table table-condensed table-bordered"}).appendTo($currGroup);
              $currGroup.find("table").append(
                       "<thead>"+
                         "<tr>"+
                           "<th rowspan='2'>Question</th>"+
                           "<th class='input-data' colspan='2'>Data Verif</th>"+
                           "<th class='input-data' colspan='2'>Edit Data</th>"+
                           "<th class='input-data' colspan='2'>Data Final</th>"+
                         "</tr>"+
                         "<tr>"+
                           "<th class='column-id'>Value</th>"+
                           "<th>Text</th>"+
                           "<th class='column-id'>Value</th>"+
                           "<th>Text</th>"+
                           "<th class='column-id'>Value</th>"+
                           "<th>Text</th>"+
                         "</tr>"+
                       "</thead>"+
                       "<tbody>"+
                        "<tr>"+
                          "<td id='taskResultDetListId' hidden>"+val.taskResultDetListId+"</td>"+
                          "<td id='taskResultDetId' hidden>"+val.taskResultDetId+"</td>"+
                          "<td id='createdBy' hidden>"+val.createdBy+"</td>"+
                          "<td>"+val.questLabel+"</td>"+
                          "<td id='answerId' hidden>"+val.answerId+"</td>"+
                          "<td id='answerDesc'>"+(val.answerDesc === null ? "" : val.answerDesc)+"</td>"+
                          "<td id='answerText'>"+(val.answerText === null ? "" : val.answerText)+"</td>"+
                          "<td id='editAnswerId' hidden>"+val.editAnswerId+"</td>"+
                          "<td id='editAnswerDesc'>"+(val.editAnswerDesc === null ? "" : val.editAnswerDesc)+"</td>"+
                          "<td id='editAnswerId'>"+(val.editAnswerText === null ? "" : val.editAnswerText)+"</td>"+
                          "<td id='finAnswerId' hidden>"+val.finAnswerId+"</td>"+
                          "<td id='finAnswerDesc'>"+(val.finAnswerDesc === null ? "" : val.finAnswerDesc)+"</td>"+
                          "<td id='finAnswerText'>"+(val.finAnswerText === null ? "" : val.finAnswerText)+"</td>"+
                        "</tr>"+
                      "</tbody>"
                      );
              
              //then append them into container
              $currGroup.appendTo($divDetQuest);
              
              //do not forget to assign current group so it can be used to compare it to the next group
              currGroup = val.questGroupId;
            
            //otherwise just created the detail
            } else {
              $currGroup.find("table>tbody").append(
                      "<tr>"+
                          "<td id='taskResultDetListId' hidden>"+val.taskResultDetListId+"</td>"+
                          "<td id='taskResultDetId' hidden>"+val.taskResultDetId+"</td>"+
                          "<td id='createdBy' hidden>"+val.createdBy+"</td>"+
                          "<td>"+val.questLabel+"</td>"+
                          "<td id='answerId' hidden>"+val.answerId+"</td>"+
                          "<td id='answerDesc'>"+(val.answerDesc === null ? "" : val.answerDesc)+"</td>"+
                          "<td id='answerText'>"+(val.answerText === null ? "" : val.answerText)+"</td>"+
                          "<td id='editAnswerId' hidden>"+val.editAnswerId+"</td>"+
                          "<td id='editAnswerDesc'>"+(val.editAnswerDesc === null ? "" : val.editAnswerDesc)+"</td>"+
                          "<td id='editAnswerId'>"+(val.editAnswerText === null ? "" : val.editAnswerText)+"</td>"+
                          "<td id='finAnswerId' hidden>"+val.finAnswerId+"</td>"+
                          "<td id='finAnswerDesc'>"+(val.finAnswerDesc === null ? "" : val.finAnswerDesc)+"</td>"+
                          "<td id='finAnswerText'>"+(val.finAnswerText === null ? "" : val.finAnswerText)+"</td>"+
                      "</tr>"
                      );
            }
          });

          //photo
          if(dataImg.length > 0) {
            $("<div>",{class: "group-header"}).html("<span>Photo</span>").appendTo($divPhotoQuest);
            $divPhotoQuest.append("<br/>");
            
            //read image via AJAX and append them into container
            $.each(dataImg,function(idx,val) {
              startAnimation();
              $.get(relativePath+"apps/data/verifytask/image/"+val.id, {}, function(imgdata, imgstatus) {
                var $imgDiv = $("<div>",{class:"img-photo"});
                $imgDiv.append("<span>"+val.name+"</span><br/>");
                $("<img>", {src: "data:image/jpg;base64," + imgdata, alt: val.name}).appendTo($imgDiv);
                $imgDiv.appendTo($divPhotoQuest);
              }).fail(function(status) {
                showMessage("Get image has some problems ..! (" + status + ")");
              }).always(function() {
                endAnimation();
              });
            });
          }
        } else {
          $divDetQuest.append("<span>Currently task has no result detail..!</span>");
        }
      } else {
        $divDetQuest.append("<span>Currently task has no result..!</span>");        
      }
    });
  });
  
  /**
   * Reload verificator list
   * @param {Function} callback
   * @returns void
   */
  function changeListVerif(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","userverifbyparent",{parentUserId: scope.coordinatorId}, function(response) {
      callback(response);
    });
  }
  
  //
  function changeListCoordInq(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","coordbyofficerole",{officeId: scope.officeId}, function(response) {
      callback(response);
    });
  }
  
});