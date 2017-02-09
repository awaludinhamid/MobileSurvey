<%-- 
    Document   : questiongrouppage
    Created on : Jan 10, 2017, 11:58:08 AM
    Author     : awal
--%>

<%@include file="../support/application.jsp" %>
<!DOCTYPE html>

<html>
  <head>
    <script src="../../js/application/questiongroup.js"></script>
    <link rel="stylesheet" href="../../css/application/questiongroup.css"/>
  </head>
<body>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-6">
          <input class="form-control" placeholder="Group Question Label" ng-model="questGroupLabelPattern" ng-init="questGroupLabelPattern=''">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Group Question Label</th>
              <th>Question Set</th>
              <th>Start Date</th>
              <th>End Date</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.questGroupId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.questGroupLabel}}</td>
              <td>
                <img id="img-question-record" class="img-record img-record-small" src="../../img/icon/menu-icon.png" alt="Question icon" 
                     title="Question" ng-click="store(data.detailQuestionGroups)"/>
              </td>
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
            <input type="hidden" id="questGroupId"/>
            <input type="hidden" id="createdBy"/>
            <input type="hidden" id="coyId">
            <div class="form-group">
              <label class="col-sm-4 control-label">Group Question Label*</label>
              <div class="col-sm-8">
                <input id="questGroupLabel" class="form-control" placeholder="[Informasi Customer]" tabindex="1" maxlength="255" required autofocus>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Valid Date*</label>
              <div class="col-sm-4">
                <div class="input-group">
                  <input id="startDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="2" required>
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
                  <input id="endDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="3" required>
                  <div class="input-group-btn">
                    <button id="btn-enddate" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group table-container table-container-detail">
              <table id="tbl-data-dtl" class="table table-bordered table-condensed">
                <thead>
                  <tr>
                    <th></th>
                    <th>Question Label</th>
                    <th>Answer Type</th>
                    <th>Option Answer</th>
                    <th>Sort</th>
                  </tr>
                </thead>
                <tbody>
                  <tr ng-repeat="data in datadrop.question">
                    <td id="questId"><span hidden>{{data.questId}}</span>
                      <input id="inputVerif" type="checkbox" class="form-control checkbox data-detail" tabindex="4"/>
                      <input type="hidden" id="detailQuestGroupId" class="data-detail"/>
                      <input type="hidden" id="createdBy" class="data-detail"/>
                      <input type="hidden" id="startDate" class="data-detail"/>
                      <input type="hidden" id="endDate" class="data-detail"/>
                    </td>
                    <td>{{data.questLabel}}</td>
                    <td>{{data.answerType.answerTypeName}}</td>
                    <td>
                      <img id="img-option-record" class="img-record img-record-small" src="../../img/icon/menu-icon.png" alt="Option icon" 
                           title="Option" ng-hide="hideItem(data.optionAnswer.optionAnswerName,'NONE')" ng-click="store(data)"/>
                    </td>
                    <td><input type="number" id="sort" class="form-control data-detail" min="1" max="99999" tabindex="5"/></td>
                  </tr>
                </tbody>
              </table>
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
  
  <div class="modal fade" id="mdl-question-list" tabindex="-1" role="dialog" aria-labelledby="question-list-title" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="question-list-title">
            <img src="../../img/icon/menu-icon.png" alt="Question icon"/>&nbspQuestion List<span></span>
          </h4>
        </div>
        <div class="modal-body">
          <div class="table-container-normal">
            <table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>Question Label</th>
                  <th>Maximum Length</th>
                  <th>Is Mandatory</th>
                  <th>Sort</th>
                </tr>
              </thead>
              <tbody>
                <tr ng-repeat="data in data">
                  <td>{{data.question.questLabel}}</td>
                  <td>{{data.question.maxLength}}</td>
                  <td><input type="checkbox" ng-checked="{{data.question.isMandatory}}" disabled></td>
                  <td>{{data.sort}}</td>
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
</body>
</html>
