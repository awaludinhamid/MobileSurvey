/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "absenceId";
objRelMap = [{name: "user", field: [{column: "userId", id: "userId"}]},
              {name: "reasonType", field: [{column: "reasonTypeId", id: "reasonTypeId"}]}];
dropdownArr = ["userbyparent","reasontype"];

$(document).ready(function() {
  //
  datePicker("input#startDateFind");
  datePicker("input#endDateFind");
  
  //  
  $("div.find-record").on("click", "div.img-container>img#img-find-record", function() {
    var currInput = [$("input#startDateFind"),$("input#endDateFind")];
    $.each(currInput,function(idx,val) {
      if(val) {
        var tooltipDate = $("div.tooltip-date");
        var currInputVal = val.val();
        if(!(currInputVal.match(asofdatePattern) || currInputVal === "")) {
          var currInputOff = val.offset();
          setTtDateStyle("transform","translate("+currInputOff.left+"px,"+(currInputOff.top - 20)+"px)");
          setTtDateStyle("animation-play-state","running");
          tooltipDate.on("animationend webkitAnimationEnd", function() {
            setTtDateStyle("animation-play-state","paused");
            tooltipDate.replaceWith(tooltipDate.clone(true));
          });
        }
      }
      function setTtDateStyle(styleProp,styleValue) {
        tooltipDate.css(styleProp,styleValue);
        tooltipDate.css("webkit-" + styleProp,styleValue);
      }      
    });
  });
});