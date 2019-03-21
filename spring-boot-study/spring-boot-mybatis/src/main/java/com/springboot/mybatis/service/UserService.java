package com.springboot.mybatis.service;

import com.springboot.mybatis.entity.Course;
import com.springboot.mybatis.entity.User;

import java.util.List;

public interface UserService  {
    List<User> selectAll();

    User getOne(long userId);

    User insert(User user);

    void update(User user);

    void delete(long userId);



}