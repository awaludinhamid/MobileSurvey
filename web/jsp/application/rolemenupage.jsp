<%-- 
    Document   : rolemenupage
    Created on : Nov 21, 2016, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/rolemenu.js"></script-->
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="rolemenu" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-3">
          <select class="form-control" ng-model="roleId" ng-init="roleId=0">
            <option value="0">--Choose Role--</option>
            <option ng-repeat="data in datadrop.role" value="{{data.roleId}}">{{data.roleName}}</option>
          </select>
        </div>
        <div class="col-sm-3">
          <select class="form-control" ng-model="menuId" ng-init="menuId=0">
            <option value="0">--Choose Menu--</option>
            <option ng-repeat="data in datadrop.menu" value="{{data.menuId}}">{{data.menuName}}</option>
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
              <th>Role</th>
              <th>Parent Menu</th>
              <th>Menu</th>
              <th>Description</th>
              <th>Role Start Date</th>
              <th>Role End Date</th>
              <th>Menu Start Date</th>
              <th>Menu End Date</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.roleMenuId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record" ng-click="storearr(data)"/>
              </td>
              <td>{{data.role.roleName}}</td>
              <td>{{data.menu.parentMenu.parentMenuName}}</td>
              <td>{{data.menu.menuName}}</td>
              <td>{{data.roleMenuDesc}}</td>
              <td>{{data.role.startDate}}</td>
              <td>{{data.role.endDate}}</td>
              <td>{{data.menu.startDate}}</td>
              <td>{{data.menu.endDate}}</td>
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
            <input type="hidden" id="roleMenuId">
            <input type="hidden" id="createdBy">
            <div class="form-group">
              <label class="col-sm-3 control-label">Role*</label>
              <div class="col-sm-8">
                <select id="roleId" class="form-control" tabindex="1" required autofocus>
                  <option ng-repeat="drop in datadrop.role" value="{{drop.roleId}}">{{drop.roleName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Menu*</label>
              <div class="col-sm-8">
                <select id="menuId" class="form-control" tabindex="2" required>
                  <option ng-repeat="drop in datadrop.menu" value="{{drop.menuId}}">{{drop.menuName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Description</label>
              <div class="col-sm-8">
                <input id="roleMenuDesc" class="form-control" placeholder="[Role menu office]" tabindex="3">
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
  </div>
</body>
</html>
