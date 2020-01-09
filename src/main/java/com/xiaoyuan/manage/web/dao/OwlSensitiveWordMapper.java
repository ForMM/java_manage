package com.xiaoyuan.manage.web.dao;

import java.util.List;
import java.util.Map;

import com.xiaoyuan.manage.web.entity.OwlSensitiveWord;

public interface OwlSensitiveWordMapper {
    int deleteByPrimaryKey(Long nSensitiveId);

    int insert(OwlSensitiveWord record);

    int insertSelective(OwlSensitiveWord record);

    OwlSensitiveWord selectByPrimaryKey(Long nSensitiveId);

    int updateByPrimaryKeySelective(OwlSensitiveWord record);

    int updateByPrimaryKey(OwlSensitiveWord record);
    
    public int countByParam(Map<String,Object> param);
    public List<OwlSensitiveWord> findByParam(Map<String,Object> param);
  
}