package com.xiaoyuan.manage.web.dao;

import java.util.List;
import java.util.Map;

import com.xiaoyuan.manage.web.entity.Comment;
import com.xiaoyuan.manage.web.entity.User;

public interface CommentMapper {
    int deleteByPrimaryKey(Long nCommentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long nCommentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

	List<Comment> findByParam(Map<String, Object> param);
	int countByParam(Map<String, Object> param);
	
	List<Comment> findCommentList(Map<String,Object> param);
    int countCommentList(Map<String,Object> param);
}