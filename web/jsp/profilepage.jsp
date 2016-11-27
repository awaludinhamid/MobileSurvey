<%-- 
    Document   : profilepage
    Created on : Nov 14, 2016, 7:39:15 PM
    Author     : awal
--%>

<%@include file="support/header.jsp" %>
<%@include file="support/top-menu.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="../../css/profile.css"/>
  </head>
  <body>
    <div class="container body-style-topmenu">
      <div class="row">
        <div class="profile-header">
          User Profile
        </div>
        <div class="profile-body">
          <form>
            <div class="form-group">
              <label class="col-sm-2 control-label">Username</label>
              <div class="col-sm-10">
                <input class="form-control" disabled value="${sessionScope.userName}">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Name</label>
              <div class="col-sm-10">
                <input class="form-control" disabled value="${sessionScope.realName}">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Session</label>
              <div class="col-sm-10">
                <input class="form-control" disabled value="${sessionScope.sessionId}">
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
