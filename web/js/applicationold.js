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

$(document).ready(function() {
  
  //
  var startdatepicker = datePicker("input#startDate");
  var enddatepicker = datePicker("input#endDate");
  var pattern1 = "";
  var pattern2 = "";
  var scope = $("div#div-table").scope();
  var activePage = $("div#sidebar-wrapper>ul.sidebar-nav>li.active-page");
    
  //
  var inputRequired = $("form#form-save input.input-required");
  inputRequired.eq(0).prop("autofocus",true);
  inputRequired.prop("required",true);
  
  //
  var gendata = function() {
    scope.getData(relativePath + activePage.data("data-url")+"/"+currPageNo,
      {pattern1: scope.pattern1, pattern2: scope.pattern2});
  };
  
  //
  scope.addTitleAndFind(activePage);
  gendata();
  
  //dropdown
  if(dropdownArr.length > 0)
    $.each(dropdownArr,function(idx,val) {
      scope.initDropdown(relativePath+"apps/data/"+val);      
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
    $("form#form-save").attr("action",
      relativePath + activePage.data("save-url") + "?" + $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text());
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
  
  $("form#form-save").on("submit",function() {
    $(this).find(":checkbox").each(function() {
      if($(this).prop("checked"))
        $(this).val("true");
      else
        $(this).val("false");
    });
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

//Setup service
angularApp.service("paramserv", ["$http", function($http) {
  this.execajax = function (method, url, params, data, headers, callback) {
    var prop = {method: method,
                url: url,
                params: params,
                data: data,
                headers: headers
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
    paramserv.execajax("GET",url,params,null,null,callback);
  };
  //
  this.updatePaging = function(data) {
    execPaging(data.count);
  };
});

angularApp.service("domserv", function() {
  this.addTitleAndFind = function(activePage) {
    //
    var container = $("div#page-content-wrapper>div.container");
    
    // find & new
    var $findRecord = $("<div>", {"class": "find-record form-group"});
    $.each(inputFindAttr,function(idx,val) {
      var $findRecordColSm3 = $("<div>", {"class": "col-sm-3"});
      var $inputFind = $("<input>", {"class": "form-control", "placeholder": val.placeholder}).attr("ng-model","pattern"+(idx+1));
      if(val.id)
        $inputFind.attr("id",val.id);
      if(val.title)
        $inputFind.attr("title",val.title);
      $inputFind.appendTo($findRecordColSm3);    
      $findRecord.append($findRecordColSm3);    
    });
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
    container.prepend($findRecord);    

    // title
    var $divTitle = $("<div>", {"class": "table-title"});
    $("<span>").text(activePage.children("a").text().trim()).appendTo($divTitle);
    container.prepend($divTitle);    
    
    return container;
  };
});

//Setup controller
angularApp.controller("angularCtrl", function($scope,$http,$compile,dataserv,domserv) {
  
  //
  $scope.getData = function(url,params) {
    var updateDatatable = function(response) {
      $scope.datatable = response.data.content;
      dataserv.updatePaging(response.data);
    };
    dataserv.getData(url,params,updateDatatable);    
  };
  
  //
  $scope.initDropdown = function(url) {
    var updateDropdown = function(response) {
      $scope.datadrop = response.data; 
    };
    dataserv.getData(url,{},updateDropdown);
  };
  
  //
  $scope.addTitleAndFind = function(activePage) {
    $compile(domserv.addTitleAndFind(activePage))($scope);
  };
});

