package com.move.heart.music.util.netease.response;

/**
 * Created by JacksonGenerator on 2020/6/7.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BindingsItem {
    @JsonProperty("expiresIn")
    private Integer expiresIn;
    @JsonProperty("expired")
    private Boolean expired;
    @JsonProperty("refreshTime")
    private Integer refreshTime;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("type")
    private Integer type;
    @JsonProperty("bindingTime")
    private Long bindingTime;
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("url")
    private String url;
}