$(function(){
  $("#addAdmin").click(function(){
	  owl.openPage(this,"/system/addAdminPage","添加管理员");
  });
  adminList.queryAdminList(adminList.page,adminList.pageSize);
});
var adminList={};
adminList.page=1;
adminList.pageSize=20;
adminList.queryAdminList=function(page,pageSize){
	var param = {};
	param.page=page;
	param.pageSize=pageSize;
	adminList.page=page;
	adminList.pageSize=pageSize;
	owl.ajaxRequest("/system/adminList",param,function(e){
  	$("#adminList").html("");
  	$("#adminTemplate").tmpl( e.data ).appendTo("#adminList"); 
  	adminList.modifyAdmin();
  	adminList.delAdmin();
  	laypage({
  	  cont: 'pageDiv',
  	  curr: page || 1, //当前页
  	  skin: '',
  	  groups: 5, //连续显示分页数
  	  pages: e.data.pageCount, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
  	  jump: function(e, first){ //触发分页后的回调
  	  if(!first){ //一定要加此判断，否则初始时会无限刷新
  		adminList.queryAdminList(e.curr,pageSize);
  	  }
  	  }
  	});
    });
};
adminList.modifyAdmin=function(){
	$(".modifyUser").click(function(){
		var userId=$(this).attr("user");
		owl.openPage(this,"/system/modifyAdminPage?userId="+userId,"修改管理员");
	});
};
adminList.delAdmin=function(){
	$(".delUser").click(function(){
		var userId=$(this).attr("user");
		layer.confirm('确认删除该用户吗？', {
			  btn: ['确认','取消'] //按钮
			}, function(){
				var param={};
				param.userId=userId;
				owl.ajaxRequest("/system/delAdmin",param,function(e){
					layer.msg(e.info);
					adminList.queryAdminList(adminList.page,adminList.pageSize);
				});
			}, function(){});
		
	});
};