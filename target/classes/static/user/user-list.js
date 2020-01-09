$(function(){
	
	var userType=$("#userType").val()==0?"":$("#userType").val();
	userList.search(userType);
	
	$("#pageSize").on("change",function(){
		userList.page=1;
		userList.search(userType);
	});
	
	$("#userType").on("change",function(){
		var value = $(this).val();
		userList.page=1;
		userList.search(value);
	});
	
	$("#searchBtn").on("click",function(){
		var beginDate =$("#datemin").val();
		var endDate = $("#datemax").val();
		var keyword = $("#keywords").val();
		var userType=$("#userType").val()==0?"":$("#userType").val();
		userList.page=1;
		userList.search(userType,beginDate,endDate,keyword);
	});
	
});
var userList={};
userList.page=1;
userList.pageSize=10;
userList.search=function(userType,beginDate,endDate,keyword){
	var param={};
	var keywords = $.trim($("#keywords").val());
	param.keywords=keywords;
	param.page=userList.page;
	userList.pageSize=$("#pageSize").val();
	param.pageSize=userList.pageSize;
	param.userType=userType;
	param.beginDate=beginDate;
	param.endDate=endDate;
	param.keyword=keyword;
	owl.ajaxRequest("/userList",param,function(e){
		//alert(JSON.stringify(e));
		$("#userListTotal").text(e.data.total);
		$("#userList").html("");
	  	$("#userListTemplate").tmpl( e.data.dataList ).appendTo("#userList"); 
	  	laypage({
	    	  cont: 'pageDiv',
	    	  curr: userList.page || 1, //当前页
	    	  skin: '',
	    	  groups: 5, //连续显示分页数
	    	  pages: e.data.pageCount, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
	    	  jump: function(e, first){ //触发分页后的回调
	    	  if(!first){ //一定要加此判断，否则初始时会无限刷新
	    		userList.page=e.curr;
	    		userList.search();
	    	  }
	    	  }
	    	});
	});
};

