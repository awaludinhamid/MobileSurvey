<%-- 
    Document   : validationpage
    Created on : Oct 15, 2016, 11:58:08 AM
    Author     : awal
--%>

<%@include file="support/header.jsp" %>
<!DOCTYPE html>

<html>
  <head>
    <script src="../../js/validation.js"></script>
  </head>
  <body>
    <div class="modal fade" id="validation-alert-mdl" tabindex="-1" role="dialog" aria-labelledby="title" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div id="title" class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title"><span class="glyphicon glyphicon-alert"></span>&nbsp;Validation Alert</h4>
          </div>
          <div class="modal-body">
            <span>Your MOU might be expired or you must setup user role first..</span>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
