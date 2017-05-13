<%-- 
    Document   : userrolepage
    Created on : Nov 19, 2016, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/userrole.js"></script-->
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="userrole" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-5">
          <div class="col-sm-6">
            <select class="form-control" ng-model="officeId" ng-init="officeId=0">
              <option value="0">--Choose Office--</option>
              <option ng-repeat="data in datadrop.office" value="{{data.officeId}}">{{data.officeName}}</option>
            </select>
          </div>
          <div class="col-sm-6">
            <select class="form-control" ng-model="roleId" ng-init="roleId=0">
              <option value="0">--Choose Role--</option>
              <option ng-repeat="data in datadrop.rolebyrole" value="{{data.roleId}}">{{data.roleName}}</option>
            </select>
          </div>
        </div>
        <div class="col-sm-6">
          <div class="col-sm-7">
            <input class="form-control" placeholder="User Name" ng-model="userNamePattern" ng-init="userNamePattern=''">
          </div>
          <div class="col-sm-5">
            <input id="asOfDate" class="form-control" placeholder="As of Date [yyyy-mm-dd]" ng-model="asOfDate" ng-init="asOfDate=''">
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
              <th>Role</th>
              <th>Menu List</th>
              <th>Office</th>
              <th>User Start Date</th>
              <th>User End Date</th>
              <th>Role Start Date</th>
              <th>Role End Date</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.userRoleId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record" ng-click="storearr(data)"/>
              </td>
              <td>{{data.user.userName}}</td>
              <td>{{data.role.roleName}}</td>
              <td>
                <img id="img-menu-record" class="img-record img-record-small" src="../../img/icon/menu-icon.png" alt="Menu icon" title="Detail" ng-click="storearr(data)"/>
              </td>
              <td>{{data.user.office.officeName}}</td>
              <td>{{data.user.startDate}}</td>
              <td>{{data.user.endDate}}</td>
              <td>{{data.role.startDate}}</td>
              <td>{{data.role.endDate}}</td>
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
            <input type="hidden" id="userRoleId">
            <input type="hidden" id="createdBy">
            <input type="hidden" id="userId" ng-value="user.userId">
            <div class="form-group">
              <label class="col-sm-3 control-label">Office*</label>
              <div class="col-sm-8">
                <select id="officeId" class="form-control display-only select-exclude-scan" tabindex="1" autofocus ng-model="office"
                        ng-options="drop.officeName for drop in datadrop.office track by drop.officeId">
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">User Code*</label>
              <div class="col-sm-8">
                <select id="userIdTemp" class="form-control display-only select-exclude-scan" tabindex="2" ng-model="user"
                        ng-options="drop.userCode for drop in datadrop.userbyoffice track by drop.userId">
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">User Code</label>
              <div class="col-sm-8">
                <label id="userCode" class="form-control" ng-bind="user.userCode"></label>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">User Name</label>
              <div class="col-sm-8">
                <label id="userName" class="form-control" ng-bind="user.userName"></label>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Role*</label>
              <div class="col-sm-8">
                <select id="roleId" class="form-control" tabindex="3" required>
                  <option ng-repeat="drop in datadrop.rolebyrole" value="{{drop.roleId}}">{{drop.roleName}}</option>
                </select>
              </div>
            </div>
            <!--div class="form-group">
              <label class="col-sm-3 control-label">Valid Date*</label>
              <div class="col-sm-4">
                <div class="input-group">
                  <input id="startDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="4" required>
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
                  <input id="endDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="5" required>
                  <div class="input-group-btn">
                    <button id="btn-enddate" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                  </div>
                </div>
              </div>
            </div-->
            <div class="btn-form-save">
              <button id="btn-clear" class="btn btn-warning" type="reset">Clear</button>
              <button id="btn-save" class="btn btn-primary" type="submit" tabindex="10">Save</button>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button class="btn btn-danger" data-dismiss="modal">Cancel</button>
        </div>
      </div>
    </div>
  </div>
  
  <div class="modal fade" id="mdl-menu-list" tabindex="-1" role="dialog" aria-labelledby="menu-list-title" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="menu-list-title">
            <img src="../../img/icon/menu-icon.png" alt="Menu icon"/>&nbspMenu List<span></span>
          </h4>
        </div>
        <div class="modal-body">
          <div class="table-container-normal">
            <table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>Menu Name</th><th>Description</th>
                </tr>
              </thead>
              <tbody>
                <tr ng-repeat="data in datadrop.rolemenubyrole">
                  <td>{{data.menu.menuName}}</td>
                  <td>{{data.menu.menuDesc}}</td>
                </tr>
              </tbody>
            </table>
          </div>
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
