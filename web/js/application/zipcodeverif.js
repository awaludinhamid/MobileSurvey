/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "zipcodeVerifId";
objRelMap = [{name: "verificator", field: [{column: "userId", id: "verificatorId"}]},
              {name: "zipcode", field: [{column: "zipcodeId", id: "zipcodeId"}]}];
dropdownArr = ["userverifbyparent","zipcode"];

$(document).ready(function() {
  //
  var scope = $(elementScope).scope();
  var currInputType = "";
  var currZipcode = "";
  var currSubZipcode = null;
  
  $("div.find-record").on("click","div.img-container>img#img-new-record",function() {    
    scope.$apply(function() {
      scope.zipcodeSearch = "";
    });
  });
  
  //
  $("table ").on("click","td>img#img-edit-record",function() {
    scope.$apply(function() {
      scope.zipcodeSearch = scope.dataarr.zipcode.zipcodeCode;
    });    
  });
  
  //
  $("button#upload-btn").click(function() {  
    //flush input file data
    $("div#upload-mdl input:file").val(null);
    $("div#upload-mdl input:text").each(function() {
      if($(this).prop("readonly"))
        $(this).val("");
    });    
  });
  
  //
  $("button#download-btn").click(function() {  
    //init verificator
    scope.$apply(function() {
      scope.verificatoriddl = scope.datadrop.userverifbyparent[0].userId;
    });
  });
  
  //
  $("button#upload-btn-exec").click(function() {
    var fileObj = $("div#upload-mdl input:file[name='"+scope.filetype+"']");
    var params = {};
    //supported one file only
    fileObj.each(function() {
      var file = this.files[0];
      params[$(this).attr("name")] = file;
      params["fileName"] = file.name;
      return false;
    });
    var fields = ["userCode","zipcodeCode","subZipcode","description"];
    params["fields"] = fields;
    params["headerFlag"] = scope.headerflag;
    params["textDelimiter"] = scope.textdelimiter;
    scope.uploadFile(
            relativePath + "apps/save/zipcodeverif/" + scope.filetype + "?" +
            $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text()
    ,params, function(response) {
      scope.getData(scope.url,scope.params);
      $("div#upload-mdl").modal("hide");
    });
  });
  
  //
  $("button#download-btn-exec").click(function() {
    var params = {
      fileType: scope.filetypedl,
      verificatorId: scope.verificatoriddl,
      textDelimiter: scope.textdelimiterdl
    }; 
    scope.postDataByParam(
            relativePath + "apps/data/zipcodeverif/download/request?" +
            $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text()
    ,params,function(reponse) {
      window.location.replace(relativePath + "apps/data/zipcodeverif/download");
      $("div#download-mdl").modal("hide");
    });
  });
  
  //
  $("div#upload-mdl input:file").change(function (){
    $(this).parents("div.input-group").children("input:text").val($(this).val());
  });
  
  //
  $("form#form-save select#zipcodeId").change(function() {
    setSubZipcodeVal();
  });
  
  //
  $("form#form-save input#inputSearch").keypress(function(event) {
    var keyCode = event.keyCode || event.which;
    currInputType = String.fromCharCode(keyCode);
  });
  
  //
  $("form#form-save input#inputSearch").keyup(function(event) {
    if (/[a-zA-Z0-9-_ ]/.test(currInputType) && $("form#form-save select#zipcodeId").val() !== null)
      setSubZipcodeVal();
  });
  
  //
  $("div.find-record").on("click","div.img-container>img#img-new-record",function() { 
    currZipcode = "";
  });
  
  //
  $("table ").on("click","td>img#img-edit-record",function() {
    currZipcode = $("form#form-save select#zipcodeId").val();
    currSubZipcode = $("form#form-save input#subZipcode").val();
  });
  
  //
  function setSubZipcodeVal() {
    var zipcodeId = $("form#form-save select#zipcodeId").val();
    var $subZipcode = $("form#form-save input#subZipcode");
    if(currZipcode === zipcodeId && currSubZipcode !== null)
      $subZipcode.val(currSubZipcode);
    else
      scope.getDataCommon(relativePath + "apps/data/maxsubzipcode",{zipcodeId:zipcodeId},function(response) {
        $subZipcode.val((Number(response.data.val) || 0) + 1);
      });
  }
  
});