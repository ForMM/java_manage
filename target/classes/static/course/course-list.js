$(function(){
	
	var courseType=$("#courseType").val()==0?"":$("#courseType").val();
	courseList.search(courseType);
	
	$("#pageSize").on("change",function(){
		courseList.page=1;
		courseList.search(courseType);
	});
	
	$("#courseType").on("change",function(){
		var value = $(this).val();
		courseList.page=1;
		courseList.search(value);
	});
	
	$("#searchBtn").on("click",function(){
		var beginDate =$("#datemin").val();
		var endDate = $("#datemax").val();
		var keyword = $("#keywords").val();
		var courseType=$("#courseType").val()==0?"":$("#courseType").val();
		courseList.page=1;
		courseList.search(courseType,beginDate,endDate,keyword);
	});
	
});
var courseList={};
courseList.page=1;
courseList.pageSize=10;
courseList.pptImgs={};
courseList.search=function(courseType,beginDate,endDate,keyword){
	courseList.pptImgs={};
	var param={};
	var keywords = $.trim($("#keywords").val());
	param.keywords=keywords;
	param.page=courseList.page;
	courseList.pageSize=$("#pageSize").val();
	param.pageSize=courseList.pageSize;
	param.courseType=courseType;
	param.beginDate=beginDate;
	param.endDate=endDate;
	param.keyword=keyword;
	owl.ajaxRequest("/courseList",param,function(e){
		//alert(JSON.stringify(e));
		$("#courseListTotal").text(e.data.total);
		$("#courseList").html("");
	  	$("#courseListTemplate").tmpl( e.data.dataList ).appendTo("#courseList"); 
	  	
	  	var dataList = e.data.dataList;
		for(var i=0;dataList!=null&&i<dataList.length;i++){
			var course = dataList[i];
			var courseId = course.courseId;
			
			courseList.pptImgs[courseId]=course.pptImgs;
			
			 $("#photos_"+courseId).click(function(){
				 
				 var cId = $(this).attr("id").split("_")[1];
				 layer.photos({
					    photos: courseList.pptImgs[cId]
					    ,anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
					  });
	    	  });
			
			  if(course.pptImgs.data == undefined){
				  $("#photos_"+courseId).css("background-color","gray");
			  }
			}
	  	
	  	
	  	laypage({
	    	  cont: 'pageDiv',
	    	  curr: courseList.page || 1, //当前页
	    	  skin: '',
	    	  groups: 5, //连续显示分页数
	    	  pages: e.data.pageCount, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
	    	  jump: function(e, first){ //触发分页后的回调
	    	  if(!first){ //一定要加此判断，否则初始时会无限刷新
	    		courseList.page=e.curr;
	    		courseList.search();
	    	  }
	    	  }
	    	});
	  	
	  	var dataList = e.data.dataList;
	  	for(var i=0;dataList!=null&&i<dataList.length;i++){
			var course = dataList[i];
			var courseId = course.courseId;
			var hisBckgroud = $("#photos_"+courseId).css("background-color");
			  courseList.pptImgs[courseId]=course.pptImgs;
			  console.log(course.pptImgs);
//			  if(course.pptImgs.data == undefined){
//				  $("#photos_"+courseId).css("background-color","gray");
//			  }
			}
	  	
	  	
	    $(".courseImg-btn").click(function(){
			  var courseId=this.id.split("_")[1];
				layer.photos({
				    photos: courseList.pptImgs[courseId]
				    ,anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
				  });
			});
	  	
	});
};

