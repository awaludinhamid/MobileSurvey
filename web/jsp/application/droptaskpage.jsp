<%-- 
    Document   : droptasknpage
    Created on : Mar 15, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/droptask.js"></script>
    <link rel="stylesheet" href="../../css/application/droptask.css"/--> 
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="droptask" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-3">
          <input id="startDateFind" class="form-control" placeholder="Order Date [yyyy-mm-dd]" ng-model="startDate" ng-init="startDate=''">
        </div>
        <div class="col-sm-3">
          <input id="endDateFind" class="form-control" placeholder="To Date [yyyy-mm-dd]" ng-model="endDate" ng-init="endDate=''">
        </div>
        <div class="col-sm-3">
          <input id="taskIdFind" class="form-control" placeholder="Task Id" ng-model="taskId">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th></th>
              <th>Task Id</th>
              <th>Order No</th>
              <th>Order Date</th>
              <th>Customer Name</th>
              <th>Address</th>
              <th>Zipcode</th>
              <th>Phone</th>
              <th>Product</th>
              <th>Owner</th>
              <th>Notes</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.taskId}}">
              <td>
                <button class="btn btn-danger btn-sm" title="Drop Record" ng-click="storearr(data); showModal('div#mdl-drop-record')">
                  <span class="glyphicon glyphicon-trash"></span>
                </button>
              </td>
              <td>{{data.taskId}}</td>
              <td>{{data.orderId}}</td>
              <td>{{data.orderDate}}</td>
              <td>{{data.customerName}}</td>
              <td>{{data.customerAddress}}</td>
              <td>{{data.customerZipcode}}</td>
              <td>{{data.customerPhone}}</td>
              <td>{{data.product.productName}}</td>
              <td>{{data.user.userName}}</td>
              <td>{{data.notes}}</td>
              <td>{{data.taskStatus.taskStatusCode}}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div id="pagination" style="text-align: center">
        <ul class="pagination"></ul>
      </div>
    </div>
  </div>
    
  <div class="modal fade" id="mdl-drop-record" tabindex="-1" role="dialog" aria-labelledby="drop-record-title" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title"><span class="glyphicon glyphicon-trash"></span>&nbsp;Drop Task</h4>
        </div>
        <div class="modal-body">
          <span>Do you want to drop the following task ?</span>
          <table class="table table-condensed table-bordered">
            <thead>
              <tr>
                <th>Task Id</th>
                <th>Order No</th>
                <th>Order Date</th>
                <th>Customer Name</th>
                <th>Owner</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{{dataarr.taskId}}</td>
                <td>{{dataarr.orderId}}</td>
                <td>{{dataarr.orderDate}}</td>
                <td>{{dataarr.customerName}}</td>
                <td>{{dataarr.user.userName}}</td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
          <button id="drop-confirm-btn" type="button" class="btn btn-primary">Yes</button>
        </div>
      </div>
    </div>
  </div>
    
  </div>
</body>
</html>
