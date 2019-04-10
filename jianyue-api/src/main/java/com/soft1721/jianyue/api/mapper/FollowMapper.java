package com.soft1721.jianyue.api.mapper;

import com.soft1721.jianyue.api.entity.Follow;
import com.soft1721.jianyue.api.entity.vo.FollowVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FollowMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "fromUId", column = "from_uid"),
            @Result(property = "toUId", column = "to_uid")
    })
    @Select("SELECT * FROM t_follow WHERE from_uid = #{fromUId} AND to_uid = #{toUId} ")
    Follow getFollow(@Param("fromUId") int fromUId, @Param("toUId") int toUId);

    @Results({
            @Result(property = "toUId", column = "to_uid"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    @Select("SELECT a.to_uid,b.nickname,b.avatar FROM t_follow a LEFT JOIN t_user b ON a.to_uid = b.id WHERE a.from_uid = #{fromUId}  ")
    List<FollowVO> getFollowsByUId(int fromUId);

    @Insert("INSERT INTO t_follow (from_uid,to_uid) VALUES (#{fromUId},#{toUId}) ")
    void insertFollow(Follow follow);

    @Delete("DELETE  FROM t_follow WHERE from_uid = #{fromUId} AND to_uid = #{toUId} ")
    void deleteFollow(@Param("fromUId") int fromUId, @Param("toUId") int toUId);
}
