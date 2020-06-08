package com.move.heart.music.util.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang.StringUtils;

/**
 * @Author: wg
 * @Date: 2020/5/30 12:54 上午
 */
@Getter
@Builder
public class CryptoResult {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String params;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String encSecKey;

    public static void main(String[] args) {
        CryptoResult build = CryptoResult.builder().params("123").encSecKey("123").build();
        System.out.println(build.toString());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (StringUtils.isNotEmpty(params)) {
            stringBuilder.append("params=" + params);
        }
        if (StringUtils.isNotEmpty(encSecKey)) {
            stringBuilder.append("&encSecKey=" + encSecKey);
        }
        return stringBuilder.toString();
    }
}
