package com.move.heart.music.util.netease.response;

/**
 * Created by JacksonGenerator on 2020/6/9.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class WeekDataItem {
    @JsonProperty("song")
    private Song song;
    @JsonProperty("playCount")
    private Integer playCount;
    @JsonProperty("score")
    private Integer score;
}