package com.move.heart.service.bean;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: wg
 * @Date: 2020/6/7 10:05 下午
 */
public enum Gender {
    UN_KNOW(0),
    /**
     * 男性
     */
    MALE(1),

    /**
     * 女性
     */
    FEMAEL(2);


    private final int code;

    /**
     * codeMap
     */
    private static final Map<Integer, Gender> CODE_MAP = Stream.of(Gender.values())
            .collect(Collectors.toMap(Gender::getCode, o -> o));

    Gender(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Gender codeOf(int code) {
        return CODE_MAP.getOrDefault(code, UN_KNOW);
    }
}
