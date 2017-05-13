/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Default script to be used in the application
 */

/*** GLOBAL VARIABLE ***/

/**
 * Id for identifier, ie. coyId for identify company object
 * @type String
 */
var dataIdField; 

/**
 * object must be cast to scalar so it must be represented by its relation identifier
 * ie. in json {id:1,name:"xxx",data:{id:1,name:"yyyy"}} object data represented by id of data
 * format [name: "data", field: [{column: "id", id: "id"}]]
 * column name in database may be different with id name in html tag
 * @type Array
 */
var objRelMap = []; 

/**
 * scope name and url last path of drop down menu
 * ie. ["coy"] will ask apps to create scope named datadrop.coy and retrieve its data from [app_url_path]/coy
 * @type Array
 */
var dropdownArr = [];

/**
 * we create new record and edit record in the same form, so to distinct them while showing the html tag use this array
 * ie. ["user-password"] will show html tag with id "user-password" showing on new record only not on edit record process
 * @type Array
 */
var hideFieldOnUpdateArr = [];

/**
 * if modul has file to upload create this object
 * format and sample {name:"appname",field:"field1"}, ask app to upload file with html tag id = "field1" to url [app_url_path]/appname/file
 * @type Object
 */
var uploadFileObj = {};

/**
 * compare two field value to validate
 * format and sample [{field1:"field1",field2:"field2",alert:"alert message"}]
 * will ask app to compare the value of two field, if mismatch then show "alert message"
 * @type Array
 */
var fieldToCheckBeforeSaveArr = [];

/**
 * we have to count how many animations have been started
 * so they only stop when all animations have been done
 * @type Number
 */
var animationCount = 0;

/**
 * sometime there is data with no predefined object, so we have to get all of its columns and separeted them w/ delimiter
 * @type String
 */
var delimiter = "|";

/**
 * saving master-detail data in one process
 * @type Object
 */
var masterDetailObj = {};

/**
 * update master data list need to specify some objects
 * @type Object
 */
var masterListUpdateOnly = {};

/**
 * simple form page do not need this (table contain data with supported tools like find button, new button, etc)
 * @type Boolean
 */
var loadInitListObj = true;

/**
 * if we need to replace functional image (find & new) with save image (in selected modul)
 * @type Boolean
 */
var replaceWithSaveImage = false;

/**
 * show find image only
 * @type Boolean
 */
var showFindImgOnly = false;

/**
 * if modul is find only modul, we need to check some objects
 * must be used together with showFindImgOnly variable
 * @type Array
 */
var masterFindOnlyArr = [];

/**
 * scope we used to execute the angular
 * @type String
 */
var elementScope = "div#content";// "div#page-content-wrapper";

/**
 * check date entered through pattern
 * @type String
 */
var datePattern = "^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";

/**
 * we need to disable records instead of delete them
 * each object in the list has two field, its name (fieldName) and where to grab its value (fieldValue)
 * @type Array
 */
var disableObjArr = [];

/**
 * if modul has specific separated class set this to 'true'
 * @type Boolean
 */
var hasExtraClass = false;

/**
 * add some extra scripts to modul than the default (usually [modul-name].js)
 * @type Array
 */
var extraScriptArr = [];

//this is an additional function that will only be executed if the data generating has been completed
var cbFuncGenData = function() {};

/**
 * if we have list of detail and need to check specific checked field may not be empty before save
 * @type type
 */
var extraCheckFieldDetail = {};

/**
 * list catch error and its message: errTxt=error text to capture, errMsg=error message to prompt
 * @type Array
 */
var errorCaptureArr = [];

/**
 * check date input must be equal or greater than today
 * @type Boolean
 */
var isDateCheckToToday = false;

/**
 * variable modal message
 * @type various
 */
var messageMdl = $("div#message-mdl");
var messageMdlContent = messageMdl.find(".modal-content");
var messageMdlTitle = messageMdlContent.find(".modal-title");
var messageMdlBody = messageMdlContent.find(".modal-body");
var backColInfo = "rgba(16,64,112,0.8)";
var backColError = "rgba(10,20,40,0.8)";
var mdlTitleInfo = "&nbsp;Information";
var mdlTitleError = "&nbsp;Error";
var mdlTitleClassInfo = "glyphicon glyphicon-info-sign";
var mdlTitleClassError = "glyphicon glyphicon-exclamation-sign";
var colInfo = "white";
var colError = "red";



/*** GLOBAL FUNCTION ***/

/**
 * start the foreground animation
 * @returns void
 */
function startAnimation() {
  animationCount += 1;
  $(".back-cover").show();
  $(".back-cover, .red-ball, .blue-ball, .green-ball, .loading-text").css("animation-play-state","running");
}

/**
 * end the foreground animation
 * @returns void
 */
function endAnimation() {
  animationCount -= 1;
  if(animationCount < 1) {
    $(".back-cover").hide();
    $(".back-cover, .red-ball, .blue-ball, .green-ball, .loading-text").css("animation-play-state","paused");
  }
}

/**
 * check requested current session(active/inactive) before execution
 * @returns void
 */
