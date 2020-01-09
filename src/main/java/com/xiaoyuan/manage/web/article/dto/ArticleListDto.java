package com.xiaoyuan.manage.web.article.dto;

import java.util.Date;

public class ArticleListDto {
	private Long articleId;
	private Integer articleType;
	private String articleTitle;
	private String createName;
	private Date createTime;
	private Integer articleStatus;
	
	
	public Integer getArticleStatus() {
		return articleStatus;
	}
	public void setArticleStatus(Integer articleStatus) {
		this.articleStatus = articleStatus;
	}
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	public Integer getArticleType() {
		return articleType;
	}
	public void setArticleType(Integer articleType) {
		this.articleType = articleType;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	
}
