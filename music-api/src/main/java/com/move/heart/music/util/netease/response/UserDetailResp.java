package com.move.heart.music.util.netease.response;

/**
 * Created by JacksonGenerator on 2020/6/7.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserDetailResp {
    @JsonProperty("userPoint")
    private UserPoint userPoint;
    @JsonProperty("adValid")
    private Boolean adValid;
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("level")
    private Integer level;
    @JsonProperty("createTime")
    private Long createTime;
    @JsonProperty("listenSongs")
    private Integer listenSongs;
    @JsonProperty("createDays")
    private Integer createDays;
    @JsonProperty("profile")
    private Profile profile;
    @JsonProperty("bindings")
    private List<BindingsItem> bindings;
    @JsonProperty("pcSign")
    private Boolean pcSign;
    @JsonProperty("mobileSign")
    private Boolean mobileSign;
    @JsonProperty("peopleCanSeeMyPlayRecord")
    private Boolean peopleCanSeeMyPlayRecord;
}