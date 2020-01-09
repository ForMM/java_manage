package com.xiaoyuan.manage.web.article.model;

import java.util.Date;

public class SensitiveWordModel {
	private Long sensitiveWordId;
	private String sensitiveWord;
	private Date createTime;
	private Date updateTime;
	private Long createId;
	private Integer cStatus;
	public Long getSensitiveWordId() {
		return sensitiveWordId;
	}
	public void setSensitiveWordId(Long sensitiveWordId) {
		this.sensitiveWordId = sensitiveWordId;
	}
	public String getSensitiveWord() {
		return sensitiveWord;
	}
	public void setSensitiveWord(String sensitiveWord) {
		this.sensitiveWord = sensitiveWord;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Long getCreateId() {
		return createId;
	}
	public void setCreateId(Long createId) {
		this.createId = createId;
	}
	public Integer getcStatus() {
		return cStatus;
	}
	public void setcStatus(Integer cStatus) {
		this.cStatus = cStatus;
	}
	
	
}
