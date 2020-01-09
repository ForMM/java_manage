package com.xiaoyuan.manage.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xiaoyuan.manage.web.entity.UserFans;

public interface UserFansMapper {
    int deleteByPrimaryKey(Long nUserfansId);

    int insert(UserFans record);

    int insertSelective(UserFans record);

    UserFans selectByPrimaryKey(Long nUserfansId);

    int updateByPrimaryKeySelective(UserFans record);

    int updateByPrimaryKey(UserFans record);
    
    List<UserFans> findByParam(Map<String, Object> param);
	int countByParam(Map<String, Object> param);
	void deleteByUserIdAndFansId(@Param("userId") Long userId,@Param("fansId") Long fansId);
}