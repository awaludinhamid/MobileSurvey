/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "jobAssignId";
loadInitListObj = false;
masterDetailObj = {isFormOnly: true, data: [{new:"jobAssignmentDTOList"}]};

$(document).ready(function() {
  //
  var scope = $(elementScope).scope();
  
  //initialized
  //role
  scope.initDropdownCommon(relativePath+"apps/data","rolejobassign",{},function(rolebyrole) {
    //
    var roleId = rolebyrole.data[0].roleId;
    //user by role
    changeListUserByRole(roleId);
    //role by parent role (see hierarchy)
    changeListRoleByParent(roleId, function(rolebyparent) {
      changeListUserByRole2(rolebyparent.data[0].roleId);
    });
  });
    
  //
  $("form#form-save select#roleId").change(function() {
    scope.datadrop.userbyrole2 = [];
    var roleId = $("form#form-save select#roleId").val();
    changeListUserByRole(roleId);
    changeListRoleByParent(roleId, function(rolebyparent) {
      changeListUserByRole2(rolebyparent.data[0].roleId);
    });
  });
    
  //
  $("form#form-save select#assignRoleId, form#form-save select#userCommissionedId").change(function() {
    scope.datadrop.userbyrole2 = [];
    changeListUserByRole2($("form#form-save select#assignRoleId").val());
  });
  
  //
  $("form#form-save input#inputVerifAll").change(function() {
    if($(this).prop("checked"))
      $("form#form-save table#tbl-data-dtl>tbody input:checkbox").prop("checked",true);
    else
      $("form#form-save table#tbl-data-dtl>tbody input:checkbox").prop("checked",false);
  });  
  
  //
  function changeListUserOrRole(url,params,callback) {
    scope.initDropdownCommon(relativePath+"apps/data",url,params,function(response) {
      callback(response);
    });
  }
  
  //
  function changeListUserByRole(roleId) {
    changeListUserOrRole("userbyrole",{roleId: roleId},function(response) {
      scope.usercomm = response.data[0];
    });
  }
  
  //
  function changeListRoleByParent(parentRoleId,callback) {
    changeListUserOrRole("rolebyparent",{parentRoleId: parentRoleId},function(response) {
      $("form#form-save select#assignRoleId").val(response.data[0].roleId);
      callback(response);
    });
  }
  
  //
  function changeListUserByRole2(roleId) {
    changeListUserOrRole("userbyrole2",{roleId: roleId},function(response) {
      setUserAssignedList(scope.usercomm.userId);
    });
  }
  
  //
  function setUserAssignedList(userCommissionedId,callback) {
    scope.initDropdownCommon(relativePath+"apps/data","jobassignment/"+userCommissionedId,{},function(response) {
      if(response.data.length > 0) {
        $("form#form-save input#inputVerif").prop("checked",false);
        $.each(response.data,function(idx,val) {
          $("form#form-save table#tbl-data-dtl>tbody tr").each(function() {
            var firstTdId = $(this).children("td").eq(0);
            if(val.assignedUser.userId + "" === firstTdId.children("span").text()) {
              firstTdId.children("input#inputVerif").prop("checked",true);
              for(var key in val) {
                if(val.hasOwnProperty(key)) {
                  if($.inArray(key,["commissionedUser","assignedUser"]) === -1)
                    firstTdId.children("input#"+key).val(val[key]);
                  else
                    firstTdId.children("input#"+key).val(val[key].userId);
                }
              }
            }
          });
        });
        callback(response);
      }
    });
  }
});