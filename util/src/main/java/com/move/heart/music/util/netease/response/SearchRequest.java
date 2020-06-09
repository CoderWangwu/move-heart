package com.move.heart.music.util.netease.response;

import lombok.Data;

/**
 * @Author: wg
 * @Date: 2020/5/29 11:49 下午
 */
@Data
public class SearchRequest {
    private String keyWord;
    private int type;
    private int start;
    private int limit;

}
