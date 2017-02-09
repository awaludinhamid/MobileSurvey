/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  
startAnimation();

/*** GLOBAL VARIABLE ***/

//id for identifier, ie. coyId for identify company object
var dataIdField; 

//object must be cast to scalar so it must be represented by its relation identifier
//ie. in json {id:1,name:"xxx",data:{id:1,name:"yyyy"}} object data represented by id of data
//format [name: "data", field: [{column: "id", id: "id"}]]
//column name in database may be different with id name in html tag
var objRelMap = []; 

//scope name and url last path of drop down menu
//ie. ["coy"] will ask apps to create scope named datadrop.coy and retrieve its data from [app_url_path]/coy
var dropdownArr = [];

//we create new record and edit record in the same form, so to distinct them while showing the html tag use this array
//ie. ["user-password"] will show html tag with id "user-password" showing on new record only not on edit record process
var hideFieldOnUpdateArr = [];

//if modul has file to upload create this object
//format and sample {name:"appname",field:"field1"}, ask app to upload file with html tag id = "field1" to url [app_url_path]/appname/file
var uploadFileObj = {};

//compare two field value to validate
//format and sample [{field1:"field1",field2:"field2",alert:"alert message"}]
//will ask app to compare the value of two field, if mismatch then show "alert message"
var fieldToCheckBeforeSaveArr = [];

//we have to count how many animations have been started
//so they only stop when all animations have been done
var animationCount = 0;

//sometime there is data with no predefined object, so we have to get all of its columns and separeted them w/ delimiter
var delimiter = "|";

//saving master-detail data in one process
var masterDetailObj = {};

//update master data list need to specify some objects
var masterListUpdateOnly = {};

//simple form page do not need this (table contain data with supported tools like find button, new button, etc)
var loadInitListObj = true;

//if we need to replace functional image (find & new) with save image (in selected modul)
var replaceWithSaveImage = false;

//show find image only
var showFindImgOnly = false;

//if modul is find only modul, we need to check some objects
//must be used together with showFindImgOnly variable
var masterFindOnlyArr = [];

//scope we used to execute the angular
var elementScope = "div#page-content-wrapper";

//check date entered through pattern
var asofdatePattern = "^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";
  
//variable modal message
var messageMdl = $("div#message-mdl");
var messageMdlContent = messageMdl.find(".modal-content");
var backColInfo = "rgba(16,64,112,0.8)";
var colInfo = "white";
var colWarning = "red";
var messageMdlBody = messageMdlContent.find(".modal-body");



/*** GLOBAL FUNCTION ***/

//
function startAnimation() {
  animationCount += 1;
  $(".back-cover").show();
  $(".back-cover, .red-ball, .blue-ball, .green-ball, .loading-text").css("animation-play-state","running");
}

//
function endAnimation() {
  animationCount -= 1;
  if(animationCount < 1) {
    $(".back-cover").hide();
    $(".back-cover, .red-ball, .blue-ball, .green-ball, .loading-text").css("animation-play-state","paused");
  }
}

//check requested current session(active/inactive) before execution
function checkCurrSessAndExec(callbackSuccess,callbackNotSuccess) {    
  $.get("../../apps/auth/currentsession",function(data,status) {
    if(status === "success") {
      if(data === $("span#sessionid").text()) {
        callbackSuccess(data); //following additional process goes here..
      } else {
        callbackNotSuccess(data);
        showMessage("Your session has been expired");
        window.location.reload();
      }
    } else {
      showMessage("Get current session unsuccessfully: status = " + status);
    }
  }).fail(function(d) {
    showMessage(d.status);
  });
}

//show your message here
function showMessage(message) {
  $("div#message-mdl .modal-body").html(message);
  $("div#message-mdl").modal("show");
}


/*** EVENT DRIVEN ***/

