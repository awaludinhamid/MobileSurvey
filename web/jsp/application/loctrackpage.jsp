<%-- 
    Document   : loctrackpage
    Created on : Feb 23, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAv3z1L3q9NZim5mwhvUqejnueYlgVSGt0"></script>
    <script src="../../googleMap/js/googlemaputil.js"></script>
    <script src="../../js/application/loctrack.js"></script>
    <link rel="stylesheet" href="../../css/application/loctrack.css"/--> 
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="loctrack" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="row find-record">
        <div class="form-group">
          <div class="col-sm-4">
            <select id="officeId" class="form-control" ng-model="officeId" ng-init="officeId=0">
              <option value="0">--Choose Office--</option>
              <option ng-repeat="data in datadrop.office" value="{{data.officeId}}">{{data.officeName}}</option>
            </select>
            <input id="officeLbl" class="form-control" value="${sessionScope.officeName}" readonly style="display: none">
          </div>
          <div class="col-sm-4">
            <select id="verificatorId" class="form-control" ng-model="verificatorId" ng-init="verificatorId=0">
              <option value="0">--Choose Verificator--</option>
              <option ng-repeat="data in datadrop.verifbyofficerole" value="{{data.userId}}">{{data.userName}}</option>
            </select>
          </div>
          <div class="col-sm-2">
            <select id="isGps" class="form-control" ng-model="isGps" ng-init="isGps='0'">
              <option value="0">--GPS/LBS--</option>
              <option value="Y">GPS</option>
              <option value="N">LBS</option>
            </select>
          </div>
          <div class="col-sm-2">
            <input readonly class="form-control i-am-a-border">
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-4">
            <input id="startDateFind" class="form-control" placeholder="Submit Date [yyyy-mm-dd]" ng-model="startDate" ng-init="startDate=''">
          </div>
          <div class="col-sm-4">
            <input id="endDateFind" class="form-control" placeholder="To Date [yyyy-mm-dd]" ng-model="endDate" ng-init="endDate=''">
          </div>
        </div>
      </div>
      <div id="div-map" class="row">
        <div id="googleMap" hidden></div>
      </div>
          <div id="pagination" hidden>
        <ul class="pagination"></ul>
      </div>
    </div>
  </div>
  </div>
</body>
</html>
