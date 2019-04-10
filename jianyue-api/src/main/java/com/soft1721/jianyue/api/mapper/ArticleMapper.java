package com.soft1721.jianyue.api.mapper;

import com.soft1721.jianyue.api.entity.vo.ArticleVO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "title",column = "title"),
            @Result(property = "content",column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
     })
    @Select("SELECT a.*,b.nickname,b.avatar FROM t_article a Left JOIN t_user b ON a.u_id=b.id ORDER By id DESC ")
    List<ArticleVO> selectAll();
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "title",column = "title"),
            @Result(property = "content",column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    @Select("SELECT a.*,b.nickname,b.avatar FROM t_article a Left JOIN t_user b ON a.u_id = b.id WHERE a.id=#{aId} ")
    ArticleVO getArticleById(int aId);


}
