package com.move.heart.music.util.netease.bean;

/**
 * Created by JacksonGenerator on 2020/6/7.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Result {
    @JsonProperty("userprofiles")
    private List<UserprofilesItem> userprofiles;
    @JsonProperty("userprofileCount")
    private Integer userprofileCount;
}