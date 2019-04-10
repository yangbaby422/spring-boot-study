package com.soft1721.jianyue.api.service;

import com.soft1721.jianyue.api.entity.User;
import com.soft1721.jianyue.api.entity.dto.UserDTO;

public interface UserService {
    //根据手机号获取用户信息
    User getUserByMobile(String mobile);
    //登录方式 @param userDTO
    int signIn(UserDTO userDTO);
    //根据id获取用户信息
    User getUserById(int id);
    //修改用户
    void updateUser(User user);
    //用户注册方法
    void signUp(UserDTO userDTO);
}
