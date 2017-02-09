/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
 
  //
  $("div#user-menu, .title-info").hide();
  
  //
  if($("div>span#has-role").text() === "no" || $("div>span#is-valid").text() === "no") {
    $("div#validation-alert-mdl").modal("show");
  } else {
    // generate menu
    $.get(relativePath+"apps/data/usermenu/"+$("div>span#userid").text(), {}, function(data, status) {
      if(data.length === 0) {
        $("div#validation-alert-mdl").modal("show");
      } else {
        var prevparent = "";
        var urlredirect = "";
        var userMenuArr = [];
        $.each(data,function(idx,val) {
          if(val.parent === prevparent) {
            userMenuArr.push({
              "idx": idx,
              "val":"<li data-save-url='"+val.menuUrl.replace("/application/","/save/")+
                      "' data-data-url='"+val.menuUrl.replace("/application/","/data/")+"'>"+                   
                      "<a href='"+relativePath+val.menuUrl+"'>"+
                        "<img class='img-record img-record-medium' src='"+relativePath+"img/icon/"+val.iconPath+"' alt='"+val.menu+"'/>&nbsp;"+val.menu+
                      "</a></li>"});
          } else {
            var separator = "";
            if(idx === 0)
              urlredirect = val.menuUrl;
            else
              separator = "<li><hr/></li>";
            userMenuArr.push({
              "idx": idx,
              "val":separator +
                    "<li class='label-menu' id='"+val.parent.replace(" ","")+"'>"+val.parent+"</li>" +
                    "<li data-save-url='"+val.menuUrl.replace("/application/","/save/")+
                      "' data-data-url='"+val.menuUrl.replace("/application/","/data/")+"'>"+                    
                      "<a href='"+relativePath+val.menuUrl+"'>"+
                        "<img class='img-record img-record-medium' src='"+relativePath+"img/icon/"+val.iconPath+"' alt='"+val.menu+"'/>&nbsp;"+val.menu+
                      "</a></li>"});
            prevparent = val.parent;
          }      
        });
        //save menu
        localStorage.setItem("userMenuArr", JSON.stringify(userMenuArr));
        //redirect
        window.location.replace(relativePath+urlredirect);
      }
    });
  }
  //
  $("div#validation-alert-mdl").on("hidden.bs.modal",function() {
    $("#form-logout>form").submit();
  });
  
});
