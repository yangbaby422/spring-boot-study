package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Comment;
import com.soft1721.jianyue.api.entity.vo.CommentVO;
import com.soft1721.jianyue.api.mapper.CommentMapper;
import com.soft1721.jianyue.api.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Override
    public List<CommentVO> selectCommentsByAId(int aId) {
        List<CommentVO> comments = commentMapper.selectCommentsByAId(aId);
        return comments;
    }

    @Override
    public void addComment(Comment comment) {
        commentMapper.insert(comment);
    }
}
