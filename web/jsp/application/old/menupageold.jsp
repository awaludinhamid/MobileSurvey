<%-- 
    Document   : menupage
    Created on : Oct 19, 2016, 11:58:08 AM
    Author     : awal
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../support/application.jsp" %>
<!DOCTYPE html>

<html>
  <head>
    <script src="../../js/application/menu.js"></script>
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
              <th>Parent Menu</th>
              <th>Menu</th>
              <th>Page</th>
              <th>Description</th>
              <th>Sort</th>
              <th>Valid Date</th>
              <th>Until Date</th>
              <th>Icon Path</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.menuId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.parentMenu.parentMenuName}}</td>
              <td>{{data.menuName}}</td>
              <td>{{data.menuPage}}</td>
              <td>{{data.menuDesc}}</td>
              <td>{{data.sort}}</td>
              <td>{{data.startDate}}</td>
              <td>{{data.endDate}}</td>
              <td>{{data.iconPath}}</td>
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
          <form:form id="form-save" class="form-horizontal" modelAttribute="menu" method="POST" enctype="multipart/form-data">
            <form:hidden path="menuId" id="menuId"/>
            <form:hidden path="createdBy" id="createdBy"/>
            <div class="form-group">
              <label class="col-sm-3 control-label">Parent Menu*</label>
              <div class="col-sm-9">
                <form:select path="parentMenu.parentMenuId" id="parentMenuId" class="form-control" tabindex="1">
                  <option ng-repeat="drop in datadrop" value={{drop.parentMenuId}}>{{drop.parentMenuName}}</option>
                </form:select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Menu*</label>
              <div class="col-sm-9">
                <form:input path="menuName" id="menuName" class="form-control input-required" placeholder="[Parameter]" maxlength="20" tabindex="2"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Page*</label>
              <div class="col-sm-9">
                <form:input path="menuPage" id="menuPage" class="form-control input-required" placeholder="[apps/application/company]" maxlength="255" tabindex="3"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Description</label>
              <div class="col-sm-9">
                <form:input path="menuDesc" id="menuDesc" class="form-control" placeholder="[Setup company]" maxlength="200" tabindex="4"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Sort*</label>
              <div class="col-sm-9">
                <form:input type="number" path="sort" id="sort" class="form-control input-required" placeholder="[5]" tabindex="5"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Valid Date*</label>
              <div class="col-sm-4">
                <div class="input-group">
                  <form:input path="startDate" id="startDate" class="form-control input-required" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="6"/>
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
                  <form:input path="endDate" id="endDate" class="form-control input-required" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="7"/>
                  <div class="input-group-btn">
                    <button id="btn-enddate" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Icon Path</label>
              <div class="col-sm-9">
                <form:input path="iconPath" id="iconPath" class="form-control" placeholder="[company-icon.png]" maxlength="30" tabindex="8"/>
              </div>
            </div>
            <div class="btn-form-save">
              <button id="btn-clear" class="btn btn-warning" type="reset">Clear</button>
              <button id="btn-save" class="btn btn-primary" type="submit" tabindex="12">Save</button>
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
