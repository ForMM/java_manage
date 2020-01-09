var setting = {
		check: {
			enable: true
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		view: {
			showIcon: false,
			showLine: false
		}
	};

	var zNodes =[
		{ id:1, pId:0, name:"随意勾选 1", open:true},
		{ id:11, pId:1, name:"随意勾选 1-1", open:true},
		{ id:111, pId:11, name:"随意勾选 1-1-1"},
		{ id:112, pId:11, name:"随意勾选 1-1-2"},
		{ id:12, pId:1, name:"随意勾选 1-2", open:true},
		{ id:121, pId:12, name:"随意勾选 1-2-1"},
		{ id:122, pId:12, name:"随意勾选 1-2-2"},
		{ id:2, pId:0, name:"随意勾选 2", checked:true, open:true},
		{ id:21, pId:2, name:"随意勾选 2-1"},
		{ id:22, pId:2, name:"随意勾选 2-2", open:true},
		{ id:221, pId:22, name:"随意勾选 2-2-1", checked:true},
		{ id:222, pId:22, name:"随意勾选 2-2-2"},
		{ id:23, pId:2, name:"随意勾选 2-3"}
	];
	
	var code;
	
	function setCheck() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		type = { "Y":"ps", "N":"ps"};
		zTree.setting.check.chkboxType = type;
		showCode('setting.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "' + type.N + '" };');
	}
	function showCode(str) {
		if (!code) code = $("#code");
		code.empty();
		code.append("<li>"+str+"</li>");
	}
	
	$(document).ready(function(){
			owl.ajaxRequest("/system/userMenuTree",{},function(e){
		  	  //alert(JSON.stringify(e));
		  	  var notes=e.data.dataList;
		  	  $.fn.zTree.init($("#treeDemo"), setting, notes);
		  	  setCheck();
		    });
		
			$("#ok").click(function(){
				group.add();
			});
			  $("#cancel").click(function(){
				  owl.closePage();
			  });
	});
	
	///
	var group={};
	group.add=function(){
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		var nodes = treeObj.getCheckedNodes(true);
		var checkedMenuIds=[];
		for(var i=0;i<nodes.length;i++){
			checkedMenuIds.push(nodes[i].id);
		}
		//alert(checkedMenuIds.join("#"));
		var groupName = $.trim($("#groupName").val());
		var groupDesc = $.trim($("#groupDesc").val());
		var param={};
		param.groupName=groupName;
		param.groupDesc=groupDesc;
		param.menuIdsStr=checkedMenuIds.join("#");
		owl.ajaxRequest("/system/addGroup",param,function(e){
		  	  //alert(JSON.stringify(e));
			layer.msg(e.info);
		    });
	};