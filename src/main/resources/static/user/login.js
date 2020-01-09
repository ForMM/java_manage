$(function(){
	
	$("#loginBtn").click(function(){
		 
		var account=$.trim($("#account").val());
		var password=$("#password").val();
		login.login(account,password);
	});
	$("#reset").click(function(){
		$("#account").val("");
		$("#password").val("");
	});
	$("#account,#password").bind("keydown",function(){
		if (event.keyCode == 13)
		  {
			var account=$.trim($("#account").val());
			var password=$("#password").val();
			login.login(account,password);
		  }
	});
});

var login={};
login.login=function(loginName,loginPassword){
	  var param = {};
      param.loginName=loginName;
      param.loginPassword=loginPassword;
     
      owl.ajaxRequest("/system/login.do",param,function(e){
    	 // alert(JSON.stringify(e));
    		  location.href=getBasePath();
      });
}