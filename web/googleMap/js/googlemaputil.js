/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//we need to access the object outside the script
var map;

$(document).ready(function() {
  //
  //var scope = $(elementScope).scope();
  //

  //map preparation
  function initialize() {
    
    //centering map position
    /*var centered = new google.maps.LatLng(0,120);//indonesian center geo position*/
    var centered = new google.maps.LatLng(-6.2146200,106.8451300); //center of Jakarta

    //map property setup (please read google documentation carefully)
    //controllling each property by uncommented them
    var mapProp = {
      center: centered,
      zoom: 11,
      //disableDefaultUI: true,
      //panControl: true,
      //zoomControl: true,
      /*zoomControlOptions: {
        style: google.maps.ZoomControlStyle.LARGE
      },*/
      //mapTypeControl: true,
      /*mapTypeControlOptions: {
        style: google.maps.MapTypeControlStyle.DROPDOWN_MENU,
        position: google.maps.ControlPosition.TOP_CENTER
      },*/
      //scaleControl: true,
      streetViewControl: false,
      //overviewMapControl: true,
      //rotateControl: true,
      mapTypeId: "roadmap" //(choices: sattelite, hybrid, terrain) or through object i.e: google.maps.MapTypeId.HYBRID
    };

    //load map with given property
    //remember to create the container (DOM) first
    map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

    //tracking route line
    /*var jakarta = new google.maps.LatLng(-6.2146200,106.8451300);
    var bandung = new google.maps.LatLng(-6.9038900,107.6186100);
    var bogor = new google.maps.LatLng(-6.5944400,106.7891700);
    var tripped = [jakarta,bandung,bogor];
    var trippedPath = new google.maps.Polyline({
      path: tripped,
      strokeColor: "#0000FF",
      strokeOpacity: 0.8,
      strokeWeight: 2
    });
    trippedPath.setMap(map);*/

    //tracking route area
    /*var semarang = new google.maps.LatLng(-6.9932000,110.4203000);
    var yogyakarta = new google.maps.LatLng(-7.7827800,110.3608300);
    var surabaya = new google.maps.LatLng(-7.2491700,112.7508300);
    var tripped2 = [semarang,yogyakarta,surabaya];
    var trippedPath2 = new google.maps.Polygon({
      path: tripped2,
      strokeColor: "#0000FF",
      strokeOpacity: 0.8,
      strokeWeight: 2,
      fillColor: "#0000FF",
      fillOpacity: 0.8
    });
    trippedPath2.setMap(map);*/

    //add info to map
    /*var infoWindow = new google.maps.InfoWindow({
      content: "<i>Hello World here !</i>",
      map: map //or via object: infoWindow.setMap(map);
    });*/

    //sometime we need to get back to the place we start
    /*var homeControlDiv = document.createElement("div");
    var homeControl = new HomeControl(homeControlDiv,map);
    map.controls[google.maps.ControlPosition.TOP_RIGHT].push(homeControlDiv);
    //
    function HomeControl(controlDiv, mapTmp) {
      controlDiv.style.padding = '5px';
      var controlUI = document.createElement('div');
      controlUI.style.color = "white";
      controlUI.style.backgroundColor = 'navy';
      controlUI.style.border='1px solid';
      controlUI.style.cursor = 'pointer';
      controlUI.style.textAlign = 'center';
      controlUI.style.padding = '5px';
      controlUI.style.opacity = '0.7';
      controlUI.title = 'Set map to Center';
      controlDiv.appendChild(controlUI);
      var controlText = document.createElement('div');
      controlText.style.fontFamily='"Century Gothic",sans-serif';
      controlText.style.fontSize='12px';
      controlText.style.paddingLeft = '4px';
      controlText.style.paddingRight = '4px';
      controlText.innerHTML = '<b>Home<b>';
      controlUI.appendChild(controlText);

      // Setup click-event listener: simply set the map to clicked
      google.maps.event.addDomListener(controlUI, 'click', function() {
        mapTmp.setCenter(centered);
        marker.setPosition(centered);
        circled.setCenter(centered);
      });
    }*/
    /*google.maps.event.addListener(map,"center_changed", function() {
      setTimeout(function() {
        map.panTo(marker.getPosition());
      }, 3000);
    });*/    
  }

  //binding preparation function on window loading
  google.maps.event.addDomListener(window, 'load', initialize);

  //it is possible to load javascript if needed only
  /*function loadScript() {
    var script = document.createElement("script");
    script.src = "http://maps.googleapis.com/maps/api/js?callback=initialize";
    document.body.appendChild(script);
  }
  window.onload = loadScript;*/
  
  //
  /*$("div.find-record").on("click", "div.img-container>img#img-find-record", function() {
    var isReady = true;
    $.each(masterFindOnlyArr,function(idx,val) {
      var continued = true;
      $.each(val.fieldToCheck,function(idx1,val1) {          
        if($(val1).val() === "0") {          
          isReady = false;
          continued = false;
          return false;
        }
      });
      return continued;
    });
    //if(isReady) {
      //initialize();
      //if(!isMapObjectInclude) {          
        //marker.setMap(null);
        //circled.setMap(null);
      //}
    //}
  });*/
  
});
