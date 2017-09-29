/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to header page
 */

/**
 * Spring 4 required CSRF token, so we need to store them in specific variable to be used later
 * @type type
 */
var csrfParamName;
var csrfToken;


/**
 * show your message here
 * @param {String} message
 * @returns void
 */
function showMessage(message) {
  $("div#message-mdl .modal-body").html(message);
  $("div#message-mdl").modal("show");
}


$(document).ready(function() {
    
  //header coloring
  if($("span#user-from-owner").text() === "N") {
    $(".title").css("background","linear-gradient(#cc2 50%,#fff 85%)");
    //$(".topbar-add-style").css("background","linear-gradient(#cc2,#cc2)");
  } else {
    $(".title").css("background","linear-gradient(#026 50%,#fff 85%)");
    //$(".topbar-add-style").css("background","linear-gradient(#026,#026)");
  }

  //controlling user visibility
  if($("span#username").text().length > 0) {
    $("div#user-menu, .title-info").show();
    // show logo
    if(localStorage.getItem("logoPicture") === "") {
      $.get(relativePath+"apps/data/detailcompanylogo/"+$("span#company-logo-id").text(), {}, function(dataLogo, statusLogo) {
        $(".img-logo").attr("src","data:image/jpg;base64," + dataLogo);
        localStorage.setItem("logoPicture",dataLogo);
      }).fail(function() {
        showMessage("Currently no company logo");
      });
    } else {
      $(".img-logo").attr("src","data:image/jpg;base64," + localStorage.getItem("logoPicture"));
    }    
    // records per page
    var recordsPerPage = localStorage.getItem("recordsPerPage");
    if(!recordsPerPage)
      localStorage.setItem("recordsPerPage",$("span#paging-records").text());
  } else {
    $("div#user-menu, .title-info").hide();
    if(window.location.pathname.indexOf("/login") === -1) {
      $("div#form-logout>form").submit();
    }
  }
    
  /**
   * event: click logout button
   * action: logout current session
   * @param {Object} evt , event
   */
  $("#btn-logout").click(function(evt) {
    evt.preventDefault();
    $.get(relativePath+"apps/auth/currentsession", {}, function(data) {
      if(data === $("span#sessionid").text())        
        $("div#form-logout>form").submit();
      else
        window.location.replace(relativePath+"apps/auth/login");
    });
  });
  
  /**
   * event: click button change password
   * action: show the modal where the password will be changed
   */
  $("#change-pass").click(function() {
    var changePassMdl = $("div#change-pass-mdl");
    changePassMdl.find("input#new-password, input#con-new-password").val("");
    changePassMdl.find("input#old-password").val(localStorage.getItem("userPassword"));
    changePassMdl.modal("show");
  });
  
  /**
   * event: click 'ok' button or enter submit on change password modal
   * action: submit the change
   */
  $("form#form-change-pass").on("submit",function() {
    if($(this).find("input#old-password").val() === $(this).find("input#new-password").val()) {
      alert("Password have not been changed");
      return false;
    }
    if($(this).find("input#new-password").val() !== $(this).find("input#con-new-password").val()) {
      alert("New password mismatch");
      return false;
    }
    localStorage.setItem("userPassword",$(this).find("input#new-password").val());
  });
  
  /**
   * event: click 'ok' button or enter submit on the form login
   * action: store current password to be used later
   */
  $("form#form-login").on("submit", function() {
    localStorage.setItem("userPassword",$(this).find("input#password").val());
  });
});
