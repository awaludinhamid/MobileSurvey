/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to location tracking page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "taskId";
dropdownArr = ["office"];
showFindImgOnly = true;      
masterFindOnlyArr = [{fieldToCheck: ["select#verificatorId","select#isGps"], message: "Must be picked up verificator and GPS/LBS to proceed ..!"}];
hasExtraClass = true;

$("div#loctrack").ready(function() {
  
  var currDiv = "div#loctrack";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  
  //supported variable specific to google map
  var map;//the map
  var markers = [];//object in the map in the various shape (icon, character, etc)
  var trippedPath;//object in the map in the form line path
  var infoWindowTmp;//popup object contains several info such as lat and lang position
  
  if($(currDiv).length) {
    
    //load google API if only unloaded
    if(typeof google === "object" && typeof google.maps === "object")
      initPageLoc();
    else
      /**
       * Get google API
       */
      $.getScript("http://maps.googleapis.com/maps/api/js?key=AIzaSyAv3z1L3q9NZim5mwhvUqejnueYlgVSGt0", function() {
        initPageLoc();
      });
  }
  
  /**
   * event: change/choose office list value
   * action: assign verificator value to default
   *         reload verificator list
   */
  $(currDiv + " div.find-record select#officeId").change(function() {
    if(scope.officeId === "0") {
      scope.datadrop.verifbyofficerole = [];
      scope.verificatorId = "0";
      scope.$apply();
    } else {
      scope.officeId = $(this).val();
      changeListVerifLoc(function() {
        scope.verificatorId = "0";
      });
    }
  });
  
  /**
   * process when initialize page
   * @returns {undefined}
   */
  function initPageLoc() {
      
      //currently online
      if (typeof google === "object" && typeof google.maps === "object") {

        //load map
        initializeMapLoc();

        //additional process when loading the page
        cbFuncGenData = function() {
          //tracking route line
          var datatable = scope.datatable;
          var datatablelen = datatable.length;
          var tripped = [];
          
          //flush map contents
          clearMapObject();
          
          //proceed if data available
          if(datatablelen > 0) {
            
            //resize map to fit container
            if(!$("div#googleMap").is(":visible")) {
              $("div#googleMap").show();
              google.maps.event.trigger(map, "resize");
            }
            
            //iterate position node
            $.each(datatable,function(idx,val) {
              
              var marker;//where point tracking is assigned
              var latlng = new google.maps.LatLng(val.latitude,val.longitude);//switch plain value to object
              
              //assign icon
              var icon = {
                url: "../../img/icon/flag-icon.png", // url
                scaledSize: new google.maps.Size(20, 20), // scaled size
                origin: new google.maps.Point(0,0), // origin, slice icon
                anchor: new google.maps.Point(0,20) // anchor, move icon from position
              };
              
              //put icon to the map
              marker = new google.maps.Marker({
                position: latlng,
                icon: icon,
                map: map
              });
              markers.push(marker);      
              
              //assign start and end marker
              if(idx === 0) {
                marker = new google.maps.Marker({
                  position: latlng,
                  label: "A",
                  map: map
                });
                markers.push(marker);
                map.setCenter(latlng);
              }
              if(idx === (datatablelen - 1))
                marker = new google.maps.Marker({
                  position: latlng,
                  label: "Z",
                  map: map
                });
                markers.push(marker);
              
              //put position to path
              tripped.push(latlng);

              //show tooltip on marker
              google.maps.event.addListener(marker,"click",function(event) {
                //alert("ok");
                //alert(JSON.stringify(val)); 
                showLocInfo(marker,val);
              });
            });
            
            //create path
            trippedPath = new google.maps.Polyline({
              path: tripped,
              strokeColor: "#ff0000",
              strokeOpacity: 0.8,
              strokeWeight: 3,
              map: map
            });
          
          //otherwise, hide the map
          } else {
            if($("div#googleMap").is(":visible"))
              $("div#googleMap").hide();      
          } 
          
          /**
           * Flushing map content
           * @returns void
           */
          function clearMapObject() {
            if(trippedPath)
              trippedPath.setMap(null);
            $.each(markers,function(idx,val) {
              val.setMap(null);
            });
            markers = [];
          }
    
          /**
           * Show the given info
           * @param {Object} marker , current marker
           * @param {Object} info , info to show
           * @returns {void}
           */
          function showLocInfo(marker,info) {
            infoWindowTmp = new google.maps.InfoWindow({
              content: "Latitude: " + info.latitude + "<br>Longitude: " + info.longitude + "<br>Submit Time: " + info.submitDate
            });
            infoWindowTmp.open(map,marker);
          }
        };  
        
      } else {
        showInfoMessage("You're currently offline and may not show the map ..!");
      } 
      
      //if logged user is coordinator then switch several element view and reload verificator list
      if($("span#roletype-code").text() === "C") {
        $(currDiv + " div.find-record select#officeId").hide();
        $(currDiv + " div.find-record input#officeLbl").show();
        changeListVerifLoc(function() {});
      }    
  }   
  
  /**
   * Reload verificator list
   * @param {Function} callback
   * @returns void
   */
  function changeListVerifLoc(callback) {
    scope.initDropdownCommon(relativePath+"apps/data","verifbyofficerole",{officeId: scope.officeId}, function(response) {
      callback(response);
    });
  }
  
  /**
   * Map intilized process 
   * @returns void
   */
  function initializeMapLoc() {
    
    var centered = new google.maps.LatLng(-6.2146200,106.8451300); //center default to Jakarta position

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
  }
  
});