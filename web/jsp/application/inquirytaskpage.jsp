<%-- 
    Document   : inquirytaskpage
    Created on : Feb 09, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/inquirytask.js"></script>
    <link rel="stylesheet" href="../../css/application/inquirytask.css"/-->
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="inquirytask" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record">
        <div class="form-group">
          <div class="col-sm-3">
            <select id="officeId" class="form-control" ng-model="officeId" ng-init="officeId=0">
              <option value="0">--Choose Office--</option>
              <option ng-repeat="data in datadrop.office" value="{{data.officeId}}">{{data.officeName}}</option>
            </select>
            <input id="officeLbl" class="form-control" value="${sessionScope.officeName}" readonly style="display: none">
          </div>
          <div class="col-sm-3">
            <select id="taskStatusId" class="form-control" ng-model="taskStatusId" ng-init="taskStatusId=0">
              <option value="0">--Choose Task Status--</option>
              <option ng-repeat="data in datadrop.taskstatus" value="{{data.taskStatusId}}">{{data.taskStatusCode}}</option>
            </select>
          </div>
          <div class="col-sm-3">
            <input id="startDateFind" class="form-control" placeholder="Assign Date [yyyy-mm-dd]" ng-model="startDate" ng-init="startDate=''">
          </div>
          <div class="col-sm-3">
            <input readonly class="form-control i-am-a-border">
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-3">
            <select id="coordinatorId" class="form-control" ng-model="coordinatorId" ng-init="coordinatorId=0">
              <option value="0">--Choose Coordinator--</option>
              <option ng-repeat="data in datadrop.coordbyofficerole" value="{{data.userId}}">{{data.userName}}</option>
            </select>
            <input id="coordinatorLbl" class="form-control" value="${sessionScope.realName}" readonly style="display: none">
          </div>
          <div class="col-sm-3">
            <select id="tempId" class="form-control" ng-model="tempId" ng-init="tempId=0">
              <option value="0">--Choose Template--</option>
              <option ng-repeat="data in datadrop.template" value="{{data.tempId}}">{{data.tempCode}}</option>
            </select>
          </div>
          <div class="col-sm-3">
            <input id="endDateFind" class="form-control" placeholder="To Date [yyyy-mm-dd]" ng-model="endDate" ng-init="endDate=''">
          </div>
          <div class="col-sm-3">
            <input readonly class="form-control i-am-a-border">
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-3">
            <select id="verificatorId" class="form-control" ng-model="verificatorId" ng-init="verificatorId=0">
              <option value="0">--Choose Verificator--</option>
              <option ng-repeat="data in datadrop.userverifbyparent" value="{{data.userId}}">{{data.userName}}</option>
            </select>
          </div>
          <div class="col-sm-3">
            <select id="priority" class="form-control" ng-model="priority" ng-init="priority=''">
              <option value="">--Choose Priority--</option>
              <option value="Y">Yes</option>
              <option value="N">No</option>
            </select>
          </div>
          <div class="col-sm-2">
            <input id="taskId" class="form-control" placeholder="Task Id.." ng-model="taskId" ng-init="taskId=''">
          </div>
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>Task Id</th>
              <th>Status</th>
              <th>Order No</th>
              <th>Order Date</th>
              <th>Customer Name</th>
              <th>Address</th>
              <th>Assign Date</th>
              <th>Retrieve Date</th>
              <th>Submit Date</th>
              <th>Verificator</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.taskId}}">
              <td><button class="btn btn-info btn-sm" ng-click="storearr(data); showModal('div#mdl-task-result')">{{data.taskId}}</button></td>
              <td>{{data.taskStatus.taskStatusCode}}</td>
              <td>{{data.orderId}}</td>
              <td>{{data.orderDate}}</td>
              <td>{{data.customerName}}</td>
              <td>{{data.customerAddress}}</td>
              <td>{{data.assignmentDate}}</td>
              <td>{{data.retrieveDate}}</td>
              <td>{{data.submitDate}}</td>
              <td ng-hide="data.user.userId === coordinatorId">{{data.user.userName}}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div id="pagination" style="text-align: center">
        <ul class="pagination"></ul>
      </div>
    </div>
  </div>
  
  <div class="modal fade modal-two-columns" id="mdl-task-result" tabindex="-1" role="dialog" aria-labelledby="task-result-title" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="task-result-title">
            <img src="../../img/icon/task-icon.png" alt="Task icon"/>&nbspTask Result<span></span>
          </h4>
        </div>
        <div class="modal-body">
          <div id="det-quest"></div>
          <div id="photo-quest"></div>
        </div>
        <div class="modal-footer">
          <button class="btn btn-danger" data-dismiss="modal">Cancel</button>
        </div>
      </div>
    </div>
  </div>
  </div>
</body>
</html>
