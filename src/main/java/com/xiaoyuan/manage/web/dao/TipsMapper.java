package com.xiaoyuan.manage.web.dao;

import com.xiaoyuan.manage.web.entity.Tips;

public interface TipsMapper {
    int deleteByPrimaryKey(Long nTipsId);

    int insert(Tips record);

    int insertSelective(Tips record);
}