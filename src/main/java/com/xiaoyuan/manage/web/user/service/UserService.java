package com.xiaoyuan.manage.web.user.service;

import com.xiaoyuan.manage.util.Result;
import com.xiaoyuan.manage.web.user.model.UserListModel;

public interface UserService {
	 public void test();
	 
	 public Result userList(UserListModel userListModel);
	 
	 public Result userVerify(Long userId,Integer status);
	 
	 
}
