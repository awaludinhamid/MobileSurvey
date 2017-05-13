<%-- 
    Document   : questionpage
    Created on : Jan 05, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/question.js"></script--> 
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="question" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-3">
          <input class="form-control" placeholder="Question Label" ng-model="questLabelPattern" ng-init="questLabelPattern=''">
        </div>
        <div class="col-sm-3">
          <select class="form-control" ng-model="answerTypeId" ng-init="answerTypeId=0">
            <option value="0">--Choose Answer Type--</option>
            <option ng-repeat="data in datadrop.answertype" value="{{data.answerTypeId}}">{{data.answerTypeName}}</option>
          </select>
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Question Label</th>
              <th>Answer Type</th>
              <th>Option Answer</th>
              <th>Maximum Length</th>
              <th>Is Mandatory</th>
              <th>Start Date</th>
              <th>End Date</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.questId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record" ng-click="storearr(data)"/>
              </td>
              <td>{{data.questLabel}}</td>
              <td>{{data.answerType.answerTypeName}}</td>
              <td>
                <img id="img-option-record" class="img-record img-record-small" src="../../img/icon/menu-icon.png" alt="Option icon" 
                     title="Option" ng-hide="hideItem(data.optionAnswer.optionAnswerName,'NONE')" ng-click="storearr(data)"/>
              </td>
              <td>{{data.maxLength}}</td>
              <td><input type="checkbox" ng-checked="{{data.isMandatory}}" disabled></td>
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
            <input type="hidden" id="questId"/>
            <input type="hidden" id="createdBy"/>
            <input type="hidden" id="coyId">
            <div class="form-group">
              <label class="col-sm-3 control-label">Question Label*</label>
              <div class="col-sm-9">
                <input id="questLabel" class="form-control" placeholder="[Tipe Identitas]" tabindex="1" maxlength="30" required autofocus>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Answer Type*</label>
              <div class="col-sm-9">
                <select id="answerTypeId" class="form-control" tabindex="2" ng-model="answertype"
                        ng-options="drop.answerTypeName for drop in datadrop.answertype track by drop.answerTypeId">
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Option Answer*</label>
              <div class="col-sm-9">
                <select id="optionAnswerId" class="form-control" tabindex="3">
                  <option ng-repeat="data in datadrop.optionanswer" value="{{data.optionAnswerId}}">{{data.optionAnswerName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group" ng-show="answertype.showMaxLength==='true'">
              <label class="col-sm-3 control-label">Max Length</label>
              <div class="col-sm-9">
                <input type="number" id="maxLength" class="form-control" placeholder="[30]" tabindex="4" max="500">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Is Mandatory</label>
              <div class="col-sm-1">
                <input type="checkbox" id="isMandatory" class="form-control checkbox" value="true" tabindex="5">
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
  
  <div class="modal fade" id="mdl-option-list" tabindex="-1" role="dialog" aria-labelledby="option-list-title" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="option-list-title">
            <img src="../../img/icon/menu-icon.png" alt="Option icon"/>&nbspOption List<span></span>
          </h4>
        </div>
        <div class="modal-body">
          <div class="table-container-normal">
            <table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th ng-repeat="header in datatablegeneric.headers">{{header}}</th>
                </tr>
              </thead>
              <tbody>
                <tr ng-repeat="data in datatablegeneric.contents">
                  <td ng-repeat="header in datatablegeneric.headers">{{data[$index]}}</td>
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
