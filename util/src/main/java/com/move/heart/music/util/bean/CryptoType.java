package com.move.heart.music.util.bean;

import com.move.heart.music.util.JsonUtil;
import com.move.heart.music.util.crypto.AESEncryptUtil;
import com.move.heart.music.util.crypto.RSAEncryptUtil;
import com.move.heart.music.util.crypto.Random;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;

/**
 * @Author: wg
 * @Date: 2020/5/30 12:40 上午
 */
public enum CryptoType {
    /**
     *
     */
    WEAPI("0CoJUm6Qyw8W8jud") {
        @Override
        public CryptoResult crypto(String url, Object o) throws Exception {
            String json = JsonUtil.toJson(o);
            String encrypt = AESEncryptUtil.encrypt(json, AESEncryptUtil.AesMode.CBC, getSecretKeySpec());
            String secretKey = Random.createSecretKey(16);
            SecretKeySpec aes = new SecretKeySpec(secretKey.getBytes(Charset.defaultCharset()), "AES");
            String encrypt1 = RSAEncryptUtil.encrypt(secretKey);
            String result = AESEncryptUtil.encrypt(encrypt, AESEncryptUtil.AesMode.CBC, aes);
            return CryptoResult.builder()
                    .encSecKey(encrypt1)
                    .params(result)
                    .build();
        }

    },
    LINUX_API("rFgB&h#%2?^eDg:Q") {
        @Override
        public CryptoResult crypto(String url, Object o) throws Exception {
            String json = JsonUtil.toJson(o);
            String result = AESEncryptUtil.encrypt(json, AESEncryptUtil.AesMode.ECB, getSecretKeySpec()).toUpperCase();
            return CryptoResult.builder()
                    .encSecKey("")
                    .params(result)
                    .build();
        }

    },
    EAPI("e82ckenh8dichen8") {
        @Override
        public CryptoResult crypto(String url, Object o) {
            return null;
        }

    };


    private SecretKeySpec secretKeySpec;

    CryptoType(String key) {
        this.secretKeySpec = new SecretKeySpec(key.getBytes(Charset.defaultCharset()), "AES");


    }


    public SecretKeySpec getSecretKeySpec() {
        return secretKeySpec;
    }

    public abstract CryptoResult crypto(String url, Object o) throws Exception;

}
