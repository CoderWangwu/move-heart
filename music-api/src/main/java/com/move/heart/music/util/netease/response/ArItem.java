package com.move.heart.music.util.netease.response;

/**
 * Created by JacksonGenerator on 2020/6/9.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class ArItem {
    @JsonProperty("name")
    private String name;
    @JsonProperty("tns")
    private List tns;
    @JsonProperty("alias")
    private List alias;
    @JsonProperty("id")
    private Integer id;
}