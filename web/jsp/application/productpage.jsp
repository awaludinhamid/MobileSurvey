<%-- 
    Document   : productpage
    Created on : Jan 17, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/product.js"></script--> 
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="product" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-6">
          <input class="form-control" placeholder="Product Name" ng-model="productNamePattern" ng-init="productNamePattern=''">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Product Code</th>
              <th>Product Name</th>
              <th>Template Code</th>
              <th>Template Label</th>
              <th>Auto Survey</th>
              <th>Start Date</th>
              <th>End Date</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.productId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record" ng-click="storearr(data)"/>
              </td>
              <td>{{data.productCode}}</td>
              <td>{{data.productName}}</td>
              <td>{{data.template.tempCode}}</td>
              <td>{{data.template.tempLabel}}</td>
              <td><img src="../../img/icon/ok-icon.png" alt="Ok" ng-show="data.isAutoSurvey==='true'"/></td>
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
            <input type="hidden" id="productId"/>
            <input type="hidden" id="createdBy"/>
            <div class="form-group">
              <label class="col-sm-3 control-label">Product Code*</label>
              <div class="col-sm-9">
                <input id="productCode" class="form-control" placeholder="[NMC]" maxlength="30" tabindex="1" required autofocus>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Product Name*</label>
              <div class="col-sm-9">
                <input id="productName" class="form-control" placeholder="[New Order NMC]" maxlength="30" tabindex="2" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Template Code*</label>
              <div class="col-sm-9">
                <select id="tempId" class="form-control display-only select-exclude-scan" tabindex="3" ng-model="template"
                        ng-options="drop.tempCode for drop in datadrop.template track by drop.tempId">
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Template Label</label>
              <div class="col-sm-9">
                <label id="tempLabel" class="form-control" ng-bind="template.tempLabel"></label>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Is Auto Survey</label>
              <div class="col-sm-1">
                <input type="checkbox" id="isAutoSurvey" class="form-control checkbox" value="true" tabindex="4">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Valid Date*</label>
              <div class="col-sm-4">
                <div class="input-group">
                  <input id="startDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="5" required>
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
                  <input id="endDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="6" required>
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
