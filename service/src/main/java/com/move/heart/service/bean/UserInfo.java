package com.move.heart.service.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: wg
 * @Date: 2020/6/6 10:00 下午
 */
@Data
@Builder
public class UserInfo {
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
    private Gender gender;

    /**
     * 位置code
     */
    private String locationCode;
    /**
     * 0:网易
     */
    private int type;
}
