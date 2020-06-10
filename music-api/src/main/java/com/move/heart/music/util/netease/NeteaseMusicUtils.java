package com.move.heart.music.util.netease;

import com.move.heart.music.util.JsonUtil;
import com.move.heart.music.util.bean.CryptoType;
import com.move.heart.music.util.http.MyHttpClient;
import com.move.heart.music.util.netease.request.SearchRequest;
import com.move.heart.music.util.netease.request.UserRecordRequest;
import com.move.heart.music.util.netease.response.UserDetailResp;
import com.move.heart.music.util.netease.response.UserDetailResponseByNick;
import com.move.heart.music.util.netease.response.UserRecordResp;


/**
 * @Author: wg
 * @Date: 2020/5/29 11:45 下午
 */
public class NeteaseMusicUtils {


    public static String search(SearchRequest searchRequest) throws Exception {
        return MyHttpClient.post("https://music.163.com/weapi/search/get", searchRequest, CryptoType.WEAPI);

    }

    /**
     * 通过昵称 查询用户信息
     *
     * @param nickName 昵称
     * @param start    分页 start
     * @param limit    偏移量
     * @return result
     * @throws Exception
     */
    public static UserDetailResponseByNick searchByNickName(String nickName, int start, int limit) throws Exception {
        SearchRequest searchRequest = SearchRequest.builder().type(1002).offset(start).limit(limit).s(nickName).build();
        String post = MyHttpClient.post("https://music.163.com/weapi/search/get", searchRequest, CryptoType.WEAPI);
        return JsonUtil.json2Object(post, UserDetailResponseByNick.class);

    }

    /**
     * 根据用户的userId 查询用户详情信息
     *
     * @param userId userId
     * @return resp
     * @throws Exception e
     */
    public static UserDetailResp queryUser(String userId) throws Exception {
        String url = "https://music.163.com/weapi/v1/user/detail/" + userId;
        String result = MyHttpClient.post(url, CryptoType.WEAPI);
        return JsonUtil.json2Object(result, UserDetailResp.class);
    }


    /**
     * 查询用户的听歌记录
     *
     * @param userId userId
     * @param type   type=1 时只返回 weekData, type=0 时返回 allData
     * @return
     * @throws Exception
     */
    public static UserRecordResp queryUserRecord(String userId, RecordType type) throws Exception {
        UserRecordRequest recordRequest = UserRecordRequest.builder().type(type.getCode()).uid(userId).build();
        String url = "https://music.163.com/weapi/v1/play/record";
        String result = MyHttpClient.post(url, recordRequest, CryptoType.WEAPI);
        return JsonUtil.json2Object(result, UserRecordResp.class);
    }

    public static void main(String[] args) throws Exception {
        //SearchRequest searchRequest = SearchRequest.builder().s("海阔天空").limit(10).offset(0).type(1).build();
        //Object search = queryUserRecord("454250112", 1);

    }
}
