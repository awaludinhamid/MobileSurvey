<%-- 
    Document   : parameterpage
    Created on : Nov 24, 2016, 11:58:08 AM
    Author     : awal
--%>

<%@include file="../support/application.jsp" %>
<!DOCTYPE html>

<html>
  <head>
    <script src="../../js/application/parameter.js"></script>
  </head>
<body>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-3">
          <input class="form-control" placeholder="Parameter Code" ng-model="parCodePattern" ng-init="parCodePattern=''">
        </div>
        <div class="col-sm-3">
          <input class="form-control" placeholder="Parameter Description" ng-model="parDescPattern" ng-init="parDescPattern=''">
        </div>
        <div class="col-sm-3">
          <select class="form-control" ng-model="parAppsType" ng-init="parAppsType=''">
            <option value="">--Choose Parameter Type--</option>
            <option ng-repeat="data in datadrop.parappstype" value="{{data.value}}">{{data.name}}</option>
          </select>
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Code</th>
              <th>Description</th>
              <th>Data Type</th>
              <th>Value</th>
              <th>Type</th>
              <th>Valid Date</th>
              <th>Until Date</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.parId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.parCode}}</td>
              <td>{{data.parDesc}}</td>
              <td>{{data.parDataType}}</td>
              <td>{{data.parValue}}</td>
              <td>{{data.parAppsType}}</td>
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
            <input type="hidden" id="parId">
            <input type="hidden" id="createdBy">
            <input type="hidden" id="coyId">
            <div class="form-group">
              <label class="col-sm-3 control-label">Code*</label>
              <div class="col-sm-9">
                <input id="parCode" class="form-control" placeholder="[TM001]" maxlength="20" tabindex="1" required autofocus>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Description</label>
              <div class="col-sm-9">
                <input id="parDesc" class="form-control" placeholder="[Refresh Task]" maxlength="255" tabindex="2">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Data Type</label>
              <div class="col-sm-9">
                <select id="parDataType" class="form-control" tabindex="3">
                  <option ng-repeat="drop in datadrop.pardatatype" value="{{drop.value}}">{{drop.name}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Value</label>
              <div class="col-sm-9">
                <input id="parValue" class="form-control" placeholder="[180]" maxlength="255" tabindex="4">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Type</label>
              <div class="col-sm-9">
                <select id="parAppsType" class="form-control" tabindex="5">
                  <option ng-repeat="drop in datadrop.parappstype" value="{{drop.value}}">{{drop.name}}</option>
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
</body>
</html>
