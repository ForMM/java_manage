package com.xiaoyuan.manage.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xiaoyuan.manage.web.entity.OrgUser;

public interface OrgUserMapper {
    int deleteByPrimaryKey(Long nOrgUserId);

    int insert(OrgUser record);

    int insertSelective(OrgUser record);

    OrgUser selectByPrimaryKey(Long nOrgUserId);

    int updateByPrimaryKeySelective(OrgUser record);

    int updateByPrimaryKey(OrgUser record);

	List<OrgUser> findByUserId(@Param("userId")Long userId);
	List<OrgUser> findOrgUsers(Map<String,Object> param);
	int countOrgUsers(Map<String,Object> param);
}