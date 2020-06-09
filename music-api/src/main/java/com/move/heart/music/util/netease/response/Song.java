package com.move.heart.music.util.netease.response;

/**
 * Created by JacksonGenerator on 2020/6/9.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;


@Data
@NoArgsConstructor
public class Song {
    @JsonProperty("no")
    private Integer no;
    @JsonProperty("rt")
    private String rt;
    @JsonProperty("copyright")
    private Integer copyright;
    @JsonProperty("fee")
    private Integer fee;
    @JsonProperty("privilege")
    private Privilege privilege;
    @JsonProperty("mst")
    private Integer mst;
    @JsonProperty("pst")
    private Integer pst;
    @JsonProperty("pop")
    private Integer pop;
    @JsonProperty("dt")
    private Integer dt;
    @JsonProperty("rtype")
    private Integer rtype;
    @JsonProperty("s_id")
    private Integer sId;
    @JsonProperty("rtUrls")
    private List rtUrls;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("st")
    private Integer st;
    @JsonProperty("cd")
    private String cd;
    @JsonProperty("publishTime")
    private Long publishTime;
    @JsonProperty("cf")
    private String cf;
    @JsonProperty("originCoverType")
    private Integer originCoverType;
    @JsonProperty("h")
    private H h;
    @JsonProperty("mv")
    private Integer mv;
    @JsonProperty("al")
    private Al al;
    @JsonProperty("l")
    private L l;
    @JsonProperty("eq")
    private String eq;
    @JsonProperty("m")
    private M m;
    @JsonProperty("cp")
    private Integer cp;
    @JsonProperty("alia")
    private List alia;
    @JsonProperty("djId")
    private Integer djId;
    @JsonProperty("ar")
    private List<ArItem> ar;
    @JsonProperty("ftype")
    private Integer ftype;
    @JsonProperty("t")
    private Integer t;
    @JsonProperty("v")
    private Integer v;
    @JsonProperty("name")
    private String name;
    @JsonProperty("mark")
    private BigInteger mark;
}