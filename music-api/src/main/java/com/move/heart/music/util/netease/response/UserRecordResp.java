package com.move.heart.music.util.netease.response;

/**
 * Created by JacksonGenerator on 2020/6/9.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author momo
 */
@Data
@NoArgsConstructor
public class UserRecordResp {
    @JsonProperty("weekData")
    private List<WeekDataItem> weekData;
    @JsonProperty("allData")
    private List<WeekDataItem> allData;
    @JsonProperty("code")
    private Integer code;
}