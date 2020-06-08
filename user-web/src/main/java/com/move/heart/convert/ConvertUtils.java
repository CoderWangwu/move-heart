package com.move.heart.convert;

import com.move.heart.request.ConcernRequest;
import com.move.heart.response.UserDetailView;
import com.move.heart.service.bean.UserInfo;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: wg
 * @Date: 2020/6/6 10:31 下午
 */
public class ConvertUtils {

    public static UserInfo convert(ConcernRequest concernRequest) {
        return UserInfo.builder()
                .avatarUrl(concernRequest.getAvatarUrl())
                .netEaseUserId(concernRequest.getNetEaseUserId())
                .nickName(concernRequest.getNickName())
                .gender(concernRequest.getGender())
                .locationCode(concernRequest.getLocationCode())
                .type(0)
                .build();
    }

    public static List<UserDetailView> convert(List<UserInfo> userInfos) {
        if (CollectionUtils.isEmpty(userInfos)) {
            return Collections.emptyList();
        }

        return userInfos.stream().map(o ->
                UserDetailView.builder()
                        .avatarUrl(o.getAvatarUrl())
                        .netEaseUserId(o.getNetEaseUserId())
                        .nickName(o.getNickName())
                        .locationCode(o.getLocationCode())
                        .gender(o.getGender())
                        .build())
                .collect(Collectors.toList());
    }
}
