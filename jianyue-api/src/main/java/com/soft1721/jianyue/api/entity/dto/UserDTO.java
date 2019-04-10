package com.soft1721.jianyue.api.entity.dto;
import lombok.Data;

/**
 * Created by 洋酱 on 2019/4/1.
 */
@Data
public class UserDTO {
    private  String mobile;
    private  String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
