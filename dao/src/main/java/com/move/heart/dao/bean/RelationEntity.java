package com.move.heart.dao.bean;

import lombok.Data;

/**
 * @Author: wg
 * @Date: 2020/6/13 5:47 下午
 */
@Data
public class RelationEntity {
    private String userId;
    /**
     * 关注用户的userId
     */
    private String netEaseUserId;

    private long createTime;

    private long updateTime;
}
