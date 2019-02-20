package utils;

import java.util.Random;

/**
 * Created by supiccc on 2019-02-19 13:57
 * 获取指定长度的随机字符串
 */
public class RandomString {
    private String source = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

    public String generateString(int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = source.charAt((int)(Math.random() * 61));
        }
        return new String(text);
    }
}
