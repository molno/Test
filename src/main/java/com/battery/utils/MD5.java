package com.battery.utils;

import java.security.MessageDigest;


public class MD5 {

    public static String create(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

//    // 全局数组
//    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
//            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
//
//    private MD5() {
//    }
//
//    // 返回形式为数字跟字符串
//    private static String byteToArrayString(byte bByte) {
//        int iRet = bByte;
//        // System.out.println("iRet="+iRet);
//        if (iRet < 0) {
//            iRet += 256;
//        }
//        int iD1 = iRet / 16;
//        int iD2 = iRet % 16;
//        return strDigits[iD1] + strDigits[iD2];
//    }
//
//    // 返回形式只为数字
//    private static String byteToNum(byte bByte) {
//        int iRet = bByte;
//        System.out.println("iRet1=" + iRet);
//        if (iRet < 0) {
//            iRet += 256;
//        }
//        return String.valueOf(iRet);
//    }
//
//    // 转换字节数组为16进制字串
//    private static String byteToString(byte[] bByte) {
//        StringBuffer sBuffer = new StringBuffer();
//        for (int i = 0; i < bByte.length; i++) {
//            sBuffer.append(byteToArrayString(bByte[i]));
//        }
//        return sBuffer.toString();
//    }
//
//    public static String GetMD5Code(String strObj) {
//        String resultString = null;
//        try {
//            resultString = new String(strObj);
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            // md.digest() 该函数返回值为存放哈希值结果的byte数组
//            resultString = byteToString(md.digest(strObj.getBytes()));
//        } catch (NoSuchAlgorithmException ex) {
//            ex.printStackTrace();
//        }
//        return resultString;
//    }
//
//    public static void main(String[] args) {
//        String s = create("123456");
//        System.out.println(s);
//        StringBuilder sb = new StringBuilder();
//        sb.append("12313213213123b");
//        System.out.println(sb.toString());
//        sb.deleteCharAt(sb.length() - 1);
//        System.out.println(sb.toString());
//    }
}
