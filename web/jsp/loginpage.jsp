<%-- 
    Document   : loginpage
    Created on : Oct 4, 2016, 7:39:15 PM
    Author     : awal
--%>

<%@include file="support/header.jsp" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="../../css/login.css"/>
    <script src="../../js/login.js"></script>
  </head>
  <body>
    <div class="container body-style-header">
      <div class="row">
        <div class="col-md-6 col-md-offset-4">
          <form id="form-login" class="form-signin login-form-style" method="POST" action="../../apps/auth/security">
            <h3 class="form-signin-heading">Silahkan <i>login</i><br/> untuk masuk ke aplikasi:</h3>
            <br/>
            <div id="logo">
              <img src="../../img/on-off-baloon.png" alt="On-off Logo"/>
            </div>
            <br/>
            <br/>
            <div class="form-group">
              <label for="username" class="sr-only">Username</label>
              <input type="text" id="username" name="username" class="form-control" placeholder="Username" maxlength="10" required autofocus>
            </div>
            <div class="form-group">
              <label for="password" class="sr-only">Password</label>
              <input type="password" id="password" name="password" class="form-control" placeholder="Password" maxlength="10" required>
            </div>
            <div class="form-group">
              <label for="coyCode" class="sr-only">Company Code</label>
              <input type="text" id="coyCode" name="coyCode" class="form-control" placeholder="Company Code" maxlength="6" required title="SIM001">
            </div>
            <div class="error-login">${error}</div>
            <br/>
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Login" />
            <input id="csrf" name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden"/>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
