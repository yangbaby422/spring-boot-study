package com.springboot.mybatis.controller;


import com.springboot.mybatis.entity.Course;
import com.springboot.mybatis.service.CourseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class Controller {
    @Resource
    private CourseService courseService;

    @RequestMapping(value = "/courses",method = RequestMethod.GET)
    public List<Course> selectAll(){
        return courseService.selectAll();
    }
    @RequestMapping(value = "/course/{id}",method = RequestMethod.GET)
    public Course getOne(@PathVariable("id") long id){
        return courseService.getOne(id);
    }
    @RequestMapping(value = "/course/{id}",method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable("id")long id){
        courseService.delete(id);
    }
}
