package com.move.heart.service;

import com.move.heart.dao.bean.RelationEntity;
import com.move.heart.dao.bean.UserInfoEntity;
import com.move.heart.dao.bean.UserMusicRecordEntity;
import com.move.heart.music.util.netease.RecordType;
import com.move.heart.music.util.netease.response.UserRecordResp;
import com.move.heart.music.util.netease.response.WeekDataItem;
import com.move.heart.service.bean.SongRecordInfo;
import com.move.heart.service.bean.SourceType;
import com.move.heart.service.bean.UserInfo;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: wg
 * @Date: 2020/6/10 11:14 上午
 */
public class Convert {

    public static List<SongRecordInfo> convertRecentWeek(UserRecordResp userRecordResp, RecordType recordType) {
        List<WeekDataItem> weekData = RecordType.ALL.equals(recordType) ? userRecordResp.getAllData()
                : userRecordResp.getAllData();
        if (CollectionUtils.isEmpty(weekData)) {
            return Collections.emptyList();
        }
        return weekData.stream()
                .map(o -> SongRecordInfo.builder()
                        .score(o.getScore())
                        .songId(o.getSong().getId().toString())
                        .sourceType(SourceType.NET_EASE)
                        .build())
                .collect(Collectors.toList());
    }

    public static UserInfoEntity convert(UserInfo userInfo) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setNetEaseUserId(userInfo.getNetEaseUserId());
        userInfoEntity.setAvatarUrl(userInfo.getAvatarUrl());
        userInfoEntity.setNickName(userInfo.getNickName());
        userInfoEntity.setGender(userInfo.getGender().getCode());
        userInfoEntity.setLocationCode(userInfo.getLocationCode());
        userInfoEntity.setType(userInfo.getType());
        userInfoEntity.setCreateTime(System.currentTimeMillis());
        userInfoEntity.setUpdateTime(System.currentTimeMillis());
        return userInfoEntity;
    }

    public static RelationEntity convert(UserInfo userInfo, String currentUser) {
        RelationEntity relationEntity = new RelationEntity();
        relationEntity.setUserId(currentUser);
        relationEntity.setNetEaseUserId(userInfo.getNetEaseUserId());
        relationEntity.setCreateTime(System.currentTimeMillis());
        relationEntity.setUpdateTime(System.currentTimeMillis());
        return relationEntity;
    }

    public static SongRecordInfo convert(UserMusicRecordEntity userMusicRecordEntity) {
        SongRecordInfo songRecordInfo = new SongRecordInfo();
        songRecordInfo.setSongId(userMusicRecordEntity.getSongId());
        songRecordInfo.setSourceType(SourceType.NET_EASE);
        songRecordInfo.setScore(userMusicRecordEntity.getScore());
        return songRecordInfo;
    }
}
