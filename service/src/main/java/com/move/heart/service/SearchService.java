package com.move.heart.service;

import com.move.heart.dao.UserMusicRecordDao;
import com.move.heart.dao.bean.UserMusicRecordEntity;
import com.move.heart.music.util.concurrent.FutureUtils;
import com.move.heart.music.util.concurrent.NamedThreadFactory;
import com.move.heart.music.util.netease.NeteaseMusicUtils;
import com.move.heart.music.util.netease.RecordType;
import com.move.heart.music.util.netease.response.Profile;
import com.move.heart.music.util.netease.response.UserDetailResp;
import com.move.heart.music.util.netease.response.UserDetailResponseByNick;
import com.move.heart.music.util.netease.response.UserprofilesItem;
import com.move.heart.service.bean.Gender;
import com.move.heart.service.bean.SongRecordInfo;
import com.move.heart.service.bean.UserInfo;
import lombok.SneakyThrows;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author: wg
 * @Date: 2020/6/7 2:52 下午
 */
@Service
public class SearchService {

    //@Resource
    private UserMusicRecordDao userMusicRecordDao;

    private ExecutorService executorService = new ThreadPoolExecutor(100, 1000, 2,
            TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(100),
            new NamedThreadFactory("SearchService"),
            new ThreadPoolExecutor.CallerRunsPolicy());

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

    public List<SongRecordInfo> searchUserMusic(String userId) {
        // step 1.查询 接口
        Future<List<SongRecordInfo>> songRecordInfosFuture = executorService.submit(()
                -> getSongRecordInfos(userId));
        // step 2.对比上一次的快照---》 正在听 保存当前快照数据
        Future<Map<String, SongRecordInfo>> yesterDaySongRecordInfosFuture = executorService.submit(()
                -> getYesterDaySongRecordInfos(userId));

        List<SongRecordInfo> songRecordInfos = FutureUtils.getWithDefault(songRecordInfosFuture, 200, Collections.emptyList());

        Map<String, SongRecordInfo> yesterDaySongRecordInfos = FutureUtils.getWithDefault(yesterDaySongRecordInfosFuture, 200, Collections.emptyMap());
        // diff
        return songRecordInfos.stream().filter(o -> {
            SongRecordInfo songRecordInfo = yesterDaySongRecordInfos.get(o.getSongId());
            if (Objects.isNull(songRecordInfo)) {
                return true;
            }
            return songRecordInfo.getScore() != o.getScore();
        }).collect(Collectors.toList());
    }

    @SneakyThrows
    private List<SongRecordInfo> getSongRecordInfos(String userId) {
        return Convert.convertRecentWeek(NeteaseMusicUtils.queryUserRecord(userId, RecordType.RENCENT_WEEK), RecordType.RENCENT_WEEK);
    }

    @SneakyThrows
    private Map<String, SongRecordInfo> getYesterDaySongRecordInfos(String userId) {
        List<UserMusicRecordEntity> userMusicRecordEntities = userMusicRecordDao.queryeUserMusicRecord(userId, 1);
        if (CollectionUtils.isEmpty(userMusicRecordEntities)) {
            return Collections.emptyMap();
        }
        return userMusicRecordEntities.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(UserMusicRecordEntity::getSongId, Convert::convert));
    }

    public static void main(String[] args) {
        SearchService searchService = new SearchService();
        Optional<UserInfo> userInfo = searchService.searchById("362343958");
        System.out.println(1);
    }
}
