<%-- 
    Document   : application
    Created on : Oct 5, 2016, 11:58:08 AM
    Author     : awal
--%>

<%@include file="../support/header.jsp" %>
<%@include file="../support/top-menu.jsp" %>
<%@include file="../support/side-menu.jsp" %>
<%@include file="../support/modalpage.jsp" %>
<!DOCTYPE html>

<html>
  <head>
    <link rel="stylesheet" href="../../jQuery/css/jquery-ui.structure.min.css"/>
    <link rel="stylesheet" href="../../css/application.css"/>
    <link rel="stylesheet" href="../../css/paging.css"/>
    <link rel="stylesheet" href="" id="link-temp"/>
    <script src="../../angular/angular.min.js"></script>
    <!--script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAv3z1L3q9NZim5mwhvUqejnueYlgVSGt0"></script-->
    <script src="../../js/application.js"></script>
    <script src="../../js/paging.js"></script>
    <script>      
      history.pushState(null,null,localStorage.getItem("previousUrl"));
    </script>
  </head>
<body ng-app="angularApp" ng-controller="angularCtrl">
  <div class="tooltip-date">Please match the requested format: (yyyy-mm-dd)</div>
  <div id="content">
    
  </div>
</body>
</html>
