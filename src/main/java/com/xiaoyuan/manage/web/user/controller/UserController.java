package com.xiaoyuan.manage.web.user.controller;

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
import com.xiaoyuan.manage.web.entity.SystemUser;
import com.xiaoyuan.manage.web.system.service.SystemService;
import com.xiaoyuan.manage.web.user.model.UserListModel;
import com.xiaoyuan.manage.web.user.service.UserService;
@Controller
public class UserController{
	
	BKLogger logger = BKLogger.getLogger(UserController.class);
	private static final Logger log= LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private SystemService systemService;
	
	
	@RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
	
	@RequestMapping("/userListPage")
    public String userListPage() {
        return "user/user-list";
    }
	
	 /**
	  * 查询用户列表
	  * */
	 @RequestMapping("/userList")
	 @ResponseBody
	 public Object userListController(HttpServletRequest request, Model model,UserListModel userListModel){
		 Result result =null;
		 try{
			 result = userService.userList(userListModel);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("查询用户列表失败", ex);
		 }
		 return logger.infobk("用户列表", result);
	 }
	
	 /**
	  * 审核用户
	  * */
	 @RequestMapping("/verifyUser")
	 @ResponseBody
	 public Object verifyUserController(HttpServletRequest request, Model model,Long userId, Integer status){
		 Result result =null;
		 try{
			 result = userService.userVerify(userId, status);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("查询用户列表失败", ex);
		 }
		 return logger.infobk("用户列表", result);
	 }
	 @RequestMapping("/loginPage")
	    public String login() {
	        return "user/login";
	    }
	 @RequestMapping(value = "/logout")
	 public String logout(HttpServletRequest request, Model model){
		 request.getSession().removeAttribute("user");
		 return "user/login";
	 }
	 @RequestMapping(value = "/loginInfo")
	 @ResponseBody
	 public Object loginInfo(HttpServletRequest request, Model model){
		 Result result =null;
		 try{
			 result = systemService.loginInfo(request);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("查询登录信息失败", ex);
		 }
		 return logger.infobk("查询登录信息输出列表", result);
	 }
}
