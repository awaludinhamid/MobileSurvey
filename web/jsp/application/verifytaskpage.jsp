<%-- 
    Document   : verifytaskpage
    Created on : Feb 13, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../jQuery/js/jquery.base64.js"></script>
    <script src="../../js/application/verifytask.js"></script>
    <link rel="stylesheet" href="../../css/application/verifytask.css"/-->
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="verifytask" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-4">
          <select id="coordinatorId" class="form-control" ng-model="coordinatorId" ng-init="coordinatorId=0">
            <option value="0">--Choose Coordinator--</option>
            <option ng-repeat="data in datadrop.usercoordbyparent" value="{{data.userId}}">{{data.userName}}</option>
          </select>
          <input id="coordinatorLbl" class="form-control" value="${sessionScope.realName}" readonly style="display: none">
        </div>
        <div class="col-sm-4">
          <select id="verificatorId" class="form-control" ng-model="verificatorId" ng-init="verificatorId=0">
            <option value="0">--Choose Verificator--</option>
            <option ng-repeat="data in datadrop.userverifbyparent" value="{{data.userId}}">{{data.userName}}</option>
          </select>
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th></th>
              <th>Task Id</th>
              <th>Result Id</th>
              <th>Order No</th>
              <th>Order Date</th>
              <th>Customer Name</th>
              <th>Address</th>
              <th>Assignment Date</th>
              <th>Retrieve Date</th>
              <th>Submit Date</th>
              <th>Verificator</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.taskResultId}}">
              <td>
                <img id="img-verif-record" class="img-record img-record-small" src="../../img/icon/verify-icon.png" alt="Verify icon" title="Verify Record" ng-click="storearr(data); showModal('div#mdl-verify-record')"/>
              </td>
              <td>{{data.task.taskId}}</td>
              <td>{{data.taskResultId}}</td>
              <td>{{data.task.orderId}}</td>
              <td>{{data.task.orderDate}}</td>
              <td>{{data.task.customerName}}</td>
              <td>{{data.task.customerAddress}}</td>
              <td>{{data.task.assignmentDate}}</td>
              <td>{{data.task.retrieveDate}}</td>
              <td>{{data.task.submitDate}}</td>
              <td>{{data.task.user.userName}}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div id="pagination" style="text-align: center">
        <ul class="pagination"></ul>
      </div>
    </div>
  </div>
        
  <div class="modal fade modal-two-columns" id="mdl-verify-record" tabindex="-1" role="dialog" aria-labelledby="verify-record-title" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="verify-record-title">
            <img src="../../img/icon/verify-icon.png" alt="Verify icon"/>&nbsp<span>Verify Task Result</span>
          </h4>
        </div>
        <div class="modal-body">
          <table class="table table-condensed verify-title">
            <tbody>
              <tr>
                <td>Office</td><td>{{dataarr.task.office.officeCode}}&nbsp;&dash;&nbsp;{{dataarr.task.office.officeName}}</td>
                <td>Assignment Date</td><td>{{dataarr.task.assignmentDate}}</td>
              </tr>
              <tr>
                <td>Verificator</td><td>{{dataarr.task.user.userCode}}&nbsp;&dash;&nbsp;{{dataarr.task.user.userName}}</td>
                <td>Retrieve Date</td><td>{{dataarr.task.retrieveDate}}</td>
              </tr>
              <tr>
                <td>Task Id</td><td>{{dataarr.task.taskId}}</td><td>Submit Date</td><td>{{dataarr.task.submitDate}}</td>
              </tr>
              <tr>
                <td>Order No</td><td>{{dataarr.task.orderId}}</td><td>Priority</td><td>{{setCondVal(dataarr.task.priority === "Y","Yes","No")}}</td>
              </tr>
              <tr>
                <td>Order Date</td><td>{{dataarr.task.orderDate}}</td><td>Notes</td><td>{{dataarr.task.notes}}</td>
              </tr>
              <tr>
                <td>Customer</td><td>{{dataarr.task.customerName}}</td><td>Address</td><td>{{dataarr.task.customerAddress}}</td>
              </tr>
              <tr>
                <td>No Telp</td><td>{{dataarr.task.customerPhone}}</td><td></td><td></td>
              </tr>
            </tbody>
          </table>
          <div id="det-quest"></div>
          <div id="photo-quest"></div>
        </div>
        <div class="modal-footer">
          <button class="btn btn-primary">Save</button>
          <button class="btn btn-danger" data-dismiss="modal">Cancel</button>
        </div>
      </div>
    </div>
  </div>
  </div>
</body>
</html>
