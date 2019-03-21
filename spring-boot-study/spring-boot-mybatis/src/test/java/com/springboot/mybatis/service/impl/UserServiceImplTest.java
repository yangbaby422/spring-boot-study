package com.springboot.mybatis.service.impl;

import com.springboot.mybatis.entity.Course;
import com.springboot.mybatis.entity.User;
import com.springboot.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Resource
    private UserService userService;
    @Test
    public void selectAll() {
        List<User> courseList=userService.selectAll();
        courseList.forEach(user -> System.out.println(user));
    }

    @Test
    public void getOne() {
        User user= userService.getOne(2);
        System.out.println(user);
    }

    @Test
    public void insert() {
        User user = new User();
        user.setMobile("13923232323");
        user.setPassword("444");
        user.setUserName("凯思");
        user.setAvatar("a.jpg");
        userService.insert(user);

    }

    @Test
    public void update() {
        User user =userService.getOne(3L);
        user.setPassword("458");
        user.setAvatar("d.jpg");
        userService.update(user);
    }

    @Test
    public void delete() {
        userService.delete(3L);
    }
}