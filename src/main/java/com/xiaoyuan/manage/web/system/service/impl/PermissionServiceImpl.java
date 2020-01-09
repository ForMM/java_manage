package com.xiaoyuan.manage.web.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyuan.manage.util.Help;
import com.xiaoyuan.manage.web.dao.PermissionMapper;
import com.xiaoyuan.manage.web.dao.RoleMapper;
import com.xiaoyuan.manage.web.dao.SystemUserMapper;
import com.xiaoyuan.manage.web.entity.SystemUser;
import com.xiaoyuan.manage.web.system.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{
	private static final Logger log= LoggerFactory.getLogger(PermissionServiceImpl.class);
	@Autowired
	private SystemUserMapper systemUserMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
	@Override
	public Map<String,Object> authorization(Long userId) {
		// TODO Auto-generated method stub
		Map<String,Object>  resultMap = new HashMap<String,Object> ();
		if(Help.isNull(userId)){
			return resultMap;
		}
		SystemUser userAccount = systemUserMapper.selectByPrimaryKey(userId);
		if(Help.isNotNull(userAccount)){
			List<String> roleNames = roleMapper.findRoleNamesByUserId(userId);
			List<String> permissions = permissionMapper.findPermissionsByUserId(userId);
			permissions.add("/system/userMenus");
			permissions.add("/system/userMenuTree");
			resultMap.put("roleNames", roleNames);
			resultMap.put("permissions", permissions);
		}
		
		return resultMap;
	}
      
}
