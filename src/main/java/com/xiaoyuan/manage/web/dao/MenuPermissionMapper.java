package com.xiaoyuan.manage.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiaoyuan.manage.web.entity.MenuPermission;

public interface MenuPermissionMapper {
    int deleteByPrimaryKey(Long nMenuPermissionId);

    int insert(MenuPermission record);

    int insertSelective(MenuPermission record);

    MenuPermission selectByPrimaryKey(Long nMenuPermissionId);

    int updateByPrimaryKeySelective(MenuPermission record);

    int updateByPrimaryKey(MenuPermission record);
    
    List<MenuPermission> findByMenuId(@Param("menuId") Long menuId);
}