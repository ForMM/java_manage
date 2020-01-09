$(function(){
	
	var tagType=$("#tagType").val()==0?"":$("#tagType").val();
	tagList.search(tagType);
	
	$("#pageSize").on("change",function(){
		tagList.page=1;
		tagList.search(tagType);
	});
	
	$("#btn-addComment").on("click",function(){
		var tagName = $("#input-comment").val();
		tagList.addTag(tagName);
	});
	
});
var tagList={};
tagList.page=1;
tagList.pageSize=10;
tagList.search=function(tagType,beginDate,endDate,keyword){
	var param={};
	var keywords = $.trim($("#keywords").val());
	param.keywords=keywords;
	param.page=tagList.page;
	tagList.pageSize=$("#pageSize").val();
	param.pageSize=tagList.pageSize;
	param.tagType=tagType;
	param.beginDate=beginDate;
	param.endDate=endDate;
	param.keyword=keyword;
	owl.ajaxRequest("/tagList",param,function(e){
		//alert(JSON.stringify(e));
		$("#userListTotal").text(e.data.total);
		$("#tagList").html("");
	  	$("#userListTemplate").tmpl( e.data.dataList ).appendTo("#tagList"); 
	  	laypage({
	    	  cont: 'pageDiv',
	    	  curr: tagList.page || 1, //当前页
	    	  skin: '',
	    	  groups: 5, //连续显示分页数
	    	  pages: e.data.pageCount, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
	    	  jump: function(e, first){ //触发分页后的回调
	    	  if(!first){ //一定要加此判断，否则初始时会无限刷新
	    		tagList.page=e.curr;
	    		tagList.search();
	    	  }
	    	  }
	    	});
	});
};
tagList.addTag = function(tagName){
	if(tagName == "" || tagName == null){
		layer.msg('标签名不能为空！');
		return false;
	}
	
	var confirmIndex = layer.confirm('您确定要添加此标签？', {
		  btn: ['确定','取消'] //按钮
		}, function(){
			owl.ajaxRequest("/addTag",{"tagName":tagName},function(e){
				layer.close(confirmIndex);
				layer.msg('添加成功！');
				tagList.search();
			});

		}, function(){
			layer.close(confirmIndex);
		});
}
tagList.deleteTag = function(tagId){
	var confirmIndex = layer.confirm('您确定要删除此标签？', {
		  btn: ['确定','取消'] //按钮
		}, function(){
			debugger;
			owl.ajaxRequest("/deleteTag",{"tagId":tagId},function(e){
				layer.close(confirmIndex);
				layer.msg('添加成功！');
				tagList.search();
			});

		}, function(){
			layer.close(confirmIndex);
		});
}

