package com.springboot.mybatis.service.impl;

import com.springboot.mybatis.entity.Course;
import com.springboot.mybatis.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest {
    @Resource
    private CourseService courseService;
    @Test
    public void selectAll() {
        List<Course> courseList = courseService.selectAll();
        courseList.forEach(course -> System.out.println(course));
    }

    @Test
    public void getOne(){
        Course course = courseService.getOne(1L);
        System.out.println(course);
    }
}