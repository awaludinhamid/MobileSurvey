<%-- 
    Document   : officepage
    Created on : Nov 14, 2016, 11:58:08 AM
    Author     : awal
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../support/application.jsp" %>
<!DOCTYPE html>

<html>
  <head>
    <script src="../../js/application/office.js"></script>
  </head>
<body>
  <div id="page-content-wrapper">
    <div class="container">
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Office Code</th>
              <th>Office Name</th>
              <th>Address</th>
              <th>Valid Date</th>
              <th>Until Date</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.officeId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.officeCode}}</td>
              <td>{{data.officeName}}</td>
              <td>{{data.address}}></td>
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
          <form:form id="form-save" class="form-horizontal" modelAttribute="office" method="POST" enctype="multipart/form-data">
            <form:hidden path="officeId" id="officeId"/>
            <form:hidden path="createdBy" id="createdBy"/>
            <form:hidden path="company.coyId" id="coyId" value="${sessionScope.coyId}"/>
            <div class="form-group">
              <label class="col-sm-3 control-label">Office Code*</label>
              <div class="col-sm-9">
                <form:input path="officeCode" id="officeCode" class="form-control input-required" placeholder="[10100]" maxlength="20" tabindex="1"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Office Name*</label>
              <div class="col-sm-9">
                <form:input path="officeName" id="officeName" class="form-control input-required" placeholder="[Jakarta - 1]" maxlength="100" tabindex="2"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Address</label>
              <div class="col-sm-9">
                <form:textarea path="address" id="address" class="form-control" placeholder="[Jl Sunter Raya]" maxlength="255" tabindex="3"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Valid Date*</label>
              <div class="col-sm-4">
                <div class="input-group">
                  <form:input path="startDate" id="startDate" class="form-control input-required" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="4"/>
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
                  <form:input path="endDate" id="endDate" class="form-control input-required" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="5"/>
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
          </form:form>
        </div>
        <div class="modal-footer">
          <button class="btn btn-danger" data-dismiss="modal">Cancel</button>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
