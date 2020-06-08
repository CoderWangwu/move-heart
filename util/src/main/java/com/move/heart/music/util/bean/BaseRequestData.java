package com.move.heart.music.util.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * @Author: wg
 * @Date: 2020/6/2 11:32 下午
 */
@Data
@NoArgsConstructor
public class BaseRequestData {

    public static BaseRequestData getEmptyInstance() {
        return EMPTY_INSTANCE;
    }

    private static final BaseRequestData EMPTY_INSTANCE = new BaseRequestData();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String csrf_token = StringUtils.EMPTY;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> header;

}
