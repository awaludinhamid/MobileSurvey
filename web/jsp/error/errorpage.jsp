<%-- 
    Document   : errorpage
    Created on : Sep 26, 2016, 8:05:44 AM
    Author     : awal
--%>

<!--%@include file="../support/header.jsp" %-->

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mobile survey, survey in your hands</title>
    <style>
      .background {
        position: fixed;
        top: 0;
        height: 100%;
        width: 100%;
        background: url('../../img/mobile-survey-image-op3.png');
        /*background-color: #ffffaa;*/
        background-size: cover;
        opacity: 1;
        z-index: -1;
      }

      .title {
        position: fixed;
        top: 0px;
        left: 0px;
        width: 100%;
        height: 56px;
        margin: 0;
        padding: 0;
        font-family: Helvetica,sans-serif,Tahoma,monospace,cursive;
        font-weight: bolder;
        color: white;
        background: linear-gradient(#026 50%,#fff 85%);
        z-index: 1100;
        /*overflow-y: hidden;*/
      }
      .title>div.right-info {
        float: right;
        font-size: 15px;
        text-align: right;
      }
    </style>
</head>
<body>
  <div class="background"></div>
  <div class="title">
    <div class="right-info">
      <span>Powered by PKP&trade;</span>
    </div>
  </div>
  <div style="position: relative; top: 100px; width: 45%; margin: auto; text-align: center">
    <h1 style="color: orangered; padding: 10px; border: 5px solid orangered; margin: 0; border-radius: 25px">
      <span style="font-size: 60px">&#9888;</span>
      <br/>
      <span>
        Oops, something is not right<br/> with the request ..!
      </span>
    </h1>
    <br/>
    <h3 style="color: #444">
      They could be caused by the following reasons<br/> (Suggestions that can be followed is described beside):
    </h3>
    <ul style="font-weight: bold; text-align: left">
      <li>The token have sent was expired: <span style="color: #448">Reload <a href="../../../MobileSurvey/apps/auth/login">login page</a> to create a new token</span></li>
      <li>Mistype when request an address: <span style="color: #448">Check it and retype the correct address</span></li>
      <li>Server currently under maintenance for a while: <span style="color: #448">Reload <a href="../../../MobileSurvey">this webpage</a> later</span></li>
      <li>Other reasons: <span style="color: #448">Contact <a href="mailto:support@sim.co.id">support</a> for further information</span></li>
    </ul>
  </div>
</body>
</html>
