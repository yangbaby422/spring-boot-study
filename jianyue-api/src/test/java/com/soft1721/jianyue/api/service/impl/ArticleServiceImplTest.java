package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Article;
import com.soft1721.jianyue.api.entity.vo.ArticleVO;
import com.soft1721.jianyue.api.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {
    @Resource
    private ArticleService articleService;
    @Test
    public void selectAll() throws Exception {
        List<ArticleVO> articleList = articleService.selectAll();
        articleList.forEach(article -> System.out.println(article));

    }

    @Test
    public void getArticleById() throws Exception {
        ArticleVO articleVO = articleService.getArticleById(1);
        System.out.println(articleVO);
    }
    @Test
    public  void insertArticle() throws Exception{
        Article article = new Article();
        article.setUId(2);
        article.setContent("biubiubiu~");
        article.setTitle("测试标题");
        article.setCreateTime(new Date());
        articleService.insertArticle(article);
    }
    @Test
    public void getArticleByUId() throws Exception {
        List<ArticleVO> articleVOList = articleService.getArticleByUId(1);
        System.out.println(articleVOList);
    }
    @Test
    public void selectByPage(){
        List<Article> articleList = articleService.selectByPage(1,4);
        articleList.forEach(article -> System.out.println(article.getId() + "\t" + article.getTitle()));
    }
}