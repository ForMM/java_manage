package com.xiaoyuan.manage.web.dao;

import com.xiaoyuan.manage.web.entity.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(Long nMessageId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Long nMessageId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}