$(document).ready(function() {
  
  //
  var startdatepicker = datePicker("input#startDate");
  var enddatepicker = datePicker("input#endDate");
  var scope = $(elementScope).scope();
  var activePage = $("div#sidebar-wrapper ul.sidebar-nav>li.active-page");
  var formInputFile = $("form#form-save input:file");
  var modalSave = "div#mdl-save-record";
      
  //
  var gendata = function() {
    //
    var paramInput = {};
    $("div.find-record select, div.find-record input").each(function() {
      var name = $(this).attr("ng-model");
      paramInput[name] = scope[name];
    });
    //
    scope.getData(relativePath + activePage.data("data-url")+"/"+currPageNo, paramInput);
  };
  
  //
  scope.addTitleAndFind(activePage);
  if(loadInitListObj)
    gendata();
  
  //dropdown
  if(dropdownArr.length > 0)
    $.each(dropdownArr,function(idx,val) {
      scope.initDropdown(relativePath+"apps/data",val);
    });
  
  //
  $(".table-container").scroll(function() {
    $(this).find("td:first-child")
            .css("transform","translateX(" + $(this).scrollLeft() + "px)");
  });
  
  //
  $(".table-container-normal").scroll(function() {
    $(this).find("th")
            .css("transform","translateY(" + $(this).scrollTop() + "px)");
  });
  
  //
  $("div.find-record").on("click", "div.img-container>img#img-find-record", function() {
    if(showFindImgOnly) {
      var breakProcess = false;
      $.each(masterFindOnlyArr,function(idx,val) {
        $.each(val.fieldToCheck,function(idx1,val1) {          
          if($(val1).val() === "0") {          
            messageMdlContent.css("background-color","rgba(10,20,40,0.8)").css("color",colWarning);
            messageMdlBody.html(val.message);
            messageMdl.modal("show");
            breakProcess = true;
          }
        });
      });
      if(breakProcess)
        return false;
    }
    currPageNo = 1;
    gendata();
    var currInput = $("input#asOfDate");
    if(currInput) {
      var tooltipDate = $("div.tooltip-date");
      var currInputVal = currInput.val();
      if(!(currInputVal.match(asofdatePattern) || currInputVal === "")) {
        var currInputOff = currInput.offset();
        setTtDateStyle("transform","translate("+currInputOff.left+"px,"+(currInputOff.top - 20)+"px)");
        setTtDateStyle("animation-play-state","running");
        tooltipDate.on("animationend webkitAnimationEnd", function() {
          setTtDateStyle("animation-play-state","paused");
          tooltipDate.replaceWith(tooltipDate.clone(true));
        });
      }
      function setTtDateStyle(styleProp,styleValue) {
        tooltipDate.css(styleProp,styleValue);
        tooltipDate.css("webkit-" + styleProp,styleValue);
      }
    }
  });
  
  //
  $("table ").on("click","td>img#img-delete-record",function() {
    $("div#message-mdl .modal-body").html("Currently unavailable");
    $("div#message-mdl").modal("show");    
  });
  
  //
  $("div#pagination>ul").on("click","li",function() {
    clickPageNo("div#pagination>ul>li",this.id,{},gendata);
  });
  
  //
  $(".modal").on("shown.bs.modal", function() {
    $(this).find("[autofocus]").focus();
  });
  
  //
  $("button#btn-startdate").click(function() {
    startdatepicker.datepicker("show");
  });  
  $("button#btn-enddate").click(function() {
    enddatepicker.datepicker("show");
  });
  
  //
  $("div.find-record, table ").on("click","div.img-container>img#img-new-record, td>img#img-edit-record",function() {    
    //
    //$("form#form-save").attr("action",
      //relativePath + activePage.data("save-url") + "?" + $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text());
    //
    $("form#form-save input:not(:radio), form#form-save textarea").val("");
    //    
    var dataId = $(this).parent("td").parent("tr").data("id");
    if(!(dataId === null || dataId === undefined)) {
      var dataArr = scope.dataarr;//getCurrDataObj(scope.datatable,dataId,dataIdField);
      $("form#form-save input:not(.data-detail), form#form-save textarea, form#form-save select:not(.select-exclude-scan)").each(function() {
        if($(this).is(":radio")) {
          if($(this).val() === dataArr[$(this).attr("name")])
            $(this).prop("checked",true);
        } else {
          $(this).val(dataArr[$(this).attr("id")]);
        }
        if($(this).is(":checkbox"))
          $(this).prop("checked",$(this).val()+""==="true");
      });
      if(objRelMap.length > 0) {
        $.each(objRelMap,function(idxClass,valClass) {
          $.each(valClass.field,function(idxField, valField) {
            var dataRelVal = dataArr[valClass.name] === null ? "" : dataArr[valClass.name][valField.column];
            $("form#form-save #"+valField.id).val(dataRelVal);
          });
        });
      }
      if(hideFieldOnUpdateArr.length > 0) {
        $.each(hideFieldOnUpdateArr,function(idx,val) {
          $("form#form-save div:has(input#"+val+")").prop("hidden",true);
          $("form#form-save #"+val).prop("required",false);
        });
      }
      //
      if(!$.isEmptyObject(masterDetailObj)) {
        $.each(masterDetailObj.data,function(idx,val) {
          var detailData = dataArr[val.edit];
          $.each(detailData,function(idxDet,valDet) {
            $("table#tbl-data-dtl tr").each(function() {
              var fieldId = $(this).find("td#"+val.field.idName);
              if(valDet[val.field.objName][val.field.idName] + "" === fieldId.children("span").text()) {
                fieldId.children("input#inputVerif").prop("checked",true);
                $(this).find("input:not(#inputVerif)").each(function() {
                  $(this).val(valDet[$(this).attr("id")]);
                });
                return false;
              }
            });
          });
        });
      }
      $("div#mdl-save-record .modal-title>img").attr("src",relativePath+"img/icon/edit-icon.png");
      $("div#mdl-save-record .modal-title>span").text("Edit Record");
    } else {
      if(hideFieldOnUpdateArr.length > 0) {
        $.each(hideFieldOnUpdateArr,function(idx,val) {
          $("form#form-save div:has(input#"+val+")").prop("hidden",false);
          $("form#form-save #"+val).prop("required",true);
        });
      }
      $("form#form-save>input[type=hidden]:nth-child(1)").val("0");
      $("div#mdl-save-record .modal-title>img").attr("src",relativePath+"img/icon/new-icon.png");
      $("div#mdl-save-record .modal-title>span").text("New Record");      
    }
    $("div#mdl-save-record").modal("show");      
  });
  
  $("form#form-save").on("submit",function(evt) {
    evt.preventDefault();
    var status = true;
    var currForm = $(this);
    if(new Date(currForm.find("input#startDate").val()) > new Date(currForm.find("input#endDate").val())) {
      alert("Until/end date must be greater than valid/start date")
      return false;
    }
    if(fieldToCheckBeforeSaveArr.length > 0) {
      $.each(fieldToCheckBeforeSaveArr,function(idx,val) {
        if(currForm.find("input#"+val.field1).val() !== currForm.find("input#"+val.field2).val()) {
          status = false;
          alert(val.alert);
          return false;
        }          
      });
    }
    if(status) {
      scope.saveData(relativePath + activePage.data("save-url") + "?" + $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text(),
                    formInputFile,
                    modalSave);
    }
  });
  
  //  
  $("div.find-record").on("click", "div.img-container>img#img-save-record", function() {
    if($(masterListUpdateOnly.updAssignObj).val() === "0") {
      messageMdlContent.css("background-color","rgba(10,20,40,0.8)").css("color",colWarning);
      messageMdlBody.html(masterListUpdateOnly.warnMessage[0]);
      messageMdl.modal("show");
    } else if(masterListUpdateOnly.updCommissionObj && $(masterListUpdateOnly.updCommissionObj).val() === "0") {
      messageMdlContent.css("background-color","rgba(10,20,40,0.8)").css("color",colWarning);
      messageMdlBody.html(masterListUpdateOnly.warnMessage[1]);
      messageMdl.modal("show");
    } else if(masterListUpdateOnly.updCommissionObj && 
            ($(masterListUpdateOnly.updCommissionObj).val() === $(masterListUpdateOnly.updAssignObj).val())) {
      messageMdlContent.css("background-color","rgba(10,20,40,0.8)").css("color",colWarning);
      messageMdlBody.html(masterListUpdateOnly.warnMessage[2]);
      messageMdl.modal("show");
    } else if($("table#tbl-data>tbody>tr>td>input#inputVerif:checked").length === 0) {
      messageMdlContent.css("background-color","rgba(10,20,40,0.8)").css("color",colWarning);
      messageMdlBody.html("Nothing to save ..!");      
      messageMdl.modal("show");
    } else {
      scope.saveData(relativePath + activePage.data("save-url") + "?" + $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text(),
                    formInputFile,
                    modalSave);
    }
  });
    
});

