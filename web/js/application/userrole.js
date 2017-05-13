/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author awal
 * Script specific to user role page
 */

//initialize the variables
//see application.js file for completed info in each variable
dataIdField = "userRoleId";
disableObjArr = [{fieldName: "Role Name", fieldValue: "role.roleName"},
                  {fieldName: "User Name", fieldValue: "user.userName"}];
objRelMap = [{name: "user", field: [{column: "userId", id: "userId"}]},{name: "role", field: [{column: "roleId", id: "roleId"}]}];
dropdownArr = ["office","rolebyrole"];
errorCaptureArr = [{errTxt: "master_user_role_unq002", errMsg: "Selected user already has role ..!"},
                    {errTxt: "master_user_role_unq001", errMsg: "User role combination already exist ..!"}];

$("div#userrole").ready(function() {
  
  var currDiv = "div#userrole";//element name of the page
  var scope = $(elementScope).scope();//angular scope initial
  var isNew = true; //what kind of process currently running ('new' or 'edit', next maybe 'delete' also)  
  
  if($(currDiv).length) {
    
    //compile menu list modal
    scope.compileObject($("div#mdl-menu-list"));
  }
  
  /**
   * event: click edit button
   * action: assign user and office value to current data
   *         switch several elements view based on current condition
   */
  $(currDiv + " table ").on("click","td>img#img-edit-record",function() { 
    isNew = false;
    scope.user = scope.dataarr.user;
    scope.office = scope.user.office;
    scope.$apply();// i was wonder why this statement must be called
    $("form#form-save select#officeId").prop("disabled",true);
    $("form#form-save div:has(select#userIdTemp)").prop("hidden",true);
    $("form#form-save div:has(label#userCode)").prop("hidden",false);
  });
  
  /**
   * event: click new button
   * action: assign office value to default
   *         switch several elements view based on current condition
   *         reload user list by office
   */
  $(currDiv + " div.find-record").on("click","div.img-container>img#img-new-record",function() { 
    isNew = true;
    scope.office = scope.datadrop.office[0];
    scope.$apply();
    $("form#form-save select#officeId").prop("disabled",false);
    $("form#form-save div:has(select#userIdTemp)").prop("hidden",false);
    $("form#form-save div:has(label#userCode)").prop("hidden",true);
    changeListUserOffice(scope.office.officeId);
  });
  
  /**
   * event: change/choose office list value
   * action: reload user list by office on new state
   */
  $(currDiv + " form#form-save select#officeId").change(function() {
    if(isNew)
      changeListUserOffice($(this).val());
  });
  
  /**
   * event: click menu image
   * action: gather menu data based on current role
   *         show menu list modal
   */
  $(currDiv + " table ").on("click","td>img#img-menu-record",function() {
    scope.initDropdownCommon(relativePath+"apps/data","rolemenubyrole",{roleId: scope.dataarr.role.roleId}, function(response) {
      scope.$apply();
      $("div#mdl-menu-list").modal("show");
    });
  });
  
  /**
   * Reload user list by office
   * @param {Number} officeId
   * @param {Function} callback
   * @returns {void}
   */
  function changeListUserOffice(officeId,callback) {
    scope.initDropdownCommon(relativePath+"apps/data","userbyoffice",{officeId: officeId}, function(response) {
      scope.user = scope.datadrop.userbyoffice[0];
      callback(response);
    });
  }

});