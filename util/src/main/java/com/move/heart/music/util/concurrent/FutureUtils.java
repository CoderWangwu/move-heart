package com.move.heart.music.util.concurrent;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 使用此工具前 务必确认是否符合自己的业务场景
 * 目前只是想对 future处理做一层异常处理   统一处理好 业务的监控 日志等
 * 1.getResult 不会抛出异常 异常处理 日志监控 业务需要异常的 请不要使用该类 或者自己 改造
 * 2.超时异常 目前不打印日志
 *
 * @Author: wg
 * @Date: 2019/12/17 12:11 下午
 */
@Slf4j
public class FutureUtils {


    public static <T> T getWithDefault(Future<T> future, int milliseSec, T defaults) {
        return getWithDefault(StringUtils.EMPTY, StringUtils.EMPTY, future, milliseSec, defaults);
    }

    /**
     * 不关注业务主体
     *
     * @param future     future
     * @param milliseSec 单位毫秒
     * @param bizName    业务标记
     * @param defaults   异常默认值
     * @param <T>        泛型类型
     * @return 返回值
     */
    public static <T> T getWithDefault(Future<T> future, int milliseSec, String bizName, T defaults) {
        return getWithDefault(bizName, StringUtils.EMPTY, future, milliseSec, defaults);
    }

    /**
     * 默认使用毫秒
     *
     * @param biz
     * @param bizKey
     * @param future
     * @param timeOut
     * @param defaultResult
     * @param <T>
     * @return
     */
    public static <T> T getWithDefault(String biz, String bizKey, Future<T> future, long timeOut, T defaultResult) {
        return getWithDefault(biz, bizKey, future, timeOut, TimeUnit.MILLISECONDS, defaultResult);
    }


    /**
     * 不建议直接用这个 参数太多
     *
     * @param biz           某一个业务类型 方便查看日志以及监控
     * @param bizKey        方便查看异常日志日志
     * @param future        future
     * @param timeOut       超时时间
     * @param timeUnit      单位
     * @param defaultResult 当异常时候 返回一个默认值 这个值不要默认传null
     * @param <T>           结果泛型
     * @return 结果
     */
    private static <T> T getWithDefault(String biz, String bizKey, Future<T> future, long timeOut
            , TimeUnit timeUnit, T defaultResult) {
        try {
            return future.get(timeOut, timeUnit);
        } catch (TimeoutException e) {
            // 超时的异常没有必要打印日志 记录监控就行
            if (StringUtils.isEmpty(biz)) {
//                Monitor.recordErr(biz);
//                Monitor.recordErr(biz + "_time_out");
            }
            return defaultResult;
        } catch (Exception e) {
            // 这个地方 biz/bizKey为空的时候 日志会有点奇怪
            // 但是为了一个日志搞的逻辑复杂 也没啥必要 能满足需求 定位问题 先简单写
            log.error("业务{} 业务对象：{}异步结果获取失败", biz, bizKey, e);
            if (StringUtils.isNotEmpty(biz)) {
//                Monitor.recordErr(biz);
            }
            return defaultResult;
        }
    }
}
