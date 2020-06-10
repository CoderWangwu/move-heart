package com.move.heart.music.util.http;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.move.heart.music.util.bean.BaseRequestData;
import com.move.heart.music.util.bean.CryptoResult;
import com.move.heart.music.util.bean.CryptoType;
import com.move.heart.music.util.bean.Temp;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.move.heart.music.util.Constants.CSRF_PATTERN;

/**
 * @Author: wg
 * @Date: 2020/5/30 12:01 上午
 */
public class MyHttpClient {

    private static final Pattern WAPI = Pattern.compile("\\w*api");
    private static final String[] USER_AGENT_LIST = {
            "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1",
            "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1",
            "Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36",
            "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36",
            "Mozilla/5.0 (Linux; Android 5.1.1; Nexus 6 Build/LYZ28E) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36",
            "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_2 like Mac OS X) AppleWebKit/603.2.4 (KHTML, like Gecko) Mobile/14F89;GameHelper",
            "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1",
            "Mozilla/5.0 (iPad; CPU OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:46.0) Gecko/20100101 Firefox/46.0",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/603.2.4 (KHTML, like Gecko) Version/10.1.1 Safari/603.2.4",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:46.0) Gecko/20100101 Firefox/46.0",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36 Edge/13.10586"
    };

    public enum UserAgentType {
        /**
         * 移动端
         */
        MOBILE {
            @Override
            public int getIndex() {
                return (int) Math.floor(Math.random() * 7);
            }
        },
        PC {
            @Override
            public int getIndex() {
                return (int) Math.floor(Math.random() * 5) + 8;
            }
        },
        DEFAULT {
            @Override
            public int getIndex() {
                return (int) Math.floor(Math.random() * USER_AGENT_LIST.length);
            }
        };


        public abstract int getIndex();
    }


    private static String getUserAgent(UserAgentType ua) {
        return USER_AGENT_LIST[ua.getIndex()];
    }

    public static String post(String url, BaseRequestData requestData, CryptoType cryptoType) throws Exception {
        return post(url, requestData, cryptoType, UserAgentType.DEFAULT, Collections.emptyMap());
    }

    public static String post(String url, CryptoType cryptoType) throws Exception {
        return post(url, BaseRequestData.getEmptyInstance(), cryptoType, UserAgentType.DEFAULT, Collections.emptyMap());
    }

    public static String post(String url, BaseRequestData requestData, CryptoType cryptoType, UserAgentType ua, Map<String, String> cookie) throws Exception {
        Map<String, String> heads = Maps.newHashMap();
        heads.put("User-Agent", getUserAgent(ua));
        heads.put("Referer", StringUtils.contains(url, "music.163.com") ? "https://music.163.com" : "");
        heads.put("Cookie", encodeCookie(cookie));
        CryptoResult data = null;
        if (CryptoType.WEAPI.equals(cryptoType)) {
            Matcher csrf = CSRF_PATTERN.matcher(heads.getOrDefault("Cookie", ""));
            if (csrf.find()) {
                requestData.setCsrf_token(csrf.group());
            }
            data = CryptoType.WEAPI.crypto("", requestData);
            Matcher matcher = WAPI.matcher(url);
            url = matcher.replaceAll("weapi");
        } else if (CryptoType.LINUX_API.equals(cryptoType)) {
            Matcher matcher = WAPI.matcher(url);
            Temp api = Temp.builder().method("POST").params(requestData).url(matcher.replaceAll("api")).build();
            data = CryptoType.LINUX_API.crypto("", api);
            heads.put("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36");
            url = "https://music.163.com/api/linux/forward";
        } else if (CryptoType.EAPI.equals(cryptoType)) {
            Map<String, String> head = Maps.newHashMap();
            head.put("osver", cookie.get("osver"));
            head.put("deviceId", cookie.get("deviceId"));
            head.put("appver", cookie.getOrDefault("appver", "6.1.1"));
            head.put("versioncode", cookie.getOrDefault("versioncode", "140"));
            head.put("mobilename", cookie.get("mobilename"));
            head.put("uildverb", cookie.getOrDefault("uildverb", String.valueOf((int) System.currentTimeMillis() / 1000)));
            head.put("resolution", cookie.getOrDefault("resolution", "1920x1080"));
            head.put("__csrf", cookie.getOrDefault("__csrf", ""));
            head.put("os", cookie.getOrDefault("os", "android"));
            head.put("channel", cookie.get("channel"));
            head.put("requestId", cookie.get("osver"));
            //if (cookie.MUSIC_U) header["MUSIC_U"] = cookie.MUSIC_U
            //            if (cookie.MUSIC_A) header["MUSIC_A"] = cookie.MUSIC_A
            requestData.setHeader(head);
            data = CryptoType.EAPI.crypto(url, requestData);
            Matcher matcher = WAPI.matcher(url);
            url = matcher.replaceAll("eapi");
        }
        // 上线需要代理
        //if (/\.pac$/i.test(options.proxy)) {
        //            settings.agent = new PacProxyAgent(options.proxy)
        //        } else {
        //            settings.proxy = options.proxy
        //        }

        Connection connection = Jsoup
                .connect(url)
                .ignoreContentType(true)
                .method(Connection.Method.POST)
                //.header("Referer", "https://music.163.com")
                .data(ImmutableMap.of("params", data.getParams(), "encSecKey", data.getEncSecKey()));
        heads.forEach(connection::header);
        Connection.Response response = connection.execute();
        return response.body();


    }

    private static String encodeCookie(Map<String, String> cookie) {
        return "";
    }
}
