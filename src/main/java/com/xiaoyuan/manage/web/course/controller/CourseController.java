package com.xiaoyuan.manage.web.course.controller;

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
import com.xiaoyuan.manage.web.course.model.AuthUserModel;
import com.xiaoyuan.manage.web.course.model.CourseModel;
import com.xiaoyuan.manage.web.course.model.CourseTypeModel;
import com.xiaoyuan.manage.web.course.service.CourseService;

@Controller
public class CourseController {
	BKLogger logger = BKLogger.getLogger(CourseController.class);
	private static final Logger log= LoggerFactory.getLogger(CourseController.class);
	

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/courseTypePage")
    public String courseTypePage() {
        return "course/course-type";
    }
	
	
	 /**
	  * 查询课堂类别列表
	  * */
	 @RequestMapping("/courseTypeList")
	 @ResponseBody
	 public Object courseTypeListController(HttpServletRequest request, Model model,CourseTypeModel courseTypeModel){
		 Result result =null;
		 try{
			 result = courseService.courseTypeList(courseTypeModel);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("查询文章列表失败", ex);
		 }
		 return logger.infobk("文章列表", result);
	 }
	
	 
	 /**
	  * 添加课堂类别
	  * */
	 @RequestMapping("/addCourseType")
	 @ResponseBody
	 public Object addCourseTypeController(HttpServletRequest request, Model model,String courseTypeName){
		 Result result =null;
		 try{
			 result = courseService.addCourseType(courseTypeName);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("添加课堂类别失败", ex);
		 }
		 return logger.infobk("添加课堂类别", result);
	 }
	 
	 /**
	  * 修改课堂类别
	  * */
	 @RequestMapping("/updateCourseType")
	 @ResponseBody
	 public Object updateCourseTypeController(HttpServletRequest request, Model model,Long courseTypeId,String courseTypeName){
		 Result result =null;
		 try{
			 result = courseService.updateCourseType(courseTypeId,courseTypeName);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("更新课堂类别失败", ex);
		 }
		 return logger.infobk("更新课堂类别", result);
	 }
	 
	 /**
	  * 删除课堂类别
	  * */
	 @RequestMapping("/deleteCourseType")
	 @ResponseBody
	 public Object deleteCourseTypeController(HttpServletRequest request, Model model,Long courseTypeId){
		 Result result =null;
		 try{
			 result = courseService.deleteCourseType(courseTypeId);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("删除课堂类别失败", ex);
		 }
		 return logger.infobk("删除课堂类别", result);
	 }
	 
	 
	 /**
	  * 查询课堂列表
	  * */
	 @RequestMapping("/courseList")
	 @ResponseBody
	 public Object courseListController(HttpServletRequest request, Model model,CourseModel courseModel){
		 Result result =null;
		 try{
			 result = courseService.courseList(courseModel);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("查询文章列表失败", ex);
		 }
		 return logger.infobk("文章列表", result);
	 }
	 
	 
	 @RequestMapping("/courseListPage")
    public String courseListPage() {
        return "course/course-list";
    }
	 
	 @RequestMapping("/authUserPage")
	    public String authUserPage() {
	        return "course/authUser-list";
	    }
	 
	 /**
	  * 查询课堂认证人列表
	  * */
	 @RequestMapping("/authUserList")
	 @ResponseBody
	 public Object authUserListController(HttpServletRequest request, Model model,AuthUserModel authUserModel){
		 Result result =null;
		 try{
			 result = courseService.authUserList(authUserModel);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("查询文章列表失败", ex);
		 }
		 return logger.infobk("文章列表", result);
	 }
	 
	 
	
}
