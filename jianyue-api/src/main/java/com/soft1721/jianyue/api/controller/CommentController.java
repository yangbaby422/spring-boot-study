package com.soft1721.jianyue.api.controller;

import com.soft1721.jianyue.api.entity.Comment;
import com.soft1721.jianyue.api.service.CommentService;
import com.soft1721.jianyue.api.util.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    @PostMapping("/add")
    public ResponseResult addComment(@RequestParam("aId") int aId, @RequestParam("uId") int uId, @RequestParam("content") String content) {
        Comment comment = new Comment();
        comment.setAId(aId);
        comment.setUId(uId);
        comment.setContent(content);
        comment.setCommentTime(new Date());
        commentService.addComment(comment);
        return ResponseResult.success();
    }
}
