/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to dashboard monitoring page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "taskId";
dropdownArr = ["office"];
showFindImgOnly = true;      
masterFindOnlyArr = [{fieldToCheck: ["select#coordinatorId"], message: "Must be picked up coordinator at least to proceed ..!"}];
hasExtraClass = true;
//extraScriptArr = ["http://maps.googleapis.com/maps/api/js?key=AIzaSyAv3z1L3q9NZim5mwhvUqejnueYlgVSGt0"];

$("div#dashmon").ready(function() {
  
  var currDiv = "div#dashmon";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  
  //supported variable specific to google map
  var map;//the map
  var circled;//object in the map in the shape of circle
  var marker;//object in the map in the shape of period
  var infoWindowTmp;//popup object contains several info such as lat and lang position
  
  if($(currDiv).length) {
    
    //load google API if only unloaded
    if(typeof google === "object" && typeof google.maps === "object")
      initPage();
    else
      /**
       * Get google API
       */
      $.getScript("http://maps.googleapis.com/maps/api/js?key=AIzaSyAv3z1L3q9NZim5mwhvUqejnueYlgVSGt0", function() {
        initPage();
      });
  }
  
  /**
   * event: change/choose the office list value
   * action: reload coordinator list and assign a default one
   */
  $(currDiv + " div.find-record select#officeId").change(function() {
    if(scope.officeId === "0") {
      scope.datadrop.coordbyofficerole = [];
      scope.coordinatorId = "0";
      scope.$apply();
    } else {
      scope.officeId = $(this).val();
      changeListCoord(function() {
        scope.coordinatorId = "0";
      });
    }
  });
  
  /**
   * event: click specific user name in the list
   * action: reposition map pointing to selected user position
   */
  $(currDiv + " div#div-map>div#verif-list").on("click","div>span:first-child",function() {
    if(!$("div#googleMap").is(":visible")) {
      $("div#googleMap").show();
      google.maps.event.trigger(map, "resize");
    }
    $(this).parent("div").siblings("div").css("background-color","");
    $(this).parent("div").css("background-color","#cfcfef");
    changeMapAndObjectPosition(map,scope.dataarr.gpsLatitude,scope.dataarr.gpsLongitude);
  });
  
  /**
   * process when initialize page
   * @returns {undefined}
   */
  function initPage() {      
    //currently online
    if (typeof google === "object" && typeof google.maps === "object") {

      //load map
      initializeMap();

      //additional process when loading the page
      cbFuncGenData = function() {
        //just hide the map
        if($("div#googleMap").is(":visible")) 
          $("div#googleMap").hide();
      };
    } else {    
      showInfoMessage("You're currently offline and may not show the map ..!");
    }

    //get initial data via AJAX and set object view in their default
    scope.getDataCommon(relativePath + "apps/data/iscoordinator",{},function(response) {
      if(response.data.val === "true") {
        $("div.find-record select#officeId").hide();
        $("div.find-record input#officeLbl").show();
        $("div.find-record select#coordinatorId").hide();
        $("div.find-record input#coordinatorLbl").show();
        scope.coordinatorId = $("span#userid").text();
      } 
    });    
  }
  
  /**
   * change the map and its object position
   * @param {Object} map , google map
   * @param {Decimal} lat , latitude position
   * @param {Decimal} lng , longitude position
   * @returns void
   */
  function changeMapAndObjectPosition(map,lat,lng) {
    //
    var latlng = new google.maps.LatLng(lat,lng);
    
    //close current opened info
    if(infoWindowTmp)
      infoWindowTmp.close();
    
    //move the object
    marker.setPosition(latlng);
    circled.setCenter(latlng);
    map.setCenter(latlng);
  }
  
  /**
   * Reload coordinator list
   * @param {Function} callback
   * @returns void
   */
  function changeListCoord(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","coordbyofficerole",{officeId: scope.officeId}, function(response) {
      callback(response);
    });
  }
  
  /**
   * Map intilized process
   * @returns void
   */
  function initializeMap() {
    
    //center default to Jakarta position
    var centered = new google.maps.LatLng(-6.2146200,106.8451300); 
    
    //map property setup (please read google documentation carefully)
    var mapProp = {
      center: centered,
      zoom: 11,
      streetViewControl: false,
      mapTypeId: "roadmap" //(choices: sattelite, hybrid, terrain) or through object i.e: google.maps.MapTypeId.HYBRID
    };
    
    //load map with given property
    //remember to create the container (DOM) first
    map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
    
    //coverage area
    if(!circled)
      circled = new google.maps.Circle({
        //center: centered,
        radius: 5000,
        strokeColor: "#0000FF",
        strokeOpacity: 0.25,
        fillColor: "#0000FF",
        fillOpacity: 0.2,
        map: map //or via object: circled.setMap(map);
      });
    
    //coordinat marker (baloon ?)
    if(!marker)
      marker = new google.maps.Marker({
        map: map //or via object: marker.setMap(map);
      });   

    //show tooltip on marker
    google.maps.event.addListener(marker,"click",function(event) {
      placeMarker(event.latLng);
    });
    
    /**
     * Mark the given location
     * @param {Object} location , pair of lat and lang
     * @returns void
     */
    function placeMarker(location) {
      infoWindowTmp = new google.maps.InfoWindow({
        content: "Latitude: " + location.lat() + "<br>Longitude: " + location.lng()
      });
      infoWindowTmp.open(map,marker);
    }
  }
  
});