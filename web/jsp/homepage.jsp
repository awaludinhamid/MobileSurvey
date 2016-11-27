<%-- 
    Document   : homepage
    Created on : Oct 5, 2016, 11:58:08 AM
    Author     : awal
--%>

<%@include file="support/header.jsp" %>
<%@include file="support/top-menu.jsp" %>
<!DOCTYPE html>

<html>
  <head>
    <link rel="stylesheet" href="../../css/home.css"/>
  </head>
<body>
  <div class="container body-style-topmenu">
    <div class="row">
      <div class="home-message">
        <span class="glyphicon glyphicon-info-sign"></span><br/>
        Silahkan masuk ke menu <strong>Application</strong> untuk mulai menggunakan aplikasi
        atau gunakan tombol bantuan di menu lainnya jika ada yang ingin diketahui lebih lanjut
      </div>
    </div>
  </div>
  <div class="row text-center">
    <div class="col-md-3">
      <svg width="100%" height="100%" style="position: fixed; opacity: 0.5">
        <g>
          <circle cx="150" cy="200" r="150" fill=""/>
          <text x="40" y="220" fill="white" style="font-size: 50px">Company</text>
          <circle cx="490" cy="200" r="150" fill=""/>
          <text x="410" y="220" fill="white" style="font-size: 50px">Activity</text>
          <circle cx="830" cy="200" r="150" fill=""/>
          <text x="770" y="220" fill="white" style="font-size: 50px">News</text>
        </g>
      </svg>
    </div>
  </div>
</body>
</html>
