/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to user role page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "taskResultId";
dropdownArr = ["usercoordbyparent","userverifbyparent"];
showFindImgOnly = true;      
masterFindOnlyArr = [{fieldToCheck: ["select#coordinatorId"], message: "Must be picked up coordinator at least to proceed ..!"}];
hasExtraClass = true;

$("div#verifytask").ready(function() {
  
  var currDiv = "div#verifytask";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  
  if($(currDiv).length) {

    //compile verify modal
    scope.compileObject($("div#mdl-verify-record"));
  
    //if logged user is coordinator then switch several element view and assign coordinator id to user id
    if($("span#roletype-code").text() === "C") {
      $("div.find-record select#coordinatorId").hide();
      $("div.find-record input#coordinatorLbl").show();
      cbFuncGenData = function() {
        scope.coordinatorId = Number($("span#userid").text());
        cbFuncGenData = function() {};
      };
    }
  }
  
  /**
   * event: change/choose coordinator list value
   * action: assign coordinator and verificator to current data
   *         reload verificator list or assign verificator list to default
   */
  $(currDiv + " div.find-record select#coordinatorId").change(function() {
    scope.coordinatorId = $(this).val();
    if(scope.coordinatorId === "0") {
      scope.datadrop.userverifbyparent = [];
      scope.verificatorId = "0";
      scope.$apply();
    } else {
      changeListVerifVer(function() {
        scope.verificatorId = "0";
      });
    }
  });
  
  /**
   * event: click detail data button
   * action: show detail data modal and assign the contents
   */
  $(currDiv + " table#tbl-data ").on("click","img#img-verif-record",function() {      
    scope.getDataNonJson(relativePath+"apps/data/verifytask",{taskId: scope.dataarr.task.taskId}, function(response) {
      
      var $divDetQuest = $("div#det-quest");//container of the question data
      var $divPhotoQuest = $("div#photo-quest");//container of the image data
      
      //flush the container
      $divDetQuest.empty();
      $divPhotoQuest.empty();
      
      var data = response.data.taskVerifyList;//question data
      var dataImg = response.data.imageList;//image data
      
       //proceed if data or image exists
      if(data.length > 0 || dataImg.length > 0) {
      
        var currGroup = "";//current group on iteration
        var $currGroup;//current group object on iteration

        //flush question container
        $divDetQuest.empty();
          
        //creation of detail question element
        $.each(data,function(idx,val) {
          
          //if object is dropdown then assign the object and its value
          if(val.optionAnswerName !== "NONE")
            scope.datadrop["verify"+idx] = val.optionList;
            
          //current group different from previous group
          if(currGroup !== val.questGroupId) {
            $divDetQuest.append("<br/>");
            $currGroup = $("<div>",{}).html(
                     "<div class='group-header'>"+
                       "<span>"+val.questGroupLabel+"</span>"+
                     "</div>"
                    );
            $("<table>",{class:"table table-condensed table-bordered"}).appendTo($currGroup);
            scope.compileObject($currGroup.find("table").append(
                     "<thead>"+
                       "<tr>"+
                         "<th rowspan='2'>Question</th>"+
                         "<th class='input-data' colspan='2'>Data Verif</th>"+
                         "<th class='input-data' colspan='2'>Edit Data</th>"+
                         "<th rowspan='2' class='checkbox-hdr'>Data Verif</th>"+
                         "<th rowspan='2' class='checkbox-hdr'>Edit Data</th>"+
                         "<th class='input-data' colspan='2'>Data Final</th>"+
                       "</tr>"+
                       "<tr>"+
                         "<th class='column-id'>Value</th>"+
                         "<th>Text</th>"+
                         "<th class='column-id input-id'>Value</th>"+
                         "<th class='input-text'>Text</th>"+
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
                       (
                        val.optionAnswerName === "NONE" ? (
                          "<td id='answerDesc'></td>"+
                          "<td id='answerText'>"+(val.answerText === null ? "" : val.answerText)+"</td>"+
                          "<td id='editAnswerId' class='input-id input-dtl'></td>"+
                          "<td id='editAnswerText' class='input-text input-dtl'>"+(val.hasText === "Y" ? "<input class='form-control'>" : "")+"</td>"+
                          "<td data-id='answer' class='checkbox-dtl'><input type='checkbox' checked></td>"+
                          "<td data-id='editAnswer' class='checkbox-dtl'><input type='checkbox'></td>"+
                          "<td id='finAnswerDesc'></td>"+
                          "<td id='finAnswerText'>"+(val.answerText === null ? "" : val.answerText)+"</td>"
                        ) : (
                          "<td id='answerId' hidden>"+val.answerId+"</td>"+
                          "<td id='answerDesc'>"+val.answerDesc+"</td>"+
                          "<td id='answerText'>"+(val.answerText === null ? "" : val.answerText)+"</td>"+
                          "<td id='editAnswerId' class='input-id input-dtl'>"+
                           "<select class='form-control'><option ng-repeat='drop in datadrop.verify"+idx+"' value='{{drop.id}}'>{{drop.descr}}</option></select>"+
                          "</td>"+
                          "<td id='editAnswerText' class='input-text input-dtl'>"+(val.hasText === "Y" ? "<input class='form-control'>" : "")+"</td>"+
                          "<td data-id='answer' class='checkbox-dtl'><input type='checkbox' checked></td>"+
                          "<td data-id='editAnswer' class='checkbox-dtl'><input type='checkbox'></td>"+
                          "<td id='finAnswerId' hidden>"+val.answerId+"</td>"+
                          "<td id='finAnswerDesc'>"+val.answerDesc+"</td>"+
                          "<td id='finAnswerText'>"+(val.answerText === null ? "" : val.answerText)+"</td>"
                        )
                       ) +
                      "</tr>"+
                    "</tbody>"
                    ));
            
            //then append them into container
            $currGroup.appendTo($divDetQuest);
            
            //do not forget to assign current group so it can be used to compare it to the next group
            currGroup = val.questGroupId;
            
          //otherwise just created the detail
          } else {
            scope.compileObject($currGroup.find("table>tbody").append(
                    "<tr>"+
                      "<td id='taskResultDetListId' hidden>"+val.taskResultDetListId+"</td>"+
                      "<td id='taskResultDetId' hidden>"+val.taskResultDetId+"</td>"+
                      "<td id='createdBy' hidden>"+val.createdBy+"</td>"+
                      "<td>"+val.questLabel+"</td>"+
                       (
                       //text input type
                        val.optionAnswerName === "NONE" ? (
                          "<td id='answerId' hidden></td>"+
                          "<td id='answerDesc'></td>"+
                          "<td id='answerText'>"+(val.answerText === null ? "" : val.answerText)+"</td>"+
                          "<td id='editAnswerId' class='input-id input-dtl'></td>"+
                          "<td id='editAnswerText' class='input-text input-dtl'>"+(val.hasText === "Y" ? "<input class='form-control'>" : "")+"</td>"+
                          "<td data-id='answer' class='checkbox-dtl'><input type='checkbox' checked></td>"+
                          "<td data-id='editAnswer' class='checkbox-dtl'><input type='checkbox'></td>"+
                          "<td id='finAnswerId' hidden></td>"+
                          "<td id='finAnswerDesc'></td>"+
                          "<td id='finAnswerText'>"+(val.answerText === null ? "" : val.answerText)+"</td>"
                        //dropdown input type
                        ) : (
                          "<td id='answerId' hidden>"+val.answerId+"</td>"+
                          "<td id='answerDesc'>"+val.answerDesc+"</td>"+
                          "<td id='answerText'>"+(val.answerText === null ? "" : val.answerText)+"</td>"+
                          "<td id='editAnswerId' class='input-id input-dtl'>"+
                           "<select class='form-control'><option ng-repeat='drop in datadrop.verify"+idx+"' value='{{drop.id}}'>{{drop.descr}}</option></select>"+
                          "</td>"+
                          "<td id='editAnswerText' class='input-text input-dtl'>"+(val.hasText === "Y" ? "<input class='form-control'>" : "")+"</td>"+
                          "<td data-id='answer' class='checkbox-dtl'><input type='checkbox' checked></td>"+
                          "<td data-id='editAnswer' class='checkbox-dtl'><input type='checkbox'></td>"+
                          "<td id='finAnswerId' hidden>"+val.answerId+"</td>"+
                          "<td id='finAnswerDesc'>"+val.answerDesc+"</td>"+
                          "<td id='finAnswerText'>"+(val.answerText === null ? "" : val.answerText)+"</td>"
                        )
                       ) +
                    "</tr>"
                    ));
          }
        });

        //photo
        if(dataImg.length > 0) {
          $("<div>",{class: "group-header"}).html("<span>Photo</span>").appendTo($divPhotoQuest);
          $divPhotoQuest.append("<br/>");
          $divPhotoQuest.append("<button id='btn-show-image' class='btn btn-info'><span class='glyphicon glyphicon-eye-open'></span>&nbsp;<span>Show Image</span></button>");
          $divPhotoQuest.append("<br/>");
          
          //read image via AJAX and append them into container
          $.each(dataImg,function(idx,val) {
            startAnimation();
            $.get(relativePath+"apps/data/verifytask/image/"+val.id, {}, function(imgdata, imgstatus) {
              var $imgDiv = $("<div>",{class:"img-photo",hidden:true});
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
        $("div#mdl-verify-record button.btn-primary").prop("disabled",false);
      } else {
        $divDetQuest.append("<span>Currently task has no result detail..!</span>");
        $("div#mdl-verify-record button.btn-primary").prop("disabled",true);
      }
    });
  });
  
  /**
   * event: [un]checked the checkbox inside verify modal
   */
  $(currDiv + " div#det-quest ").on("change",":checkbox",function() {
    
    var $currTd = $(this).parent("td");//current <TD> element
    var $parentTr = $currTd.parent("tr");//current <TR> element
    
    //checked the checkbox
    if($(this).prop("checked")) {
      
      var currTdIdx = $currTd.index();//assign current index to current <TD> index
      var prevTdIdx = 0;//initial previous index
      
      //iterate over column inside current row
      $parentTr.children("td.checkbox-dtl").each(function() {
        
        //validate to all checkbox
        //one and only one checkbox must be checked
        if($(this).index() !== currTdIdx) {
          if($(this).children("input:checkbox").prop("checked"))
            prevTdIdx = $(this).index();
          $(this).children("input:checkbox").prop("checked",false);
        }
      });
      
      //assign value to the suited detail in every columns
      var $referTdId = $parentTr.children("td#"+$currTd.data("id")+"Id");
      var $referTdDesc = $parentTr.children("td#"+$currTd.data("id")+"Desc");
      var $referTdText = $parentTr.children("td#"+$currTd.data("id")+"Text");
      var valId = $referTdId.find("select").length ? $referTdId.find("select").val() : $referTdId.text();
      var valDesc = $referTdId.find("select").length ? $referTdId.find("select>option:selected").text() : $referTdDesc.text();
      var valText = $referTdText.find("input").length ? $referTdText.children("input").val() : $referTdText.text();
      if(valId === "" && valText === "") {
        $(this).prop("checked",false);
        $parentTr.children("td").eq(prevTdIdx).children("input:checkbox").prop("checked",true);
        alert("Assigned value is empty ..!");
      } else {
        $parentTr.children("td#finAnswerId").text(valId);
        $parentTr.children("td#finAnswerDesc").text(valDesc);
        $parentTr.children("td#finAnswerText").text(valText);
      }
      
    //unchecked the checkbox, not allowed, switch to checked status
    } else {
      $(this).prop("checked",true);
    }
  });
  
  /**
   * event: click 'ok' button inside verify modal
   * action: read and assign the value, and post them to be saved to database
   */
  $(currDiv + " div#mdl-verify-record button.btn-primary").click(function() {
    
    var datasave = {};//data object container
    var resultDetailListDTOList = [];//array of result detail list
    
    //iterate over detail to gather result detail list value
    $("div#mdl-verify-record .modal-body>div#det-quest>div").each(function() {
      var $currTable = $(this).children("table");
      
      //iterate over row
      $currTable.find("tbody>tr").each(function() {    
        
        var resultDetailListDTO = {};//data object
        
        //iterate over column
        $(this).children("td").each(function() {
          var tdId = $(this).attr("id");
          if(tdId) {
            if(tdId === "taskResultDetListId" && ($(this).text() === "" || $(this).text() === "null"))
              return false;
            if($(this).children("input").length)
              resultDetailListDTO[tdId] = $(this).children("input").val();
            else if($(this).children("select").length)
              resultDetailListDTO[tdId] = $(this).children("select").val();
            else
              resultDetailListDTO[tdId] = $(this).text();
          }
        });
        
        //put data object into array
        if(!$.isEmptyObject(resultDetailListDTO)) {
          resultDetailListDTOList.push(resultDetailListDTO);
        }
      });
    });
    
    //finally put array into object container and post it via AJAX
    if(resultDetailListDTOList.length > 0)
      datasave["resultDetailListDTOList"] = resultDetailListDTOList;
    scope.saveDataNonAssign(relativePath+"apps/save/verifytask?"+$("span#csrf-param-name").text() + "=" + $("span#csrf-token").text(),datasave,function() {
      $("div#mdl-verify-record").modal("hide");
    });
  });
  
  /**
   * event: click show image button
   * action: show/hide image based on current status
   */
  $(currDiv + " div#photo-quest ").on("click","button#btn-show-image",function() {
    var $span = $(this).children("span:first-child");
    var $spanlast = $(this).children("span:last-child");
    if($span.hasClass("glyphicon-eye-open")) {
      $("div#photo-quest div:has(img)").show();
      $spanlast.text("Hide Image");
    } else {
      $("div#photo-quest div:has(img)").hide();
      $spanlast.text("Show Image");
    }
    $span.toggleClass("glyphicon-eye-open").toggleClass("glyphicon-eye-close");
  });
  
  /**
   * Reload verificator list by coordinator
   * @param {Function} callback
   * @returns {void}
   */
  function changeListVerifVer(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","userverifbyparent",{parentUserId: scope.coordinatorId}, function(response) {
      callback(response);
    });
  }
  
});