package com.move.heart.dao;

import com.move.heart.dao.bean.UserInfoEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: wg
 * @Date: 2020/6/13 5:19 下午
 */
@Repository
public interface UserInfoDao {


    /**
     * @param userInfoEntity
     * @return
     */
    long insertUserEntitry(@Param("userInfoEntity") UserInfoEntity userInfoEntity);

    UserInfoEntity queryUserInfoEntityUserId(@Param("netEaseUserId") String netEaseUserId);

    UserInfoEntity queryUserInfoEntityById(@Param("id") int id);
}
