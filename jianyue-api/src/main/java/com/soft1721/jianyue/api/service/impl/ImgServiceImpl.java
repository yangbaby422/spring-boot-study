package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Img;
import com.soft1721.jianyue.api.mapper.ImgMapper;
import com.soft1721.jianyue.api.service.ImgService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class ImgServiceImpl implements ImgService {
    @Resource
    private ImgMapper imgMapper;
    @Override
    public List<Img> selectImgsByAId(int aId) {
        List<Img> imgs = imgMapper.selectImgsByAId(aId);
        return imgs;
    }
}
