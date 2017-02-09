<%-- 
    Document   : header
    Created on : Oct 4, 2016, 7:33:25 PM
    Author     : awal
--%>

<%@page contentType="text/html"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="../../msicon.png" />
    <link rel="stylesheet" href="../../jQuery/css/jquery-ui.min.css"/>
    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../css/header.css"/>
    <link rel="stylesheet" href="../../css/loading.css"/>
    <script src="../../jQuery/js/jquery.min.js"></script>
    <!--script src="../../jQuery/js/jquery-3.1.1.min.js"></script-->
    <script src="../../jQuery/js/jquery-ui.min.js"></script>
    <script src="../../bootstrap/js/bootstrap.min.js"></script>
    <script src="../../js/globalvarfunc.js"></script>
    <script src="../../js/header.js"></script>
    <title>Mobile survey, survey in your hands</title>
  </head>
  <body>
    <div class="background"></div>
    <div class="title">            
      <span class="title-info"><img class="title-info img-logo" src="" alt="Logo"/>${sessionScope.systemName}</span>
      <div class="right-info">
        <span>Powered by PKP&trade;</span>
        <div id="user-menu" hidden>
          <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="glyphicon glyphicon-user"></span>&nbsp;${sessionScope.realName}&nbsp;<span class="caret"></span>
            </button>
            <ul class="dropdown-menu dropdown-menu-right">
              <li id="btn-logout"><a href="#"><span class="glyphicon glyphicon-off"></span>&nbsp;Logout</a></li>
              <li id="change-pass"><a href="#"><span class="glyphicon glyphicon-lock"></span>&nbsp;Change Password</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="../../apps/main/profile"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;Profile</a></li>
            </ul>
          </div>
        </div>
      </div>
      <div class="mirror title-info"><img class="title-info img-logo" src="" alt="Logo"/>${sessionScope.systemName}</div>
    </div>
    <div id="form-logout">      
      <form action="../../apps/auth/logout" method="POST">        
        <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden"/>
      </form>
    </div>
    <div class="modal fade" id="change-pass-mdl" tabindex="-1" role="dialog" aria-labelledby="title" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div id="title" class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title"><span class="glyphicon glyphicon-lock"></span>&nbsp;Change Password</h4>
          </div>
          <div class="modal-body">
            <div>
              <form id="form-change-pass" class="form-horizontal" method="POST" action="../../apps/auth/password/${sessionScope.userId}">
                <div class="form-group">
                  <label for="old-password" class="col-sm-4 control-label">Old Password</label>
                  <div class="col-sm-8">
                    <input type="password" name="old-password" id="old-password" class="form-control" disabled>
                  </div>
                </div>
                <div class="form-group">
                  <label for="new-password" class="col-sm-4 control-label">New Password*</label>
                  <div class="col-sm-8">
                    <input type="password" name="new-password" id="new-password" class="form-control" required autofocus>
                  </div>
                </div>
                <div class="form-group">
                  <label for="con-new-password" class="col-sm-4 control-label">Confirm New Password*</label>
                  <div class="col-sm-8">
                    <input type="password" name="con-new-password" id="con-new-password" class="form-control" required>
                  </div>
                </div>
                <div class="btn-form-save">
                  <input type="submit" class="btn btn-primary" value="Save">
                  <button class="btn btn-warning" data-dismiss="modal">Cancel</button>
                </div>  
                <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden"/>
              </form>
            </div>
          </div>
          <div class="modal-footer">
          </div>
        </div>
      </div>
    </div>
    <div hidden>
      <span id="userid">${sessionScope.userId}</span>
      <span id="username">${sessionScope.userName}</span>
      <span id="realname">${sessionScope.realName}</span>
      <span id="has-role">${sessionScope.hasRole}</span>
      <span id="is-valid">${sessionScope.isValid}</span>
      <span id="sessionid">${sessionScope.sessionId}</span>
      <span id="officename">${sessionScope.officeName}</span>
      <span id="paging-records">${sessionScope.pagingRecords}</span>
      <span id="company-logo-id">${sessionScope.companyLogoId}</span>
      <span id="csrf-param-name">${_csrf.parameterName}</span>
      <span id="csrf-token">${_csrf.token}</span>
    </div>
    
    
    <div class="back-cover" hidden>
      <div class="red-ball">
        <div></div>
      </div>
      <div class="blue-ball">
        <div></div>
      </div>
      <div class="green-ball">
        <div></div>
      </div>
      <div class="loading-text">
        <span>Loading...</span>
      </div>
    </div>
  </body>
</html>
