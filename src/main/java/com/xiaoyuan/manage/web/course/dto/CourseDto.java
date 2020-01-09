package com.xiaoyuan.manage.web.course.dto;

import java.util.Date;
import java.util.Map;

public class CourseDto {
	private Long courseId;
	private String courseName;
	private String courseType;
	private Date beginTime;
	private Date endTime;
	private String teacherName;
	private String orgName;
	private String schoolName;
	private Date createTime;
	private Integer count;
	private Map<String,Object> pptImgs;//layer显示相册
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Map<String, Object> getPptImgs() {
		return pptImgs;
	}
	public void setPptImgs(Map<String, Object> pptImgs) {
		this.pptImgs = pptImgs;
	}
	
	
}
