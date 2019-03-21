package com.springboot.mybatis.mapper;

import com.springboot.mybatis.entity.Course;
import com.springboot.mybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "mobile",column = "mobile"),
            @Result(property = "password",column = "password"),
            @Result(property = "userName",column = "username"),
            @Result(property = "avatar",column = "avatar"),
    })
    @Select("SELECT * FROM t_sys_user ")
    List<User> selectAll();
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "mobile",column = "mobile"),
            @Result(property = "password",column = "password"),
            @Result(property = "userName",column = "username"),
            @Result(property = "avatar",column = "avatar"),
    })
    @Select("SELECT * FROM t_sys_user WHERE user_id=#{user_id}")
    User getOne(long UserId);

    @Insert("INSERT INTO t_sys_user(mobile,password,username,avatar)" +
            " VALUES(#{mobile}, #{password}, #{userName},#{avatar}) ")
    void insert(User user);


    @Update("UPDATE t_sys_user SET password=#{password},avatar=#{avatar} WHERE user_id=#{userId} ")
    void update(User user);

    @Delete("DELETE FROM t_sys_user WHERE user_id =#{userId} ")
    void delete(Long userId);


}
