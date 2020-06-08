package com.move.heart.music.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * @Author: wg
 * @Date: 2020/5/30 12:57 上午
 */
@Slf4j
public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        //配置序列化的输出缩进
        //mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        //如果没有DateFormat，ObjectMapper将会把Date类型序列化为毫秒数
        //mapper.setDateFormat(format);
        //按照map的key的自然排序来产生序列化结果
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        mapper.configure(SerializationFeature.WRITE_SELF_REFERENCES_AS_NULL, false);
        //该属性设置主要是将对象的所有字段全部列入，若有特殊需求，可以进入JsonSerialize.Inclusion该枚举类查看
        //mapper.setSerializationInclusion(JsonSerialize.Inclusion.ALWAYS);

        //该属性设置主要是取消将对象的时间默认转换timesstamps(时间戳)形式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        //该属性设置主要是将忽略空bean转json错误
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //所有日期都统一为以下样式：yyyy-MM-dd HH:mm:ss，这里可以不用我的DateTimeUtil.DATE_FORMAT，手动添加
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    }

    public static <T> String toJson(T t) {
        try {
            return mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(t);
        } catch (JsonProcessingException e) {
            return StringUtils.EMPTY;
        }
    }

    public static <T> T json2Object(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json) || clazz == null) {
            return null;
        }

        try {
            return clazz.equals(String.class) ? (T) json : mapper.readValue(json, clazz);
        } catch (Exception e) {
            log.warn("json To obj is error", e);
            return null;
        }
    }


    /**
     * 通过   TypeReference    处理List<User>这类多泛型问题
     *
     * @param json
     * @param typeReference
     * @param <T>
     * @return
     */
    public static <T> T json2Object(String json, TypeReference typeReference) {
        if (StringUtils.isEmpty(json) || typeReference == null) {
            return null;
        }

        try {
            return (T) (typeReference.getType().equals(String.class) ? json : mapper.readValue(json, typeReference));
        } catch (Exception e) {
            log.warn("json To obj is error", e);
            return null;
        }
    }

    /**
     * 通过jackson 的javatype 来处理多泛型的转换
     *
     * @param json
     * @param collectionClazz
     * @param elements
     * @param <T>
     * @return
     */
    public static <T> T json2Object(String json, Class<?> collectionClazz, Class<?>... elements) {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClazz, elements);

        try {
            return mapper.readValue(json, javaType);
        } catch (Exception e) {
            log.warn("json To obj is error", e);
            return null;
        }
    }

    public static String toJson(Map<String, String> t) {
        try {
            return mapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            return StringUtils.EMPTY;
        }
    }

    public static void main(String[] args) {
        String s = "{\"s\":\"海阔天空\",\"type\":1,\"limit\":30,\"offset\":0,\"csrf_token\":\"\"}";
        byte[] bytes = s.getBytes();
        System.out.println(toJson(Lists.newArrayList(123)));
    }
}
