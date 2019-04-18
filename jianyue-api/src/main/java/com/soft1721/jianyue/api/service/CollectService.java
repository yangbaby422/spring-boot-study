package com.soft1721.jianyue.api.service;

import com.soft1721.jianyue.api.entity.Collect;
import com.soft1721.jianyue.api.entity.vo.CollectVO;

import java.util.List;

public interface CollectService {
    Collect getCollect(int uId,int aId);
    List<CollectVO> getCollectByUId(int uId);
    void insertCollect(Collect collect);
    void deleteCollect(int uId,int aId);
}
