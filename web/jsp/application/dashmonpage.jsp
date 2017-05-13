<%-- 
    Document   : dashmonpage
    Created on : Feb 22, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAv3z1L3q9NZim5mwhvUqejnueYlgVSGt0"></script>
    <script src="../../googleMap/js/googlemaputil.js"></script>
    <script src="../../js/application/dashmon.js"></script>
    <link rel="stylesheet" href="../../css/application/dashmon.css"/--> 
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="dashmon" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="row find-record form-group">
        <div class="col-sm-4">
          <select id="officeId" class="form-control" ng-model="officeId" ng-init="officeId=0">
            <option value="0">--Choose Office--</option>
            <option ng-repeat="data in datadrop.office" value="{{data.officeId}}">{{data.officeName}}</option>
          </select>
          <input id="officeLbl" class="form-control" value="${sessionScope.officeName}" readonly style="display: none">
        </div>
        <div class="col-sm-4">
          <select id="coordinatorId" class="form-control" ng-model="coordinatorId" ng-init="coordinatorId=0">
            <option value="0">--Choose Coordinator--</option>
            <option ng-repeat="data in datadrop.coordbyofficerole" value="{{data.userId}}">{{data.userName}}</option>
          </select>
          <input id="coordinatorLbl" class="form-control" value="${sessionScope.realName}" readonly style="display: none">
        </div>
      </div>
      <div id="div-map" class="row">
        <div id="verif-list" class="col-sm-3">
          <div ng-repeat="data in datatable">
            <!--span class="glyphicon glyphicon-user"></span-->
            <span ng-click="storearr(data)">&ofcir; {{data.userName}}</span>&nbsp;&VerticalSeparator;&nbsp;
            <span>{{data.lastAssignDate}}</span>&nbsp;&VerticalSeparator;&nbsp;
            <span>O/S Task: {{data.osTask}}</span>,&nbsp;
            <span>Submitted Task: {{data.submitTask}}</span>
          </div>
        </div>
        <div id="googleMap" class="col-sm-9" hidden></div>
      </div>
      <div id="pagination" hidden>
        <ul class="pagination"></ul>
      </div>
    </div>
  </div>
  </div>
</body>
</html>
