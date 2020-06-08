package com.move.heart.response;

import lombok.Builder;

/**
 * @Author: wg
 * @Date: 2020/6/6 10:37 下午
 */
@Builder
public class UserSearchResponse {
    /**
     * 搜索的结果类型  0 代表用户 1.代表歌曲
     */
    private int type;

    private Object result;
}
