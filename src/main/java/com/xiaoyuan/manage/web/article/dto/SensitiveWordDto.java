package com.xiaoyuan.manage.web.article.dto;

import java.util.Date;

public class SensitiveWordDto {
	private Long wordId;
	private String word;
	private Date createTime;
	public Long getWordId() {
		return wordId;
	}
	public void setWordId(Long wordId) {
		this.wordId = wordId;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
