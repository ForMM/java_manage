$(function(){
	sensitiveList.search();
	$("#searchFinanceBtn").click(function(){
		sensitiveList.page=1;
		sensitiveList.search();
	});
	$("#insertBtn").click(function(){
		sensitiveList.insert();
	});
	$("#pageSize").on("change",function(){
		sensitiveList.page=1;
		sensitiveList.search();
	});
})

var sensitiveList={};
sensitiveList.page=1;
sensitiveList.pageSize=20;
sensitiveList.search=function(){
	var keyword = $("#keyword").val();
	var param={};	
	param.keyword = keyword;
	param.page=sensitiveList.page;
	sensitiveList.pageSize=$("#pageSize").val();
	param.pageSize=sensitiveList.pageSize;	
	owl.ajaxRequest("/sensitiveList",param,function(e){
//		console.log(JSON.stringify(e));
		$("#sensitiveListTotal").text(e.data.total);
		$("#sensitiveList").html("");
	  	$("#sensitiveListTemplate").tmpl( e.data.dataList ).appendTo("#sensitiveList"); 
	  	laypage({
	    	  cont: 'pageDiv',
	    	  curr: sensitiveList.page || 1, //当前页
	    	  skin: '',
	    	  groups: 5, //连续显示分页数
	    	  pages: e.data.pageCount, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
	    	  jump: function(e, first){ //触发分页后的回调
	    	  if(!first){ //一定要加此判断，否则初始时会无限刷新
	    		sensitiveList.page=e.curr;
	    		sensitiveList.search();
	    	  }
	    	  }
	    	});
	});
};
sensitiveList.insert=function(){
	var sensitiveWord = $("#keywordStr").val();
	if(sensitiveWord == ''){
		layer.msg('请先输入敏感词！');
		return false;
	}
	owl.ajaxRequest("/insertSensitive",{word:sensitiveWord},function(e){
		//alert(JSON.stringify(e));
		layer.msg('添加成功！');
		sensitiveList.search();	  
	});
}
sensitiveList.deleteWord=function(obj,id){
	layer.confirm('确认要删除吗？',function(index){		
		owl.ajaxRequest("/deleteSensitive",{"wordId":id},function(e){			
//			$(obj).parents("tr").remove();
			layer.msg('已删除!');	
			sensitiveList.search();
		   });
	});
}