/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//global variable
var dataIdField;
var objRelMap = [];
var inputFindAttr = [];
var dropdownArr = [];
var hideFieldOnUpdateArr = [];
var uploadFileObj = {};
var fieldToCheckBeforeSaveArr = [];
var fieldToAssignBeforeSaveArr = [];
var fieldIncludeCheckboxListArr = [];

$(document).ready(function() {
  
  //
  var startdatepicker = datePicker("input#startDate");
  var enddatepicker = datePicker("input#endDate");
  var pattern1 = "";
  var pattern2 = "";
  var scope = $("div#div-table").scope();
  var activePage = $("div#sidebar-wrapper>ul.sidebar-nav>li.active-page");
  var asofdatePattern = "^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";
    
  //
  var inputRequired = $("form#form-save input.input-required");
  inputRequired.eq(0).prop("autofocus",true);
  inputRequired.prop("required",true);
  
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
  gendata();
  
  //dropdown
  if(dropdownArr.length > 0)
    $.each(dropdownArr,function(idx,val) {
      scope.initDropdown(relativePath+"apps/data",val);
    });
  
  //
  $(".table-container").scroll(function() {
    $(".table-container td:first-child")
            .css("transform","translate(" + $(this).scrollLeft() + "px)");
  });
  
  //
  $("div.find-record").on("click", "div.img-container>img#img-find-record", function() {
    currPageNo = 1;
    pattern1 = scope.pattern1;
    pattern2 = scope.pattern2;
    gendata();
  });
  
  //
  $("table ").on("click","td>img#img-delete-record",function() {
    $("div#message-mdl .modal-body").html("Currently unavailable");
    $("div#message-mdl").modal("show");    
  });
  
  //
  $("div#pagination>ul").on("click","li",function() {
    scope.pattern1 = pattern1;
    scope.pattern2 = pattern2;
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
    $("form#form-save input, form#form-save textarea").val("");
    //    
    var dataId = $(this).parent("td").parent("tr").data("id");
    if(!(dataId === null || dataId === undefined)) {
      var dataArr = getCurrDataObj(scope.datatable,dataId,dataIdField);
      $("form#form-save input, form#form-save textarea").each(function() {
        $(this).val(dataArr[$(this).attr("id")]);
        if($(this).is(":checkbox"))
          $(this).prop("checked",$(this).val()==="true");
      });
      if(objRelMap.length > 0) {
        $.each(objRelMap,function(idxClass,valClass) {
          $.each(valClass.field,function(idxField, valField) {
            $("form#form-save #"+valField).val(dataArr[valClass.name][valField]);
          });
        });
      }
      if(hideFieldOnUpdateArr.length > 0) {
        $.each(hideFieldOnUpdateArr,function(idx,val) {
          $("form#form-save div:has(input#"+val+")").prop("hidden",true);
          $("form#form-save #"+val).prop("required",false);
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
      if(fieldToAssignBeforeSaveArr.length > 0) {
        $.each(fieldToAssignBeforeSaveArr,function(idx,val) {
          if(!currForm.find("input#"+val.target).val()) {
            currForm.find("input#"+val.target).val(currForm.find("input#"+val.source).val());
          }          
        });
      }
      scope.saveData(relativePath + activePage.data("save-url") + "?" + $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text());
    }
  });
  
  //
  
  $("div.find-record").on("click", "div.img-container>img#img-find-record", function() {
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
    }
    function setTtDateStyle(styleProp,styleValue) {
      tooltipDate.css(styleProp,styleValue);
      tooltipDate.css("webkit-" + styleProp,styleValue);
    }
  });

  //  
  function getCurrDataObj(dataArr,dataId,idName) {
    var currDataObj = {};
    $.each(dataArr,function(idx,val) {
      if(val[idName] === dataId) {
        currDataObj = dataArr[idx];
        return false;
      }
    });
    return currDataObj;
  }  
    
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
  this.execajax = function (method, url, params, data, headers, callback) {
    var prop = {method: method,
                url: url,
                params: params,
                data: data,
                headers: headers/*,
                transformRequest: angular.identity*/
              };
    $http(prop).then(function success(response){
      callback(response);
    }, function error(response){      
      $("div#message-mdl .modal-body").html("Oops something wrong ..!: " + response.status);
      $("div#message-mdl").modal("show");    
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
  this.uploadFile = function(url,response) {
    var formInputFile = $("form#form-save input:file");
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
        $("div#mdl-save-record").modal("hide");
        window.location.reload();
      }).fail(function() {
      });
    } else {
      $("div#mdl-save-record").modal("hide");
      window.location.reload();
    }    
  };
});

angularApp.service("domserv", function() {
  //
  this.addTitleAndFind = function(activePage) {
    //
    var container = $("div#page-content-wrapper>div.container");
    
    // find & new
    var $findRecord = $("div#page-content-wrapper>div.container div.find-record");
    var $imgContainer = $("<div>", {"class": "img-container"});
    $("<img>", 
      {"id": "img-find-record", "class": "img-record img-record-medium",
        "src": "../../img/icon/find-icon.png", "alt": "Find icon", "title": "Find Record"})
              .appendTo($imgContainer);
    $("<img>", 
      {"id": "img-new-record", "class": "img-record img-record-medium",
        "src": "../../img/icon/new-icon.png", "alt": "New icon", "title": "New Record"})
              .appendTo($imgContainer);
    $findRecord.append($imgContainer);

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
    var objArr = {};
    $("form#form-save input:not(:file):not(.display-only), form#form-save textarea, form#form-save select").each(function() {
      if($(this).is(":checkbox")) 
        objArr[$(this).attr("id")] = $(this).prop("checked")+"";
      else
        objArr[$(this).attr("id")] = $(this).val();
    });
    if(fieldIncludeCheckboxListArr.length > 0) {
      $.each(fieldIncludeCheckboxListArr,function(idx,val) {
        var cbList = [];
        $("form#form-save div#"+val+" input:checkbox").each(function() {
          if($(this).prop("checked") === true)
            cbList.push($(this).parents(".input-group").data("id"));
        });
        objArr[val] = cbList;
      });
    }
    return objArr;
  };
});

//Setup controller
angularApp.controller("angularCtrl", function($scope,$compile,dataserv,domserv) {
  //
  $scope.datadrop = {};
  
  //
  $scope.getData = function(url,params) {
    var updateDatatable = function(response) {
      $scope.datatable = response.data.content;
      domserv.updatePaging(response.data);
    };
    dataserv.getData(url,params,updateDatatable);    
  };
  
  //
  $scope.initDropdown = function(pathUrl,pathName) {
    var updateDropdown = function(response) {
      $scope.datadrop[pathName] = response.data;
    };
    dataserv.getData(pathUrl+"/"+pathName,{},updateDropdown);
  };
  
  //
  $scope.addTitleAndFind = function(activePage) {
    $compile(domserv.addTitleAndFind(activePage))($scope);
  };
  
  //
  $scope.saveData = function(url) {
    var uploadFile = function(response) {
      dataserv.uploadFile(url,response);
    };
    dataserv.saveData(url,domserv.assignData(),uploadFile);
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
});

