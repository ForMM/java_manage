$(function(){
	
	var commentType=$("#commentType").val()==0?"":$("#commentType").val();
	commentList.search(commentType);
	
	$("#pageSize").on("change",function(){
		commentList.page=1;
		commentList.search(commentType);
	});
	
	$("#commentType").on("change",function(){
		var value = $(this).val();
		commentList.page=1;
		commentList.search(value);
	});
	
	$("#searchBtn").on("click",function(){
		var beginDate =$("#datemin").val();
		var endDate = $("#datemax").val();
		var keyword = $("#keywords").val();
		var commentType=$("#commentType").val()==0?"":$("#commentType").val();
		commentList.page=1;
		commentList.search(commentType,beginDate,endDate,keyword);
	});
	
});
var commentList={};
commentList.page=1;
commentList.pageSize=10;
commentList.search=function(commentType,beginDate,endDate,keyword){
	var param={};
	var keywords = $.trim($("#keywords").val());
	param.keywords=keywords;
	param.page=commentList.page;
	commentList.pageSize=$("#pageSize").val();
	param.pageSize=commentList.pageSize;
	param.commentType=commentType;
	param.beginDate=beginDate;
	param.endDate=endDate;
	param.keyword=keyword;
	owl.ajaxRequest("/commentList",param,function(e){
		//alert(JSON.stringify(e));
		$("#userListTotal").text(e.data.total);
		$("#commentList").html("");
	  	$("#userListTemplate").tmpl( e.data.dataList ).appendTo("#commentList"); 
	  	laypage({
	    	  cont: 'pageDiv',
	    	  curr: commentList.page || 1, //当前页
	    	  skin: '',
	    	  groups: 5, //连续显示分页数
	    	  pages: e.data.pageCount, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
	    	  jump: function(e, first){ //触发分页后的回调
	    	  if(!first){ //一定要加此判断，否则初始时会无限刷新
	    		commentList.page=e.curr;
	    		commentList.search();
	    	  }
	    	  }
	    	});
	});
};

