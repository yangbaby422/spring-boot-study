package com.soft1721.jianyue.api.service;

import com.soft1721.jianyue.api.entity.vo.ArticleVO;

import java.util.List;

public interface ArticleService {
    List<ArticleVO> selectAll();
    ArticleVO getArticleById(int aId);
}
