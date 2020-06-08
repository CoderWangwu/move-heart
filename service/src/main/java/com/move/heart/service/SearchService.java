package com.move.heart.service;

import com.move.heart.music.util.netease.NeteaseMusicUtils;
import com.move.heart.music.util.netease.bean.Profile;
import com.move.heart.music.util.netease.bean.UserDetailResp;
import com.move.heart.music.util.netease.bean.UserDetailResponseByNick;
import com.move.heart.music.util.netease.bean.UserprofilesItem;
import com.move.heart.service.bean.Gender;
import com.move.heart.service.bean.UserInfo;
import lombok.SneakyThrows;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author: wg
 * @Date: 2020/6/7 2:52 下午
 */
@Service
public class SearchService {


    @SneakyThrows
    public Optional<UserInfo> searchById(String uid) {
        UserDetailResp search = NeteaseMusicUtils.queryUser(uid);
        if (Objects.isNull(search) || Objects.isNull(search.getProfile())) {
            return Optional.empty();
        }
        Profile profile = search.getProfile();
        return Optional.of(UserInfo.builder()
                .type(0)
                .nickName(profile.getNickname())
                .netEaseUserId(uid)
                .avatarUrl(profile.getAvatarUrl())
                .locationCode(profile.getCity().toString())
                .gender(Gender.codeOf(profile.getGender()))
                .build());
    }

    @SneakyThrows
    public List<UserInfo> searchByNickName(String nickName, int start, int limit) {
        UserDetailResponseByNick userDetailResponseByNick = NeteaseMusicUtils.searchByNickName(nickName, start, limit);
        if (Objects.isNull(userDetailResponseByNick)
                || Objects.isNull(userDetailResponseByNick.getResult())
                || CollectionUtils.isEmpty(userDetailResponseByNick.getResult().getUserprofiles())) {
            return Collections.emptyList();
        }

        List<UserprofilesItem> items = userDetailResponseByNick.getResult().getUserprofiles();
        return items.stream()
                .map(o -> UserInfo.builder()
                        .avatarUrl(o.getAvatarUrl())
                        .netEaseUserId(o.getUserId().toString())
                        .nickName(o.getNickname())
                        .gender(Gender.codeOf(o.getGender()))
                        .locationCode(o.getCity().toString())
                        .build())
                .collect(Collectors.toList());
    }

    public List<UserInfo> searchSong(String query) {
        return null;
    }

    public static void main(String[] args) {
        SearchService searchService = new SearchService();
        Optional<UserInfo> userInfo = searchService.searchById("362343958");
        System.out.println(1);
    }
}
