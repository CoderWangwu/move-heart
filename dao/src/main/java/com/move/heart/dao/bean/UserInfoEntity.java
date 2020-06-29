package com.move.heart.dao.bean;

import lombok.Data;

/**
 * @Author: wg
 * @Date: 2020/6/13 5:21 下午
 */

@Data
public class UserInfoEntity {

    private long id;
    /**
     * 关注用户的userId
     */
    private String netEaseUserId;

    /**
     * 关注用户的头像url
     */
    private String avatarUrl;

    /**
     * 关注用户的昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private int gender;

    /**
     * 位置code
     */
    private String locationCode;
    /**
     * 0:网易
     */
    private int type;

    private long createTime;

    private long updateTime;
}
