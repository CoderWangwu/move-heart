package com.move.heart.dao.bean;

import lombok.Data;

/**
 * @Author: wg
 * @Date: 2020/6/13 5:47 下午
 */
@Data
public class RelationEntity {
    private long id;

    /**
     * 微信userId
     */
    private String userId;
    /**
     * 关注用户的userId
     */
    private String netEaseUserId;

    /**
     * 状态 0为有效 1为删除
     */
    private int status;

    private long createTime;

    private long updateTime;
}
