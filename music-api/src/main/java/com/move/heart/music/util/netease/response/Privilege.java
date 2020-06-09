package com.move.heart.music.util.netease.response;

/**
 * Created by JacksonGenerator on 2020/6/9.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author momo
 */
@Data
@NoArgsConstructor
public class Privilege {
    @JsonProperty("st")
    private Integer st;
    @JsonProperty("flag")
    private Integer flag;
    @JsonProperty("subp")
    private Integer subp;
    @JsonProperty("fl")
    private Integer fl;
    @JsonProperty("fee")
    private Integer fee;
    @JsonProperty("dl")
    private Integer dl;
    @JsonProperty("cp")
    private Integer cp;
    @JsonProperty("preSell")
    private Boolean preSell;
    @JsonProperty("cs")
    private Boolean cs;
    @JsonProperty("toast")
    private Boolean toast;
    @JsonProperty("maxbr")
    private Integer maxbr;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("pl")
    private Integer pl;
    @JsonProperty("sp")
    private Integer sp;
    @JsonProperty("payed")
    private Integer payed;
}