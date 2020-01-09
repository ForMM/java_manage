package com.xiaoyuan.manage.web.course.service;

import com.xiaoyuan.manage.util.Result;
import com.xiaoyuan.manage.web.course.model.AuthUserModel;
import com.xiaoyuan.manage.web.course.model.CourseModel;
import com.xiaoyuan.manage.web.course.model.CourseTypeModel;

public interface CourseService {
	public Result courseTypeList(CourseTypeModel courseTypeListModel);
	 
	 public Result addCourseType(String courseTypeName);
	 
	 public Result updateCourseType(Long courseTypeId,String courseTypeName);
	 
	 public Result deleteCourseType(Long courseTypeId);
	 
	 
	 public Result courseList(CourseModel courseModel);
	 
	 public Result authUserList(AuthUserModel authUserModel);
	 
}
