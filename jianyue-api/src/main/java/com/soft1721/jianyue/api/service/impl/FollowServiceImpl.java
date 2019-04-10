package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Follow;
import com.soft1721.jianyue.api.entity.vo.FollowVO;
import com.soft1721.jianyue.api.mapper.FollowMapper;
import com.soft1721.jianyue.api.service.FollowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class FollowServiceImpl implements FollowService {
    @Resource
    private FollowMapper followMapper;
    @Override
    public Follow getFollow(int fromUId, int toUId) {
        return followMapper.getFollow(fromUId,toUId);
    }

    @Override
    public List<FollowVO> getFollowsByUId(int fromUId) {
        return followMapper.getFollowsByUId(fromUId);
    }

    @Override
    public void insertFollow(Follow follow) {
        followMapper.insertFollow(follow);
    }

    @Override
    public void deleteFollow(int fromUId, int toUId) {
        followMapper.deleteFollow(fromUId,toUId);
    }
}
