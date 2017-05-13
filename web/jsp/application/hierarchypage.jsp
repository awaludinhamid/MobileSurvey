<%-- 
    Document   : hierarchypage
    Created on : Nov 29, 2016, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/hierarchy.js"></script--> 
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="hierarchy" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-3">
          <select class="form-control" ng-model="roleId" ng-init="roleId=0">
            <option value="0">--Choose Role--</option>
            <option ng-repeat="data in datadrop.rolebyrole" value="{{data.roleId}}">{{data.roleName}}</option>
          </select>
        </div>
        <div class="col-sm-3">
          <select class="form-control" ng-model="roleIdUp" ng-init="roleIdUp=0">
            <option value="0">--Choose Up Level--</option>
            <option ng-repeat="data in datadrop.rolebyrolewithnull" value="{{data.roleId}}">{{data.roleName}}</option>
          </select>
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Role</th>
              <th>Up Level</th>
              <th>Valid Date</th>
              <th>Until Date</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.hieId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record" ng-click="storearr(data)"/>
              </td>
              <td>{{data.role.roleName}}</td>
              <!--td>{{switchValTo(data.roleUp.roleName,'','System Owner')}}</td-->
              <td>{{data.roleUp.roleName}}</td>
              <td>{{data.startDate}}</td>
              <td>{{data.endDate}}</td>
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
            <input type="hidden" id="hieId">
            <input type="hidden" id="createdBy">
            <input type="hidden" id="coyId">
            <div class="form-group">
              <label class="col-sm-3 control-label">Role*</label>
              <div class="col-sm-8">
                <select id="roleId" class="form-control" tabindex="1" required autofocus>
                  <option ng-repeat="drop in datadrop.rolebyrole" value="{{drop.roleId}}">{{drop.roleName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Up Level*</label>
              <div class="col-sm-8">
                <select id="roleIdUp" class="form-control" tabindex="1" required>
                  <option ng-repeat="drop in datadrop.rolebyrolewithnull" value="{{drop.roleId}}">{{drop.roleName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Valid Date*</label>
              <div class="col-sm-4">
                <div class="input-group">
                  <input id="startDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="6" required>
                  <div class="input-group-btn">
                    <button id="btn-startdate" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Until Date*</label>
              <div class="col-sm-4">
                <div class="input-group">
                  <input id="endDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="7" required>
                  <div class="input-group-btn">
                    <button id="btn-enddate" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                  </div>
                </div>
              </div>
            </div>
            <div class="btn-form-save">
              <button id="btn-clear" class="btn btn-warning" type="reset">Clear</button>
              <button id="btn-save" class="btn btn-primary" type="submit" tabindex="7">Save</button>
            </div>
          </form>
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
