<%-- 
    Document   : distributionpage
    Created on : Dec 12, 2016, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/distribution.js"></script-->
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="distribution" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-6">
          <select class="form-control" ng-model="officeId" ng-init="officeId=0">
            <option value="0">--Choose Office--</option>
            <option ng-repeat="data in datadrop.office" value="{{data.officeId}}">{{data.officeName}}</option>
          </select>
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Office Code</th>
              <th>Office Name</th>
              <th>Auto Distribution</th>
              <th>Load Balance</th>
              <th>Round Robin</th>
              <th>Assign To</th>
              <th>Start Date</th>
              <th>End Date</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.distId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record" ng-click="storearr(data)"/>
              </td>
              <td>{{data.office.officeCode}}</td>
              <td>{{data.office.officeName}}</td>
              <td><img src="../../img/icon/ok-icon.png" alt="Ok" ng-show="data.isAutoDist==='true'"/></td>
              <td>
                <img ng-src="../../img/icon/radio-button-{{radioButton(data.isAutoDist,data.methodType,'L')}}.png" 
                     class="img-record-small" alt="Radio"/>
              </td>
              <td>
                <img ng-src="../../img/icon/radio-button-{{radioButton(data.isAutoDist,data.methodType,'R')}}.png" 
                     class="img-record-small" alt="Radio"/>
              </td>
              <td>{{data.roleAssignTo.roleName}}</td>
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
            <input type="hidden" id="distId"/>
            <input type="hidden" id="createdBy"/>
            <div class="form-group">
              <label class="col-sm-4 control-label">Office*</label>
              <div class="col-sm-8">
                <select id="officeId" class="form-control display-only select-exclude-scan" tabindex="1" ng-model="office" 
                        ng-options="drop.officeName for drop in datadrop.office track by drop.officeId">
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Office Code</label>
              <div class="col-sm-8">
                <label id="officeCode" class="form-control" ng-bind="office.officeCode"></label>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Is Auto Distribution ?</label>
              <div class="col-sm-1">
                <input type="checkbox" id="isAutoDist" class="form-control checkbox" value="true" tabindex="3" ng-model="isAutoDist">
              </div>
            </div>
            <div ng-show="isAutoDist">
              <div class="col-sm-6 col-sm-offset-4 border-around-subject">
                <label>Metode</label>
                <div>
                  <input type="radio" id="loadBalance" name="methodType" value="L" checked>&nbsp;Load Balance
                </div>
                <div>
                  <input type="radio" id="roundRobin" name="methodType" value="R">&nbsp;Round Robin
                </div>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Assign To*</label>
              <div class="col-sm-8">
                <select id="roleId" class="form-control" tabindex="4" required>
                  <option ng-repeat="drop in datadrop.roleassigndist" value="{{drop.roleId}}">{{drop.roleName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Valid Date*</label>
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
              <label class="col-sm-4 control-label">Until Date*</label>
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
  </div>
</body>
</html>
