package com.move.heart.service.bean;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: wg
 * @Date: 2020/6/10 11:09 上午
 */
public enum SourceType {
    /**
     * 网易
     */
    NET_EASE(0);


    private final int code;

    /**
     * codeMap
     */
    private static final Map<Integer, SourceType> CODE_MAP = Stream.of(SourceType.values())
            .collect(Collectors.toMap(SourceType::getCode, o -> o));

    SourceType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static SourceType codeOf(int code) {
        return CODE_MAP.getOrDefault(code, null);
    }
}
