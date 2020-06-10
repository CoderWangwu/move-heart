package com.move.heart.music.util.netease;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: wg
 * @Date: 2020/6/10 11:15 上午
 */
public enum RecordType {
    /**
     * 用户历史听歌记录
     */
    ALL(0),

    /**
     * 用户当前听歌记录
     */
    RENCENT_WEEK(1);


    private final int code;

    /**
     * codeMap
     */
    private static final Map<Integer, RecordType> CODE_MAP = Stream.of(RecordType.values())
            .collect(Collectors.toMap(RecordType::getCode, o -> o));

    RecordType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static RecordType codeOf(int code) {
        return CODE_MAP.getOrDefault(code, null);
    }
}
