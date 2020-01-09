package com.xiaoyuan.manage.web.entity;

import java.util.Date;

public class OrgUser {
    private Long nOrgUserId;

    private Long nOrgId;

    private Long nUserId;

    private Date tCreateTime;

    public Long getnOrgUserId() {
        return nOrgUserId;
    }

    public void setnOrgUserId(Long nOrgUserId) {
        this.nOrgUserId = nOrgUserId;
    }

    public Long getnOrgId() {
        return nOrgId;
    }

    public void setnOrgId(Long nOrgId) {
        this.nOrgId = nOrgId;
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
}