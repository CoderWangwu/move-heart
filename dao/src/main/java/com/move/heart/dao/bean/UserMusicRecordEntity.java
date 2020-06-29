package com.move.heart.dao.bean;

import lombok.Data;

/**
 * @Author: wg
 * @Date: 2020/6/13 5:57 下午
 */
@Data
public class UserMusicRecordEntity {

    private long id;

    private String netEaseUserId;

    private String songId;

    /**
     * 0 周的记录 1天的记录
     */
    private int type;

    private int score;
}
