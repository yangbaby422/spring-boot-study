package com.soft1721.jianyue.api.controller;

import com.soft1721.jianyue.api.entity.Follow;
import com.soft1721.jianyue.api.service.FollowService;
import com.soft1721.jianyue.api.util.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/follow")
public class FollowController {
    @Resource
    private FollowService followService;


    @PostMapping("/add")
    public ResponseResult followUser(@RequestParam("fromUId") int fromUId, @RequestParam("toUId") int toUId) {
        Follow follow = new Follow();
        follow.setFromUId(fromUId);
        follow.setToUId(toUId);
        followService.insertFollow(follow);
        return ResponseResult.success();
    }

    @PostMapping("/cancel")
    public ResponseResult cancelFollow(@RequestParam("fromUId") int fromUId, @RequestParam("toUId") int toUId) {
        followService.deleteFollow(fromUId, toUId);
        return ResponseResult.success();
    }
}
