package com.move.heart.music.util.crypto;

/**
 * @Author: wg
 * @Date: 2020/6/2 12:54 上午
 */
public class Random {

    public static String createSecretKey(int size) {
        String keys = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < size; i++) {
            double pos = Math.random() * keys.length();

            int index = (int) Math.floor(pos);
            key.append(keys.charAt(index));
        }
        return key.toString();
    }
}
