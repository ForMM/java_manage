$(function(){
	
	var courseTypeType=$("#courseTypeType").val()==0?"":$("#courseTypeType").val();
	courseTypeList.search(courseTypeType);
	
	$("#pageSize").on("change",function(){
		courseTypeList.page=1;
		courseTypeList.search(courseTypeType);
	});
	
	$("#btn-addComment").on("click",function(){
		var courseTypeName = $("#input-comment").val();
		courseTypeList.addCourseType(courseTypeName);
	});
	
});
var courseTypeList={};
courseTypeList.page=1;
courseTypeList.pageSize=10;
courseTypeList.search=function(courseTypeType,beginDate,endDate,keyword){
	var param={};
	var keywords = $.trim($("#keywords").val());
	param.keywords=keywords;
	param.page=courseTypeList.page;
	courseTypeList.pageSize=$("#pageSize").val();
	param.pageSize=courseTypeList.pageSize;
	param.courseTypeType=courseTypeType;
	param.beginDate=beginDate;
	param.endDate=endDate;
	param.keyword=keyword;
	owl.ajaxRequest("/courseTypeList",param,function(e){
		//alert(JSON.stringify(e));
		$("#userListTotal").text(e.data.total);
		$("#courseTypeList").html("");
	  	$("#userListTemplate").tmpl( e.data.dataList ).appendTo("#courseTypeList"); 
	  	laypage({
	    	  cont: 'pageDiv',
	    	  curr: courseTypeList.page || 1, //当前页
	    	  skin: '',
	    	  groups: 5, //连续显示分页数
	    	  pages: e.data.pageCount, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
	    	  jump: function(e, first){ //触发分页后的回调
	    	  if(!first){ //一定要加此判断，否则初始时会无限刷新
	    		courseTypeList.page=e.curr;
	    		courseTypeList.search();
	    	  }
	    	  }
	    	});
	});
};
courseTypeList.addCourseType = function(courseTypeName){
	if(courseTypeName == "" || courseTypeName == null){
		layer.msg('课堂类别不能为空！');
		return false;
	}
	
	var confirmIndex = layer.confirm('您确定要添加此课堂类别？', {
		  btn: ['确定','取消'] //按钮
		}, function(){
			owl.ajaxRequest("/addCourseType",{"courseTypeName":courseTypeName},function(e){
				layer.close(confirmIndex);
				layer.msg('添加成功！');
				courseTypeList.search();
			});

		}, function(){
			layer.close(confirmIndex);
		});
}

