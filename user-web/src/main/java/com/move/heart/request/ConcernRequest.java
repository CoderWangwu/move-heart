package com.move.heart.request;

import com.move.heart.service.bean.Gender;
import lombok.Data;

/**
 * @Author: wg
 * @Date: 2020/6/6 9:52 下午
 */
@Data
public class ConcernRequest {
    /**
     * 用户微信名称
     */
    private String currentUser;

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
}
