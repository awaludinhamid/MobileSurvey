<%-- 
    Document   : rollingtaskpage
    Created on : Feb 06, 2017, 11:58:08 AM
    Author     : awal
--%>

<%@include file="../support/application.jsp" %>
<!DOCTYPE html>

<html>
  <head>
    <script src="../../js/application/rollingtask.js"></script>
    <link rel="stylesheet" href="../../css/application/rollingtask.css"/>
  </head>
<body>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-3">
          <select id="roleId" class="form-control" ng-model="roleId" ng-init="roleId=0">
            <option value="0">--Choose Rolling Type--</option>
            <option ng-repeat="data in datadrop.roleassigndist" value="{{data.roleId}}">{{data.roleName}}</option>
          </select>
        </div>
        <div class="col-sm-3">
          <select id="commissionedId" class="form-control" ng-model="commissionedId" ng-init="commissionedId=0">
            <option value="0">--Choose Rolling From--</option>
            <option ng-repeat="data in datadrop.userbyroleparent" value="{{data.userId}}">{{data.userName}}</option>
          </select>
        </div>
        <div class="col-sm-3">
          <select id="assignedId" class="form-control" ng-model="assignedId" ng-init="assignedId=0">
            <option value="0">--Choose Rolling To--</option>
            <option ng-repeat="data in datadrop.userbyroleparent" value="{{data.userId}}">{{data.userName}}</option>
          </select>
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th><input id="inputVerifAll" type="checkbox" class="form-control checkbox data-detail" tabindex="4"/></th>
              <th>Order Id</th>
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
</body>
</html>
