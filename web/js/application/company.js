/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to company page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "coyId";
disableObjArr = [{fieldName: "Coy Code", fieldValue: "coyCode"},
                  {fieldName: "Coy Name", fieldValue: "coyName"}];
objRelMap = [{name: "detailCompanyLogo", field: [{column: "companyLogoId", id: "companyLogoId"}]}];
uploadFileObj = {name: "company", field: "companyLogoId"};


$("div#company").ready(function() {
  
  var currDiv = "div#company";//element name of the page
  
  /**
   * event: click image logo button
   * action: show the image
   */
  $(currDiv + " table#tbl-data ").on("click","img.coy-logo",function() {
    
    var imgObj = $("div#mdl-coy-logo .modal-body div>img");//image container
    
    //flush current image and get the new one via AJAX
    imgObj.attr("src","");
    $.ajax({
      method: "GET",
      url: relativePath+"apps/data/detailcompanylogo/"+$(this).parent("td").parent("tr").data("logo-id"),
      data: {}
    }).done(function(response) {
      $("div#mdl-coy-logo .modal-body div>img").attr("src","data:image/jpg;base64," + response);
      $("div#mdl-coy-logo").modal("show");
    }).fail(function() {
      showMessage("Currently no company logo");
    });
  });
  
  /**
   * event: click edit button
   * action: gather selected company logo and assign it into container
   */
  $(currDiv + " div.img-container, " + currDiv + " table ").on("click","img#img-new-record, td>img#img-edit-record",function() { 
    
    var coyLogoId = $(this).parent("td").parent("tr").data("logo-id");//current company id
    var imgElem = $("div#form-preview-logo>div.companylogoimg>img");//image container
    
    //flush current image and get the new one via AJAX
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
  
  /**
   * event: change file of logo image
   * action: read a new image file and put it in the container
   */
  $(currDiv + " input#companyLogo:file").change(function (){
    var fileName = $(this).val();
    var imgElem = $("div#form-preview-logo>div.companylogoimg>img");
    imgElem.attr("src","");
    $("input#fileNameTmp").val(fileName);
    readImg(this,imgElem);
  });
  
  /**
   * event: click clear button in the form preview logo
   * action: clear the image inside container
   */
  $(currDiv + " button#btn-clear").click(function() {
    $("div#form-preview-logo>div.companylogoimg>img").attr("src","");
  });
  
  /**
   * event: click zoomout button in the form preview logo
   * action: zoomout the image
   */
  $(currDiv + " button.zoomoutlogo").click(function() {
    var imgElem = $(this).parent("div").siblings("div").children("img");
    imgElem.css("width",0.9*imgElem.css("width").replace("px","")+"px");
  });
  
  /**
   * event: click zoomin button in the form preview logo
   * action: zoomin the image
   */
  $(currDiv + " button.zoominlogo").click(function() {
    var imgElem = $(this).parent("div").siblings("div").children("img");
    imgElem.css("width",imgElem.css("width").replace("px","")/0.9+"px");
  });
  
  /**
   * Read the image file and put it into container
   * @param {Object} input , input image file
   * @param {Object} imgObj , element where image is placed
   * @returns void
   */
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