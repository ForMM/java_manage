package com.xiaoyuan.manage.content;

public class FinVal {
	
	/**
	 * 标签类型：
	 * 系统文章标签
	 * */
	public static final int 	TAG_TYPE_SYSTEM = 1;
	
	/**
	 * 标签类型：
	 * 用户自定义标签
	 * */
	public static final int 	TAG_TYPE_IDENTIFY = 2;
	
	
	
	/**
	 * 默认翻页数据
	 * 页码
	 * */
	public static final int DEFAULT_PAGE=1;
	
	/**
	 * 默认翻页数据
	 * 每页条数
	 * */
	public static final int DEFAULT_PAGESIZE=20;
	
	public static final int DEFAULT_TRUE=1;
	public static final int DEFAULT_FALSE=0;
	
	
	/**
	 * 认证状态：未提交
	 * */
	public static final Integer AUTH_STATUS_UN_SUBMIT=0;
	/**
	 * 认证状态：提交
	 * */
	public static final Integer AUTH_STATUS_SUBMIT=1;
	/**
	 * 认证状态：认证成功
	 * */
	public static final Integer AUTH_STATUS_SUCCESS=2;
	/**
	 * 认证状态：认证失败
	 * */
	public static final Integer AUTH_STATUS_FAILURE=3;

	/**
	 * 课程状态：1即将开始
	 * */
	public static final Integer COURSE_STATU_BEFORE=1;
	/**
	 * 课程状态：2直播中
	 * */
	public static final Integer COURSE_STATU_BGIN=2;
	/**
	 * 课程状态：2已结束
	 * */
	public static final Integer COURSE_STATU_END=3;
	
}
