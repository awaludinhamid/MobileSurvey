/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to zipcode verificator page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "zipcodeVerifId";
disableObjArr = [{fieldName: "Zipcode", fieldValue: "zipcode.zipcodeCode"},
                  {fieldName: "Verificator", fieldValue: "verificator.userName"}];
objRelMap = [{name: "verificator", field: [{column: "userId", id: "verificatorId"}]},
              {name: "zipcode", field: [{column: "zipcodeId", id: "zipcodeId"}]}];
dropdownArr = ["userverifbyparent","provinsi"];
hasExtraClass = true;
errorCaptureArr = [{errTxt: "java.io.IOException", errMsg: "Failed to read your file, please verify the contents ..!"},
                    {errTxt: "File contained invalid user", errMsg: "File contained invalid user ..!"},
                    {errTxt: "File contained invalid zipcode", errMsg: "File contained invalid zipcode ..!"},
                    {errTxt: "master_zipcode_verificator_unq001", errMsg: "User - zipcode combination recorded already ..!"}
                  ];

$("div#zipcodeverif").ready(function() {
  
  var currDiv = "div#zipcodeverif";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  var currInputType = "";//current element input type
  
  if($(currDiv).length) {
    
    //compile upload, download and download template modal
    scope.compileObject($("div#upload-mdl"));
    scope.compileObject($("div#download-mdl"));
    scope.compileObject($("div#download-temp-mdl"));
  }
  
  /**
   * event: click new button
   * action: switch several elements view
   *         assign provinsi, city and subzipcode value to default
   *         reload city and zipcode list
   */
  $(currDiv + " div.find-record").on("click","div.img-container>img#img-new-record",function() { 
    $("select#provId").parents("div.form-group").show();
    $("select#cityId").parents("div.form-group").show();
    $("select#zipcodeId").parent("div").show();
    $("label#zipcodeCode").parent("div").hide();
    scope.prov = scope.datadrop.provinsi[0];
    changeListCityZipver(scope.prov.provId,function() {
      scope.city = scope.datadrop.citybyprov[0];
      changeListZipcodeZipver(scope.city.cityId,function() {
        setSubZipcodeVal(scope.datadrop.zipcodebycity[0].zipcodeId);
      });
    });
  });
  
  /**
   * event: click edit button
   * action: switch several elements view
   *         assign zipcode to current zipcode
   */
  $(currDiv + " table ").on("click","td>img#img-edit-record",function() {
    //
    $("select#provId").parents("div.form-group").hide();
    $("select#cityId").parents("div.form-group").hide();
    $("select#zipcodeId").parent("div").hide();
    $("label#zipcodeCode").parents("div").show();
    //
    $("form#form-save label#zipcodeCode").text(scope.dataarr.zipcode.zipcodeCode);
    $("form#form-save input#subZipcode").val(scope.dataarr.subZipcode);
    $("form#form-save input#subZipcode").prop("defaultValue",scope.dataarr.subZipcode);
    scope.datadrop.zipcodebycity = [scope.dataarr.zipcode];
    scope.$apply();
    $("select#zipcodeId").val(scope.dataarr.zipcode.zipcodeId);
  });
  
  /**
   * event: change/choose provinsi list value
   * action: reload city and zipcode list
   *         assign city and sub zipcode value to deafult
   */
  $(currDiv + " form#form-save select#provId").change(function() {
    changeListCityZipver($(this).val(),function() {
      scope.city = scope.datadrop.citybyprov[0];
      changeListZipcodeZipver(scope.city.cityId,function() {
        setSubZipcodeVal(scope.datadrop.zipcodebycity[0].zipcodeId);
      });
    });
  });
  
  /**
   * event: change/choose city list value
   * action: reload zipcode list
   *         assign sub zipcode value to deafult
   */
  $(currDiv + " form#form-save select#cityId").change(function() {
    changeListZipcodeZipver($(this).val(),function() {
      setSubZipcodeVal(scope.datadrop.zipcodebycity[0].zipcodeId);
    });
  });
  
  /**
   * event: change/choose zipcode list value
   * action: assign sub zipcode value to deafult
   */
  $(currDiv + " form#form-save select#zipcodeId").change(function() {
    setSubZipcodeVal($(this).val());
  });
  
  /**
   * event: click upload button
   * action: flush input file data
   */
  $(currDiv + " button#upload-btn").click(function() {  
    $("div#upload-mdl input:file").val(null);
    $("div#upload-mdl input:text").each(function() {
      if($(this).prop("readonly"))
        $(this).val("");
    });    
  });
  
  /**
   * event: click 'ok' button on upload modal
   * action: upload selected file to be saved to database
   */
  $(currDiv + " button#upload-btn-exec").click(function() {
    
    var fileObj = $("div#upload-mdl input:file[name='"+scope.filetype+"']");//file input element
    var params = {};//parameter in form of name and value pair
    var isExists = true;//verified valid file is ready to upload
    
    //supported one file only
    fileObj.each(function() {
      var file = this.files[0];
      if(file) {
        var fileTypes = [];
        if(scope.filetype === "textfile")
          fileTypes = ["txt"];
        else if(scope.filetype === "excelfile")
          fileTypes = ["xls","xlsx"];
        if($.inArray(file.name.split(".").pop(), fileTypes) > -1) {
          params[$(this).attr("name")] = file;
          params["fileName"] = file.name;
        } else {
          showErrorMessage("Wrong file type ..! --> (File ext must be: " + fileTypes.toString() + ")");
          isExists = false;
        }
      } else {
        showErrorMessage("No file to upload ..!");
        isExists = false;
      }
      return false;
    });
    
    //we're ready to upload the file via AJAX call
    if(isExists) {
      
      //prepare parameter
      var fields = ["userCode","zipcodeCode","subZipcode","description"];
      params["fields"] = fields;
      params["headerFlag"] = scope.headerflag;
      params["textDelimiter"] = scope.textdelimiter;
      
      //now upload the file
      scope.uploadFile(
              relativePath + "apps/save/zipcodeverif/" + scope.filetype + "?" +
              $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text()
      ,params, function(response) {
        scope.getData(scope.url,scope.params);
        $("div#upload-mdl").modal("hide");
      });
    }
  });
  
  /**
   * event: click 'ok' button on download modal
   * action: download the file based on given parameters
   */
  $(currDiv + " button#download-btn-exec").click(function() {
    
    //parameter object
    var params = {
      fileType: scope.filetypedl,//file type
      textDelimiter: scope.textdelimiterdl//delimiter if required
    }; 
    
    //post parameter and download the file
    scope.postDataByParam(
            relativePath + "apps/data/zipcodeverif/download/request?" +
            $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text()
    ,params,function(reponse) {
      window.location.replace(relativePath + "apps/data/zipcodeverif/download");
      $("div#download-mdl").modal("hide");
    });
  });
  
  /**
   * event: click 'ok' button on download template modal
   * action: download the template file based on given parameters
   */
  $(currDiv + " button#download-temp-btn-exec").click(function() {
    
    //parameter object
    var params = {
      fileType: scope.filetypedltemp,//file type
      textDelimiter: scope.textdelimiterdltemp//delimiter if required
    }; 
    
    //post parameter and download the template file
    scope.postDataByParam(
            relativePath + "apps/data/zipcodeverif/download/requesttemp?" +
            $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text()
    ,params,function(reponse) {
      window.location.replace(relativePath + "apps/data/zipcodeverif/download");
      $("div#download-temp-mdl").modal("hide");
    });
  });
  
  /**
   * event: change the upload input file
   * action: change the name in the input text
   */
  $(currDiv + " div#upload-mdl input:file").change(function (){
    $(this).parents("div.input-group").children("input:text").val($(this).val());
  });
  
  /**
   * event: press the key on search input
   * action: assign input character into storage
   * @param {Object} event
   */
  $(currDiv + " form#form-save input#inputSearch").keypress(function(event) {
    var keyCode = event.keyCode || event.which;
    currInputType = String.fromCharCode(keyCode);
  });
  
  /**
   * event: release the key on search input
   * action: if input character is valid character and zipcode is selected then assign sub zipcode value
   * @param {Object} event
   */
  $(currDiv + " form#form-save input#inputSearch").keyup(function(event) {
    if (/[a-zA-Z0-9-_ ]/.test(currInputType) && $("form#form-save select#zipcodeId").val() !== null)
      setSubZipcodeVal();
  });
  
  /**
   * Assign sub zipcode value by request to server
   * @param {Number} zipcodeId
   * @returns {void}
   */
  function setSubZipcodeVal(zipcodeId) {
    scope.getDataCommon(relativePath + "apps/data/maxsubzipcode",{zipcodeId:zipcodeId},function(response) {
      $("form#form-save input#subZipcode").val((Number(response.data) || 0) + 1);
      $("form#form-save input#subZipcode").prop("defaultValue",(Number(response.data) || 0) + 1);
    });
  }
  
  /**
   * Reload city list by provinsi
   * @param {Number} provId , provinsi id
   * @param {Function} callback
   * @returns {void}
   */
  function changeListCityZipver(provId,callback) {
    scope.initDropdownCommon(relativePath+"apps/data","citybyprov",{provId: provId}, function(response) {
      callback(response);
    });
  }
  
  /**
   * Reload zipcode list by city
   * @param {Number} cityId
   * @param {Function} callback
   * @returns {void}
   */
  function changeListZipcodeZipver(cityId,callback) {
    scope.initDropdownCommon(relativePath+"apps/data","zipcodebycity",{cityId: cityId}, function(response) {
      callback(response);
    });
  }
  
});