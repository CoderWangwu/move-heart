package com.move.heart.music.util.netease.bean;

/**
 * Created by JacksonGenerator on 2020/6/7.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserprofilesItem {
    @JsonProperty("birthday")
    private Long birthday;
    @JsonProperty("detailDescription")
    private String detailDescription;
    @JsonProperty("backgroundUrl")
    private String backgroundUrl;
    @JsonProperty("gender")
    private Integer gender;
    @JsonProperty("city")
    private Integer city;
    @JsonProperty("signature")
    private String signature;
    @JsonProperty("description")
    private String description;
    @JsonProperty("accountStatus")
    private Integer accountStatus;
    @JsonProperty("avatarImgId")
    private Long avatarImgId;
    @JsonProperty("defaultAvatar")
    private Boolean defaultAvatar;
    @JsonProperty("avatarImgIdStr")
    private String avatarImgIdStr;
    @JsonProperty("backgroundImgIdStr")
    private String backgroundImgIdStr;
    @JsonProperty("province")
    private Integer province;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("alg")
    private String alg;
    @JsonProperty("djStatus")
    private Integer djStatus;
    @JsonProperty("avatarUrl")
    private String avatarUrl;
    @JsonProperty("authStatus")
    private Integer authStatus;
    @JsonProperty("vipType")
    private Integer vipType;
    @JsonProperty("followed")
    private Boolean followed;
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("authenticationTypes")
    private Integer authenticationTypes;
    @JsonProperty("mutual")
    private Boolean mutual;
    @JsonProperty("authority")
    private Integer authority;
    @JsonProperty("anchor")
    private Boolean anchor;
    @JsonProperty("userType")
    private Integer userType;
    @JsonProperty("backgroundImgId")
    private Long backgroundImgId;
}