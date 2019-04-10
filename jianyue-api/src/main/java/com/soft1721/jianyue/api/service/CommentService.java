package com.soft1721.jianyue.api.service;

import com.soft1721.jianyue.api.entity.Comment;
import com.soft1721.jianyue.api.entity.vo.CommentVO;

import java.util.List;

public interface CommentService {
    List<CommentVO> selectCommentsByAId(int aId);
    void addComment(Comment comment);
}
