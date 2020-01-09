$(function(){
	index.userMenus();
	$("#logout").click(function(){
		index.logout();
	});
	$("#resetPwdPage").click(function(){
		  owl.openPage(this,"/system/resetPwdPage.do","修改密码");
	});
	 owl.ajaxRequest("/loginInfo",{},function(e){
   	// alert(JSON.stringify(e));
   	  $("#userName").html(e.data.loginInfo.cUserName);
   	  $("#realName").html(e.data.loginInfo.cRealName);
     });
});

var index={};
index.userMenus=function(){
	  var param = {};
     var basePath=getBasePath();
      owl.ajaxRequest("/system/userMenus",param,function(e){
    	 //alert(JSON.stringify(e));
    	 $("#menuTemplate").tmpl( e.data ).appendTo("#menuList"); 
    	 $("dt").click(function(){
    		 if($(this).hasClass("selected")){
    			 $(this).removeClass("selected");
    			 $(this).siblings("dd").eq(0).css("display","none");
    		 }else{
    			 $("dt").removeClass("selected");
    			 $("dd").css("display","none");
    			 $(this).addClass("selected");
    			 $(this).siblings("dd").eq(0).css("display","block");
    		 }
    	 });
    	  
      });
};

index.logout=function(){
	layer.confirm('确认退出吗？', {
		  btn: ['确认','取消'] //按钮
		}, function(){
			location.href=getBasePath()+"/loginout";
		}, function(){});
	
};
	