/********************************************/

  
/****** A N G U L A R   S E C T I O N ******/

//Setup angular modul
var angularApp = angular.module("angularApp",[]);

//own directive
angularApp.directive("fileModel", ["$parse", function ($parse) {
    return {
        restrict: "A",
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind("change", function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

//Setup service
angularApp.service("paramserv", ["$http", function($http) {
  
  //
  this.execajax = function (method, url, params, data, headers, callback) {
    startAnimation();
    var prop = {method: method,
                url: url,
                params: params,
                data: data,
                headers: headers/*,
                transformRequest: angular.identity*/
              };
    var showMessage = (method.toLowerCase() === "post" && url.indexOf("download") === -1);
    //
    $http(prop).then(function success(response){
      callback(response);
      if(showMessage) {
        messageMdlContent.css("background-color",backColInfo).css("color",colInfo);
        messageMdlBody.html("Your change has been saved ..!");
      }
    }, function error(response){      
      if(response.status !== undefined) {
        messageMdlContent.css("background-color","rgba(10,20,40,0.8)").css("color",colWarning);
        messageMdlBody.html("Oops something wrong with the request..! (" + response.statusText + "):<br/>" +
                              "<ul>" +
                                "<li>Check the input constraint (duplicate key/value, not null value, etc)</li> " +
                                "<li>Still in the development phase, contact the developer</li>" +
                              "</ul>");
        showMessage = true;
      } else if(showMessage) {
        messageMdlContent.css("background-color",backColInfo).css("color",colInfo);
        messageMdlBody.html("Your change has been saved ..!");
      }
    }).finally(function() {  
      if(showMessage)
        messageMdl.modal("show");  
      endAnimation();
    });
  };
  //
  this.uploadfile = function(url,formData,contentType,processData,cache,callback) {
    startAnimation();
    $.ajax({
      method: "POST",
      url: url,
      data: formData,
      contentType: contentType,
      processData: processData,
      cache: cache
    }).done(function(response) {
      messageMdlContent.css("background-color",backColInfo).css("color",colInfo);
      messageMdlBody.html("Your change has been saved ..!");
      callback(response);
    }).fail(function(response) {
      messageMdlContent.css("background-color","rgba(10,20,40,0.8)").css("color",colWarning);
      messageMdlBody.html("Oops something wrong with the uploaded file or the development ..!: " + response.status);
    }).always(function() {
      messageMdl.modal("show");  
      endAnimation();
    });
  };
}]);

angularApp.service("dataserv", function(paramserv) {
  //
  this.getData = function(url,params,callback) {
    paramserv.execajax("GET",url,params,null,{"Content-Type": "application/json"},callback);
  };
  //
  this.saveData = function(url,data,callback) {
    paramserv.execajax("POST",url,null,data,{"Content-Type": "application/json"},callback);
  };
  //
  this.postDataByParam = function(url,params,callback) {
    paramserv.execajax("POST",url,params,null,null,callback);
  };
  //
  /*this.uploadFileReg = function(url,response,callback) {
    if(formInputFile.val()) {
      var formData = new FormData();
      formInputFile.each(function() {
        formData.append($(this).attr("name"),this.files[0]);
      });
      formData.append(uploadFileObj.field,response.data[uploadFileObj.field]);
      $.ajax({
        method: "POST",
        url: url.replace(uploadFileObj.name,uploadFileObj.name+"/file"),
        data: formData,
        contentType: false,
        processData: false,
        cache: false
      }).done(function(resp) {
        callback();
        //window.location.reload();
      }).fail(function() {
      });
    } else {
      callback();
      //window.location.reload();
    }    
  };*/
  //
  this.uploadFile = function(url,params,callback) {
    var formData = new FormData();
    for(var key in params) {
      formData.append(key,params[key]);
    }
    paramserv.uploadfile(url,formData,false,false,false,callback);
  };
});

angularApp.service("domserv", function() {
  //
  this.addTitleAndFind = function(activePage) {
    //
    var container = $("div#page-content-wrapper>div.container");
    
    // find & new
    if(loadInitListObj) {
      var $findRecord = $("div#page-content-wrapper>div.container div.find-record");
      var $imgContainer = $("<div>", {"class": "img-container"});
      
      $("<img>", 
        {"id": "img-find-record", "class": "img-record img-record-medium",
          "src": "../../img/icon/find-icon.png", "alt": "Find icon", "title": "Find Record"})
                .appendTo($imgContainer);
      if(replaceWithSaveImage) {
        $("<img>", 
          {"id": "img-save-record", "class": "img-record img-record-medium",
            "src": "../../img/icon/save-icon.png", "alt": "Save icon", "title": "Save Record"})
                  .appendTo($imgContainer);
        $imgContainer.find("img#img-find-record").prop("hidden",true);
      } else if(!showFindImgOnly) {
        $("<img>", 
          {"id": "img-new-record", "class": "img-record img-record-medium",
            "src": "../../img/icon/new-icon.png", "alt": "New icon", "title": "New Record"})
                  .appendTo($imgContainer);
      }
      
      $findRecord.append($imgContainer);
    }

    // title
    var $divTitle = $("<div>", {"class": "table-title"});
    $("<span>").text(activePage.children("a").text().trim()).appendTo($divTitle);
    container.prepend($divTitle);    
    
    return container;
  };
  //
  this.updatePaging = function(data) {
    execPaging(data.count);
  };
  //
  this.assignData = function() {
    var objData = {};
    if(!$.isEmptyObject(masterListUpdateOnly)) {
      var dataIdList = [];
      $("table#tbl-data>tbody>tr").each(function() {
        if($(this).find("td>input#inputVerif").prop("checked") === true) {
          dataIdList.push($(this).data("id"));
        }
      });
      if(dataIdList.length > 0) {
        objData[masterListUpdateOnly.updVarName] = $(masterListUpdateOnly.updAssignObj).val();
        objData[masterListUpdateOnly.updListIdName] = dataIdList;
      }      
    } else {
      $("form#form-save input:not(:file):not(.display-only):not(.data-detail), form#form-save textarea, form#form-save select").each(function() {
        if($(this).is(":checkbox")) 
          objData[$(this).attr("id")] = $(this).prop("checked")+"";
        else if($(this).is(":radio") && $(this).is(":checked"))
          objData[$(this).attr("name")] = $(this).val();
        else
          objData[$(this).attr("id")] = $(this).val();
      });
      //
      if(!$.isEmptyObject(masterDetailObj)) {
        $.each(masterDetailObj.data,function(idx,val) {
          var objOthArr = [];
          $("table#tbl-data-dtl>tbody>tr").each(function() {
            var objOth = {};
            if($(this).find("td>input#inputVerif").prop("checked") === true) {
              if(masterDetailObj.isFormOnly) { 
                for(var key in objData) {
                  if(objData.hasOwnProperty(key))
                    objOth[key] = objData[key];
                }
              }
              var tdId = $(this).children("td").eq(0);
              objOth[tdId.attr("id")] = tdId.children("span").text();
              $(this).children("td").each(function() {
                $(this).children("input:not(#inputVerif)").each(function() {
                  objOth[$(this).attr("id")] = $(this).val();
                });
              });
            }
            if(!$.isEmptyObject(objOth))
              objOthArr.push(objOth);
          });
          objData[val.new] = objOthArr;
        });
      }
    }
    //alert(JSON.stringify(objData));
    return objData;
  };
  
  this.showModal = function(modalName) {
    $(modalName).modal("show");
  };
  
  this.hideModal = function(modalName) {
    $(modalName).modal("hide");
  };
  
  this.resetInputVal = function() {
    var inputArr = [{name:"input#inputVerifAll",type:"checkbox"}];
    $.each(inputArr,function(idx,val) {
      if(val.type === "checkbox") {
        $(val.name).prop("checked",false);
      } else {
        $(val.name).val("");
      }
    });
  };
});

//Setup controller
angularApp.controller("angularCtrl", function($scope,$compile,dataserv,domserv) {
  //
  $scope.datadrop = {};
  
  //Show/hide item by comparing its value and the default
  $scope.hideItem = function(itemVal,defVal) {
    if(itemVal === defVal)
      return true;
    return false;
  };
  
  //
  $scope.radioButton = function(radioEnable,currentValue,fieldValue) {
    if(radioEnable === "true") {
      if(currentValue === fieldValue)
        return "on";
      else
        return "off";
    } else {
      return "disable";
    }
  };
  
  //
  $scope.getData = function(url,params) {
    var updateDatatable = function(response) {
      $scope.datatable = response.data.content;
      domserv.updatePaging(response.data);
      $scope.url = url;
      $scope.params = params;
    };
    dataserv.getData(url,params,updateDatatable);    
  };
  
  //
  $scope.initDropdown = function(pathUrl,pathName) {
    var updateDropdown = function(response) {
      var dataDropName = pathName;
      if(pathName.indexOf("/") > 0)
        dataDropName = pathName.split("/").pop();
      $scope.datadrop[dataDropName] = response.data;
    };
    dataserv.getData(pathUrl+"/"+pathName,{},updateDropdown);
  };
  
  //
  $scope.addTitleAndFind = function(activePage) {
    $compile(domserv.addTitleAndFind(activePage))($scope);
  };
  
  //
  $scope.saveData = function(url,formInputFile,modalSave) {
    $scope.$apply();
    var uploadFile = function(response) {
      if(formInputFile.val()) {
        var params = {};
        formInputFile.each(function() {
          params[$(this).attr("name")] = this.files[0];
        });
        params[uploadFileObj.field] = response.data[uploadFileObj.field];
        $scope.uploadFile(url.replace(uploadFileObj.name,uploadFileObj.name+"/file"),params,function(responseDown) {
          $scope.getData($scope.url,$scope.params);
          domserv.hideModal(modalSave);
        });
      } else {
        $scope.getData($scope.url,$scope.params);
        domserv.hideModal(modalSave);
      } 
      domserv.resetInputVal();
    };
    dataserv.saveData(url,domserv.assignData(),uploadFile);
    //domserv.assignData();
  };
  
  //
  $scope.initDropdownCommon = function(pathUrl,pathName,params,callback) {
    var updateDropdown = function(response) {
      $scope.datadrop[pathName] = response.data;
      callback(response);
    };
    dataserv.getData(pathUrl+"/"+pathName,params,updateDropdown);
  };
  
  //
  $scope.store = function(data) {
    $scope.data = data;
  };
  
  //
  $scope.storedd = function(drop) {
    $scope.datadd = drop;
  };
  
  $scope.storearr = function(dataarr) {
    $scope.dataarr = dataarr;
  };
  
  //
  $scope.switchValTo = function(valToSwitch,switchedVal,checkedVal) {
    if(valToSwitch === checkedVal)
      return switchedVal;
    return valToSwitch;
  };
  
  //
  $scope.initDataTableGeneric = function(pathUrl,pathName,params,callback) {
    dataserv.getData(pathUrl+"/"+pathName,params,function(response) {
      var tableContents = response.data.tableContents;
      var contents = [];
      $.each(tableContents,function(idx,val) {
        contents[idx] = val.val.split(delimiter);
      });
      var datatablegeneric = {headers: response.data.tableHeaders, contents: contents};
      $scope.datatablegeneric = datatablegeneric;
      callback(response);
    });
  };
  
  //
  $scope.showModal = function(modalName) {
    domserv.showModal(modalName);
  };
  
  //
  $scope.uploadFile = function(url,params,callback) {
    dataserv.uploadFile(url,params,callback);
  };
  
  //
  $scope.postDataByParam = function(url,params,callback) {
    dataserv.postDataByParam(url,params,callback);
  };
  
  //
  $scope.getDataCommon = function(url,params,callback) {
    dataserv.getData(url,params,callback);
  };
});

