package com.xiaoyuan.manage.web.system.controller;

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
import com.xiaoyuan.manage.web.system.model.AddAdminModel;
import com.xiaoyuan.manage.web.system.model.AddGroupModel;
import com.xiaoyuan.manage.web.system.model.AdminListModel;
import com.xiaoyuan.manage.web.system.model.GroupListModel;
import com.xiaoyuan.manage.web.system.model.ModifyAdminModel;
import com.xiaoyuan.manage.web.system.model.ModifyGroupModel;
import com.xiaoyuan.manage.web.system.service.SystemService;

@Controller
@RequestMapping("/system")
public class SystemController {
	BKLogger logger = BKLogger.getLogger(SystemController.class);
	private static final Logger log= LoggerFactory.getLogger(SystemController.class);
	@Autowired
	private SystemService systemService;
	/**
	  * 后台登录
	  * */
	 @RequestMapping("/login")
	 @ResponseBody
	 public Object login(HttpServletRequest request, Model model,String loginName, String loginPassword){
		 Result result =null;
		 try{
			 result = systemService.login(request,loginName, loginPassword);
		 }catch(Exception ex){
			 result=new Result();
			 log.error("登录失败", ex);
		 }
		 return logger.infobk("登录列表", result);
	 }
	 /**
	  * 获取当前登录用户菜单
	  * */
	 @RequestMapping(value = "/userMenus")
	 @ResponseBody
	 public Object userMenusController(HttpServletRequest request, Model model){
		 Result result=null;
		 try{
			 log.debug("获取当前登录用户菜单");
			 result = systemService.getUserMenus(request);
		 }catch(Exception ex){
			 result = new Result();
			 log.error("获取当前登录用户菜单失败", ex);
		 }
		return (logger.infobk("获取当前登录用户菜单输出列表", result));
	 }
 	@RequestMapping("/groupPage")
    public String rolePage() {
        return "system/group";
    }
    @RequestMapping("/addGroupPage")
    public String addGroupPage() {
        return "system/group-add";
    }
	//群组列表
	 @RequestMapping(value = "/groupList")
	 @ResponseBody
	 public Object groupListController(HttpServletRequest request, Model model,GroupListModel groupListModel){
		 Result result=null;
		 try{
			 result = systemService.groupList(groupListModel);
		 }catch(Exception ex){
			 result = new Result();
			 log.error("查询群组列表失败", ex);
		 }
		 return (logger.infobk("查询群组列输出列表", result));
	 }
	//管理组页菜单树
		 @RequestMapping(value = "/userMenuTree")
		 @ResponseBody
		 public Object userMenuTreeController(HttpServletRequest request, Model model,Long roleCode){
			 Result result=null;
			 try{
				 SystemUser user = (SystemUser) request.getSession().getAttribute("user");
				 result = systemService.menuTree(user.getnUserId(),roleCode);
			 }catch(Exception ex){
				 result = new Result();
				 log.error("获取菜单树失败", ex);
			 }
			 return (logger.infobk("获取菜单树输出列表", result));
		 }
		//添加管理组
		 @RequestMapping(value = "/addGroup")
		 @ResponseBody
		 public Object addGroupController(HttpServletRequest request, Model model,AddGroupModel addGroupModel){
			 Result result=null;
			 try{
				 result = systemService.addGroup(request,addGroupModel);
			 }catch(Exception ex){
				 result = new Result();
				 log.error("添加管理组失败", ex);
			 }
			 return (logger.infobk("添加管理组输出列表", result));
		 }
		 /**
		  * 跳转到修改群组页面
		  * */
		 @RequestMapping(value = "/modifyGroupPage")
		 public String modifyGroupPage(HttpServletRequest request, Model model,Long groupId){
			 request.getSession().setAttribute("groupId", groupId);
			 return "system/group-modify";
		 }
		 @RequestMapping(value = "/roleDetail")
		 @ResponseBody
		 public Object addGroup(HttpServletRequest request, Model model){
			 Result result=null;
			 try{
				Long groupId = (Long) request.getSession().getAttribute("groupId");
				result = systemService.roleDetail(groupId );
			 }catch(Exception ex){
			 }
			 return (logger.infobk("session role", result));
		 }
		 @RequestMapping(value = "/modifyGroup")
		 @ResponseBody
		 public Object modifyGroupController(HttpServletRequest request, Model model,ModifyGroupModel modifyGroupModel){
			 Result result=null;
			 try{
				 result = systemService.modifyGroup(request,modifyGroupModel);
			 }catch(Exception ex){
				 result = new Result();
				 log.error("修改管理组失败", ex);
			 }
			 return (logger.infobk("修改管理组输出列表", result));
		 }
		//删除群组
		 @RequestMapping(value = "/delGroup")
		 @ResponseBody
		 public Object delGroupController(HttpServletRequest request, Model model,Long groupId){
			 Result result=null;
			 try{
				 result = systemService.delGroup(groupId);
			 }catch(Exception ex){
				 result = new Result();
				 log.error("删除群组失败", ex);
			 }
			 return (logger.infobk("删除群组输出列表", result));
		 }
		 /**
		  * 跳转到用户列表页面
		  * */
		 @RequestMapping(value = "/adminListPage")
		 public String adminListPage(HttpServletRequest request, Model model){
			 return "system/admin-list";
		 }
		 @RequestMapping(value = "/adminList")
		 @ResponseBody
		 public Object adminListController(HttpServletRequest request, Model model,AdminListModel adminListModel){
			 Result result=null;
			 try{
				 result = systemService.adminList(adminListModel); 
			 }catch(Exception ex){
				 result = new Result();
				 log.error("添加管理员失败", ex);
			 }
			return (logger.infobk("添加管理员输出列表", result));
		 }
		 /**
		  * 跳转到添加用户页面
		  * */
		 @RequestMapping(value = "/addAdminPage")
		 public String addAdminPage(HttpServletRequest request, Model model){
			 return "system/admin-add";
		 }
		 @RequestMapping(value = "/allGroups")
		 @ResponseBody
		 public Object allGroups(HttpServletRequest request, Model model){
			 Result result = systemService.groupList(null);
			return (logger.infobk("添加管理员输出列表", result));
		 }
		 @RequestMapping(value = "/addAdmin")
		 @ResponseBody
		 public Object addAdminController(HttpServletRequest request, Model model,AddAdminModel addAdminModel){
			 Result result=null;
			 try{
				 result = systemService.addAdmin(addAdminModel); 
			 }catch(Exception ex){
				 result = new Result();
				 log.error("添加管理员失败", ex);
			 }
			 return (logger.infobk("添加管理员输出列表", result));
		 }
		 @RequestMapping(value = "/modifyAdminPage")
		 public String modifyAdminPage(HttpServletRequest request, Model model,Long userId){
			 Result result = systemService.adminInfo(userId);
			 request.getSession().setAttribute("adminInfo", result);
			 return "system/admin-modify";
		 }
		 @RequestMapping(value = "/adminInfo")
		 @ResponseBody
		 public Object adminInfo(HttpServletRequest request, Model model,AddAdminModel addAdminModel){
			 Result result= (Result) request.getSession().getAttribute("adminInfo");
			 return (logger.infobk("admin输出列表", result));
		 }
		 @RequestMapping(value = "/modifyAdmin")
		 @ResponseBody
		 public Object modifyAdminController(HttpServletRequest request, Model model,ModifyAdminModel modifyAdminModel){
			 Result result=null;
			 try{
				 result = systemService.modifyAdmin(modifyAdminModel); 
			 }catch(Exception ex){
				 result = new Result();
				 log.error("修改管理员失败", ex);
			 }
			 return(logger.infobk("修改管理员输出列表", result));
		 }
		 @RequestMapping(value = "/delAdmin")
		 @ResponseBody
		 public Object delAdminController(HttpServletRequest request, Model model,Long userId){
			 Result result=null;
			 try{
				 result = systemService.delAdmin(userId); 
			 }catch(Exception ex){
				 result = new Result();
				 log.error("删除管理员失败", ex);
			 }
			 return(logger.infobk("删除管理员输出列表", result));
		 }
}