function checkCurrSessAndExec() {
  $.get(relativePath + "apps/auth/currentsession",function(data,status) {
    if(status === "success") {
      if(data != $("span#sessionid").text()) {
        window.location.reload();
      }
    } else {
      showErrorMessage("Get current session unsuccessfully: status = " + status);
    }
  }).fail(function(d) {
      showErrorMessage("Get current session unsuccessfully: status = " + d.status);
  });
}
 
/**
 * show warning/error message
 * @param {String} msg
 * @returns void
 */
function showErrorMessage(msg) {
  messageMdlTitle.children("span:first-child").attr("class",mdlTitleClassError);
  messageMdlTitle.children("span:last-child").html(mdlTitleError);
  messageMdlContent.css("background-color",backColError).css("color",colError);
  messageMdlBody.html(msg);
  messageMdl.modal("show");
}

/**
 * show info message 
 * @param {String} msg
 * @returns void
 */
function showInfoMessage(msg) {
  messageMdlTitle.children("span:first-child").attr("class",mdlTitleClassInfo);
  messageMdlTitle.children("span:last-child").html(mdlTitleInfo);
  messageMdlContent.css("background-color",backColInfo).css("color",colInfo);
  messageMdlBody.html(msg);
  messageMdl.modal("show");
}

//start the foreground animation to prevent end user acces the page immediately   
startAnimation();


/*** EVENT DRIVEN ***/

