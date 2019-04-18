package com.soft1721.jianyue.api.entity;

public class Collect {
    private Integer id;
    private Integer uId;
    private Integer aId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public Integer getAId() {
        return aId;
    }

    public void setAId(Integer aId) {
        this.aId = aId;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", uId=" + uId +
                ", aId=" + aId +
                '}';
    }
}
