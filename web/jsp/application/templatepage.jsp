<%-- 
    Document   : templatepage
    Created on : Jan 13, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/template.js"></script>
    <link rel="stylesheet" href="../../css/application/template.css"/--> 
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="template" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-6">
          <input class="form-control" placeholder="Template Label" ng-model="tempLabelPattern" ng-init="tempLabelPattern=''">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Template Code</th>
              <th>Template Label</th>
              <th>Group Question</th>
              <th>Start Date</th>
              <th>End Date</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.tempId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record" ng-click="storearr(data)"/>
              </td>
              <td>{{data.tempCode}}</td>
              <td>{{data.tempLabel}}</td>
              <td>
                <img id="img-question-group-record" class="img-record img-record-small" src="../../img/icon/menu-icon.png" alt="Group Question icon" 
                     title="Group Question" ng-click="store(data.detailTemplates)"/>
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
            <input type="hidden" id="tempId"/>
            <input type="hidden" id="createdBy"/>
            <input type="hidden" id="coyId">
            <div class="form-group">
              <label class="col-sm-3 control-label">Template Code*</label>
              <div class="col-sm-9">
                <input id="tempCode" class="form-control" placeholder="[TNMCORD]" tabindex="1" maxlength="30" required autofocus>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Template Label*</label>
              <div class="col-sm-9">
                <input id="tempLabel" class="form-control" placeholder="[New Order New Motor Cycle]" tabindex="2" maxlength="30" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Start Date*</label>
              <div class="col-sm-4">
                <div class="input-group">
                  <input id="startDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="3" required>
                  <div class="input-group-btn">
                    <button id="btn-startdate" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                  </div>
                </div>
              </div>
              <div class="col-sm-5">
                <label class="control-label col-sm-3">To*</label>
                <div>
                  <div class="input-group col-sm-9">
                    <input id="endDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="4" required>
                    <div class="input-group-btn">
                      <button id="btn-enddate" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group table-container table-container-detail">
              <table id="tbl-data-dtl" class="table table-bordered table-condensed">
                <thead>
                  <tr>
                    <th></th>
                    <th>Group Question</th>
                    <th>Sort</th>
                    <th>Question Set</th>
                  </tr>
                </thead>
                <tbody>
                  <tr ng-repeat="data in datadrop.questiongroup">
                    <td id="questGroupId"><span hidden>{{data.questGroupId}}</span>
                      <input id="inputVerif" type="checkbox" class="form-control checkbox data-detail" tabindex="5"/>
                      <input type="hidden" id="detailTempId" class="data-detail"/>
                      <input type="hidden" id="createdBy" class="data-detail"/>
                      <input type="hidden" id="startDate" class="data-detail"/>
                      <input type="hidden" id="endDate" class="data-detail"/>
                    </td>
                    <td>{{data.questGroupLabel}}</td>
                    <td><input type="number" id="sort" class="form-control data-detail" min="1" max="99999" maxlength="5" tabindex="6"/></td>
                    <td>
                      <img id="img-question-record" class="img-record img-record-small" src="../../img/icon/menu-icon.png" alt="Question icon" 
                           title="Question" ng-click="store(data.detailQuestionGroups)"/>
                    </td>
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
  
  <div class="modal fade" id="mdl-question-group-list" tabindex="-1" role="dialog" aria-labelledby="question-group-list-title" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="question-group-list-title">
            <img src="../../img/icon/menu-icon.png" alt="Group Question icon"/>&nbspGroup Question List<span></span>
          </h4>
        </div>
        <div class="modal-body">
          <div class="table-container-normal">
            <table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>Group Question</th>
                  <th>Sort</th>
                </tr>
              </thead>
              <tbody>
                <tr ng-repeat="data in data | orderBy : 'sort'">
                  <td>{{data.questionGroup.questGroupLabel}}</td>
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
  
  <div class="modal fade" id="mdl-question-list" tabindex="-1" role="dialog" aria-labelledby="question-list-title" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="question-list-title">
            <img src="../../img/icon/menu-icon.png" alt="Option icon"/>&nbspQuestion List<span></span>
          </h4>
        </div>
        <div class="modal-body">
          <div class="table-container-normal">
            <table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>Question Label</th>
                  <th>Answer Type</th>
                  <th>Option Answer</th>
                  <th>Sort</th>
                </tr>
              </thead>
              <tbody>
                <tr ng-repeat="data in data | orderBy : 'sort'">
                    <td>{{data.question.questLabel}}</td>
                    <td>{{data.question.answerType.answerTypeName}}</td>
                    <td>{{data.question.optionAnswer.optionAnswerName}}</td>
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
  </div>
</body>
</html>
