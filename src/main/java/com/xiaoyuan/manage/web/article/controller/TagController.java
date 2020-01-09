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
import com.xiaoyuan.manage.web.article.service.TagService;
import com.xiaoyuan.manage.web.comment.Model.TagListModel;

@Controller
public class TagController {
	BKLogger logger = BKLogger.getLogger(TagController.class);
	private static final Logger log= LoggerFactory.getLogger(TagController.class);
	

	@Autowired
	private TagService tagService;
	
	@RequestMapping("/tagListPage")
    public String tagListPage() {
        return "article/tag-list";
    }
	
	
	 /**
	  * 查询标签列表
	  * */
	 @RequestMapping("/tagList")
	 @ResponseBody
	 public Object tagListController(HttpServletRequest request, Model model,TagListModel tagListModel){
		 Result result =null;
		 try{
			 result = tagService.tagList(tagListModel);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("查询文章列表失败", ex);
		 }
		 return logger.infobk("查询标签列表", result);
	 }
	 
	 
	 /**
	  * 添加标签
	  * */
	 @RequestMapping("/addTag")
	 @ResponseBody
	 public Object addTagController(HttpServletRequest request, Model model,String tagName){
		 Result result =null;
		 try{
			 result = tagService.addTag(tagName);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("添加标签失败", ex);
		 }
		 return logger.infobk("添加标签", result);
	 }
	 
	 /**
	  * 修改标签
	  * */
	 @RequestMapping("/updateTag")
	 @ResponseBody
	 public Object updateTagController(HttpServletRequest request, Model model,Long tagId,String tagName){
		 Result result =null;
		 try{
			 result = tagService.updateTag(tagId,tagName);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("更新标签失败", ex);
		 }
		 return logger.infobk("更新标签", result);
	 }
	 
	 /**
	  * 删除标签
	  * */
	 @RequestMapping("/deleteTag")
	 @ResponseBody
	 public Object deleteTagController(HttpServletRequest request, Model model,Long tagId){
		 Result result =null;
		 try{
			 result = tagService.deleteTag(tagId);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("删除标签失败", ex);
		 }
		 return logger.infobk("删除标签", result);
	 }
	 
	 /**
	  * 审核用户
	  * */
	 @RequestMapping("/verifyTag")
	 @ResponseBody
	 public Object verifyTagController(HttpServletRequest request, Model model,Long tagId, Integer status){
		 Result result =null;
		 try{
			 result = tagService.tagVerify(tagId, status);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("查询文章列表失败", ex);
		 }
		 return logger.infobk("文章列表", result);
	 }
	
}
