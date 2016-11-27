<%-- 
    Document   : loginpage
    Created on : Oct 4, 2016, 7:39:15 PM
    Author     : awal
--%>

<%@include file="support/header.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="../../css/login.css"/>
  </head>
  <body>
    <div class="container body-style-header">
      <div class="row">
        <!--div class="col-md-8 login-welcome-style">
          <h2 class="text-center">
            Selamat datang di aplikasi
          </h3>
          <hr/>
          <div>
            <h3>Pengantar</h3>
            <span class="text-justify">
              Kecepatan layanan ...
            </span>
          </div>
          <hr/>
          <div>
            <h3>Fungsi Aplikasi</h3>
            <ul>
              <li>Mengintegrasikan ...</li>
              <li>Meningkatkan kinerja ...</li>
              <li>...</li>
            </ul>
          </div>
          <hr/>
          <div>
            <h3>Informasi Penggunaan</h3>
            <ul>
              <li>Untuk memulai silahkan <i>login</i> terlebih dahulu</li>
              <li>Modul yang bisa diakses disesuaikan dengan <i>role</i> pengguna yang <i>login</i></li>
              <li>Setiap modul terdiri dari dua bagian utama yakni bagian penginputan dan bagian tampilan</li>
              <li>Bantuan penggunaan disediakan berupa menu <i>Help</i> di menu utama dan <i>tooltip</i> di masing-masing kolom isian/tampilan</li>
              <li>Jika membutuhkan bantuan yang tidak disediakan di menu <i>Help</i> dan <i>tooltip</i> silahkan mengakses menu <i>Contact Us</i> 
                untuk mendapatkan bantuan dari admin aplikasi
              </li>
            </ul>        
          </div>
        </div-->
        <div class="col-md-6 col-md-offset-4">
          <form id="form-login" class="form-signin login-form-style" method="POST" action="../../apps/auth/security">
            <h3 class="form-signin-heading">Silahkan <i>login</i> untuk masuk ke aplikasi:</h3>
            <br/>
            <div id="logo">
              <img src="../../img/on-off-baloon.png" alt="On-off Logo"/>
            </div>
            <br/>
            <br/>
            <div class="form-group">
              <label for="username" class="sr-only">Username</label>
              <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
            </div>
            <div class="form-group">
              <label for="password" class="sr-only">Password</label>
              <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
            </div>
            <div class="error-login">${error}</div>
            <br/>
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Login" />
            <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden"/>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
