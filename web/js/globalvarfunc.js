/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script contains global variable and global function
 */

/* * * * * * G L O B A L   V A R I A B L E * * * * * */

/**
 * Defined day short name
 * Change them for other purpose
 * @type Array
 */
var dayNamesMin = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];

/**
 * Default date format when converting to text
 * @type String
 */
var dateFormat = "yy-mm-dd";

/**
 * Assign the datepicker (calendar form) to be used later
 * @param {Object} htmlElem , HTML element where to put the datepicker
 * @returns the datepicker object
 */
var datePicker = function(htmlElem) {
  return $(htmlElem).datepicker({
          dayNamesMin: dayNamesMin,
          dateFormat: dateFormat
        });
};

/**
 * Default relative prefix path of the page
 * @type String
 */
var relativePath = "../../";

/* * * * * * * * * * * */


/* * * * * * G L O B A L   F U N C T I O N * * * * * */

/**
 * camel word convertion
 * @param {String} pText , text to be converted to camel case
 * @returns converted text
 */
function initCap(pText) {
    return pText.toLowerCase().replace(/(?:^|\s)[a-z]/g, function (initChar) {
      return initChar.toUpperCase();
     });
}