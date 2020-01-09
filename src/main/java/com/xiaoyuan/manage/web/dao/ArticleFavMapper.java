package com.xiaoyuan.manage.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xiaoyuan.manage.web.entity.ArticleFav;

public interface ArticleFavMapper {
    int insert(ArticleFav record);

    int insertSelective(ArticleFav record);

	void deleteByArticleIdAndUserId(@Param("userId")Long user, @Param("articleId")Long articleId);

	List<ArticleFav> findByUserIdAndArticleId(@Param("userId")Long user, @Param("articleId")Long articleId);

	List<ArticleFav> findByParam(Map<String, Object> param);
	int countByParam(Map<String, Object> param);
}