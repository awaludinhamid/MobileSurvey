<%-- 
    Document   : kelurahanpage
    Created on : Dec 23, 2016, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/kelurahan.js"></script-->
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="kelurahan" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-3">
          <input class="form-control" placeholder="Kelurahan Code" ng-model="kelCodePattern" ng-init="kelCodePattern=''">
        </div>
        <div class="col-sm-3">
          <input class="form-control" placeholder="Kelurahan Name" ng-model="kelNamePattern" ng-init="kelNamePattern=''">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Kelurahan Code</th>
              <th>Kelurahan Name</th>
              <th>Kecamatan</th>
              <th>Kab/Kota</th>
              <th>Provinsi</th>
              <th>Zipcode</th>
              <th>Start Date</th>
              <th>End Date</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.kelId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record" ng-click="storearr(data)"/>
              </td>
              <td>{{data.kelCode}}</td>
              <td>{{data.kelName}}</td>
              <td>{{data.kecamatan.kecName}}</td>
              <td>{{data.kecamatan.city.cityName}}</td>
              <td>{{data.kecamatan.city.provinsi.provName}}</td>
              <td>{{data.zipcode.zipcodeCode}}</td>
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
            <input type="hidden" id="kelId"/>
            <input type="hidden" id="createdBy"/>
            <input type="hidden" id="kecId" value="{{kecamatan.kecId}}">
            <input type="hidden" id="zipcodeId" value="{{zipcode}}">
            <div class="form-group">
              <label class="col-sm-4 control-label">Kelurahan Code*</label>
              <div class="col-sm-8">
                <input id="kelCode" class="form-control" placeholder="[001]" maxlength="20" tabindex="1" required autofocus>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Kelurahan Name*</label>
              <div class="col-sm-8">
                <input id="kelName" class="form-control" placeholder="[Kuningan Barat]" maxlength="100" tabindex="2" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Provinsi*</label>
              <div class="col-sm-8">
                <select id="provId" class="form-control display-only select-exclude-scan" tabindex="3" ng-model="prov" 
                        ng-options="drop.provName for drop in datadrop.provinsi track by drop.provId">
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Kab/Kota*</label>
              <div class="col-sm-8">
                <select id="cityId" class="form-control select-exclude-scan" tabindex="4" required ng-model="city"
                        ng-options="drop.cityName for drop in datadrop.citybyprov track by drop.cityId">
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Kecamatan*</label>
              <div class="col-sm-8">
                <select id="kecamatan" class="form-control select-exclude-scan" tabindex="5" required ng-model="kecamatan"
                        ng-options="drop.kecName for drop in datadrop.kecbycity track by drop.kecId">
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Zipcode</label>
              <div class="col-sm-5">
                <div class="input-group">
                  <input id="patternCode" class="form-control " placeholder="Type Number" maxlength="5" tabindex="6">
                  <div class="input-group-btn">
                    <button type="button" id="btn-load-zipcode" class="btn btn-info" tabindex="7"><span class="glyphicon glyphicon-search"></span>&nbsp;Load List</button>
                  </div>
                </div>
              </div>
              <div class="col-sm-3">
                <select id="zipcode" class="form-control select-exclude-scan" tabindex="8" ng-model="zipcode"
                        ng-options="drop.zipcodeId as drop.zipcodeCode for drop in datadrop.zipcodebypattern">
                  <option value=""></option>
                </select>
              </div>
            </div>
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
