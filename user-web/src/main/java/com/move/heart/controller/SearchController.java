package com.move.heart.controller;

import com.google.common.collect.Lists;
import com.move.heart.convert.ConvertUtils;
import com.move.heart.music.util.http.UrlUtils;
import com.move.heart.request.SearchRequest;
import com.move.heart.response.UserDetailView;
import com.move.heart.response.UserSearchResponse;
import com.move.heart.service.SearchService;
import com.move.heart.service.bean.UserInfo;
import org.apache.commons.collections.MapUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: wg
 * @Date: 2020/6/6 10:36 下午
 * 查询信息接口
 */
@RestController("/query")
public class SearchController {

    @Resource
    private SearchService searchService;

    @RequestMapping("/search")
    private UserSearchResponse search(SearchRequest searchRequest) {
        if (searchRequest.getType() == 0) {
            List<UserInfo> userInfos = Lists.newArrayList();
            String query = searchRequest.getQuery();
            if (UrlUtils.isURL(query)) {
                Map<String, String> params = UrlUtils.urlSplit(query);
                if (MapUtils.isEmpty(params) || StringUtils.isEmpty(params.get("userid"))) {
                    //
                    return null;
                }
                searchService.searchById(params.get("userid"))
                        .ifPresent(userInfos::add);
            } else {
                userInfos.addAll(searchService.searchByNickName(query, searchRequest.getStart()
                        , searchRequest.getLimit()));
            }
            List<UserDetailView> convert = ConvertUtils.convert(userInfos);
            return UserSearchResponse.builder()
                    .result(convert)
                    .type(0)
                    .build();

        }
        //TODO 未完待续 song
        return null;
    }
}
