<%-- 
    Document   : repmonpage
    Created on : Feb 27, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/repmon.js"></script>
    <link rel="stylesheet" href="../../css/application/repmon.css"/--> 
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="repmon" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div style="float: right">
        <button id="download-btn" class="btn btn-info">
          <span class="glyphicon glyphicon-download-alt"></span>&nbsp;Download
        </button>
      </div>
      <div class="row find-record">
        <div class="form-group">
          <div class="col-sm-4">
            <select id="officeId" class="form-control" ng-model="officeId" ng-init="officeId=0">
              <option value="0">--Choose Office--</option>
              <option ng-repeat="data in datadrop.office" value="{{data.officeId}}">{{data.officeName}}</option>
            </select>
            <input id="officeLbl" class="form-control" value="${sessionScope.officeName}" readonly style="display: none">
          </div>
        </div>
      </div>
      <div id="div-repmon">
        <div>
          <span class="glyphicon glyphicon-stop"></span> : New Task &nbsp;
          <span class="glyphicon glyphicon-stop"></span> : Task Read &nbsp;
          <span class="glyphicon glyphicon-stop"></span> : Verification &nbsp;
          <span class="glyphicon glyphicon-stop"></span> : Task Submitted &nbsp;
        </div>
        <div>
          <span>A : Assignment Date &nbsp;</span>
          <span>R : Retrieve Date &nbsp;</span>
          <span>S : Submit Date &nbsp;</span>
        </div>
        <div><span>Detail Task</span></div>
        <div id="div-task">
          <table id="det-task" class="">
            <tbody></tbody>
          </table>
        </div>
      </div>
      <div id="pagination" hidden>
        <ul class="pagination"></ul>
      </div>
    </div>
  </div>          
  
  <div class="modal fade" id="download-mdl" tabindex="-1" role="dialog" aria-labelledby="download-title" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="download-title"><span class="glyphicon glyphicon-download-alt"></span>&nbsp;Download File</h4>
        </div>
        <div class="modal-body">
          <div>
            <div class="form-group">
              <label>Please select download file type:</label>
              <div id="exceltypedl" class="radio">
                <label>
                  <input type="radio" name="filetypedl" ng-model="filetypedl" value="excelfile" ng-init="filetypedl='excelfile'">
                  <img class="img-record-small" src="../../img/icon/excel_icon.jpg" alt="Excel">&nbsp;Excel
                </label>                
              </div>              
              <div id="pdftypedl" class="radio">
                <label>
                  <input type="radio" name="filetypedl" ng-model="filetypedl" value="pdffile">
                  <img class="img-record-small" src="../../img/icon/pdf_icon.png" alt="PDF">&nbsp;PDF
                </label>               
              </div>              
              <div id="texttypedl" class="radio">
                <label>
                  <input type="radio" name="filetypedl" ng-model="filetypedl" value="textfile">
                  <img class="img-record-small" src="../../img/icon/text_icon.jpg" alt="Text">&nbsp;Text
                </label>               
              </div>             
              <div id="textdelimiterdl" class="input-group" ng-show="filetypedl==='textfile'">
                <label class="input-group-addon">
                  <span>Delimiter:</span>
                </label>
                <input class="form-control" maxlength="3" style="width: 60px" ng-model="textdelimiterdl"> 
              </div>
            </div>
            <!--div class="form-group">
              <label>Verificator</label>
              <div>
                <select class="form-control" ng-model="verificatoriddl">
                  <option ng-repeat="data in datadrop.userasverif" value="{{data.userId}}">{{data.userCode}}</option>
                </select>
              </div>             
            </div-->
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
          <button id="download-btn-exec" class="btn btn-primary">Download</button>
        </div>
      </div>
    </div>
  </div>
  </div>
</body>
</html>
