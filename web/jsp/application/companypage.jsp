<%-- 
    Document   : companypage
    Created on : Oct 19, 2016, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/company.js"></script-->  
    <!--meta http-equiv="Refresh" content="1; url=../../apps/main/application"/-->   
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="company" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-3">
          <input class="form-control" placeholder="Company Code" ng-model="coyCodePattern" ng-init="coyCodePattern=''">
        </div>
        <div class="col-sm-3">
          <input class="form-control" placeholder="Company Name" ng-model="coyNamePattern" ng-init="coyNamePattern=''">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Code</th>
              <th>Name</th>
              <th>Start Date</th>
              <th>End Date</th>
              <th>System Name</th>
              <th>No of Users</th>
              <th>Address</th>
              <th>Phone</th>
              <th>MOU No</th>
              <th>PIC Name</th>
              <th>HP No</th>
              <th>Logo</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.coyId}}" data-logo-id="{{data.detailCompanyLogo.companyLogoId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record" ng-click="storearr(data)"/>
              </td>
              <td>{{data.coyCode}}</td>
              <td>{{data.coyName}}</td>
              <td>{{data.startDate}}</td>
              <td>{{data.endDate}}</td>
              <td>{{data.systemName}}</td>
              <td>{{data.noOfUsers}}</td>
              <td>{{data.address}}</td>
              <td>{{data.phone}}</td>
              <td>{{data.mouNo}}</td>
              <td>{{data.picName}}</td>
              <td>{{data.hpNo}}</td>
              <td><img class="coy-logo" src="../../img/icon/coy-logo-ico.png" alt="Coy icon"/></td>
            </tr>
          </tbody>
        </table>
      </div>
      <div id="pagination">
        <ul class="pagination"></ul>
      </div>
    </div>
  </div>
  <div class="modal fade" id="mdl-coy-logo" tabindex="-1" role="dialog" aria-labelledby="coy-logo-title" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="coy-logo-title">
            <img src="../../img/icon/coy-logo-ico.png" alt="Company Icon"/><span>&nbsp;Company Logo</span>
          </h4>
        </div>
        <div class="modal-body">
          <div id="div-preview-logo">
            <div class="companylogoimg">
              <img src="" alt="company logo"/>
            </div>
            <div>            
              <button class="btn btn-default btn-sm zoominlogo"><span class="glyphicon glyphicon-plus"></span></button>
              <button class="btn btn-default btn-sm zoomoutlogo"><span class="glyphicon glyphicon-minus"></span></button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade modal-two-columns" id="mdl-save-record" tabindex="-1" role="dialog" aria-labelledby="save-record-title" aria-hidden="true">
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
            <input type="hidden" id="coyId"/>
            <input type="hidden" id="createdBy"/>
            <input type="hidden" id="companyLogoId"/>
            <div class="form-group">
              <label class="col-sm-2 control-label">Company Code*</label>
              <div class="col-sm-4">
                <input id="coyCode" class="form-control" placeholder="[SIM001]" maxlength="6" tabindex="1" required autofocus>
              </div>
              <label class="col-sm-2 control-label">Number of Users*</label>
              <div class="col-sm-4">
                <input type="number" id="noOfUsers" class="form-control" placeholder="[100]" min="1" max="9999999999" tabindex="10" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Company Name*</label>
              <div class="col-sm-4">
                <input id="coyName" class="form-control" placeholder="[PT SWAKARSA INSAN MANDIRI]" maxlength="30" tabindex="2" required>
              </div>
              <label class="col-sm-2 control-label">System Name*</label>
              <div class="col-sm-4">
                <input id="systemName" class="form-control" placeholder="[Mobile Survey]" maxlength="15" tabindex="11" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Address*</label>
              <div class="col-sm-4">
                <textarea id="address" class="form-control" placeholder="[Jl Kebagusan]" maxlength="150" tabindex="3" required></textarea>
              </div>
              <label for="companyLogo" class="col-sm-2 control-label">Company Logo</label>
              <div class="col-sm-4">
                <div class="input-group">
                  <label class="input-group-btn">
                    <span class="btn btn-primary"> Browse&hellip;
                      <input type="file" id="companyLogo" name="companylogo" class="form-control" accept="image/*" style="display: none">
                    </span>
                  </label>
                  <input type="text" id="fileNameTmp" class="form-control display-only" readonly>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Phone</label>
              <div class="col-sm-4">
                <input id="phone" class="form-control" placeholder="[021-777888999]" maxlength="30" tabindex="4">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">MOU No.</label>
              <div class="col-sm-4">
                <input id="mouNo" class="form-control" placeholder="[SIM001-20161023]" maxlength="30" tabindex="5">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Effective Date*</label>
              <div class="col-sm-2">
                <div class="input-group">
                  <input id="startDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="6" required>
                  <div class="input-group-btn">
                    <button id="btn-startdate" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                  </div>
                </div>
              </div>
              <div class="col-sm-3">
                <label class="control-label col-sm-2">To*</label>
                <div>
                  <div class="input-group col-sm-7">
                    <input id="endDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="7" required>
                    <div class="input-group-btn">
                      <button id="btn-enddate" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">PIC Name</label>
              <div class="col-sm-4">
                <input id="picName" class="form-control" placeholder="[Bambang Utoyo]" maxlength="30" tabindex="8">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">HP No.</label>
              <div class="col-sm-4">
                <input id="hpNo" class="form-control" placeholder="[0811-999888777]" maxlength="30" tabindex="9">
              </div>
            </div>
            <div class="btn-form-save">
              <button id="btn-clear" class="btn btn-warning" type="reset">Clear</button>
              <button id="btn-save" class="btn btn-primary" type="submit" tabindex="12">Save</button>
            </div>
          </form>
          <div id="form-preview-logo">              
            <div class="companylogoimg">
              <img src="" alt="Logo Preview"/>
            </div>
            <div>            
              <button class="btn btn-default btn-sm zoominlogo"><span class="glyphicon glyphicon-plus"></span></button>
              <button class="btn btn-default btn-sm zoomoutlogo"><span class="glyphicon glyphicon-minus"></span></button>
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button class="btn btn-danger" data-dismiss="modal">Cancel</button>
        </div>
      </div>
    </div>
  </div>
  
  <!--script src="../../js/application/company.js"></script-->
  </div>
</body>
</html>
