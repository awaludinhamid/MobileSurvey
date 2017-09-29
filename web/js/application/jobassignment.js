/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to job assignment page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "jobAssignId";
loadInitListObj = false;
masterDetailObj = {isFormOnly: true, data: [{new:"jobAssignmentDTOList"}]};
hasExtraClass = true;
errorCaptureArr = [{errTxt: "master_job_assignment_unq002", errMsg: "Selected user already has up-level ..!"}];

$("div#jobassignment").ready(function() {
  
  var currDiv = "div#jobassignment";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  
  //initialized
  
  /**
   * Gather role by logged user role and execute several process based on the role
   * @returns void
   */
  var initRole = function() {
    scope.initDropdownCommon(relativePath+"apps/data","rolejobassign",{},function(rolebyrole) {
      
      //load user by role
      changeListUserByRole(rolebyrole.data[0].roleId, function(userbyrole) {        
        
        var currUser = getCurrUser(Number($("span#userid").text()),userbyrole.data); //current user object 
        
        //if logged user is coordinator then inaccessible other user
        if($("span#roletype-code").text() === "C") {
          scope.usercomm = currUser;
          saveParams = {userCommissionedId:scope.usercomm.userId};
          $("form#form-save select#userCommissionedId").prop("disabled",true);
          $("form#form-save select#roleId").prop("disabled",true);
        }
        else {
          $("form#form-save select#userCommissionedId").prop("disabled",false);
          $("form#form-save select#roleId").prop("disabled",false);          
        }
        
        //role by parent role (see hierarchy)
        changeListRoleByParent(rolebyrole.data[0].roleLevel, function(rolebyparent) {
          changeListUserByRole2(rolebyparent.data[0].roleId, rolebyrole.data[0].roleType.roleTypeCode, currUser.userId);
        });        
      });
    });
    
    /**
     * Get user by id
     * @param {Number} userId
     * @param {Array} userArr , array of user to find
     * @returns Object
     */
    function getCurrUser(userId,userArr) {
      for(var idxUser in userArr) {
        if(userArr[idxUser].userId === userId) {
          return userArr[idxUser];
        }
      }
      return userArr[0];
    }
  };
  
  if($(currDiv).length) {
    
    //just execute the initializing role
    initRole();
  }
  
  /**
   * event: change/choose the role list value
   * action: reload user by commission role list, role by superior list and user by assigned role list
   */
  $(currDiv + " form#form-save select#roleId").change(function() {
    scope.datadrop.userbyrole2 = [];
    var selectedOption = $(this).find(":selected");
    changeListUserByRole($(this).val(), function(userbyrole) {
      changeListRoleByParent(selectedOption.data("level"), function(rolebyparent) {
        changeListUserByRole2(rolebyparent.data[0].roleId, selectedOption.data("roletypecode"), userbyrole.data[0].userId);
      });      
    });
  });
    
  /**
   * event: change/choose assign role or user commission list value
   * action: reload user by assigned role list
   */
  $(currDiv + " form#form-save select#assignRoleId, " + currDiv + " form#form-save select#userCommissionedId").change(function() {
    scope.datadrop.userbyrole2 = [];
    saveParams = {userCommissionedId:$("form#form-save select#userCommissionedId").val()};
    changeListUserByRole2($("form#form-save select#assignRoleId").val(),
                          $("form#form-save select#roleId").find(":selected").data("roletypecode"),
                          $("form#form-save select#userCommissionedId").val());
  });
  
  /**
   * event: [un]checked the checkbox all
   * action: switched detail checkbox align with the checkbox all value
   */
  $(currDiv + " form#form-save input#inputVerifAll").change(function() {
    if($(this).prop("checked"))
      $("form#form-save table#tbl-data-dtl>tbody input:checkbox").prop("checked",true);
    else
      $("form#form-save table#tbl-data-dtl>tbody input:checkbox").prop("checked",false);
  });  
  
  /**
   * event: click reset button
   * action: reinitialize the process
   */
  $(currDiv + " form#form-save").on("reset",function() {
    initRole();
  });
  
  /**
   * event: on hide the modal
   * action: reload user by assigned role list
   */
  $(".modal#message-mdl").on("hidden.bs.modal", function() {
    if($(currDiv).length)
      changeListUserByRole2($("form#form-save select#assignRoleId").val(),
                          $("form#form-save select#roleId").find(":selected").data("roletypecode"),
                          $("form#form-save select#userCommissionedId").val());
  });
  
  /**
   * Reload user or role list
   * @param {String} url
   * @param {Object} params , parameter in form of name and value pair
   * @param {Function} callback
   * @returns void
   */
  function changeListUserOrRole(url,params,callback) {
    scope.initDropdownCommon(relativePath+"apps/data",url,params,function(response) {
      callback(response);
    });
  }
  
  /**
   * Reload user by user commissioned role list
   * Assign user commissioned value
   * @param {Number} roleId
   * @param {Function} callback
   * @returns void
   */
  function changeListUserByRole(roleId, callback) {
    changeListUserOrRole("userbyrole",{roleId: roleId},function(response) {
      scope.usercomm = response.data[0];        
      //assign save parameter
      saveParams = {userCommissionedId:scope.usercomm.userId};
      callback(response);
    });
  }
  
  /**
   * Reload role by superior list
   * Assign the assigned role id
   * @param {Number} roleLevel
   * @param {Function} callback
   * @returns void
   */
  function changeListRoleByParent(roleLevel,callback) {
    changeListUserOrRole("rolechildlevel",{roleLevel: roleLevel},function(response) {
      $("form#form-save select#assignRoleId").val(response.data[0].roleId);
      callback(response);
    });
  }
  
  /**
   * Reload user by user assigned role and set the default value
   * @param {Number} roleId
   * @param {String} roleTypeCode
   * @param {Number} userId
   * @returns void
   */
  function changeListUserByRole2(roleId, roleTypeCode, userId) {
    changeListUserOrRole("userbyrole2",{roleId: roleId, roleTypeCode: roleTypeCode, userId: userId},function(response) {
      setUserAssignedList(scope.usercomm.userId);
    });
  }
  
  /**
   * Value assignment of user assigned list
   * @param {type} userCommissionedId
   * @param {type} callback
   * @returns {undefined}
   */
  function setUserAssignedList(userCommissionedId,callback) {
    scope.initDropdownCommon(relativePath+"apps/data","jobassignment/"+userCommissionedId,{},function(response) {
      
      //proceed when data found
      if(response.data.length > 0) {
        $("form#form-save input#inputVerif").prop("checked",false);
        
        //checked the checkbox list if it verified
        //and assign other field value
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