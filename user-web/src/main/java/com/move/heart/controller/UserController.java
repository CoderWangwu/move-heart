package com.move.heart.controller;

import com.move.heart.convert.ConvertUtils;
import com.move.heart.request.ConcernRequest;
import com.move.heart.service.UserConcernService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wg
 * @Date: 2020/6/6 9:16 下午
 */
@RestController("/user")
public class UserController {


    private UserConcernService userConcernService;

    /**
     * 关注用户 userId/userName
     *
     * @param concernRequest u
     */
    @RequestMapping("/concern")
    public void concern(@RequestBody ConcernRequest concernRequest) {
        // step 1. 参数校验
        userConcernService.concern(ConvertUtils.convert(concernRequest), concernRequest.getCurrentUser());
    }

    /**
     * 查询用户听歌记录
     * @param userMusicRecord
     */
//    @RequestMapping("/concern")
//    public void concern(@RequestBody UserMusicRecord userMusicRecord) {
//        // step 1. 参数校验
//        userConcernService.concern(ConvertUtils.convert(concernRequest), concernRequest.getCurrentUser());
//    }

}
