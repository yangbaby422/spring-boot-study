package com.soft1721.jianyue.api.controller;

import com.soft1721.jianyue.api.entity.Collect;
import com.soft1721.jianyue.api.entity.vo.CollectVO;
import com.soft1721.jianyue.api.service.CollectService;
import com.soft1721.jianyue.api.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/collect")
public class CollectController {
    @Resource
    private CollectService collectService;
    @PostMapping("/add")
    public ResponseResult collectArticle(@RequestParam("uId") int uId, @RequestParam("aId") int aId) {
        Collect collect = new Collect();
        collect.setUId(uId);
        collect.setAId(aId);
        collectService.insertCollect(collect);
        return ResponseResult.success();
    }

    @PostMapping("/cancel")
    public ResponseResult cancelCollect(@RequestParam("uId") int uId, @RequestParam("aId") int aId) {
        collectService.deleteCollect(uId, aId);
        return ResponseResult.success();
    }

    @GetMapping("/list")
    public ResponseResult getCollectByUId(@RequestParam("uId") int uId) {
        List<CollectVO> collectVO =collectService.getCollectByUId(uId);
        return ResponseResult.success(collectVO);
    }
}
