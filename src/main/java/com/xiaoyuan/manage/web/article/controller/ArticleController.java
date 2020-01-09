package com.xiaoyuan.manage.web.article.controller;

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
import com.xiaoyuan.manage.web.article.model.ArticleListModel;
import com.xiaoyuan.manage.web.article.service.ArticleService;

@Controller
public class ArticleController {
	BKLogger logger = BKLogger.getLogger(ArticleController.class);
	private static final Logger log= LoggerFactory.getLogger(ArticleController.class);
	

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/articleListPage")
    public String articleListPage() {
        return "article/article-list";
    }
	
	
	 /**
	  * 查询用户列表
	  * */
	 @RequestMapping("/articleList")
	 @ResponseBody
	 public Object articleListController(HttpServletRequest request, Model model,ArticleListModel articleListModel){
		 Result result =null;
		 try{
			 result = articleService.articleList(articleListModel);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("查询文章列表失败", ex);
		 }
		 return logger.infobk("文章列表", result);
	 }
	
	 /**
	  * 审核用户
	  * */
	 @RequestMapping("/verifyArticle")
	 @ResponseBody
	 public Object verifyArticleController(HttpServletRequest request, Model model,Long articleId, Integer status){
		 Result result =null;
		 try{
			 result = articleService.articleVerify(articleId, status);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("查询文章列表失败", ex);
		 }
		 return logger.infobk("审核文章输出列表", result);
	 }
	
}
