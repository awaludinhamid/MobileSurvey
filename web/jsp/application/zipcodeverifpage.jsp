<%-- 
    Document   : productpage
    Created on : Jan 23, 2017, 11:58:08 AM
    Author     : awal
--%>

<%@include file="../support/application.jsp" %>
<!DOCTYPE html>

<html>
  <head>
    <script src="../../js/application/zipcodeverif.js"></script>
    <link rel="stylesheet" href="../../css/application/zipcodeverif.css"/>
  </head>
<body>
  <div id="page-content-wrapper">
    <div class="container">
      <div style="float: right">
        <button id="upload-btn" class="btn btn-warning" ng-click="showModal('div#upload-mdl')">
          <span class="glyphicon glyphicon-upload"></span>&nbsp;Upload
        </button>
        <button id="download-btn" class="btn btn-info" ng-click="showModal('div#download-mdl')">
          <span class="glyphicon glyphicon-download-alt"></span>&nbsp;Download
        </button>
      </div>
      <div class="find-record form-group">
        <div class="col-sm-4">
          <select class="form-control" ng-model="verificatorId" ng-init="verificatorId=0">
            <option value="0">--Choose Verificator--</option>
            <option ng-repeat="data in datadrop.userverifbyparent" value="{{data.userId}}">{{data.userCode}}</option>
          </select>
        </div>
        <div class="col-sm-4">
          <input class="form-control" placeholder="Zipcode/Kode Pos" ng-model="zipcodeCodePattern" ng-init="zipcodeCodePattern=''">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Zipcode/Kode Pos</th>
              <th>Sub Zipcode</th>
              <th>Description</th>
              <th>Verificator</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.zipcodeVerifId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.zipcode.zipcodeCode}}</td>
              <td>{{data.subZipcode}}</td>
              <td>{{data.description}}</td>
              <td>{{data.verificator.userName}}</td>
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
            <input type="hidden" id="zipcodeVerifId"/>
            <input type="hidden" id="createdBy"/>
            <div class="form-group">
              <label class="col-sm-3 control-label">Zipcode*</label>
              <div class="col-sm-3">
                <input id="inputSearch" class="form-control" placeholder="Type to search..&#x261E;" tabindex="1" autofocus
                       ng-model="zipcodeSearch">
              </div>
              <div class="col-sm-4">
                <select id="zipcodeId" class="form-control" tabindex="2" required>
                  <option ng-repeat="drop in datadrop.zipcode | filter: {zipcodeCode: zipcodeSearch}"
                          value="{{drop.zipcodeId}}" ng-if="zipcodeSearch">{{drop.zipcodeCode}}</option>
                </select>
              </div>
              <div class="col-sm-2">
                <input id="subZipcode" class="form-control" readonly>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Description</label>
              <div class="col-sm-9">
                <input id="description" class="form-control" placeholder="[Kel Jelambar Kec Grogol Petamburan Jakarta Barat]"
                       maxlength="255" tabindex="4">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Verificator*</label>
              <div class="col-sm-9">
                <select id="verificatorId" class="form-control" tabindex="5" required>
                  <option ng-repeat="data in datadrop.userverifbyparent" value="{{data.userId}}">{{data.userCode}}</option>
                </select>
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
  
  <div class="modal fade" id="upload-mdl" tabindex="-1" role="dialog" aria-labelledby="upload-title" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="upload-title"><span class="glyphicon glyphicon-upload"></span>&nbsp;Upload File</h4>
        </div>
        <div class="modal-body">
          <div>
            <div class="form-group">
              <label>Please select upload file type:</label>
              <div id="exceltype" class="radio">
                <label>
                  <input type="radio" name="excelfile" ng-model="filetype" value="excelfile" ng-init="filetype='excelfile'">&nbsp;Excel (.xls, .xlsx)
                </label>                
              </div>              
              <div id="texttype" class="radio">
                <label>
                  <input type="radio" name="textfile" ng-model="filetype" value="textfile">&nbsp;Text (.txt)
                </label>               
              </div>              
              <div id="textdelimiter" class="input-group" ng-show="filetype==='textfile'">
                <label class="input-group-addon">
                  <span>Delimiter:</span>
                </label>
                <input class="form-control" maxlength="3" style="width: 60px" ng-model="textdelimiter"> 
              </div>
            </div>  
            <div class="form-group" ng-show="filetype==='excelfile'">
              <div id="excelfile" class="input-group">
                <label class="input-group-btn">
                  <span class="btn btn-primary"> Browse File&hellip;
                    <input type="file" name="excelfile" class="form-control" style="display: none"
                           accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel">
                  </span>
                </label>                           
                <input class="form-control" readonly>
              </div>
            </div>
            <div class="form-group" ng-show="filetype==='textfile'">
              <div id="textfile" class="input-group">
                <label class="input-group-btn">
                  <span class="btn btn-primary"> Browse File&hellip;
                  <input type="file" name="textfile" class="form-control" style="display: none"
                         accept="text/plain">
                  </span>
                </label>                           
                <input class="form-control" readonly>
              </div>
            </div>
            <div class="form-group">
              <label>Data Heading Alternative:</label>
              <div id="withoutheaderflag" class="radio">
                <label>
                  <input type="radio" name="headerflag" ng-model="headerflag" value="WO" ng-init="headerflag='WO'">
                  &nbsp;Without header (read data from row no. 1)                  
                </label>
              </div>              
              <div id="withheaderflag" class="radio">
                <label>
                  <input type="radio" name="headerflag" ng-model="headerflag" value="WH">
                  &nbsp;With header (read data from row no. 2)                  
                </label>
              </div>              
            </div>
            <div id="table-format">
              <label>Verify that the file match the following column format:</label>
              <table class="table table-bordered table-condensed">
                <thead>
                  <tr>
                    <th>Verificator Code</th>
                    <th>Zipcode/ Kode&nbsp;Pos</th>
                    <th>Sub Zipcode</th>
                    <th>Description</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>aswin123</td>
                    <td>10210</td>
                    <td>2</td>
                    <td>Kel Benhil Kec Tanah Abang Jakarta Pusat</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
          <button id="upload-btn-exec" class="btn btn-primary">Upload</button>
        </div>
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
            <div class="form-group">
              <label>Verificator</label>
              <div>
                <select class="form-control" ng-model="verificatoriddl">
                  <option ng-repeat="data in datadrop.userasverif" value="{{data.userId}}">{{data.userCode}}</option>
                </select>
              </div>             
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
          <button id="download-btn-exec" class="btn btn-primary">Download</button>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
