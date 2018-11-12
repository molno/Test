package com.battery.utils;

import java.util.Random;
import java.util.UUID;

/**
 * 生成随机数
 *
 * @author ellen
 * @version 1.0
 * @date 2018/9/26 16:26
 */
public class RandomUtil {

    private static Random random = new Random();
    // 生成随机数的默认位数
    private static final long BITS = 6;

    //用于产生微信支付随机数
    private static final String RANDOM_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Random RANDOM = new Random();

    /*
     * 生成uuid
     */
    public static String makeUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13)
                + str.substring(14, 18) + str.substring(19, 23)
                + str.substring(24);
        return temp.toUpperCase();
    }

    /*
     * 生成(获得)RandomUtil。BITS位随机数串
     */
    public static String makeRandomDigit() {
        return getNBitRandomDigit(BITS);
    }

    /**
     * 生成(获得)n位随机数串
     *
     * @param n 生成随机数串的位数
     * @return 返回生成的 n为数字串
     */
    public static String getNBitRandomDigit(long n) {
        if (n < 1) { // 若 n小于 1，则设置为生成随机数的默认位数
            n = BITS;
        }
        // 存储中间生成的数串
        StringBuffer randomDigitStr = new StringBuffer();
        // 生成的随机数
        long randomDigit;

        if (n < 18) {
            // 生成 n位随机数（-0.5避免生成的前 n均为 9最终四舍五入时（可能）超出一位数字）
            randomDigit = Math
                    .round((random.nextDouble() * Math.pow(10, n)) - 0.5);
            randomDigitStr.append(randomDigit);
        } else {
            // n超过 18，则通过生成多个 18位随机数连接成更长串
            for (int i = 0; i < Math.floor(n / 18); ++i) {
                // 生成 18位随机数（long最长为 19位且非所有位均为 9，所以取 18位）
                randomDigit = Math.round((random.nextDouble() * Math
                        .pow(10, 18)) - 0.5);
                randomDigitStr.append(randomDigit);
            }
        }
        // 生成的随机数串位数
        int randomDigitStrLength = randomDigitStr.length();

        // 生成的随机数串位不足但是也不达 18位时，循环随机插入随机生成的[0, 9]间任意一位数
        if (randomDigitStrLength < n) {
            for (int i = 0; i < n - randomDigitStrLength; ++i) {
                // 生成可插入的下标位置（若位置为 randomDigitStr.length()，则是在末尾添加）
                int offset = random.nextInt(randomDigitStr.length() + 1);
                if (offset < randomDigitStr.length()) {
                    // 在 offset位置（下标）插入随机生成的[0, 9]间一位数
                    randomDigitStr.insert(offset, random.nextInt(10));
                } else {
                    // 在数串末尾添加[0, 9]间一位数
                    randomDigitStr.append(random.nextInt(10));
                }
            }
        }
        return randomDigitStr.toString();
    }

    /**
     * 微信支付-获取16位随机字符串
     *
     * @return
     */
    public static String getRandomStr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(RANDOM_STR.charAt(RANDOM.nextInt(RANDOM_STR.length())));
        }
        return sb.toString();
    }

    public static void main(String[] s) {
        System.out.println(makeUUID());
    }
}
