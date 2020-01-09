$(function(){
	banner.init();
	$("#save-btn").click(function(){
		banner.save();
	});
})
var banner={};
banner.save=function(){
	var data=[];
	$(".input-file").each(function(i){
		var obj = {};
		var id=this.id;
		var imgUrl=$("#"+id+"_Pre").attr("src");
		var url=$.trim($("#"+id+"_url").val());
		if(imgUrl!=''){
		var index=i+1;
		obj.imgUrl=imgUrl;
		obj.url=url;
		obj.index=index;
		data.push(obj);
		
		}
		banner.delPic(this);
	});
	owl.ajaxRequestContentType("/picture/saveBanner.do",JSON.stringify(data),"application/json",function(e){
		//alert(JSON.stringify(e));
		layer.msg("保存成功！");
	});
};
banner.init=function(){
	owl.ajaxRequest("/picture/getBanners.do",{},function(e){
		//alert(JSON.stringify(e));
		var banners = e.data.pics;
		$(".input-file").each(function(i){
			var id=this.id;
			var index=i+1;
			var bannerValue=banners[index];
			if(bannerValue){
			$("#"+id+"_Pre").attr("src",bannerValue.split("#")[0]);
			$("#"+id+"_url").val(bannerValue.split("#")[1]);
			}
			banner.delPic(this);
		});
	});
}
banner.delPic=function(obj){
	var id=obj.id;
	$("#"+id+"_delete").click(function(){
		$("#"+id+"_Pre").attr("src","");
		$("#"+id+"_url").val("");
	});
	
}
//==================================================
function change(e) {
	var picPreId=e.id+"_Pre";
	/*var formId=e.id+"_Form"
	var picPreId=e.id+"_Pre";
    var pic = document.getElementById(picPreId),
        file = e;
    $("#"+picPreId).css("display","inline");
    var ext=file.value.substring(file.value.lastIndexOf(".")+1).toLowerCase();
 
     // gif在IE浏览器暂时无法显示
     if(ext!='png'&&ext!='jpg'&&ext!='jpeg'){
         layer.alert('图片的格式必须为png或者jpg或者jpeg格式！', {
        	    skin: 'layui-layer-lan'
        	    ,closeBtn: 0
        	    ,shift: 4 //动画类型
        	  });
         $("#"+picPreId).css("display","none");
         return;
     }
     var isIE = navigator.userAgent.match(/MSIE/)!= null,
         isIE6 = navigator.userAgent.match(/MSIE 6.0/)!= null;
 
     if(isIE) {
        file.select();
        var reallocalpath = document.selection.createRange().text;
 
        // IE6浏览器设置img的src为本地路径可以直接显示图片
         if (isIE6) {
            pic.src = reallocalpath;
         }else {
            // 非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现
             pic.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\"" + reallocalpath + "\")";
             // 设置img的src为base64编码的透明图片 取消显示浏览器默认图片
             pic.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
         }
     }else {
        html5Reader(file,picPreId);
     }*/
   var load =  layer.load();
 /*  alert(getBasePath()+"/picture/uploadBanner.do");
   $("#"+formId).attr("action",getBasePath()+"/picture/uploadBanner.do");
   $("#"+formId).attr("method","post");
   $("#"+formId).submit();*/
   $.ajaxFileUpload ({
	   url:getBasePath()+"/picture/uploadBanner.do", //你处理上传文件的服务端
	   secureuri:false, //与页面处理代码中file相对应的ID值
	   fileElementId:e.id,
	   dataType: 'json', //返回数据类型:text，xml，json，html,scritp,jsonp五种
	   success: function (data) {
		   if(data.status==10000){ 
			   $("#"+picPreId).attr("src","http://"+data.data.filePath);
				  //  alert(JSON.stringify(data));
				    layer.msg("上传成功");
              }else if(data.status==10081){
              /* alert(data.info);*/
               	 layer.msg(data.info);
                 top.location.href=getBasePath()+"/user/loginPage.do";
              }else if(data.status==403){
                  /* alert(data.info);*/
             	 layer.msg(data.info);
              }else{
             	 layer.msg(data.info);
              }  
		 
	    layer.close(load);
	   },
	   error:function(){
		   layer.msg("上传失败!");
		   layer.close(load);
	   }
	 });
}
 
 function html5Reader(file,picPreId){
     var file = file.files[0];
     var reader = new FileReader();
     reader.readAsDataURL(file);
     reader.onload = function(e){
         var pic = document.getElementById(picPreId);
         pic.src=this.result;
     }
 }
