package com.move.heart.music.util.netease.request;

import com.move.heart.music.util.bean.BaseRequestData;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: wg
 * @Date: 2020/6/9 10:08 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class UserRecordRequest extends BaseRequestData {
    private String uid;
    private int type;
}
