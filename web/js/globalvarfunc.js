/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* * * * * * G L O B A L   V A R I A B L E * * * * * */

//
var dayNamesMin = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
var dateFormat = "yy-mm-dd";
var datePicker = function(htmlElem) {
  return $(htmlElem).datepicker({
          dayNamesMin: dayNamesMin,
          dateFormat: dateFormat
        });
};

//
var relativePath = "../../";

/* * * * * * * * * * * */


/* * * * * * G L O B A L   F U N C T I O N * * * * * */

//
function initCap(pText) {
    return pText.toLowerCase().replace(/(?:^|\s)[a-z]/g, function (initChar) {
      return initChar.toUpperCase();
     });
}

