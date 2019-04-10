package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.vo.ArticleVO;
import com.soft1721.jianyue.api.mapper.ArticleMapper;
import com.soft1721.jianyue.api.mapper.ImgMapper;
import com.soft1721.jianyue.api.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ImgMapper imgMapper;
    @Override
    public List<ArticleVO> selectAll() {
        List<ArticleVO> articles = articleMapper.selectAll();
        for (ArticleVO articleVO:articles){
            articleVO.setImgs(imgMapper.selectImgsByAId(articleVO.getId()));
        }
        return articles;
    }

    @Override
    public ArticleVO getArticleById(int aId) {
        return articleMapper.getArticleById(aId);
    }
}
