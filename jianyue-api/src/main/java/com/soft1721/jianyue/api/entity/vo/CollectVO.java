package com.soft1721.jianyue.api.entity.vo;

import lombok.Data;

import java.util.Date;
@Data
public class CollectVO {
    private Integer aId;
    private String title;
    private Date createTime;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
