package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Collect;
import com.soft1721.jianyue.api.entity.vo.CollectVO;
import com.soft1721.jianyue.api.service.CollectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectServiceImplTest {
    @Resource
    private CollectService collectService;
    @Test
    public void getCollect() {
        Collect collect = collectService.getCollect(1,2);
        System.out.println(collect);
    }

    @Test
    public void getCollectByUId() {
        List<CollectVO> collects = collectService.getCollectByUId(2);
        System.out.println(collects);
    }

    @Test
    public void insertCollect() {
        Collect collect = new Collect();
        collect.setUId(1);
        collect.setAId(3);
        collectService.insertCollect(collect);
    }

    @Test
    public void deleteCollect() {
        collectService.deleteCollect(3,1);
    }
}