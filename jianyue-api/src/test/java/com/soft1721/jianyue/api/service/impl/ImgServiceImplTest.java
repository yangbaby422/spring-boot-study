package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Img;
import com.soft1721.jianyue.api.service.ImgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ImgServiceImplTest {
    @Resource
    private ImgService imgService;

    @Test
    public void selectImgsByAId() throws Exception {
        List<Img> imgList = imgService.selectImgsByAId(1);
        imgList.forEach(img -> System.out.println(img));

    }
}