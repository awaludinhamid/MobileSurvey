/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  
//
dataIdField = "coyId";
objRelMap = [{name: "detailCompanyLogo", field: ["companyLogoId"]}];
inputFindAttr = [{placeholder: "Company Code"},{placeholder: "Company Name"}];


$(document).ready(function() {
  
  $("table#tbl-data ").on("click","img.coy-logo",function() {
    var imgObj = $("div#mdl-coy-logo .modal-body div>img");
    imgObj.attr("src","");
    $.ajax({
      method: "GET",
      url: relativePath+"apps/data/detailcompanylogo/"+$(this).parent("td").parent("tr").data("logo-id"),
      data: {}
    }).done(function(response) {
      $("div#mdl-coy-logo .modal-body div>img").attr("src","data:image/jpg;base64," + response);
      $("div#mdl-coy-logo").modal("show");
    }).fail(function() {
      $("div#message-mdl .modal-body").html("Currently no company logo");
      $("div#message-mdl").modal("show");
    });
  });
  
  $("div.img-container, table ").on("click","img#img-new-record, td>img#img-edit-record",function() { 
    var coyLogoId = $(this).parent("td").parent("tr").data("logo-id");
    var imgElem = $("div#form-preview-logo>div.companylogoimg>img");
    imgElem.attr("src","");
    if(!(coyLogoId === null || coyLogoId === undefined)) {
      $.ajax({
        method: "GET",
        url: relativePath+"apps/data/detailcompanylogo/"+coyLogoId,
        data: {}
      }).done(function(response) {
        imgElem.attr("src","data:image/jpg;base64," + response);
      }).fail(function() {
      });
    } else {
      $("form#form-save input#companyLogoId").val("0");
    }
  });
  
  $("input#companyLogo:file").change(function (){
    var fileName = $(this).val();
    var imgElem = $("div#form-preview-logo>div.companylogoimg>img");
    imgElem.attr("src","");
    $("input#fileNameTmp").val(fileName);
    readImg(this,imgElem);
  });
  
  //
  $("button#btn-clear").click(function() {
    $("div#form-preview-logo>div.companylogoimg>img").attr("src","");
  });
  
  //
  $("button.zoomoutlogo").click(function() {
    var imgElem = $(this).parent("div").siblings("div").children("img");
    imgElem.css("width",0.9*imgElem.css("width").replace("px","")+"px");
  });
  $("button.zoominlogo").click(function() {
    var imgElem = $(this).parent("div").siblings("div").children("img");
    imgElem.css("width",imgElem.css("width").replace("px","")/0.9+"px");
  });
  
  function readImg(input,imgObj) {    
    if(input.files && input.files[0]) {
      var reader = new FileReader();
      reader.onload = function (e) {
        imgObj
          .attr("src", e.target.result);
      };
      reader.readAsDataURL(input.files[0]);
    }
  }

});