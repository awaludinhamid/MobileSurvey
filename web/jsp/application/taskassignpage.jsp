<%-- 
    Document   : taskassignpage
    Created on : Feb 02, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/taskassign.js"></script>
    <link rel="stylesheet" href="../../css/application/taskassign.css"/--> 
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="taskassign" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-4">
          <select id="coordinatorId" class="form-control" ng-model="coordinatorId" ng-init="coordinatorId=0">
            <option value="0">--Choose Coordinator--</option>
            <option ng-repeat="data in datadrop.usercoordbyparent" value="{{data.userId}}">{{data.userName}}</option>
          </select>
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
              <th><input id="inputVerifAll" type="checkbox" class="form-control checkbox data-detail" tabindex="4"/></th>
              <th>Order No</th>
              <th>Order Date</th>
              <th>Customer Name</th>
              <th>Address</th>
              <th>Zipcode</th>
              <th>Phone</th>
              <th>Product</th>
              <th>Owner</th>
              <th>Notes</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.taskId}}">
              <td>
                <input id="inputVerif" type="checkbox" class="form-control checkbox data-detail" tabindex="5"/>
              </td>
              <td>{{data.orderId}}</td>
              <td>{{data.orderDate}}</td>
              <td>{{data.customerName}}</td>
              <td>{{data.customerAddress}}</td>
              <td>{{data.customerZipcode}}</td>
              <td>{{data.customerPhone}}</td>
              <td>{{data.product.productName}}</td>
              <td>{{data.user.userName}}</td>
              <td>{{data.notes}}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div id="pagination" style="text-align: center">
        <ul class="pagination"></ul>
      </div>
    </div>
  </div>
  </div>
</body>
</html>
