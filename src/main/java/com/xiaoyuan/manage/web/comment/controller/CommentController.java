package com.xiaoyuan.manage.web.comment.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoyuan.manage.log.BKLogger;
import com.xiaoyuan.manage.util.Result;
import com.xiaoyuan.manage.web.comment.Model.CommentListModel;
import com.xiaoyuan.manage.web.comment.service.CommentService;

@Controller
public class CommentController {
	BKLogger logger = BKLogger.getLogger(CommentController.class);
	private static final Logger log= LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/commentListPage")
    public String commentListPage() {
        return "comment/comment-list";
    }
	
	 /**
	  * 查询评论列表
	  * */
	 @RequestMapping("/commentList")
	 @ResponseBody
	 public Object commentListController(HttpServletRequest request, Model model,CommentListModel commentListModel){
		 Result result =null;
		 try{
			 result = commentService.commentList(commentListModel);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("查询评论列表失败", ex);
		 }
		 return logger.infobk("评论列表", result);
	 }
	
	
}
