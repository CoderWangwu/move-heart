package com.move.heart.service.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: wg
 * @Date: 2020/6/10 11:09 上午
 */
@Builder
@Data
public class SongRecordInfo {

    private String songId;

    private SourceType sourceType;

    private int score;
}
