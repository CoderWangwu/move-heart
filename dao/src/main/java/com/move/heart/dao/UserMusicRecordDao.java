package com.move.heart.dao;

import com.move.heart.dao.bean.UserMusicRecordEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wg
 * @Date: 2020/6/13 5:58 下午
 */
@Repository
public interface UserMusicRecordDao {

    void batchSaveUserMusicRecord(List<UserMusicRecordEntity> userMusicRecordEntityList);

    List<UserMusicRecordEntity> queryeUserMusicRecord(String netEaseUserId);

}
