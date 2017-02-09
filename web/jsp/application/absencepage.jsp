<%-- 
    Document   : absencepage
    Created on : Jan 26, 2017, 11:58:08 AM
    Author     : awal
--%>

<%@include file="../support/application.jsp" %>
<!DOCTYPE html>

<html>
  <head>
    <script src="../../js/application/absence.js"></script>
  </head>
<body>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-3">
          <select class="form-control" ng-model="userId" ng-init="userId=0">
            <option value="0">--Choose User--</option>
            <option ng-repeat="data in datadrop.userbyparent" value="{{data.userId}}">{{data.userName}}</option>
          </select>
        </div>
        <div class="col-sm-3">
          <select class="form-control" ng-model="reasonTypeId" ng-init="reasonTypeId=0">
            <option value="0">--Choose Reason Type--</option>
            <option ng-repeat="data in datadrop.reasontype" value="{{data.reasonTypeId}}">{{data.reasonTypeName}}</option>
          </select>
        </div>
        <div class="col-sm-5">
          <div class="col-sm-6">
            <input id="startDateFind" class="form-control" placeholder="From Date [yyyy-mm-dd]" ng-model="startDate" ng-init="startDate=''">
          </div>
          <div class="col-sm-6">
            <input id="endDateFind" class="form-control" placeholder="To Date [yyyy-mm-dd]" ng-model="endDate" ng-init="endDate=''">
          </div>
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>User Name</th>
              <th>From Date</th>
              <th>To Date</th>
              <th>Reason Type</th>
              <th>Description</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.absenceId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.user.userName}}</td>
              <td>{{data.startDate}}</td>
              <td>{{data.endDate}}</td>
              <td>{{data.reasonType.reasonTypeName}}</td>
              <td>{{data.description}}</td>
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
            <input type="hidden" id="absenceId">
            <input type="hidden" id="createdBy">
            <div class="form-group">
              <label class="col-sm-3 control-label">User Name*</label>
              <div class="col-sm-9">
                <select id="userId" class="form-control" tabindex="1" required autofocus>
                  <option ng-repeat="drop in datadrop.userbyparent" value="{{drop.userId}}">{{drop.userName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Reason Type*</label>
              <div class="col-sm-9">
                <select id="reasonTypeId" class="form-control" tabindex="2" required>
                  <option ng-repeat="drop in datadrop.reasontype" value="{{drop.reasonTypeId}}">{{drop.reasonTypeName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">From Date*</label>
              <div class="col-sm-4">
                <div class="input-group">
                  <input id="startDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="3" required>
                  <div class="input-group-btn">
                    <button id="btn-startdate" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">To Date*</label>
              <div class="col-sm-4">
                <div class="input-group">
                  <input id="endDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="4" required>
                  <div class="input-group-btn">
                    <button id="btn-enddate" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Description</label>
              <div class="col-sm-9">
                <textarea id="description" class="form-control" placeholder="[Diare]" maxlength="255" tabindex="5"></textarea>
              </div>
            </div>
            <div class="btn-form-save">
              <button id="btn-clear" class="btn btn-warning" type="reset">Clear</button>
              <button id="btn-save" class="btn btn-primary" type="submit" tabindex="12">Save</button>
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
