package com.battery.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ellen on 2018/11/1.
 */
public class DateConvert implements Converter<String, Date> {


    public Date convert(String stringDate) {
        if(stringDate == null){
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(stringDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
