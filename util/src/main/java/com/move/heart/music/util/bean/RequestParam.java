package com.move.heart.music.util.bean;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * @Author: wg
 * @Date: 2020/6/2 11:15 下午
 */
@Data
@Builder
public class RequestParam {

    private CryptoResult cryptoResult;
    private String method;
    private String url;
    private Map<String, String> heads;
    private String body;

}
