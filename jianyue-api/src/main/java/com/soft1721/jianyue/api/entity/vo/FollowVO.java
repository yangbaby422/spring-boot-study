package com.soft1721.jianyue.api.entity.vo;

import lombok.Data;

@Data
public class FollowVO {
    private Integer toUId;
    private String nickname;
    private String avatar;

    public Integer getToUId() {
        return toUId;
    }

    public void setToUId(Integer toUId) {
        this.toUId = toUId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
