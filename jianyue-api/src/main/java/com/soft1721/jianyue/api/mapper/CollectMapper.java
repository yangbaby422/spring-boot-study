package com.soft1721.jianyue.api.mapper;

import com.soft1721.jianyue.api.entity.Collect;
import com.soft1721.jianyue.api.entity.vo.CollectVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CollectMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "aId", column = "a_id")
    })
    @Select("SELECT * FROM t_collect WHERE u_id = #{uId} AND a_id = #{aId} ")
    Collect getCollect(@Param("uId") int uId, @Param("aId") int aId);

    @Results({
            @Result(column = "a_id",property = "aId"),
            @Result(column = "title",property = "title"),
            @Result(column = "create_time",property = "createTime")
    })
    @Select("SELECT a.a_id,b.title,b.create_time FROM t_collect a LEFT JOIN t_article b ON a.a_id = b.id WHERE a.u_id = #{uId}  " )
    List<CollectVO> getCollectByUId(Integer uId);

    @Insert("INSERT INTO t_collect (u_id,a_id) VALUES (#{uId},#{aId}) ")
    void insertCollect(Collect collect);

    @Delete("DELETE  FROM t_collect WHERE u_id = #{uId} AND a_id = #{aId} ")
    void deleteCollect(@Param("uId") int uId, @Param("aId") int aId);
}
