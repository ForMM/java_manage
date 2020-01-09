package com.xiaoyuan.manage.web.dao;

import org.apache.ibatis.annotations.Param;

import com.xiaoyuan.manage.web.entity.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Long nRolePermission);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Long nRolePermission);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

	void deleteByRoleCode(@Param("roleCode")Long roleCode);
}