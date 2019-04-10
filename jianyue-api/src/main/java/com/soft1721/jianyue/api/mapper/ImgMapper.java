package com.soft1721.jianyue.api.mapper;

import com.soft1721.jianyue.api.entity.Img;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ImgMapper {
    @Results({
             @Result(property = "id", column = "id"),
            @Result(property = "aId", column = "a_id"),
            @Result(property = "imgUrl",column = "img_url")
    })
    @Select("SELECT * FROM t_img WHERE a_id = #{aId} ")
    List<Img> selectImgsByAId(int aId);
}
