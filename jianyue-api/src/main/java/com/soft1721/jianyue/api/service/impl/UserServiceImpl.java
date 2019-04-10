package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.User;
import com.soft1721.jianyue.api.entity.dto.UserDTO;
import com.soft1721.jianyue.api.mapper.UserMapper;
import com.soft1721.jianyue.api.service.UserService;
import com.soft1721.jianyue.api.util.StatusConst;
import com.soft1721.jianyue.api.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByMobile(String mobile) {

        return userMapper.getUserByMobile(mobile);
    }

    @Override
    public int signIn(UserDTO userDTO) {
        User user = userMapper.getUserByMobile(userDTO.getMobile());
        //手机号存在
        if (user != null) {
            //密码正确
            if (userDTO.getPassword().equals(user.getPassword())) {
                //账号正常
                if (user.getStatus() == 1) {
                    user.setToken(StringUtil.getUUIDString());
                    userMapper.updateUser(user);
                    return StatusConst.SUCCESS;
                } else {  //账号异常
                    return StatusConst.USER_STATUS_ERROR;
                }
            } else {  //密码错误
                return StatusConst.PASSWORD_ERROR;
            }
        } else {  //手机号不存在
            return StatusConst.USER_MOBILE_NOT_FOUND;
        }
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void signUp(UserDTO userDTO) {
        User user1 = new User();
        user1.setMobile(userDTO.getMobile());
        user1.setPassword(StringUtil.getBase64Encoder(userDTO.getPassword()));
        user1.setNickname("新用户");
        user1.setAvatar("http://ppeto2k90.bkt.clouddn.com/avatar/default.png");
        user1.setRegtime(new Date());
        user1.setStatus((short) 1);
        userMapper.insert(user1);
    }
}