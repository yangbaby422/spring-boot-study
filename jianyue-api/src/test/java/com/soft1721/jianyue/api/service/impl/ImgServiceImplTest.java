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
    @Test
    public void insertImg() throws Exception{
        Img img = new Img();
        img.setAId(5);
        img.setImgUrl("https://upload-images.jianshu.io/upload_images/14975877-38df7b3ea25e3ff0?imageMogr2/auto-orient/strip|imageView2/1/w/360/h/240");
        imgService.insertImg(img);
    }
}