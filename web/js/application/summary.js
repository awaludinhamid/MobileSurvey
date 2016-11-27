/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
  
  $(window).bind("load", function() {
    $("#wrapper>div>ul>li:nth-child(17)>a").addClass("active-page");
  });
  
  $.get("../../apps/data/summary",{},function(data,status) {
    if(status === "success") {
      var angObject = $("#summary-table>tbody");
      var scope = angObject.scope();
      scope.dataList = data;
      scope.$apply();
    } else {
      alert("Generate table content unsuccessfully: status = " + status);
    }
  });
  
  $("div>ul>li").click(function() {
    $(this).siblings("li").each(function() {
      if($(this).attr("class") !== "list-label")
        $(this).toggle();
    });
  });
});