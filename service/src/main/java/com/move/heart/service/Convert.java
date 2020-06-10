package com.move.heart.service;

import com.move.heart.music.util.netease.RecordType;
import com.move.heart.music.util.netease.response.UserRecordResp;
import com.move.heart.music.util.netease.response.WeekDataItem;
import com.move.heart.service.bean.SongRecordInfo;
import com.move.heart.service.bean.SourceType;
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
}
