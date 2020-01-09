package com.xiaoyuan.manage.web.dao;

import java.util.List;
import java.util.Map;

import com.xiaoyuan.manage.web.entity.Tag;

public interface TagMapper {
    int deleteByPrimaryKey(Long nTagId);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Long nTagId);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
    
    List<Tag> findTagList(Map<String,Object> param);
    int countTagList(Map<String,Object> param);
    
}