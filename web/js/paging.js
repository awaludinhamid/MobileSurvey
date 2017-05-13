/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to paging function
 */


// GLOBAL VARIABLE

/**
 * Current page being accessed and maximum page number to be shown
 * @type Number
 */
var currPageNo = 1,
    currMaxPage;


// GLOBAL FUNCTION

/**
 * Execute various action when clicked the page number
 * @param {String} listPaging , list name where the page number put
 * @param {String} thisId , id of the clicked page number
 * @param {Object} params , parameter in form of name and value pair
 * @param {Function} callback
 * @returns void
 */
function clickPageNo(listPaging,thisId,params,callback) {
  
  //avoid execution on current page, disable page
  //page no must be less or equal then maximum page allowed
  if(!$(listPaging+"#"+thisId).hasClass("active") && !$(listPaging+"#"+thisId).hasClass("disabled")/* && currPageNo <= currMaxPage*/) {
    if(thisId === "firstPage")
      currPageNo = 1;
    else if(thisId === "nextPage")
      currPageNo += 1;
    else if(thisId === "prevPage")
      currPageNo -= 1;
    else if(thisId === "lastPage")
      currPageNo = currMaxPage;
    else
      currPageNo = parseInt(thisId.replace("page",""));
    
    //finally, executed the process
    callback(params);
  }  
}

/**
 * Creation of paging
 * @param {Number} dataLength , total data to be devided into several pages
 * @returns void
 */
function execPaging(dataLength) {
  
  //execute some process, see the info in each process
  setPagination();
  switchPageStatus();
  
  /**
   * Set pagination based on data length
   * @returns {Boolean}
   */
  function setPagination() {
    
    var pagePerLoad = 10;//default maximum page to be shown
    var pagingRecords = parseInt($("span#paging-records").text());//maximum number of records per page
    
    //recreated paging list
    $("div#pagination>ul>li").remove();
    if(dataLength === 0) return false;
    $("div#pagination>ul").append(
      "<li id='firstPage' title='First'><a href='#' aria-label='First'><span aria-hidden='true'>&laquo;</span></a></li>"+
      "<li id='prevPage' title='Previous'><a href='#' aria-label='Previous'><span aria-hidden='true'>&lt;</span></a></li>"
    );
    
   //set max page, start and end page no, and active page, and reinit current page no if necessary
    currMaxPage = Math.floor(dataLength/pagingRecords) + (dataLength%pagingRecords === 0 ? 0 : 1);
    var startPageNo = Math.floor(currPageNo/pagePerLoad) * pagePerLoad + (currPageNo%pagePerLoad === 0 ? 0 : 1); //start page no of serial page on page selected
    var endPageNo = currMaxPage < (startPageNo + pagePerLoad) ? currMaxPage : (startPageNo + pagePerLoad - 1); //end page no of serial page on page selected
    if(currPageNo > endPageNo) endPageNo = currPageNo;
    
    //iterate over page number to create the element and append a new drection element
    for(var idx = startPageNo; idx <= endPageNo; idx++) {
      $("div#pagination>ul").append(
        "<li id='page"+idx+"'"+(idx === currPageNo ? " class='active' " : "")+"><a href='#'>"+idx+"</a></li>"
      );
    }
    $("div#pagination>ul").append(
      "<li id='nextPage' title='Next'><a href='#' aria-label='Next'><span aria-hidden='true'>&gt;</span></a></li>"+
      "<li id='lastPage' title='Last'><a href='#' aria-label='Last'><span aria-hidden='true'>&raquo;</span></a></li>"
    );
  }

  /**
   * Switch page status by enable/disable page number element on the specific condition
   * @returns void
   */
  function switchPageStatus() {
    if(currPageNo === 1)
      $("div#pagination>ul>li#firstPage").addClass("disabled");
    else
      $("div#pagination>ul>li#firstPage").removeClass("disabled");
    if(currPageNo > 1)
      $("div#pagination>ul>li#prevPage").removeClass("disabled");
    else
      $("div#pagination>ul>li#prevPage").addClass("disabled");
    if(currPageNo < currMaxPage)
      $("div#pagination>ul>li#nextPage").removeClass("disabled");
    else
      $("div#pagination>ul>li#nextPage").addClass("disabled");
    if(currPageNo === currMaxPage)
      $("div#pagination>ul>li#lastPage").addClass("disabled");
    else
      $("div#pagination>ul>li#lastPage").removeClass("disabled");
  }
}