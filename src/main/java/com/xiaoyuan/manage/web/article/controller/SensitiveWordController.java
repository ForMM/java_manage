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
import com.xiaoyuan.manage.web.article.service.SensitiveWordService;


@Controller
public class SensitiveWordController{
	BKLogger logger = BKLogger.getLogger(ArticleController.class);
	private static final Logger log= LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private SensitiveWordService sensitiveWordService;
	/**
	 * 敏感词列表界面
	 * */
	@RequestMapping("/sensitiveListPage")
    public String sensitiveListPage() {
        return "article/sensitive-list";
    }
	
	/**
	 * 敏感词列表
	 * */
	@RequestMapping("/sensitiveList")
	@ResponseBody
	public Object sensitiveListController(HttpServletRequest request, Model model,Integer pageSize,Integer page,String keyword){		 
		Result result = null;
		try{
			result = sensitiveWordService.senWordList(keyword, pageSize, page);
		}catch(Exception e){
			 log.error("获取敏感词列表失败！");
			 log.error("获取敏感词列表失败！", e);
			 result=new Result(); 
		}
		 return logger.infobk("敏感词列表", result);
	}
	
	/**
	 *新增 敏感词
	 * */
	@RequestMapping("/insertSensitive")
	@ResponseBody
	public Object insertSensitiveController(HttpServletRequest request, Model model,String word){		 
		Result result = null;
		try{
			result = sensitiveWordService.insertSenWord(word);
		}catch(Exception e){
			 log.error("新增敏感词失败！");
			 log.error("新增敏感词失败！", e);
			 result=new Result(); 
		}
		 return logger.infobk("敏感词列表", result);
	}
	
	/**
	 *新删除敏感词
	 * */
	@RequestMapping("/deleteSensitive")
	@ResponseBody
	public Object deleteSensitiveController(HttpServletRequest request, Model model,Long wordId){		 
		Result result = null;
		try{
			result = sensitiveWordService.deleteSenWord(wordId);
		}catch(Exception e){
			 log.error("删除敏感词失败！");
			 log.error("删除敏感词失败！", e);
			 result=new Result(); 
		}
		return logger.infobk("删除敏感词", result);
	}
}
