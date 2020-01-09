package com.xiaoyuan.manage.web.entity;

import java.util.Date;

public class Comment {
    private Long nCommentId;

    private String cCommentContent;

    private Integer nCommentType;

    private Long nTargetId;

    private Long nUserId;

    private Date tCreateTime;

    private Byte nStatus;

    public Long getnCommentId() {
        return nCommentId;
    }

    public void setnCommentId(Long nCommentId) {
        this.nCommentId = nCommentId;
    }

    public String getcCommentContent() {
        return cCommentContent;
    }

    public void setcCommentContent(String cCommentContent) {
        this.cCommentContent = cCommentContent == null ? null : cCommentContent.trim();
    }

    public Integer getnCommentType() {
		return nCommentType;
	}

	public void setnCommentType(Integer nCommentType) {
		this.nCommentType = nCommentType;
	}

	public Long getnTargetId() {
        return nTargetId;
    }

    public void setnTargetId(Long nTargetId) {
        this.nTargetId = nTargetId;
    }

    public Long getnUserId() {
        return nUserId;
    }

    public void setnUserId(Long nUserId) {
        this.nUserId = nUserId;
    }

    public Date gettCreateTime() {
        return tCreateTime;
    }

    public void settCreateTime(Date tCreateTime) {
        this.tCreateTime = tCreateTime;
    }

    public Byte getnStatus() {
        return nStatus;
    }

    public void setnStatus(Byte nStatus) {
        this.nStatus = nStatus;
    }
}