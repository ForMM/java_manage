$(function(){
  $("#addGroup").click(function(){
	  $(this).attr("data-href",getBasePath()+"/system/addGroupPage");
	  Hui_admin_tab(this);
  });
  groupList.queryGroupList(groupList.page,groupList.pageSize);
  $("#pageSize").on("change",function(){
	  groupList.page=1;
	  groupList.pageSize = $(this).val();
	  groupList.queryGroupList(groupList.page,groupList.pageSize);
  });
  
});

var groupList={};
groupList.page=1;
groupList.pageSize=20;
groupList.queryGroupList=function(page,pageSize){
	var param = {};
	param.page=page;
	param.pageSize=pageSize;
	groupList.page=page;
	groupList.pageSize=pageSize;
	owl.ajaxRequest("/system/groupList",param,function(e){
  	$("#groupList").html("");
  	$("#groupListTotal").html(e.data.count);
  	$("#groupTemplate").tmpl( e.data ).appendTo("#groupList"); 
  	groupList.modifyGroup();
  	groupList.delGroup();
  	laypage({
  	  cont: 'pageDiv',
  	  curr: page || 1, //当前页
  	  skin: '',
  	  groups: 5, //连续显示分页数
  	  pages: e.data.pageCount, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
  	  jump: function(e, first){ //触发分页后的回调
  	  if(!first){ //一定要加此判断，否则初始时会无限刷新
  		groupList.queryGroupList(e.curr,pageSize);
  	  }
  	  }
  	});
    });
};
groupList.modifyGroup=function(){
	$(".modifyGroup").click(function(){
		var groupId=$(this).attr("groupId");
		owl.openPage(this,"/system/modifyGroupPage?groupId="+groupId,"修改群组");
	});
};
groupList.delGroup=function(){
	$(".delGroup").click(function(){
		var groupId =$(this).attr("groupId");
		layer.confirm('确认删除该群组吗？', {
			  btn: ['确认','取消'] //按钮
			}, function(){
				var param={};
				param.groupId=groupId;
				owl.ajaxRequest("/system/delGroup",param,function(e){
					layer.msg(e.info);
					 groupList.queryGroupList(groupList.page,groupList.pageSize);
				});
			}, function(){});
		
	});
};