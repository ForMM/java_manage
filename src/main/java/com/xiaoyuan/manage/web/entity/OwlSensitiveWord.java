package com.xiaoyuan.manage.web.entity;

import java.util.Date;

public class OwlSensitiveWord {
    private Long nSensitiveId;

    private String cWord;

    private Date tCreateTime;

    private Date tUpdateTime;

    private Long nCreateId;

    private Long nUpdateId;

    private Integer nStatus;

    public Long getnSensitiveId() {
        return nSensitiveId;
    }

    public void setnSensitiveId(Long nSensitiveId) {
        this.nSensitiveId = nSensitiveId;
    }

    public String getcWord() {
        return cWord;
    }

    public void setcWord(String cWord) {
        this.cWord = cWord == null ? null : cWord.trim();
    }

    public Date gettCreateTime() {
        return tCreateTime;
    }

    public void settCreateTime(Date tCreateTime) {
        this.tCreateTime = tCreateTime;
    }

    public Date gettUpdateTime() {
        return tUpdateTime;
    }

    public void settUpdateTime(Date tUpdateTime) {
        this.tUpdateTime = tUpdateTime;
    }

    public Long getnCreateId() {
        return nCreateId;
    }

    public void setnCreateId(Long nCreateId) {
        this.nCreateId = nCreateId;
    }

    public Long getnUpdateId() {
        return nUpdateId;
    }

    public void setnUpdateId(Long nUpdateId) {
        this.nUpdateId = nUpdateId;
    }

    public Integer getnStatus() {
        return nStatus;
    }

    public void setnStatus(Integer nStatus) {
        this.nStatus = nStatus;
    }
}