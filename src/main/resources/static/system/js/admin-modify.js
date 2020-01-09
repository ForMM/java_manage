$(function(){
	modifyAdmin.userId=userId;
  $("#modifyAdminBtn").click(function(){
	  
	  modifyAdmin.modifyAdmin(); 
  });
  $("#cancel").click(function(){
	  owl.closePage();
  });
  owl.ajaxRequest("/system/adminInfo",{},function(ee){
		  //alert(JSON.stringify(ee));
		  modifyAdmin.userId=ee.data.admin.userId;
		  $("#userName").val(ee.data.admin.userName);
		  $("#userAccount").val(ee.data.admin.userAccount);
		
		  owl.ajaxRequest("/system/allGroups",{},function(e){
				 // alert(JSON.stringify(e))
					$("#roleCodes").html("");
				  	$("#groupTemplate").tmpl( e.data ).appendTo("#roleCodes"); 
				      var groupId = ee.data.admin.groupList[0].groupId;
					  var groupCode = ee.data.admin.groupList[0].groupCode;
				  	$("#roleCodes").children("option").each(function(){
				  		var value = this.value;
				  		if(groupCode==value){
				  			this.selected = true;
				  		}
				  	});
				  	
			    });
	    });
  
  
});
var modifyAdmin={};
modifyAdmin.modifyAdmin=function(){
	if(modifyAdmin.userId==""){
		layer.msg("用户不存在或已被删除！");
	}else{
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
		  param.userId=modifyAdmin.userId;
		  owl.ajaxRequest("/system/modifyAdmin",param,function(e){
	  	  //alert(JSON.stringify(e));
	  	  layer.msg(e.info);
		  });
	}
	  
  
};
