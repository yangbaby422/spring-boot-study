package com.springboot.mybatis.controller;

import com.springboot.mybatis.entity.Course;
import com.springboot.mybatis.entity.User;
import com.springboot.mybatis.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> selectAll() {
        return  userService.selectAll();
    }
    @RequestMapping(value = "/users/{id}",method=RequestMethod.GET )
    public User getOne(@PathVariable("id") long id){
        return userService.getOne(id);
    }
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userService.insert(user);
    }
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user){
        userService.update(user);
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public  void delete(@PathVariable("id") long id){
        userService.delete(id);
    }
}