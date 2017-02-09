<%-- 
    Document   : userpage
    Created on : Nov 14, 2016, 11:58:08 AM
    Author     : awal
--%>

<%@include file="../support/application.jsp" %>
<!DOCTYPE html>

<html>
  <head>
    <script src="../../js/application/user.js"></script>
  </head>
<body>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-3">
          <select class="form-control" ng-model="userCode" ng-init="userCode=''">
            <option value="">--Choose User Code--</option>
            <option ng-repeat="data in datadrop.user" value="{{data.userCode}}">{{data.userCode}}</option>
          </select>
        </div>
        <div class="col-sm-3">
          <select class="form-control" ng-model="userName" ng-init="userName=''">
            <option value="">--Choose User Name--</option>
            <option ng-repeat="data in datadrop.user" value="{{data.userName}}">{{data.userName}}</option>
          </select>
        </div>
        <div class="col-sm-3">
          <input id="asOfDate" class="form-control" placeholder="As of Date [yyyy-mm-dd]" ng-model="asOfDate" ng-init="asOfDate=''">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>User Name</th>
              <th>User Code</th>
              <th>Office</th>
              <th>Valid Date</th>
              <th>Until Date</th>
              <th>IMEI</th>
              <th>Password</th>
              <th>Email</th>
              <!--th>Is Verificator</th-->
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.userId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.userName}}</td>
              <td>{{data.userCode}}</td>
              <td>{{data.office.officeName}}</td>
              <td>{{data.startDate}}</td>
              <td>{{data.endDate}}</td>
              <td>{{data.userImei}}</td>
              <td>{{data.userPassword}}</td>
              <td>{{data.userEmail}}</td>
              <!--td><input type="checkbox" ng-checked="{{data.isVerif}}" disabled></td-->
            </tr>
          </tbody>
        </table>
      </div>
      <div id="pagination" style="text-align: center">
        <ul class="pagination"></ul>
      </div>
    </div>
  </div>
  <div class="modal fade" id="mdl-save-record" tabindex="-1" role="dialog" aria-labelledby="save-record-title" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="save-record-title">
            <img src="" alt="Save icon"/>&nbsp<span></span>
          </h4>
        </div>
        <div class="modal-body">
          <form id="form-save" class="form-horizontal">
            <input type="hidden" id="userId">
            <input type="hidden" id="createdBy">
            <input type="hidden" id="userPassword" value="{{userPassword}}">
            <div class="form-group">
              <label class="col-sm-4 control-label">Office*</label>
              <div class="col-sm-8">
                <select id="officeId" class="form-control" tabindex="1" required autofocus>
                  <option ng-repeat="drop in datadrop.office" value="{{drop.officeId}}">{{drop.officeName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">User Code*</label>
              <div class="col-sm-8">
                <input id="userCode" class="form-control" placeholder="[admin]" pattern="[a-zA-Z0-9]+" maxlength="10" tabindex="2" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">User Name*</label>
              <div class="col-sm-8">
                <input id="userName" class="form-control" placeholder="[Administrator]" maxlength="100" tabindex="3" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Password*</label>
              <div class="col-sm-8">
                <input type="password" id="user-password" class="form-control" placeholder="[**********]" pattern=".{6,}" maxlength="10" tabindex="4" required ng-model="userPassword">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Confirm Password*</label>
              <div class="col-sm-8">
                <input type="password" id="con-user-password" class="form-control" placeholder="[**********]" pattern=".{6,}" maxlength="10" tabindex="5" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">IMEI</label>
              <div class="col-sm-8">
                <input id="userImei" class="form-control" placeholder="WYIZN10FGH03JKY" maxlength="20" tabindex="6">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Email</label>
              <div class="col-sm-8">
                <input type="email" id="userEmail" class="form-control" placeholder="[admin@sim.co.id]" maxlength="100" tabindex="7">
              </div>
            </div>
            <!--div class="form-group">
              <label class="col-sm-4 control-label">Is Verificator ?</label>
              <div class="col-sm-1">
                <input type="checkbox" id="isVerif" class="form-control checkbox" value="true" tabindex="8">
              </div>
            </div-->
            <div class="form-group">
              <label class="col-sm-4 control-label">Valid Date*</label>
              <div class="col-sm-4">
                <div class="input-group">
                  <input id="startDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="9" required>
                  <div class="input-group-btn">
                    <button id="btn-startdate" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Until Date*</label>
              <div class="col-sm-4">
                <div class="input-group">
                  <input id="endDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="10" required>
                  <div class="input-group-btn">
                    <button id="btn-enddate" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                  </div>
                </div>
              </div>
            </div>
            <div class="btn-form-save">
              <button id="btn-clear" class="btn btn-warning" type="reset">Clear</button>
              <button id="btn-save" class="btn btn-primary" type="submit" tabindex="11">Save</button>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button class="btn btn-danger" data-dismiss="modal">Cancel</button>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
