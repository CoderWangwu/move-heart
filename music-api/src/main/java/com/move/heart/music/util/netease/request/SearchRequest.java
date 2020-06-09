package com.move.heart.music.util.netease.request;

import com.move.heart.music.util.bean.BaseRequestData;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: wg
 * @Date: 2020/5/29 11:49 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class SearchRequest extends BaseRequestData {

    private String s;
    /**
     * 1 即单曲 , 取值意义 : 1: 单曲, 10: 专辑, 100: 歌手, 1000: 歌单,
     * 1002: 用户, 1004: MV, 1006: 歌词, 1009: 电台, 1014: 视频, 1018:综合
     */
    private int type;
    private int offset;
    private int limit;

}
