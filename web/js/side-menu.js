/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
  
  //generate menu
  $.each(JSON.parse(localStorage.getItem("userMenuArr")),function(idx,val) {
    $("div#sidebar-wrapper ul.sidebar-nav").append(val.val);
  });
  
  // active-page  
  var path = window.location.pathname;
  var page = path.split("/").pop().replace("#","");
  var addPar = page.indexOf(";");
  if(addPar > -1) {
    page = page.substring(0,addPar);
  }
  var liObj = $(".sidebar-nav li:has(a)");
  liObj.removeClass("active-page");
  liObj.each(function() {
    if(page === $(this).children("a").attr("href").split("/").pop()) {
      $(this).addClass("active-page");
      var topPos = $(this).position().top;
      var parentHeight = $("div#sidebar-wrapper").height();
      if(topPos > (parentHeight/2)) {//move scrollbar to obj position if it over the limit (to prevent unseeing menu)
        $("div#sidebar-wrapper").scrollTop(topPos);        
      }
      return false;
    }
  });
});