$(document).ready(function() {
  
  //verify that the logged user has session
  checkCurrSessAndExec();  
  
  var scope;// angular scope //= $(elementScope).scope();
  var activePage = $("div#sidebar-wrapper ul.sidebar-nav>li.active-page");//currently page was accesed
  var formInputFile;//object form alike that could be sent via ajax
  var modalSave = "div#mdl-save-record";
  var currPage = "";//the current page of the data to view
  
  /**
   * Navigate between menu
   * Process would executed
   * @param {String} href
   * @returns void
   */
  var switchMenu = function(href) {  
    
    //direct user to a default page if he access application page
    if(href.split("/").pop().indexOf("application") !== -1) {
      href = localStorage.getItem("defaultAppUrl");
    }
    
    /**
     * load target contents into page
     */
    $("div#content").load(href + " div.target-div",function() {
      
      //initial variable
      objRelMap = [];
      dropdownArr = [];
      hideFieldOnUpdateArr = [];
      uploadFileObj = {};
      fieldToCheckBeforeSaveArr = [];
      animationCount = 0;
      masterDetailObj = {};
      masterListUpdateOnly = {};
      loadInitListObj = true;
      replaceWithSaveImage = false;
      showFindImgOnly = false;
      masterFindOnlyArr = [];
      disableObjArr = [];
      hasExtraClass = false;
      extraScriptArr = [];
      extraCheckFieldDetail = {};
      errorCaptureArr = [];
      cbFuncGenData = function() {};
      isDateCheckToToday = false;

      /**
       * load target script into page
       */ 
      $.getScript(relativePath + activePage.data("js-url"), function() {  
        
        /**
         * initial process
         * @returns void
         */
        var initFunc = function() {
          
          //assign address to href
          history.pushState(null,null,href);
          //show target
          $("div#content").children("div").show();
          //assign angular scope
          scope = $(elementScope).scope();
          //assign form
          formInputFile = $("form#form-save input:file");
          //flush data
          scope.datatable = [];
          //add default object to page
          scope.addTitleAndFind(activePage);
          //compile modal save to enable it access anguler scope
          scope.compileObject($(modalSave));
          
          //load target css file into page
          if(hasExtraClass)
            $("link#link-temp").attr("href",relativePath + activePage.data("css-url"));

          //load dropdown data
          if(dropdownArr.length > 0)
            $.each(dropdownArr,function(idx,val) {
              scope.initDropdown(relativePath+"apps/data",val);
            });

          //load data
          if(loadInitListObj) {
            currPageNo = 1;
            gendata();        
          }
        };
      
        //extra script
        if(extraScriptArr.length > 0) {
          $.each(extraScriptArr,function(idx,val) {   
            $.getScript(val, function() {
              initFunc();
            });
          });
        } else {
          initFunc();
        }
      });
      
      
      
      /*** BINDING EVENT ***/
      
      /**
       * event: scroll table
       * action: move left object along with horizontal scrolling
       */
      $(".table-container").scroll(function() {
        $(this).find("td:first-child")
                .css("transform","translateX(" + $(this).scrollLeft() + "px)");
      });
  
      /**
       * event: scroll table
       * action: move upper object along with vertical scrolling
       */
      $(".table-container-normal").scroll(function() {
        $(this).find("th")
                .css("transform","translateY(" + $(this).scrollTop() + "px)");
      });
  
      /**
       * event: click page number
       * action: reload data
       * @param evt the event object
       */
      $("div#pagination>ul").on("click","li>a",function(evt) {    
        evt.preventDefault();
        clickPageNo("div#pagination>ul>li",this.parentNode.id,{},gendata);
      });
  
      /**
       * event: click find button
       * action: various (see the following process)
       */
      $("div.find-record").on("click", "div.img-container>img#img-find-record", function() {
        
        //initial break status
        var breakProcess = false;

        //specific checked
        //general value checked
        if(showFindImgOnly) {
          $.each(masterFindOnlyArr,function(idx,val) {
            var continued = true;
            $.each(val.fieldToCheck,function(idx1,val1) {          
              if($(val1).val() === "0") {          
                showErrorMessage(val.message);
                $(val1).addClass("back-error");
                animateStyle($(val1),[]);
                breakProcess = true;
                continued = false;
                return false;
              }
            });
            return continued;
          });    
          //validation failed, cancel the process
          if(breakProcess)
            return false;
        }

        //date format checked
        $.each(["input#asOfDate","input#startDateFind","input#endDateFind"],function(idx,val) {
          var currInputVal = $(val).val();
          if(currInputVal) {
            var $tooltipDate = $("div.tooltip-date");
            if(!(currInputVal.match(datePattern) || currInputVal === "")) {
              var currInputOff = $(val).offset();
              animateStyle($tooltipDate,[{styleProp:"transform",styleVal:"translate("+currInputOff.left+"px,"+(currInputOff.top - 20)+"px)"}]);
              breakProcess = true;
              return false;
            }
          }      
        });   
        //validation failed, cancel the process
        if(breakProcess)
          return false;

        //date value checked
        var $startDate = $("input#startDateFind");
        var startDate = $startDate.val();
        if(startDate) {
          var endDate = $("input#endDateFind").val();
          if(endDate) {
            if(startDate > endDate) {
              showErrorMessage("Start date must be earlier than end date ..!");
              $startDate.addClass("back-error");
              animateStyle($startDate,[]);
              return false;
            }
          }        
        }

        //ready to execute
        currPageNo = 1;
        gendata();

        /**
         * separate function
         * animate style
         * @param {Object} element
         * @param {Array} addStyleArr
         * @returns void
         */
        function animateStyle(element,addStyleArr) {
          $.each(addStyleArr,function(idx,val) {
            element.css(val.styleProp,val.styleVal);
            element.css("webkit-" + val.styleProp,val.styleVal);
          });
          element.css("animation-play-state","running");
          element.css("webkit-animation-play-state","running");
          element.on("animationend webkitAnimationEnd", function() {
            element.css("animation-play-state","paused");
            element.css("webkit-animation-play-state","paused");
            element.removeClass("back-error");
          });
        }
      });
  
      /**
       * event: click new or edit button
       * action: various (see the following process)
       */
      $("div.find-record, table ").on("click","div.img-container>img#img-new-record, td>img#img-edit-record",function() { 
        
        //reset previous data
        $("form#form-save").trigger("reset");
            
        var dataId = $(this).parent("td").parent("tr").data("id");//record id
        
        //read the record
        if(!(dataId === null || dataId === undefined)) { //edit process
          var dataArr = scope.dataarr;//assign current record
          
          //assign value to form field
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
          
          //assign relation value to form field
          if(objRelMap.length > 0) {
            $.each(objRelMap,function(idxClass,valClass) {
              $.each(valClass.field,function(idxField, valField) {
                var dataRelVal = dataArr[valClass.name] === null ? "" : dataArr[valClass.name][valField.column];
                $("form#form-save #"+valField.id).val(dataRelVal);
              });
            });
          }
          
          //hide spesific field on edit if any
          if(hideFieldOnUpdateArr.length > 0) {
            $.each(hideFieldOnUpdateArr,function(idx,val) {
              $("form#form-save div:has(input#"+val+")").prop("hidden",true);
              $("form#form-save #"+val).prop("required",false);
            });
          }
          
          //master detail relation
          //checked detail if it have relation to master
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
          
          //set edit icon and title
          $("div#mdl-save-record .modal-title>img").attr("src",relativePath+"img/icon/edit-icon.png");
          $("div#mdl-save-record .modal-title>span").text("Edit Record");
          
        } else {//new process
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
        //compile and show
        scope.$apply();
        $(modalSave).modal("show");      
      });
  
      /**
       * date picker
       * click input or button element to show the calendar
       * @type Object
       */
      var startdatepicker = datePicker(".input-group input#startDate");
      var enddatepicker = datePicker(".input-group input#endDate");
      //
      $("button#btn-startdate").click(function() {
        startdatepicker.datepicker("show");
      });  
      $("button#btn-enddate").click(function() {
        enddatepicker.datepicker("show");
      });
      //
      if($("input#startDateFind").length) {
        datePicker("input#startDateFind");
        datePicker("input#endDateFind");
      }
      if($("input#asOfDate").length)
        datePicker("input#asOfDate");
  
      /**
       * event: submit form/click ok button
       * action: various (see the following process)
       */
      $("form#form-save").on("submit",function(evt) {
        
        evt.preventDefault();
        var status = true;//check if form is allowed to submit
        var currForm = $(this);
        
        //end date must be greater or equal to start date
        if(new Date(currForm.find("input#startDate").val()) > new Date(currForm.find("input#endDate").val())) {
          showErrorMessage("Until/end date must be greater or equal to valid/start date")
          return false;
        }
        
        //saved end date must be greater or equal to today
        //disable through disable feature only
        if(new Date().setHours(0,0,0,0) > new Date(currForm.find("input#endDate").val())) {
          showErrorMessage("Please disable record via disable button ..!");
          return false;
        }
        
        //validate equality of values if any
        if(fieldToCheckBeforeSaveArr.length > 0) {
          $.each(fieldToCheckBeforeSaveArr,function(idx,val) {
            if(currForm.find("input#"+val.field1).val() !== currForm.find("input#"+val.field2).val()) {
              status = false;
              alert(val.alert);
              return false;
            }          
          });
        }
        
        //validate checkbox element has properly relation value
        if(!$.isEmptyObject(extraCheckFieldDetail)) {
          var checkBoxName = "td>input#"+extraCheckFieldDetail.checkboxField;
          $.each(extraCheckFieldDetail.fields,function(idx,val) {
            var fieldName = val.fieldName;
            $("table#tbl-data-dtl tr").each(function() {
              if($(this).find(checkBoxName).is(":checked") && $(this).find("td>input#"+fieldName).val() === "") {
                status = false;
                alert(val.alert);
                return false;
              }
            });
            return status;
          });
        }
        
        //validate value to the date of today
        if(isDateCheckToToday) {
          var today = new Date().setHours(0,0,0,0);
          if(today > new Date(currForm.find("input#startDate").val()) || today > new Date(currForm.find("input#endDate").val())) {
            showErrorMessage("Absence date must be equal or greater than today ..!");
            return false;
          }
        }
        
        //proceed to submit
        if(status) {
          scope.saveData(relativePath + activePage.data("save-url") + "?" + $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text(),
                        formInputFile,
                        modalSave);
        }
      });
  
      /**
       * event: click delete button
       * action: various (see the following process)
       */
      $("table ").on("click","td>img#img-delete-record",function() {
        
        //deleted modal variable
        var $delmdl = $("div#delete-mdl");
        var $delmdlhead = $delmdl.find("thead>tr");
        var $delmdlbody = $delmdl.find("tbody>tr");
        
        //init
        $delmdlhead.empty();
        $delmdlbody.empty();
        
        //creation of deleted table contents
        $.each(disableObjArr,function(idx,val) {
          $delmdlhead.append("<th>"+val.fieldName+"</th>");
          if(val.fieldValue.indexOf(".") > -1) {
            var fieldValueArr = val.fieldValue.split(".");
            $delmdlbody.append("<td>"+(scope.dataarr[fieldValueArr[0]][fieldValueArr[1]])+"</td>");
          } else {        
            $delmdlbody.append("<td>"+(scope.dataarr[val.fieldValue])+"</td>");      
          }
        });
        $delmdl.modal("show");    
      });
      
      /**
       * event: click 'ok' button on deleted modal
       * action: various (see the following process)
       */
      $("button#delete-confirm-btn").click(function() {
        
        //clear form
        var formData = {};
        
        //assign record id to delete
        formData[dataIdField] = scope.dataarr[dataIdField];
        
        //delete the record by given id
        scope.saveDataNonAssign(relativePath + activePage.data("save-url") + "/disable?" + $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text(),
                        formData,function(response) {
          scope.getData(scope.url,scope.params);
          if(response.data)
            $("div#delete-mdl").modal("hide");
        });
      });
  
      /**
       * event: click save button on main page
       * action: validate record, if it passed then save the change
       */
      $("div.find-record").on("click", "div.img-container>img#img-save-record", function() {
        if(masterListUpdateOnly.updAssignObj && $(masterListUpdateOnly.updAssignObj).val() === "0") {
          showErrorMessage(masterListUpdateOnly.warnMessage[0]);
        } else if(masterListUpdateOnly.updCommissionObj && $(masterListUpdateOnly.updCommissionObj).val() === "0") {
          showErrorMessage(masterListUpdateOnly.warnMessage[1]);
        } else if(masterListUpdateOnly.updCommissionObj && 
                ($(masterListUpdateOnly.updCommissionObj).val() === $(masterListUpdateOnly.updAssignObj).val())) {
          showErrorMessage(masterListUpdateOnly.warnMessage[2]);
        } else if($("table#tbl-data>tbody>tr>td>input#inputVerif:checked").length === 0) {
          showErrorMessage("Nothing to save ..!");
        } else {
          scope.saveData(relativePath + activePage.data("save-url") + "?" + $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text(),
                        formInputFile,
                        modalSave);
        }
      });
      
      /*** END BINDING EVENT ***/
    });
  };
  
  
  /**
   * On becoming as active page
   * @param {HTML Element} $element
   * @returns void
   */
  var switchActivePage = function($element) {
    
    //assign parent element
    var $parentThis = $element.parent("li");
    
    //add active page class to the current page and remove it from others
    $parentThis.siblings("li").removeClass("active-page");
    $parentThis.addClass("active-page");
    
    //assign active page for further purpose
    activePage = $parentThis;
  };
  
  /**
   * event: on loading window
   * action: various (see the following process)
   */
  $(window).load(function() {
    
    //assign href to load and proceed
    var href = localStorage.getItem("previousUrl") || localStorage.getItem("defaultAppUrl");
    switchMenu(href);
    
    //assign active page class to current menu
    var page = href.split("/").pop();
    var $sidebarLi = $(".sidebar-nav li:has(a)");
    $sidebarLi.removeClass("active-page");
    $(".sidebar-nav li:has(a)").each(function() {
      if(page === $(this).children("a").attr("href").split("/").pop()) {
        $(this).addClass("active-page");
        activePage = $(this);
        return false;
      }          
    });
  });

  /**
   * event: on binding window to browser back button
   * action: proceed switch menu/page
   */
  $(window).bind("popstate",function() {
    switchMenu(window.location.href);
  });

  /**
   * event: click menu
   * action: proceed switchMenu and switchActivePage function, and assign current page to the clicked href
   * @param evt : event object
   */
  $("div#sidebar-wrapper ul.sidebar-nav ").on("click","li>a",function(evt) {
    evt.preventDefault();
    if(currPage !== $(this).attr("href")) {
      switchMenu($(this).attr("href"));
      switchActivePage($(this));
      currPage = $(this).attr("href");
    }
  }); 
      
  /**
   * Generate main data
   * @returns void
   */
  var gendata = function() {
    
    //clear old parameter and assign the new ones
    var paramInput = {};
    $("div.find-record select, div.find-record input").each(function() {
      var name = $(this).attr("ng-model");
      paramInput[name] = scope[name];
    });
    
    //proceed to show the main data
    scope.getData(relativePath + activePage.data("data-url")+"/"+currPageNo, paramInput);
  };
    
});

/********************************************/

  
/************************************ A N G U L A R   S E C T I O N ************************************/

/**
 * Angular application module
 * @type angular.module.angular-1_3_6_L1749.moduleInstance
 */
var angularApp = angular.module("angularApp",[]);

/**
 * file model directive
 * modelling file 
 * @param {angular object} $parse 
 */
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

/**
 * Setup http/ajax service
 * @param {angular object} $http , ajax function accessor
 */
angularApp.service("paramserv", ["$http", function($http) {
  
  /**
   * Execution ajax call 
   * @param {String} method
   * @param {String} url
   * @param {Object} params , parameter pairs of name and value
   * @param {Object} data
   * @param {Object} headers
   * @param {Function} callback
   * @returns void
   */
  this.execajax = function (method, url, params, data, headers, callback) {
    
    //check user logged session
    checkCurrSessAndExec();
    
    //begin foreground animation
    startAnimation();
    
    //http property
    var prop = {method: method,
                url: url,
                params: params,
                data: data,
                headers: headers
              };
              
    //show message on post method and not in the download process
    var showMessage = (method.toLowerCase() === "post" && url.indexOf("download") === -1);
    
    /**
     * Ajax call
     * @param {Object} response , response object from ajax call
     */
    $http(prop).then(function success(response){
      
      //process response
      callback(response);
      
      //time to show the message if it was allowed
      if(showMessage) {
        if(response.data)
          showInfoMessage("Your change has been saved ..!");
        else
          showErrorMessage("Save got problem, your record may have relation ..!");
      }
      
    }, function error(response){      
      
      //undefined means error did not come from response but from caller
      //define error message based on stack trace
      if(response.status !== undefined) {
        var showError = true;
        if(errorCaptureArr.length > 0) {
          var responseError = JSON.stringify(response.data);
          $.each(errorCaptureArr,function(idx,val) {
            if(responseError.indexOf(val.errTxt) > -1) {
              showErrorMessage(val.errMsg);
              showError = false;
              return false;
            }
          });
        }        
        
        //show the default error if no error shown before
        if(showError)
          showErrorMessage("Something wrong with the request..! (" + response.statusText + "):<br/>" +
                              "<ul>" +
                                "<li>Check the input constraint (duplicate key/value, parent-child integrity, etc)</li> " +
                                "<li>Still in the development phase, contact the developer</li>" +
                              "</ul>");
                      
      //undefined error was assumed as a normal process
      } else if(showMessage) {
        if(response.data)
          showInfoMessage("Your change has been saved ..! status: " + response.status);
        else          
          showErrorMessage("Save got problem, your record may have relation ..!");
      } 
    }).finally(function() {
      //end foreground animation
      endAnimation();
    });
  };
  
  /**
   * Upload file
   * @param {String} url
   * @param {Object} formData , form object contain pair of name and value
   * @param {String} contentType
   * @param {Boolean} processData
   * @param {Boolean} cache
   * @param {Function} callback
   * @returns void
   */
  this.uploadfile = function(url,formData,contentType,processData,cache,callback) {
    
    //check user logged session
    checkCurrSessAndExec();
    
    //begin foreground animation
    startAnimation();
    
    /**
     * Ajax call
     * @param {Object} response , response object from ajax call
     */
    $.ajax({
      method: "POST",
      url: url,
      data: formData,
      contentType: contentType,
      processData: processData,
      cache: cache
    }).done(function(response) {
      
      //prompt success and proceed next process
      showInfoMessage("Your change has been saved ..!");
      callback(response);
      
    }).fail(function(response) {
      var showError = true;
      
      //verify error has spesific message and show the error when it found
      if(errorCaptureArr.length > 0) {
        var responseError = JSON.stringify(response.responseText);
        $.each(errorCaptureArr,function(idx,val) {
          if(responseError.indexOf(val.errTxt) > -1) {
            showErrorMessage(val.errMsg);
            showError = false;
            return false;
          }
        });
      }
      
      //show the default error if no error shown before
      if(showError)
        showErrorMessage("Oops something wrong with the uploaded file or the development ..!: " + response.status);
      
    }).always(function() {
      //end foreground animation
      endAnimation();
    });
  };
}]);

/**
 * Setup data access
 * @param {angular object} $http , ajax function accessor
 */
angularApp.service("dataserv", function(paramserv) {
  
  /**
   * Get json data from given url by specific params
   * @param {String} url
   * @param {Object} params , parameter pairs of name and value
   * @param {Function} callback
   * @returns void
   */
  this.getData = function(url,params,callback) {
    paramserv.execajax("GET",url,params,null,{"Content-Type": "application/json"},callback);
  };
  
  /**
   * Post data to specific url to be saved to database
   * @param {String} url
   * @param {Object} data , must be in form of java object (see each correlation class)
   * @param {Function} callback
   * @returns void
   */
  this.saveData = function(url,data,callback) {
    paramserv.execajax("POST",url,null,data,{"Content-Type": "application/json"},callback);
  };
  
  /**
   * Post params to specific url to be saved to database
   * @param {String} url
   * @param {Object} params , in form of pairs of name and value
   * @param {Function} callback
   * @returns void
   */
  this.postDataByParam = function(url,params,callback) {
    paramserv.execajax("POST",url,params,null,null,callback);
  };
  
  /**
   * Upload file to specific url by given params
   * @param {String} url
   * @param {Object} params , in form of pairs of name and value
   * @param {Function} callback
   * @returns void
   */
  this.uploadFile = function(url,params,callback) {
    var formData = new FormData();
    for(var key in params) {
      formData.append(key,params[key]);
    }
    paramserv.uploadfile(url,formData,false,false,false,callback);
  };
  
  /**
   * Get json data from given url by specific params without defining contents-type
   * @param {String} url
   * @param {Object} params , in form of pairs of name and value
   * @param {Function} callback
   * @returns void
   */
  this.getDataNonJson = function(url,params,callback) {
    paramserv.execajax("GET",url,params,null,null,callback);
  };
});

/**
 * Setup DOM manipulation
 * Access via angular service
 */
angularApp.service("domserv", function() {
  
  /**
   * Created new HTML element (title and button)
   * @param {Object} activePage , jQuery HTML <LI> element pointing to the current page
   * @returns HTML element
   */
  this.addTitleAndFind = function(activePage) {
    
    //assign element container where to put the new element
    var container = $("div#page-content-wrapper>div.container");
    
    // created general button function (find, new and save button)
    if(loadInitListObj) {
      
      var $findRecord = $("div#page-content-wrapper>div.container div.find-record");//element group where to put the buttons
      var $imgContainer = $("<div>", {"class": "img-container"});//parent element of the buttons
      
      //created find button and put it in the parent
      $("<img>", 
        {"id": "img-find-record", "class": "img-record img-record-medium",
          "src": "../../img/icon/find-icon.png", "alt": "Find icon", "title": "Find Record"})
                .appendTo($imgContainer);
      
      //created save button and put it in the parent
      if(replaceWithSaveImage) {
        $("<img>", 
          {"id": "img-save-record", "class": "img-record img-record-medium",
            "src": "../../img/icon/save-icon.png", "alt": "Save icon", "title": "Save Record"})
                  .appendTo($imgContainer);
        $imgContainer.find("img#img-find-record").prop("hidden",true);
      //created new button and put it in the parent
      } else if(!showFindImgOnly) {
        $("<img>", 
          {"id": "img-new-record", "class": "img-record img-record-medium",
            "src": "../../img/icon/new-icon.png", "alt": "New icon", "title": "New Record"})
                  .appendTo($imgContainer);
      }
      
      //finally, put the parent element into element group
      $findRecord.append($imgContainer);
    }

    //created table title and append it to container
    var $divTitle = $("<div>", {"class": "table-title"});
    $("<span>").text(activePage.children("a").text().trim()).appendTo($divTitle);
    container.prepend($divTitle);    
    
    return container;
  };
  
  /**
   * Update paging: assign active page and number of page
   * see execPaging function
   * @param {Object} data
   * @returns void
   */
  this.updatePaging = function(data) {
    execPaging(data.count);
  };
  
  /**
   * Assign data from form to be posted later
   * @returns data object, in form of name and value pair
   */
  this.assignData = function() {
    
    var objData = {};//data container
    
    //on update detail of the master
    //assign detail id to the container
    if(!$.isEmptyObject(masterListUpdateOnly)) {
      var dataIdList = [];
      $("table#tbl-data>tbody>tr").each(function() {
        if($(this).find("td>input#inputVerif").prop("checked") === true) {
          dataIdList.push($(this).data("id"));
        }
      });
      if(dataIdList.length > 0) {
        if(masterListUpdateOnly.updVarName)
          objData[masterListUpdateOnly.updVarName] = $(masterListUpdateOnly.updAssignObj).val();
        objData[masterListUpdateOnly.updListIdName] = dataIdList;
      }
    
    //normal assign
    //assign each field of the form into container
    } else {
      $("form#form-save input:not(:file):not(.display-only):not(.data-detail), form#form-save textarea, form#form-save select").each(function() {
        if($(this).is(":checkbox")) 
          objData[$(this).attr("id")] = $(this).prop("checked")+"";
        else if($(this).is(":radio") && $(this).is(":checked"))
          objData[$(this).attr("name")] = $(this).val();
        else
          objData[$(this).attr("id")] = $(this).val();
      });
      
      //additional assign if current module has detail relation
      if(!$.isEmptyObject(masterDetailObj)) {
        
        //iterate over each relation
        $.each(masterDetailObj.data,function(idx,val) {
          
          var objOthArr = [];//detail relation array
          
          //iterate over data in relation
          $("table#tbl-data-dtl>tbody>tr").each(function() {
            
            var objOth = {};//detail relation object
            
            //validate relation has properly value
            if($(this).find("td>input#inputVerif").prop("checked") === true) {
              
              //object not in the form of table but form
              if(masterDetailObj.isFormOnly) { 
                for(var key in objData) {
                  if(objData.hasOwnProperty(key))
                    objOth[key] = objData[key];
                }
              }
                            
              var tdId = $(this).children("td").eq(0);//id is in the first element of <TD>
              
              //assign id and other element value
              objOth[tdId.attr("id")] = tdId.children("span").text();
              $(this).children("td").each(function() {
                $(this).children("input:not(#inputVerif)").each(function() {
                  objOth[$(this).attr("id")] = $(this).val();
                });
              });
            }
            
            //put the detail object into array
            if(!$.isEmptyObject(objOth))
              objOthArr.push(objOth);
          });
          
          //and finally put the array into container
          objData[val.new] = objOthArr;
        });
      }
    }
    //alert(JSON.stringify(objData));
    return objData;
  };
  
  /**
   * Show the given modal
   * @param {String} modalName
   * @returns void
   */
  this.showModal = function(modalName) {
    $(modalName).modal("show");
  };
  
  /**
   * Hide the givem modal
   * @param {String} modalName
   * @returns void
   */
  this.hideModal = function(modalName) {
    $(modalName).modal("hide");
  };
  
  /**
   * Reset form value
   * @returns void
   */
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

/**
 * Setup controller 
 * @param {Object} $scope angular scope service
 * @param {Object} $compile angular compile service
 * @param {Object} dataserv custom angular data service
 * @param {Object} domserv custom angular DOM service
 */
angularApp.controller("angularCtrl", function($scope,$compile,dataserv,domserv) {
  
  //data dropdown object, contain list of objects
  $scope.datadrop = {};
  
  /**
   * Show/hide item by comparing its value and the default
   * @param {String} itemVal
   * @param {String} defVal default value
   * @returns {Boolean}
   */
  $scope.hideItem = function(itemVal,defVal) {
    if(itemVal === defVal)
      return true;
    return false;
  };
  
  /**
   * check given condition, set value if it is true/false
   * @param {Boolean} cond condition
   * @param {String} trueVal
   * @param {String} falseVal
   * @returns {String}
   */
  $scope.setCondVal = function(cond, trueVal, falseVal) {
    if(cond)
      return trueVal;
    return falseVal;
  };
  
  /**
   * Switch radio button based on given parameter value
   * @param {String} radioEnable verification of radio button 
   * @param {String} currentValue
   * @param {String} fieldValue
   * @returns {String}
   */
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
  
  /**
   * Get data via AJAX based on given url and parameter
   * @param {String} url
   * @param {Object} params , in form of pairs of name and value
   * @returns void
   */
  $scope.getData = function(url,params) {
    
    //reload data view after getting data
    var updateDatatable = function(response) {
      $scope.datatable = response.data.content;
      domserv.updatePaging(response.data);
      $scope.url = url;
      $scope.params = params;
      cbFuncGenData();
    };
    
    //execute AJAX call
    dataserv.getData(url,params,updateDatatable);    
  };
  
  /**
   * Get spesific data for dropdown object
   * @param {String} pathUrl full path url
   * @param {String} pathName last partial path which used to name dropdown object
   * @returns {undefined}
   */
  $scope.initDropdown = function(pathUrl,pathName) {
    
    //assign data to dropdown object
    var updateDropdown = function(response) {
      var dataDropName = pathName;
      if(pathName.indexOf("/") > 0)
        dataDropName = pathName.split("/").pop();
      $scope.datadrop[dataDropName] = response.data;
    };
    
    //execute AJAX call
    dataserv.getData(pathUrl+"/"+pathName,{},updateDropdown);
  };
  
  /**
   * Created new object of title and common button
   * @param {Oject} activePage current loading pahe
   * @returns void
   */
  $scope.addTitleAndFind = function(activePage) {
    $compile(domserv.addTitleAndFind(activePage))($scope);
  };
  
  /**
   * Post data to be saved to database
   * @param {String} url
   * @param {Object} formInputFile
   * @param {String} modalSave
   * @returns void
   */
  $scope.saveData = function(url,formInputFile,modalSave) {
    $scope.$apply();
    
    //additional process if any, such as upload image, etc.
    var uploadFile = function(response) {
      
      if(formInputFile.val()) {//form has file to upload
        var params = {};
        formInputFile.each(function() {
          params[$(this).attr("name")] = this.files[0];//currently supported only one file per field
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
      
      //clear form after save
      domserv.resetInputVal();
    };
    
    //execute AJAX call
    dataserv.saveData(url,domserv.assignData(),uploadFile);
  };
  
  /**
   * Get specific data for dropdown object with given parameters
   * @param {String} pathUrl , full path url
   * @param {String} pathName , partial path to be used to naming dropdown object
   * @param {Object} params , parameter in form of name and value pair
   * @param {Function} callback
   * @returns void
   */
  $scope.initDropdownCommon = function(pathUrl,pathName,params,callback) {
    
    //assign data to dropdown object
    var updateDropdown = function(response) {
      $scope.datadrop[pathName] = response.data;
      callback(response);
    };
    
    //execute AJAX call
    dataserv.getData(pathUrl+"/"+pathName,params,updateDropdown);
  };
  
  /**
   * Assign scope data
   * @param {Object} data
   * @returns void
   */
  $scope.store = function(data) {
    $scope.data = data;
  };
  
  /**
   * Assign scope data spesific to dropdown object
   * @param {Object} drop
   * @returns void
   */
  $scope.storedd = function(drop) {
    $scope.datadd = drop;
  };
  
  /**
   * Assign scope data specific to detail data
   * @param {Object} dataarr
   * @returns void
   */
  $scope.storearr = function(dataarr) {
    $scope.dataarr = dataarr;
  };
  
  /**
   * Validated data value, if it verified then switch it to a new value, otherwise no action needed
   * @param {String} valToSwitch , value to be verified
   * @param {String} switchedVal , switched value
   * @param {String} checkedVal , verified value
   * @returns void
   */
  $scope.switchValTo = function(valToSwitch,switchedVal,checkedVal) {
    if(valToSwitch === checkedVal)
      return switchedVal;
    return valToSwitch;
  };
  
  /**
   * Get data via AJAX based on given url and parameter spesific to dynamic table
   * @param {String} pathUrl , full path url
   * @param {String} pathName , partial path to be used to naming the data table object
   * @param {Object} params , parameter in form of name and value pair
   * @param {Function} callback
   * @returns void
   */
  $scope.initDataTableGeneric = function(pathUrl,pathName,params,callback) {
    dataserv.getData(pathUrl+"/"+pathName,params,function(response) {
      var tableContents = response.data.tableContents;//dynamic table contents without column define
      var contents = [];//contents container
      
      //split row data into column
      $.each(tableContents,function(idx,val) {
        contents[idx] = val.val.split(delimiter);
      });
      
      //assign contents to view table
      var datatablegeneric = {headers: response.data.tableHeaders, contents: contents};
      $scope.datatablegeneric = datatablegeneric;
      callback(response);
    });
  };
  
  /**
   * Show given modal
   * @param {String} modalName
   * @returns void
   */
  $scope.showModal = function(modalName) {
    domserv.showModal(modalName);
  };
  
  /**
   * Upload specific file
   * @param {String} url
   * @param {Object} params , parameter in form of name and value pair
   * @param {Function} callback
   * @returns void
   */
  $scope.uploadFile = function(url,params,callback) {
    dataserv.uploadFile(url,params,callback);
  };
  
  /**
   * Post data to be saved to database via parameters
   * @param {String} url
   * @param {Object} params , parameter in form of name and value pair
   * @param {Function} callback
   * @returns void
   */
  $scope.postDataByParam = function(url,params,callback) {
    dataserv.postDataByParam(url,params,callback);
  };
  
  /**
   * Get data via AJAX based on given url and parameter with specific user defined function
   * @param {String} url
   * @param {Object} params , in form of pairs of name and value
   * @param {Function} callback
   * @returns void
   */
  $scope.getDataCommon = function(url,params,callback) {
    dataserv.getData(url,params,callback);
  };
  
  /**
   * Get data via AJAX based on given url and parameter without defining contents-type
   * @param {String} url
   * @param {Object} params , in form of pairs of name and value
   * @param {Function} callback
   * @returns void
   */
  $scope.getDataNonJson = function(url,params,callback) {
    dataserv.getDataNonJson(url,params,callback);
  };
  
  /**
   * Post data to be saved to database with user specified data to be posted
   * @param {String} url
   * @param {Object} data
   * @param {Function} callback
   * @returns void
   */
  $scope.saveDataNonAssign = function(url,data,callback) {
    dataserv.saveData(url,data,function(response) {
      callback(response);
      $scope.getData($scope.url,$scope.params);
    });
  };
  
  /**
   * When working with modal object we need recompiling angular object, so they could listen to the data change
   * @param {Object} obj , object to compile
   * @returns void
   */
  $scope.compileObject = function(obj) {
    $compile(obj)($scope);
  };
});

