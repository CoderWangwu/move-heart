package com.move.heart.music.util.crypto;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * @Author: wg
 * @Date: 2020/6/1 10:55 下午
 */
public class AESEncryptUtil {


    /**
     * 向量iv
     */
    public static final String IV = "0102030405060708";


    /**
     * 使用CBC模式，需要一个向量iv，可增加加密算法的强度
     */
    private static final IvParameterSpec IPS = new IvParameterSpec(IV.getBytes());

    private static final BASE64Decoder base64Decoder = new BASE64Decoder();
    private static final BASE64Encoder base64Encoder = new BASE64Encoder();

    static {
        Security.addProvider(new BouncyCastleProvider());
    }


    public enum AesMode {
        /**
         * cbc 加密模式
         */
        CBC {
            @Override
            public Cipher getCipher(SecretKeySpec secretKeySpec) throws Exception {
                //"算法/模式/补码方式"
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, IPS);
                return cipher;
            }
        },
        ECB {
            @Override
            public Cipher getCipher(SecretKeySpec secretKeySpec) throws Exception {
                //"算法/模式/补码方式"
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
                return cipher;
            }
        };

        public abstract Cipher getCipher(SecretKeySpec secretKeySpec) throws Exception;
    }


    public static String encrypt(String content, AesMode aesMode, SecretKeySpec secretKeySpec) throws Exception {
        byte[] encrypted = aesMode.getCipher(secretKeySpec).doFinal(content.getBytes());
        return base64Encoder.encode(encrypted);
    }


    public static String decrypt(String content, AesMode aesMode, SecretKeySpec secretKeySpec) throws Exception {
        try {

            byte[] encrypted1 = base64Decoder.decodeBuffer(content);
            try {
                byte[] original = aesMode.getCipher(secretKeySpec).doFinal(encrypted1);
                return new String(original);
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
