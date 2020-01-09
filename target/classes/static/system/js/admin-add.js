$(function(){
  $("#addAdminBtn").click(function(){
	  
	  admin.addAdmin(); 
	  
  });
  $("#cancel").click(function(){
	  owl.closePage();
  });
  owl.ajaxRequest("/system/allGroups",{},function(e){
	 // alert(JSON.stringify(e))
		$("#roleCodes").html("");
	  	$("#groupTemplate").tmpl( e.data ).appendTo("#roleCodes"); 
    });
});
var admin={};
admin.addAdmin=function(){
	var userAccount=$.trim($("#userAccount").val());
	  var userName=$.trim($("#userName").val());
	  var roleCodes=$.trim($("#roleCodes").val());
	  var password=$("#password").val();
	  var confirmPassword=$("#confirmPassword").val();
	  var param={};
	  param.userAccount=userAccount;
	  param.userName=userName;
	  param.password=password;
	  param.confirmPassword=confirmPassword;
	  param.roleCodes=roleCodes;
	owl.ajaxRequest("/system/addAdmin",param,function(e){
  	  //alert(JSON.stringify(e));
  	  layer.msg(e.info);
  	  admin.resetForm();
    });
};
admin.resetForm=function(){
	 $("#userAccount").val("");
	 $("#userName").val("");
	 $("#roleCodes").val("");
	 $("#password").val("");
	 $("#confirmPassword").val("");
}