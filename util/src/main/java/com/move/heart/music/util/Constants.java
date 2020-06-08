package com.move.heart.music.util;

import java.util.regex.Pattern;

/**
 * @Author: wg
 * @Date: 2020/5/30 1:11 上午
 */
public class Constants {
    public static final String base62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final String publicKey = "-----BEGIN PUBLIC KEY-----\nMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDgtQn2JZ34ZC28NWYp" +
            "AUd98iZ37BUrX/aKzmFbt7clFSs6sXqHauqKWqdtLkF2KexO40H1YTX8z2lSgBBOAxLsvaklV8k4cBFK9snQXE9/DDaFt6Rr7iVZMldczhC0" +
            "JNgTz+SHXT6CBHuX3e9SdB1Ua44oncaTWz7OBGLbCiK45wIDAQAB\n-----END PUBLIC KEY-----";
    public static final String eapiKey = "e82ckenh8dichen8";
    public static final byte[] iv = "0102030405060708".getBytes();
    public static final byte[] presetKey = "0CoJUm6Qyw8W8jud".getBytes();
    public static final byte[] linuxapiKey = "rFgB&h#%2?^eDg:Q".getBytes();

    public static final Pattern CSRF_PATTERN = Pattern.compile("/_csrf=([^(;|$)]+)/");
}
