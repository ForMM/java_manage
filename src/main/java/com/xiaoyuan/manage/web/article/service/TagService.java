package com.xiaoyuan.manage.web.article.service;

import com.xiaoyuan.manage.util.Result;
import com.xiaoyuan.manage.web.comment.Model.TagListModel;

public interface TagService {
	 
	 public Result tagList(TagListModel tagListModel);
	 
	 public Result addTag(String tagName);
	 
	 public Result updateTag(Long tagId,String tagName);
	 
	 public Result deleteTag(Long tagId);
	 
	 public Result tagVerify(Long tagId,Integer status);
	 
	 
}
