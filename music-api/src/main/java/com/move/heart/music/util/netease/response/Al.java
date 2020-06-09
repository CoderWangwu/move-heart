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
public class Al {
    @JsonProperty("picUrl")
    private String picUrl;
    @JsonProperty("name")
    private String name;
    @JsonProperty("tns")
    private List tns;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("pic")
    private Long pic;
}