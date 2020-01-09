$(function(){
	
	var articleType=$("#articleType").val()==0?"":$("#articleType").val();
	articleList.search(articleType);
	
	$("#pageSize").on("change",function(){
		articleList.page=1;
		articleList.search(articleType);
	});
	
	$("#articleType").on("change",function(){
		var value = $(this).val();
		articleList.page=1;
		articleList.search(value);
	});
	
	$("#searchBtn").on("click",function(){
		var beginDate =$("#datemin").val();
		var endDate = $("#datemax").val();
		var keyword = $("#keywords").val();
		var articleType=$("#articleType").val()==0?"":$("#articleType").val();
		articleList.page=1;
		articleList.search(articleType,beginDate,endDate,keyword);
	});
	
});
var articleList={};
articleList.page=1;
articleList.pageSize=10;
articleList.search=function(articleType,beginDate,endDate,keyword){
	var param={};
	var keywords = $.trim($("#keywords").val());
	param.keywords=keywords;
	param.page=articleList.page;
	articleList.pageSize=$("#pageSize").val();
	param.pageSize=articleList.pageSize;
	param.articleType=articleType;
	param.beginDate=beginDate;
	param.endDate=endDate;
	param.keyword=keyword;
	owl.ajaxRequest("/articleList",param,function(e){
		//alert(JSON.stringify(e));
		$("#userListTotal").text(e.data.total);
		$("#articleList").html("");
	  	$("#userListTemplate").tmpl( e.data.dataList ).appendTo("#articleList"); 
	  	laypage({
	    	  cont: 'pageDiv',
	    	  curr: articleList.page || 1, //当前页
	    	  skin: '',
	    	  groups: 5, //连续显示分页数
	    	  pages: e.data.pageCount, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
	    	  jump: function(e, first){ //触发分页后的回调
	    	  if(!first){ //一定要加此判断，否则初始时会无限刷新
	    		articleList.page=e.curr;
	    		articleList.search();
	    	  }
	    	  }
	    	});
	});
};

