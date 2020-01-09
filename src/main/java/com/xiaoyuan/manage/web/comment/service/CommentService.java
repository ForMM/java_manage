package com.xiaoyuan.manage.web.comment.service;

import com.xiaoyuan.manage.util.Result;
import com.xiaoyuan.manage.web.comment.Model.CommentListModel;

public interface CommentService {

	public Result commentList(CommentListModel commentListModel);
	 
	 public Result commentVerify(Long commentId,Integer status);
	
}
