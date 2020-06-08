package com.move.heart.music.util.netease.bean;

/**
 * Created by JacksonGenerator on 2020/6/7.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDetailResponseByNick {
    @JsonProperty("result")
    private Result result;
    @JsonProperty("code")
    private Integer code;
}