package com.move.heart.music.util.netease;

import com.move.heart.music.util.JsonUtil;
import com.move.heart.music.util.bean.CryptoType;
import com.move.heart.music.util.http.MyHttpClient;
import com.move.heart.music.util.netease.bean.SearchRequest;
import com.move.heart.music.util.netease.bean.UserDetailResp;
import com.move.heart.music.util.netease.bean.UserDetailResponseByNick;


/**
 * @Author: wg
 * @Date: 2020/5/29 11:45 下午
 */
public class NeteaseMusicUtils {


    public static String search(SearchRequest searchRequest) throws Exception {
        return MyHttpClient.post("https://music.163.com/weapi/search/get", searchRequest, CryptoType.WEAPI);

    }

    public static UserDetailResponseByNick searchByNickName(String nickName, int start, int limit) throws Exception {
        SearchRequest searchRequest = SearchRequest.builder().type(1002).offset(start).limit(limit).s(nickName).build();
        String post = MyHttpClient.post("https://music.163.com/weapi/search/get", searchRequest, CryptoType.WEAPI);
        return JsonUtil.json2Object(post, UserDetailResponseByNick.class);

    }

    public static UserDetailResp queryUser(String userId) throws Exception {
        String url = "https://music.163.com/weapi/v1/user/detail/" + userId;
        String result = MyHttpClient.post(url, CryptoType.WEAPI);
        return JsonUtil.json2Object(result, UserDetailResp.class);
    }

    public static void main(String[] args) throws Exception {
        SearchRequest searchRequest = SearchRequest.builder().s("海阔天空").limit(10).offset(0).type(1).build();
        Object search = search(searchRequest);

    }
}
