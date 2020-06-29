package com.move.heart.service;

import com.move.heart.dao.RelationDao;
import com.move.heart.dao.UserInfoDao;
import com.move.heart.service.bean.SongRecordInfo;
import com.move.heart.service.bean.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wg
 * @Date: 2020/6/6 9:25 下午
 */
@Service
public class UserConcernService {

    //@Resource
    private UserInfoDao userInfoDao;

    //@Resource
    private RelationDao relationDao;

    //@Resource
    private SearchService searchService;

    public void concern(UserInfo userInfo, String currentUser) {
        // step 1.存在则不插入
        long id = userInfoDao.insertUserEntitry(Convert.convert(userInfo));
        // step 2.插入 返回Id
        relationDao.concern(Convert.convert(userInfo, currentUser));
        // step 3.保存 关注关系

        // step 4.异步保存 关注用户的听歌记录
        List<SongRecordInfo> songRecordInfos = searchService.searchUserMusic(userInfo.getNetEaseUserId());

    }


}
