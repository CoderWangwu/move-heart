package com.move.heart.music.util.netease.bean;

/**
 * Created by JacksonGenerator on 2020/6/7.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class Profile {
    @JsonProperty("detailDescription")
    private String detailDescription;
    @JsonProperty("birthday")
    private Long birthday;
    @JsonProperty("backgroundUrl")
    private String backgroundUrl;
    @JsonProperty("gender")
    private Integer gender;
    @JsonProperty("city")
    private Integer city;
    @JsonProperty("signature")
    private String signature;
    @JsonProperty("followeds")
    private Integer followeds;
    @JsonProperty("description")
    private String description;
    @JsonProperty("eventCount")
    private Integer eventCount;
    @JsonProperty("allSubscribedCount")
    private Integer allSubscribedCount;
    @JsonProperty("playlistBeSubscribedCount")
    private Integer playlistBeSubscribedCount;
    @JsonProperty("accountStatus")
    private Integer accountStatus;
    @JsonProperty("avatarImgId")
    private Long avatarImgId;
    @JsonProperty("defaultAvatar")
    private Boolean defaultAvatar;
    @JsonProperty("backgroundImgIdStr")
    private String backgroundImgIdStr;
    @JsonProperty("avatarImgIdStr")
    private String avatarImgIdStr;
    @JsonProperty("province")
    private Integer province;
    @JsonProperty("followMe")
    private Boolean followMe;
    @JsonProperty("artistIdentity")
    private List artistIdentity;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("sDJPCount")
    private Integer sDJPCount;
    @JsonProperty("newFollows")
    private Integer newFollows;
    @JsonProperty("djStatus")
    private Integer djStatus;
    @JsonProperty("avatarUrl")
    private String avatarUrl;
    @JsonProperty("authStatus")
    private Integer authStatus;
    @JsonProperty("follows")
    private Integer follows;
    @JsonProperty("vipType")
    private Integer vipType;
    @JsonProperty("blacklist")
    private Boolean blacklist;
    @JsonProperty("followed")
    private Boolean followed;
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("mutual")
    private Boolean mutual;
    @JsonProperty("avatarImgId_str")
    private String avatarImg;
    @JsonProperty("createTime")
    private Long createTime;
    @JsonProperty("authority")
    private Integer authority;
    @JsonProperty("cCount")
    private Integer cCount;
    @JsonProperty("userType")
    private Integer userType;
    @JsonProperty("backgroundImgId")
    private Long backgroundImgId;
    @JsonProperty("experts")
    private Experts experts;
    @JsonProperty("playlistCount")
    private Integer playlistCount;
    @JsonProperty("sCount")
    private Integer sCount;
}