package com.move.heart.music.util.netease.response;

/**
 * Created by JacksonGenerator on 2020/6/7.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class UserPoint {
    @JsonProperty("balance")
    private Integer balance;
    @JsonProperty("blockBalance")
    private Integer blockBalance;
    @JsonProperty("updateTime")
    private Long updateTime;
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("version")
    private Integer version;
    @JsonProperty("status")
    private Integer status;
}