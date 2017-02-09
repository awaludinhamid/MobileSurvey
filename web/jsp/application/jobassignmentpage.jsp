<%-- 
    Document   : templatepage
    Created on : Jan 13, 2017, 11:58:08 AM
    Author     : awal
--%>

<%@include file="../support/application.jsp" %>
<!DOCTYPE html>

<html>
  <head>
    <script src="../../js/application/jobassignment.js"></script>
    <link rel="stylesheet" href="../../css/application/jobassignment.css"/>
  </head>
<body>
  <div id="page-content-wrapper">
    <div class="container">
      <form id="form-save" class="form-horizontal">
        <div class="form-group">
          <label class="col-sm-3 control-label">Role</label>
          <div class="col-sm-9">
            <select id="roleId" class="form-control display-only" tabindex="1" autofocus>
              <option ng-repeat="drop in datadrop.rolejobassign" value="{{drop.roleId}}">{{drop.roleName}}</option>
            </select>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-3 control-label">User Code*</label>
          <div class="col-sm-9">
            <select id="userCommissionedId" class="form-control display-only select-exclude-scan" tabindex="2" ng-model="usercomm"
                    ng-options="drop.userCode for drop in datadrop.userbyrole track by drop.userId">
            </select>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-3 control-label">User Name</label>
          <div class="col-sm-9">
            <label id="userName" class="form-control" ng-bind="usercomm.userName"></label>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-3 control-label">Assign To</label>
          <div class="col-sm-9">
            <select id="assignRoleId" class="form-control display-only" tabindex="3">
              <option ng-repeat="drop in datadrop.rolebyparent" value="{{drop.roleId}}">{{drop.roleName}}</option>
            </select>
          </div>
        </div>
        <div class="form-group table-container table-container-detail">
          <table id="tbl-data-dtl" class="table table-bordered table-condensed">
            <thead>
              <tr>
                <th><input id="inputVerifAll" type="checkbox" class="form-control checkbox data-detail" tabindex="4"/></th>
                <th>User Code</th>
                <th>User Name</th>
              </tr>
            </thead>
            <tbody>
              <tr ng-repeat="data in datadrop.userbyrole2">
                <td id="userAssignedId"><span hidden>{{data.userId}}</span>
                  <input id="inputVerif" type="checkbox" class="form-control checkbox data-detail" tabindex="5"/>
                  <input type="hidden" id="jobAssignId" class="data-detail"/>
                  <input type="hidden" id="createdBy" class="data-detail"/>
                </td>
                <td>{{data.userCode}}</td>
                <td>{{data.userName}}</td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="btn-form-save">
          <button id="btn-clear" class="btn btn-warning" type="reset">Clear</button>
          <button id="btn-save" class="btn btn-primary" type="submit" tabindex="12">Save</button>
        </div>
      </form>
    </div>
  </div>
</body>
</html>
