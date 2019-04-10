package com.soft1721.jianyue.api.util;
;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by 洋酱 on 2019/4/1.
 */
public class StringUtil {
    /**
     * 日期转字符串
     *
     * @param date
     * @return
     */
    public static String getDateString(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

    /**
     * Base64加密
     *
     * @param srcString
     * @return
     */
    public static String getBase64Encoder(String srcString) {
        String resultStr = "";
        try {
            resultStr = Base64.getEncoder().encodeToString(srcString.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return resultStr;
    }

    /**
     * Base64解码
     *
     * @param srcString
     * @return
     */
    public static String getBase64Decoder(String srcString) {
        byte[] bytes = Base64.getDecoder().decode(srcString);
        return new String(bytes);
    }


    /**
     * 获取UUID字符串
     *
     * @return
     */
    public static String getUUIDString() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取六位随机数短信验证码
     *
     * @return
     */
    public static String getVerifyCode() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(String.valueOf(random.nextInt(10)));
        }
        return stringBuilder.toString();
    }
}