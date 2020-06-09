package com.move.heart.music.util.netease.response;

/**
 * Created by JacksonGenerator on 2020/6/9.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class L {
    @JsonProperty("br")
    private Integer br;
    @JsonProperty("fid")
    private Integer fid;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("vd")
    private Integer vd;
}