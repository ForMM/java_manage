package com.xiaoyuan.manage.web.dao;

import java.util.List;
import java.util.Map;

import com.xiaoyuan.manage.web.entity.CourseType;

public interface CourseTypeMapper {
    int deleteByPrimaryKey(Long nCourseTypeId);

    int insert(CourseType record);

    int insertSelective(CourseType record);

    CourseType selectByPrimaryKey(Long nCourseTypeId);

    int updateByPrimaryKeySelective(CourseType record);

    int updateByPrimaryKey(CourseType record);

	List<CourseType> findAll();
	
	List<CourseType> findCourseTypeList(Map<String,Object> param);
	int countCourseTypeList(Map<String,Object> param);
	
	int maxIndex();
}