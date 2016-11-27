/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
  
  //
  var arrTopMenu = [//{name:"home",icon:"home"},
                    {name:"application",icon:"tag",page:window.localStorage["currAppPage"]},
                    {name:"about",icon:"book",page:"../../apps/main/about"},
                    {name:"help",icon:"question-sign",page:"../../apps/main/help"},
                    {name:"contact us",icon:"phone-alt",page:"../../apps/main/contactus"}];
  var currTopMenu = getCurrTopMenu();
  //
  var navbarTopCollapse = $("#navbar-top-collapse>ul");
  navbarTopCollapse.remove("li");
  for(var idx in arrTopMenu) {
    if(arrTopMenu[idx].name !== currTopMenu.name) {
      navbarTopCollapse.append(
        "<li>"+
          "<a href='"+arrTopMenu[idx].page+"'>"+
            "<span class='glyphicon glyphicon-"+arrTopMenu[idx].icon+"'></span>&nbsp;"+initCap(arrTopMenu[idx].name)+
          "</a>"+
        "</li>"
      );
    }
  }
  //
  var navbarHeader = $("div.navbar-header");
  navbarHeader.remove("#curr-page-name");
  navbarHeader.append(
    "<div id='curr-page-name' class='navbar-brand' style='color: white'>"+
      "<span class='glyphicon glyphicon-"+currTopMenu.icon+"'></span>&nbsp;"+initCap(currTopMenu.name)+
    "</div>"
  );
  //
  function getCurrTopMenu() {
    var path = window.location.pathname;
    var appPage = "application"; //app page has detail/child page
    var page = path.split("/").pop().replace("#","");
    if(path.indexOf(appPage) > -1) {
      window.localStorage["currAppPage"] = relativePath+"apps/application/"+page;
      page = appPage;
    }
    for(var idx in arrTopMenu) {
      if(arrTopMenu[idx].name.replace(" ","") === page)
        return arrTopMenu[idx];
    }
    return null;
  }
});
