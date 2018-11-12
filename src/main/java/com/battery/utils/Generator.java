package com.battery.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by kuyun on 2017/10/15.
 */
public class Generator {

    /**
     * 生成唯一的保存到磁盘上的文件名
     * @return
     */
    public static String generateUniqueName(){
        String fileName = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        fileName = sdf.format(new Date());

        Random r = new Random();
        for(int i=0; i<3; i++){
            fileName += r.nextInt(10);
        }

        return fileName;

    }

    public static String generateOrderCode(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String OrderCode = sdf.format(new Date());

        Random r = new Random();
        for(int i=0; i<5; i++){
            OrderCode += r.nextInt(10);
        }
        return OrderCode;
    }

//    public static void main(String args[]){
//        for(int i = 0;i<100; i++) {
//            System.out.println(generateOrderCode());
//        }
//    }
}