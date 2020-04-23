package com.cqy.util;

//import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;

/**
 * Created by goumin on 2019/10/24.
 */

public class Md5 {
    /**
     * 利用MD5进行加密
     */
    public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        Encoder base64en = Base64.getEncoder();
        //加密后的字符串
        String newStr = base64en.encodeToString(md5.digest(str.getBytes("utf-8")));
        return newStr;
    }
}
