package com.springboot.mybatis.mapper;

import com.springboot.mybatis.entity.Course;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper {
    @Results({
            @Result(property = "courseId",column = "course_id"),
            @Result(property = "courseName",column = "course_name"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "courseClass",column = "course_class"),
            @Result(property = "cover",column = "cover"),
            @Result(property = "courseCode",column = "course_code"),
            @Result(property = "finished",column = "finished")
    })
    @Select("SELECT * FROM t_course ")
    List<Course> selectAll();

    @Results({
            @Result(property = "courseId",column = "course_id"),
            @Result(property = "courseName",column = "course_name"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "courseClass",column = "course_class"),
            @Result(property = "cover",column = "cover"),
            @Result(property = "courseCode",column = "course_code"),
            @Result(property = "finished",column = "finished")
    })
    @Select("SELECT * FROM t_course WHERE course_id = #{courseId} ")
    Course getOne(Long courseId);
}
