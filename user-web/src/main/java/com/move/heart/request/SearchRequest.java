package com.move.heart.request;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: wg
 * @Date: 2020/6/7 3:01 下午
 */
@Data
@Builder
public class SearchRequest {
    private String query;
    /**
     * 默认为用户
     */
    private int type;

    int start;

    int limit;
}
