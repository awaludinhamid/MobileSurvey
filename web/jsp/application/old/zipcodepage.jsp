<%-- 
    Document   : zipcodepage
    Created on : Oct 23, 2016, 11:58:08 AM
    Author     : awal
--%>

<%@include file="../support/application.jsp" %>
<!DOCTYPE html>

<html>
  <head>
    <script src="../../js/application/zipcode.js"></script>
  </head>
<body>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-3">
          <input class="form-control" placeholder="Zipcode" ng-model="zipcodeCodePattern" ng-init="zipcodeCodePattern=''">
        </div>
        <div class="col-sm-3">
          <input class="form-control" placeholder="Description" ng-model="zipcodeDescPattern" ng-init="zipcodeDescPattern=''">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Zipcode</th>
              <th>Description</th>
              <th>Provinsi</th>
              <th>Kabupaten/Kota</th>
              <th>Kecamatan</th>
              <th>Kelurahan</th>
              <th>Start Date</th>
              <th>End Date</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.zipcodeId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.zipcodeCode}}</td>
              <td>{{data.zipcodeDesc}}</td>
              <td>{{data.kelurahan.kecamatan.city.provinsi.provName}}</td>
              <td>{{data.kelurahan.kecamatan.city.cityName}}</td>
              <td>{{data.kelurahan.kecamatan.kecName}}</td>
              <td>{{data.kelurahan.kelName}}</td>
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
            <input type="hidden" id="zipcodeId"/>
            <input type="hidden" id="createdBy"/>
            <input type="hidden" id="kelId" value="{{kelurahan}}">
            <div class="form-group">
              <label class="col-sm-3 control-label">Zipcode*</label>
              <div class="col-sm-9">
                <input id="zipcodeCode" class="form-control" placeholder="[16151]" maxlength="5" tabindex="1" required autofocus>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Description</label>
              <div class="col-sm-9">
                <input id="zipcodeDesc" class="form-control" placeholder="[Kode pos kelurahan cimahpar]" maxlength="255" tabindex="2">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Provinsi*</label>
              <div class="col-sm-9">
                <select id="prov" class="form-control display-only select-exclude-scan" tabindex="3" ng-model="prov" 
                        ng-options="drop.provId as drop.provName for drop in datadrop.provinsi">
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Kab/Kota*</label>
              <div class="col-sm-9">
                <select id="city" class="form-control select-exclude-scan" tabindex="4" required ng-model="city"
                        ng-options="drop.cityId as drop.cityName for drop in datadrop.citybyprov">
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Kecamatan*</label>
              <div class="col-sm-9">
                <select id="kecamatan" class="form-control select-exclude-scan" tabindex="5" required ng-model="kecamatan"
                        ng-options="drop.kecId as drop.kecName for drop in datadrop.kecbycity">
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Kelurahan*</label>
              <div class="col-sm-9">
                <select id="kelurahan" class="form-control select-exclude-scan" tabindex="6" required ng-model="kelurahan"
                        ng-options="drop.kelId as drop.kelName for drop in datadrop.kelbykec">
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Valid Date*</label>
              <div class="col-sm-4">
                <div class="input-group">
                  <input id="startDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="7" required>
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
                  <input id="endDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="8" required>
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
</body>
</html>
