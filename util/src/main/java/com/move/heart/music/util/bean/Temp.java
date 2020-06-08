package com.move.heart.music.util.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: wg
 * @Date: 2020/6/3 12:00 上午
 */
@Data
@Builder
public class Temp {
    private String method;
    String url;
    BaseRequestData params;

}
