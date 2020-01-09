package com.xiaoyuan.manage.web.article.service;

import com.xiaoyuan.manage.util.Result;
import com.xiaoyuan.manage.web.article.model.ArticleListModel;

public interface ArticleService {
	 
	 public Result articleList(ArticleListModel articleListModel);
	 
	 public Result articleVerify(Long articleId,Integer status);
	 
	 
}
